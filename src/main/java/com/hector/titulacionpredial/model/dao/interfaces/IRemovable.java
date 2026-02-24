package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IRemovable {

    void delete(int code) throws DAOException;

}
