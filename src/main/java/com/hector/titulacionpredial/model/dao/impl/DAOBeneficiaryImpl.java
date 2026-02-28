package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.BeneficiaryPersistenceException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.*;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para la gestión de beneficiarios
 * en la base de datos PostgreSQL.
 *
 * <p>
 * Utiliza el patrón Singleton para garantizar una única instancia.
 * Las consultas SQL se obtienen desde {@link SQLRepository} y la
 * conexión a la base de datos mediante {@link DataBasePool}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBeneficiary
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOBeneficiaryImpl implements DAOBeneficiary {

    /**
     * Instancia única del DAO (patrón Singleton).
     */
    private static DAOBeneficiaryImpl instance;

    /**
     * Constructor privado para garantizar el patrón Singleton.
     */
    private DAOBeneficiaryImpl() {

    }

    /**
     * Obtiene la instancia única del DAO.
     *
     * @return instancia Singleton de {@code DAOBeneficiaryImpl}
     */
    public static DAOBeneficiaryImpl getInstance() {
        if (instance == null) {
            instance = new DAOBeneficiaryImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOBeneficiaryCreate dto) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            statementDetails(st, dto);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No fue posible guardar la información del beneficiario", e);
        }
    }

    /**
     * Preparar objeto PrepateStatement con los datos de la transaccion.
     *
     * @param st  objeto PrepareStatement
     * @param dto objeto DTO con datos del beneficiario
     * @throws SQLException si ocurre una excepcion al realizar
     *                      la operacion.
     */
    private void statementDetails(PreparedStatement st, DTOBeneficiaryCreate dto) throws SQLException {
        st.setLong(1, dto.getId());
        st.setString(2, dto.getFullName());
        st.setString(3, String.valueOf(dto.getDepartment()));
        st.setString(4, String.valueOf(dto.getMunicipality()));
        st.setString(5, dto.getAddress());
        st.setString(6, dto.getCadastralReference());
        st.setString(7, String.valueOf(dto.getMaritalStatus()));
        st.setString(8, dto.getAffectation());
        st.setLong(9, dto.getPhone());
        st.setString(10, dto.getCrossing());
        st.setString(11, dto.getPublication());
        st.setString(12, dto.getNeighborhood());
        st.setString(13, dto.getExpeditionLocation());
        st.setDate(14, Date.valueOf(LocalDate.now()));
    }

    @Override
    public DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            return executeResultSet(st);
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información del beneficiario con código: " + code, e);
        }
    }

    @Override
    public DTOBeneficiarySimpleDetails findById(long id) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findById.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, id);

            return executeResultSet(st);
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información del beneficiario con cedula: " + id, e);
        }
    }

    @Override
    public DTOBeneficiarySimpleDetails findByName(String name) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findByName.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, name);

            return executeResultSet(st);
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información del beneficiario con nombre: " + name, e);
        }
    }

    /**
     * Obtener datos de la consulta a traves {@link ResultSet} y crear el objeto DTO
     * pasando el resultado a {@link #executeSimpleQuery(DTOBeneficiarySimpleDetails, ResultSet)}.
     *
     * @param st objeto con los datos de la consulta
     * @return objeto DTO con los datos del Beneficiario.
     * @throws DAOException se lanza cuando hay errores al realizar la operacion.
     */
    private DTOBeneficiarySimpleDetails executeResultSet(PreparedStatement st) throws DAOException {
        try (ResultSet rs = st.executeQuery()) {
            if (!rs.next()) {
                return null;
            }

            DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
            executeSimpleQuery(dto, rs);
            return dto;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se ha podido recuperar la información", e);
        }
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws DAOException {
        List<DTOBeneficiarySimpleDetails> list = new ArrayList<>();
        String sql = SQLRepository.get("sql/beneficiary/findByMunicipalities.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, municipality);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
                    executeSimpleQuery(dto, rs);
                    list.add(dto);
                }

                return list;
            }
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información de beneficiarios del municipio de " + municipality, e);
        }
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findByAll() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findByAll.sql");
        return executeFindAllWithoutProperty(sql);
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllWithoutProperty() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findAllWithoutProperty.sql");
        return executeFindAllWithoutProperty(sql);
    }

    /**
     * Realizar consulta a la base de datos para obtener los datos de la entidad.
     *
     * @param sql consulta SQL a realizar.
     * @return lista con información de los beneficiarios.
     * @throws DAOException se lanza cuando falla la operacion.
     */
    private List<DTOBeneficiarySimpleDetails> executeFindAllWithoutProperty(String sql) throws DAOException {
        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            List<DTOBeneficiarySimpleDetails> list = new ArrayList<>();

            while (rs.next()) {
                DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
                executeSimpleQuery(dto, rs);
                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información de los beneficiarios", e);
        }
    }

    /**
     * Preparar objecto {@link PreparedStatement} para la consulta.
     *
     * @param dto objeto DTO a configurar.
     * @param rs  resultados de la consulta.
     * @throws SQLException se lanza cuando hay fallos con la base de datos..
     */
    private void executeSimpleQuery(DTOBeneficiarySimpleDetails dto, ResultSet rs) throws SQLException {
        dto.setCode(rs.getInt("code"));
        dto.setId(rs.getLong("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setPhone(rs.getLong("phone"));
        dto.setCadastralReference(rs.getString("cadastral_reference"));
        dto.setMunicipality(Municipalities.valueOf(rs.getString("municipality")));
        dto.setMaritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")));
        dto.setAddress(rs.getString("address"));
    }

    @Override
    public DTOBeneficiaryDetails findAllData(int code) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findAllData.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    throw new BeneficiaryNotFoundException(String.valueOf(code));
                }

                return executeQuery(rs);
            }
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información de los beneficiarios", e);
        }
    }

    @Override
    public List<DTOBeneficiaryCreate> findAllForExport() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findAllForExport.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            List<DTOBeneficiaryCreate> list = new ArrayList<>();

            while (rs.next()) {
                DTOBeneficiaryCreate dto = new DTOBeneficiaryCreate.Builder()
                        .id(rs.getLong("id"))
                        .fullName(rs.getString("full_name"))
                        .department(Department.valueOf(rs.getString("department")))
                        .municipality(Municipalities.valueOf(rs.getString("municipality")))
                        .address(rs.getString("address"))
                        .cadastralReference(rs.getString("cadastral_reference"))
                        .maritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")))
                        .affectation(rs.getString("affectation"))
                        .phone(rs.getLong("phone"))
                        .crossing(rs.getString("crossing"))
                        .publication(rs.getString("publication"))
                        .neighborhood(rs.getString("neighborhood"))
                        .expeditionLocation(rs.getString("expedition_location"))
                        .build();
                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al recuperar la información de los beneficiarios para exportar", e);
        }
    }

    /**
     * Crear objeto DTO con los resultados de la consulta
     *
     * @param rs objeto con los resultados de la consulta
     * @return objecto DTO con los datos del Beneficiario
     * @throws SQLException exception lanzada si hay fallos con la base
     *                      de datos.
     */
    private DTOBeneficiaryDetails executeQuery(ResultSet rs) throws SQLException {
        return new DTOBeneficiaryDetails.Builder()
                .code(rs.getInt("code"))
                .id(rs.getLong("id"))
                .fullName(rs.getString("full_name"))
                .department(Department.valueOf(rs.getString("department")))
                .municipality(Municipalities.valueOf(rs.getString("municipality")))
                .address(rs.getString("address"))
                .cadastralReference(rs.getString("cadastral_reference"))
                .maritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")))
                .affectation(rs.getString("affectation"))
                .phone(rs.getLong("phone"))
                .crossing(rs.getString("crossing"))
                .publication(rs.getString("publication"))
                .neighborhood(rs.getString("neighborhood"))
                .expeditionLocation(rs.getString("expedition_location"))
                .idSpouse(rs.getLong("spouse_id"))
                .fullNameSpouse(rs.getString("spouse_full_name"))
                .expeditionLocationSpouse(rs.getString("spouse_expedition_location"))
                .addressSpouse(rs.getString("spouse_address"))
                .phoneSpouse(rs.getLong("spouse_phone"))
                .build();
    }

    @Override
    public boolean modify(DTOBeneficiaryUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/modify.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            statementDetailsUpdate(st, dto);

            if (st.executeUpdate() == 0) {
                throw new BeneficiaryNotFoundException("No se ha encontrado el beneficiario a modificar.");
            }

            return true;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al acceder a la información del beneficiario a modificar.", e);
        }
    }

    /**
     * Configurar objeto {@link PreparedStatement} con los datos a modificar.
     *
     * @param st  objeto {@code PreparedStatement}
     * @param dto objeto DTO con los datos del beneficiario
     * @throws SQLException excepcion lanzada cuando hay problemas
     *                      con la base de datos.
     */
    private void statementDetailsUpdate(PreparedStatement st, DTOBeneficiaryUpdate dto) throws SQLException {
        st.setString(1, String.valueOf(dto.getDepartment()));
        st.setString(2, String.valueOf(dto.getMunicipality()));
        st.setString(3, dto.getAddress());
        st.setString(4, String.valueOf(dto.getMaritalStatus()));
        st.setString(5, dto.getAffectation());
        st.setLong(6, dto.getPhone());
        st.setString(7, dto.getCrossing());
        st.setString(8, dto.getPublication());
        st.setString(9, dto.getNeighborhood());
        st.setInt(10, dto.getCode());
    }

    @Override
    public boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/modifyProperty.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, dto.getPropertyCode());
            st.setInt(2, dto.getBeneficiaryCode());

            if (st.executeUpdate() == 0) {
                throw new BeneficiaryNotFoundException("No se ha encontrado el beneficiario a modificar.");
            }

            return true;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("Error al acceder a la información del beneficiario a modificar.", e);
        }
    }

    @Override
    public void delete(int code) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/delete.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            if (st.executeUpdate() == 0) {
                throw new BeneficiaryNotFoundException(String.valueOf(code));
            }
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException();
        }
    }

    @Override
    public int countRecords() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/countRecords.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new BeneficiaryNotFoundException("No hay registros para contar");
            }

            return rs.getInt("total_records");
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se pudo acceder a los registros de beneficiarios.", e);
        }
    }

    @Override
    public int getLastCode() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/getLastCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new BeneficiaryNotFoundException();
            }

            return rs.getInt("last_code");
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se pudo acceder a los registros de beneficiarios.", e);
        }
    }

    @Override
    public List<DTOBeneficiariesByMonth> countBeneficiariesLastMonths(int months) throws DAOException {
        List<DTOBeneficiariesByMonth> result = new ArrayList<>();
        String sql = SQLRepository.get("sql/beneficiary/countBeneficiariesLastMonths.sql");

        try (Connection conn = DataBasePool.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, months);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    DTOBeneficiariesByMonth dto = new DTOBeneficiariesByMonth(rs.getInt("year_value"),
                            rs.getInt("month_value"), rs.getInt("total_count"));
                    result.add(dto);
                }
            }

            return result;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se pudo acceder a los registros de beneficiarios.", e);
        }
    }

    @Override
    public int countBeneficiariesWithProperty() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/countBeneficiariesWithProperty.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new BeneficiaryNotFoundException();
            }

            return rs.getInt("beneficiaries_with_property");
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se pudo acceder a los registros de beneficiarios.", e);
        }
    }

    @Override
    public int percentBeneficiariesWithProperty() throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/percenBeneficiariesWithProperty.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new BeneficiaryNotFoundException();
            }

            return rs.getInt("percent");
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException("No se pudo acceder a los registros de beneficiarios.", e);
        }
    }

}
