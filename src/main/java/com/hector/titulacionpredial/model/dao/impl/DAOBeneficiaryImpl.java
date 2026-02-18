package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, 2);
            st.setString(2, "valor");
            st.executeUpdate();
        }
    }

    @Override
    public DTOBeneficiaryDetails findByCode(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public DTOBeneficiaryDetails findById(int id) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public DTOBeneficiaryDetails findByName(String name) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public DTOBeneficiaryDetails findByMunicipality(String municipality) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public List<DTOBeneficiaryDetails> findByAll() throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return List.of();
    }

    @Override
    public boolean modify(DTOBeneficiaryUpdate dto) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return false;
    }

    @Override
    public boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return false;
    }

    @Override
    public void delete(int code) throws Exception {
        String sql = "INSERT INTO beneficiary () VALUES ();";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public int countRecords() throws Exception {
        return 0;
    }

}
