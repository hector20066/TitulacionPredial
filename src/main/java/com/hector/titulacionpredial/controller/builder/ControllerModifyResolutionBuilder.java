package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.panels.ControllerModifyResolution;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

/**
 * Builder for configuring and constructing the {@link ControllerModifyResolution} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerModifyResolution
 * @since 1.0
 */
public class ControllerModifyResolutionBuilder {

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
    public ControllerModifyResolutionBuilder withViewModifyResolution(ModifyResolution modifyResolution) {
        this.modifyResolution = modifyResolution;
        return this;
    }

    /**
     * Assign the resolutions query panel view.
     *
     * @param seeResolutions resolutions query view
     * @return instance of the builder for fluid chaining
     */
    public ControllerModifyResolutionBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**     * with controller login.     * @param controllerLogin the controller login     * @return the with controller login     */
    public ControllerModifyResolutionBuilder withControllerLogin(ControllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern.
     * @return instance of the builder for fluid chaining
     */
    public ControllerModifyResolutionBuilder withSubject(Subject subject) {
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
    public ControllerModifyResolutionBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerModifyResolutionBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Builder and initialize a new instance of {@link ControllerModifyResolution}.
     *
     * @return new configured instance of {@link ControllerModifyResolution}
     */
    public ControllerModifyResolution build() {
        return new ControllerModifyResolution(this);
    }

    public ModifyResolution getModifyResolution() {
        return modifyResolution;
    }

    public ControllerLogin getControllerLogin() {
        return controllerLogin;
    }

    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
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
