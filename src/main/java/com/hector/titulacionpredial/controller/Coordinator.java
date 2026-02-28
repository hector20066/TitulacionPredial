package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;
import com.hector.titulacionpredial.controller.panels.*;
import com.hector.titulacionpredial.observer.ConcreteSubject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Coordinador principal de la aplicación.
 *
 * <p>
 * Se encarga de inicializar todas las vistas y controladores
 * de la aplicación, conectarlos entre sí y arrancar la
 * interfaz gráfica. Implementa el patrón Coordinator para
 * centralizar la construcción y configuración del sistema.
 * </p>
 *
 * <p>
 * Flujo de inicio:
 * </p>
 * <ol>
 *   <li>Crear las vistas ({@code startView})</li>
 *   <li>Crear los controladores ({@code startDrivers})</li>
 *   <li>Notificar a los observadores para cargar datos iniciales</li>
 *   <li>Mostrar la ventana principal</li>
 * </ol>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentBuilder
 * @see ConcreteSubject
 * @since 1.0
 */
public class Coordinator {

    /**
     * Sujeto concreto del patrón Observer (Singleton).
     */
    private final ConcreteSubject subject = ConcreteSubject.getInstance();

    // Views
    private Content content;
    private Dashboard dashboard;
    private GenerateResolution generateResolution;
    private RegisterBeneficiary registerBeneficiary;
    private RegisterProperty registerProperty;
    private ViewBeneficiaries viewBeneficiaries;
    private SeeProperties seeProperties;
    private SeeResolutions seeResolutions;
    private ModifyResolution modifyResolution;
    private About about;

    /**
     * Encargado de iniciar la app, cargando dependencias
     * y mostrando la interfaz grafica.
     *
     * <p>
     * Notifica a los observadores para que carguen la
     * informacion necesaria al iniciar la app.
     * </p>
     */
    public void startApp() {
        startView();
        startDrivers();
        subject.notifyObservers();

        java.awt.EventQueue.invokeLater(() -> {
            content.setVisible(true);
            content.setLocationRelativeTo(null);
            content.setResizable(false);
            NavigatorUtils.showForms(dashboard);
        });
    }

    /**
     * Inicializa todas las vistas (paneles) de la aplicación.
     *
     * <p>
     * Crea las instancias de cada panel que conforma la interfaz
     * gráfica, incluyendo el dashboard, los formularios de registro,
     * los listados y la vista «Acerca de».
     * </p>
     */
    private void startView() {
        content = new Content();
        dashboard = new Dashboard();
        generateResolution = new GenerateResolution();
        registerBeneficiary = new RegisterBeneficiary();
        registerProperty = new RegisterProperty();
        viewBeneficiaries = new ViewBeneficiaries();
        seeProperties = new SeeProperties();
        seeResolutions = new SeeResolutions();
        modifyResolution = new ModifyResolution();
        about = new About();
    }

    /**
     * Inicializa y conecta todos los controladores de la aplicación.
     *
     * <p>
     * Construye el controlador principal del contenido mediante
     * {@link ControllerContentBuilder} y crea los controladores
     * de cada panel, inyectando las vistas y el sujeto del
     * patrón Observer correspondiente.
     * </p>
     */
    private void startDrivers() {
        new ControllerContentBuilder()
                .withViewContent(content)
                .withViewDashboard(dashboard)
                .withViewRegisterBeneficiary(registerBeneficiary)
                .withViewRegisterProperty(registerProperty)
                .withViewBeneficiaries(viewBeneficiaries)
                .withViewSeeProperties(seeProperties)
                .withViewSeeResolutions(seeResolutions)
                .withSubject(subject)
                .withViewAbout(about)
                .build();

        new ControllerDashboard(dashboard, subject);
        new ControllerGenerateResolution(generateResolution, subject);
        new ControllerRegisterBeneficiary(registerBeneficiary, viewBeneficiaries, subject);
        new ControllerRegisterProperty(registerProperty, subject);
        new ControllerSeeProperties(seeProperties, generateResolution, subject);
        new ControllerSeeResolutions(seeResolutions, modifyResolution, subject);
        new ControllerViewBeneficiaries(viewBeneficiaries, registerBeneficiary, subject);
        new ControllerModifyResolution(modifyResolution, seeResolutions, subject);
    }

}
