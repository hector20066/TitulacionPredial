package com.hector.titulacionpredial.facade.impl;

import java.util.List;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPropertyImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyCreate;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyUpdate;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Implementation of the {@link PropertyFacade} facade for
 * property management.
 *
 * <p>
 * Build the necessary DATA from the received parameters and
 * delegate the operations to the DAO {@link DAOPropertyImpl}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see PropertyFacade
 * @see DAOPropertyImpl
 * @since 1.0
 */
public class PropertyImplFacade implements PropertyFacade {

    private final DAOProperty daoProperty;

    /**
     * Create a new instance by obtaining the DAO of
     * properties through your Singleton.
     */
    public PropertyImplFacade() {
        this.daoProperty = DAOPropertyImpl.getInstance();
    }

    @Override
    public int add(String cadastralId, String address, Department department, Municipalities municipality,
                   String crossing, String neighborhood, String publication) throws DAOException {
        DTOPropertyCreate dto = new DTOPropertyCreate.Builder()
                .cadastralRef(cadastralId)
                .address(address)
                .department(department)
                .municipality(municipality)
                .crossing(crossing)
                .neighborhood(neighborhood)
                .publication(publication)
                .build();

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
    public List<DTOPropertyDetails> findByMunicipality(Municipalities municipality) throws DAOException {
        return daoProperty.findByMunicipality(municipality);
    }

    @Override
    public boolean modify(String cadastralReference, double area) throws DAOException {
        DTOPropertyUpdate dto = new DTOPropertyUpdate(area, cadastralReference);
        return daoProperty.modify(dto);
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
