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
import com.hector.titulacionpredial.model.dto.property.DTOPropertyUpdate;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the DAO for property management in the MySQL database.
 *
 * <p>
 * It uses the Singleton pattern to ensure a single instance. It handles
 * complex relationships between properties, beneficiaries, and geographic
 * points using JOIN queries.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOProperty
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOPropertyImpl implements DAOProperty {

    private static final LanguageManager lang = LanguageManager.getInstance();
    private static DAOPropertyImpl instance;

    /**
     * Private builder to guarantee the Singleton pattern.
     */
    private DAOPropertyImpl() {

    }

    /**
     * Obtain the single instance of the DAO.
     *
     * @return Singleton instance of {@code DAOPropertyImpl}
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
            st.setString(2, String.valueOf(dto.getDepartment()));
            st.setString(3, String.valueOf(dto.getMunicipality()));
            st.setString(4, dto.getNeighborhood());
            st.setString(5, dto.getAddress());
            st.setString(6, dto.getCrossing());
            st.setString(7, dto.getPublication());

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
     * Execute an SQL query that returns a list of properties with their
     * beneficiaries and geographic points.
     *
     * <p>
     * Process each row of the {@link ResultSet} by grouping the information
     * by property code using a {@link LinkedHashMap}.
     * </p>
     *
     * @param sql SQL query to execute
     * @return List of property data and their relationships
     * @throws PropertyPersistenceException if an error occurs in the query
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
     * Process a row from the {@link ResultSet} and group it
     * within the property map.
     *
     * <p>
     * If the property does not already exist on the map, it creates it.
     * Then it adds the beneficiaries and points that have not been previously
     * registered, avoiding duplicates produced by JOINs.
     * </p>
     *
     * @param rs         current row of the query result
     * @param properties map of properties indexed by code
     * @throws SQLException if an error occurs while reading the data
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
     * Add a beneficiary to the property if it has not already been registered.
     *
     * @param rs       current row of the query result
     * @param property DTO of the property to which the beneficiary will be added
     * @throws SQLException if an error occurs while reading the data
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
     * Add a geographic point to the property if it has not yet been registered.
     *
     * @param rs           current row of the query result
     * @param property     DTO of the property to which the point will be added
     * @param propertyCode property code
     * @throws SQLException if an error occurs while reading the data
     */
    private void addPointIfNecessary(ResultSet rs, DTOPropertyDetails property, int propertyCode) throws SQLException {
        int numberPoint = rs.getInt("number");

        if (!verifyPointExists(property, numberPoint)) {
            DTOPoint point = createDTOPoints(rs, numberPoint, propertyCode);
            property.getPoints().add(point);
        }
    }

    /**
     * Creates a {@link DTOPropertyDetails} object from the current
     * row of the {@link ResultSet}.
     *
     * <p>
     * Manages null values in the fields of resolution, notification,
     * execution, FMI, act, public deed and notary.
     * </p>
     *
     * @param rs current row of the query result
     * @return DTO with the property data
     * @throws SQLException if an error occurs while reading the data
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
     * Create a {@link DTOBeneficiaryPropertyDetails} object from the
     * current row of the {@link ResultSet}.
     *
     * @param rs              current row of the query result
     * @param beneficiaryCode beneficiary code
     * @return DTO with the beneficiary's data associated with the property
     * @throws SQLException if an error occurs while reading the data
     */
    private DTOBeneficiaryPropertyDetails createDtoBeneficiaryPropertyDetails(ResultSet rs, int beneficiaryCode) throws SQLException {
        String municipalityStr = rs.getString("beneficiary_municipality");
        Municipalities municipality = null;

        if (municipalityStr != null) {
            municipality = Municipalities.valueOf(municipalityStr);
        }

        /*return new DTOBeneficiaryPropertyDetails(
                rs.getString("beneficiary_fullname"),
                beneficiaryCode,
                municipalityStr,
                rs.getString("beneficiary_address")
        );*/
        return null;
    }

    /**
     * Check if a beneficiary has already been added to the property.
     *
     * @param property        DTO of the property to be verified
     * @param beneficiaryCode beneficiary code to search
     * @return {@code true} if the beneficiary already exists on the list
     */
    private boolean verifyBeneficiaryExist(DTOPropertyDetails property, int beneficiaryCode) {
        return property.getBeneficiaries()
                .stream()
                .anyMatch(b -> b.getId() == beneficiaryCode);
    }

    /**
     * Check if a geographic point has already been added to the property.
     *
     * @param property    DTO of the property to be verified
     * @param numberPoint number of the point to look for
     * @return {@code true} if the point already exists in the list
     */
    private boolean verifyPointExists(DTOPropertyDetails property, int numberPoint) {
        return property.getPoints()
                .stream()
                .anyMatch(p -> p.getNumberPoint() == numberPoint);
    }

    /**
     * Create a {@link DTOPoint} object using its Builder from the current
     * row of the {@link ResultSet}.
     *
     * @param rs           current row of the query result
     * @param numberPoint  point number
     * @param propertyCode property code to which the point belongs
     * @return DTO with the data of the geographic point
     * @throws SQLException if an error occurs while reading the data
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

    public boolean modify(DTOPropertyUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/property/modify.sql");

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            st.setDouble(1, dto.getArea());
            st.setString(2, dto.getCadastralRef());

            if (st.executeUpdate() == 0) {
                throw new PropertyNotFoundException();
            }

            return true;
        } catch (SQLException e) {
            throw new PropertyPersistenceException("No se encontro");
        }
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
