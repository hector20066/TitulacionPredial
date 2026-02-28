package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.database.DataBasePool;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.dao.persistence.ResolutionPersistenceException;
import com.hector.titulacionpredial.model.dao.interfaces.DAOResolution;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionCreate;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionUpdate;
import com.hector.titulacionpredial.utils.SQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta de {@link DAOResolution} que gestiona
 * las operaciones de persistencia relacionadas con resoluciones.
 *
 * <p>
 * Esta clase pertenece a la capa de acceso a datos (DAO) y es
 * responsable de ejecutar operaciones CRUD contra la base de datos
 * utilizando JDBC y sentencias SQL externas obtenidas desde
 * {@link SQLRepository}.
 * </p>
 *
 * <p>
 * Las conexiones son obtenidas mediante {@link DataBasePool},
 * garantizando el uso de un pool de conexiones para mejorar
 * el rendimiento y la gestión de recursos.
 * </p>
 *
 * <p>
 * Implementa el patrón Singleton para asegurar una única instancia
 * compartida dentro del contexto de la aplicación.
 * </p>
 *
 * <p><strong>Manejo de errores:</strong></p>
 * <ul>
 *     <li>Lanza {@link ResolutionPersistenceException} ante errores SQL.</li>
 *     <li>Lanza {@link ResolutionNotFoundException} cuando no se encuentran registros esperados.</li>
 *     <li>Propaga {@link DAOException} como contrato general de la capa DAO.</li>
 * </ul>
 *
 * <p>
 * Esta clase no contiene lógica de negocio; únicamente realiza
 * operaciones de acceso a datos.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
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

    /**
     * Inserta una nueva resolución en la base de datos.
     *
     * @param dto objeto que contiene la información necesaria
     *            para crear la resolución
     * @throws DAOException si ocurre un error durante la operación
     *                      de persistencia
     */
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

    /**
     * Recupera una resolución a partir de su número.
     *
     * @param numResolution número de resolución a buscar
     * @return {@link DTOResolutionDetails} con la información encontrada,
     * o {@code null} si no existe registro asociado
     * @throws DAOException si ocurre un error de acceso a datos
     */
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

    /**
     * Recupera todas las resoluciones registradas en la base de datos.
     *
     * @return lista de {@link DTOResolutionDetails}.
     * Puede estar vacía si no existen registros.
     * @throws DAOException si ocurre un error durante la consulta
     */
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

    /**
     * Actualiza la información de una resolución existente.
     *
     * @param dto objeto que contiene los datos actualizados
     * @return {@code true} si la actualización fue exitosa
     * @throws ResolutionNotFoundException si no existe una resolución
     *                                     con el identificador proporcionado
     * @throws DAOException                si ocurre un error durante la operación
     */
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

    /**
     * Obtiene la cantidad total de resoluciones registradas.
     *
     * @return número total de registros
     * @throws ResolutionNotFoundException si no existen registros
     * @throws DAOException                si ocurre un error durante la consulta
     */
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
