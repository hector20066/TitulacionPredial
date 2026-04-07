package com.hector.titulacionpredial.facade.impl;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dao.impl.DAOPropertyImpl;
import com.hector.titulacionpredial.model.dao.interfaces.DAOProperty;
import com.hector.titulacionpredial.model.dto.property.*;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

import java.util.List;

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
    public DTOPropertySimpleDetails findSimpleDetails(String cadastralRef) throws DAOException {
        return daoProperty.findSimpleDetails(cadastralRef);
    }

    @Override
    public boolean modifyBasicInformation(Department department, Municipalities municipality, String neighborhood, String address,
                                          String crossing, String publication, String cadastralReference) throws DAOException {
        DTOPropertyModifyBasic dto = new DTOPropertyModifyBasic.Builder()
                .department(department)
                .municipality(municipality)
                .neighborhood(neighborhood)
                .address(address)
                .crossing(crossing)
                .publication(publication)
                .cadastralRef(cadastralReference)
                .build();

        return daoProperty.modifyBasicInformation(dto);
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

    @Override
    public int countRecordsByMunicipality(Municipalities municipality) throws DAOException {
        return daoProperty.countRecordsByMunicipality(municipality);
    }

    @Override
    public int countPropertyWithResolutionByMunicipality(Municipalities municipality) throws DAOException {
        return daoProperty.countPropertyWithResolutionByMunicipality(municipality);
    }

}
