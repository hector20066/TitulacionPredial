package com.hector.titulacionpredial.facade.interfaces;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.PointImplFacade;
import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 * Fachada que define las operaciones de alto nivel para la
 * gestión de puntos geográficos (coordenadas) en el sistema.
 *
 * <p>
 * Simplifica la construcción de {@link DTOPoint} y encapsula
 * las llamadas al DAO correspondiente.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see PointImplFacade
 * @since 1.0
 */
public interface PointFacade {

    /**
     * Registra un nuevo punto geográfico asociado a un predio.
     *
     * @param numberPoint     número del punto
     * @param northCoordinate coordenada norte
     * @param eastCoordinate  coordenada este
     * @param distance        distancia
     * @param hillside        ladera o costado
     * @param propertyCode    código del predio asociado
     * @throws DAOException si ocurre un error en la operación
     */
    void add(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside,
             int propertyCode) throws DAOException;

    /**
     * Busca los puntos geográficos de un predio.
     *
     * @param propertyCode código del predio
     * @return DTO con los datos del punto encontrado
     * @throws DAOException si ocurre un error o no se encuentra
     */
    DTOPoint findByCode(int propertyCode) throws DAOException;

}
