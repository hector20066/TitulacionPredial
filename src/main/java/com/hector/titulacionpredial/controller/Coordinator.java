package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerDashboardBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerGenerateResolutionBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerModifyResolutionBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerRegisterBeneficiaryBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerRegisterPropertyBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerSeePropertiesBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerSeeResolutionsBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerSettingsBuilder;
import com.hector.titulacionpredial.controller.builder.ControllerViewBeneficiariesBuilder;
import com.hector.titulacionpredial.controller.panels.ControllerSettings;
import com.hector.titulacionpredial.i18n.AppLanguage;
import com.hector.titulacionpredial.i18n.ConcreteLanguageSubject;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.observer.ConcreteSubject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.UserConfig;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.About;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.content.panels.Settings;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

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

    /**
     * Sujeto concreto del patron Observer para el sistema i18n
     */
    private final ConcreteLanguageSubject languageSubject = ConcreteLanguageSubject.getInstance();

    /**
     * Gestor de i18n de la aplicación
     */
    private final LanguageManager lang = LanguageManager.getInstance();

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
    private Settings settings;
    private About about;

    private ControllerSettings controllerSettings;

    /**
     * Encargado de iniciar la app, cargando dependencias
     * y mostrando la interfaz gráfica.
     *
     * <p>
     * Notifica a los observadores para que carguen la
     * información necesaria al iniciar la app.
     * </p>
     */
    public void startApp() {
        startView();
        startDrivers();
        loadLanguage();
        subject.notifyObservers();

        java.awt.EventQueue.invokeLater(() -> {
            content.setVisible(true);
            content.setLocationRelativeTo(null);
            content.setResizable(false);
            NavigatorUtils.showForms(dashboard);
        });
    }

    /**
     * Carga el idioma de la aplicación desde la configuración del usuario.
     *
     * <p>
     * Obtiene el idioma almacenado en las preferencias del usuario,
     * lo aplica al gestor de idiomas y notifica a los observadores
     * de cambio de idioma para actualizar la interfaz gráfica.
     * </p>
     */
    private void loadLanguage() {
        String language = UserConfig.get("app.language");
        lang.setLanguage(AppLanguage.valueOf(language.toUpperCase()));
        languageSubject.notifyObserver();

        controllerSettings.selectLanguageRadio(language);
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
        settings = new Settings();
        about = new About(lang, languageSubject);
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
                .withViewSettings(settings)
                .withSubject(subject)
                .withViewAbout(about)
                .withLanguageManager(lang)
                .withLanguageSubject(languageSubject)
                .build();

        new ControllerDashboardBuilder()
                .withViewDashboard(dashboard)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerGenerateResolutionBuilder()
                .withViewGenerateResolution(generateResolution)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerRegisterBeneficiaryBuilder()
                .withViewRegisterBeneficiary(registerBeneficiary)
                .withViewBeneficiaries(viewBeneficiaries)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerRegisterPropertyBuilder()
                .withViewRegisterProperty(registerProperty)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerSeePropertiesBuilder()
                .withViewGenerateResolution(generateResolution)
                .withViewSeeProperties(seeProperties)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerSeeResolutionsBuilder()
                .withViewSeeResolutions(seeResolutions)
                .withViewModifyResolution(modifyResolution)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerViewBeneficiariesBuilder()
                .withViewRegisterBeneficiary(registerBeneficiary)
                .withViewBeneficiaries(viewBeneficiaries)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        new ControllerModifyResolutionBuilder()
                .withViewModifyResolution(modifyResolution)
                .withViewSeeResolutions(seeResolutions)
                .withSubject(subject)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();

        controllerSettings = new ControllerSettingsBuilder()
                .withViewSettings(settings)
                .withLanguageSubject(languageSubject)
                .withLanguageManager(lang)
                .build();
    }

}
