package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.builder.controller.ControllerContentBuilder;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author hectoracevedo
 */
public class ControllerContent {

    private final Content content;
    private final Dashboard dashboard;
    private final RegisterBeneficiary registerBeneficiary;
    private final RegisterProperty registerProperty;
    private final ViewBeneficiaries viewBeneficiaries;
    private final SeeProperties seeProperties;
    private final SeeResolutions seeResolutions;
    private final Settings settings;
    private final About about;
    private final Subject subject;

    public ControllerContent(ControllerContentBuilder builder) {
        this.content = builder.getContent();
        this.dashboard = builder.getDashboard();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.registerProperty = builder.getRegisterProperty();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.seeProperties = builder.getSeeProperties();
        this.seeResolutions = builder.getSeeResolutions();
        this.settings = builder.getSettings();
        this.about = builder.getAbout();
        this.subject = builder.getSubject();

        connectEvents();
    }

    private void connectEvents() {
        content.setControllerMenu(this::selectedMenu);
    }

    private void selectedMenu(int index, int indexSubMenu) {
        switch(index) {
            case 0 -> NavigatorUtils.showForms(dashboard);
            case 1 -> {
                switch (indexSubMenu) {
                    case 1 -> {
                        NavigatorUtils.showForms(registerBeneficiary);
                        registerBeneficiary.clearFields();
                        subject.notifyObservers();
                        registerBeneficiary.setModify(false);
                    }
                    case 2 -> NavigatorUtils.showForms(registerProperty);
                }
            }
            case 2 -> {
                switch (indexSubMenu) {
                    case 1 -> NavigatorUtils.showForms(viewBeneficiaries);
                    case 2 -> NavigatorUtils.showForms(seeProperties);
                    case 3 -> NavigatorUtils.showForms(seeResolutions);
                }
            }
            case 3 -> NavigatorUtils.showForms(settings);
            case 4 -> NavigatorUtils.showForms(about);
        }
    }

}
