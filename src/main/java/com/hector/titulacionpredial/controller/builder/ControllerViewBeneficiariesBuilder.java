package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.controller.panels.ControllerViewBeneficiaries;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

/**
 * Builder for building instances of {@link ControllerViewBeneficiaries}.
 *
 * <p>
 * Centralize the injection of dependencies necessary for controller
 * configuration using a Builder design pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerViewBeneficiariesBuilder {

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
    public ControllerViewBeneficiariesBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Assign the view of the beneficiary display panel.
     *
     * @param viewBeneficiaries beneficiary display view
     * @return instance of the builder for fluid chaining
     */
    public ControllerViewBeneficiariesBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**     * with controller login.     * @param controllerLogin the controller login     * @return the with controller login     */
    public ControllerViewBeneficiariesBuilder withControllerLogin(ControllerLogin controllerLogin) {
        this.controllerLogin = controllerLogin;
        return this;
    }

    /**
     * Assign the Observer pattern subject for data notifications.
     *
     * @param subject specific subject of the Observer pattern
     * @return instance of the builder for fluid chaining
     */
    public ControllerViewBeneficiariesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Assign the subject of the Observer pattern for the language system.
     *
     * @param languageSubject subject to language change
     * @return instance of the builder for fluid chaining
     */
    public ControllerViewBeneficiariesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerViewBeneficiariesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerViewBeneficiaries}.
     *
     * @return new configured instance of {@link ControllerViewBeneficiaries}
     */
    public ControllerViewBeneficiaries build() {
        return new ControllerViewBeneficiaries(this);
    }

    /**     * get register beneficiary.     * @return the get register beneficiary     */
    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    /**     * get view beneficiaries.     * @return the get view beneficiaries     */
    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    /**     * get controller login.     * @return the get controller login     */
    public ControllerLogin getControllerLogin() {
        return controllerLogin;
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
