package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 * Interfaz DAO para la gestión de puntos geográficos
 * (coordenadas) en la base de datos.
 *
 * <p>
 * Extiende {@link DAOBase} con {@link DTOPoint} como tipo tanto
 * de creación como de consulta, proporcionando las operaciones
 * básicas de inserción y búsqueda por código.
 * </p>
 *
 * @author Hector Acevedo
 * @see DAOBase
 * @since 1.0
 */
public interface DAOPoint extends DAOBase<DTOPoint, DTOPoint> {

}
