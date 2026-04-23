package com.hector.titulacionpredial.controller.panels;

import java.awt.CardLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.hector.titulacionpredial.controller.builder.ControllerRegisterPropertyBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PointImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiariesCode;
import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.DialogUtils;
import com.hector.titulacionpredial.utils.ImportExcel;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.ValidationUtils;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterPropertyText;
import com.hector.titulacionpredial.view.swing.button.ButtonAction;

/**
 * Property registration panel controller.
 *
 * <p>
 * Implement {@link LanguageObserver} as a concrete observer of the
 * Observer pattern, allowing the view to be automatically updated
 * when the {@link LanguageSubject} notifies a language change.
 * </p>
 *
 * <p>
 * Use {@link LanguageManager} to access internationalized resources
 * using text keys.
 * </p>
 *
 * <p>
 * Manage form validation, property registration with its four
 * geographic points, and association with selected beneficiaries.
 * Use a {@link CardLayout} to navigate between coordinate panels.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see RegisterProperty
 * @see PropertyFacade
 * @see PointFacade
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerRegisterProperty implements LanguageObserver {

    private final RegisterProperty registerProperty;
    private final Subject subject;
    private final LanguageManager lang;

    private final PropertyFacade daoProperty;
    private final PointFacade daoPoint;
    private final BeneficiaryFacade daoBeneficiary;

    private int propertyCode;
    private JDialog currentImportDialog;
    private ResultadoImportacion ultimoResultado;

    /**
     * Create the controller, register it as an observer, and
     * connect the form events.
     *
     * @param builder constructor with configured views
     */
    public ControllerRegisterProperty(ControllerRegisterPropertyBuilder builder) {
        this.registerProperty = builder.getRegisterProperty();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.daoProperty = new PropertyImplFacade();
        this.daoPoint = new PointImplFacade();
        this.daoBeneficiary = new BeneficiaryImplFacade();

        connectEvents();
        builder.getLanguageSubject().register(this);
    }

    public synchronized int getPropertyCode() {
        return propertyCode;
    }

    public synchronized void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    /**
     * Connect the form button events with their respective
     * action methods.
     */
    private void connectEvents() {
        registerProperty.setControllerRegister(e -> register());
        registerProperty.setControllerGoPoint2(e -> actionAfter());
        registerProperty.setControllerGoPoint3(e -> actionAfter());
        registerProperty.setControllerGoPoint4(e -> actionAfter());
        registerProperty.setControllerReturnPoint1(e -> actionPrevious());
        registerProperty.setControllerReturnPoint2(e -> actionPrevious());
        registerProperty.setControllerReturnPoint3(e -> actionPrevious());
        registerProperty.setControllerSearchBeneficiaries(e -> searchBeneficiaries());
        registerProperty.setControllerImportExcelData(e -> importExcelData());
    }

    @Override
    public void updateLanguage() {
        DTORegisterPropertyText dto = new DTORegisterPropertyText.Builder()
                .title(lang.app("register.property.title"))
                .point(lang.app("register.property.point"))
                .northCord(lang.app("register.property.north.cord"))
                .eastCord(lang.app("register.property.east.cord"))
                .distance(lang.app("register.property.distance"))
                .hillside(lang.app("register.property.hillside"))
                .registerBtn(lang.app("register.property.btn"))
                .propertyInfo(lang.app("register.property.info"))
                .cadastralId(lang.app("register.property.cadastralId"))
                .area(lang.app("register.property.area"))
                .address(lang.app("register.beneficiary.address"))
                .pointsInfo(lang.app("register.property.points.info"))
                .beneficiaryCode(lang.app("register.property.beneficiary.code"))
                .searchBeneficiary(lang.app("register.property.search.beneficiary"))
                .importExcelData(lang.app("register.property.import.excel.data"))
                .build();

        registerProperty.updateLanguage(dto);
    }

    /**
     * Validate the form data and launch the property registration
     * process with its geographic points.
     *
     * <p>
     * Extract the cadastral certificate, area, beneficiary codes
     * and the coordinates of the four points, validate the required
     * fields and delegate to the background thread.
     * </p>
     */
    private void register() {
        try {
            String cadastralId = registerProperty.getTxt_cadastralId().getText().trim();
            String area = registerProperty.getTxt_area().getText().trim();

            if (cadastralId.isBlank() || area.isBlank()) {
                throw new EmptyFieldException(lang.message("empty.property.id.area"));
            }

            List<PointData> points = extractPoints();

            prepareUI();
            doInBackGround(cadastralId, Double.parseDouble(area.replace(",", ".")), points);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerProperty);
        }
    }

    /**
     * It obtains the information from the four points for the geographic
     * coordinates of the property.
     *
     * @return list with the points
     * @throws InvalidInputException if there is invalid data
     */
    private List<PointData> extractPoints() throws InvalidInputException {
        JTextField[][] fields = {
                {registerProperty.getTxt_northCoordinate1(), registerProperty.getTxt_eastCoordinate1(), registerProperty.getTxt_distance1(), registerProperty.getTxt_hillside1()},
                {registerProperty.getTxt_northCoordinate2(), registerProperty.getTxt_eastCoordinate2(), registerProperty.getTxt_distance2(), registerProperty.getTxt_hillside2()},
                {registerProperty.getTxt_northCoordinate3(), registerProperty.getTxt_eastCoordinate3(), registerProperty.getTxt_distance3(), registerProperty.getTxt_hillside3()},
                {registerProperty.getTxt_northCoordinate4(), registerProperty.getTxt_eastCoordinate4(), registerProperty.getTxt_distance4(), registerProperty.getTxt_hillside4()},
        };

        return getPointData(fields);
    }

    /**
     * Create a list with the points obtained.
     *
     * @param fields matrix with the information of the points.
     * @return list with the points obtained.
     * @throws InvalidInputException if there is invalid data.
     */
    private List<PointData> getPointData(JTextField[][] fields) throws InvalidInputException {
        List<PointData> points = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            String north = fields[i][0].getText().trim();
            String east = fields[i][1].getText().trim();
            String distance = fields[i][2].getText().trim();
            String hillside = fields[i][3].getText().trim();

            if (ValidationUtils.isEmptyFields(north, east, distance, hillside)) {
                throw new EmptyFieldException(lang.message("empty.property.point") + " " + (i + 1));
            }

            north = north.replace(",", ".");
            east = east.replace(",", ".");
            distance = distance.replace(",", ".");
            hillside = hillside.replace(",", ".");

            points.add(new PointData(i + 1, north, east, distance, hillside));
        }

        return points;
    }

    /**
     * Prepare the interface by disabling the registration
     * button and displaying upload text.
     */
    private void prepareUI() {
        registerProperty.getBtn_register().setText(lang.app("controller.register.property.registering"));
        registerProperty.getBtn_register().setEnabled(false);
    }

    /**
     * Register the property, its geographical points and the
     * association with the beneficiaries in a background thread.
     *
     * <p>
     * Verify that there is no duplicate property with the same
     * cadastral certificate, if the property persists, register
     * each point and associate the indicated beneficiaries.
     * </p>
     *
     * @param cadastralId      cadastral certificate of the property
     * @param area             area of the property in square meters
     * @param points           List of data for the four geographical points
     */
    private void doInBackGround(String cadastralId, double area, List<PointData> points) {
        new Thread(() -> {
            try {
                if (daoProperty.findByCode(cadastralId) == null) {
                    throw new PersistenceException(lang.message("persistence.property.not.found"));
                }

                boolean success = daoProperty.modify(cadastralId, area);

                for (PointData p : points) {
                    daoPoint.add(p.pointNumber(),
                            p.north(),
                            p.east(),
                            Double.parseDouble(p.distance()),
                            p.hillside(),
                            getPropertyCode());
                }

                SwingUtilities.invokeLater(() -> runInvokeLater(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), registerProperty);
                    resetButton();
                });
            }
        }).start();
    }

    /**
     * Displays the successful registration message, notifies
     * observers, and resets the interface.
     */
    private void runInvokeLater(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.property.register"), registerProperty);
            subject.notifyObservers();
            resetUI();
        } else {
            MessageUtils.errorMessage(lang.message("message.property.register.error"), registerProperty);
        }
    }

    /**
     * Reset the registration button and clear the form fields.
     */
    private void resetUI() {
        resetButton();
        registerProperty.clearFields();
        showCardFirst();
        setPropertyCode(0);
    }

    /**
     * Resets the button to its default values.
     */
    private void resetButton() {
        registerProperty.getBtn_register().setText(lang.app("controller.register.property.register"));
        registerProperty.getBtn_register().setEnabled(true);
    }

    /**
     * Advance to the next coordinate panel using
     * the {@link CardLayout}.
     */
    private void actionAfter() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.next(registerProperty.getJpl_contentPoints());
    }

    /**
     * Go back to the previous coordinate panel
     * using {@link CardLayout}.
     */
    private void actionPrevious() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.previous(registerProperty.getJpl_contentPoints());
    }

    /**
     * return to the panel from the first point
     */
    private void showCardFirst() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.show(registerProperty.getJpl_contentPoints(), "point1");
    }

    /**
     * Load the list of beneficiaries without assigned
     * property and display the selection dialog.
     *
     * <p>
     * Disable the buttons during loading and restore
     * them when closing the dialog.
     * </p>
     */
    private void searchBeneficiaries() {
        try {
            String beneficiariesCode = registerProperty.getTxt_beneficiaryCode().getText().trim().toUpperCase();

            if (beneficiariesCode.isBlank()) {
                throw new EmptyFieldException(lang.message("empty.beneficiaries.code"));
            }

            if (!beneficiariesCode.matches("^F[A-Z]?\\d{4}$")) {
                throw new InvalidInputException(lang.message("empty.beneficiaries.code"));
            }

            prepareUISearch();
            doInBackGroundSearch(beneficiariesCode);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerProperty);
        }
    }

    /**
     * Prepare the UI for the beneficiary search operation.
     *
     * <p>
     * Disables the register and search buttons and updates the search
     * button text to show progress.
     * </p>
     */
    private void prepareUISearch() {
        registerProperty.getBtn_register().setEnabled(false);
        registerProperty.getBtn_searchBeneficiary().setEnabled(false);
        registerProperty.getBtn_searchBeneficiary().setText(lang.app("controller.register.property.searching"));
        setPropertyCode(0);
    }

    /**
     * Search for beneficiary in background thread.
     *
     * @param beneficiariesCode the beneficiary code to search
     */
    private void doInBackGroundSearch(String beneficiariesCode) {
        new Thread(() -> {
            try {
                DTOBeneficiariesCode dto = daoBeneficiary.findByBeneficiariesCode(beneficiariesCode);

                SwingUtilities.invokeLater(() -> {
                    registerProperty.getTxt_cadastralId().setText(dto.getCadastral_reference());
                    registerProperty.getTxt_address().setText(dto.getAddress());
                    setPropertyCode(dto.getCode());

                    resetUILoadBeneficiaries();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), registerProperty);
                    resetUILoadBeneficiaries();
                });
            }
        }).start();
    }

    /**
     * Resets the buttons after closing the beneficiary
     * selection dialog.
     */
    private void resetUILoadBeneficiaries() {
        registerProperty.getBtn_register().setEnabled(true);
        registerProperty.getBtn_searchBeneficiary().setEnabled(true);
        registerProperty.getBtn_searchBeneficiary().setText(lang.app("controller.register.property.search.beneficiary"));
    }

    /**
     * Import excel data - opens bulk import dialog with drag & drop support.
     */
    private void importExcelData() {
        JDialog dialog = new JDialog((java.awt.Frame) SwingUtilities.getWindowAncestor(registerProperty),
                "Importar Datos en Lote", true);
        this.currentImportDialog = dialog;
        dialog.setSize(1000, 600);
        dialog.setLocationRelativeTo(registerProperty);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        JPanel dropPanel = registerProperty.getPanel_dragDrop();
        mainPanel.add(dropPanel, java.awt.BorderLayout.NORTH);

        JScrollPane tableScroll = new JScrollPane(registerProperty.getTable_bulkImport());
        mainPanel.add(tableScroll, java.awt.BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        ButtonAction btnSave = new ButtonAction();
        btnSave.setText(lang.message("controller.button.save"));
        btnSave.setBackground(new java.awt.Color(64, 145, 108));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.addActionListener(e -> {
            btnSave.setEnabled(false);
            saveBulkData();
        });

        ButtonAction btnCancel = new ButtonAction();
        btnCancel.setText(lang.message("controller.button.cancel"));
        btnCancel.setBackground(new java.awt.Color(200, 200, 200));
        btnCancel.addActionListener(e -> dialog.dispose());

        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        dialog.add(mainPanel);

        registerProperty.setOnFileDropped(this::onExcelFileDropped);
        dialog.setVisible(true);
    }

    /**
     * Handle Excel file dropped via drag & drop.
     */
    private void onExcelFileDropped(File file) {
        new Thread(() -> {
            try {
                ImportExcel reader = new ImportExcel();
                List<List<String>> data = reader.readExcel(file.getAbsolutePath());

                SwingUtilities.invokeLater(() -> {
                    registerProperty.loadBulkImportTable(data);
                    // No apply validation styling - will validate during save instead
                });
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        MessageUtils.errorMessage(e.getMessage(), registerProperty)
                );
            }
        }).start();
    }

    /**
     * Apply styling to table cells based on validation results.
     * @deprecated This method is very slow with many rows. Validation now happens during save.
     */
    @Deprecated
    private void applyValidationStyling() {
        // Removed - validation now happens during save instead for better performance
    }

    /**
     * Check if a beneficiary code exists in the database.
     * @deprecated Use beneficiary caching instead. This method makes unnecessary DB calls.
     */
    @Deprecated
    private boolean beneficiaryCodeExists(String code) {
        try {
            return daoBeneficiary.findByBeneficiariesCode(code) != null;
        } catch (DAOException e) {
            return false;
        }
    }

    /**
     * Save all valid beneficiary codes from the bulk import table.
     *
     * <p>
     * Shows a loading dialog while processing. Upon completion, displays detailed
     * results and closes the import dialog on confirmation.
     * </p>
     */
    private void saveBulkData() {
        JDialog loadingDialog = DialogUtils.createLoadDialog(registerProperty,
                lang.message("dialog.saving.bulk.data"));

        SwingWorker<ResultadoImportacion, Void> worker = new SwingWorker<>() {
            @Override
            protected ResultadoImportacion doInBackground() throws Exception {
                return processBulkData();
            }

            @Override
            protected void done() {
                loadingDialog.dispose();

                try {
                    ResultadoImportacion resultado = get();
                    ultimoResultado = resultado;

                    // Mostrar mensaje detallado
                    StringBuilder mensaje = new StringBuilder();
                    mensaje.append("Registros procesados:\n");
                    mensaje.append("\u2713 Válidos guardados: ").append(resultado.validRecords).append("\n");
                    mensaje.append("\u2717 Inválidos: ").append(resultado.invalidRecords);

                    if (!resultado.codigosSinBeneficiarios.isEmpty()) {
                        mensaje.append("\n\nCódigos sin beneficiarios:\n");
                        resultado.codigosSinBeneficiarios.stream()
                                .limit(10)
                                .forEach(codigo -> mensaje.append("  - No existe beneficiario con código ").append(codigo).append(" para dichos predios\n"));

                        if (resultado.codigosSinBeneficiarios.size() > 10) {
                            mensaje.append("  ... y ").append(resultado.codigosSinBeneficiarios.size() - 10).append(" más");
                        }
                    }

                    if (!resultado.otrosErrores.isEmpty()) {
                        mensaje.append("\n\nOtros errores:\n");
                        resultado.otrosErrores.stream()
                                .limit(5)
                                .forEach(error -> mensaje.append("  - ").append(error).append("\n"));
                    }

                    // Mostrar diálogo con opción de cerrar
                    MessageUtils.informationMessage(mensaje.toString(), registerProperty);

                    // Cerrar el diálogo de importación
                    if (currentImportDialog != null) {
                        currentImportDialog.dispose();
                    }

                    // Notificar observadores y limpiar
                    subject.notifyObservers();
                    registerProperty.clearFields();

                } catch (Exception e) {
                    String msg = (e.getCause() != null) ? e.getCause().getMessage() : e.getMessage();
                    MessageUtils.errorMessage(lang.message("dialog.utils.error1") + "\n" +
                            lang.message("dialog.utils.error2") + " " + msg, registerProperty);
                }
            }
        };

        worker.execute();
        loadingDialog.setVisible(true);
    }

    /**
     * Process bulk data import in background.
     */
    private ResultadoImportacion processBulkData() throws Exception {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) registerProperty.getTable_bulkImport().getModel();

        int rowCount = model.getRowCount();
        int validRecords = 0;
        int invalidRecords = 0;
        List<String> codigosSinBeneficiarios = new ArrayList<>();
        List<String> otrosErrores = new ArrayList<>();

        // Pre-load all beneficiary codes into a map to avoid repeated DB queries
        java.util.Map<String, DTOBeneficiariesCode> beneficiaryCache = new java.util.HashMap<>();

        for (int i = 0; i < rowCount; i++) {
            String beneficiaryCode = model.getValueAt(i, 0).toString().trim();

            if (!beneficiaryCode.isEmpty() && !beneficiaryCache.containsKey(beneficiaryCode)) {
                try {
                    DTOBeneficiariesCode dto = daoBeneficiary.findByBeneficiariesCode(beneficiaryCode);
                    if (dto != null) {
                        beneficiaryCache.put(beneficiaryCode, dto);
                    }
                } catch (DAOException ignored) {
                    // Will be handled as invalid in the main loop
                }
            }
        }

        // Process each row
        for (int i = 0; i < rowCount; i++) {
            String beneficiaryCode = model.getValueAt(i, 0).toString().trim();

            // Check if code is empty
            if (beneficiaryCode.isEmpty()) {
                invalidRecords++;
                continue;
            }

            // Check if beneficiary exists in cache
            if (!beneficiaryCache.containsKey(beneficiaryCode)) {
                invalidRecords++;
                codigosSinBeneficiarios.add(beneficiaryCode);
                continue;
            }

            // Process valid beneficiary
            try {
                    DTOBeneficiariesCode beneficiaryInfo = beneficiaryCache.get(beneficiaryCode);
                    String cadastralRef = beneficiaryInfo.getCadastral_reference();
                    String address = beneficiaryInfo.getAddress();

                    List<PointData> points = extractPointsFromRow(model, i);
                    String areaStr = model.getValueAt(i, 17).toString().trim();
                    double area = !areaStr.isEmpty() ? Double.parseDouble(areaStr.replace(",", ".")) : 0;

                    if (cadastralRef == null || cadastralRef.trim().isEmpty()) {
                        invalidRecords++;
                        otrosErrores.add(beneficiaryCode + ": Sin referencia catastral");
                        continue;
                    }

                    var existingProperty = daoProperty.findByCode(cadastralRef);
                    int propertyCode;

                    if (existingProperty == null) {
                        propertyCode = daoProperty.add(
                                cadastralRef,
                                address != null ? address : "",
                                Department.CORDOBA,
                                Municipalities.MONTERIA,
                                "",
                                "",
                                ""
                        );
                    } else {
                        propertyCode = existingProperty.getPropertyCode();
                    }

                    Set<Integer> existingPointNumbers = daoPoint.existingPointNumber(propertyCode);

                    if (!points.isEmpty()) {
                        for (PointData p : points) {
                            if (existingPointNumbers.contains(p.pointNumber())) {
                                continue;
                            }

                            try {
                                daoPoint.add(
                                        p.pointNumber(),
                                        p.north(),
                                        p.east(),
                                        Double.parseDouble(p.distance().isEmpty() ? "0" : p.distance().replace(",", ".")),
                                        p.hillside().isEmpty() ? "" : p.hillside(),
                                        propertyCode
                                );

                                existingPointNumbers.add(p.pointNumber());
                            } catch (Exception pointEx) {
                                boolean isDuplicate = isIsDuplicate(pointEx);

                                if (!isDuplicate) {
                                    otrosErrores.add(beneficiaryCode + " Punto " + p.pointNumber() + ": " + pointEx.getMessage());
                                }
                                if (isDuplicate) {
                                    existingPointNumbers.add(p.pointNumber());
                                }
                            }
                        }
                    }

                    if (area > 0) {
                        if (existingProperty == null || existingProperty.getArea() <= 0) {
                            try {
                                daoProperty.modify(cadastralRef, area);
                            } catch (Exception areaEx) {
                                otrosErrores.add(beneficiaryCode + " Área: " + areaEx.getMessage());
                            }
                        }
                    }

                    validRecords++;
                } catch (Exception e) {
                    invalidRecords++;
                    otrosErrores.add(beneficiaryCode + ": " + e.getMessage());
                }
        }

        return new ResultadoImportacion(validRecords, invalidRecords, codigosSinBeneficiarios, otrosErrores);
    }

    private static boolean isIsDuplicate(Exception pointEx) {
        String msg = pointEx.getMessage() != null ? pointEx.getMessage().toLowerCase() : "";

        return msg.contains("duplicate") || msg.contains("already") ||
                            msg.contains("unique") || msg.contains("constraint") ||
                            msg.contains("key") || msg.contains("violate") ||
                            msg.contains("existe") || msg.contains("repetida");
    }

    /**
     * Extract points data from a specific row in the bulk import table.
     * Extracts all 4 points from the row, handling both coordinates and metadata.
     * 
     * @param model the table model
     * @param rowIndex the row index
     * @return list of PointData objects extracted from the row
     */
    private List<PointData> extractPointsFromRow(javax.swing.table.DefaultTableModel model, int rowIndex) {
        List<PointData> points = new ArrayList<>();
        
        try {
            String north1 = getTableValue(model, rowIndex, 2);
            String east1 = getTableValue(model, rowIndex, 1);
            String dist1 = getTableValue(model, rowIndex, 3);
            String hill1 = getTableValue(model, rowIndex, 4);

            if (!north1.isEmpty() && !east1.isEmpty()) {
                points.add(new PointData(1, north1, east1, dist1, hill1));
            }

            String north2 = getTableValue(model, rowIndex, 6);
            String east2 = getTableValue(model, rowIndex, 5);
            String dist2 = getTableValue(model, rowIndex, 7);
            String hill2 = getTableValue(model, rowIndex, 8);

            if (!north2.isEmpty() && !east2.isEmpty()) {
                points.add(new PointData(2, north2, east2, dist2, hill2));
            }

            String north3 = getTableValue(model, rowIndex, 10);
            String east3 = getTableValue(model, rowIndex, 9);
            String dist3 = getTableValue(model, rowIndex, 11);
            String hill3 = getTableValue(model, rowIndex, 12);

            if (!north3.isEmpty() && !east3.isEmpty()) {
                points.add(new PointData(3, north3, east3, dist3, hill3));
            }

            String north4 = getTableValue(model, rowIndex, 14);
            String east4 = getTableValue(model, rowIndex, 13);
            String dist4 = getTableValue(model, rowIndex, 15);
            String hill4 = getTableValue(model, rowIndex, 16);

            if (!north4.isEmpty() && !east4.isEmpty()) {
                points.add(new PointData(4, north4, east4, dist4, hill4));
            }
        } catch (Exception e) {
            System.err.println("Error extracting points from row " + rowIndex + ": " + e.getMessage());
        }
        
        return points;
    }
    
    /**
     * Safely get a value from the table model.
     */
    private String getTableValue(javax.swing.table.DefaultTableModel model, int row, int col) {
        try {
            Object value = model.getValueAt(row, col);
            if (value != null) {
                return value.toString().trim();
            }
        } catch (Exception _) {

        }
        return "";
    }

    /**
     * Immutable record that encapsulates the data of
     * a geographic point of the property.
     *
     * @param pointNumber point number (1 to 4)
     * @param north       north coordinate
     * @param east        east coordinate
     * @param distance    distance to the next point
     * @param hillside    neighboring boundary
     */
    private record PointData(int pointNumber, String north, String east, String distance, String hillside) {

    }

    /**
     * Record that encapsulates the results of a bulk import operation.
     *
     * @param validRecords               number of successfully saved records
     * @param invalidRecords             number of records that failed
     * @param codigosSinBeneficiarios    beneficiary codes not found in database
     * @param otrosErrores               other errors that occurred during import
     */
    private record ResultadoImportacion(
            int validRecords,
            int invalidRecords,
            List<String> codigosSinBeneficiarios,
            List<String> otrosErrores
    ) {

    }

}
