package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.DTOSpouse;

/**
 * DAO interface for managing spouses in the database.
 *
 * <p>
 * Extends {@link DAOBase} with {@link DTOSpouse} as
 * the creation and query type, and {@link IRemovable}
 * to allow record deletion.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DAOBase
 * @see IRemovable
 * @since 1.0
 */
public interface DAOSpouse extends DAOBase<DTOSpouse, DTOSpouse>, IRemovable {

}
