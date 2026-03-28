package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentReaderBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerContentReader implements LanguageObserver {

    private final ContentReader contentReader;
    private final Dashboard dashboard;
    private final ViewBeneficiaries viewBeneficiaries;
    private final SeeProperties seeProperties;
    private final SeeResolutions seeResolutions;
    private final Settings settings;
    private final About about;
    private final ContentLogin contentLogin;
    private final Subject subject;
    private final LanguageManager lang;

    public ControllerContentReader(ControllerContentReaderBuilder builder) {
        this.contentReader = builder.getContent();
        this.dashboard = builder.getDashboard();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.seeProperties = builder.getSeeProperties();
        this.seeResolutions = builder.getSeeResolutions();
        this.settings = builder.getSettings();
        this.about = builder.getAbout();
        this.contentLogin = builder.getContentLogin();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        connectEvents();
    }

    /**
     * Connect the side menu events to the controller's navigation logic.
     */
    private void connectEvents() {
        contentReader.setControllerMenu(this::selectedMenu);
        contentReader.setControllerLogout(e -> logout());
    }

    private void selectedMenu(int index, int indexSubMenu) {
        switch (index) {
            case 0 -> {
                NavigatorUtils.showForms(ContentReader.getJpl_content(), dashboard);
                subject.notifyObservers();
            }
            case 1 -> {
                switch (indexSubMenu) {
                    case 1 -> NavigatorUtils.showForms(ContentReader.getJpl_content(), viewBeneficiaries);
                    case 2 -> NavigatorUtils.showForms(ContentReader.getJpl_content(), seeProperties);
                    case 3 -> NavigatorUtils.showForms(ContentReader.getJpl_content(), seeResolutions);
                }
            }
            case 2 -> NavigatorUtils.showForms(ContentReader.getJpl_content(), settings);
            case 3 -> NavigatorUtils.showForms(ContentReader.getJpl_content(), about);
        }
    }

    @Override
    public void updateLanguage() {

    }

    public void prepareUI() {
        viewBeneficiaries.getBtn_delete().setVisible(false);
        viewBeneficiaries.getBtn_modify().setVisible(false);
        seeProperties.getBtn_delete().setVisible(false);
        seeProperties.getBtn_generate().setVisible(false);
        seeResolutions.getBtn_modify().setVisible(false);
    }

    private void logout() {
        this.contentLogin.setVisible(true);
        this.contentLogin.setResizable(false);
        this.contentLogin.setLocationRelativeTo(null);
        this.contentLogin.getBtn_login().setEnabled(true);
        this.contentLogin.getBtn_login().setText("INICIAR SESION");
        contentReader.setVisible(false);
        contentReader.dispose();
    }

}
