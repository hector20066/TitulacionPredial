package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.builder.controller.ControllerContentBuilder;
import com.hector.titulacionpredial.controller.panels.*;
import com.hector.titulacionpredial.observer.ConcreteSubject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author hectoracevedo
 */
public class Coordinator {

    // Observer
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
    private Settings settings;
    private About about;

    // Drivers
    private ControllerContent controllerContent;
    private ControllerDashboard controllerDashboard;
    private ControllerGenerateResolution controllerGenerateResolution;
    private ControllerRegisterBeneficiary controllerRegisterBeneficiary;
    private ControllerRegisterProperty controllerRegisterProperty;
    private ControllerSeeProperties controllerSeeProperties;
    private ControllerSeeResolutions controllerSeeResolutions;
    private ControllerSettings controllerSettings;
    private ControllerViewBeneficiaries controllerViewBeneficiaries;
    private ControllerModifyResolution controllerModifyResolution;

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
        about = new About();
    }

    private void startDrivers() {
        controllerContent = new ControllerContentBuilder()
                .withViewContent(content)
                .withViewDashboard(dashboard)
                .withViewRegisterBeneficiary(registerBeneficiary)
                .withViewRegisterProperty(registerProperty)
                .withViewBeneficiaries(viewBeneficiaries)
                .withViewSeeProperties(seeProperties)
                .withViewSeeResolutions(seeResolutions)
                .withViewSettings(settings)
                .withViewAbout(about)
                .build();

        controllerDashboard = new ControllerDashboard(dashboard, subject);
        controllerGenerateResolution = new ControllerGenerateResolution(generateResolution, subject);
        controllerRegisterBeneficiary = new ControllerRegisterBeneficiary(registerBeneficiary, subject);
        controllerRegisterProperty = new ControllerRegisterProperty(registerProperty, subject);
        controllerSeeProperties = new ControllerSeeProperties(seeProperties, generateResolution, subject);
        controllerSeeResolutions = new ControllerSeeResolutions(seeResolutions, modifyResolution, subject);
        controllerSettings = new ControllerSettings(settings);
        controllerViewBeneficiaries = new ControllerViewBeneficiaries(viewBeneficiaries, subject);
        controllerModifyResolution = new ControllerModifyResolution(modifyResolution, seeResolutions, subject);
    }

}
