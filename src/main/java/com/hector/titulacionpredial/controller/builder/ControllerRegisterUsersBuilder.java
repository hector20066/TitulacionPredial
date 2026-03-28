package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerManageUsers;
import com.hector.titulacionpredial.controller.panels.ControllerRegisterUsers;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;

/**
 * @author Ing. Hector Acevedo
 */
public class ControllerRegisterUsersBuilder {

    private RegisterUsers registerUsers;
    private LanguageManager lang;
    private Subject subject;
    private LanguageSubject languageSubject;

    public ControllerRegisterUsersBuilder withViewRegisterUsers(RegisterUsers registerUsers) {
        this.registerUsers = registerUsers;
        return this;
    }

    public ControllerRegisterUsersBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerRegisterUsersBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerRegisterUsersBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerRegisterUsers build() {
        return new ControllerManageUsers(this);
    }

    public RegisterUsers getRegisterUsers() {
        return registerUsers;
    }

    public LanguageManager getLang() {
        return lang;
    }

    public Subject getSubject() {
        return subject;
    }

    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }
}
