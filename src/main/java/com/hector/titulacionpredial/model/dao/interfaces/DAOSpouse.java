package com.hector.titulacionpredial.model.dao.interfaces;

import com.hector.titulacionpredial.model.dto.DTOSpouse;

public interface DAOSpouse {

    void add(DTOSpouse dto) throws Exception;
    DTOSpouse findByBeneficiaryCode(int code) throws Exception;
    void delete(int code) throws Exception;

}
