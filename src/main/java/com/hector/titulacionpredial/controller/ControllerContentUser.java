package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentUserBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.About;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.content.panels.Settings;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

/**
 * Controller for user content navigation and interaction.
 *
 * <p>
 * Manages the user interface for standard employee access, handling navigation
 * between different panels via the side menu. Implements the
 * {@link LanguageObserver} to support dynamic language changes.
 * </p>
 *
 * <p>
 * This controller provides standard functionality for employee users,
 * allowing registration and viewing of beneficiaries and properties
 * with limited administrative capabilities.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentUserBuilder
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerContentUser implements LanguageObserver {

    private final ContentUser contentUser;
    private final Dashboard dashboard;
    private final RegisterBeneficiary registerBeneficiary;
    private final RegisterProperty registerProperty;
    private final ViewBeneficiaries viewBeneficiaries;
    private final SeeProperties seeProperties;
    private final SeeResolutions seeResolutions;
    private final Settings settings;
    private final About about;
    private final ContentLogin contentLogin;
    private final Subject subject;
    private final LanguageManager lang;

    /**
     * Create the controller from a builder that contains all
     * the necessary views and dependencies.
     *
     * @param builder constructor with configured views
     */
    public ControllerContentUser(ControllerContentUserBuilder builder) {
        this.contentUser = builder.getContent();
        this.dashboard = builder.getDashboard();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.registerProperty = builder.getRegisterProperty();
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
        contentUser.setControllerMenu(this::selectedMenu);
        contentUser.setControllerLogout(e -> logout());
    }

    /**
     * Manage the selection from the side menu and navigate to the
     * corresponding panel.
     *
     * <p>
     * Based on the selected menu and submenu index, it displays
     * the appropriate panel and notifies observers when data
     * needs to be updated.
     * </p>
     *
     * @param index        main menu index
     * @param indexSubMenu index of the selected submenu
     */
    private void selectedMenu(int index, int indexSubMenu) {
        switch (index) {
            case 0 -> {
                NavigatorUtils.showForms(ContentUser.getJpl_content(), dashboard);
                subject.notifyObservers();
            }
            case 1 -> {
                switch (indexSubMenu) {
                    case 1 -> {
                        NavigatorUtils.showForms(ContentUser.getJpl_content(), registerBeneficiary);
                        registerBeneficiary.clearFields();
                        registerBeneficiary.setModify(false);
                    }
                    case 2 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), registerProperty);
                }
            }
            case 2 -> {
                switch (indexSubMenu) {
                    case 1 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), viewBeneficiaries);
                    case 2 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), seeProperties);
                    case 3 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), seeResolutions);
                }
            }
            case 3 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), settings);
            case 4 -> NavigatorUtils.showForms(ContentUser.getJpl_content(), about);
        }
    }

    /**
     * Update the interface language based on current language selection.
     */
    @Override
    public void updateLanguage() {

    }

    /**
     * Perform logout operation and return to login screen.
     *
     * <p>
     * Closes the current user content window and displays the login
     * view, disposing of all resources associated with this session.
     * </p>
     */
    private void logout() {
        this.contentLogin.setVisible(true);
        this.contentLogin.setResizable(false);
        this.contentLogin.setLocationRelativeTo(null);
        this.contentLogin.getBtn_login().setEnabled(true);
        this.contentLogin.getBtn_login().setText(lang.app("controller.content.login"));
        contentUser.setVisible(false);
        contentUser.dispose();
    }

}
