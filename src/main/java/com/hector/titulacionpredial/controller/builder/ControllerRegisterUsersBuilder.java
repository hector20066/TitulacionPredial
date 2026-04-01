package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerRegisterUsers;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;

/**
 * Builder for configuring and constructing the {@link ControllerRegisterUsers} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerRegisterUsers
 * @since 1.0
 */
public class ControllerRegisterUsersBuilder {

    private RegisterUsers registerUsers;
    private LanguageManager lang;
    private Subject subject;
    private LanguageSubject languageSubject;

    /**
     *  with view register users.
     *
     *  @param registerUsers the register users
     *  @return the with view register users
     */
    public ControllerRegisterUsersBuilder withViewRegisterUsers(RegisterUsers registerUsers) {
        this.registerUsers = registerUsers;
        return this;
    }

    /**
     * with language manager.
     *
     * @param lang the lang
     * @return the with language manager
     */
    public ControllerRegisterUsersBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * with subject.
     *
     * @param subject the subject
     * @return the with subject
     */
    public ControllerRegisterUsersBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * with language subject.
     *
     * @param languageSubject the language subject
     * @return the with language subject
     */
    public ControllerRegisterUsersBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * build.
     *
     * @return the build
     */
    public ControllerRegisterUsers build() {
        return new ControllerRegisterUsers(this);
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
