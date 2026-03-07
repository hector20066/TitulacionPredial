package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.builder.ControllerModifyResolutionBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.exception.validation.MaxLengthExceededException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOModifyResolutionText;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Resolution modification panel controller.
 *
 * <p>
 * Implement {@link LanguageObserver} as a concrete
 * observer of the Observer pattern, allowing the
 * view to be automatically updated when the
 * {@link LanguageSubject} notifies a language change.
 * </p>
 *
 * <p>
 * Use {@link LanguageManager} to access internationalized
 * resources using text keys.
 * </p>
 *
 * <p>
 * Manage the validation of form data and the updating of
 * the resolution in the database. Upon completion of the
 * modification, navigate back to the list of resolutions.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ModifyResolution
 * @see ResolutionFacade
 * @see SeeResolutions
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerModifyResolution implements LanguageObserver {

    private final ModifyResolution modifyResolution;
    private final SeeResolutions seeResolutions;
    private final Subject subject;
    private final LanguageManager lang;

    private final ResolutionFacade daoResolution;

    /**
     * Create the controller, register it as an observer,
     * and connect the form events.
     *
     * @param builder constructor with configured views
     */
    public ControllerModifyResolution(ControllerModifyResolutionBuilder builder) {
        this.modifyResolution = builder.getModifyResolution();
        this.seeResolutions = builder.getSeeResolutions();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.daoResolution = new ResolutionImplFacade();

        connectEvents();
    }

    /**
     * Connect the modify button to the {@link #modifyResolution()}
     * method.
     */
    private void connectEvents() {
        modifyResolution.setControllerModify(e -> modifyResolution());
    }

    @Override
    public void updateLanguage() {
        DTOModifyResolutionText dto = new DTOModifyResolutionText.Builder()
                .title(lang.app("modify.resolution.title"))
                .code(lang.app("modify.resolution.code"))
                .numResolution(lang.app("modify.resolution.number"))
                .fmi(lang.app("modify.resolution.fmi"))
                .act(lang.app("modify.resolution.act"))
                .publicWriting(lang.app("modify.resolution.publicWriting"))
                .notary(lang.app("modify.resolution.notary"))
                .modifyBtn(lang.app("modify.resolution.btn"))
                .executory(lang.app("modify.resolution.executory"))
                .notification(lang.app("modify.resolution.notify"))
                .build();

        modifyResolution.updateLanguage(dto);
    }

    /**
     * Validate the data in the modification form and launch the
     * update in the background.
     *
     * <p>
     * Extract all form fields, apply required field validations,
     * numeric formatting, and maximum length before delegating
     * to the background thread.
     * </p>
     */
    private void modifyResolution() {
        try {
            String code = modifyResolution.getTxt_code().getText().trim();
            String numResolution = modifyResolution.getTxt_numResolution().getText().trim();
            Date notification = (Date) modifyResolution.getFtx_notification().getValue();
            Date executory = (Date) modifyResolution.getFtx_executory().getValue();
            String notary = modifyResolution.getTxt_note().getText().trim();
            String fmi = modifyResolution.getTxt_fmi().getText().trim();
            String act = modifyResolution.getTxt_act().getText().trim();
            String publicWriting = modifyResolution.getTxt_publicWriting().getText().trim();

            if (isInvalidData(numResolution, notary, fmi)) {
                throw new EmptyFieldException(lang.message("empty.resolution.number.notary.fmi"));
            }

            if (!NumericalValidationUtils.isNumeric(numResolution)) {
                throw new InvalidNumberInputException(lang.message("invalid.number.property.number"));
            }

            if (fmi.length() > 20) {
                throw new MaxLengthExceededException(lang.message("max.length.resolution.fmi"), "20");
            }

            LocalDate notificationLocalDate = notification.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate executoryLocalDate = executory.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            prepareUI();
            doInBackground(Integer.parseInt(code), Long.parseLong(numResolution), notificationLocalDate, executoryLocalDate,
                    notary, fmi, act, publicWriting);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), modifyResolution);
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
     * Prepare the graphical interface by changing the
     * button text and disabling it.
     */
    private void prepareUI() {
        modifyResolution.getBtn_modify().setText(lang.app("modify.resolution.btn.executor"));
        modifyResolution.getBtn_modify().setEnabled(false);
    }

    /**
     * Execute the resolution modification in a background thread.
     *
     * @param code          resolution code
     * @param numResolution new resolution number
     * @param notification  notification date
     * @param executory     date of execution
     * @param notary        name of the notary
     * @param fmi           Real Estate Registration Folio
     * @param act           act
     * @param publicWriting public deed
     */
    private void doInBackground(int code, long numResolution, LocalDate notification, LocalDate executory, String notary,
                                String fmi, String act, String publicWriting) {
        new Thread(() -> {
            try {
                boolean success = daoResolution.modify(code, executory, act, publicWriting, numResolution, notification, fmi, notary);
                SwingUtilities.invokeLater(() -> runInvokeLater(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), modifyResolution);
                    resetButton();
                });
            }
        }).start();
    }

    /**
     * Update the interface after completing the modification.
     *
     * <p>
     * If the operation was successful, it displays a confirmation
     * message, notifies observers, and navigates to the resolutions
     * list. Otherwise, it displays an error message.
     * </p>
     *
     * @param success {@code true} if the modification was successful
     */
    private void runInvokeLater(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.resolution.modify"), modifyResolution);
            subject.notifyObservers();
            NavigatorUtils.showForms(seeResolutions);
        } else {
            MessageUtils.errorMessage(lang.message("message.resolution.error.modify"), modifyResolution);
        }
    }

    /**
     * Resets the button to its default values.
     */
    private void resetButton() {
        modifyResolution.getBtn_modify().setText(lang.app("modify.resolution.btn"));
        modifyResolution.getBtn_modify().setEnabled(true);
    }

}
