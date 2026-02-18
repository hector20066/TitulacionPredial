package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterBeneficiary {

    private final RegisterBeneficiary registerBeneficiary;

    public ControllerRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;

        connectEvents();
    }

    private void connectEvents() {
        registerBeneficiary.setControllerRegister(e -> registerBeneficiary());
        registerBeneficiary.setControllerCbo_department(e -> selectDepartment());
        registerBeneficiary.setControllerCbo_maritalStatus(e -> registerSpouse());
    }

    private void registerBeneficiary() {
        try {

        } catch (Exception e) {

        }
    }

    private void selectDepartment() {
        try {

        } catch (Exception e) {

        }
    }

    private void registerSpouse() {
        try {

        } catch (Exception e) {

        }
    }

}
