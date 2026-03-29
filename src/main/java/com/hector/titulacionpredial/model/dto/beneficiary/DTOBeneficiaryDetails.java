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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Municipalities getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public long getIdSpouse() {
        return idSpouse;
    }

    public void setIdSpouse(long idSpouse) {
        this.idSpouse = idSpouse;
    }

    public String getFullNameSpouse() {
        return fullNameSpouse;
    }

    public void setFullNameSpouse(String fullNameSpouse) {
        this.fullNameSpouse = fullNameSpouse;
    }

    public String getExpeditionLocationSpouse() {
        return expeditionLocationSpouse;
    }

    public void setExpeditionLocationSpouse(String expeditionLocationSpouse) {
        this.expeditionLocationSpouse = expeditionLocationSpouse;
    }

    public long getPhoneSpouse() {
        return phoneSpouse;
    }

    public void setPhoneSpouse(long phoneSpouse) {
        this.phoneSpouse = phoneSpouse;
    }

    public int getSpouseBeneficiaryCode() {
        return spouseBeneficiaryCode;
    }

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

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder idSpouse(long idSpouse) {
            this.idSpouse = idSpouse;
            return this;
        }

        public Builder fullNameSpouse(String fullNameSpouse) {
            this.fullNameSpouse = fullNameSpouse;
            return this;
        }

        public Builder expeditionLocationSpouse(String expeditionLocationSpouse) {
            this.expeditionLocationSpouse = expeditionLocationSpouse;
            return this;
        }

        public Builder phoneSpouse(long phoneSpouse) {
            this.phoneSpouse = phoneSpouse;
            return this;
        }

        public Builder spouseBeneficiaryCode(int spouseBeneficiaryCode) {
            this.spouseBeneficiaryCode = spouseBeneficiaryCode;
            return this;
        }

        @Override
        public DTOBeneficiaryDetails build() {
            return new DTOBeneficiaryDetails(this);
        }

    }

}
