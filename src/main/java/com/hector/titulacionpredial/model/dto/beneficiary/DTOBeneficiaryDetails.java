package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryDetails extends DTOBeneficiary {

    private int code;
    private String name;
    private String lastName;
    private long id;
    private long cadastralReference;

    public DTOBeneficiaryDetails() {

    }

    public DTOBeneficiaryDetails(int code, String name, String lastName, long id, String department, String municipality, String neighborhood, String address, long phone, long cadastralReference, String crossing, String publication, MaritalStatus maritalStatus, String affectation) {
        super(department, municipality, neighborhood, address, phone, crossing, publication, maritalStatus, affectation);
        this.code = code;
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.cadastralReference = cadastralReference;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public long getCadastralReference() {
        return cadastralReference;
    }

}
