package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBase<C, D> {

    void add(C dto) throws DAOException;
    D findByCode(int code) throws DAOException;

}
