package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerViewBeneficiaries;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerViewBeneficiariesBuilder {

    private RegisterBeneficiary registerBeneficiary;
    private ViewBeneficiaries viewBeneficiaries;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerViewBeneficiariesBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    public ControllerViewBeneficiariesBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    public ControllerViewBeneficiariesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerViewBeneficiariesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerViewBeneficiariesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerViewBeneficiaries build() {
        return new ControllerViewBeneficiaries(this);
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
