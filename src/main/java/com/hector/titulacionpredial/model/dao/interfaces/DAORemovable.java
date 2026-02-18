package com.hector.titulacionpredial.model.dao.interfaces;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface DAORemovable {

    void delete(int code) throws Exception;

}
