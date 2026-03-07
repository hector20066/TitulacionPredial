package com.hector.titulacionpredial.controller.panels;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.hector.titulacionpredial.controller.builder.ControllerSeePropertiesBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.DialogUtils;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.GenerateExcel;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeePropertiesText;

/**
 * Property display panel controller.
 *
 * <p>
 * Implement {@link Observer} to update the property table when
 * changes occur and {@link LanguageObserver} to update the view
 * when the application language changes.
 * </p>
 *
 * <p>
 * It offers functionalities for searching, deleting, exporting
 * to Excel, and navigating to the resolution generation form.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SeeProperties
 * @see PropertyFacade
 * @see GenerateExcel
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerSeeProperties implements Observer, LanguageObserver {

    private final SeeProperties seeProperties;
    private final GenerateResolution generateResolution;
    private final Subject subject;
    private final LanguageManager lang;

    private final PropertyFacade daoProperty;
    private String searchPlaceholder;

    /**
     * Create the controller, register it as an observer,
     * and connect the panel events.
     *
     * @param builder constructor with configured views
     */
    public ControllerSeeProperties(ControllerSeePropertiesBuilder builder) {
        this.seeProperties = builder.getSeeProperties();
        this.generateResolution = builder.getGenerateResolution();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.subject.register(this);
        builder.getLanguageSubject().register(this);

        this.daoProperty = new PropertyImplFacade();
        this.searchPlaceholder = lang.app("controller.see.property.search");

        connectEvents();
    }

    /**
     * Connect all events of the buttons and components of the
     * property panel with their respective action methods.
     */
    private void connectEvents() {
        seeProperties.setControllerGenerate(e -> generateResolution());
        seeProperties.setControllerExportToExcel(e -> exportToExcel());
        seeProperties.setControllerDelete(e -> deleteProperty());
        seeProperties.setControllerSearch(e -> searchProperty());
        seeProperties.setControllerSearchCancel(e -> cancelSearch());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOPropertyDetails> properties = daoProperty.findByAll();
                SwingUtilities.invokeLater(() -> loadData(properties));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeProperties));
            }
        }).start();
    }

    @Override
    public void updateLanguage() {
        DTOSeePropertiesText dto = new DTOSeePropertiesText.Builder()
                .properties(lang.app("see.properties.title"))
                .code(lang.app("see.properties.code"))
                .name(lang.app("see.properties.name"))
                .id(lang.app("see.properties.id"))
                .numResolution(lang.app("see.properties.num.resolution"))
                .notify(lang.app("see.properties.notify"))
                .executory(lang.app("see.properties.executory"))
                .fmi(lang.app("see.properties.fmi"))
                .act(lang.app("see.properties.act"))
                .publicWriting(lang.app("see.properties.publicWriting"))
                .notary(lang.app("see.properties.notary"))
                .cadastralRef(lang.app("see.properties.cadastralRef"))
                .address(lang.app("see.properties.address"))
                .municipality(lang.app("see.properties.municipality"))
                .search(lang.app("see.properties.search"))
                .generateBtn(lang.app("see.properties.generate.resolution.btn"))
                .deleteBtn(lang.app("see.properties.delete.btn"))
                .exportExcelBtn(lang.app("see.properties.export.excel.btn"))
                .build();

        searchPlaceholder = lang.app("controller.see.property.search");
        seeProperties.updateLanguage(dto);
    }

    /**
     * Extract the data from the selected property and navigate
     * to the resolution generation form with the preloaded data.
     *
     * <p>
     * It obtains from the selected property: property code,
     * beneficiary name, ID number, address, municipality,
     * coordinates of the four geographic points and area.
     * </p>
     */
    private void generateResolution() {
        try {
            int selectedRow = seeProperties.getJtbl_properties().getSelectedRow();

            if (seeProperties.getJtbl_properties().getSelectedRowCount() != 1) {
                throw new Exception(lang.message("exception.property.select.row"));
            }

            int propertyCode = (int) seeProperties.getJtbl_properties().getValueAt(selectedRow, 0);
            String beneficiaryName = seeProperties.getJtbl_properties().getValueAt(selectedRow, 1).toString();
            String beneficiaryId = seeProperties.getJtbl_properties().getValueAt(selectedRow, 2).toString();
            String address = seeProperties.getJtbl_properties().getValueAt(selectedRow, 11).toString();
            Municipalities municipalities = Municipalities.valueOf(seeProperties.getJtbl_properties().getValueAt(selectedRow, 12).toString());
            String cadastralReference = seeProperties.getJtbl_properties().getValueAt(selectedRow, 10).toString();

            double eastCoordinate1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 13);
            double northCoordinate1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 14);
            double distance1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 15);
            String hillside1 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 16).toString();

            double eastCoordinate2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 17);
            double northCoordinate2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 18);
            double distance2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 19);
            String hillside2 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 20).toString();

            double eastCoordinate3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 21);
            double northCoordinate3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 22);
            double distance3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 23);
            String hillside3 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 24).toString();

            double eastCoordinate4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 25);
            double northCoordinate4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 26);
            double distance4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 27);
            String hillside4 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 28).toString();

            String[] point1 = {String.valueOf(northCoordinate1), String.valueOf(eastCoordinate1), String.valueOf(distance1), hillside1};
            String[] point2 = {String.valueOf(northCoordinate2), String.valueOf(eastCoordinate2), String.valueOf(distance2), hillside2};
            String[] point3 = {String.valueOf(northCoordinate3), String.valueOf(eastCoordinate3), String.valueOf(distance3), hillside3};
            String[] point4 = {String.valueOf(northCoordinate4), String.valueOf(eastCoordinate4), String.valueOf(distance4), hillside4};

            double area = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 29);

            DTOBeneficiarySimpleDetails dtoBeneficiary = createDTOBeneficiaries(beneficiaryName, address, municipalities, cadastralReference);

            generateResolution.loadData(area, point1, point2, point3, point4, propertyCode, dtoBeneficiary, beneficiaryId);
            generateResolution.clearFields();
            NavigatorUtils.showForms(generateResolution);
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Create a DTO with the beneficiary's basic data for the
     * resolution generation form.
     *
     * @param nameBeneficiary    full name of the beneficiary
     * @param address            property address
     * @param municipalities     municipality of the property
     * @param cadastralReference cadastral reference
     * @return DTO with configured data
     */
    private DTOBeneficiarySimpleDetails createDTOBeneficiaries(String nameBeneficiary, String address,
                                                               Municipalities municipalities, String cadastralReference) {
        return new DTOBeneficiarySimpleDetails.Builder()
                .fullName(nameBeneficiary)
                .address(address)
                .municipality(municipalities)
                .cadastralReference(cadastralReference)
                .build();
    }

    /**
     * Export the information for all properties to an Excel file.
     *
     * <p>
     * It prompts the user for the save path and executes the
     * export in the background, displaying a loading dialog.
     * </p>
     */
    private void exportToExcel() {
        try {
            String path = DialogUtils.selectRoute(seeProperties);

            if (path == null) return;

            DialogUtils.executeWithDialog(seeProperties, lang.message("dialog.exporting.report"),
                    lang.message("dialog.exported.report"), () -> {
                        List<DTOPropertyDetails> allProperties = daoProperty.findByAllForExport();
                        GenerateExcel.export(allProperties, path);
                        return null;
                    });
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Delete the selected property with prior user confirmation.
     *
     * <p>
     * Validate the selection, display a confirmation dialog, and
     * execute the deletion in the background if the user accepts.
     * </p>
     */
    private void deleteProperty() {
        try {
            if (seeProperties.getJtbl_properties().getSelectedRowCount() != 1) {
                throw new InvalidInputException(lang.message("invalid.input.property.delete.row"));
            }

            int code = (int) seeProperties.getJtbl_properties().getValueAt(seeProperties.getJtbl_properties().getSelectedRow(), 0);
            int option = MessageUtils.confirmDialog(lang.message("message.property.confirmation.delete"), seeProperties);

            if (option != MessageUtils.yesOption()) {
                return;
            }

            runDelete(code);
        } catch (InvalidInputException e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Execute the deletion of the property in a background thread
     * and notify observers upon completion.
     *
     * @param code code of the property to be eliminated
     */
    private void runDelete(int code) {
        new Thread(() -> {
            try {
                daoProperty.delete(code);

                SwingUtilities.invokeLater(() -> {
                    MessageUtils.informationMessage(lang.message("message.property.delete"), seeProperties);
                    subject.notifyObservers();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeProperties));
            }
        }).start();
    }

    /**
     * Start the search for the property using the cadastral certificate.
     *
     * <p>
     * Validate that the criteria are not empty, update the visibility of
     * the buttons, and run the query in the background.
     * </p>
     */
    private void searchProperty() {
        try {
            String searchText = seeProperties.getTxt_search().getText().trim();

            if (searchText.isBlank() || searchText.equalsIgnoreCase(searchPlaceholder)) {
                throw new InvalidInputException(lang.message("invalid.input.property.cadastral.id"));
            }

            seeProperties.getBtn_searchCancel().setVisible(true);
            seeProperties.getBtn_search().setVisible(false);

            doInBackground(searchText);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Search for the property by cadastral certificate in a background
     * thread and display the result in the table.
     *
     * @param searchText cadastral certificate to be found
     */
    private void doInBackground(String searchText) {
        new Thread(() -> {
            try {
                DTOPropertyDetails dtoPropertyDetails = daoProperty.findByCode(searchText);

                if (dtoPropertyDetails == null) {
                    throw new PropertyNotFoundException(searchText);
                }

                SwingUtilities.invokeLater(() -> {
                    seeProperties.getModel().setRowCount(0);
                    seeProperties.loadData(dtoPropertyDetails);
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeProperties));
            }
        }).start();
    }

    /**
     * Register the {@link DocumentListener} in the search field to
     * filter the table in real time.
     */
    private void documentListeners() {
        seeProperties.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), searchPlaceholder);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), searchPlaceholder);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), searchPlaceholder);
            }
        });
    }

    /**
     * Configure the focus and click listeners for the search field
     * to handle the "Search" placeholder text.
     */
    private void listenerSearch() {
        seeProperties.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeProperties.getTxt_search().getText().isBlank()) {
                    seeProperties.getTxt_search().setText(searchPlaceholder);
                }
            }
        });

        seeProperties.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeProperties.getTxt_search().getText().equals(searchPlaceholder)) {
                    seeProperties.getTxt_search().setText("");
                }
            }
        });
    }

    /**
     * Cancels active search, restores placeholder, and reloads
     * all properties.
     */
    private void cancelSearch() {
        seeProperties.getTxt_search().setText(searchPlaceholder);
        seeProperties.getBtn_searchCancel().setVisible(false);
        seeProperties.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Load the list of properties into the view table.
     *
     * @param listProperties List of property data to display
     */
    private void loadData(List<DTOPropertyDetails> listProperties) {
        seeProperties.getModel().setRowCount(0);
        listProperties.forEach(seeProperties::loadData);
    }

}
