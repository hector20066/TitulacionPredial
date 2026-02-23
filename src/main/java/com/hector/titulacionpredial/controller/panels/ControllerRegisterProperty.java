package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PointImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;
import com.hector.titulacionpredial.view.content.panels.RegisterProperty;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ControllerRegisterProperty {

    private final RegisterProperty registerProperty;
    private final Subject subject;
    
    private final PropertyFacade daoProperty;
    private final PointFacade daoPoint;
    private final BeneficiaryFacade daoBeneficiary;

    public ControllerRegisterProperty(RegisterProperty registerProperty, Subject subject) {
        this.registerProperty = registerProperty;
        this.subject = subject;
        
        this.daoProperty = new PropertyImplFacade();
        this.daoPoint = new PointImplFacade();
        this.daoBeneficiary = new BeneficiaryImplFacade();

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

            if (cadastralId.isBlank() || area.isBlank()) {
                throw new Exception("Por favor ingrese toda la información del predio");
            }

            if (beneficiaryCode.isBlank()) {
                throw new Exception("Por favor ingrese el código del beneficiario");
            }

            String[] beneficiariesCode = beneficiaryCode.split(" - ");

            List<PointData> points = extractPoints();

            prepareUI();
            doInBackGround(cadastralId, Double.parseDouble(area), beneficiariesCode, points);
        } catch (Exception e) {
            MessageUtils.errorMessage("Ha ocurrido un error.\nError: " + e.getMessage(), registerProperty);
        }
    }

    private List<PointData> extractPoints() throws Exception {
        JTextField[][] fields = {
                { registerProperty.getTxt_northCoordinate1(), registerProperty.getTxt_eastCoordinate1(), registerProperty.getTxt_distance1(), registerProperty.getTxt_hillside1() },
                { registerProperty.getTxt_northCoordinate2(), registerProperty.getTxt_eastCoordinate2(), registerProperty.getTxt_distance2(), registerProperty.getTxt_hillside2() },
                { registerProperty.getTxt_northCoordinate3(), registerProperty.getTxt_eastCoordinate3(), registerProperty.getTxt_distance3(), registerProperty.getTxt_hillside3() },
                { registerProperty.getTxt_northCoordinate4(), registerProperty.getTxt_eastCoordinate4(), registerProperty.getTxt_distance4(), registerProperty.getTxt_hillside4() },
        };

        return getPointData(fields);
    }

    private List<PointData> getPointData(JTextField[][] fields) throws Exception {
        List<PointData> points = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            String north = fields[i][0].getText().trim();
            String east = fields[i][1].getText().trim();
            String distance = fields[i][2].getText().trim();
            String hillside = fields[i][3].getText().trim();

            if (invalidPoints(north, east, distance, hillside)) {
                throw new Exception("Por favor ingrese toda la información del punto " + (i + 1));
            }

            points.add(new PointData(i + 1, north, east, distance, hillside));
        }

        return points;
    }

    private boolean invalidPoints(String... info) {
        for (String data : info) {
            if (data.isBlank()) {
                return true;
            }
        }

        return false;
    }

    private void prepareUI() {
        registerProperty.getBtn_register().setText("Registrando Información...");
        registerProperty.getBtn_register().setEnabled(false);
    }

    private void doInBackGround(String cadastralId, double area, String[] beneficiaryCodes, List<PointData> points) {
        new Thread(() -> {
            try {
                if (daoProperty.findByCode(cadastralId) != null) {
                    throw new Exception("El predio con cedula catastral '" + cadastralId + "' ya se encuentra registrado");
                }

                int propertyCode = daoProperty.add(cadastralId, area);

                for (PointData p : points) {
                    daoPoint.add(p.pointNumber(),
                            Double.parseDouble(p.north()),
                            Double.parseDouble(p.east()),
                            Double.parseDouble(p.distance()),
                            p.hillside(),
                            propertyCode);
                }

                for (String beneficiaryCode : beneficiaryCodes) {
                    daoBeneficiary.modifyProperty(Integer.parseInt(beneficiaryCode), propertyCode);
                }

                SwingUtilities.invokeLater(this::runInvokeLater);
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage("Ha ocurrido un error al registrar la información.\nError: " +
                        e.getMessage(), registerProperty));
            }
        }).start();
    }

    private void runInvokeLater() {
        MessageUtils.informationMessage("Se ha registrado la información correctamente", registerProperty);
        subject.notifyObservers();
        resetUI();
    }

    private void resetUI() {
        registerProperty.getBtn_register().setText("REGISTRAR PREDIO");
        registerProperty.getBtn_register().setEnabled(true);
        registerProperty.clearFields();
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
        try {
            java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerProperty);

            SelectBeneficiary dialog = new SelectBeneficiary(parentFrame, true);
            dialog.loadBeneficiaries(daoBeneficiary.findByAll());
            dialog.setLocationRelativeTo(registerProperty);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                int beneficiaryCode = dialog.codeBeneficiarySelected();
                String beneficiaryCodeStr = registerProperty.getTxt_beneficiaryCode().getText().trim();
                registerProperty.getTxt_beneficiaryCode().setText( beneficiaryCodeStr + (beneficiaryCodeStr.isBlank() ? "" : " - ") + "F" + beneficiaryCode);
            }
        } catch (Exception e) {
            MessageUtils.errorMessage("Ha ocurrido un error al mostrar los beneficiarios", registerProperty);
        }
    }

    private record PointData(int pointNumber, String north, String east, String distance, String hillside) {

    }

}
