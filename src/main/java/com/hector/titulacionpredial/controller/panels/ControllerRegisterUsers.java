package com.hector.titulacionpredial.controller.panels;

import javax.swing.SwingUtilities;

import com.hector.titulacionpredial.controller.builder.ControllerRegisterUsersBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterUsersText;

/**
 * Controller for managing user registration functionality.
 *
 * <p>
 * Handles the creation of new user accounts with validation of input fields,
 * password strength requirements, and persistence through the user facade.
 * Integrates with the UI layer and supports language changes through observer pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerRegisterUsers implements LanguageObserver {

    private final RegisterUsers registerUsers;
    private final Subject subject;
    private final LanguageManager lang;

    private final UsersFacade daoUsers;

    /**
     * controller register users
     *
     * @param builder the builder
     */
    public ControllerRegisterUsers(ControllerRegisterUsersBuilder builder) {
        this.registerUsers = builder.getRegisterUsers();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.daoUsers = new UsersImplFacade();

        connectEvents();
    }

    /**
     * connect events.
     */
    private void connectEvents() {
        registerUsers.setControllerCreate(e -> createAccount());
        registerUsers.setControllerSeePassword(e -> seePassword());
    }

    @Override
    public void updateLanguage() {
        DTORegisterUsersText dto = new DTORegisterUsersText.Builder()
                .title(lang.app("register.users.title"))
                .desc(lang.app("register.users.desc"))
                .fullName(lang.app("register.users.fullName"))
                .id(lang.app("register.users.id"))
                .desc2(lang.app("register.users.desc2"))
                .user(lang.app("register.users.user"))
                .password(lang.app("register.users.password"))
                .rol(lang.app("register.users.rol"))
                .createBtn(lang.app("register.users.btn.create"))
                .build();

        registerUsers.updateLanguage(dto);
    }

    /**
     * Creates a new user account after validating all input fields.
     *
     * <p>
     * Retrieves registration data from the view, validates completeness and format
     * (including ID format and password strength), and executes the account creation
     * in a background thread to prevent UI blocking. Shows appropriate messages
     * on validation errors.
     * </p>
     */
    private void createAccount() {
        try {
            String name = registerUsers.getTxt_fullName().getText();
            String id = registerUsers.getTxt_id().getText();
            String user = registerUsers.getTxt_user().getText();
            String password = new String(registerUsers.getJpld_password().getPassword());
            Role role = (Role) registerUsers.getCbo_role().getSelectedItem();

            if (isInvalidData(name, id, user, password)) {
                throw new EmptyFieldException(lang.message("empty.user.general"));
            }

            if (!NumericalValidationUtils.isNumeric(id)) {
                throw new InvalidNumberInputException(lang.message("empty.user.id"));
            }

            if (password.length() < 8) {
                throw new InvalidInputException(lang.message("invalid.input.password"));
            }

            prepareUI();
            doInBackground(name, Integer.parseInt(id), user, password, role);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerUsers);
        }
    }

    /**
     * is invalid data.
     *
     * @param fields the fields
     * @return the is invalid data
     */
    private boolean isInvalidData(String... fields) {
        for (String field : fields) {
            if (field.isBlank()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prepare the UI for registration.
     */
    private void prepareUI() {
        registerUsers.getBtn_createAccount().setEnabled(false);
        registerUsers.getBtn_createAccount().setText(lang.app("controller.register.users.registering"));
    }

    /**
     * Execute user registration in background thread.
     *
     * @param name     user's full name
     * @param id       user's ID number
     * @param user     username for login
     * @param password user's password
     * @param role     user's role in system
     */
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

    /**
     * invoke later.
     */
    private void invokeLater() {
        MessageUtils.informationMessage(lang.message("message.user.register"), registerUsers);
        resetUI();
        registerUsers.clearFields();
        subject.notifyObservers();
    }

    /**
     * reset ui.
     */
    private void resetUI() {
        registerUsers.getBtn_createAccount().setEnabled(true);
        registerUsers.getBtn_createAccount().setText(lang.app("controller.register.users.create"));
    }

    /**
     * see password.
     */
    private void seePassword() {
        if (registerUsers.getRbn_seePasswd().isSelected()) {
            registerUsers.getJpld_password().setEchoChar((char) 0);
        } else {
            registerUsers.getJpld_password().setEchoChar('•');
        }
    }

}
