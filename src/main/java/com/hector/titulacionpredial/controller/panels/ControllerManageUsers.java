package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.IManageAccounts;
import com.hector.titulacionpredial.controller.builder.ControllerManageUsersBuilder;
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
    private final Subject subject;

    private final UsersFacade daoUsers;

    /**     * controller manage users.     * @param builder the builder     * @return the controller manage users     */
    public ControllerManageUsers(ControllerManageUsersBuilder builder) {
        this.manageUsers = builder.getManageUsers();
        this.lang = builder.getLang();
        this.subject = builder.getSubject();

        builder.getSubject().register(this);
        builder.getLanguageSubject().register(this);

        this.daoUsers = new UsersImplFacade();
    }

    @Override
    /**     * update.     */
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
    /**     * update language.     */
    public void updateLanguage() {

    }

    @Override
    /**     * modify account.     * @param account the account     */
    public void modifyAccount(DTOUserDetails account) {
        int id = account.getId();
        String newPassword = MessageUtils.inputDialog(lang.message("message.user.enter.newPassword"), manageUsers);
        new Thread(() -> {
            try {
                boolean success = daoUsers.modifyPassword(id, newPassword);
                SwingUtilities.invokeLater(() -> {
                    actionForSuccess(success);
                });
            } catch (DAOException ex) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(lang.message("message.user.modify.error"), manageUsers));
            }
        }).start();
    }

    @Override
    /**     * delete account.     * @param id the id     * @param panel the panel     */
    public void deleteAccount(int id, JPanel panel) {
        new Thread(() -> {
            try {
                daoUsers.delete(id);
                SwingUtilities.invokeLater(this::actionForSuccess);
            } catch (DAOException ex) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(lang.message("message.user.delete.error") + "\n" + lang.message("message.user.error") + " " + ex, manageUsers));
            }
        }).start();
    }

    /**     * action for success.     */
    private void actionForSuccess() {
        MessageUtils.informationMessage(lang.message("message.user.delete"), manageUsers);
        subject.notifyObservers();
    }

    /**     * action for success.     * @param success the success     */
    private void actionForSuccess(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.user.modify"), manageUsers);
            subject.notifyObservers();
        } else {
            MessageUtils.errorMessage(lang.message("message.user.no.modify"), manageUsers);
        }
    }

    /**     * load data.     * @param listUsers the list users     */
    private void loadData(List<DTOUserDetails> listUsers) {
        manageUsers.clearPanel();
        listUsers.forEach(dto -> manageUsers.addAccountsPanel(dto, this));
    }

}
