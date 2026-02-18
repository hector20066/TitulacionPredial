package com.hector.titulacionpredial.model.dao.impl;

import com.hector.titulacionpredial.model.dao.interfaces.DAOBeneficiary;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyUpdate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryUpdate;

import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DAOBeneficiaryImpl implements DAOBeneficiary {

    private static DAOBeneficiaryImpl instance;

    private DAOBeneficiaryImpl() {

    }

    public static DAOBeneficiaryImpl getInstance() {
        if (instance == null) {
            instance = new DAOBeneficiaryImpl();
        }

        return instance;
    }

    @Override
    public void add(DTOBeneficiaryCreate dto) throws Exception {

    }

    @Override
    public DTOBeneficiaryDetails findByCode(int code) throws Exception {
        return null;
    }

    @Override
    public DTOBeneficiaryDetails findById(int id) throws Exception {
        return null;
    }

    @Override
    public DTOBeneficiaryDetails findByName(String name) throws Exception {
        return null;
    }

    @Override
    public DTOBeneficiaryDetails findByMunicipality(String municipality) throws Exception {
        return null;
    }

    @Override
    public List<DTOBeneficiaryDetails> findByAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean modify(DTOBeneficiaryUpdate dto) throws Exception {
        return false;
    }

    @Override
    public boolean modifyProperty(DTOBeneficiaryPropertyUpdate dto) throws Exception {
        return false;
    }

    @Override
    public void delete(int code) throws Exception {

    }

}
