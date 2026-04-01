package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.panels.ControllerRegisterBeneficiary;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

/**
 * Builder for configuring and constructing the {@link ControllerRegisterBeneficiary} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerRegisterBeneficiary
 * @since 1.0
 */
public class ControllerRegisterBeneficiaryBuilder {

    private RegisterBeneficiary registerBeneficiary;
    private ViewBeneficiaries viewBeneficiaries;
    private ControllerLogin controllerLogin;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the view of the beneficiary registration panel.
     *
     * @param registerBeneficiary beneficiary registration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerRegisterBeneficiaryBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerRegisterBeneficiaryBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * with controller login.
     *
     * @param controllerLogin the controller login
     * @return the with controller login
     */
    public ControllerRegisterBeneficiaryBuilder withControllerLogin(ControllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerRegisterBeneficiaryBuilder withSubject(Subject subject) {
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
    public ControllerRegisterBeneficiaryBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerRegisterBeneficiaryBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerRegisterBeneficiary}.
     *
     * @return new configured instance of {@link ControllerRegisterBeneficiary}
     */
    public ControllerRegisterBeneficiary build() {
        return new ControllerRegisterBeneficiary(this);
    }

    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
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
