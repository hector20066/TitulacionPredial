package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.builder.ControllerViewBeneficiariesBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.dao.notfound.PropertyNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertySimpleDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.*;
import com.hector.titulacionpredial.view.content.dialogs.UserProfile;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOViewBeneficiariesText;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Beneficiary display panel controller.
 *
 * <p>
 * Implement {@link Observer} to update the beneficiary table when
 * changes occur and {@link LanguageObserver} to update the view
 * when the application language changes.
 * </p>
 *
 * <p>
 * It offers functionalities for searching (by ID number, code or name),
 * deletion, modification, viewing of detailed profile and export to Excel.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ViewBeneficiaries
 * @see BeneficiaryFacade
 * @see GenerateExcelBeneficiary
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerViewBeneficiaries implements Observer, LanguageObserver {

    private final ViewBeneficiaries viewBeneficiaries;
    private final RegisterBeneficiary registerBeneficiary;
    private final ControllerLogin controllerLogin;
    private final Subject subject;
    private final LanguageManager lang;

    private final BeneficiaryFacade daoBeneficiary;
    private final PropertyFacade daoProperty;
    private String searchPlaceholder;

    /**
     * Create the controller, register it as an observer, and
     * connect the panel events.
     *
     * @param builder constructor with configured views
     */
    public ControllerViewBeneficiaries(ControllerViewBeneficiariesBuilder builder) {
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.controllerLogin = builder.getControllerLogin();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.subject.register(this);
        builder.getLanguageSubject().register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.daoProperty = new PropertyImplFacade();
        this.searchPlaceholder = lang.app("controller.view.beneficiaries.search");

        connectEvents();
    }

    /**
     * Connect all events of the buttons and components of the
     * beneficiary panel with their respective methods.
     */
    private void connectEvents() {
        viewBeneficiaries.setControllerViewDetails(e -> showDetails());
        viewBeneficiaries.setControllerModify(e -> modifyBeneficiary());
        viewBeneficiaries.setControllerDelete(e -> deleteBeneficiary());
        viewBeneficiaries.setControllerSearch(e -> search());
        viewBeneficiaries.setControllerSearchCancel(e -> cancelSearch());
        viewBeneficiaries.setControllerExportToExcel(e -> exportToExcel());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                Municipalities municipality = SessionManager.getInstance().getMunicipality();
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = (municipality != null)
                    ? daoBeneficiary.findAllByMunicipality(municipality)
                    : daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listBeneficiaries));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    @Override
    public void updateLanguage() {
        DTOViewBeneficiariesText dto = new DTOViewBeneficiariesText.Builder()
                .title(lang.app("view.beneficiaries.title"))
                .code(lang.app("view.beneficiaries.code"))
                .codeIdentification(lang.app("view.beneficiaries.code.identification"))
                .id(lang.app("view.beneficiaries.id"))
                .name(lang.app("view.beneficiaries.name"))
                .phone(lang.app("view.beneficiaries.phone"))
                .cadastralRef(lang.app("view.beneficiaries.cadastralRef"))
                .municipality(lang.app("view.beneficiaries.municipality"))
                .address(lang.app("view.beneficiaries.address"))
                .search(lang.app("view.beneficiaries.search"))
                .fullInfoBtn(lang.app("view.beneficiaries.full.info"))
                .modifyBtn(lang.app("view.beneficiaries.modify"))
                .deleteBtn(lang.app("view.beneficiaries.delete"))
                .exportExcelBtn(lang.app("view.beneficiaries.export.excel"))
                .build();

        searchPlaceholder = lang.app("controller.view.beneficiaries.search");
        viewBeneficiaries.updateLanguage(dto);
    }

    /**
     * Displays the detailed profile of the selected beneficiary
     * in a modal dialog.
     *
     * <p>
     * It validates that a row has been selected in the table,
     * temporarily disables the button, and loads the complete
     * beneficiary data in the background.
     * </p>
     */
    private void showDetails() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new InvalidInputException(lang.message("invalid.input.beneficiary.view.info"));
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            prepareUI();
            doInBackground(code);
        } catch (InvalidInputException e) {
            MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    /**
     * Prepare the interface by disabling the view profile
     * button and displaying upload text.
     */
    private void prepareUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(false);
        viewBeneficiaries.getBtn_seeProfile().setText(lang.app("controller.view.beneficiaries.searching.info"));
    }

    /**
     * View the beneficiary's full details in the background
     * and display the profile dialog.
     *
     * @param code beneficiary code to consult
     */
    private void doInBackground(int code) {
        new Thread(() -> {
            try {
                DTOBeneficiaryDetails dto = daoBeneficiary.findAllData(code);

                SwingUtilities.invokeLater(() -> {
                    java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(viewBeneficiaries);
                    UserProfile dialog = new UserProfile(parentFrame, true);
                    dialog.loadBeneficiary(dto);

                    dialog.setLocationRelativeTo(viewBeneficiaries);
                    dialog.updateLanguage();
                    dialog.setVisible(true);

                    resetUI();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
                    resetUI();
                });
            }
        }).start();
    }

    /**
     * Resets the view profile button to its original state.
     */
    private void resetUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(true);
        viewBeneficiaries.getBtn_seeProfile().setText(lang.app("controller.view.beneficiaries.full.info"));
    }

    /**
     * Navigate to the registration form with the selected
     * beneficiary's data loaded for modification.
     */
    private void modifyBeneficiary() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new InvalidInputException(lang.message("invalid.input.beneficiary.view.info"));
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            prepareUIModify();
            doInBackgroundModify(code);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    private void prepareUIModify() {
        viewBeneficiaries.getBtn_modify().setEnabled(false);
        viewBeneficiaries.getBtn_modify().setText("Cargando Información...");
    }

    /**
     * Load the beneficiary's data to be modified in the
     * background and navigate to the registration form.
     *
     * @param code beneficiary code to be modified
     */
    private void doInBackgroundModify(int code) {
        new Thread(() -> {
            try {
                DTOBeneficiaryDetails dtoBeneficiary = daoBeneficiary.findAllData(code);

                if (dtoBeneficiary == null) {
                    throw new BeneficiaryNotFoundException(String.valueOf(code));
                }

                DTOPropertySimpleDetails dtoProperty = daoProperty.findSimpleDetails(dtoBeneficiary.getCadastralRef());

                if (dtoProperty == null) {
                    throw new PropertyNotFoundException(String.valueOf(dtoBeneficiary.getCadastralRef()));
                }

                SwingUtilities.invokeLater(() -> {
                    NavigatorUtils.showForms(controllerLogin.jpl_Content(), registerBeneficiary);
                    registerBeneficiary.loadDataModify(dtoBeneficiary, dtoProperty);
                    registerBeneficiary.setModify(true);
                    registerBeneficiary.setNowStatus(dtoBeneficiary.getMaritalStatus());
                    registerBeneficiary.setModifyCode(code);
                    registerBeneficiary.getBtn_addBeneficiaries().setVisible(false);
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
                resetUIModify();
            }
        }).start();
    }

    private void resetUIModify() {
        viewBeneficiaries.getBtn_modify().setEnabled(false);
        viewBeneficiaries.getBtn_modify().setText("Modificar");
    }

    /**
     * Remove the selected beneficiary with prior user confirmation.
     *
     * <p>
     * Validate the selection, display a confirmation dialog, and
     * execute the deletion in the background if the user accepts.
     * </p>
     */
    private void deleteBeneficiary() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (viewBeneficiaries.getJtbl_beneficiaries().getSelectedRowCount() != 1) {
                throw new InvalidInputException(lang.message("invalid.input.beneficiary.delete"));
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);
            int option = MessageUtils.confirmDialog(lang.message("message.beneficiary.confirmation.delete"), viewBeneficiaries);

            if (option != MessageUtils.yesOption()) {
                return;
            }

            runDelete(code);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    /**
     * Execute the beneficiary removal in a background thread and
     * notify observers upon completion.
     *
     * @param code beneficiary code to be removed
     */
    private void runDelete(int code) {
        new Thread(() -> {
            try {
                daoBeneficiary.delete(code);
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.informationMessage(lang.message("message.beneficiary.delete"), viewBeneficiaries);
                    subject.notifyObservers();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    /**
     * Start the search for the beneficiary using the criteria entered
     * in the text field.
     *
     * <p>
     * It validates that the criteria are not empty, updates the visibility
     * of the search/cancel buttons, and executes the query asynchronously.
     * </p>
     */
    private void search() {
        String param = getSearchParam();

        if (!isValid(param)) {
            MessageUtils.warningMessage(lang.message("message.beneficiary.enter.search"), viewBeneficiaries);
            return;
        }

        viewBeneficiaries.getBtn_search().setVisible(false);
        viewBeneficiaries.getBtn_searchCancel().setVisible(true);

        lockUI(false);
        executeSearchAsync(param);
    }

    /**
     * It retrieves the search text entered by the user, removing
     * leading and trailing spaces.
     *
     * @return clean search parameter
     */
    private String getSearchParam() {
        return viewBeneficiaries.getTxt_search().getText().trim();
    }

    /**
     * Validate that the search parameter is not empty or equal
     * to the placeholder text.
     *
     * @param param text to validate
     * @return {@code true} if the parameter is valid for searching,
     * {@code false} otherwise
     */
    private boolean isValid(String param) {
        return !(param.isBlank() || param.equalsIgnoreCase(searchPlaceholder));
    }

    /**
     * Perform the asynchronous search using {@link SwingWorker}.
     *
     * @param param search criteria
     */
    private void executeSearchAsync(String param) {
        new SwingWorker<DTOBeneficiarySimpleDetails, Void>() {
            @Override
            protected DTOBeneficiarySimpleDetails doInBackground() throws DAOException {
                return resolveSearch(param);
            }

            @Override
            protected void done() {
                try {
                    handleResult(get(), param);
                } catch (DAOException | InterruptedException | ExecutionException e) {
                    MessageUtils.errorMessage(lang.message("message.beneficiary.search.error"), viewBeneficiaries);
                } finally {
                    lockUI(true);
                }
            }
        }.execute();
    }

    /**
     * Determine the search type according to the parameter and
     * view the corresponding facade.
     *
     * @param param search criteria
     * @return DTO of the beneficiary found, or {@code null}
     * @throws DAOException if an error occurs in the query
     */
    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws DAOException {
        if (NumericalValidationUtils.isNumeric(param)) {
            long value = Long.parseLong(param);

            return (value > 100000) ? daoBeneficiary.findById(value) : daoBeneficiary.findByCode((int) value);
        }

        return daoBeneficiary.findByName(param);
    }

    /**
     * It processes the search result and displays it in the table.
     *
     * @param result DTO of the beneficiary found
     * @param param  original search criteria
     * @throws DAOException if no record was found
     */
    private void handleResult(DTOBeneficiarySimpleDetails result, String param) throws DAOException {
        if (result == null) {
            throw new BeneficiaryNotFoundException(param);
        }

        viewBeneficiaries.getTableModel().setRowCount(0);
        viewBeneficiaries.loadData(result);
    }

    /**
     * Enables or disables action buttons during search.
     *
     * @param isBlocked {@code true} to enable, {@code false} to disable
     */
    private void lockUI(boolean isBlocked) {
        viewBeneficiaries.getBtn_delete().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_modify().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_seeProfile().setEnabled(isBlocked);
    }

    /**
     * Register the {@link DocumentListener} in the search field to
     * filter the table in real time as the user types.
     */
    private void documentListeners() {
        viewBeneficiaries.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), searchPlaceholder);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), searchPlaceholder);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), searchPlaceholder);
            }
        });
    }

    /**
     * Configure the focus and click listeners for the search field
     * to handle the "Search" placeholder text.
     */
    private void listenerSearch() {
        viewBeneficiaries.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (viewBeneficiaries.getTxt_search().getText().isBlank()) {
                    viewBeneficiaries.getTxt_search().setText(searchPlaceholder);
                }
            }
        });

        viewBeneficiaries.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (viewBeneficiaries.getTxt_search().getText().equals(searchPlaceholder)) {
                    viewBeneficiaries.getTxt_search().setText("");
                }
            }
        });
    }

    /**
     * Cancel active search, restore placeholder, and reload
     * all beneficiaries.
     */
    private void cancelSearch() {
        viewBeneficiaries.getTxt_search().setText(searchPlaceholder);
        viewBeneficiaries.getBtn_searchCancel().setVisible(false);
        viewBeneficiaries.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Load the list of beneficiaries into the view table.
     *
     * @param listBeneficiaries list of DATA to display
     */
    private void loadData(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        viewBeneficiaries.getTableModel().setRowCount(0);
        listBeneficiaries.forEach(viewBeneficiaries::loadData);
    }

    /**
     * Export the information of all beneficiaries to an Excel file.
     *
     * <p>
     * It prompts the user for the save path and executes the export
     * in the background, displaying a loading dialog.
     * </p>
     */
    private void exportToExcel() {
        try {
            String path = DialogUtils.selectRoute(viewBeneficiaries);

            if (path == null) return;

            DialogUtils.executeWithDialog(viewBeneficiaries, lang.message("dialog.exporting.report"),
                    lang.message("dialog.exported.report"), () -> {
                        List<DTOBeneficiaryDetails> allBeneficiaries = daoBeneficiary.findAllForExport();
                        GenerateExcelBeneficiary.export(allBeneficiaries, path);
                        return null;
                    });
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
        }
    }

}
