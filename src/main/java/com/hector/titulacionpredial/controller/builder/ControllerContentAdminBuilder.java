package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContentAdmin;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder to build the {@link ControllerContentAdmin} with
 * all its views and dependencies.
 *
 * <p>
 * It allows you tu smoothly configure each panel of the
 * application before creating the main content controller
 * using the {@link #build()} method.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentAdmin
 * @since 1.0
 */
public class ControllerContentAdminBuilder {

    private ContentAdmin content;
    private Dashboard dashboard;
    private RegisterBeneficiary registerBeneficiary;
    private RegisterProperty registerProperty;
    private ViewBeneficiaries viewBeneficiaries;
    private SeeProperties seeProperties;
    private SeeResolutions seeResolutions;
    private RegisterUsers registerUsers;
    private ManageUsers manageUsers;
    private Settings settings;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;
    private About about;
    private ContentLogin contentLogin;

    /**
     * Assigns the main view of the application content.
     *
     * @param content Main view of the content
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewContent(ContentAdmin content) {
        this.content = content;
        return this;
    }

    /**
     * Assigns the home panel (dashboard) view.
     *
     * @param dashboard dashboard view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Assign the view of the beneficiary registration panel.
     *
     * @param registerBeneficiary beneficiary registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Assign the property registration panel view.
     *
     * @param registerProperty property registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Assign the property query panel view
     *
     * @param seeProperties property search view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Assign the resolutions query panel view
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**     * with view register users.     * @param registerUsers the register users     * @return the with view register users     */
    public ControllerContentAdminBuilder withViewRegisterUsers(RegisterUsers registerUsers) {
        this.registerUsers = registerUsers;
        return this;
    }

    /**     * wit view manage users.     * @param manageUsers the manage users     * @return the wit view manage users     */
    public ControllerContentAdminBuilder witViewManageUsers(ManageUsers manageUsers) {
        this.manageUsers = manageUsers;
        return this;
    }

    /**
     * Assign the configuration panel view.
     *
     * @param settings configuration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Assign the subject of the Observer pattern for the
     * language system.
     *
     * @param languageSubject subject to language change
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Assign the view of the «About» panel.
     *
     * @param about view of the About panel
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Assign the view of the «ContentLogin».
     *
     * @param contentLogin view of the Login
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentAdminBuilder withViewLogin(ContentLogin contentLogin) {
        this.contentLogin = contentLogin;
        return this;
    }

    /**
     * Build a new instance of {@link ControllerContentAdmin}
     *
     * @return new DTO configured
     */
    public ControllerContentAdmin build() {
        return new ControllerContentAdmin(this);
    }

    /**     * get content.     * @return the get content     */
    public ContentAdmin getContent() {
        return content;
    }

    /**     * get dashboard.     * @return the get dashboard     */
    public Dashboard getDashboard() {
        return dashboard;
    }

    /**     * get register beneficiary.     * @return the get register beneficiary     */
    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    /**     * get register property.     * @return the get register property     */
    public RegisterProperty getRegisterProperty() {
        return registerProperty;
    }

    /**     * get view beneficiaries.     * @return the get view beneficiaries     */
    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    /**     * get see properties.     * @return the get see properties     */
    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    /**     * get see resolutions.     * @return the get see resolutions     */
    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
    }

    /**     * get register users.     * @return the get register users     */
    public RegisterUsers getRegisterUsers() {
        return registerUsers;
    }

    /**     * get manage users.     * @return the get manage users     */
    public ManageUsers getManageUsers() {
        return manageUsers;
    }

    /**     * get settings.     * @return the get settings     */
    public Settings getSettings() {
        return settings;
    }

    /**     * get subject.     * @return the get subject     */
    public Subject getSubject() {
        return subject;
    }

    /**     * get language subject.     * @return the get language subject     */
    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    /**     * get lang.     * @return the get lang     */
    public LanguageManager getLang() {
        return lang;
    }

    /**     * get about.     * @return the get about     */
    public About getAbout() {
        return about;
    }

    /**     * get content login.     * @return the get content login     */
    public ContentLogin getContentLogin() {
        return contentLogin;
    }

}
