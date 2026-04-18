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
import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.dto.DTOSpouse;
import com.hector.titulacionpredial.model.dto.DTOSpouseController;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.MaritalStatus;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.ValidationUtils;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterBeneficiaryText;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
public class ControllerRegisterBeneficiary implements LanguageObserver {

    private final RegisterBeneficiary registerBeneficiary;
    private final ViewBeneficiaries viewBeneficiaries;
    private final ControllerLogin controllerLogin;
    private final Subject subject;
    private final LanguageManager lang;

    private final BeneficiaryFacade daoBeneficiary;
    private final PropertyFacade daoProperty;
    private final SpouseFacade daoSpouse;

    private final List<DTOBeneficiary> listBeneficiaries;
    private final List<DTOSpouseController> listSpouses;

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

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.daoSpouse = new SpouseImplFacade();

        this.listBeneficiaries = new ArrayList<>();
        this.listSpouses = new ArrayList<>();

        connectEvents();
        builder.getLanguageSubject().register(this);
    }

    /**
     * Connect the form component events with their respective
     * action methods.
     */
    private void connectEvents() {
        registerBeneficiary.setControllerRegister(e -> registerOrModifyBeneficiary());
        registerBeneficiary.setControllerAddBeneficiaries(e -> addBeneficiaries());
        registerBeneficiary.setControllerCbo_department(e -> selectDepartment());
        registerBeneficiary.setControllerCbo_maritalStatus(e -> showSpouseDialog());
    }

    @Override
    public void updateLanguage() {
        DTORegisterBeneficiaryText dto = new DTORegisterBeneficiaryText.Builder()
                .modifyTitle(lang.app("register.beneficiary.modify.title"))
                .modifyBtn(lang.app("register.beneficiary.modify.btn"))
                .addTitle(lang.app("register.beneficiary.add.title"))
                .registerBtn(lang.app("register.beneficiary.register.btn"))
                .addBeneficiaryBtn(lang.app("register.beneficiary.btn.add"))
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
            if (registerBeneficiary.isModify()) {
                modify();
            } else {
                register();
            }
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerBeneficiary);
        }
    }

    /**
     * Validate and prepare the data for the beneficiary modification.
     *
     * @throws InvalidInputException if the data is invalid
     */
    private void modify() throws InvalidInputException {
        String fullName = registerBeneficiary.getTxt_fullName().getText().trim();
        String id = registerBeneficiary.getTxt_id().getText().trim();
        String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
        String phone = registerBeneficiary.getTxt_phone().getText().trim();
        MaritalStatus maritalStatus = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();
        String affectation = registerBeneficiary.getTxa_affectation().getText().trim();
        String codeBeneficiaries = registerBeneficiary.getTxt_followingCode().getText().trim().toUpperCase();
        int modifyCode = registerBeneficiary.getModifyCode();
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        Department department = (Department) registerBeneficiary.getCbo_department().getSelectedItem();
        Municipalities municipality = (Municipalities) registerBeneficiary.getCbo_municipality().getSelectedItem();
        String neighborhood = registerBeneficiary.getTxt_neighborhood().getText().trim();
        String address = registerBeneficiary.getTxt_address().getText().trim();
        String crossing = registerBeneficiary.getTxa_crossing().getText().trim();
        String publication = (String) registerBeneficiary.getCbo_publication().getSelectedItem();
        String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();

        validations(fullName, id, expeditionLocation, phone, codeBeneficiaries);
        prepareUI(true);
        doInBackgroundModify(fullName, id, expeditionLocation, codeBeneficiaries, phoneLong, maritalStatus, affectation,
                modifyCode, department, municipality, neighborhood, address, crossing, publication, cadastralReference);
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
    private void doInBackgroundModify(String fullName, String id, String expeditionLocation, String codeBeneficiaries,
                                      long phone, MaritalStatus maritalStatus, String affectation, int modifyCode,
                                      Department department, Municipalities municipalities, String neighborhood,
                                      String address, String crossing, String publication, String cadastralReference) {
        new Thread(() -> {
            try {
                boolean success = daoBeneficiary.modify(Long.parseLong(id), codeBeneficiaries, fullName, maritalStatus,
                        affectation, phone, expeditionLocation, modifyCode);

                if (registerBeneficiary.getNowStatus() == MaritalStatus.MARRIED
                        || registerBeneficiary.getNowStatus() == MaritalStatus.FREE_UNION) {

                    if (maritalStatus == MaritalStatus.SINGLE || maritalStatus == MaritalStatus.DIVORCED
                            || maritalStatus == MaritalStatus.WIDOWER) {
                        daoSpouse.delete(modifyCode);
                    }
                }

                boolean successModifyProperty = daoProperty.modifyBasicInformation(department, municipalities, neighborhood,
                        address, crossing, publication, cadastralReference);

                SwingUtilities.invokeLater(() -> runInvokeLaterModify(success, successModifyProperty));
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
    private void runInvokeLaterModify(boolean success, boolean successModifyProperty) {
        if (success && successModifyProperty) {
            MessageUtils.informationMessage(lang.message("message.beneficiary.modify"), registerBeneficiary);
            subject.notifyObservers();
            NavigatorUtils.showForms(controllerLogin.jpl_Content(), viewBeneficiaries);
            registerBeneficiary.clearFields();
            viewBeneficiaries.getBtn_modify().setEnabled(true);
            viewBeneficiaries.getBtn_modify().setText("Modificar");
        } else {
            MessageUtils.errorMessage(lang.message("message.beneficiary.error.modify"), registerBeneficiary);
        }
    }

    /**
     *  register.
     */
    private void register() {
        try {
            if (listBeneficiaries.isEmpty()) {
                MessageUtils.informationMessage("No hay beneficiarios para registrar.", registerBeneficiary);
            }

            String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();
            Department department = (Department) registerBeneficiary.getCbo_department().getSelectedItem();
            Municipalities municipality = (Municipalities) registerBeneficiary.getCbo_municipality().getSelectedItem();
            String neighborhood = registerBeneficiary.getTxt_neighborhood().getText().trim();
            String address = registerBeneficiary.getTxt_address().getText().trim().toUpperCase();
            String publication = (String) registerBeneficiary.getCbo_publication().getSelectedItem();
            String crossing = registerBeneficiary.getTxa_crossing().getText().trim();

            prepareUI(false);
            doInBackgroundRegister(cadastralReference, address, department, municipality, crossing, neighborhood,
                    publication);
        } catch (Exception e) {
            MessageUtils.warningMessage(e.getMessage(), registerBeneficiary);
        }
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
     *
     */
    private void doInBackgroundRegister(String cadastralId, String address, Department department,
                                        Municipalities municipalities, String crossing, String neighborhood,
                                        String publication) {
        new Thread(() -> {
            try {
                if (daoBeneficiary.findById(listBeneficiaries.getFirst().getId()) != null
                        || daoBeneficiary.findByName(listBeneficiaries.getFirst().getFullName()) != null) {
                    throw new PersistenceException(lang.message("persistence.beneficiary.exist"));
                }

                if (daoProperty.findByCode(cadastralId) != null) {
                    throw new PersistenceException(lang.message("persistence.property.exist1") + " '"
                            + cadastralId + "' " + lang.message("persistence.property.exist2"));
                }

                int propertyCode = daoProperty.add(cadastralId, address, department, municipalities, crossing,
                        neighborhood, publication);

                for (DTOBeneficiary dto : listBeneficiaries) {
                    int codeBeneficiary = daoBeneficiary.add(dto.getCodeBeneficiaries(), dto.getId(), dto.getFullName(),
                            dto.getMaritalStatus(), dto.getAffectation(), dto.getPhone(), dto.getExpeditionLocation(),
                            propertyCode);

                    if (dto.getMaritalStatus() == MaritalStatus.MARRIED || dto.getMaritalStatus() == MaritalStatus.FREE_UNION) {
                        listSpouses.stream()
                                .filter(spouse -> spouse.getIdBeneficiary() == dto.getId())
                                .findFirst()
                                .ifPresent(spouse -> {
                                    try {
                                        registerSpouse(spouse, codeBeneficiary);
                                    } catch (DAOException e) {
                                        MessageUtils.errorMessage(e.getMessage(), registerBeneficiary);
                                    }
                                });
                    }
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
    private void registerSpouse(DTOSpouseController dto, int beneficiaryCode) throws DAOException {
        if (listSpouses.isEmpty()) {
            throw new DataNotFoundException(lang.message("not.found.spouse.data"));
        }

        DTOSpouse dtoSpouse = new DTOSpouse.Builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .expeditionLocation(dto.getExpeditionLocation())
                .phone(dto.getPhone())
                .build();

        daoSpouse.add(dtoSpouse.getId(), dtoSpouse.getFullName(), dtoSpouse.getExpeditionLocation(),
                dtoSpouse.getPhone(), beneficiaryCode);
    }

    /**
     * Displays the successful registration message, notifies observers,
     * and resets the interface.
     */
    private void runInvokeLater() {
        resetUI();
        MessageUtils.informationMessage(lang.message("message.beneficiary.register"), registerBeneficiary);
        subject.notifyObservers();
        this.listBeneficiaries.clear();
        this.listSpouses.clear();
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
     *  add beneficiaries.
     */
    private void addBeneficiaries() {
        try {
            String fullName = registerBeneficiary.getTxt_fullName().getText().trim();
            String id = registerBeneficiary.getTxt_id().getText().trim();
            String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
            String phone = registerBeneficiary.getTxt_phone().getText().trim();
            MaritalStatus maritalStatus = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();
            String affectation = registerBeneficiary.getTxa_affectation().getText().trim();
            String codeBeneficiaries = registerBeneficiary.getTxt_followingCode().getText().trim().toUpperCase();

            validations(fullName, id, expeditionLocation, phone, codeBeneficiaries);

            DTOBeneficiary dto = new DTOBeneficiary.ConcreteBuilder()
                    .id(Integer.parseInt(id))
                    .fullName(fullName)
                    .expeditionLocation(expeditionLocation)
                    .phone(Long.parseLong(phone))
                    .maritalStatus(maritalStatus)
                    .affectation(affectation)
                    .codeBeneficiaries(codeBeneficiaries)
                    .build();

            listBeneficiaries.add(dto);
            cleanUIAddBeneficiaries();

            if (!listBeneficiaries.isEmpty()) {
                registerBeneficiary.getBtn_register().setEnabled(true);
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
        if (ValidationUtils.isEmptyFields(fullName, id, expeditionLocation, codeBeneficiaries)) {
            throw new EmptyFieldException(lang.message("empty.beneficiary.general"));
        }

        if (!codeBeneficiaries.contains("F")) {
            throw new InvalidInputException(lang.message("invalid.input.beneficiary.code"));
        }

        if (phone.length() > 10) {
            throw new MaxLengthExceededException(lang.message("max.length.beneficiary.phone"), "10");
        }

        if (id.length() > 10) {
            throw new MaxLengthExceededException(lang.message("max.length.beneficiary.id"), "10");
        }

        if (!ValidationUtils.isNumeric(phone)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.phone"));
        }

        if (!ValidationUtils.isNumeric(id)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.id"));
        }
    }

    /**
     * Clear all input fields in the beneficiary registration form.
     *
     * <p>
     * Resets text fields, combo boxes, and text areas to their
     * default empty state for a new registration entry.
     * </p>
     */
    private void cleanUIAddBeneficiaries() {
        registerBeneficiary.getTxt_fullName().setText("");
        registerBeneficiary.getTxt_id().setText("");
        registerBeneficiary.getTxt_expeditionLocation().setText("");
        registerBeneficiary.getTxt_phone().setText("");
        registerBeneficiary.getCbo_maritalStatus().setSelectedIndex(0);
        registerBeneficiary.getTxa_affectation().setText("");
    }

    /**
     * Update the municipality combo according to the department
     * selected by the user.
     */
    private void selectDepartment() {
        try {
            Department departmentSelected = (Department) registerBeneficiary.getCbo_department().getSelectedItem();

            JComboBox<Municipalities> cboMunicipality = registerBeneficiary.getCbo_municipality();
            cboMunicipality.removeAllItems();

            if (departmentSelected == null) {
                throw new EmptyFieldException("Departamento");
            }

            for (Municipalities municipality : departmentSelected.getMunicipalities()) {
                cboMunicipality.addItem(municipality);
            }
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerBeneficiary);
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
        try {
            if (registerBeneficiary.isLoading()) return;
            MaritalStatus selected = (MaritalStatus) registerBeneficiary.getCbo_maritalStatus().getSelectedItem();

            String affectationMarriedOrFreeUnion = lang.app("register.beneficiary.affectation.desc");

            if (selected == MaritalStatus.MARRIED || selected == MaritalStatus.FREE_UNION) {
                String idBeneficiary = registerBeneficiary.getTxt_id().getText().trim();
                registerBeneficiary.getTxa_affectation().setText(affectationMarriedOrFreeUnion);

                if (idBeneficiary.isBlank()) {
                    throw new EmptyFieldException("Cedula");
                }

                if (!ValidationUtils.isNumeric(idBeneficiary)) {
                    throw new InvalidNumberInputException("Cedula");
                }

                java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerBeneficiary);

                SpouseData dialog = new SpouseData(parentFrame, true);
                dialog.setLocationRelativeTo(registerBeneficiary);
                dialog.updateLanguage();
                dialog.setIdBeneficiary(Integer.parseInt(idBeneficiary));
                dialog.setVisible(true);

                if (dialog.isConfirmed()) {
                    listSpouses.add(dialog.getSpouse());
                }
            }
        } catch (InvalidInputException e) {
            MessageUtils.errorMessage(e.getMessage(), registerBeneficiary);
        }
    }

}
