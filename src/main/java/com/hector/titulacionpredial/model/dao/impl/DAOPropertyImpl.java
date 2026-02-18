package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

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
    public void add(DTOPropertyCreate dto) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public DTOPropertyDetails findByCode(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return List.of();
    }

    @Override
    public void delete(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public int countRecords() throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return 0;
    }

}
