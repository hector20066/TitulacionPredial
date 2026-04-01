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
 * Builder for configuring and constructing the {@link ControllerLogin} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerLogin
 * @since 1.0
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

    /**
     * with view login.
     *
     * @param login the login
     * @return the with view login
     */
    public ControllerLoginBuilder withViewLogin(ContentLogin login) {
        this.login = login;
        return this;
    }

    /**
     *  with content admin
     *
     *  @param contentAdmin the content admin
     *  @return the with content admin
     */
    public ControllerLoginBuilder withContentAdmin(ContentAdmin contentAdmin) {
        this.contentAdmin = contentAdmin;
        return this;
    }

    /**
     * with content user.
     *
     * @param contentUser the content user
     * @return the with content user
     */
    public ControllerLoginBuilder withContentUser(ContentUser contentUser) {
        this.contentUser = contentUser;
        return this;
    }

    /**
     * with content reader.
     *
     * @param contentReader the content reader
     * @return the with content reader
     */
    public ControllerLoginBuilder withContentReader(ContentReader contentReader) {
        this.contentReader = contentReader;
        return this;
    }

    /**
     * with dashboard.
     *
     * @param dashboard the dashboard
     * @return the with dashboard
     */
    public ControllerLoginBuilder withDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * with subject.
     *
     * @param subject the subject
     * @return the with subject
     */
    public ControllerLoginBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * with language manager.
     *
     * @param languageManager the language manager
     * @return the with language manager
     */
    public ControllerLoginBuilder withLanguageManager(LanguageManager languageManager) {
        this.lang = languageManager;
        return this;
    }

    /**
     * with controller content reader.
     *
     * @param controllerContentReader the controller content reader
     * @return the with controller content reader
     */
    public ControllerLoginBuilder withControllerContentReader(ControllerContentReader controllerContentReader) {
        this.controllerContentReader = controllerContentReader;
        return this;
    }

    /**
     * with language subject
     *
     * @param languageSubject the language subject
     * @return the with language subject
     */
    public ControllerLoginBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * build.
     *
     * @return the build
     */
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
