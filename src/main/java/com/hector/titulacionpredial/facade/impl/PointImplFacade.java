package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPointImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOPoint;
import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 * Implementación de la fachada {@link PointFacade} para la
 * gestión de puntos geográficos.
 *
 * <p>
 * Construye los DTOs necesarios a partir de los parámetros
 * recibidos y delega las operaciones al DAO
 * {@link DAOPointImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see PointFacade
 * @see DAOPointImpl
 * @since 1.0
 */
public class PointImplFacade implements PointFacade {

    /**
     * DAO delegado para operaciones de puntos geográficos.
     */
    private final DAOPoint daoPoint;

    /**
     * Crea una nueva instancia obteniendo el DAO
     * de puntos mediante su Singleton.
     */
    public PointImplFacade() {
        this.daoPoint = DAOPointImpl.getInstance();
    }

    @Override
    public void add(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside,
                    int propertyCode) throws DAOException {
        DTOPoint dto = new DTOPoint.Builder()
                .numberPoint(numberPoint)
                .northCoordinate(northCoordinate)
                .eastCoordinate(eastCoordinate)
                .distance(distance)
                .hillside(hillside)
                .propertyCode(propertyCode)
                .build();

        daoPoint.add(dto);
    }

    @Override
    public DTOPoint findByCode(int propertyCode) throws DAOException {
        return daoPoint.findByCode(propertyCode);
    }

}
