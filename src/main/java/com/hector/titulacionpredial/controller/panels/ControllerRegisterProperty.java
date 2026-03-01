package com.hector.titulacionpredial.controller.panels;

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
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador del panel de registro de predios.
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
 * Gestiona la validación del formulario, el registro del predio
 * con sus cuatro puntos geográficos y la asociación con
 * beneficiarios seleccionados. Utiliza un {@link CardLayout}
 * para navegar entre los paneles de coordenadas.
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

    /**
     * Vista del formulario de registro de predios.
     */
    private final RegisterProperty registerProperty;

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
     * Fachada de acceso a datos de puntos geográficos.
     */
    private final PointFacade daoPoint;

    /**
     * Fachada de acceso a datos de beneficiarios.
     */
    private final BeneficiaryFacade daoBeneficiary;

    /**
     * Crea el controlador, lo registra como observador
     * y conecta los eventos del formulario.
     *
     * @param registerProperty vista del formulario
     * @param subject          sujeto para notificación de cambios
     * @param languageSubject  sujeto para notificar cambios de idioma
     * @param lang             acceso al gestor de los idiomas
     */
    public ControllerRegisterProperty(RegisterProperty registerProperty, Subject subject, LanguageSubject languageSubject,
                                      LanguageManager lang) {
        this.registerProperty = registerProperty;
        this.subject = subject;
        this.lang = lang;

        languageSubject.register(this);

        this.daoProperty = new PropertyImplFacade();
        this.daoPoint = new PointImplFacade();
        this.daoBeneficiary = new BeneficiaryImplFacade();

        connectEvents();
    }

    /**
     * Conecta los eventos de los botones del formulario con
     * sus respectivos métodos de acción.
     */
    private void connectEvents() {
        registerProperty.setControllerRegister(e -> register());
        registerProperty.setControllerGoPoint2(e -> actionAfter());
        registerProperty.setControllerGoPoint3(e -> actionAfter());
        registerProperty.setControllerGoPoint4(e -> actionAfter());
        registerProperty.setControllerReturnPoint1(e -> actionPrevious());
        registerProperty.setControllerReturnPoint2(e -> actionPrevious());
        registerProperty.setControllerReturnPoint3(e -> actionPrevious());
        registerProperty.setControllerShowBeneficiaries(e -> showBeneficiaries());
    }

    @Override
    public void updateLanguage() {

    }

    /**
     * Valida los datos del formulario y lanza el proceso
     * de registro del predio con sus puntos geográficos.
     *
     * <p>
     * Extrae la cédula catastral, área, códigos de beneficiarios
     * y las coordenadas de los cuatro puntos, valida los
     * campos obligatorios y delega al hilo de fondo.
     * </p>
     */
    private void register() {
        try {
            String cadastralId = registerProperty.getTxt_cadastralId().getText().trim();
            String area = registerProperty.getTxt_area().getText().trim();
            String beneficiaryCode = registerProperty.getTxt_beneficiaryCode().getText().trim().replace("F", "");

            if (cadastralId.isBlank() || area.isBlank()) {
                throw new EmptyFieldException("Cedula Catastral y Area");
            }

            String[] beneficiariesCode = beneficiaryCode.split(" - ");
            List<PointData> points = extractPoints();

            prepareUI();
            doInBackGround(cadastralId, Double.parseDouble(area.replace(",", ".")), beneficiariesCode, points);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerProperty);
        }
    }

    /**
     * Obtiene la informacin de los cuatro puntos para las
     * coordenadas geograficas del predio.
     *
     * @return lista con los puntos
     * @throws InvalidInputException si hay datos invalidos
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
     * Crear una lista con los puntos obtenidos.
     *
     * @param fields matriz con la informacion de los puntos.
     * @return lista con los puntos obtenidos.
     * @throws InvalidInputException si hay datos invalidos.
     */
    private List<PointData> getPointData(JTextField[][] fields) throws InvalidInputException {
        List<PointData> points = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            String north = fields[i][0].getText().trim();
            String east = fields[i][1].getText().trim();
            String distance = fields[i][2].getText().trim();
            String hillside = fields[i][3].getText().trim();

            if (invalidPoints(north, east, distance, hillside)) {
                throw new EmptyFieldException("del punto " + (i + 1));
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
     * Verifica si alguno de los campos proporcionados está vacío.
     *
     * @param info argumentos a validar
     * @return {@code true} si al menos un campo está en blanco
     */
    private boolean invalidPoints(String... info) {
        for (String data : info) {
            if (data.isBlank()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prepara la interfaz deshabilitando el botón de registro
     * y mostrando texto de carga.
     */
    private void prepareUI() {
        registerProperty.getBtn_register().setText("Registrando Información...");
        registerProperty.getBtn_register().setEnabled(false);
    }

    /**
     * Registra el predio, sus puntos geográficos y la asociación
     * con los beneficiarios en un hilo de fondo.
     *
     * <p>
     * Verifica que no exista un predio duplicado con la misma
     * cédula catastral, persiste el predio, registra cada punto
     * y asocia los beneficiarios indicados.
     * </p>
     *
     * @param cadastralId      cédula catastral del predio
     * @param area             área del predio en metros cuadrados
     * @param beneficiaryCodes códigos de los beneficiarios asociados
     * @param points           lista de datos de los cuatro puntos geográficos
     */
    private void doInBackGround(String cadastralId, double area, String[] beneficiaryCodes, List<PointData> points) {
        new Thread(() -> {
            try {
                if (daoProperty.findByCode(cadastralId) != null) {
                    throw new PersistenceException("El predio con cedula catastral '" + cadastralId + "' ya se encuentra registrado");
                }

                int propertyCode = daoProperty.add(cadastralId, area);

                for (PointData p : points) {
                    daoPoint.add(p.pointNumber(),
                            Double.parseDouble(p.north()),
                            Double.parseDouble(p.east()),
                            Double.parseDouble(p.distance()),
                            p.hillside(),
                            propertyCode);
                }

                for (String beneficiaryCode : beneficiaryCodes) {
                    daoBeneficiary.modifyProperty(Integer.parseInt(beneficiaryCode), propertyCode);
                }

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerProperty));
            }
        }).start();
    }

    /**
     * Muestra el mensaje de registro exitoso, notifica a los
     * observadores y restablece la interfaz.
     */
    private void runInvokeLater() {
        MessageUtils.informationMessage("Se ha registrado la información correctamente", registerProperty);
        subject.notifyObservers();
        resetUI();
    }

    /**
     * Restablece el botón de registro y limpia los campos
     * del formulario.
     */
    private void resetUI() {
        registerProperty.getBtn_register().setText("REGISTRAR PREDIO");
        registerProperty.getBtn_register().setEnabled(true);
        registerProperty.clearFields();
    }

    /**
     * Avanza al siguiente panel de coordenadas mediante
     * el {@link CardLayout}.
     */
    private void actionAfter() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.next(registerProperty.getJpl_contentPoints());
    }

    /**
     * Retrocede al panel de coordenadas anterior mediante
     * el {@link CardLayout}.
     */
    private void actionPrevious() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.previous(registerProperty.getJpl_contentPoints());
    }

    /**
     * Carga la lista de beneficiarios sin predio asignado
     * y muestra el diálogo de selección.
     *
     * <p>
     * Deshabilita los botones durante la carga y los restablece
     * al cerrar el diálogo.
     * </p>
     */
    private void showBeneficiaries() {
        prepareUILoadBeneficiaries();

        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> dto = daoBeneficiary.findAllWithoutProperty();
                SwingUtilities.invokeLater(() -> loadInvokerDialog(dto));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerProperty));
            }
        }).start();
    }

    /**
     * Prepara la interfaz deshabilitando botones mientras se
     * cargan los beneficiarios.
     */
    private void prepareUILoadBeneficiaries() {
        registerProperty.getBtn_register().setEnabled(false);
        registerProperty.getBtn_selectBeneficiary().setEnabled(false);
        registerProperty.getBtn_selectBeneficiary().setText("Buscando Beneficiarios...");
    }

    /**
     * Muestra el diálogo de selección de beneficiarios y
     * añade el código seleccionado al campo del formulario.
     *
     * @param dto lista de beneficiarios disponibles para selección
     */
    private void loadInvokerDialog(List<DTOBeneficiarySimpleDetails> dto) {
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerProperty);

        SelectBeneficiary dialog = new SelectBeneficiary(parentFrame, true);
        dialog.loadBeneficiaries(dto);
        dialog.setLocationRelativeTo(registerProperty);
        dialog.setVisible(true);

        resetUILoadBeneficiaries();

        if (dialog.isConfirmed()) {
            int beneficiaryCode = dialog.codeBeneficiarySelected();
            String beneficiaryCodeStr = registerProperty.getTxt_beneficiaryCode().getText().trim();
            registerProperty.getTxt_beneficiaryCode().setText(beneficiaryCodeStr + (beneficiaryCodeStr.isBlank() ? "" : " - ") + "F" + beneficiaryCode);
        }
    }

    /**
     * Restablece los botones tras cerrar el diálogo de
     * selección de beneficiarios.
     */
    private void resetUILoadBeneficiaries() {
        registerProperty.getBtn_register().setEnabled(true);
        registerProperty.getBtn_selectBeneficiary().setEnabled(true);
        registerProperty.getBtn_selectBeneficiary().setText("Buscar Beneficiario");
    }

    /**
     * Registro inmutable que encapsula los datos de un punto
     * geográfico del predio.
     *
     * @param pointNumber número del punto (1 a 4)
     * @param north       coordenada norte
     * @param east        coordenada este
     * @param distance    distancia al siguiente punto
     * @param hillside    lindero vecino
     */
    private record PointData(int pointNumber, String north, String east, String distance, String hillside) {

    }

}
