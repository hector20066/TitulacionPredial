package com.hector.titulacionpredial.model.dao.interfaces;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface DAOModifiable<T> {

    boolean modify(T dto) throws Exception;

}
