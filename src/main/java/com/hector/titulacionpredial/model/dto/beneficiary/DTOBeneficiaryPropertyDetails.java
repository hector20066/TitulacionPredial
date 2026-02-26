package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryPropertyDetails extends DTOBeneficiary {

    private String fullName;
    private long id;

    public DTOBeneficiaryPropertyDetails() {
        super();
    }

    public DTOBeneficiaryPropertyDetails(String fullName, long code, Municipalities municipality, String address) {
        super();
        this.fullName = fullName;
        this.id = code;
        setMunicipality(municipality);
        setAddress(address);
    }

    public void setCode(long code) {
        this.id = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

}
