package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;

import javax.swing.*;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterBeneficiary {

    private final RegisterBeneficiary registerBeneficiary;

    private DTOSpouse dtoSpouse;

    public ControllerRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;

        connectEvents();
    }

    private void connectEvents() {
        registerBeneficiary.setControllerRegister(e -> registerBeneficiary());
        registerBeneficiary.setControllerCbo_department(e -> selectDepartment());
        registerBeneficiary.setControllerCbo_maritalStatus(e -> showSpouseDialog());
    }

    private void registerBeneficiary() {
        try {
            /*Beneficiary beneficiary = new Beneficiary.Builder()
                    .code(Integer.parseInt(registerBeneficiary.getTxt_followingCode().getText().trim()))
                    .name(registerBeneficiary.getTxt_name().getText().trim())
                    .lastName(registerBeneficiary.getTxt_lastName().getText().trim())
                    .id(Long.parseLong(registerBeneficiary.getTxt_id().getText().trim()))
                    .phone(Long.parseLong(registerBeneficiary.getTxt_phone().getText().trim()))
                    .expeditionLocation(registerBeneficiary.getTxt_expeditionLocation().getText().trim())
                    .maritalStatus((MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem())
                    .department((Department) registerBeneficiary.getCbo_department().getSelectedItem())
                    // .municipality(...)
                    .neighborhood(registerBeneficiary.getTxt_neighborhood().getText().trim())
                    .address(registerBeneficiary.getTxt_address().getText().trim())
                    .cadastralReference(Long.parseLong(registerBeneficiary.getTxt_cadastralReference().getText().trim()))
                    .crossing(registerBeneficiary.getTxt_crossing().getText().trim())
                    .affectation(registerBeneficiary.getTxt_affectation().getText().trim())
                    .publication(registerBeneficiary.getTxt_publication().getText().trim())
                    .build();

            // Guardar beneficiario en BD (vía DAO)
            // daoBeneficiary.save(beneficiary);

            // Si hay datos del cónyuge, guardarlo vinculado al beneficiario
            if (spouseData != null) {
                spouseData.setBeneficiary(beneficiary);
                // daoSpouse.save(spouseData);
            }*/
        } catch (Exception e) {

        }
    }

    private void selectDepartment() {
        Department departmentSelected = (Department) registerBeneficiary.getCbo_department().getSelectedItem();

        if (departmentSelected == null) {
            return;
        }

        JComboBox<Municipalities> cboMunicipality = registerBeneficiary.getCbo_municipality();
        cboMunicipality.removeAllItems();

        for (Municipalities municipality : departmentSelected.getMunicipalities()) {
            cboMunicipality.addItem(municipality);
        }
    }

    private void showSpouseDialog() {
        try {
            MaritalStatus selected = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();

            if (selected == MaritalStatus.CASADO || selected == MaritalStatus.UNION_LIBRE) {
                java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerBeneficiary);

                SpouseData dialog = new SpouseData(parentFrame, true);
                dialog.setLocationRelativeTo(registerBeneficiary);
                dialog.setVisible(true);

                if (dialog.isConfirmed()) {
                    this.dtoSpouse = dialog.getSpouse();
                }
            } else {
                this.dtoSpouse = null;
            }
        } catch (Exception e) {

        }
    }

}
