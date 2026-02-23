package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;
import com.hector.titulacionpredial.model.dto.property.*;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hectoracevedo
 */
public class DAOPropertyImpl implements DAOProperty {

    private static DAOPropertyImpl instance;

    private DAOPropertyImpl() {

    }

    public static DAOPropertyImpl getInstance() {
        if (instance == null) {
            instance = new DAOPropertyImpl();
        }

        return instance;
    }

    @Override
    public int add(DTOPropertyCreate dto) throws Exception {
        String sql = "INSERT INTO property (cadastral_id, area) VALUES (?, ?);";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, dto.getCadastralId());
            st.setDouble(2, dto.getArea());

            int affectedRows = st.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Error al crear la propiedad; no hay filas afectadas.");
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al crear la propiedad, no se obtuvo ninguna identificación.");
                }
            }
        }
    }

    @Override
    public DTOPropertyDetails findByCode(String cadastralId) throws Exception {
        String sql = """
           SELECT
              p.code AS property_code,
              p.cadastral_id,
              p.area,
              b.id AS beneficiary_code,
              b.full_name AS beneficiary_fullname,
              b.municipality AS beneficiary_municipality,
              b.address AS beneficiary_address,
              pt.number,
              pt.north_coordinate,
              pt.east_coordinate,
              pt.distance,
              pt.hillside,
              r.num_resolution,
              r.notification,
              r.executory,
              r.fmi,
              r.act,
              r.public_writing,
              r.notary
            FROM property p
          JOIN point pt ON pt.property_code = p.code
          LEFT JOIN beneficiary b ON b.property_code = p.code
          LEFT JOIN resolution r ON r.property_code = p.code
          WHERE p.cadastral_id = ?
          ORDER BY pt.number
        """;

        DTOPropertyDetails property = null;

        try (Connection conn = DataBasePool.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cadastralId);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int propertyCode = rs.getInt("property_code");

                    if (property == null) {
                        property = createDTOPropertyDetails(rs);
                    }

                    Integer beneficiaryCode = rs.getObject("beneficiary_code", Integer.class);

                    if (beneficiaryCode != null) {
                        boolean beneficiaryExists = verifyBeneficiaryExist(property, beneficiaryCode);

                        if (!beneficiaryExists) {
                            DTOBeneficiaryPropertyDetails beneficiary = createDtoBeneficiaryPropertyDetails(rs, beneficiaryCode);
                            property.getBeneficiaries().add(beneficiary);
                        }
                    }

                    int numberPoint = rs.getInt("number");
                    boolean pointExists = verifyPointExists(property, numberPoint);

                    if (!pointExists) {
                        property.getPoints().add(createDTOPoints(rs, numberPoint, propertyCode));
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return property;
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws Exception {
        String sql = """
            SELECT 
                p.code AS property_code, 
                p.cadastral_id, 
                p.area, 
                b.id AS beneficiary_code,
                b.full_name AS beneficiary_fullname,
                b.municipality AS beneficiary_municipality,
                b.address AS beneficiary_address,
                pt.number,
                pt.north_coordinate,
                pt.east_coordinate,
                pt.distance,
                pt.hillside,
                r.num_resolution,
                r.notification,
                r.executory,
                r.fmi,
                r.act,
                r.public_writing,
                r.notary
            FROM (
                SELECT code 
                FROM property 
                ORDER BY code DESC 
                LIMIT 1000
            ) last_properties
            JOIN property p ON p.code = last_properties.code
            JOIN point pt ON pt.property_code = p.code
            LEFT JOIN beneficiary b ON b.property_code = p.code
            LEFT JOIN resolution r ON r.property_code = p.code
            ORDER BY p.code DESC, pt.number
        """;

        Map<Integer, DTOPropertyDetails> properties = new LinkedHashMap<>();

        try (Connection conn = DataBasePool.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int propertyCode = rs.getInt("property_code");
                DTOPropertyDetails property = properties.get(propertyCode);

                if (property == null) {
                    property = createDTOPropertyDetails(rs);
                    properties.put(propertyCode, property);
                }

                Integer beneficiaryCode = rs.getObject("beneficiary_code", Integer.class);

                if (beneficiaryCode != null) {
                    boolean beneficiaryExists = verifyBeneficiaryExist(property, beneficiaryCode);

                    if (!beneficiaryExists) {
                        DTOBeneficiaryPropertyDetails beneficiary = createDtoBeneficiaryPropertyDetails(rs, beneficiaryCode);
                        property.getBeneficiaries().add(beneficiary);
                    }
                }

                int numberPoint = rs.getInt("number");
                boolean pointExists = verifyPointExists(property, numberPoint);

                if (!pointExists) {
                    DTOPointDetails point = createDTOPoints(rs, numberPoint, propertyCode);
                    property.getPoints().add(point);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return new ArrayList<>(properties.values());
    }

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

    private boolean verifyBeneficiaryExist(DTOPropertyDetails property, int beneficiaryCode) {
        return property.getBeneficiaries()
                .stream()
                .anyMatch(b -> b.getId() == beneficiaryCode);
    }

    private boolean verifyPointExists(DTOPropertyDetails property, int numberPoint) {
        return property.getPoints()
                .stream()
                .anyMatch(p -> p.getNumberPoint() == numberPoint);
    }

    private DTOPointDetails createDTOPoints(ResultSet rs, int numberPoint, int propertyCode) throws SQLException {
        return new DTOPointDetails.Builder()
                .numberPoint(numberPoint)
                .northCoordinate(rs.getDouble("north_coordinate"))
                .eastCoordinate(rs.getDouble("east_coordinate"))
                .distance(rs.getDouble("distance"))
                .hillside(rs.getString("hillside"))
                .propertyCode(propertyCode)
                .build();
    }

    @Override
    public void delete(int code) throws Exception {
        String sql = "DELETE FROM property WHERE code = ?";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, code);
            st.executeUpdate();
        }
    }

    @Override
    public int countRecords() throws Exception {
        String sql = "SELECT COUNT(*) AS total_records FROM property;";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            if (!rs.next()) {
                return 0;
            }

            return rs.getInt("total_records");
        }
    }

    @Override
    public int percentPropertiesWithResolutions() throws Exception {
        String sql = """
                SELECT
                    ROUND(
                        COUNT(DISTINCT resolution.property_code) * 100.0 / COUT(DISTINCT property.code), 0
                    ) AS percent
                FROM property LEFT JOIN resolution
                ON resolution.property_code = property.code;
                """;

        try (Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            if (!rs.next()) {
                return 0;
            }

            return rs.getInt("percent");
        }
    }

    @Override
    public int countPropertyWithResolution() throws Exception {
        String sql = """
                SELECT 
                    COUNT(*) AS properties_with_resolution
                FROM property INNER JOIN resolution
                ON resolution.property_code = property.code;
                """;

        try(Connection connection = DataBasePool.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if(!rs.next()) {
                return 0;
            }

            return rs.getInt("properties_with_resolution");
        }
    }

}
