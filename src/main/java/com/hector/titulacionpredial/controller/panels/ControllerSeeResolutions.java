package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.builder.ControllerSeeResolutionsBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.*;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeeResolutionsText;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Resolution display panel controller.
 *
 * <p>
 * Implement {@link Observer} to update the resolutions table
 * when changes occur and {@link LanguageObserver} to update
 * the view when the application language changes.
 * </p>
 *
 * <p>
 * It offers functionalities for searching by resolution number,
 * real-time filtering, and navigation to the modification form.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SeeResolutions
 * @see ResolutionFacade
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerSeeResolutions implements Observer, LanguageObserver {

    private final SeeResolutions seeResolutions;
    private final ModifyResolution modifyResolution;
    private final ControllerLogin controllerLogin;
    private final Subject subject;
    private final LanguageManager lang;

    private final ResolutionFacade daoResolution;
    private String searchPlaceholder;

    /**
     * Create the controller, register it as an observer, and
     * connect the panel events.
     *
     * @param builder constructor with configured views
     */
    public ControllerSeeResolutions(ControllerSeeResolutionsBuilder builder) {
        this.seeResolutions = builder.getSeeResolutions();
        this.modifyResolution = builder.getModifyResolution();
        this.controllerLogin = builder.getControllerLogin();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.daoResolution = new ResolutionImplFacade();
        this.searchPlaceholder = lang.app("controller.see.resolution.search");

        connectEvents();
        this.subject.register(this);
        builder.getLanguageSubject().register(this);
    }

    /**
     * Connect all events of the buttons and components of
     * the resolutions panel with their respective methods.
     */
    private void connectEvents() {
        seeResolutions.setControllerModify(e -> modify());
        seeResolutions.setControllerSearch(e -> searchResolution());
        seeResolutions.setControllerSearchCancel(e -> cancelSearch());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                Municipalities municipality = SessionManager.getInstance().getMunicipality();
                List<DTOResolutionDetails> listResolutions = (municipality != null)
                    ? daoResolution.findByMunicipality(municipality)
                    : daoResolution.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listResolutions));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeResolutions));
            }
        }).start();
    }

    @Override
    public void updateLanguage() {
        DTOSeeResolutionsText dto = new DTOSeeResolutionsText.Builder()
                .title(lang.app("see.resolutions.title"))
                .code(lang.app("see.resolutions.code"))
                .number(lang.app("see.resolutions.number"))
                .notification(lang.app("see.resolutions.notify"))
                .executory(lang.app("see.resolutions.executory"))
                .notary(lang.app("see.resolutions.notary"))
                .fmi(lang.app("see.resolutions.fmi"))
                .act(lang.app("see.resolutions.act"))
                .publicWriting(lang.app("see.resolutions.publicWriting"))
                .search(lang.app("see.resolutions.search"))
                .modifyBtn(lang.app("see.properties.modify"))
                .build();

        searchPlaceholder = lang.app("controller.see.resolution.search");
        seeResolutions.updateLanguage(dto);
    }

    /**
     * Extract the data from the selected resolution, load it
     * into the modification form, and navigate to it.
     *
     * <p>
     * Format the notification and enforcement dates to the
     * legible Spanish format before passing them to the form.
     * </p>
     */
    private void modify() {
        try {
            int selectedRow = seeResolutions.getJtbl_resolutions().getSelectedRow();

            if (seeResolutions.getJtbl_resolutions().getSelectedRowCount() != 1) {
                throw new Exception(lang.message("exception.resolution.select"));
            }

            int code = (int) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 0);
            long numResolution = (long) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 1);
            LocalDate notification = (LocalDate) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 2);
            LocalDate executory = (LocalDate) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 3);
            String notary = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 4).toString();
            String fmi = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 5).toString();
            String act = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 6).toString();
            String publicWriting = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 7).toString();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
            String notificationString = notification.format(formatter);
            String executoryString = executory.format(formatter);

            DTOResolutionDetails dto = createDTO(code, numResolution, notary, fmi, act, publicWriting);

            modifyResolution.loadData(dto, notificationString, executoryString);
            NavigatorUtils.showForms(controllerLogin.jpl_Content(), modifyResolution);
        } catch (Exception e) {
            MessageUtils.warningMessage(e.getMessage(), seeResolutions);
        }
    }

    /**
     * Build a DTO with the data from the selected resolution.
     *
     * @param code          resolution code
     * @param numResolution resolution number
     * @param notary        name of the notary
     * @param fmi           Real Estate Registration Folio
     * @param act           act
     * @param publicWriting public deed
     * @return DTO with configured data
     */
    private DTOResolutionDetails createDTO(int code, long numResolution, String notary, String fmi, String act, String publicWriting) {
        return new DTOResolutionDetails.Builder()
                .code(code)
                .resolutionNumber(numResolution)
                .notary(notary)
                .fmi(fmi)
                .act(act)
                .publicWriting(publicWriting)
                .build();
    }

    /**
     * Start the search for a solution by its number.
     *
     * <p>
     * Validate that the criteria is not empty and is numeric,
     * update the buttons, and run the query in the background.
     * </p>
     */
    private void searchResolution() {
        try {
            String numResolutionText = seeResolutions.getTxt_search().getText().trim();

            if (numResolutionText.isBlank() || numResolutionText.equalsIgnoreCase(searchPlaceholder)) {
                throw new InvalidInputException(lang.message("invalid.input.resolution.number"));
            }

            if (!ValidationUtils.isNumeric(numResolutionText)) {
                throw new InvalidNumberInputException(lang.message("invalid.number.property.search"));
            }

            seeResolutions.getBtn_searchCancel().setVisible(true);
            seeResolutions.getBtn_search().setVisible(false);

            doInBackground(Integer.parseInt(numResolutionText));
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), seeResolutions);
        }
    }

    /**
     * Search for the solution by its number in a background
     * thread and display the result in the table.
     *
     * @param numResolution resolution number to search
     */
    private void doInBackground(int numResolution) {
        new Thread(() -> {
            try {
                DTOResolutionDetails dto = daoResolution.findByCode(numResolution);

                if (dto == null) {
                    throw new ResolutionNotFoundException(String.valueOf(numResolution));
                }

                SwingUtilities.invokeLater(() -> {
                    seeResolutions.getModel().setRowCount(0);
                    seeResolutions.loadData(dto);
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeResolutions));
            }
        }).start();
    }

    /**
     * Register the {@link DocumentListener} in the search
     * field to filter the table in real time.
     */
    private void documentListeners() {
        seeResolutions.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), searchPlaceholder);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), searchPlaceholder);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), searchPlaceholder);
            }
        });
    }

    /**
     * Configure the focus and click listeners for the search
     * field to handle the "Search" placeholder text.
     */
    private void listenerSearch() {
        seeResolutions.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeResolutions.getTxt_search().getText().isBlank()) {
                    seeResolutions.getTxt_search().setText(searchPlaceholder);
                }
            }
        });

        seeResolutions.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeResolutions.getTxt_search().getText().equals(searchPlaceholder)) {
                    seeResolutions.getTxt_search().setText("");
                }
            }
        });
    }

    /**
     * Cancels active search, restores placeholder, and
     * reloads all resolutions.
     */
    private void cancelSearch() {
        seeResolutions.getTxt_search().setText(searchPlaceholder);
        seeResolutions.getBtn_searchCancel().setVisible(false);
        seeResolutions.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Load the list of resolutions into the view table.
     *
     * @param listResolutions List of resolution data to display
     */
    private void loadData(List<DTOResolutionDetails> listResolutions) {
        seeResolutions.getModel().setRowCount(0);
        listResolutions.forEach(seeResolutions::loadData);
    }

}
