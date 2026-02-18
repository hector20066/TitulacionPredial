package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouse;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author hectoracevedo
 */
public class DAOSpouseImpl implements DAOSpouse {

    private static DAOSpouseImpl instance;

    private DAOSpouseImpl() {

    }

    public static DAOSpouseImpl getInstance() {
        if (instance == null) {
            instance = new DAOSpouseImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOSpouse dto) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public DTOSpouse findByCode(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public void delete(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

}
