package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerManageUsers;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;

/**
 * Builder for configuring and constructing the {@link ControllerManageUsers} controller.
 *
 * <p>
 * It assembles all the necessary dependencies (views, facades, language manager, etc.)
 * and provides a fluid interface for building the controller instance.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerManageUsers
 * @since 1.0
 */
public class ControllerManageUsersBuilder {

    private ManageUsers manageUsers;
    private LanguageManager lang;
    private Subject subject;
    private LanguageSubject languageSubject;

    /**
     * with view manage users.
     *
     * @param manageUsers the manage users
     * @return the with view manage users
     */
    public ControllerManageUsersBuilder withViewManageUsers(ManageUsers manageUsers) {
        this.manageUsers = manageUsers;
        return this;
    }

    /**
     * with language manager.
     *
     * @param lang the lang
     * @return the with language manager
     */
    public ControllerManageUsersBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * with subject
     *
     * @param subject the subject
     * @return the with subject
     */
    public ControllerManageUsersBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * with language subject.
     *
     * @param languageSubject the language subject
     * @return the with language subject
     */
    public ControllerManageUsersBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * build.
     *
     * @return the build
     */
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
