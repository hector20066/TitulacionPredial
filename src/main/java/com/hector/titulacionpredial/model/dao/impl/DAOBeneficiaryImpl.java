package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.BeneficiaryPersistenceException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
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
 * Implementation of the DAO for beneficiary management in the PostgreSQL database.
 *
 * <p>
 * It uses the Singleton pattern to ensure a single instance. SQL queries are
 * obtained from {@link SQLRepository} and the database connection is made via
 * {@link DataBasePool}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBeneficiary
 * @see DataBasePool
 * @see SQLRepository
 * @since 1.0
 */
public class DAOBeneficiaryImpl implements DAOBeneficiary {

    private static DAOBeneficiaryImpl instance;
    private final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Private builder to guarantee the Singleton pattern.
     */
    private DAOBeneficiaryImpl() {

    }

    /**
     * Obtain the single instance of the DAO.
     *
     * @return Singleton instance of {@code DAOBeneficiaryImpl}
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
            st.setString(1, dto.getCodeBeneficiaries());
            st.setLong(2, dto.getId());
            st.setString(3, dto.getFullName());
            st.setString(4, String.valueOf(dto.getMaritalStatus()));
            st.setString(5, dto.getAffectation());
            st.setLong(6, dto.getPhone());
            st.setString(7, dto.getExpeditionLocation());
            st.setDate(8, Date.valueOf(LocalDate.now()));
            st.executeUpdate();
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.register"), e);
        }
    }

    @Override
    public DTOBeneficiarySimpleDetails findByCode(int code) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);

            return executeResultSet(st);
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.code") + " " + code, e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.id") + " " + id, e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.name") + " " + name, e);
        }
    }

    /**
     * Get query data through {@link ResultSet} and create the DTO object by passing the
     * result to {@link #executeSimpleQuery(DTOBeneficiarySimpleDetails, ResultSet)}.
     *
     * @param st object with the query data
     * @return DTO object with the Beneficiary's data.
     * @throws DAOException It is triggered when there are errors while performing the operation.
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info"), e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.municipality") + " " + municipality, e);
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
     * Perform a query to the database to obtain the entity's data.
     *
     * @param sql SQL query to be performed.
     * @return list with information of the beneficiaries.
     * @throws DAOException It is launched when the operation fails.
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.all"), e);
        }
    }

    /**
     * Prepare object {@link PreparedStatement} for the query.
     *
     * @param dto DTO object to be configured.
     * @param rs  results of the consultation.
     * @throws SQLException It is launched when there are errors with the database.
     */
    private void executeSimpleQuery(DTOBeneficiarySimpleDetails dto, ResultSet rs) throws SQLException {
        dto.setCode(rs.getInt("code"));
        dto.setId(rs.getLong("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setPhone(rs.getLong("phone"));
        dto.setMaritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")));
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.all"), e);
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
                        .codeBeneficiaries(rs.getString("code_beneficiaries"))
                        .id(rs.getLong("id"))
                        .fullName(rs.getString("full_name"))
                        .maritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")))
                        .affectation(rs.getString("affectation"))
                        .phone(rs.getLong("phone"))
                        .expeditionLocation(rs.getString("expedition_location"))
                        .build();

                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.export"), e);
        }
    }

    /**
     * Create a DTO object with the query results
     *
     * @param rs object with the results of the query
     * @return DTO object with the Beneficiary's data
     * @throws SQLException exception thrown if there are database errors.
     */
    private DTOBeneficiaryDetails executeQuery(ResultSet rs) throws SQLException {
        return new DTOBeneficiaryDetails.Builder()
                .codeBeneficiaries(rs.getString("code_beneficiaries"))
                .id(rs.getLong("id"))
                .fullName(rs.getString("full_name"))
                .maritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")))
                .affectation(rs.getString("affectation"))
                .phone(rs.getLong("phone"))
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
            st.setString(1, dto.getCodeBeneficiaries());
            st.setLong(2, dto.getId());
            st.setString(3, dto.getFullName());
            st.setString(4, String.valueOf(dto.getMaritalStatus()));
            st.setString(5, dto.getAffectation());
            st.setLong(6, dto.getPhone());
            st.setString(7, dto.getExpeditionLocation());
            st.setInt(8, dto.getCode());

            if (st.executeUpdate() == 0) {
                throw new BeneficiaryNotFoundException(lang.message("not.found.beneficiary.modify"));
            }

            return true;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.modify"), e);
        }
    }

    /**
     * Prepare PreparedStatement object with transaction data.
     *
     * @param st  PrepareStatement object
     * @param dto DTO object with beneficiary data
     * @throws SQLException if an exception occurs while
     *                      performing the operation.
     */
    private void statementDetails(PreparedStatement st, DTOBeneficiary dto) throws SQLException {
        st.setLong(1, dto.getId());
        st.setString(2, dto.getFullName());
        st.setString(7, String.valueOf(dto.getMaritalStatus()));
        st.setString(8, dto.getAffectation());
        st.setLong(9, dto.getPhone());
        st.setString(13, dto.getExpeditionLocation());
    }

    @Override
    public boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/beneficiary/modifyProperty.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, dto.getPropertyCode());
            st.setString(2, dto.getCodeBeneficiaries());

            if (st.executeUpdate() == 0) {
                throw new BeneficiaryNotFoundException(lang.message("not.found.beneficiary.modify"));
            }

            return true;
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.modify"), e);
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
                throw new BeneficiaryNotFoundException(lang.message("not.found.count"));
            }

            return rs.getInt("total_records");
        } catch (SQLException e) {
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.access"), e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.access"), e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.access"), e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.access"), e);
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
            throw new BeneficiaryPersistenceException(lang.message("persistence.beneficiary.info.access"), e);
        }
    }

}
