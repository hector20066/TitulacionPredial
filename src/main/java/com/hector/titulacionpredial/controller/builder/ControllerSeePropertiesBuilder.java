package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.panels.ControllerSeeProperties;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;

/**
 * Builder for building instances of {@link ControllerSeeProperties}.
 *
 * <p>
 * Centralize the injection of dependencies necessary for controller
 * configuration using a Builder design pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSeePropertiesBuilder {

    private GenerateResolution generateResolution;
    private SeeProperties seeProperties;
    private ControllerLogin controllerLogin;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the resolution generation panel view.
     *
     * @param generateResolution resolution generation view
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeePropertiesBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    /**
     * Assign the property query panel view.
     *
     * @param seeProperties property search view
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeePropertiesBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    public ControllerSeePropertiesBuilder withControllerLogin(ControllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeePropertiesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Assign the subject of the Observer pattern for the language system.
     *
     * @param languageSubject subject to language change
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeePropertiesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeePropertiesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerSeeProperties}.
     *
     * @return new configured instance of {@link ControllerSeeProperties}
     */
    public ControllerSeeProperties build() {
        return new ControllerSeeProperties(this);
    }

    public GenerateResolution getGenerateResolution() {
        return generateResolution;
    }

    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    public ControllerLogin getControllerLogin() {
        return controllerLogin;
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
