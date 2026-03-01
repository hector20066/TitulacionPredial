package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerRegisterProperty;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerRegisterPropertyBuilder {

    private RegisterProperty registerProperty;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerRegisterPropertyBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    public ControllerRegisterPropertyBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerRegisterPropertyBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerRegisterPropertyBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerRegisterProperty build() {
        return new ControllerRegisterProperty(this);
    }

    public RegisterProperty getRegisterProperty() {
        return registerProperty;
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
