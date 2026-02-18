package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.entities.Property;
import com.hector.titulacionpredial.model.enums.MaritalStatus;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryCreate extends DTOBeneficiary {

    private long id;
    private String name;
    private String lastName;
    private String expeditionLocation;
    private long cadastralReference;
    private int propertyCode;

    public DTOBeneficiaryCreate() {

    }

    public DTOBeneficiaryCreate(long id, String name, String lastName, String expeditionLocation, String department, String municipality, String neighborhood, String address, long phone, long cadastralReference, String crossing, String publication, MaritalStatus maritalStatus, String affectation, int propertyCode) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.expeditionLocation = expeditionLocation;
        this.cadastralReference = cadastralReference;
        this.propertyCode = propertyCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public void setCadastralReference(long cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public long getCadastralReference() {
        return cadastralReference;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

}
