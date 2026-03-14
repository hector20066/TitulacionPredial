package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.model.enums.Role;
import com.hector.titulacionpredial.service.LoginService;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerLogin {

    private final ContentLogin login;
    private final Content content;
    private final Dashboard dashboard;

    public ControllerLogin(ContentLogin login, Content content, Dashboard dashboard) {
        this.login = login;
        this.content = content;
        this.dashboard = dashboard;

        connectEvents();
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

    private void logIn() {
        try {
            String user = login.getTxt_user().getText().trim();
            String passwd = new String(login.getJpld_password().getPassword());

            if (user.isBlank() || passwd.isBlank()) {
                throw new EmptyFieldException("Usuario y Contraseña");
            }

            /*if (passwd.length() < 8) {
                throw new InvalidInputException("La contraseña debe tener minimo 8 caracteres");
            }*/

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
                java.awt.EventQueue.invokeLater(() -> {
                    content.setVisible(true);
                    content.setLocationRelativeTo(null);
                    content.setResizable(false);
                    NavigatorUtils.showForms(dashboard);
                });
                login.dispose();
            }
            //case Role.EMPLOYEE -> ;
            case Role.NONE -> {
                MessageUtils.warningMessage("No se han encontrado las credenciales", null);
                resetLogIn();
            }
        }
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
