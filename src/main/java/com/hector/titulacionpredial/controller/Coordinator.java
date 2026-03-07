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
 * Main coordinator of the application.
 *
 * <p>
 * It handles initializing all the application's views and controllers,
 * connecting them, and starting the graphical interface. It implements
 * the Coordinator pattern to centralize system construction and
 * configuration.
 * </p>
 *
 * <p>
 * Startup flow:
 * </p>
 * <ol>
 *   <li>Create the views</li>
 *   <li>Create the controllers</li>
 *   <li>Notify observers to upload initial data</li>
 *   <li>Show the main window</li>
 * </ol>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentBuilder
 * @see ConcreteSubject
 * @since 1.0
 */
public class Coordinator {

    private final ConcreteSubject subject = ConcreteSubject.getInstance();
    private final ConcreteLanguageSubject languageSubject = ConcreteLanguageSubject.getInstance();
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
     * Responsible for starting the app, loading dependencies,
     * and displaying the graphical interface.
     *
     * <p>
     * Notify observers to upload the necessary information
     * when starting the app.
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
     * Load the application language from the user settings.
     *
     * <p>
     * It retrieves the language stored in the user's
     * preferences, applies it to the language manager,
     * and notifies language change observers to update
     * the graphical interface.
     * </p>
     */
    private void loadLanguage() {
        String language = UserConfig.get("app.language");
        lang.setLanguage(AppLanguage.valueOf(language.toUpperCase()));
        languageSubject.notifyObserver();

        controllerSettings.selectLanguageRadio(language);
    }

    /**
     * Initializes all views (panels) of the application.
     *
     * <p>
     * Create instances of each panel that makes up the
     * graphical interface, including the dashboard,
     * registration forms, listings, and the «About» view.
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
     * Initialize and connect all application controllers.
     *
     * <p>
     * Build the main content controller using
     * {@link ControllerContentBuilder} and create the
     * controllers for each panel, injecting the views
     * and subject of the corresponding Observer pattern.
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
