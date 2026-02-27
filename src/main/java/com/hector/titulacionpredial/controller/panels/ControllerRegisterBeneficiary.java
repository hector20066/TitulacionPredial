package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.*;
import com.hector.titulacionpredial.exception.validation.*;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.model.enums.*;
import com.hector.titulacionpredial.observer.*;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

import javax.swing.*;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterBeneficiary implements Observer {

    private final RegisterBeneficiary registerBeneficiary;
    private final ViewBeneficiaries viewBeneficiaries;
    private final Subject subject;

    private final BeneficiaryFacade daoBeneficiary;
    private final SpouseFacade daoSpouse;
    private DTOSpouse dtoSpouse;

    public ControllerRegisterBeneficiary(RegisterBeneficiary registerBeneficiary, ViewBeneficiaries viewBeneficiaries, Subject subject) {
        this.registerBeneficiary = registerBeneficiary;
        this.viewBeneficiaries = viewBeneficiaries;
        this.subject = subject;

        this.subject.register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoSpouse = new SpouseImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        registerBeneficiary.setControllerRegister(e -> registerOrModifyBeneficiary());
        registerBeneficiary.setControllerCbo_department(e -> selectDepartment());
        registerBeneficiary.setControllerCbo_maritalStatus(e -> showSpouseDialog());
        registerBeneficiary.setControllerCbx_affectation(e -> affectationSelected());
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                int code = daoBeneficiary.getLastCode();
                SwingUtilities.invokeLater(() -> registerBeneficiary.loadFollowingCode(code + 1));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerBeneficiary));
            }
        }).start();
    }

    private void registerOrModifyBeneficiary() {
        try {
            String phone = registerBeneficiary.getTxt_phone().getText().trim();
            MaritalStatus maritalStatus = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();
            Department department = (Department) registerBeneficiary.getCbo_department().getSelectedItem();
            Municipalities municipality = (Municipalities) registerBeneficiary.getCbo_municipality().getSelectedItem();
            String neighborhood = registerBeneficiary.getTxt_neighborhood().getText().trim();
            String address = registerBeneficiary.getTxt_address().getText().trim().toUpperCase();
            String publication = registerBeneficiary.getTxt_publication().getText().trim();
            String crossing = registerBeneficiary.getTxa_crossing().getText().trim();
            String affectation = registerBeneficiary.getTxa_affectation().getText().trim();
            String code = registerBeneficiary.getTxt_followingCode().getText().trim();

            if (phone.length() > 10) {
                throw new MaxLengthExceededException("Teléfono", "10");
            }

            if (!NumericalValidationUtils.isNumeric(phone)) {
                throw new InvalidNumberInputException("Teléfono");
            }

            if (registerBeneficiary.isModify()) {
                modify(code, phone, department, municipality, maritalStatus, neighborhood, address, publication, crossing, affectation);
            } else {
                register(code, phone, department, municipality, maritalStatus, neighborhood, address, publication, crossing, affectation);
            }
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerBeneficiary);
        }
    }

    private void modify(String code, String phone, Department department, Municipalities municipality,
                        MaritalStatus maritalStatus, String neighborhood, String address, String publication,
                        String crossing, String affectation) throws InvalidInputException {

        if (isInvalidData(neighborhood, address)) {
            throw new EmptyFieldException("Barrio y Dirección");
        }

        int codeLong = Integer.parseInt(code);
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        doInBackgroundModify(codeLong, phoneLong, department, municipality, maritalStatus, neighborhood, address, publication,
                crossing, affectation);
    }

    private void doInBackgroundModify(int code, long phone, Department department, Municipalities municipality, MaritalStatus maritalStatus,
                                      String neighborhood, String address, String publication, String crossing, String affectation) {
        new Thread(() -> {
            try {
                boolean success = daoBeneficiary.modify(department, municipality, address, maritalStatus, affectation, phone,
                        crossing, publication, neighborhood, code);

                if (registerBeneficiary.getNowStatus() == MaritalStatus.CASADO || registerBeneficiary.getNowStatus() == MaritalStatus.UNION_LIBRE) {
                    if (maritalStatus == MaritalStatus.SOLTERO || maritalStatus == MaritalStatus.DIVORCIADO || maritalStatus == MaritalStatus.VIUDO) {
                        daoSpouse.delete(code);
                    }
                }

                SwingUtilities.invokeLater(() -> runInvokeLaterModify(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerBeneficiary));
            }
        }).start();
    }

    private void runInvokeLaterModify(boolean success) {
        if (success) {
            MessageUtils.informationMessage("Se ha modificado la información del beneficiario.", registerBeneficiary);
            subject.notifyObservers();
            NavigatorUtils.showForms(viewBeneficiaries);
            registerBeneficiary.clearFields();
        } else {
            MessageUtils.errorMessage("Ha ocurrido un inconveniente. Por favor inténtelo nuevamente.", registerBeneficiary);
        }
    }

    private void register(String code, String phone, Department department, Municipalities municipality,
                          MaritalStatus maritalStatus, String neighborhood, String address, String publication,
                          String crossing, String affectation) throws InvalidInputException {

        String name = registerBeneficiary.getTxt_name().getText().trim();
        String lastName = registerBeneficiary.getTxt_lastName().getText().trim();
        String id = registerBeneficiary.getTxt_id().getText().trim();
        String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
        String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();

        validations(name, lastName, id, phone, cadastralReference, expeditionLocation, neighborhood, address);

        String fullName = name + " " + lastName;
        int codeInt = Integer.parseInt(code);
        long idLong = Long.parseLong(id);
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        prepareUI();
        doInBackGround(fullName, codeInt, idLong, phoneLong, department, municipality, maritalStatus, expeditionLocation,
                neighborhood, address, cadastralReference, publication, crossing, affectation);
    }

    private void validations(String name, String lastName, String id, String phone, String cadastralReference,
                             String expeditionLocation, String neighborhood, String address) throws InvalidInputException {

        if (isInvalidData(name, lastName, id, expeditionLocation, neighborhood, address, cadastralReference)) {
            throw new EmptyFieldException("Nombre, Apellido, Cedula, Lugar de Expedición, Barrio, Dirección "
                    + "y Referencia Catastral");
        }

        if (lastName.split(" ").length < 2) {
            throw new InvalidInputException("Por favor ingrese los dos Apellidos del beneficiario");
        }

        if (!NumericalValidationUtils.isNumeric(id) || !NumericalValidationUtils.isNumeric(cadastralReference)) {
            throw new InvalidNumberInputException("Cedula y Referencia Catastral");
        }

        if (id.length() > 10) {
            throw new MaxLengthExceededException("Cedula", "10");
        }
    }

    private boolean isInvalidData(String... fields) {
        for (String field : fields) {
            if (field.isBlank()) {
                return true;
            }
        }

        return false;
    }

    private void prepareUI() {
        registerBeneficiary.getBtn_register().setText("Registrando Beneficiario...");
        registerBeneficiary.getBtn_register().setEnabled(false);
    }

    private void doInBackGround(String fullName, int code, long id, long phone, Department department, Municipalities municipalities,
                                MaritalStatus maritalStatus, String expeditionLocation, String neighborhood, String address,
                                String cadastralReference, String publication, String crossing, String affectation) {
        new Thread(() -> {
            try {
                if (daoBeneficiary.findById(id) != null || daoBeneficiary.findByName(fullName) != null) {
                    throw new PersistenceException("Este usuario ya se encuentra registrado.");
                }

                daoBeneficiary.add(id, fullName, department, municipalities, address, cadastralReference, maritalStatus,
                        affectation, phone, crossing, publication, neighborhood, expeditionLocation);

                if (maritalStatus == MaritalStatus.CASADO || maritalStatus == MaritalStatus.UNION_LIBRE) {
                    registerSpouse(code);
                }

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerBeneficiary));
            }
        }).start();
    }

    private void registerSpouse(int beneficiaryCode) throws DAOException {
        if (dtoSpouse == null) {
            throw new DataNotFoundException("No se han encontrado registros del conjugue.");
        }

        daoSpouse.add(dtoSpouse.getId(), dtoSpouse.getFullName(), dtoSpouse.getExpeditionLocation(), dtoSpouse.getAddress(),
                dtoSpouse.getPhone(), beneficiaryCode);
    }

    private void runInvokeLater() {
        resetUI();
        MessageUtils.informationMessage("Se ha registrado la información del beneficiario en la base de datos", registerBeneficiary);
        subject.notifyObservers();
    }

    private void resetUI() {
        registerBeneficiary.getBtn_register().setEnabled(true);
        registerBeneficiary.getBtn_register().setText("AGREGAR BENEFICIARIO");
        registerBeneficiary.clearFields();
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
        if (registerBeneficiary.isLoading()) return;
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
    }

    private void affectationSelected() {
        registerBeneficiary.getTxa_affectation().setEditable(registerBeneficiary.getCbx_affectation().isSelected());
    }

}
