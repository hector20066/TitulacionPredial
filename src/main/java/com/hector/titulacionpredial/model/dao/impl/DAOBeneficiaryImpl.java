package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.*;
import com.hector.titulacionpredial.model.enums.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOBeneficiaryImpl implements DAOBeneficiary {

    private static DAOBeneficiaryImpl instance;

    private DAOBeneficiaryImpl() {

    }

    public static DAOBeneficiaryImpl getInstance() {
        if (instance == null) {
            instance = new DAOBeneficiaryImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOBeneficiaryCreate dto) throws Exception {
        String sql = "INSERT INTO beneficiary(id, full_name, departament, municipality, address, cadastral_reference, marital_status, affectation, phone, crossing, publication, neighborhood, expedition_location, entry_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             statementDetails(st, dto);
             st.executeUpdate();
        }
    }

    private void statementDetails(PreparedStatement st, DTOBeneficiaryCreate dto) throws Exception {
        st.setLong(1, dto.getId());
        st.setString(2, dto.getFullName());
        st.setString(3, String.valueOf(dto.getDepartment()));
        st.setString(4, String.valueOf(dto.getMunicipality()));
        st.setString(5, dto.getAddress());
        st.setLong(6, dto.getCadastralReference());
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
    public DTOBeneficiarySimpleDetails findByCode(int code) throws Exception {
        String sql = "SELECT code, id, full_name, phone, cadastral_reference, municipality, address FROM beneficiary WHERE code = ? LIMIT 1;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setInt(1, code);

             return executeResultSet(st);
        }
    }

    @Override
    public DTOBeneficiarySimpleDetails findById(long id) throws Exception {
        String sql = "SELECT code, id, full_name, phone, cadastral_reference, municipality, address FROM beneficiary WHERE id = ? LIMIT 1;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setLong(1, id);

            return executeResultSet(st);
        }
    }

    @Override
    public DTOBeneficiarySimpleDetails findByName(String name) throws Exception {
        String sql = "SELECT code, id, full_name, phone, cadastral_reference, municipality, address FROM beneficiary WHERE full_name = ? LIMIT 1;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setString(1, name);

            return executeResultSet(st);
        }
    }

    private DTOBeneficiarySimpleDetails executeResultSet(PreparedStatement st) throws Exception {
        try (ResultSet rs = st.executeQuery()) {
            if (!rs.next()) {
                return null;
            }

            DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
            executeSimpleQuery(dto, rs);
            return dto;
        }
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findAllByMunicipality(String municipality) throws Exception {
        List<DTOBeneficiarySimpleDetails> list = new ArrayList<>();
        String sql = "SELECT code, id, full_name, phone, cadastral_reference, municipality, address FROM beneficiary WHERE municipality = ?;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setString(1, municipality);

             ResultSet rs = st.executeQuery();

             while(rs.next()) {
                 DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
                 executeSimpleQuery(dto, rs);
                 list.add(dto);
             }
        }

        return list;
    }

    @Override
    public List<DTOBeneficiarySimpleDetails> findByAll() throws Exception {
        List<DTOBeneficiarySimpleDetails> list = new ArrayList<>();
        String sql = "SELECT code, id, full_name, phone, cadastral_reference, municipality, address FROM beneficiary ORDER BY code DESC LIMIT 1000;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

             while(rs.next()) {
                 DTOBeneficiarySimpleDetails dto = new DTOBeneficiarySimpleDetails();
                 executeSimpleQuery(dto, rs);
                 list.add(dto);
             }
        }

        return list;
    }

    private void executeSimpleQuery(DTOBeneficiarySimpleDetails dto, ResultSet rs) throws Exception {
        dto.setCode(rs.getInt("code"));
        dto.setId(rs.getLong("id"));
        dto.setFullName(rs.getString("full_name"));
        dto.setPhone(rs.getLong("phone"));
        dto.setCadastralReference(rs.getLong("cadastral_reference"));
        dto.setMunicipality(Municipalities.valueOf(rs.getString("municipality")));
        dto.setAddress(rs.getString("address"));
    }

    @Override
    public DTOBeneficiaryDetails findAllData(int code) throws Exception {
        String sql = "SELECT beneficiary.code, beneficiary.id, beneficiary.full_name, beneficiary.departament, beneficiary.municipality, beneficiary.address, beneficiary.cadastral_reference, beneficiary.marital_status, beneficiary.affectation, beneficiary.phone, beneficiary.crossing, beneficiary.publication, beneficiary.neighborhood, beneficiary.expedition_location, spouse.id AS spouse_id, spouse.full_name AS spouse_full_name, spouse.expedition_location AS spouse_expedition_location, spouse.address AS spouse_address, spouse.phone AS spouse_phone FROM beneficiary LEFT JOIN spouse ON beneficiary.code = spouse.beneficiary_code WHERE beneficiary.code = ?;";

        try(Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, code);
            ResultSet rs = st.executeQuery();

            if (!rs.next()) {
                return null;
            }

            return executeQuery(rs);
        }
    }

    private DTOBeneficiaryDetails executeQuery(ResultSet rs) throws SQLException {
        return new DTOBeneficiaryDetails.Builder()
                .code(rs.getInt("code"))
                .id(rs.getLong("id"))
                .fullName(rs.getString("full_name"))
                .department(Department.valueOf(rs.getString("departament")))
                .municipality(Municipalities.valueOf(rs.getString("municipality")))
                .address(rs.getString("address"))
                .cadastralReference(rs.getLong("cadastral_reference"))
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
    public boolean modify(DTOBeneficiaryUpdate dto) throws Exception {
        String sql = "UPDATE beneficiary SET departament = ?, municipality = ?, address = ?, marital_status = ?, affectation = ?, phone = ?, crossing = ?, publication = ?, neighborhood = ? WHERE code = ?;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             statementDetailsUpdate(st, dto);
             st.executeUpdate();

             return true;
        }
    }

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
    public boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception {
        String sql = "UPDATE beneficiary SET property_code = ? WHERE code = ?;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, dto.getPropertyCode());
            st.setInt(2, dto.getBeneficiaryCode());
            st.executeUpdate();

            return true;
        }
    }

    @Override
    public void delete(int code) throws Exception {
        String sql = "DELETE FROM beneficiary WHERE code = ?;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             st.setInt(1, code);
             st.executeUpdate();
        }
    }

    @Override
    public int countRecords() throws Exception {
        String sql = "SELECT COUNT(*) AS total_records FROM beneficiary;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
             ResultSet rs = st.executeQuery();

             if(!rs.next()) {
                 return 0;
             }
             return rs.getInt("total_records");
        }
    }

    @Override
    public int getLastCode() throws Exception {
        String sql = "SELECT MAX(code) AS last_code FROM beneficiary;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                return 0;
            }

            return rs.getInt("last_code");
        }
    }

}
