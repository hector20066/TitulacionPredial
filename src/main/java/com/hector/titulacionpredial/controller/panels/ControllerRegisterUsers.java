package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;

import javax.swing.*;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerRegisterUsers implements LanguageObserver {

    private final RegisterUsers registerUsers;
    private final Subject subject;
    private final LanguageManager lang;

    private final UsersFacade daoUsers;

    public ControllerRegisterUsers(RegisterUsers registerUsers, Subject subject, LanguageSubject languageSubject,
                                   LanguageManager lang) {
        this.registerUsers = registerUsers;
        this.subject = subject;
        this.lang = lang;

        languageSubject.register(this);

        this.daoUsers = new UsersImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        registerUsers.setControllerCreate(e -> createAccount());
    }

    @Override
    public void updateLanguage() {

    }

    private void createAccount() {
        try {
            String name = registerUsers.getTxt_fullName().getText();
            String id = registerUsers.getTxt_id().getText();
            String user = registerUsers.getTxt_user().getText();
            String password = new String(registerUsers.getJpld_password().getPassword());
            Role role = (Role) registerUsers.getCbo_role().getSelectedItem();

            if (isInvalidData(name, id, user, password)) {
                throw new EmptyFieldException("Nombre, cedula, usuario y contraseña");
            }

            if (!NumericalValidationUtils.isNumeric(id)) {
                throw new InvalidNumberInputException("cedula");
            }

            prepareUI();
            doInBackground(name, Integer.parseInt(id), user, password, role);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerUsers);
        }
    }

    private boolean isInvalidData(String... fields) {
        for (String field : fields) {
            if (field.isBlank()) {
                return true;
            }
        }

        return false;
    }

    private void prepareUI() {
        registerUsers.getBtn_createAccount().setEnabled(false);
        registerUsers.getBtn_createAccount().setText("Registrando Usuario");
    }

    private void doInBackground(String name, int id, String user, String password, Role role) {
        new Thread(() -> {
            try {
                daoUsers.add(name, id, user, password, role);
                SwingUtilities.invokeLater(this::invokeLater);
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.errorMessage(e.getMessage(), registerUsers);
                    resetUI();
                });
            }
        }).start();
    }

    private void invokeLater() {
        MessageUtils.informationMessage("Se ha registrado el usuario.", registerUsers);
        resetUI();
        registerUsers.clearFields();
        subject.notifyObservers();
    }

    private void resetUI() {
        registerUsers.getBtn_createAccount().setEnabled(true);
        registerUsers.getBtn_createAccount().setText("Crear Cuenta");
    }

}
