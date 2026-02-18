package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.point.DTOPointCreate;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author hectoracevedo
 */
public class DAOPointImpl implements DAOPoint {

    private static DAOPointImpl instance;

    private DAOPointImpl() {

    }

    public static DAOPointImpl getInstance() {
        if (instance == null) {
            instance = new DAOPointImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOPointCreate dto) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public DTOPointDetails findById(int id) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public DTOPointDetails findByCode(int propertyCode) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

}
