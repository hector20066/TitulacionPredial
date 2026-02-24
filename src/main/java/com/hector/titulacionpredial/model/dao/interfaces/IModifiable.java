package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IModifiable<T> {

    boolean modify(T dto) throws DAOException;

}
