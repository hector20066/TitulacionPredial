package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

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
        super();
    }

    public DTOBeneficiaryCreate(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.expeditionLocation = builder.expeditionLocation;
        this.cadastralReference = builder.cadastralReference;
        this.propertyCode = builder.propertyCode;
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

    public static class Builder extends DTOBeneficiary.Builder<Builder> {

        private long id;
        private String name;
        private String lastName;
        private String expeditionLocation;
        private long cadastralReference;
        private int propertyCode;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        public Builder cadastralReference(long cadastralReference) {
            this.cadastralReference = cadastralReference;
            return this;
        }

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        @Override
        public DTOBeneficiaryCreate build() {
            return new DTOBeneficiaryCreate(this);
        }

    }

}
