package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentReaderBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.panels.*;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOContentLogoutBtnText;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOReadingMenuText;

/**
 * Controller for reader content navigation and interaction.
 *
 * <p>
 * Manages the user interface for read-only access, handling navigation
 * between different panels via the side menu. Implements the
 * {@link LanguageObserver} to support dynamic language changes.
 * </p>
 *
 * <p>
 * This controller provides restricted functionality compared to the
 * admin controller, hiding modification and deletion buttons where
 * appropriate for read-only access.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentReaderBuilder
 * @see LanguageObserver
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

    /**
     * Create the controller from a builder that contains all
     * the necessary views and dependencies.
     *
     * @param builder constructor with configured views
     */
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

        connectEvents();
        builder.getLanguageSubject().register(this);
    }

    /**
     * Connect the side menu events to the controller's navigation logic.
     */
    private void connectEvents() {
        contentReader.setControllerMenu(this::selectedMenu);
        contentReader.setControllerLogout(e -> logout());
    }

    /**
     * Manage the selection from the side menu and navigate to the
     * corresponding panel.
     *
     * <p>
     * Based on the selected menu and submenu index, it displays the
     * appropriate panel and notifies observers when data needs to be
     * updated.
     * </p>
     *
     * @param index        main menu index
     * @param indexSubMenu index of the selected submenu
     */
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
        DTOReadingMenuText dto = new DTOReadingMenuText.Builder()
                .mainTitle(lang.app("read.menu.main.title"))
                .dashboard(lang.app("read.menu.main.item1"))
                .info(lang.app("read.menu.info.title"))
                .see(lang.app("read.menu.info.see"))
                .seeBeneficiaries(lang.app("read.menu.info.see.item1"))
                .seeProperties(lang.app("read.menu.info.see.item2"))
                .seeResolutions(lang.app("read.menu.info.see.item3"))
                .configuration(lang.app("read.menu.configuration.title"))
                .settings(lang.app("read.menu.settings"))
                .aboutApp(lang.app("read.menu.about.title"))
                .about(lang.app("read.menu.about"))
                .build();

        DTOContentLogoutBtnText dtoLogout = new DTOContentLogoutBtnText.Builder()
                .logout(lang.app("content.logout"))
                .build();

        contentReader.getMenu().setText(dto);
        contentReader.updateLanguage(dtoLogout);
    }

    /**
     * Hide specific action buttons for read-only mode.
     *
     * <p>
     * Hides delete and modify buttons in the beneficiary, property,
     * and resolution views to enforce read-only access restrictions.
     * </p>
     */
    public void hideButtons() {
        viewBeneficiaries.getBtn_delete().setVisible(false);
        viewBeneficiaries.getBtn_modify().setVisible(false);
        seeProperties.getBtn_delete().setVisible(false);
        seeProperties.getBtn_generate().setVisible(false);
        seeResolutions.getBtn_modify().setVisible(false);
    }

    /**
     * Perform logout operation and return to login screen.
     *
     * <p>
     * Closes the current reader content window and displays the login
     * view, disposing of all resources associated with this session.
     * </p>
     */
    private void logout() {
        this.contentLogin.setVisible(true);
        this.contentLogin.setResizable(false);
        this.contentLogin.setLocationRelativeTo(null);
        this.contentLogin.getBtn_login().setEnabled(true);
        this.contentLogin.getBtn_login().setText(lang.app("controller.content.login"));
        this.contentReader.dispose();
    }

}
