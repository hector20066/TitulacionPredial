package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.IManageAccounts;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;

import javax.swing.*;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerManageUsers implements Observer, LanguageObserver, IManageAccounts {

    private final ManageUsers manageUsers;
    private final LanguageManager lang;

    public ControllerManageUsers(ManageUsers manageUsers, Subject subject, LanguageSubject languageSubject, LanguageManager lang) {
        this.manageUsers = manageUsers;
        this.lang = lang;

        subject.register(this);
        languageSubject.register(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void updateLanguage() {

    }

    @Override
    public void modifyAccount(DTOUserDetails account) {

    }

    @Override
    public void deleteAccount(long id, JPanel panel) {

    }

}
