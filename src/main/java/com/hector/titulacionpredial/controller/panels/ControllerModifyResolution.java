package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.exception.validation.MaxLengthExceededException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Controlador del panel de modificación de resoluciones.
 *
 * <p>
 * Gestiona la validación de los datos del formulario y
 * la actualización de la resolución en la base de datos.
 * Al completar la modificación, navega de regreso al
 * listado de resoluciones.
 * </p>
 *
 * @author Hector Acevedo
 * @see ModifyResolution
 * @see ResolutionFacade
 * @since 1.0
 */
public class ControllerModifyResolution {

    /**
     * Vista del formulario de modificación.
     */
    private final ModifyResolution modifyResolution;
    /**
     * Vista del listado de resoluciones (destino tras modificar).
     */
    private final SeeResolutions seeResolutions;
    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

    /**
     * Fachada de acceso a datos de resoluciones.
     */
    private final ResolutionFacade daoResolution;

    /**
     * Crea el controlador y conecta los eventos del formulario.
     *
     * @param modifyResolution vista del formulario de modificación
     * @param seeResolutions   vista de listado de resoluciones
     * @param subject          sujeto para notificación de cambios
     */
    public ControllerModifyResolution(ModifyResolution modifyResolution, SeeResolutions seeResolutions, Subject subject) {
        this.modifyResolution = modifyResolution;
        this.seeResolutions = seeResolutions;
        this.subject = subject;

        this.daoResolution = new ResolutionImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        modifyResolution.setControllerModify(e -> modifyResolution());
    }

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
                throw new EmptyFieldException("Num. Resolución, Notaria y FMI");
            }

            if (!NumericalValidationUtils.isNumeric(numResolution)) {
                throw new InvalidNumberInputException("Num. Resolución");
            }

            if (fmi.length() > 20) {
                throw new MaxLengthExceededException("FMI", "20");
            }

            LocalDate notificationLocalDate = notification.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate executoryLocalDate = executory.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            doInBackground(Integer.parseInt(code), Long.parseLong(numResolution), notificationLocalDate, executoryLocalDate,
                    notary, fmi, act, publicWriting);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), modifyResolution);
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

    private void doInBackground(int code, long numResolution, LocalDate notification, LocalDate executory, String notary,
                                String fmi, String act, String publicWriting) {
        new Thread(() -> {
            try {
                boolean success = daoResolution.modify(code, executory, act, publicWriting, numResolution, notification, fmi, notary);
                SwingUtilities.invokeLater(() -> runInvokeLater(success));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), modifyResolution));
            }
        }).start();
    }

    private void runInvokeLater(boolean success) {
        if (success) {
            MessageUtils.informationMessage("Se ha modificado la información de la resolución", modifyResolution);
            subject.notifyObservers();
            NavigatorUtils.showForms(seeResolutions);
        } else {
            MessageUtils.errorMessage("No se pudo modificar. Inténtelo nuevamente.", modifyResolution);
        }
    }

}
