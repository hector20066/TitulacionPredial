package com.hector.titulacionpredial.controller.panels;

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
import com.hector.titulacionpredial.utils.*;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSeePropertiesText;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Controlador del panel de visualización de predios.
 *
 * <p>
 * Implementa {@link Observer} para actualizar la tabla de predios
 * cuando se producen cambios y {@link LanguageObserver} para actualizar
 * la vista cuando se cambia el idioma de la aplicación.
 * </p>
 *
 * <p>
 * Ofrece funcionalidades de búsqueda, eliminación, exportación
 * a Excel y navegación hacia el formulario de generación de resoluciones.
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

    /**
     * Vista del listado de predios.
     */
    private final SeeProperties seeProperties;

    /**
     * Vista del formulario de generación de resoluciones.
     */
    private final GenerateResolution generateResolution;

    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

    /**
     * Acceso al gestor de los idiomas.
     */
    private final LanguageManager lang;

    /**
     * Fachada de acceso a datos de predios.
     */
    private final PropertyFacade daoProperty;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del panel.
     *
     * @param builder constructor con las vistas configuradas
     */
    public ControllerSeeProperties(ControllerSeePropertiesBuilder builder) {
        this.seeProperties = builder.getSeeProperties();
        this.generateResolution = builder.getGenerateResolution();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        this.subject.register(this);
        builder.getLanguageSubject().register(this);

        this.daoProperty = new PropertyImplFacade();

        connectEvents();
    }

    /**
     * Conecta todos los eventos de los botones y componentes del
     * panel de predios con sus respectivos métodos de accion.
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

        seeProperties.updateLanguage(dto);
    }

    /**
     * Extrae los datos del predio seleccionado y navega al
     * formulario de generación de resoluciones con los datos precargados.
     *
     * <p>
     * Obtiene del predio seleccionado: código del predio, nombre del
     * beneficiario, cédula, dirección, municipio, coordenadas de los
     * cuatro puntos geográficos y área.
     * </p>
     */
    private void generateResolution() {
        try {
            int selectedRow = seeProperties.getJtbl_properties().getSelectedRow();

            if (seeProperties.getJtbl_properties().getSelectedRowCount() != 1) {
                throw new Exception("Por favor seleccione una fila para generar la resolución");
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
     * Construye un DTO con los datos básicos del beneficiario
     * para el formulario de generación de resoluciones.
     *
     * @param nameBeneficiary    nombre completo del beneficiario
     * @param address            dirección del predio
     * @param municipalities     municipio del predio
     * @param cadastralReference referencia catastral
     * @return DTO con los datos configurados
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
     * Exporta la información de todos los predios a un archivo Excel.
     *
     * <p>
     * Solicita al usuario la ruta de guardado y ejecuta la
     * exportación en segundo plano mostrando un diálogo de carga.
     * </p>
     */
    private void exportToExcel() {
        try {
            String path = DialogUtils.selectRoute(seeProperties);

            if (path == null) return;

            DialogUtils.executeWithDialog(seeProperties, "Exportando reporte, por favor espere...",
                    "Reporte exportado exitosamente", () -> {
                        List<DTOPropertyDetails> allProperties = daoProperty.findByAllForExport();
                        GenerateExcel.export(allProperties, path);
                        return null;
                    });
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Elimina el predio seleccionado con previa confirmación del usuario.
     *
     * <p>
     * Valida la selección, muestra un diálogo de confirmación
     * y ejecuta la eliminación en segundo plano si el usuario acepta.
     * </p>
     */
    private void deleteProperty() {
        try {
            if (seeProperties.getJtbl_properties().getSelectedRowCount() != 1) {
                throw new InvalidInputException("Por favor seleccione una fila para eliminar");
            }

            int code = (int) seeProperties.getJtbl_properties().getValueAt(seeProperties.getJtbl_properties().getSelectedRow(), 0);
            int option = MessageUtils.confirmDialog("¿Estas seguro que deseas eliminar la información de este predio?", seeProperties);

            if (option != MessageUtils.yesOption()) {
                return;
            }

            runDelete(code);
        } catch (InvalidInputException e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Ejecuta la eliminación del predio en un hilo de fondo
     * y notifica a los observadores al completar.
     *
     * @param code código del predio a eliminar
     */
    private void runDelete(int code) {
        new Thread(() -> {
            try {
                daoProperty.delete(code);

                SwingUtilities.invokeLater(() -> {
                    MessageUtils.informationMessage("Se ha eliminado el registro", seeProperties);
                    subject.notifyObservers();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), seeProperties));
            }
        }).start();
    }

    /**
     * Inicia la búsqueda del predio por cédula catastral.
     *
     * <p>
     * Valida que el criterio no esté vacío, actualiza la visibilidad
     * de los botones y ejecuta la consulta en segundo plano.
     * </p>
     */
    private void searchProperty() {
        try {
            String searchText = seeProperties.getTxt_search().getText().trim();

            if (searchText.isBlank() || searchText.equalsIgnoreCase("Buscar")) {
                throw new InvalidInputException("Por favor ingrese la cedula catastral para realizar la búsqueda");
            }

            seeProperties.getBtn_searchCancel().setVisible(true);
            seeProperties.getBtn_search().setVisible(false);

            doInBackground(searchText);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), seeProperties);
        }
    }

    /**
     * Busca el predio por cédula catastral en un hilo de fondo
     * y muestra el resultado en la tabla.
     *
     * @param searchText cédula catastral a buscar
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
     * Registra el {@link DocumentListener} en el campo de búsqueda
     * para filtrar la tabla en tiempo real.
     */
    private void documentListeners() {
        seeProperties.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }
        });
    }

    /**
     * Configura los listeners de foco y clic del campo de búsqueda
     * para gestionar el texto placeholder «Buscar».
     */
    private void listenerSearch() {
        seeProperties.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeProperties.getTxt_search().getText().isBlank()) {
                    seeProperties.getTxt_search().setText("Buscar");
                }
            }
        });

        seeProperties.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeProperties.getTxt_search().getText().equals("Buscar")) {
                    seeProperties.getTxt_search().setText("");
                }
            }
        });
    }

    /**
     * Cancela la búsqueda activa, restaura el placeholder y
     * recarga todos los predios.
     */
    private void cancelSearch() {
        seeProperties.getTxt_search().setText("Buscar");
        seeProperties.getBtn_searchCancel().setVisible(false);
        seeProperties.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    /**
     * Carga la lista de predios en la tabla de la vista.
     *
     * @param listProperties lista de DTOs de predios a mostrar
     */
    private void loadData(List<DTOPropertyDetails> listProperties) {
        seeProperties.getModel().setRowCount(0);
        listProperties.forEach(seeProperties::loadData);
    }

}
