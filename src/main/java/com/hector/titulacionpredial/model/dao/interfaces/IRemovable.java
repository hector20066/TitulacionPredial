package com.hector.titulacionpredial.model.dao.interfaces;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IRemovable {

    void delete(int code) throws Exception;

}
