package com.hector.titulacionpredial.model.dao.interfaces;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IModifiable<T> {

    boolean modify(T dto) throws Exception;

}
