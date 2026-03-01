package com.hector.titulacionpredial.controller.panels;

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
 * Controlador del panel de modificación de resoluciones.
 *
 * <p>
 * Implementa {@link LanguageObserver} como observador concreto
 * del patrón Observer, permitiendo que la vista se actualice
 * automáticamente cuando el {@link LanguageSubject} notifica
 * un cambio de idioma.
 * </p>
 *
 * <p>
 * Utiliza {@link LanguageManager} para acceder a los recursos
 * internacionalizados mediante claves de texto.
 * </p>
 *
 * <p>
 * Gestiona la validación de los datos del formulario y
 * la actualización de la resolución en la base de datos.
 * Al completar la modificación, navega de regreso al
 * listado de resoluciones.
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
     * Acceso al gestor de los idiomas.
     */
    private final LanguageManager lang;

    /**
     * Fachada de acceso a datos de resoluciones.
     */
    private final ResolutionFacade daoResolution;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del formulario.
     *
     * @param modifyResolution vista del formulario de modificación
     * @param seeResolutions   vista de listado de resoluciones
     * @param subject          sujeto para notificación de cambios
     * @param languageSubject  sujeto para notificar cambios de idioma
     * @param lang             acceso al gestor de los idiomas
     */
    public ControllerModifyResolution(ModifyResolution modifyResolution, SeeResolutions seeResolutions, Subject subject,
                                      LanguageSubject languageSubject, LanguageManager lang) {
        this.modifyResolution = modifyResolution;
        this.seeResolutions = seeResolutions;
        this.subject = subject;
        this.lang = lang;

        languageSubject.register(this);

        this.daoResolution = new ResolutionImplFacade();

        connectEvents();
    }

    /**
     * Conecta el botón de modificar con el método
     * {@link #modifyResolution()}.
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
     * Valida los datos del formulario de modificación y
     * lanza la actualización en segundo plano.
     *
     * <p>
     * Extrae todos los campos del formulario, aplica las
     * validaciones de campos obligatorios, formato numérico
     * y longitud máxima antes de delegar al hilo de fondo.
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
     * Ejecuta la modificación de la resolución en un hilo de fondo.
     *
     * @param code          código de la resolución
     * @param numResolution nuevo número de resolución
     * @param notification  fecha de notificación
     * @param executory     fecha de ejecutoria
     * @param notary        nombre de la notaría
     * @param fmi           Folio de Matrícula Inmobiliaria
     * @param act           acta
     * @param publicWriting número de escritura pública
     */
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

    /**
     * Actualiza la interfaz tras completar la modificación.
     *
     * <p>
     * Si la operación fue exitosa, muestra un mensaje de confirmación,
     * notifica a los observadores y navega al listado de resoluciones.
     * En caso contrario, muestra un mensaje de error.
     * </p>
     *
     * @param success {@code true} si la modificación fue exitosa
     */
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
