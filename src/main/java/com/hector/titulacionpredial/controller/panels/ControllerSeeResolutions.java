package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.ResolutionNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

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
 * Controlador del panel de visualización de resoluciones.
 *
 * <p>
 * Implementa {@link Observer} para actualizar la tabla de
 * resoluciones cuando se producen cambios. Ofrece funcionalidades
 * de búsqueda por número de resolución, filtrado en tiempo real
 * y navegación hacia el formulario de modificación.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SeeResolutions
 * @see ResolutionFacade
 * @since 1.0
 */
public class ControllerSeeResolutions implements Observer {

    /**
     * Vista del listado de resoluciones.
     */
    private final SeeResolutions seeResolutions;
    /**
     * Vista del formulario de modificación de resoluciones.
     */
    private final ModifyResolution modifyResolution;
    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

    /**
     * Fachada de acceso a datos de resoluciones.
     */
    private final ResolutionFacade daoResolution;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del panel.
     *
     * @param seeResolutions   vista del listado de resoluciones
     * @param modifyResolution vista del formulario de modificación
     * @param subject          sujeto para registro del observador
     */
    public ControllerSeeResolutions(SeeResolutions seeResolutions, ModifyResolution modifyResolution, Subject subject) {
        this.seeResolutions = seeResolutions;
        this.modifyResolution = modifyResolution;
        this.subject = subject;

        this.subject.register(this);

        this.daoResolution = new ResolutionImplFacade();

        connectEvents();
    }

    /**
     * Conecta todos los eventos de los botones y componentes del
     * panel de resoluciones con sus respectivos métodos.
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
                List<DTOResolutionDetails> listResolutions = daoResolution.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listResolutions));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeResolutions));
            }
        }).start();
    }

    /**
     * Extrae los datos de la resolución seleccionada, los carga
     * en el formulario de modificación y navega hacia él.
     *
     * <p>
     * Formatea las fechas de notificación y ejecutoria al formato
     * español legible antes de pasarlas al formulario.
     * </p>
     */
    private void modify() {
        try {
            int selectedRow = seeResolutions.getJtbl_resolutions().getSelectedRow();

            if (seeResolutions.getJtbl_resolutions().getSelectedRowCount() != 1) {
                throw new Exception("Debe seleccionar una resolución para modificarla");
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
            NavigatorUtils.showForms(modifyResolution);
        } catch (Exception e) {
            MessageUtils.warningMessage(e.getMessage(), seeResolutions);
        }
    }

    /**
     * Construye un DTO con los datos de la resolución seleccionada.
     *
     * @param code          código de la resolución
     * @param numResolution número de resolución
     * @param notary        nombre de la notaría
     * @param fmi           Folio de Matrícula Inmobiliaria
     * @param act           número de acta
     * @param publicWriting número de escritura pública
     * @return DTO con los datos configurados
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
     * Inicia la búsqueda de una resolución por su número.
     *
     * <p>
     * Valida que el criterio no esté vacío y sea numérico,
     * actualiza los botones y ejecuta la consulta en segundo plano.
     * </p>
     */
    private void searchResolution() {
        try {
            String numResolutionText = seeResolutions.getTxt_search().getText().trim();

            if (numResolutionText.isBlank() || numResolutionText.equalsIgnoreCase("Buscar")) {
                throw new InvalidInputException("Debe ingresar el numero de la resolución para realizar la búsqueda");
            }

            if (!NumericalValidationUtils.isNumeric(numResolutionText)) {
                throw new InvalidNumberInputException("de Búsqueda");
            }

            seeResolutions.getBtn_searchCancel().setVisible(true);
            seeResolutions.getBtn_search().setVisible(false);

            doInBackground(Integer.parseInt(numResolutionText));
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), seeResolutions);
        }
    }

    /**
     * Busca la resolución por su número en un hilo de fondo
     * y muestra el resultado en la tabla.
     *
     * @param numResolution número de resolución a buscar
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
     * Registra el {@link DocumentListener} en el campo de búsqueda
     * para filtrar la tabla en tiempo real.
     */
    private void documentListeners() {
        seeResolutions.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }
        });
    }

    /**
     * Configura los listeners de foco y clic del campo de búsqueda
     * para gestionar el texto placeholder «Buscar».
     */
    private void listenerSearch() {
        seeResolutions.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeResolutions.getTxt_search().getText().isBlank()) {
                    seeResolutions.getTxt_search().setText("Buscar");
                }
            }
        });

        seeResolutions.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeResolutions.getTxt_search().getText().equals("Buscar")) {
                    seeResolutions.getTxt_search().setText("");
                }
            }
        });
    }

    /**
     * Cancela la búsqueda activa, restaura el placeholder y
     * recarga todas las resoluciones.
     */
    private void cancelSearch() {
        seeResolutions.getTxt_search().setText("Buscar");
        seeResolutions.getBtn_searchCancel().setVisible(false);
        seeResolutions.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Carga la lista de resoluciones en la tabla de la vista.
     *
     * @param listResolutions lista de DTOs de resoluciones a mostrar
     */
    private void loadData(List<DTOResolutionDetails> listResolutions) {
        seeResolutions.getModel().setRowCount(0);
        listResolutions.forEach(seeResolutions::loadData);
    }

}
