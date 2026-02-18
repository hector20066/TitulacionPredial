package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Spouse extends Person {

    private Beneficiary beneficiary;

    public Spouse() {

    }

    public Spouse(Builder builder) {
        super(builder);
        this.beneficiary = builder.beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCode Beneficiary= " + beneficiary;
    }

    public static class Builder extends Person.Builder<Builder> {

        private Beneficiary beneficiary;

        public Builder beneficiary(Beneficiary beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

        @Override
        public Spouse build() {
            return new Spouse(this);
        }

    }

}
