package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Data Transfer Object (DTO) that contains the information obtained
 * from a beneficiary.
 *
 * <p>
 * It is used to transport data from the persistence layer to the
 * presentation layer to display the information, avoiding directly
 * exposing the {@code Beneficiary} entity.
 * </p>
 *
 * <p>
 * Extends {@link DTOBeneficiaryCreate} by adding specific information
 * related to the code and the beneficiary's spouse information.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluent construction using the
 * {@link DTOBeneficiaryDetails.Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryDetails extends DTOBeneficiaryCreate {

    private int code;
    private Department department;
    private Municipalities municipality;
    private String address;
    private String cadastralRef;
    private String crossing;
    private String publication;
    private String neighborhood;
    private long idSpouse;
    private String fullNameSpouse;
    private String expeditionLocationSpouse;
    private long phoneSpouse;
    private int spouseBeneficiaryCode;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOBeneficiaryDetails() {
        super();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOBeneficiaryDetails(Builder builder) {
        super(builder);
        this.code = builder.code;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.address = builder.address;
        this.cadastralRef = builder.cadastralRef;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.neighborhood = builder.neighborhood;
        this.idSpouse = builder.idSpouse;
        this.fullNameSpouse = builder.fullNameSpouse;
        this.expeditionLocationSpouse = builder.expeditionLocationSpouse;
        this.phoneSpouse = builder.phoneSpouse;
        this.spouseBeneficiaryCode = builder.spouseBeneficiaryCode;
    }

    /**     * get code.     * @return the get code     */
    public int getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(int code) {
        this.code = code;
    }

    /**     * get department.     * @return the get department     */
    public Department getDepartment() {
        return department;
    }

    /**     * set department.     * @param department the department     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**     * get municipality.     * @return the get municipality     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**     * set municipality.     * @param municipality the municipality     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * set address.     * @param address the address     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

    /**     * get crossing.     * @return the get crossing     */
    public String getCrossing() {
        return crossing;
    }

    /**     * set crossing.     * @param crossing the crossing     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**     * get publication.     * @return the get publication     */
    public String getPublication() {
        return publication;
    }

    /**     * set publication.     * @param publication the publication     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    /**     * get neighborhood.     * @return the get neighborhood     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**     * set neighborhood.     * @param neighborhood the neighborhood     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**     * get id spouse.     * @return the get id spouse     */
    public long getIdSpouse() {
        return idSpouse;
    }

    /**     * set id spouse.     * @param idSpouse the id spouse     */
    public void setIdSpouse(long idSpouse) {
        this.idSpouse = idSpouse;
    }

    /**     * get full name spouse.     * @return the get full name spouse     */
    public String getFullNameSpouse() {
        return fullNameSpouse;
    }

    /**     * set full name spouse.     * @param fullNameSpouse the full name spouse     */
    public void setFullNameSpouse(String fullNameSpouse) {
        this.fullNameSpouse = fullNameSpouse;
    }

    /**     * get expedition location spouse.     * @return the get expedition location spouse     */
    public String getExpeditionLocationSpouse() {
        return expeditionLocationSpouse;
    }

    /**     * set expedition location spouse.     * @param expeditionLocationSpouse the expedition location spouse     */
    public void setExpeditionLocationSpouse(String expeditionLocationSpouse) {
        this.expeditionLocationSpouse = expeditionLocationSpouse;
    }

    /**     * get phone spouse.     * @return the get phone spouse     */
    public long getPhoneSpouse() {
        return phoneSpouse;
    }

    /**     * set phone spouse.     * @param phoneSpouse the phone spouse     */
    public void setPhoneSpouse(long phoneSpouse) {
        this.phoneSpouse = phoneSpouse;
    }

    /**     * get spouse beneficiary code.     * @return the get spouse beneficiary code     */
    public int getSpouseBeneficiaryCode() {
        return spouseBeneficiaryCode;
    }

    /**     * set spouse beneficiary code.     * @param spouseBeneficiaryCode the spouse beneficiary code     */
    public void setSpouseBeneficiaryCode(int spouseBeneficiaryCode) {
        this.spouseBeneficiaryCode = spouseBeneficiaryCode;
    }

    /**
     * Builder for the fluid construction of
     * {@link DTOBeneficiaryDetails} instances.
     *
     * <p>
     * It allows you to configure the attributes
     * before invoking {@link #build()}.
     * </p>
     */
    public static class Builder extends DTOBeneficiaryCreate.AbstractBuilder<Builder> {

        private int code;
        private Department department;
        private Municipalities municipality;
        private String address;
        private String cadastralRef;
        private String crossing;
        private String publication;
        private String neighborhood;
        private long idSpouse;
        private String fullNameSpouse;
        private String expeditionLocationSpouse;
        private long phoneSpouse;
        private int spouseBeneficiaryCode;

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

    /**     * department.     * @param department the department     * @return the department     */
        public Builder department(Department department) {
            this.department = department;
            return this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

    /**     * crossing.     * @param crossing the crossing     * @return the crossing     */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

    /**     * publication.     * @param publication the publication     * @return the publication     */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

    /**     * neighborhood.     * @param neighborhood the neighborhood     * @return the neighborhood     */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

    /**     * id spouse.     * @param idSpouse the id spouse     * @return the id spouse     */
        public Builder idSpouse(long idSpouse) {
            this.idSpouse = idSpouse;
            return this;
        }

    /**     * full name spouse.     * @param fullNameSpouse the full name spouse     * @return the full name spouse     */
        public Builder fullNameSpouse(String fullNameSpouse) {
            this.fullNameSpouse = fullNameSpouse;
            return this;
        }

    /**     * expedition location spouse.     * @param expeditionLocationSpouse the expedition location spouse     * @return the expedition location spouse     */
        public Builder expeditionLocationSpouse(String expeditionLocationSpouse) {
            this.expeditionLocationSpouse = expeditionLocationSpouse;
            return this;
        }

    /**     * phone spouse.     * @param phoneSpouse the phone spouse     * @return the phone spouse     */
        public Builder phoneSpouse(long phoneSpouse) {
            this.phoneSpouse = phoneSpouse;
            return this;
        }

    /**     * spouse beneficiary code.     * @param spouseBeneficiaryCode the spouse beneficiary code     * @return the spouse beneficiary code     */
        public Builder spouseBeneficiaryCode(int spouseBeneficiaryCode) {
            this.spouseBeneficiaryCode = spouseBeneficiaryCode;
            return this;
        }

        @Override
    /**     * build.     * @return the build     */
        public DTOBeneficiaryDetails build() {
            return new DTOBeneficiaryDetails(this);
        }

    }

}
