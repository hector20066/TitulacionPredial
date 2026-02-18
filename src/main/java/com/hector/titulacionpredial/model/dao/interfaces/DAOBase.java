package com.hector.titulacionpredial.model.dao.interfaces;

/**
 *
 * @author hectoracevedo
 */
public interface DAOBase<C, D> {

    void add(C dto) throws Exception;
    D findByCode(int code) throws Exception;

}
