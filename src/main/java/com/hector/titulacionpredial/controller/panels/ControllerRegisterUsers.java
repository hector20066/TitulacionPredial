package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerRegisterUsers implements LanguageObserver {

    private final RegisterUsers registerUsers;
    private final Subject subject;
    private final LanguageManager lang;

    public ControllerRegisterUsers(RegisterUsers registerUsers, Subject subject, LanguageSubject languageSubject,
                                   LanguageManager lang) {
        this.registerUsers = registerUsers;
        this.subject = subject;
        this.lang = lang;

        languageSubject.register(this);

        connectEvents();
    }

    private void connectEvents() {
        registerUsers.setControllerCreate(e -> createAccount());
    }

    @Override
    public void updateLanguage() {

    }

    private void createAccount() {

    }

}
