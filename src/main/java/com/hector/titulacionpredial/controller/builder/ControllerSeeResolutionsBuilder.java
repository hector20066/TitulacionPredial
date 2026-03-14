package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.panels.ControllerSeeResolutions;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

/**
 * Builder for building instances of {@link ControllerSeeResolutions}.
 *
 * <p>
 * Centralize the injection of dependencies necessary for controller
 * configuration using a Builder design pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSeeResolutionsBuilder {

    private ModifyResolution modifyResolution;
    private SeeResolutions seeResolutions;
    private ControllerLogin controllerLogin;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the resolution modification panel view.
     *
     * @param modifyResolution view of resolution modification
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeeResolutionsBuilder withViewModifyResolution(ModifyResolution modifyResolution) {
        this.modifyResolution = modifyResolution;
        return this;
    }

    /**
     * Assign the resolutions query panel view.
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeeResolutionsBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    public ControllerSeeResolutionsBuilder withControllerLogin(ControllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeeResolutionsBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Assign the subject of the Observer pattern for the language system.
     *
     * @param languageSubject subject to language change
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeeResolutionsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerSeeResolutionsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerSeeResolutions}.
     *
     * @return new configured instance of {@link ControllerSeeResolutions}
     */
    public ControllerSeeResolutions build() {
        return new ControllerSeeResolutions(this);
    }

    public ModifyResolution getModifyResolution() {
        return modifyResolution;
    }

    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
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
