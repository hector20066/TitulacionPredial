package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.PointImplFacade;
import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.PointFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
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
                throw new EmptyFieldException("Cedula Catastral, Area y Código del Beneficiario");
            }

            String[] beneficiariesCode = beneficiaryCode.split(" - ");
            List<PointData> points = extractPoints();

            prepareUI();
            doInBackGround(cadastralId, Double.parseDouble(area.replace(",", ".")), beneficiariesCode, points);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), registerProperty);
        }
    }

    private List<PointData> extractPoints() throws InvalidInputException {
        JTextField[][] fields = {
                {registerProperty.getTxt_northCoordinate1(), registerProperty.getTxt_eastCoordinate1(), registerProperty.getTxt_distance1(), registerProperty.getTxt_hillside1()},
                {registerProperty.getTxt_northCoordinate2(), registerProperty.getTxt_eastCoordinate2(), registerProperty.getTxt_distance2(), registerProperty.getTxt_hillside2()},
                {registerProperty.getTxt_northCoordinate3(), registerProperty.getTxt_eastCoordinate3(), registerProperty.getTxt_distance3(), registerProperty.getTxt_hillside3()},
                {registerProperty.getTxt_northCoordinate4(), registerProperty.getTxt_eastCoordinate4(), registerProperty.getTxt_distance4(), registerProperty.getTxt_hillside4()},
        };

        return getPointData(fields);
    }

    private List<PointData> getPointData(JTextField[][] fields) throws InvalidInputException {
        List<PointData> points = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            String north = fields[i][0].getText().trim();
            String east = fields[i][1].getText().trim();
            String distance = fields[i][2].getText().trim();
            String hillside = fields[i][3].getText().trim();

            if (invalidPoints(north, east, distance, hillside)) {
                throw new EmptyFieldException("del punto " + (i + 1));
            }

            north = north.replace(",", ".");
            east = east.replace(",", ".");
            distance = distance.replace(",", ".");
            hillside = hillside.replace(",", ".");

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
                    throw new PersistenceException("El predio con cedula catastral '" + cadastralId + "' ya se encuentra registrado");
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
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerProperty));
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
        prepareUILoadBeneficiaries();

        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> dto = daoBeneficiary.findAllWithoutProperty();
                SwingUtilities.invokeLater(() -> loadInvokerDialog(dto));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), registerProperty));
            }
        }).start();
    }

    private void prepareUILoadBeneficiaries() {
        registerProperty.getBtn_register().setEnabled(false);
        registerProperty.getBtn_selectBeneficiary().setEnabled(false);
        registerProperty.getBtn_selectBeneficiary().setText("Buscando Beneficiarios...");
    }

    private void loadInvokerDialog(List<DTOBeneficiarySimpleDetails> dto) {
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(registerProperty);

        SelectBeneficiary dialog = new SelectBeneficiary(parentFrame, true);
        dialog.loadBeneficiaries(dto);
        dialog.setLocationRelativeTo(registerProperty);
        dialog.setVisible(true);

        resetUILoadBeneficiaries();

        if (dialog.isConfirmed()) {
            int beneficiaryCode = dialog.codeBeneficiarySelected();
            String beneficiaryCodeStr = registerProperty.getTxt_beneficiaryCode().getText().trim();
            registerProperty.getTxt_beneficiaryCode().setText(beneficiaryCodeStr + (beneficiaryCodeStr.isBlank() ? "" : " - ") + "F" + beneficiaryCode);
        }
    }

    private void resetUILoadBeneficiaries() {
        registerProperty.getBtn_register().setEnabled(true);
        registerProperty.getBtn_selectBeneficiary().setEnabled(true);
        registerProperty.getBtn_selectBeneficiary().setText("Buscar Beneficiario");
    }

    private record PointData(int pointNumber, String north, String east, String distance, String hillside) {

    }

}
