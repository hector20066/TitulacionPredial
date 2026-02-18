package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Spouse extends Person {

    private Beneficiary beneficiary;

    public Spouse() {

    }

    public Spouse(Beneficiary beneficiary) {
        super();
        this.beneficiary = beneficiary;
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

}
