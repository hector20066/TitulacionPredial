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
    private About about;

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
        about = new About();
    }

    private void startDrivers() {
        ControllerContent controllerContent = new ControllerContentBuilder()
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

        ControllerDashboard controllerDashboard = new ControllerDashboard(dashboard, subject);
        ControllerGenerateResolution controllerGenerateResolution = new ControllerGenerateResolution(generateResolution, subject);
        ControllerRegisterBeneficiary controllerRegisterBeneficiary = new ControllerRegisterBeneficiary(registerBeneficiary, viewBeneficiaries, subject);
        ControllerRegisterProperty controllerRegisterProperty = new ControllerRegisterProperty(registerProperty, subject);
        ControllerSeeProperties controllerSeeProperties = new ControllerSeeProperties(seeProperties, generateResolution, subject);
        ControllerSeeResolutions controllerSeeResolutions = new ControllerSeeResolutions(seeResolutions, modifyResolution, subject);
        ControllerViewBeneficiaries controllerViewBeneficiaries = new ControllerViewBeneficiaries(viewBeneficiaries, registerBeneficiary, subject);
        ControllerModifyResolution controllerModifyResolution = new ControllerModifyResolution(modifyResolution, seeResolutions, subject);
    }

}
