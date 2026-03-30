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

    /**     * with view register users.     * @param registerUsers the register users     * @return the with view register users     */
    public ControllerRegisterUsersBuilder withViewRegisterUsers(RegisterUsers registerUsers) {
        this.registerUsers = registerUsers;
        return this;
    }

    /**     * with language manager.     * @param lang the lang     * @return the with language manager     */
    public ControllerRegisterUsersBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**     * with subject.     * @param subject the subject     * @return the with subject     */
    public ControllerRegisterUsersBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**     * with language subject.     * @param languageSubject the language subject     * @return the with language subject     */
    public ControllerRegisterUsersBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**     * build.     * @return the build     */
    public ControllerRegisterUsers build() {
        return new ControllerRegisterUsers(this);
    }

    /**     * get register users.     * @return the get register users     */
    public RegisterUsers getRegisterUsers() {
        return registerUsers;
    }

    /**     * get lang.     * @return the get lang     */
    public LanguageManager getLang() {
        return lang;
    }

    /**     * get subject.     * @return the get subject     */
    public Subject getSubject() {
        return subject;
    }

    /**     * get language subject.     * @return the get language subject     */
    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }
}
