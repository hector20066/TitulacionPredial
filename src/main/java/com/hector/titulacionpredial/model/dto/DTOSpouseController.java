package com.hector.titulacionpredial.model.dto;

public class DTOSpouseController extends DTOSpouse {

    private int idBeneficiary;

    public DTOSpouseController() {

    }

    public DTOSpouseController(Builder builder) {
        super(builder);
        this.idBeneficiary = builder.idBeneficiary;
    }

    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    public static class Builder extends DTOSpouse.AbstractBuilder<Builder> {

        private int idBeneficiary;

        public Builder idBeneficiary(int idBeneficiary) {
            this.idBeneficiary = idBeneficiary;
            return this;
        }

        public DTOSpouseController build() {
            return new DTOSpouseController(this);
        }

    }

}
