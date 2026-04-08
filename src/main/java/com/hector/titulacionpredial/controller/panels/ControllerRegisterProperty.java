package com.hector.titulacionpredial.controller.panels;

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
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.ImportExcel;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.ValidationUtils;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterPropertyText;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
                            Double.parseDouble(p.north()),
                            Double.parseDouble(p.east()),
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

            if (!beneficiariesCode.contains("F")) {
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
     * import excel data.
     */
    private void importExcelData() {
        JFileChooser fileChooser = new JFileChooser();

        int option = fileChooser.showOpenDialog(registerProperty);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            String name = file.getName().toLowerCase();
            if (!name.endsWith(".xlsx") && !name.endsWith(".xls")) {
                JOptionPane.showMessageDialog(registerProperty,
                        lang.message("message.property.import"),
                        lang.message("message.property.import.invalid.file"), JOptionPane.WARNING_MESSAGE);
                return;
            }

            ImportExcel reader = new ImportExcel();
            List<List<String>> data = reader.readExcel(file.getAbsolutePath());

            loadInFields(data);
        }
    }

    /**
     * Load Excel data into form fields.
     *
     * @param data list of string rows from Excel file
     */
    private void loadInFields(List<List<String>> data) {
        if (!data.isEmpty()) {
            List<String> fila = data.getFirst();

            registerProperty.getTxt_eastCoordinate1().setText(!fila.isEmpty() ? fila.get(0) : "");
            registerProperty.getTxt_northCoordinate1().setText(fila.size() > 1 ? fila.get(1) : "");
            registerProperty.getTxt_distance1().setText(fila.size() > 2 ? fila.get(2) : "");
            registerProperty.getTxt_hillside1().setText(fila.size() > 3 ? fila.get(3) : "");
            registerProperty.getTxt_eastCoordinate2().setText(fila.size() > 4 ? fila.get(4) : "");
            registerProperty.getTxt_northCoordinate2().setText(fila.size() > 5 ? fila.get(5) : "");
            registerProperty.getTxt_distance2().setText(fila.size() > 6 ? fila.get(6) : "");
            registerProperty.getTxt_hillside2().setText(fila.size() > 7 ? fila.get(7) : "");
            registerProperty.getTxt_eastCoordinate3().setText(fila.size() > 8 ? fila.get(8) : "");
            registerProperty.getTxt_northCoordinate3().setText(fila.size() > 9 ? fila.get(9) : "");
            registerProperty.getTxt_distance3().setText(fila.size() > 10 ? fila.get(10) : "");
            registerProperty.getTxt_hillside3().setText(fila.size() > 11 ? fila.get(11) : "");
            registerProperty.getTxt_eastCoordinate4().setText(fila.size() > 12 ? fila.get(12) : "");
            registerProperty.getTxt_northCoordinate4().setText(fila.size() > 13 ? fila.get(13) : "");
            registerProperty.getTxt_distance4().setText(fila.size() > 14 ? fila.get(14) : "");
            registerProperty.getTxt_hillside4().setText(fila.size() > 15 ? fila.get(15) : "");
            registerProperty.getTxt_area().setText(fila.size() > 16 ? fila.get(16) : "");

        }
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

}
