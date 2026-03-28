package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContentReader;
import com.hector.titulacionpredial.controller.ControllerLogin;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

/**
 * @author Ing. Hector Acevedo
 */
public class ControllerLoginBuilder {

    private ContentLogin login;
    private ContentAdmin contentAdmin;
    private ContentUser contentUser;
    private ContentReader contentReader;
    private Dashboard dashboard;
    private Subject subject;
    private LanguageManager lang;
    private ControllerContentReader controllerContentReader;
    private LanguageSubject languageSubject;

    public ControllerLoginBuilder withViewLogin(ContentLogin login) {
        this.login = login;
        return this;
    }

    public ControllerLoginBuilder withContentAdmin(ContentAdmin contentAdmin) {
        this.contentAdmin = contentAdmin;
        return this;
    }

    public ControllerLoginBuilder withContentUser(ContentUser contentUser) {
        this.contentUser = contentUser;
        return this;
    }

    public ControllerLoginBuilder withContentReader(ContentReader contentReader) {
        this.contentReader = contentReader;
        return this;
    }

    public ControllerLoginBuilder withDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    public ControllerLoginBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public ControllerLoginBuilder withLanguageManager(LanguageManager languageManager) {
        this.lang = languageManager;
        return this;
    }

    public ControllerLoginBuilder withControllerContentReader(ControllerContentReader controllerContentReader) {
        this.controllerContentReader = controllerContentReader;
        return this;
    }

    public ControllerLoginBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerLogin build() {
        return new ControllerLogin(this);
    }

    public ContentLogin getLogin() {
        return login;
    }

    public ContentAdmin getContentAdmin() {
        return contentAdmin;
    }

    public ContentUser getContentUser() {
        return contentUser;
    }

    public ContentReader getContentReader() {
        return contentReader;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public Subject getSubject() {
        return subject;
    }

    public LanguageManager getLang() {
        return lang;
    }

    public ControllerContentReader getControllerContentReader() {
        return controllerContentReader;
    }

    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

}
