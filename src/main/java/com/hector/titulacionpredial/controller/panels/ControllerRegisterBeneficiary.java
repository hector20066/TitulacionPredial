package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.builder.ControllerRegisterBeneficiaryBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.DataNotFoundException;
import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.exception.validation.MaxLengthExceededException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.SpouseImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
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
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterBeneficiaryText;

import javax.swing.*;

/**
 * Controlador del panel de registro y modificación de beneficiarios.
 *
 * <p>
 * Implementa {@link Observer} para actualizar el código
 * secuencial del próximo beneficiario y {@link LanguageObserver}
 * para actualizar la interfaz cuado se realiza un cambio de idioma.
 * Gestiona las validaciones de los datos del formulario, el registro
 * y la modificación de beneficiarios, incluyendo la gestión del
 * cónyuge cuando el estado civil lo requiere.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see RegisterBeneficiary
 * @see BeneficiaryFacade
 * @see SpouseFacade
 * @since 1.0
 */
public class ControllerRegisterBeneficiary implements Observer, LanguageObserver {

    /**
     * Vista del formulario de registro.
     */
    private final RegisterBeneficiary registerBeneficiary;

    /**
     * Vista de listado de beneficiarios.
     */
    private final ViewBeneficiaries viewBeneficiaries;

    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

    /**
     * Acceso al gestor de los idiomas.
     */
    private final LanguageManager lang;

    /**
     * Fachada de acceso a datos de beneficiarios.
     */
    private final BeneficiaryFacade daoBeneficiary;

    /**
     * Fachada de acceso a datos de cónyuges.
     */
    private final SpouseFacade daoSpouse;

    /**
     * Datos del cónyuge capturados desde el diálogo.
     */
    private DTOSpouse dtoSpouse;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del formulario.
     *
     * @param builder constructor con las vistas configuradas
     */
    public ControllerRegisterBeneficiary(ControllerRegisterBeneficiaryBuilder builder) {
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.subject.register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoSpouse = new SpouseImplFacade();

        connectEvents();
    }

    /**
     * Conecta los eventos de los componentes del formulario
     * con sus respectivos métodos de acción.
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
                .name(lang.app("register.beneficiary.name"))
                .phone(lang.app("register.beneficiary.phone"))
                .lastName(lang.app("register.beneficiary.lastname"))
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
     * Determina si la acción es registrar o modificar un beneficiario
     * y delega al método correspondiente.
     *
     * <p>
     * Extrae los datos comunes del formulario (teléfono, estado civil,
     * departamento, municipio, barrio, dirección, etc.) y valida
     * el teléfono antes de continuar.
     * </p>
     */
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
                throw new MaxLengthExceededException(lang.message("max.length.beneficiary.phone"), "10");
            }

            if (!NumericalValidationUtils.isNumeric(phone)) {
                throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.phone"));
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

    /**
     * Valida y prepara los datos para la modificación del beneficiario.
     *
     * @param code          código del beneficiario
     * @param phone         teléfono de contacto
     * @param department    departamento seleccionado
     * @param municipality  municipio seleccionado
     * @param maritalStatus estado civil
     * @param neighborhood  barrio
     * @param address       dirección
     * @param publication   publicación
     * @param crossing      cruce
     * @param affectation   afectación
     * @throws InvalidInputException si los datos son inválidos
     */
    private void modify(String code, String phone, Department department, Municipalities municipality,
                        MaritalStatus maritalStatus, String neighborhood, String address, String publication,
                        String crossing, String affectation) throws InvalidInputException {

        if (isInvalidData(neighborhood, address)) {
            throw new EmptyFieldException(lang.message("empty.beneficiary.neighborhood.address"));
        }

        int codeLong = Integer.parseInt(code);
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        doInBackgroundModify(codeLong, phoneLong, department, municipality, maritalStatus, neighborhood, address, publication,
                crossing, affectation);
    }

    /**
     * Ejecuta la modificación del beneficiario en un hilo de fondo.
     *
     * <p>
     * Además de actualizar los datos del beneficiario, gestiona
     * la eliminación del cónyuge si el estado civil cambió a uno
     * que no lo requiere.
     * </p>
     *
     * @param code          código del beneficiario
     * @param phone         teléfono de contacto
     * @param department    departamento
     * @param municipality  municipio
     * @param maritalStatus nuevo estado civil
     * @param neighborhood  barrio
     * @param address       dirección
     * @param publication   publicación
     * @param crossing      cruce
     * @param affectation   afectación
     */
    private void doInBackgroundModify(int code, long phone, Department department, Municipalities municipality,
                                      MaritalStatus maritalStatus, String neighborhood, String address, String publication,
                                      String crossing, String affectation) {
        new Thread(() -> {
            try {
                boolean success = daoBeneficiary.modify(department, municipality, address, maritalStatus, affectation, phone,
                        crossing, publication, neighborhood, code);

                if (registerBeneficiary.getNowStatus() == MaritalStatus.MARRIED
                        || registerBeneficiary.getNowStatus() == MaritalStatus.FREE_UNION) {

                    if (maritalStatus == MaritalStatus.SINGLE || maritalStatus == MaritalStatus.DIVORCED
                            || maritalStatus == MaritalStatus.WIDOWER) {
                        daoSpouse.delete(code);
                    }
                }

                SwingUtilities.invokeLater(() -> runInvokeLaterModify(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerBeneficiary));
            }
        }).start();
    }

    /**
     * Actualiza la interfaz tras completar la modificación.
     *
     * <p>
     * Si la operación fue exitosa, muestra un mensaje de confirmación,
     * notifica a los observadores y navega al listado de beneficiarios.
     * </p>
     *
     * @param success {@code true} si la modificación fue exitosa
     */
    private void runInvokeLaterModify(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.beneficiary.modify"), registerBeneficiary);
            subject.notifyObservers();
            NavigatorUtils.showForms(viewBeneficiaries);
            registerBeneficiary.clearFields();
        } else {
            MessageUtils.errorMessage(lang.message("message.beneficiary.error.modify"), registerBeneficiary);
        }
    }

    /**
     * Valida y prepara los datos para el registro de un nuevo beneficiario.
     *
     * @param code          código secuencial del beneficiario
     * @param phone         teléfono de contacto
     * @param department    departamento seleccionado
     * @param municipality  municipio seleccionado
     * @param maritalStatus estado civil
     * @param neighborhood  barrio
     * @param address       dirección
     * @param publication   publicación
     * @param crossing      cruce
     * @param affectation   afectación
     * @throws InvalidInputException si los datos son inválidos
     */
    private void register(String code, String phone, Department department, Municipalities municipality,
                          MaritalStatus maritalStatus, String neighborhood, String address, String publication,
                          String crossing, String affectation) throws InvalidInputException {

        String name = registerBeneficiary.getTxt_name().getText().trim();
        String lastName = registerBeneficiary.getTxt_lastName().getText().trim();
        String id = registerBeneficiary.getTxt_id().getText().trim();
        String expeditionLocation = registerBeneficiary.getTxt_expeditionLocation().getText().trim();
        String cadastralReference = registerBeneficiary.getTxt_cadastralReference().getText().trim();

        validations(name, lastName, id, cadastralReference, expeditionLocation, neighborhood, address);

        String fullName = name + " " + lastName;
        int codeInt = Integer.parseInt(code);
        long idLong = Long.parseLong(id);
        long phoneLong = phone.isEmpty() ? 0 : Long.parseLong(phone);

        prepareUI();
        doInBackGround(fullName, codeInt, idLong, phoneLong, department, municipality, maritalStatus, expeditionLocation,
                neighborhood, address, cadastralReference, publication, crossing, affectation);
    }

    /**
     * Valida los campos obligatorios del formulario de registro.
     *
     * <p>
     * Verifica que no estén vacíos, que el apellido tenga dos partes,
     * que la cédula y referencia catastral sean numéricas,
     * y que la cédula no exceda 10 caracteres.
     * </p>
     *
     * @param name               nombre del beneficiario
     * @param lastName           apellidos del beneficiario
     * @param id                 cédula de ciudadanía
     * @param cadastralReference referencia catastral
     * @param expeditionLocation lugar de expedición
     * @param neighborhood       barrio
     * @param address            dirección
     * @throws InvalidInputException si alguna validación falla
     */
    private void validations(String name, String lastName, String id, String cadastralReference,
                             String expeditionLocation, String neighborhood, String address) throws InvalidInputException {

        if (isInvalidData(name, lastName, id, expeditionLocation, neighborhood, address, cadastralReference)) {
            throw new EmptyFieldException(lang.message("empty.beneficiary.general"));
        }

        if (lastName.split(" ").length < 2) {
            throw new InvalidInputException(lang.message("invalid.input.beneficiary.lastnames"));
        }

        if (!NumericalValidationUtils.isNumeric(id) || !NumericalValidationUtils.isNumeric(cadastralReference)) {
            throw new InvalidNumberInputException(lang.message("invalid.number.beneficiary.id.cadastralRef"));
        }

        if (id.length() > 10) {
            throw new MaxLengthExceededException(lang.message("max.length.beneficiary.id"), "10");
        }
    }

    /**
     * Verifica si alguno de los campos proporcionados está vacío.
     *
     * @param fields campos a validar
     * @return {@code true} si al menos un campo está en blanco
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
     * Prepara la interfaz deshabilitando el botón de registro
     * y mostrando texto de carga.
     */
    private void prepareUI() {
        registerBeneficiary.getBtn_register().setText(lang.app("controller.register.beneficiary.registering"));
        registerBeneficiary.getBtn_register().setEnabled(false);
    }

    /**
     * Registra el beneficiario y su cónyuge (si aplica) en
     * un hilo de fondo.
     *
     * <p>
     * Verifica que no exista un duplicado por cédula o nombre,
     * persiste el beneficiario y registra el cónyuge cuando
     * el estado civil lo requiere.
     * </p>
     *
     * @param fullName           nombre completo del beneficiario
     * @param code               código secuencial
     * @param id                 cédula de ciudadanía
     * @param phone              teléfono de contacto
     * @param department         departamento
     * @param municipalities     municipio
     * @param maritalStatus      estado civil
     * @param expeditionLocation lugar de expedición
     * @param neighborhood       barrio
     * @param address            dirección
     * @param cadastralReference referencia catastral
     * @param publication        publicación
     * @param crossing           cruce
     * @param affectation        afectación
     */
    private void doInBackGround(String fullName, int code, long id, long phone, Department department, Municipalities municipalities,
                                MaritalStatus maritalStatus, String expeditionLocation, String neighborhood, String address,
                                String cadastralReference, String publication, String crossing, String affectation) {
        new Thread(() -> {
            try {
                if (daoBeneficiary.findById(id) != null || daoBeneficiary.findByName(fullName) != null) {
                    throw new PersistenceException(lang.message("persistence.beneficiary.exist"));
                }

                daoBeneficiary.add(id, fullName, department, municipalities, address, cadastralReference, maritalStatus,
                        affectation, phone, crossing, publication, neighborhood, expeditionLocation);

                if (maritalStatus == MaritalStatus.MARRIED || maritalStatus == MaritalStatus.FREE_UNION) {
                    registerSpouse(code);
                }

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerBeneficiary));
            }
        }).start();
    }

    /**
     * Registra los datos del cónyuge asociado al beneficiario.
     *
     * @param beneficiaryCode código del beneficiario al que se asocia
     * @throws DAOException si no se encontraron datos del cónyuge
     *                      o si ocurre un error en la persistencia
     */
    private void registerSpouse(int beneficiaryCode) throws DAOException {
        if (dtoSpouse == null) {
            throw new DataNotFoundException(lang.message("not.found.spouse.data"));
        }

        daoSpouse.add(dtoSpouse.getId(), dtoSpouse.getFullName(), dtoSpouse.getExpeditionLocation(), dtoSpouse.getAddress(),
                dtoSpouse.getPhone(), beneficiaryCode);
    }

    /**
     * Muestra el mensaje de registro exitoso, notifica a los
     * observadores y restablece la interfaz.
     */
    private void runInvokeLater() {
        resetUI();
        MessageUtils.informationMessage(lang.message("message.beneficiary.register"), registerBeneficiary);
        subject.notifyObservers();
    }

    /**
     * Restablece el botón de registro y limpia los campos
     * del formulario.
     */
    private void resetUI() {
        registerBeneficiary.getBtn_register().setEnabled(true);
        registerBeneficiary.getBtn_register().setText(lang.app("controller.register.beneficiary.add"));
        registerBeneficiary.clearFields();
    }

    /**
     * Actualiza el combo de municipios según el departamento
     * seleccionado por el usuario.
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
     * Muestra el diálogo de captura de datos del cónyuge
     * cuando el estado civil es casado o unión libre.
     *
     * <p>
     * Si el usuario confirma el diálogo, almacena el DTO del
     * cónyuge. Si cambia a un estado civil sin cónyuge,
     * limpia la referencia.
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
     * Habilita o deshabilita el campo de afectación según
     * el estado del checkbox.
     */
    private void affectationSelected() {
        registerBeneficiary.getTxa_affectation().setEditable(registerBeneficiary.getCbx_affectation().isSelected());
    }

}
