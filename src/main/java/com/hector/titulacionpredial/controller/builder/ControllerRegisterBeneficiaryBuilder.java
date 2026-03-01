package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerRegisterBeneficiary;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerRegisterBeneficiaryBuilder {

    private RegisterBeneficiary registerBeneficiary;
    private ViewBeneficiaries viewBeneficiaries;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerRegisterBeneficiaryBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    public ControllerRegisterBeneficiaryBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    public ControllerRegisterBeneficiaryBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerRegisterBeneficiaryBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerRegisterBeneficiaryBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerRegisterBeneficiary build() {
        return new ControllerRegisterBeneficiary(this);
    }

    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
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
