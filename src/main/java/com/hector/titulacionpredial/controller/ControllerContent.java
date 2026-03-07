package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOMenuText;

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
 * @see ControllerContentBuilder
 * @see NavigatorUtils
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerContent implements LanguageObserver {

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
    private final LanguageManager lang;

    /**
     * Create the controller from a builder that contains all
     * the necessary views and dependencies.
     *
     * @param builder constructor with configured views
     */
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
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        connectEvents();
    }

    /**
     * Connect the side menu events to the controller's navigation logic.
     */
    private void connectEvents() {
        content.setControllerMenu(this::selectedMenu);
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
                NavigatorUtils.showForms(dashboard);
                subject.notifyObservers();
            }
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

    @Override
    public void updateLanguage() {
        DTOMenuText dto = new DTOMenuText.Builder()
                .mainTitle(lang.app("menu.main"))
                .dashboard(lang.app("menu.main.dashboard"))
                .info(lang.app("menu.info"))
                .registerInfo(lang.app("menu.info.register"))
                .registerBeneficiaries(lang.app("menu.info.register.beneficiary"))
                .registerProperties(lang.app("menu.info.register.property"))
                .see(lang.app("menu.info.see"))
                .seeBeneficiaries(lang.app("menu.info.see.beneficiaries"))
                .seeProperties(lang.app("menu.info.see.properties"))
                .seeResolutions(lang.app("menu.info.see.resolution"))
                .configuration(lang.app("menu.configuration.title"))
                .settings(lang.app("menu.configuration.settings"))
                .aboutApp(lang.app("menu.about"))
                .about(lang.app("menu.about.desc"))
                .build();

        content.getMenu().setText(dto);
    }

}
