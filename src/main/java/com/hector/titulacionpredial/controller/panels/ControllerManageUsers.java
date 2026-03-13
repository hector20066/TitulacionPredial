package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.IManageAccounts;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;

import javax.swing.*;
import java.util.List;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerManageUsers implements Observer, LanguageObserver, IManageAccounts {

    private final ManageUsers manageUsers;
    private final LanguageManager lang;

    private final UsersFacade daoUsers;

    public ControllerManageUsers(ManageUsers manageUsers, Subject subject, LanguageSubject languageSubject, LanguageManager lang) {
        this.manageUsers = manageUsers;
        this.lang = lang;

        subject.register(this);
        languageSubject.register(this);

        this.daoUsers = new UsersImplFacade();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOUserDetails> listUsers = daoUsers.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listUsers));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), manageUsers));
            }
        }).start();
    }

    @Override
    public void updateLanguage() {

    }

    @Override
    public void modifyAccount(DTOUserDetails account) {

    }

    @Override
    public void deleteAccount(long id, JPanel panel) {
        new Thread(() -> {
            try {
                boolean success = daoUsers.delete(id);
            }
        })
    }

    private void loadData(List<DTOUserDetails> listUsers) {
        manageUsers.clearPanel();
        listUsers.forEach(dto -> manageUsers.addAccountsPanel(dto, this));
    }

}
