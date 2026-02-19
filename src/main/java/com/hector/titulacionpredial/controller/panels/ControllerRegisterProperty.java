package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;

import java.awt.*;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterProperty {

    private final RegisterProperty registerProperty;
    private final Subject subject;

    public ControllerRegisterProperty(RegisterProperty registerProperty, Subject subject) {
        this.registerProperty = registerProperty;
        this.subject = subject;

        connectEvents();
    }

    private void connectEvents() {
        registerProperty.setControllerRegister(e -> register());
        registerProperty.setControllerGoPoint2(e -> actionAfter());
        registerProperty.setControllerGoPoint3(e -> actionAfter());
        registerProperty.setControllerGoPoint4(e -> actionAfter());
        registerProperty.setControllerReturnPoint1(e -> actionPrevious());
        registerProperty.setControllerReturnPoint2(e -> actionPrevious());
        registerProperty.setControllerReturnPoint3(e -> actionPrevious());
    }

    private void register() {
        try {

        } catch (Exception e) {

        }
    }

    private void actionAfter() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.next(registerProperty.getJpl_contentPoints());
    }

    private void actionPrevious() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.previous(registerProperty.getJpl_contentPoints());
    }

}
