package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerDashboard;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

/**
 * Builder for configuring and constructing the {@link ControllerDashboard} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerDashboard
 * @since 1.0
 */
public class ControllerDashboardBuilder {

    private Dashboard dashboard;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the home panel (dashboard) view.
     *
     * @param dashboard dashboard view
     * @return instance of the builder for fluid chaining
     */
    public ControllerDashboardBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject  of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerDashboardBuilder withSubject(Subject subject) {
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
    public ControllerDashboardBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerDashboardBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerDashboard}.
     *
     * @return new configured instance of {@link ControllerDashboard}
     */
    public ControllerDashboard build() {
        return new ControllerDashboard(this);
    }

    public Dashboard getDashboard() {
        return dashboard;
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

}
