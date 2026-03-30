package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.builder.ControllerRegisterUsersBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.UsersImplFacade;
import com.hector.titulacionpredial.facade.interfaces.UsersFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.dto.user.DTOUserCreate;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.RegisterUsers;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTORegisterUsersText;

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

    /**     * controller register users.     * @param builder the builder     * @return the controller register users     */
    public ControllerRegisterUsers(ControllerRegisterUsersBuilder builder) {
        this.registerUsers = builder.getRegisterUsers();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        this.daoUsers = new UsersImplFacade();

        connectEvents();
    }

    /**     * connect events.     */
    private void connectEvents() {
        registerUsers.setControllerCreate(e -> createAccount());
        registerUsers.setControllerSeePassword(e -> seePassword());
    }

    @Override
    /**     * update language.     */
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

    /**     * create account.     */
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

    /**     * is invalid data.     * @param fields the fields     * @return the is invalid data     */
    private boolean isInvalidData(String... fields) {
        for (String field : fields) {
            if (field.isBlank()) {
                return true;
            }
        }

        return false;
    }

    /**     * prepare ui.     */
    private void prepareUI() {
        registerUsers.getBtn_createAccount().setEnabled(false);
        registerUsers.getBtn_createAccount().setText(lang.app("controller.register.users.registering"));
    }

    /**     * do in background.     * @param name the name     * @param id the id     * @param user the user     * @param password the password     * @param role the role     */
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

    /**     * invoke later.     */
    private void invokeLater() {
        MessageUtils.informationMessage(lang.message("message.user.register"), registerUsers);
        resetUI();
        registerUsers.clearFields();
        subject.notifyObservers();
    }

    /**     * reset ui.     */
    private void resetUI() {
        registerUsers.getBtn_createAccount().setEnabled(true);
        registerUsers.getBtn_createAccount().setText(lang.app("controller.register.users.create"));
    }

    /**     * see password.     */
    private void seePassword() {
        if (registerUsers.getRbn_seePasswd().isSelected()) {
            registerUsers.getJpld_password().setEchoChar((char) 0);
        } else {
            registerUsers.getJpld_password().setEchoChar('•');
        }
    }

}
