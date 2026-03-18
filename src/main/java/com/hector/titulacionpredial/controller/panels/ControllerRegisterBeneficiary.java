package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.builder.ControllerRegisterBeneficiaryBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.exception.validation.MaxLengthExceededException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.facade.interfaces.SpouseFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterBeneficiaryText;

import javax.swing.*;

/**
 * Controller of the beneficiary registration and modification panel.
 *
 * <p>
 * Implement {@link Observer} to update the sequential code for the
 * next beneficiary and {@link LanguageObserver} to update the interface
 * when a language change occurs. Manage form data validations,
 * beneficiary registration and modification, including spouse management
 * when required by marital status.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see RegisterBeneficiary
 * @see BeneficiaryFacade
 * @see SpouseFacade
 * @since 1.0
 */
public class ControllerRegisterBeneficiary implements Observer, LanguageObserver {

    private final RegisterBeneficiary registerBeneficiary;
    private final ViewBeneficiaries viewBeneficiaries;
    private final ControllerLogin controllerLogin;
    private final Subject subject;
    private final LanguageManager lang;

    private final BeneficiaryFacade daoBeneficiary;
    private final PropertyFacade daoProperty;
    private final SpouseFacade daoSpouse;
    private DTOSpouse dtoSpouse;

    /**
     * Create the controller, register it as an observer, and
     * connect the form events.
     *
     * @param builder constructor with configured views
     */
    public ControllerRegisterBeneficiary(ControllerRegisterBeneficiaryBuilder builder) {
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.controllerLogin = builder.getControllerLogin();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.subject.register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.daoSpouse = new SpouseImplFacade();

        connectEvents();
    }

    /**
     * Connect the form component events with their respective
     * action methods.
     */
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

    @Override
    public void updateLanguage() {
        DTORegisterBeneficiaryText dto = new DTORegisterBeneficiaryText.Builder()
                .modifyTitle(lang.app("register.beneficiary.modify.title"))
                .modifyBtn(lang.app("register.beneficiary.modify.btn"))
                .addTitle(lang.app("register.beneficiary.add.title"))
                .addBtn(lang.app("register.beneficiary.add.btn"))
                .beneficiaryInfo(lang.app("register.beneficiary.info"))
                .fullName(lang.app("register.beneficiary.name"))
                .phone(lang.app("register.beneficiary.phone"))
                .id(lang.app("register.beneficiary.id"))
                .maritalStatus(lang.app("register.beneficiary.maritalStatus"))
                .residenceData(lang.app("register.beneficiary.residence.data"))
                .department(lang.app("register.beneficiary.department"))
                .municipality(lang.app("register.beneficiary.municipality"))
                .neighborhood(lang.app("register.beneficiary.neighborhood"))
                .address(lang.app("register.beneficiary.address"))
                .cadastralRef(lang.app("register.beneficiary.cadastralRef"))
                .crossing(lang.app("register.beneficiary.crossing"))
                .affectation(lang.app("register.beneficiary.affectation"))
                .expeditionLocation(lang.app("register.beneficiary.expeditionLocate"))
                .publication(lang.app("register.beneficiary.publication"))
                .affected(lang.app("register.beneficiary.affected"))
                .code(lang.app("register.beneficiary.code"))
                .build();

        registerBeneficiary.updateLanguage(dto);
    }

    /**
     * Determine whether the action is to register or modify a
     * beneficiary and delegate to the corresponding method.
     *
     * <p>
     * Extract the common data from the form (phone, marital status,
     * department, municipality, neighborhood, address, etc.) and
     * validate the phone number before continuing.
     * </p>
     */
    private void registerOrModifyBeneficiary() {
        try {
            String fullName = registerBeneficiary.getTxt_fullName().getText().trim();
            String id = registerBeneficiary.getTxt_id().getText().trim();
            String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
            String phone = registerBeneficiary.getTxt_phone().getText().trim();
            MaritalStatus maritalStatus = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();
            String affectation = registerBeneficiary.getTxa_affectation().getText().trim();
            String codeBeneficiaries = registerBeneficiary.getTxt_followingCode().getText().trim().toUpperCase();

            validations(fullName, id, expeditionLocation, phone, codeBeneficiaries);

            if (registerBeneficiary.isModify()) {
                modify(fullName, id, expeditionLocation, codeBeneficiaries, phone, maritalStatus, affectation);
            } else {
                register(fullName, id, expeditionLocation, codeBeneficiaries, phone, maritalStatus, affectation);
            }
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerBeneficiary);
        }
    }

    /**
     * Validate the required fields in the registration form.
     *
     * <p>
     * Verify that they are not empty, that the surname has two parts,
     * that the ID and cadastral reference are numeric, and that the ID
     * does not exceed 10 characters.
     * </p>
     *
     * @param fullName           full name
     * @param id                 national identity card
     * @param expeditionLocation place of expedition
     * @throws InvalidInputException if any validation fails
     */
    private void validations(String fullName, String id, String expeditionLocation, String phone,
                             String codeBeneficiaries) throws InvalidInputException {
        if (isInvalidData(fullName, id, expeditionLocation, codeBeneficiaries)) {
            throw new EmptyFieldException(lang.message("empty.beneficiary.general"));
        }

        if (!codeBeneficiaries.contains("F")) {
            throw new InvalidInputException("Por favor ingrese el codigo con el formato correcto: FXXXX");
        }

        if (phone.length() > 10) {
            throw new MaxLengthExceededException(lang.message("max.length.beneficiary.phone"), "10");
        }

        if (id.length() > 10) {
            throw new MaxLengthExceededException(lang.message("max.length.beneficiary.id"), "10");
        }

        if (!NumericalValidationUtils.isNumeric(phone)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.phone"));
        }

        if (!NumericalValidationUtils.isNumeric(id)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.id.cadastralRef"));
        }
    }

    /**
     * Validate and prepare the data for the beneficiary modification.
     *
     * @param codeBeneficiaries beneficiary code
     * @param phone         contact phone number
     * @param maritalStatus marital status
     * @param affectation   affectation
     * @throws InvalidInputException if the data is invalid
     */
    private void modify(String fullName, String id, String expeditionLocation, String codeBeneficiaries,
                        String phone, MaritalStatus maritalStatus, String affectation) throws InvalidInputException {
        int modifyCode = registerBeneficiary.getModifyCode();
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        prepareUI(true);
        doInBackgroundModify(fullName, id, expeditionLocation, codeBeneficiaries, phoneLong, maritalStatus, affectation, modifyCode);
    }

    /**
     * Execute the beneficiary modification in a background thread.
     *
     * <p>
     * In addition to updating the beneficiary's data, it manages
     * the removal of the spouse if the marital status changed to
     * one that does not require it.
     * </p>
     *
     * @param phone         contact phone number
     * @param maritalStatus new marital status
     * @param affectation   affectation
     */
    private void doInBackgroundModify(String fullName, String id, String expeditionLocation, String codeBeneficiaries, long phone,
                                      MaritalStatus maritalStatus, String affectation, int modifyCode) {
        new Thread(() -> {
            try {
                boolean success = daoBeneficiary.modify(Integer.parseInt(id), codeBeneficiaries, fullName, maritalStatus,
                        affectation, phone, expeditionLocation, modifyCode);

                if (registerBeneficiary.getNowStatus() == MaritalStatus.MARRIED
                        || registerBeneficiary.getNowStatus() == MaritalStatus.FREE_UNION) {

                    if (maritalStatus == MaritalStatus.SINGLE || maritalStatus == MaritalStatus.DIVORCED
                            || maritalStatus == MaritalStatus.WIDOWER) {
                        daoSpouse.delete(modifyCode);
                    }
                }

                SwingUtilities.invokeLater(() -> runInvokeLaterModify(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), registerBeneficiary);
                    resetButton(true);
                });
            }
        }).start();
    }

    /**
     * Update the interface after completing the modification.
     *
     * <p>
     * If the operation was successful, it displays a confirmation
     * message, notifies observers, and navigates to the list of
     * beneficiaries.
     * </p>
     *
     * @param success {@code true} if the modification was successful
     */
    private void runInvokeLaterModify(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.beneficiary.modify"), registerBeneficiary);
            subject.notifyObservers();
            NavigatorUtils.showForms(controllerLogin.jpl_Content(), viewBeneficiaries);
            registerBeneficiary.clearFields();
        } else {
            MessageUtils.errorMessage(lang.message("message.beneficiary.error.modify"), registerBeneficiary);
        }
    }

    /**
     * Check if any of the provided fields are empty.
     *
     * @param fields fields to validate
     * @return {@code true} if at least one field is blank
     */
    private boolean isInvalidData(String... fields) {
        for (String field : fields) {
            if (field.isBlank()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prepare the interface by disabling the registration
     * button and displaying upload text.
     *
     * @param isModify operation to be performed
     */
    private void prepareUI(boolean isModify) {
        if (isModify) {
            registerBeneficiary.getBtn_register().setText(lang.app("register.beneficiary.modify.btn.executor"));
        } else {
            registerBeneficiary.getBtn_register().setText(lang.app("controller.register.beneficiary.registering"));
        }

        registerBeneficiary.getBtn_register().setEnabled(false);
    }

    /**
     * Register the beneficiary and their spouse (if applicable)
     * in a background thread.
     *
     * <p>
     * Verify that there is no duplicate by ID or name, the beneficiary
     * persists and register the spouse when the civil status requires it.
     * </p>
     *
     * @param fullName           full name of the beneficiary
     * @param codeBeneficiaries  sequential code
     * @param id                 national identity card
     * @param phone              contact phone number
     * @param maritalStatus      marital status
     * @param expeditionLocation place of expedition
     * @param affectation        affectation
     */
    private void doInBackGroundRegister(String fullName, String codeBeneficiaries, long id, long phone, MaritalStatus maritalStatus,
                                String expeditionLocation, String affectation, String cadastralId, String address,
                                        Department department, Municipalities municipalities, String crossing, String neighborhood, String publication) {
        new Thread(() -> {
            try {
                if (daoBeneficiary.findById(id) != null || daoBeneficiary.findByName(fullName) != null) {
                    throw new PersistenceException(lang.message("persistence.beneficiary.exist"));
                }

                int propertyCode = daoProperty.add(cadastralId, address, department, municipalities, crossing, neighborhood, publication);
                int code = daoBeneficiary.add(codeBeneficiaries, id, fullName, maritalStatus, affectation, phone, expeditionLocation);

                if (maritalStatus == MaritalStatus.MARRIED || maritalStatus == MaritalStatus.FREE_UNION) {
                    registerSpouse(code);
                }

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), registerBeneficiary);
                    resetButton(false);
                });
            }
        }).start();
    }

    /**
     * Register the details of the spouse associated with the beneficiary.
     *
     * @param beneficiaryCode beneficiary code to which it is associated
     * @throws DAOException if no spouse data was found or if a persistence
     *                      error occurs
     */
    private void registerSpouse(int beneficiaryCode) throws DAOException {
        if (dtoSpouse == null) {
            throw new DataNotFoundException(lang.message("not.found.spouse.data"));
        }

        daoSpouse.add(dtoSpouse.getId(), dtoSpouse.getFullName(), dtoSpouse.getExpeditionLocation(),
                dtoSpouse.getPhone(), beneficiaryCode);
    }

    private void register(String fullName, String id, String expeditionLocation, String codeBeneficiaries, String phone,
                          MaritalStatus maritalStatus, String affectation) throws InvalidInputException {
        String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();
        Department department = (Department) registerBeneficiary.getCbo_department().getSelectedItem();
        Municipalities municipality = (Municipalities) registerBeneficiary.getCbo_municipality().getSelectedItem();
        String neighborhood = registerBeneficiary.getTxt_neighborhood().getText().trim();
        String address = registerBeneficiary.getTxt_address().getText().trim().toUpperCase();
        String publication = (String) registerBeneficiary.getCbo_publication().getSelectedItem();
        String crossing = registerBeneficiary.getTxa_crossing().getText().trim();

        prepareUI(false);
        doInBackGroundRegister(fullName, codeBeneficiaries, Long.parseLong(id), Long.parseLong(phone), maritalStatus,
                expeditionLocation, affectation, cadastralReference, address, department, municipality,
                crossing, neighborhood, publication);
    }

    /**
     * Displays the successful registration message, notifies observers,
     * and resets the interface.
     */
    private void runInvokeLater() {
        resetUI();
        MessageUtils.informationMessage(lang.message("message.beneficiary.register"), registerBeneficiary);
        subject.notifyObservers();
    }

    /**
     * Reset the registration button and clear the form fields.
     */
    private void resetUI() {
        resetButton(false);
        registerBeneficiary.clearFields();
    }

    /**
     * Resets the button to its default values.
     *
     * @param isModify operation to be performed
     */
    private void resetButton(boolean isModify) {
        registerBeneficiary.getBtn_register().setEnabled(true);

        if (isModify) {
            registerBeneficiary.getBtn_register().setText(lang.app("register.beneficiary.modify.btn"));
        } else {
            registerBeneficiary.getBtn_register().setText(lang.app("controller.register.beneficiary.add"));
        }
    }

    /**
     * Update the municipality combo according to the department
     * selected by the user.
     */
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

    /**
     * Displays the spouse data capture dialog when the marital
     * status is married or common-law union.
     *
     * <p>
     * If the user confirms the dialog, the spouse's DTO is stored.
     * If the user changes to a marital status without a spouse,
     * the reference is cleared.
     * </p>
     */
    private void showSpouseDialog() {
        if (registerBeneficiary.isLoading()) return;
        MaritalStatus selected = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();

        if (selected == MaritalStatus.MARRIED || selected == MaritalStatus.FREE_UNION) {
            java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerBeneficiary);

            SpouseData dialog = new SpouseData(parentFrame, true);
            dialog.setLocationRelativeTo(registerBeneficiary);
            dialog.updateLanguage();
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                this.dtoSpouse = dialog.getSpouse();
            }
        } else {
            this.dtoSpouse = null;
        }
    }

    /**
     * Enables or disables the affected field according
     * to the checkbox status.
     */
    private void affectationSelected() {
        registerBeneficiary.getTxa_affectation().setEditable(registerBeneficiary.getCbx_affectation().isSelected());
    }

}
