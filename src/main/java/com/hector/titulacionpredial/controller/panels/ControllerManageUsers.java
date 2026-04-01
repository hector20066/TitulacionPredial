package com.hector.titulacionpredial.controller.panels;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.hector.titulacionpredial.controller.IManageAccounts;
import com.hector.titulacionpredial.controller.builder.ControllerManageUsersBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.panels.ManageUsers;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOManageUsersText;

/**
 * Controller for managing user accounts.
 *
 * <p>
 * Implements the Observer pattern to react to data changes and
 * language changes. Provides functionality for loading, modifying,
 * and deleting user accounts. All operations are performed in
 * background threads to avoid blocking the UI.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see IManageAccounts
 * @see Observer
 * @see LanguageObserver
 */
public class ControllerManageUsers implements Observer, LanguageObserver, IManageAccounts {

    private final ManageUsers manageUsers;
    private final LanguageManager lang;
    private final Subject subject;

    private final UsersFacade daoUsers;

    public ControllerManageUsers(ControllerManageUsersBuilder builder) {
        this.manageUsers = builder.getManageUsers();
        this.lang = builder.getLang();
        this.subject = builder.getSubject();

        builder.getSubject().register(this);
        builder.getLanguageSubject().register(this);

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
        DTOManageUsersText dto = new DTOManageUsersText.Builder()
                .title(lang.app("manage.users.title"))
                .subtitle(lang.app("manage.users.panel.title"))
                .name(lang.app("manage.users.panel.name"))
                .user(lang.app("manage.users.panel.user"))
                .modify(lang.app("manage.users.panel.btn.modify"))
                .delete(lang.app("manage.users.panel.btn.delete"))
                .build();

        manageUsers.updateLanguage(dto);
    }

    @Override
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

    /**
     * Deletes a user account from the database.
     *
     * <p>
     * Performs the deletion in a background thread and notifies
     * the user of success or failure.
     * </p>
     *
     * @param id the unique identifier of the user to delete
     * @param panel the parent component for displaying messages
     */
    @Override
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

    private void actionForSuccess() {
        MessageUtils.informationMessage(lang.message("message.user.delete"), manageUsers);
        subject.notifyObservers();
    }

    private void actionForSuccess(boolean success) {
        if (success) {
            MessageUtils.informationMessage(lang.message("message.user.modify"), manageUsers);
            subject.notifyObservers();
        } else {
            MessageUtils.errorMessage(lang.message("message.user.no.modify"), manageUsers);
        }
    }

    private void loadData(List<DTOUserDetails> listUsers) {
        manageUsers.clearPanel();
        manageUsers.loadUsers(listUsers, this);
    }

}
