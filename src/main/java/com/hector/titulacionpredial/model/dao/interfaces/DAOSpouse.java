package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * Interfaz DAO para la gestión de cónyuges en la base de datos.
 *
 * <p>
 * Extiende {@link DAOBase} con {@link DTOSpouse} como tipo de
 * creación y consulta, e {@link IRemovable} para permitir la
 * eliminación de registros.
 * </p>
 *
 * @author Hector Acevedo
 * @see DAOBase
 * @see IRemovable
 * @since 1.0
 */
public interface DAOSpouse extends DAOBase<DTOSpouse, DTOSpouse>, IRemovable {

}
