package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void add(DTOResolutionCreate dto) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }
    }

    @Override
    public DTOResolutionDetails findByCode(int code) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return null;
    }

    @Override
    public List<DTOResolutionDetails> findByAll() throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return List.of();
    }

    @Override
    public boolean modify(DTOResolutionUpdate dto) throws Exception {
        String sql = "";

        try (Connection connection = DataBasePool.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

        }

        return false;
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
