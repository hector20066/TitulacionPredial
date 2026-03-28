package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerManageUsers;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;

/**
 * @author Ing. Hector Acevedo
 */
public class ControllerManageUsersBuilder {

    private ManageUsers manageUsers;
    private LanguageManager lang;
    private Subject subject;
    private LanguageSubject languageSubject;

    public ControllerManageUsersBuilder withViewManageUsers(ManageUsers manageUsers) {
        this.manageUsers = manageUsers;
        return this;
    }

    public ControllerManageUsersBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    public ControllerManageUsersBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerManageUsersBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerManageUsers build() {
        return new ControllerManageUsers(this);
    }

    public ManageUsers getManageUsers() {
        return manageUsers;
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
