package com.hector.titulacionpredial.model.dao.interfaces;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
@FunctionalInterface
public interface IListable<T> {

    List<T> findByAll() throws Exception;

}
