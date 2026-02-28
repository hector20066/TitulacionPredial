package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPropertyImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;

import java.util.List;

/**
 * Implementación de la fachada {@link PropertyFacade} para la
 * gestión de predios.
 *
 * <p>
 * Construye los DTOs necesarios a partir de los parámetros
 * recibidos y delega las operaciones al DAO
 * {@link DAOPropertyImpl}.
 * </p>
 *
 * @author Hector Acevedo
 * @see PropertyFacade
 * @see DAOPropertyImpl
 * @since 1.0
 */
public class PropertyImplFacade implements PropertyFacade {

    /**
     * DAO delegado para operaciones de predios.
     */
    private final DAOProperty daoProperty;

    /**
     * Crea una nueva instancia obteniendo el DAO
     * de predios mediante su Singleton.
     */
    public PropertyImplFacade() {
        this.daoProperty = DAOPropertyImpl.getInstance();
    }

    @Override
    public int add(String cadastralId, Double area) throws DAOException {
        DTOPropertyCreate dto = new DTOPropertyCreate();
        dto.setCadastralId(cadastralId);
        dto.setArea(area);

        return daoProperty.add(dto);
    }

    @Override
    public DTOPropertyDetails findByCode(String cadastralId) throws DAOException {
        return daoProperty.findByCode(cadastralId);
    }

    @Override
    public List<DTOPropertyDetails> findByAll() throws DAOException {
        return daoProperty.findByAll();
    }

    @Override
    public List<DTOPropertyDetails> findByAllForExport() throws DAOException {
        return daoProperty.findByAllForExport();
    }

    @Override
    public void delete(int code) throws DAOException {
        daoProperty.delete(code);
    }

    @Override
    public int countRecords() throws DAOException {
        return daoProperty.countRecords();
    }

    @Override
    public int percentPropertiesWithResolutions() throws DAOException {
        return daoProperty.percentPropertiesWithResolutions();
    }

    @Override
    public int countPropertyWithResolution() throws DAOException {
        return daoProperty.countPropertyWithResolution();
    }

}
