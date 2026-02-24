package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface ICountable {

    int countRecords() throws DAOException;

}
