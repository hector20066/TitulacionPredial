package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.PropertyPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación del DAO para la gestión de predios
 * en la base de datos PostgreSQL.
 *
 * <p>
 * Utiliza el patrón Singleton para garantizar una única instancia.
 * Maneja relaciones complejas entre predios, beneficiarios y
 * puntos geográficos mediante consultas con JOIN.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOProperty
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOPropertyImpl implements DAOProperty {

    /**
     * Instancia única del DAO (patrón Singleton).
     */
    private static DAOPropertyImpl instance;

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Constructor privado para garantizar el patrón Singleton.
     */
    private DAOPropertyImpl() {

    }

    /**
     * Obtiene la instancia única del DAO.
     *
     * @return instancia Singleton de {@code DAOPropertyImpl}
     */
    public static DAOPropertyImpl getInstance() {
        if (instance == null) {
            instance = new DAOPropertyImpl();
        }

        return instance;
    }

    @Override
    public int add(DTOPropertyCreate dto) throws DAOException {
        String sql = SQLRepository.get("sql/property/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, dto.getCadastralId());
            st.setDouble(2, dto.getArea());

            int affectedRows = st.executeUpdate();

            if (affectedRows == 0) {
                throw new PropertyNotFoundException(lang.message("not.found.property.rows"));
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new PropertyNotFoundException(lang.message("not.found.property.id"));
                }
            }
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.register"), e);
        }
    }

    @Override
    public DTOPropertyDetails findByCode(String cadastralId) throws DAOException {
        String sql = SQLRepository.get("sql/property/findByCode.sql");
        Map<Integer, DTOPropertyDetails> properties = new LinkedHashMap<>();

        try (Connection conn = DataBasePool.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cadastralId);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    processRow(rs, properties);
                }
            }

            return properties.values().stream().findFirst().orElse(null);
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.info.id") + " " + cadastralId, e);
        }
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws DAOException {
        String sql = SQLRepository.get("sql/property/findByAll.sql");
        return getDtoPropertyDetails(sql);
    }

    @Override
    public List<DTOPropertyDetails> findByAllForExport() throws DAOException {
        String sql = SQLRepository.get("sql/property/findByAllExport.sql");
        return getDtoPropertyDetails(sql);
    }

    /**
     * Ejecuta una consulta SQL que retorna una lista de predios
     * con sus beneficiarios y puntos geográficos.
     *
     * <p>
     * Procesa cada fila del {@link ResultSet} agrupando
     * la información por código de predio mediante un {@link LinkedHashMap}.
     * </p>
     *
     * @param sql consulta SQL a ejecutar
     * @return lista de DTOs de predios con sus relaciones
     * @throws PropertyPersistenceException si ocurre un error en la consulta
     */
    private List<DTOPropertyDetails> getDtoPropertyDetails(String sql) throws PropertyPersistenceException {
        Map<Integer, DTOPropertyDetails> properties = new LinkedHashMap<>();

        try (Connection conn = DataBasePool.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                processRow(rs, properties);
            }

            return new ArrayList<>(properties.values());
        } catch (SQLException e) {
            throw new PropertyPersistenceException(
                    lang.message("persistence.property.info.all"), e);
        }
    }

    /**
     * Procesa una fila del {@link ResultSet} y la agrupa
     * dentro del mapa de predios.
     *
     * <p>
     * Si el predio aún no existe en el mapa, lo crea.
     * Luego añade los beneficiarios y puntos que no se hayan
     * registrado previamente, evitando duplicados producidos
     * por los JOINs.
     * </p>
     *
     * @param rs         fila actual del resultado de la consulta
     * @param properties mapa de predios indexado por código
     * @throws SQLException si ocurre un error al leer los datos
     */
    private void processRow(ResultSet rs, Map<Integer, DTOPropertyDetails> properties) throws SQLException {
        int propertyCode = rs.getInt("property_code");

        DTOPropertyDetails property = properties.get(propertyCode);

        if (property == null) {
            property = createDTOPropertyDetails(rs);
            properties.put(propertyCode, property);
        }

        addBeneficiaryIfNecessary(rs, property);
        addPointIfNecessary(rs, property, propertyCode);
    }

    /**
     * Añade un beneficiario al predio si aún no ha sido registrado.
     *
     * @param rs       fila actual del resultado de la consulta
     * @param property DTO del predio al que se añadirá el beneficiario
     * @throws SQLException si ocurre un error al leer los datos
     */
    private void addBeneficiaryIfNecessary(ResultSet rs, DTOPropertyDetails property) throws SQLException {
        Integer beneficiaryCode = rs.getObject("beneficiary_code", Integer.class);

        if (beneficiaryCode != null && !verifyBeneficiaryExist(property, beneficiaryCode)) {
            DTOBeneficiaryPropertyDetails beneficiary =
                    createDtoBeneficiaryPropertyDetails(rs, beneficiaryCode);

            property.getBeneficiaries().add(beneficiary);
        }
    }

    /**
     * Añade un punto geográfico al predio si aún no ha sido registrado.
     *
     * @param rs           fila actual del resultado de la consulta
     * @param property     DTO del predio al que se añadirá el punto
     * @param propertyCode código del predio
     * @throws SQLException si ocurre un error al leer los datos
     */
    private void addPointIfNecessary(ResultSet rs, DTOPropertyDetails property, int propertyCode) throws SQLException {
        int numberPoint = rs.getInt("number");

        if (!verifyPointExists(property, numberPoint)) {
            DTOPoint point = createDTOPoints(rs, numberPoint, propertyCode);
            property.getPoints().add(point);
        }
    }

    /**
     * Crea un objeto {@link DTOPropertyDetails} a partir de la fila
     * actual del {@link ResultSet}.
     *
     * <p>
     * Gestiona los valores nulos de los campos de resolución,
     * notificación, ejecutoria, FMI, acta, escritura pública
     * y notaría.
     * </p>
     *
     * @param rs fila actual del resultado de la consulta
     * @return DTO con los datos del predio
     * @throws SQLException si ocurre un error al leer los datos
     */
    private DTOPropertyDetails createDTOPropertyDetails(ResultSet rs) throws SQLException {
        DTOPropertyDetails property = new DTOPropertyDetails();

        property.setPropertyCode(rs.getInt("property_code"));
        property.setCadastralId(rs.getString("cadastral_id"));
        property.setArea(rs.getDouble("area"));

        long numResolution = rs.getLong("num_resolution");
        property.setNumResolution(rs.wasNull() ? 0 : numResolution);

        Date notification = rs.getDate("notification");
        property.setNotification(notification != null ? notification.toLocalDate() : null);

        Date executory = rs.getDate("executory");
        property.setExecutory(executory != null ? executory.toLocalDate() : null);

        property.setFmi(rs.getString("fmi"));
        property.setAct(rs.getString("act"));
        property.setPublicWriting(rs.getString("public_writing"));
        property.setNotary(rs.getString("notary"));

        return property;
    }

    /**
     * Crea un objeto {@link DTOBeneficiaryPropertyDetails}
     * a partir de la fila actual del {@link ResultSet}.
     *
     * @param rs              fila actual del resultado de la consulta
     * @param beneficiaryCode código del beneficiario
     * @return DTO con los datos del beneficiario asociado al predio
     * @throws SQLException si ocurre un error al leer los datos
     */
    private DTOBeneficiaryPropertyDetails createDtoBeneficiaryPropertyDetails(ResultSet rs, int beneficiaryCode) throws SQLException {
        String municipalityStr = rs.getString("beneficiary_municipality");
        Municipalities municipality = null;

        if (municipalityStr != null) {
            municipality = Municipalities.valueOf(municipalityStr);
        }

        return new DTOBeneficiaryPropertyDetails(
                rs.getString("beneficiary_fullname"),
                beneficiaryCode,
                municipality,
                rs.getString("beneficiary_address")
        );
    }

    /**
     * Verifica si un beneficiario ya fue agregado al predio.
     *
     * @param property        DTO del predio a verificar
     * @param beneficiaryCode código del beneficiario a buscar
     * @return {@code true} si el beneficiario ya existe en la lista
     */
    private boolean verifyBeneficiaryExist(DTOPropertyDetails property, int beneficiaryCode) {
        return property.getBeneficiaries()
                .stream()
                .anyMatch(b -> b.getId() == beneficiaryCode);
    }

    /**
     * Verifica si un punto geográfico ya fue agregado al predio.
     *
     * @param property    DTO del predio a verificar
     * @param numberPoint número del punto a buscar
     * @return {@code true} si el punto ya existe en la lista
     */
    private boolean verifyPointExists(DTOPropertyDetails property, int numberPoint) {
        return property.getPoints()
                .stream()
                .anyMatch(p -> p.getNumberPoint() == numberPoint);
    }

    /**
     * Crea un objeto {@link DTOPoint} mediante su Builder
     * a partir de la fila actual del {@link ResultSet}.
     *
     * @param rs           fila actual del resultado de la consulta
     * @param numberPoint  número del punto
     * @param propertyCode código del predio al que pertenece el punto
     * @return DTO con los datos del punto geográfico
     * @throws SQLException si ocurre un error al leer los datos
     */
    private DTOPoint createDTOPoints(ResultSet rs, int numberPoint, int propertyCode) throws SQLException {
        return new DTOPoint.Builder()
                .numberPoint(numberPoint)
                .northCoordinate(rs.getDouble("north_coordinate"))
                .eastCoordinate(rs.getDouble("east_coordinate"))
                .distance(rs.getDouble("distance"))
                .hillside(rs.getString("hillside"))
                .propertyCode(propertyCode)
                .build();
    }

    @Override
    public void delete(int code) throws DAOException {
        String sql = SQLRepository.get("sql/property/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            if (st.executeUpdate() == 0) {
                throw new PropertyNotFoundException(String.valueOf(code));
            }
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.info.code") + " " + code, e);
        }
    }

    @Override
    public int countRecords() throws DAOException {
        String sql = SQLRepository.get("sql/property/countRecords.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new PropertyNotFoundException(lang.message("not.found.count"));
            }

            return rs.getInt("total_records");
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.info.all"), e);
        }
    }

    @Override
    public int percentPropertiesWithResolutions() throws DAOException {
        String sql = SQLRepository.get("sql/property/percentPropertiesWithResolution.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new PropertyNotFoundException(lang.message("property.not.found"));
            }

            return rs.getInt("percent");
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.info.all"), e);
        }
    }

    @Override
    public int countPropertyWithResolution() throws DAOException {
        String sql = SQLRepository.get("sql/property/countPropertiesWithResolution.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new PropertyNotFoundException(lang.message("property.not.found"));
            }

            return rs.getInt("properties_with_resolution");
        } catch (SQLException e) {
            throw new PropertyPersistenceException(lang.message("persistence.property.info.all"), e);
        }
    }

}
