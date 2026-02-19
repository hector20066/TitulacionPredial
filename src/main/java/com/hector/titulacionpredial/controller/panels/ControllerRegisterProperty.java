package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;
import com.hector.titulacionpredial.view.content.dialogs.SpouseData;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;

import java.awt.*;
import java.security.spec.ECField;

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
        registerProperty.setControllerShowBeneficiaries(e -> showBeneficiaries());
    }

    private void register() {
        try {
            String cadastralId = registerProperty.getTxt_cadastralId().getText().trim();
            String area = registerProperty.getTxt_area().getText().trim();
            String beneficiaryCode = registerProperty.getTxt_beneficiaryCode().getText().trim().replace("F", "");

            if (cadastralId.isBlank() || area.isBlank() || beneficiaryCode.isBlank()) {
                return;
            }

            prepareUI();
            doInBackGround();
        } catch (Exception e) {

        }
    }

    private void prepareUI() {

    }

    private void doInBackGround() {
        new Thread(() -> {
            try {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void registerPoint1() {
        String northCoord1 = registerProperty.getTxt_northCoordinate1().getText().trim();
        String eastCoord1 = registerProperty.getTxt_eastCoordinate1().getText().trim();
        String distance1 = registerProperty.getTxt_distance1().getText().trim();
        String hillside1 = registerProperty.getTxt_hillside1().getText().trim();
    }

    private void registerPoint2() {
        String northCoord2 = registerProperty.getTxt_northCoordinate2().getText().trim();
        String eastCoord2 = registerProperty.getTxt_eastCoordinate2().getText().trim();
        String distance2 = registerProperty.getTxt_distance2().getText().trim();
        String hillside2 = registerProperty.getTxt_hillside2().getText().trim();
    }

    private void registerPoint3() {
        String northCoord3 = registerProperty.getTxt_northCoordinate3().getText().trim();
        String eastCoord3 = registerProperty.getTxt_eastCoordinate3().getText().trim();
        String distance3 = registerProperty.getTxt_distance3().getText().trim();
        String hillside3 = registerProperty.getTxt_hillside3().getText().trim();
    }

    private void registerPoint4() {
        String northCoord4 = registerProperty.getTxt_northCoordinate4().getText().trim();
        String eastCoord4 = registerProperty.getTxt_eastCoordinate4().getText().trim();
        String distance4 = registerProperty.getTxt_distance4().getText().trim();
        String hillside4 = registerProperty.getTxt_hillside4().getText().trim();
    }

    private boolean invalidPoints(String... info) {
        for (String data : info) {
            if (data.isBlank()) {
                return true;
            }
        }

        return false;
    }

    private void actionAfter() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.next(registerProperty.getJpl_contentPoints());
    }

    private void actionPrevious() {
        CardLayout card = (CardLayout) registerProperty.getJpl_contentPoints().getLayout();
        card.previous(registerProperty.getJpl_contentPoints());
    }

    private void showBeneficiaries() {
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerProperty);

        SelectBeneficiary dialog = new SelectBeneficiary(parentFrame, true);
        dialog.setLocationRelativeTo(registerProperty);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            int beneficiaryCode = dialog.codeBeneficiarySelected();
            registerProperty.getTxt_beneficiaryCode().setText("F" + beneficiaryCode);
        }
    }

}
