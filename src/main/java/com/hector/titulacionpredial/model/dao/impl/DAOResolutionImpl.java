package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.ResolutionPersistenceException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.*;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOResolutionImpl implements DAOResolution {

    private static DAOResolutionImpl instance;

    private DAOResolutionImpl() {

    }

    public static DAOResolutionImpl getInstance() {
        if (instance == null) {
            instance = new DAOResolutionImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOResolutionCreate dto) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/insert.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, dto.getResolutionNumber());
            st.setDate(2, Date.valueOf(dto.getNotification()));
            st.setDate(3, Date.valueOf(dto.getExecutory()));
            st.setString(4, dto.getFmi());
            st.setString(5, dto.getAct());
            st.setString(6, dto.getPublicWriting());
            st.setString(7, dto.getNotary());
            st.setString(8, dto.getBeneficiaryName());
            st.setInt(9, dto.getPropertyCode());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new ResolutionPersistenceException("No fue posible guardar la información de la resolución", e);
        }
    }

    @Override
    public DTOResolutionDetails findByCode(int numResolution) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/findByCode.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setLong(1, numResolution);

            try (ResultSet rs = st.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                DTOResolutionDetails dto = new DTOResolutionDetails();
                executeQuery(dto, rs);
                return dto;
            }
        } catch (SQLException e) {
            throw new ResolutionPersistenceException("Error al recuperar la información de la resolución con numero " + numResolution, e);
        }
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws DAOException {
        List<DTOResolutionDetails> list = new ArrayList<>();
        String sql = SQLRepository.get("sql/resolution/findByAll.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                DTOResolutionDetails dto = new DTOResolutionDetails();
                executeQuery(dto, rs);
                list.add(dto);
            }

            return list;
        } catch (SQLException e) {
            throw new ResolutionPersistenceException("Error al recuperar la información de las resoluciones.", e);
        }
    }

    private void executeQuery(DTOResolutionDetails dto, ResultSet rs) throws SQLException {
        dto.setCode(rs.getInt("code"));
        dto.setResolutionNumber(rs.getLong("num_resolution"));
        dto.setNotification(rs.getDate("notification").toLocalDate());
        dto.setExecutory(rs.getDate("executory").toLocalDate());
        dto.setFmi(rs.getString("fmi"));
        dto.setAct(rs.getString("act"));
        dto.setPublicWriting(rs.getString("public_writing"));
        dto.setNotary(rs.getString("notary"));
        dto.setBeneficiaryName(rs.getString("beneficiary_name"));
    }

    @Override
    public boolean modify(DTOResolutionUpdate dto) throws DAOException {
        String sql = SQLRepository.get("sql/resolution/modify.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setDate(1, Date.valueOf(dto.getExecutory()));
            st.setString(2, dto.getAct());
            st.setString(3, dto.getPublicWriting());
            st.setDate(4, Date.valueOf(dto.getNotification()));
            st.setLong(5, dto.getResolutionNumber());
            st.setString(6, dto.getFmi());
            st.setString(7, dto.getNotary());
            st.setInt(8, dto.getCode());

            if (st.executeUpdate() == 0) {
                throw new ResolutionNotFoundException(String.valueOf(dto.getResolutionNumber()));
            }

            return true;
        } catch (SQLException e) {
            throw new ResolutionPersistenceException("Error al recuperar la información de la resolución con numero"
                    + dto.getResolutionNumber(), e);
        }
    }

    @Override
    public int countRecords() throws DAOException {
        String sql = SQLRepository.get("sql/resolution/countRecords.sql");

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (!rs.next()) {
                throw new ResolutionNotFoundException("No hay registros para contar");
            }

            return rs.getInt("total_records");
        } catch (SQLException e) {
            throw new ResolutionPersistenceException("Error al recuperar la información de las resoluciones.", e);
        }
    }

}
