package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerGenerateResolution;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

/**
 * Builder for configuring and constructing the {@link ControllerGenerateResolution} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerGenerateResolution
 * @since 1.0
 */
public class ControllerGenerateResolutionBuilder {

    private GenerateResolution generateResolution;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the resolution generation panel view.
     *
     * @param generateResolution resolution generation view
     * @return instance of the builder for fluid chaining
     */
    public ControllerGenerateResolutionBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerGenerateResolutionBuilder withSubject(Subject subject) {
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
    public ControllerGenerateResolutionBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerGenerateResolutionBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerGenerateResolution}.
     *
     * @return new configured instance of {@link ControllerGenerateResolution}
     */
    public ControllerGenerateResolution build() {
        return new ControllerGenerateResolution(this);
    }

    public GenerateResolution getGenerateResolution() {
        return generateResolution;
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
