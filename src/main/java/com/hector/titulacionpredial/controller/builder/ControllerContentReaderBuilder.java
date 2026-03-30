package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContentReader;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.panels.About;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;
import com.hector.titulacionpredial.view.content.panels.Settings;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

/**
 * Builder for constructing the {@link ControllerContentReader} with
 * all its views and dependencies.
 *
 * <p>
 * It allows you to smoothly configure each panel of the
 * application for reader-level access before creating the main
 * content controller using the {@link #build()} method.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentReader
 * @since 1.0
 */
public class ControllerContentReaderBuilder {

    private ContentReader content;
    private Dashboard dashboard;
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
    public ControllerContentReaderBuilder withViewContent(ContentReader content) {
        this.content = content;
        return this;
    }

    /**
     * Assigns the home panel (dashboard) view.
     *
     * @param dashboard dashboard view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Assign the property query panel view
     *
     * @param seeProperties property search view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Assign the resolutions query panel view
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**
     * Assign the configuration panel view.
     *
     * @param settings configuration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withSubject(Subject subject) {
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
    public ControllerContentReaderBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Assign the view of the «About» panel.
     *
     * @param about view of the About panel
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Assign the view of the «ContentLogin».
     *
     * @param contentLogin view of the Login
     * @return instance of the builder for fluid chaining
     */
    public ControllerContentReaderBuilder withViewLogin(ContentLogin contentLogin) {
        this.contentLogin = contentLogin;
        return this;
    }

    /**
     * Build a new instance of {@link ControllerContentReader}
     *
     * @return new controller configured with all views
     */
    public ControllerContentReader build() {
        return new ControllerContentReader(this);
    }

    /**
     * Get the main content view.
     *
     * @return the configured main content view
     */
    public ContentReader getContent() {
        return content;
    }

    /**
     * Get the dashboard panel view.
     *
     * @return the configured dashboard view
     */
    public Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * Get the beneficiary view panel.
     *
     * @return the configured beneficiary view
     */
    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    /**
     * Get the property search panel view.
     *
     * @return the configured property search view
     */
    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    /**
     * Get the resolutions query panel view.
     *
     * @return the configured resolutions query view
     */
    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
    }

    /**
     * Get the configuration panel view.
     *
     * @return the configured settings view
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Get the observer pattern subject for data notifications.
     *
     * @return the configured subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Get the observer pattern subject for language changes.
     *
     * @return the configured language subject
     */
    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    /**
     * Get the language manager instance.
     *
     * @return the configured language manager
     */
    public LanguageManager getLang() {
        return lang;
    }

    /**
     * Get the About panel view.
     *
     * @return the configured About view
     */
    public About getAbout() {
        return about;
    }

    /**
     * Get the login content view.
     *
     * @return the configured login view
     */
    public ContentLogin getContentLogin() {
        return contentLogin;
    }

}
