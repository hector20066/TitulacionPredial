/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Spouse extends Person {

    private Beneficiary codeBeneficiary;

    public Spouse() {

    }

    public Spouse(long id, String name, String lastName, String address, String expeditionLocation, long phone, Beneficiary codeBeneficiary) {
        super(id, name, lastName, address, expeditionLocation, phone);
        this.codeBeneficiary = codeBeneficiary;
    }

    public void setCodeBeneficiary(Beneficiary codeBeneficiary) {
        this.codeBeneficiary = codeBeneficiary;
    }

    public Beneficiary getCodeBeneficiary() {
        return codeBeneficiary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCode Beneficiary= " + codeBeneficiary;
    }
}
