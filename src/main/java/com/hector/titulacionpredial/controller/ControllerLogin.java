package com.hector.titulacionpredial.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.hector.titulacionpredial.controller.builder.ControllerLoginBuilder;
import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.model.dto.user.DTOUserDetailsLogin;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.service.LoginService;
import com.hector.titulacionpredial.utils.*;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.Dashboard;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOContentLoginText;

/**
 * Controller for user authentication and login management.
 *
 * <p>
 * Handles user credential verification, session creation, and role-based
 * navigation to the appropriate content view. It supports multiple user roles
 * (ADMIN, EMPLOYEE, NONE) and manages municipality-specific access for
 * employee users.
 * </p>
 *
 * <p>
 * The controller manages the login UI interactions, including password
 * visibility toggling and form validation. It implements {@link LanguageObserver}
 * to support dynamic language changes during the login process.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerLoginBuilder
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerLogin implements LanguageObserver {

    private final ContentLogin login;
    private final ContentAdmin contentAdmin;
    private final ContentUser contentUser;
    private final ContentReader contentReader;
    private final Dashboard dashboard;
    private final Subject subject;
    private final LanguageManager lang;
    private final ControllerContentReader controllerContentReader;
    private final ControllerContentUser controllerContentUser;
    private Role role;

    /**
     * Create the controller from a builder that contains all
     * the necessary views and dependencies.
     *
     * @param builder constructor with configured views and dependencies
     */
    public ControllerLogin(ControllerLoginBuilder builder) {
        this.login = builder.getLogin();
        this.contentAdmin = builder.getContentAdmin();
        this.contentUser = builder.getContentUser();
        this.contentReader = builder.getContentReader();
        this.dashboard = builder.getDashboard();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();
        this.controllerContentReader = builder.getControllerContentReader();
        this.controllerContentUser = builder.getControllerContentUser();

        builder.getLanguageSubject().register(this);

        connectEvents();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    /**
     * Get the content panel corresponding to the current user role.
     *
     * <p>
     * Returns the appropriate panel for the logged-in user role,
     * either admin or user content.
     * </p>
     *
     * @return the {@link JPanel} for the current role's content
     */
    public JPanel jpl_Content() {
        if (getRole() == Role.ADMIN) {
            return ContentAdmin.getJpl_content();
        } else {
            return ContentUser.getJpl_content();
        }
    }

    /**
     * Connect login UI events to their corresponding event handlers.
     *
     * <p>
     * Registers listeners for login button, password visibility toggle,
     * and keyboard shortcuts (Enter key on password field).
     * </p>
     */
    private void connectEvents() {
        login.setControllerLogin(e -> logIn());
        login.setControllerSeePassword(e -> seePassword());
        login.setJpld_passwordAction(e -> login.getBtn_login().doClick());

        login.setTxt_userAction(e -> {
            login.getJpld_password().requestFocus();
            mousePressedPassword();
        });

        login.setTxt_userMouse(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedUser();
            }
        });

        login.setJpld_passwordMouse(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedPassword();
            }
        });
    }

    @Override
    public void updateLanguage() {
        DTOContentLoginText dto = new DTOContentLoginText.Builder()
                .title(lang.app("content.login.title"))
                .user(lang.app("content.login.user"))
                .userText(lang.app("content.login.user.text"))
                .password(lang.app("content.login.password"))
                .login(lang.app("content.login.btn.login"))
                .access(lang.app("content.login.access.text"))
                .build();

        login.updateLanguage(dto);
    }

    /**
     * Perform user login validation and authentication.
     *
     * <p>
     * Validates that username and password fields are not empty, verifies
     * that password length is at least 8 characters, and then executes
     * an asynchronous login worker to verify credentials. Exceptions are
     * caught internally and displayed to the user.
     * </p>
     */
    private void logIn() {
        try {
            String user = login.getTxt_user().getText().trim();
            String passwd = new String(login.getJpld_password().getPassword());

            if(!NetworkUtils.hasInternetConnection()) {
                MessageUtils.errorMessage(lang.message("message.login.error.connection1") + "\n" +
                        lang.message("message.login.error.connection2"), null);
                return;
            }

            if (ValidationUtils.isEmptyFields(user, passwd)) {
                throw new EmptyFieldException(lang.message("empty.user.password"));
            }

            if (passwd.length() < 8) {
                throw new InvalidInputException(lang.message("invalid.input.password"));
            }

            prepareUI();
            executeLoginWorker(user, passwd);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), null);
        }
    }

    /**
     * Prepare the login UI for authentication process.
     *
     * <p>
     * Disables the login button and updates its text to indicate
     * that authentication is in progress.
     * </p>
     */
    private void prepareUI() {
        login.getBtn_login().setEnabled(false);
        login.getBtn_login().setText(lang.app("controller.login.init"));
    }

    /**
     * Execute asynchronous login worker to verify user credentials.
     *
     * <p>
     * Uses {@link SwingWorker} to perform credential verification in a
     * background thread, preventing UI freezing during database operations.
     * Handles database connection errors and interruptions.
     * </p>
     *
     * @param user         the username to verify
     * @param plainPasswd  the plaintext password to verify
     */
    private void executeLoginWorker(String user, String plainPasswd) {
        SwingWorker<DTOUserDetailsLogin, Void> executor = new SwingWorker<>() {
            @Override
            protected DTOUserDetailsLogin doInBackground() throws DAOException {
                return LoginService.getInstance().verifyCredentials(user, plainPasswd);
            }

            @Override
            public void done() {
                try {
                    DTOUserDetailsLogin dto = get();
                    handledLoginResult(dto);
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();

                    if(cause instanceof java.sql.SQLNonTransientConnectionException
                            || cause instanceof com.mysql.cj.jdbc.exceptions.CommunicationsException) {
                        MessageUtils.errorMessage(lang.message("message.error.connect.db"), null);
                    }

                    resetLogIn();
                } catch (InterruptedException e) {
                    MessageUtils.errorMessage(lang.message("message.abort.login"), null);
                    resetLogIn();
                }
            }
        };

        executor.execute();
    }

    /**
     * Handle the result of user authentication.
     *
     * <p>
     * Based on the returned role, initializes the appropriate session
     * (admin or employee) or displays an error message if credentials
     * are invalid.
     * </p>
     *
     * @param dto the {@link DTOUserDetailsLogin} returned from authentication
     */
    private void handledLoginResult(DTOUserDetailsLogin dto) {
        switch (dto.getRole()) {
            case Role.ADMIN -> {
                startSessionAdmin(dto.getUser());
                subject.notifyObservers();
                setRole(Role.ADMIN);
            }
            case Role.EMPLOYEE -> {
                startSessionUser(dto.getUser());
                setRole(Role.EMPLOYEE);
            }
            case Role.NONE -> {
                MessageUtils.warningMessage(lang.message("message.not.found.credentials"), null);
                resetLogIn();
            }
        }
    }

    /**
     * Initialize an admin user session.
     *
     * <p>
     * Displays the admin content view, sets the window properties, and
     * closes the login window.
     * </p>
     */
    private void startSessionAdmin(String user) {
        java.awt.EventQueue.invokeLater(() -> {
            contentAdmin.setVisible(true);
            contentAdmin.setLocationRelativeTo(null);
            controllerContentUser.showButtons();
            NavigatorUtils.showForms(ContentAdmin.getJpl_content(), dashboard);
            dashboard.setUsername(user);
            dashboard.getJlb_welcome().setText(lang.app("controller.dashboard.welcome") + " " + dashboard.getUsername());
        });

        login.dispose();
    }

    /**
     * Initialize an employee user session.
     *
     * <p>
     * Displays either the reader or user content view based on the
     * selected access mode, sets municipality context if specified,
     * and closes the login window.
     * </p>
     */
    private void startSessionUser(String user) {
        String mode = (String) login.getCbo_access().getSelectedItem();
        Municipalities municipality = extractMunicipalityFromMode(mode);

        if (municipality != null) {
            SessionManager.getInstance().setMunicipality(municipality);
        }

        if (mode.equalsIgnoreCase("Solo lectura")) {
            java.awt.EventQueue.invokeLater(() -> {
                contentReader.setVisible(true);
                contentReader.setLocationRelativeTo(null);
                controllerContentReader.hideButtons();
                NavigatorUtils.showForms(ContentReader.getJpl_content(), dashboard);
            });
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                contentUser.setVisible(true);
                contentUser.setLocationRelativeTo(null);
                controllerContentUser.showButtons();
                NavigatorUtils.showForms(ContentUser.getJpl_content(), dashboard);
            });
        }

        dashboard.setUsername(user);
        dashboard.getJlb_welcome().setText(lang.app("controller.dashboard.welcome") + " " + dashboard.getUsername());
        subject.notifyObservers();
        login.dispose();
    }
    
    /**
     * Extract the municipality from the selected access mode.
     *
     * @param mode the selected access mode from the ComboBox
     * @return the corresponding {@link Municipalities} enum, or null if unrestricted
     */
    private Municipalities extractMunicipalityFromMode(String mode) {
        return switch (mode) {
            case "Info. Sahagun" -> Municipalities.SAHAGUN;
            case "Inf. Monteria" -> Municipalities.MONTERIA;
            default -> null;
        };
    }

    /**
     * Reset the login UI to its initial state.
     *
     * <p>
     * Re-enables the login button and restores its original text,
     * allowing the user to attempt login again.
     * </p>
     */
    private void resetLogIn() {
        login.getBtn_login().setEnabled(true);
        login.getBtn_login().setText(lang.app("controller.content.login"));
    }

    /**
     * Handle password field focus and display logic.
     *
     * <p>
     * When the password field receives focus, displays the placeholder
     * text in the username field if it's empty, and clears any placeholder
     * from the password field.
     * </p>
     */
    private void mousePressedPassword() {
        if (login.getTxt_user().getText().isBlank()) {
            login.getTxt_user().setText(lang.app("controller.login.enter.user"));
            login.getTxt_user().setForeground(Color.gray);
        }

        if (String.valueOf(login.getJpld_password().getPassword()).equals("••••••••")) {
            login.getJpld_password().setText("");
            login.getJpld_password().setForeground(new Color(37,106,208));
        }
    }

    /**
     * Handle username field focus and display logic.
     *
     * <p>
     * When the username field receives focus, clears any placeholder text
     * and displays the placeholder in the password field if it's empty.
     * </p>
     */
    private void mousePressedUser() {
        if (login.getTxt_user().getText().equals(lang.app("controller.login.enter.user"))) {
            login.getTxt_user().setText("");
            login.getTxt_user().setForeground(new Color(37,106,208));
        }

        if (String.valueOf(login.getJpld_password().getPassword()).isBlank()) {
            login.getJpld_password().setText("••••••••");
            login.getJpld_password().setForeground(Color.gray);
        }
    }

    /**
     * Toggle password visibility in the password field.
     *
     * <p>
     * If the "show password" radio button is selected, displays the password
     * in plain text. Otherwise, masks the password with bullet characters.
     * </p>
     */
    private void seePassword() {
        if (login.getRbn_seePasswd().isSelected()) {
            login.getJpld_password().setEchoChar((char) 0);
        } else {
            login.getJpld_password().setEchoChar('•');
        }
    }

}
