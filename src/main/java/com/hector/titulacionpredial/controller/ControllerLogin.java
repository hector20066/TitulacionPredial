package com.hector.titulacionpredial.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.service.LoginService;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.utils.SessionManager;
import com.hector.titulacionpredial.view.content.ContentAdmin;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.ContentReader;
import com.hector.titulacionpredial.view.content.ContentUser;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

/**
 * @author Ing. Hector Acevedo
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
    private Role role;

    public ControllerLogin(ContentLogin login, ContentAdmin contentAdmin, ContentUser contentUser, ContentReader contentReader, Dashboard dashboard,
                           Subject subject, LanguageSubject languageSubject, LanguageManager lang) {
        this.login = login;
        this.contentAdmin = contentAdmin;
        this.contentUser = contentUser;
        this.contentReader = contentReader;
        this.dashboard = dashboard;
        this.subject = subject;
        this.lang = lang;

        languageSubject.register(this);

        connectEvents();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public JPanel jpl_Content() {
        if (getRole() == Role.ADMIN) {
            return ContentAdmin.getJpl_content();
        } else {
            return ContentUser.getJpl_content();
        }
    }

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

    }

    private void logIn() {
        try {
            String user = login.getTxt_user().getText().trim();
            String passwd = new String(login.getJpld_password().getPassword());

            /*if(!NetworkUtils.hasInternetConnection()) {
                MessageUtils.errorMessage("No tienes conexión a internet.\nVerifica la conexión e intentalo nuevamente", null);
                return;
            }*/

            if (user.isBlank() || passwd.isBlank()) {
                throw new EmptyFieldException("Usuario y Contraseña");
            }

            if (passwd.length() < 8) {
                throw new InvalidInputException("La contraseña debe tener minimo 8 caracteres");
            }

            prepareUI();
            executeLoginWorker(user, passwd);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), null);
        }
    }

    private void prepareUI() {
        login.getBtn_login().setEnabled(false);
        login.getBtn_login().setText("Iniciando Sesion...");
    }

    private void executeLoginWorker(String user, String plainPasswd) {
        SwingWorker<Role, Void> executor = new SwingWorker<>() {
            @Override
            protected Role doInBackground() throws DAOException {
                return LoginService.getInstance().verifyCredentials(user, plainPasswd);
            }

            @Override
            public void done() {
                try {
                    Role role = get();
                    handledLoginResult(role);
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();

                    if(cause instanceof java.sql.SQLNonTransientConnectionException
                            || cause instanceof com.mysql.cj.jdbc.exceptions.CommunicationsException) {
                        MessageUtils.errorMessage("No se pudo conectar con la base de datos. Intentalo mas tarde", null);
                    }

                    resetLogIn();
                } catch (InterruptedException e) {
                    MessageUtils.errorMessage("Se ha interrumpido el inicio de sesión.", null);
                    resetLogIn();
                }
            }
        };

        executor.execute();
    }

    private void handledLoginResult(Role role) {
        switch (role) {
            case Role.ADMIN -> {
                startSessionAdmin();
                subject.notifyObservers();
                setRole(Role.ADMIN);
            }
            case Role.EMPLOYEE -> {
                startSessionUser();
                subject.notifyObservers();
                setRole(Role.EMPLOYEE);
            }
            case Role.NONE -> {
                MessageUtils.warningMessage("No se han encontrado las credenciales", null);
                resetLogIn();
            }
        }
    }

    private void startSessionAdmin() {
        java.awt.EventQueue.invokeLater(() -> {
            contentAdmin.setVisible(true);
            contentAdmin.setLocationRelativeTo(null);
            contentAdmin.setResizable(false);
            NavigatorUtils.showForms(ContentAdmin.getJpl_content(), dashboard);
        });

        login.dispose();
    }

    private void startSessionUser() {
        String mode = (String) login.getCbo_access().getSelectedItem();
        
        // Extract municipality from selection and store in session
        Municipalities municipality = extractMunicipalityFromMode(mode);

        if (municipality != null) {
            SessionManager.getInstance().setMunicipality(municipality);
        }

        if (mode.equalsIgnoreCase("Solo lectura")) {
            java.awt.EventQueue.invokeLater(() -> {
                contentReader.setVisible(true);
                contentReader.setLocationRelativeTo(null);
                contentReader.setResizable(false);
                NavigatorUtils.showForms(ContentReader.getJpl_content(), dashboard);
            });
        } else {
            java.awt.EventQueue.invokeLater(() -> {
                contentUser.setVisible(true);
                contentUser.setLocationRelativeTo(null);
                contentUser.setResizable(false);
                NavigatorUtils.showForms(ContentUser.getJpl_content(), dashboard);
            });
        }

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
            default -> null; // "Solo lectura" returns null (unrestricted access)
        };
    }

    private void resetLogIn() {
        login.getBtn_login().setEnabled(true);
        login.getBtn_login().setText("INICIAR SESION");
    }

    private void mousePressedPassword() {
        if (login.getTxt_user().getText().isBlank()) {
            login.getTxt_user().setText("Ingrese el usuario");
            login.getTxt_user().setForeground(Color.gray);
        }

        if (String.valueOf(login.getJpld_password().getPassword()).equals("••••••••")) {
            login.getJpld_password().setText("");
            login.getJpld_password().setForeground(new Color(37,106,208));
        }
    }

    private void mousePressedUser() {
        if (login.getTxt_user().getText().equals("Ingrese el usuario")) {
            login.getTxt_user().setText("");
            login.getTxt_user().setForeground(new Color(37,106,208));
        }

        if (String.valueOf(login.getJpld_password().getPassword()).isBlank()) {
            login.getJpld_password().setText("••••••••");
            login.getJpld_password().setForeground(Color.gray);
        }
    }

    private void seePassword() {
        if (login.getRbn_seePasswd().isSelected()) {
            login.getJpld_password().setEchoChar((char) 0);
        } else {
            login.getJpld_password().setEchoChar('•');
        }
    }

}
