package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.ContentLogin;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        java.awt.EventQueue.invokeLater(() -> {
            content.setVisible(true);
            content.setLocationRelativeTo(null);
            content.setResizable(false);
            NavigatorUtils.showForms(dashboard);
        });

        login.dispose();
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
