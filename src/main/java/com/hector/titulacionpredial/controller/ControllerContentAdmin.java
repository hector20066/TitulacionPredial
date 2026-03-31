package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentAdminBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.panels.About;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.content.panels.Settings;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOAdminMenuText;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOContentLogoutBtnText;

/**
 * Main controller of application content.
 *
 * <p>
 * Manage navigation between the different panels of the graphical
 * interface through the side menu. Coordinate the transition between
 * views and notify the {@link Subject} when data updates are required.
 * </p>
 *
 * <p>
 * Implement {@link LanguageObserver} as a concrete observer of the
 * Observer pattern, allowing the view to be automatically updated
 * when the {@link LanguageSubject} notifies a language change.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentAdminBuilder
 * @see NavigatorUtils
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerContentAdmin implements LanguageObserver {

    private final ContentAdmin content;
    private final Dashboard dashboard;
    private final RegisterBeneficiary registerBeneficiary;
    private final RegisterProperty registerProperty;
    private final ViewBeneficiaries viewBeneficiaries;
    private final SeeProperties seeProperties;
    private final SeeResolutions seeResolutions;
    private final RegisterUsers registerUsers;
    private final ManageUsers seeUsers;
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
    public ControllerContentAdmin(ControllerContentAdminBuilder builder) {
        this.content = builder.getContent();
        this.dashboard = builder.getDashboard();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.registerProperty = builder.getRegisterProperty();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.seeProperties = builder.getSeeProperties();
        this.seeResolutions = builder.getSeeResolutions();
        this.registerUsers = builder.getRegisterUsers();
        this.seeUsers = builder.getManageUsers();
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
        content.setControllerMenu(this::selectedMenu);
        content.setControllerLogout(e -> logout());
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
                NavigatorUtils.showForms(ContentAdmin.getJpl_content(), dashboard);
                subject.notifyObservers();
            }
            case 1 -> {
                switch (indexSubMenu) {
                    case 1 -> {
                        NavigatorUtils.showForms(ContentAdmin.getJpl_content(), registerBeneficiary);
                        registerBeneficiary.clearFields();
                        registerBeneficiary.setModify(false);
                        registerBeneficiary.getBtn_addBeneficiaries().setVisible(true);
                    }
                    case 2 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), registerProperty);
                }
            }
            case 2 -> {
                switch (indexSubMenu) {
                    case 1 -> {
                        NavigatorUtils.showForms(ContentAdmin.getJpl_content(), viewBeneficiaries);
                        viewBeneficiaries.getBtn_modify().setEnabled(true);
                        viewBeneficiaries.getBtn_modify().setText("Modificar");
                    }
                    case 2 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), seeProperties);
                    case 3 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), seeResolutions);
                }
            }
            case 3 -> {
                switch (indexSubMenu) {
                    case 1 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), registerUsers);
                    case 2 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), seeUsers);
                }
            }
            case 4 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), settings);
            case 5 -> NavigatorUtils.showForms(ContentAdmin.getJpl_content(), about);
        }
    }

    /**
     * Update the interface language based on current language selection.
     *
     * <p>
     * Populates the menu text with localized strings from the language
     * manager for all menu items.
     * </p>
     */
    @Override
    public void updateLanguage() {
        DTOAdminMenuText dto = new DTOAdminMenuText.Builder()
                .mainTitle(lang.app("admin.menu.main.title"))
                .dashboard(lang.app("admin.menu.main.item1"))
                .info(lang.app("admin.menu.info.title"))
                .registerInfo(lang.app("admin.menu.info.register"))
                .registerBeneficiaries(lang.app("admin.menu.info.register.item1"))
                .registerProperties(lang.app("admin.menu.info.register.item2"))
                .see(lang.app("admin.menu.info.see"))
                .seeBeneficiaries(lang.app("admin.menu.info.see.item1"))
                .seeProperties(lang.app("admin.menu.info.see.item2"))
                .seeResolutions(lang.app("admin.menu.info.see.item3"))
                .manageUsers(lang.app("admin.menu.usermanage.title"))
                .users(lang.app("admin.menu.usermanage.subtitle"))
                .registerUser(lang.app("admin.menu.usermanage.item1"))
                .seeUsers(lang.app("admin.menu.usermanage.item2"))
                .configuration(lang.app("admin.menu.configuration.title"))
                .settings(lang.app("admin.menu.settings"))
                .aboutApp(lang.app("admin.menu.about.title"))
                .about(lang.app("admin.menu.about"))
                .build();

        DTOContentLogoutBtnText dtoLogout = new DTOContentLogoutBtnText.Builder()
                .logout(lang.app("content.logout"))
                .build();

        content.getMenu().setText(dto);
        content.updateLanguage(dtoLogout);
    }

    /**
     * Perform logout operation and return to login screen.
     *
     * <p>
     * Closes the current admin content window and displays the login
     * view, disposing of all resources associated with this session.
     * </p>
     */
    private void logout() {
        this.contentLogin.setVisible(true);
        this.contentLogin.setResizable(false);
        this.contentLogin.setLocationRelativeTo(null);
        this.contentLogin.getBtn_login().setEnabled(true);
        this.contentLogin.getBtn_login().setText(lang.app("controller.content.login"));
        this.content.setVisible(false);
        this.content.dispose();
    }

}
