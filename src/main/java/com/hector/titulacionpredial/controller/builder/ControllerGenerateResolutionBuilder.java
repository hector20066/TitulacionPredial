package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerGenerateResolution;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

/**
 * Builder for building instances of {@link ControllerGenerateResolution}.
 *
 * <p>
 * Centralize the injection of dependencies necessary for
 * controller configuration using a Builder design pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
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

    /**     * get generate resolution.     * @return the get generate resolution     */
    public GenerateResolution getGenerateResolution() {
        return generateResolution;
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

}
