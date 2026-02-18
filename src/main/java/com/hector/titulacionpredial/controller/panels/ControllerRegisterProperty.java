package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.view.content.panels.RegisterProperty;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterProperty {

    private final RegisterProperty registerProperty;

    public ControllerRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;

        connectEvents();
    }

    private void connectEvents() {
        registerProperty.setControllerRegister(e -> register());
        registerProperty.setControllerGoPoint2(e -> goPoint2());
        registerProperty.setControllerGoPoint3(e -> goPoint3());
        registerProperty.setControllerGoPoint4(e -> goPoint4());
        registerProperty.setControllerReturnPoint1(e -> returnPoint1());
        registerProperty.setControllerReturnPoint2(e -> returnPoint2());
        registerProperty.setControllerReturnPoint3(e -> returnPoint3());
    }

    private void register() {
        try {

        } catch (Exception e) {

        }
    }

    private void goPoint2() {

    }

    private void goPoint3() {

    }

    private void goPoint4() {

    }

    private void returnPoint1() {

    }

    private void returnPoint2() {

    }

    private void returnPoint3() {

    }

}
