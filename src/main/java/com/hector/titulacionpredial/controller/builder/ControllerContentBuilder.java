package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContent;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder to build the {@link ControllerContent} with
 * all its views and dependencies.
 *
 * <p>
 * It allows you tu smoothly configure each panel of the
 * application before creating the main content controller
 * using the {@link #build()} method.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContent
 * @since 1.0
 */
public class ControllerContentBuilder {

    private Content content;
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

    /**
     * Assigns the main view of the application content.
     *
     * @param content Main view of the content
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewContent(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Assigns the home panel (dashboard) view.
     *
     * @param dashboard dashboard view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Assign the view of the beneficiary registration panel.
     *
     * @param registerBeneficiary beneficiary registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Assign the property registration panel view.
     *
     * @param registerProperty property registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Assign the property query panel view
     *
     * @param seeProperties property search view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Assign the resolutions query panel view
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**
     * Assign the configuration panel view.
     *
     * @param settings configuration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withSubject(Subject subject) {
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
    public ControllerContentBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Assign the view of the «About» panel.
     *
     * @param about view of the About panel
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Build a new instance of {@link ControllerContent}
     *
     * @return new DTO configured
     */
    public ControllerContent build() {
        return new ControllerContent(this);
    }

    public Content getContent() {
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

}
