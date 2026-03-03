package com.hector.titulacionpredial.controller.panels;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.hector.titulacionpredial.controller.builder.ControllerViewBeneficiariesBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.DialogUtils;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.GenerateExcelBeneficiary;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.dialogs.UserProfile;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOViewBeneficiariesText;

/**
 * Controlador del panel de visualización de beneficiarios.
 *
 * <p>
 * Implementa {@link Observer} para actualizar la tabla de
 * beneficiarios cuando se producen cambios y {@link LanguageObserver}
 * para actualizar la vista cuando se cambia el idioma de la aplicación.
 * </p>
 *
 * <p>
 * Ofrece funcionalidades de búsqueda (por cédula, código o nombre),
 * eliminación, modificación, visualización de perfil detallado y
 * exportación a Excel.
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

    /**
     * Vista del listado de beneficiarios.
     */
    private final ViewBeneficiaries viewBeneficiaries;

    /**
     * Vista del formulario de registro (destino al modificar).
     */
    private final RegisterBeneficiary registerBeneficiary;

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
     * Texto placeholder actual del campo de búsqueda,
     * actualizado dinámicamente según el idioma activo.
     */
    private String searchPlaceholder;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del panel.
     *
     * @param builder constructor con las vistas configuradas
     */
    public ControllerViewBeneficiaries(ControllerViewBeneficiariesBuilder builder) {
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.subject.register(this);
        builder.getLanguageSubject().register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();
        this.searchPlaceholder = lang.app("controller.view.beneficiaries.search");

        connectEvents();
    }

    /**
     * Conecta todos los eventos de los botones y componentes
     * del panel de beneficiarios con sus respectivos métodos.
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
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
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
     * Muestra el perfil detallado del beneficiario seleccionado
     * en un diálogo modal.
     *
     * <p>
     * Valida que se haya seleccionado una fila en la tabla,
     * deshabilita el botón temporalmente y carga los datos
     * completos del beneficiario en segundo plano.
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
     * Prepara la interfaz deshabilitando el botón de ver perfil
     * y mostrando texto de carga.
     */
    private void prepareUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(false);
        viewBeneficiaries.getBtn_seeProfile().setText(lang.app("controller.view.beneficiaries.searching.info"));
    }

    /**
     * Consulta los datos completos del beneficiario en segundo plano
     * y muestra el diálogo de perfil.
     *
     * @param code código del beneficiario a consultar
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
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    /**
     * Restablece el botón de ver perfil a su estado original.
     */
    private void resetUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(true);
        viewBeneficiaries.getBtn_seeProfile().setText(lang.app("controller.view.beneficiaries.full.info"));
    }

    /**
     * Navega al formulario de registro con los datos del beneficiario
     * seleccionado cargados para su modificación.
     */
    private void modifyBeneficiary() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new InvalidInputException(lang.message("invalid.input.beneficiary.view.info"));
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);
            doInBackgroundModify(code);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    /**
     * Carga los datos del beneficiario a modificar en segundo plano
     * y navega al formulario de registro.
     *
     * @param code código del beneficiario a modificar
     */
    private void doInBackgroundModify(int code) {
        new Thread(() -> {
            try {
                DTOBeneficiaryDetails dto = daoBeneficiary.findAllData(code);

                if (dto == null) {
                    throw new BeneficiaryNotFoundException(String.valueOf(code));
                }

                SwingUtilities.invokeLater(() -> {
                    NavigatorUtils.showForms(registerBeneficiary);
                    registerBeneficiary.loadDataModify(dto);
                    registerBeneficiary.setModify(true);
                    registerBeneficiary.setNowStatus(dto.getMaritalStatus());
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    /**
     * Elimina el beneficiario seleccionado con previa confirmación
     * del usuario.
     *
     * <p>
     * Valida la selección, muestra un diálogo de confirmación
     * y ejecuta la eliminación en segundo plano si el usuario acepta.
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
     * Ejecuta la eliminación del beneficiario en un hilo de fondo
     * y notifica a los observadores al completar.
     *
     * @param code código del beneficiario a eliminar
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
     * Inicia la búsqueda del beneficiario con el criterio ingresado
     * en el campo de texto.
     *
     * <p>
     * Valida que el criterio no esté vacío, actualiza la visibilidad
     * de los botones de búsqueda/cancelar y ejecuta la consulta
     * de forma asíncrona.
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

    private String getSearchParam() {
        return viewBeneficiaries.getTxt_search().getText().trim();
    }

    private boolean isValid(String param) {
        return !(param.isBlank() || param.equalsIgnoreCase(searchPlaceholder));
    }

    /**
     * Ejecuta la búsqueda asincrónica usando {@link SwingWorker}.
     *
     * @param param criterio de búsqueda
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
     * Determina el tipo de búsqueda según el parámetro y
     * consulta la fachada correspondiente.
     *
     * @param param criterio de búsqueda
     * @return DTO del beneficiario encontrado, o {@code null}
     * @throws DAOException si ocurre un error en la consulta
     */
    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws DAOException {
        if (NumericalValidationUtils.isNumeric(param)) {
            long value = Long.parseLong(param);

            return (value > 100000) ? daoBeneficiary.findById(value) : daoBeneficiary.findByCode((int) value);
        }

        return daoBeneficiary.findByName(param);
    }

    /**
     * Procesa el resultado de la búsqueda y lo muestra en la tabla.
     *
     * @param result DTO del beneficiario encontrado
     * @param param  criterio original de búsqueda
     * @throws DAOException si no se encontró ningún registro
     */
    private void handleResult(DTOBeneficiarySimpleDetails result, String param) throws DAOException {
        if (result == null) {
            throw new BeneficiaryNotFoundException(param);
        }

        viewBeneficiaries.getTableModel().setRowCount(0);
        viewBeneficiaries.loadData(result);
    }

    /**
     * Habilita o deshabilita los botones de acción durante
     * la búsqueda.
     *
     * @param isBlocked {@code true} para habilitar, {@code false} para deshabilitar
     */
    private void lockUI(boolean isBlocked) {
        viewBeneficiaries.getBtn_delete().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_modify().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_seeProfile().setEnabled(isBlocked);
    }

    /**
     * Registra el {@link DocumentListener} en el campo de búsqueda
     * para filtrar la tabla en tiempo real mientras el usuario escribe.
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
     * Configura los listeners de foco y clic del campo de búsqueda
     * para gestionar el texto placeholder «Buscar».
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
     * Cancela la búsqueda activa, restaura el placeholder y
     * recarga todos los beneficiarios.
     */
    private void cancelSearch() {
        viewBeneficiaries.getTxt_search().setText(searchPlaceholder);
        viewBeneficiaries.getBtn_searchCancel().setVisible(false);
        viewBeneficiaries.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Carga la lista de beneficiarios en la tabla de la vista.
     *
     * @param listBeneficiaries lista de DTOs a mostrar
     */
    private void loadData(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        viewBeneficiaries.getTableModel().setRowCount(0);
        listBeneficiaries.forEach(viewBeneficiaries::loadData);
    }

    /**
     * Exporta la información de todos los beneficiarios a un
     * archivo Excel.
     *
     * <p>
     * Solicita al usuario la ruta de guardado y ejecuta la
     * exportación en segundo plano mostrando un diálogo de carga.
     * </p>
     */
    private void exportToExcel() {
        try {
            String path = DialogUtils.selectRoute(viewBeneficiaries);

            if (path == null) return;

            DialogUtils.executeWithDialog(viewBeneficiaries, lang.message("dialog.exporting.report"),
                    lang.message("dialog.exported.report"), () -> {
                        List<DTOBeneficiaryCreate> allBeneficiaries = daoBeneficiary.findAllForExport();
                        GenerateExcelBeneficiary.export(allBeneficiaries, path);
                        return null;
                    });
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
        }
    }

}
