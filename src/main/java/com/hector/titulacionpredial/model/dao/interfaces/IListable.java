package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IListable<T> {

    List<T> findByAll() throws DAOException;

}
