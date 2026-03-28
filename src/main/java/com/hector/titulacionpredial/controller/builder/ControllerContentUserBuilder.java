package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContentAdmin;
import com.hector.titulacionpredial.controller.ControllerContentUser;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerContentUserBuilder {

    private ContentUser content;
    private Dashboard dashboard;
    private RegisterBeneficiary registerBeneficiary;
    private RegisterProperty registerProperty;
    private ViewBeneficiaries viewBeneficiaries;
    private SeeProperties seeProperties;
    private SeeResolutions seeResolutions;
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
    public ControllerContentUserBuilder withViewContent(ContentUser content) {
        this.content = content;
        return this;
    }

    /**
     * Assigns the home panel (dashboard) view.
     *
     * @param dashboard dashboard view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Assign the view of the beneficiary registration panel.
     *
     * @param registerBeneficiary beneficiary registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Assign the property registration panel view.
     *
     * @param registerProperty property registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Assign the property query panel view
     *
     * @param seeProperties property search view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Assign the resolutions query panel view
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**
     * Assign the configuration panel view.
     *
     * @param settings configuration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withSubject(Subject subject) {
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
    public ControllerContentUserBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Assign the view of the «About» panel.
     *
     * @param about view of the About panel
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Assign the view of the «ContentLogin».
     *
     * @param contentLogin view of the Login
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentUserBuilder withViewLogin(ContentLogin contentLogin) {
        this.contentLogin = contentLogin;
        return this;
    }

    /**
     * Build a new instance of {@link ControllerContentAdmin}
     *
     * @return new DTO configured
     */
    public ControllerContentUser build() {
        return new ControllerContentUser(this);
    }

    public ContentUser getContent() {
        return content;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    public RegisterProperty getRegisterProperty() {
        return registerProperty;
    }

    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
    }

    public Settings getSettings() {
        return settings;
    }

    public Subject getSubject() {
        return subject;
    }

    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    public LanguageManager getLang() {
        return lang;
    }

    public About getAbout() {
        return about;
    }

    public ContentLogin getContentLogin() {
        return contentLogin;
    }

}
