package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;

import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterBeneficiary implements Observer {

    private final RegisterBeneficiary registerBeneficiary;
    private final Subject subject;

    private final BeneficiaryFacade daoBeneficiary;
    private final SpouseFacade daoSpouse;
    private DTOSpouse dtoSpouse;

    public ControllerRegisterBeneficiary(RegisterBeneficiary registerBeneficiary, Subject subject) {
        this.registerBeneficiary = registerBeneficiary;
        this.subject = subject;

        this.subject.register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoSpouse = new SpouseImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        registerBeneficiary.setControllerRegister(e -> registerBeneficiary());
        registerBeneficiary.setControllerCbo_department(e -> selectDepartment());
        registerBeneficiary.setControllerCbo_maritalStatus(e -> showSpouseDialog());
    }

    @Override
    public void update() {

    }

    private void registerBeneficiary() {
        try {
            String name = registerBeneficiary.getTxt_name().getText().trim();
            String lastName = registerBeneficiary.getTxt_lastName().getText().trim();
            String id = registerBeneficiary.getTxt_id().getText().trim();
            String phone = registerBeneficiary.getTxt_phone().getText().trim();
            MaritalStatus maritalStatus = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();
            String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
            Department department = (Department) registerBeneficiary.getCbo_department().getSelectedItem();
            Municipalities municipality = (Municipalities) registerBeneficiary.getCbo_municipality().getSelectedItem();
            String neighborhood = registerBeneficiary.getTxt_neighborhood().getText().trim();
            String address = registerBeneficiary.getTxt_address().getText().trim();
            String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();
            String publication = registerBeneficiary.getTxt_publication().getText().trim();
            String crossing = registerBeneficiary.getTxa_crossing().getText().trim();
            String affectation = registerBeneficiary.getTxa_affectation().getText().trim();
            String code = registerBeneficiary.getTxt_followingCode().getText().trim();

            if (isInvalidData(name, lastName, id, phone, expeditionLocation, neighborhood, address, cadastralReference, publication, crossing, affectation)) {
                return;
            }

            String fullName = name + " " + lastName;
            int codeInt = Integer.parseInt(code);
            long idLong = Long.parseLong(id);
            long phoneLong = Long.parseLong(phone);
            long cadastralReferenceLong = Long.parseLong(cadastralReference);

            prepareUI();
            doInBackGround(fullName, codeInt, idLong, phoneLong, department, municipality, maritalStatus, expeditionLocation, neighborhood, address, cadastralReferenceLong, publication, crossing, affectation);
        } catch (Exception e) {

        }
    }

    private boolean isInvalidData(String name, String lastName, String id, String phone, String expeditionLocation, String neighborhood, String address, String cadastralReference, String publication, String crossing, String affectation) {
        return name.isBlank() || lastName.isBlank() || id.isBlank() || phone.isBlank() || expeditionLocation.isBlank() || neighborhood.isBlank() || address.isBlank() || cadastralReference.isBlank() || publication.isBlank() || crossing.isBlank() || affectation.isBlank();
    }

    private void prepareUI() {
        registerBeneficiary.getBtn_register().setText("Registrando Beneficiario...");
        registerBeneficiary.getBtn_register().setEnabled(false);
    }

    private void doInBackGround(String fullName, int code, long id, long phone, Department department, Municipalities municipalities, MaritalStatus maritalStatus, String expeditionLocation, String neighborhood, String address, long cadastralReference, String publication, String crossing, String affectation) {
        new Thread(() -> {
            try {
                if (daoBeneficiary.findById(id) != null || daoBeneficiary.findByName(fullName) != null) {
                    throw new Exception("Ya existe un usuario con este numero de cedula");
                }

                if (maritalStatus == MaritalStatus.CASADO || maritalStatus == MaritalStatus.UNION_LIBRE) {
                    registerSpouse(code);
                }

                daoBeneficiary.add(id, fullName, department, municipalities, address, cadastralReference, maritalStatus, affectation, phone, crossing, publication, neighborhood, expeditionLocation);

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void registerSpouse(int beneficiaryCode) throws Exception {
        if (dtoSpouse == null) {
            throw new Exception("No se han encontrado registros del conyugue.");
        }

        daoSpouse.add(dtoSpouse.getId(), dtoSpouse.getFullName(), dtoSpouse.getExpeditionLocation(), dtoSpouse.getAddress(), dtoSpouse.getPhone(), beneficiaryCode);
    }

    private void runInvokeLater() {
        resetUI();
        MessageUtils.informationMessage("Se ha registrado la informacion del beneficiario en la base de datos", registerBeneficiary);
    }

    private void resetUI() {
        registerBeneficiary.getBtn_register().setEnabled(true);
        registerBeneficiary.getBtn_register().setText("AGREGAR BENEFICIARIO");
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
