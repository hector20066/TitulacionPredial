package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.*;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.DialogUtils;
import com.hector.titulacionpredial.utils.GenerateResolutionUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author hectoracevedo
 */
public class ControllerGenerateResolution {

    private final GenerateResolution generateResolution;
    private final Subject subject;

    private final ResolutionFacade daoResolution;
    private final BeneficiaryFacade daoBeneficiary;

    public ControllerGenerateResolution(GenerateResolution generateResolution, Subject subject) {
        this.generateResolution = generateResolution;
        this.subject = subject;

        this.daoResolution = new ResolutionImplFacade();
        this.daoBeneficiary = new BeneficiaryImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        generateResolution.setControllerGenerate(e -> generateResolution());
    }

    private void generateResolution() {
        try {
            String resolutionNumber = generateResolution.getTxt_numResolution().getText().trim();
            Date executory = (Date) generateResolution.getFtx_executory().getValue();
            String act = generateResolution.getTxt_act().getText().trim();
            String publicWriting = generateResolution.getTxt_publicWriting().getText().trim();
            Date notification = (Date) generateResolution.getFtx_notification().getValue();
            String fmi = generateResolution.getTxt_fmi().getText().trim();
            String notary = generateResolution.getTxt_note().getText().trim();
            String propertyCode = generateResolution.getTxt_propertyCode().getText().trim();
            String beneficiaryName = generateResolution.getTxt_nameBeneficiary().getText().trim();
            String address = generateResolution.getTxt_addressBeneficiary().getText().trim();
            String cadastralId = generateResolution.getTxt_cadastralReference().getText().trim().replace(".", "");
            String area = generateResolution.getTxt_area().getText().trim();
            String idBeneficiaries = generateResolution.getTxt_idBeneficiary().getText().trim();

            String path = DialogUtils.selectRoute(generateResolution);

            if (executory == null || notification == null) {
                throw new EmptyFieldException("Ejecutorio y notificación");
            }

            if (path == null) {
                throw new InvalidInputException("Debe seleccionar la ruta para guardar el archivo.");
            }

            if (resolutionNumber.isBlank() || notary.isBlank() || propertyCode.isBlank()) {
                throw new EmptyFieldException("N. Resolución y Nota");
            }

            if (!NumericalValidationUtils.isNumeric(resolutionNumber)) {
                throw new InvalidNumberInputException("N. Resolución");
            }

            LocalDate executoryLocalDate = executory.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate notificationLocalDate = notification.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            doInBackground(Integer.parseInt(resolutionNumber), executoryLocalDate, act, publicWriting, notificationLocalDate,
                    fmi, notary, Integer.parseInt(propertyCode), beneficiaryName, idBeneficiaries, address, cadastralId, area, path);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), generateResolution);
        }
    }

    private void executeWithDialog(Callable<Void> task) {
        DialogUtils.executeWithDialog(generateResolution, "Generando documento, por favor espere...",
                "Se ha generado la resolución.", task, subject::notifyObservers);
    }

    private void doInBackground(int numResolution, LocalDate executory, String act, String publicWriting,
                                LocalDate notification, String fmi, String notary, int propertyCode, String beneficiaryName,
                                String idBeneficiaries, String address, String cadastralId, String area, String path) {
        executeWithDialog(() -> {
            if (daoResolution.findByCode((int) numResolution) != null) {
                throw new PersistenceException("Ya existe un registro con este numero de resolución en la base de datos");
            }

            List<DTOBeneficiarySimpleDetails> listDTOBeneficiaries = new ArrayList<>();
            String[] beneficiaries = idBeneficiaries.split(" - ");

            for (String idBeneficiary : beneficiaries) {
                DTOBeneficiarySimpleDetails dto = daoBeneficiary.findById(Long.parseLong(idBeneficiary.replace(" -", "")));
                listDTOBeneficiaries.add(dto);
            }

            daoResolution.add(numResolution, notification, executory, fmi, act, publicWriting, notary, propertyCode, beneficiaryName);
            generateDocument(path, listDTOBeneficiaries, address, cadastralId, fmi, area, String.valueOf(notification));
            return null;
        });
    }

    private void generateDocument(String path, List<DTOBeneficiarySimpleDetails> beneficiariesList,
                                  String address, String cadastralId, String fmi, String area, String notification) throws IOException {
        String northCoordinate1 = generateResolution.getTxt_northCoordinate1().getText().trim();
        String eastCoordinate1 = generateResolution.getTxt_eastCoordinate1().getText().trim();
        String distance1 = generateResolution.getTxt_distance1().getText().trim();
        String hillside1 = generateResolution.getTxt_hillside1().getText().trim();

        String northCoordinate2 = generateResolution.getTxt_northCoordinate2().getText().trim();
        String eastCoordinate2 = generateResolution.getTxt_eastCoordinate2().getText().trim();
        String distance2 = generateResolution.getTxt_distance2().getText().trim();
        String hillside2 = generateResolution.getTxt_hillside2().getText().trim();

        String northCoordinate3 = generateResolution.getTxt_northCoordinate3().getText().trim();
        String eastCoordinate3 = generateResolution.getTxt_eastCoordinate3().getText().trim();
        String distance3 = generateResolution.getTxt_distance3().getText().trim();
        String hillside3 = generateResolution.getTxt_hillside3().getText().trim();

        String northCoordinate4 = generateResolution.getTxt_northCoordinate4().getText().trim();
        String eastCoordinate4 = generateResolution.getTxt_eastCoordinate4().getText().trim();
        String distance4 = generateResolution.getTxt_distance4().getText().trim();
        String hillside4 = generateResolution.getTxt_hillside4().getText().trim();

        List<DTOPoint> points = new ArrayList<>();
        points.add(new DTOPoint.Builder()
                .numberPoint(1)
                .northCoordinate(Double.parseDouble(northCoordinate1))
                .eastCoordinate(Double.parseDouble(eastCoordinate1))
                .distance(Double.parseDouble(distance1))
                .hillside(hillside1)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(2)
                .northCoordinate(Double.parseDouble(northCoordinate2))
                .eastCoordinate(Double.parseDouble(eastCoordinate2))
                .distance(Double.parseDouble(distance2))
                .hillside(hillside2)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(3)
                .northCoordinate(Double.parseDouble(northCoordinate3))
                .eastCoordinate(Double.parseDouble(eastCoordinate3))
                .distance(Double.parseDouble(distance3))
                .hillside(hillside3)
                .build());

        points.add(new DTOPoint.Builder()
                .numberPoint(4)
                .northCoordinate(Double.parseDouble(northCoordinate4))
                .eastCoordinate(Double.parseDouble(eastCoordinate4))
                .distance(Double.parseDouble(distance4))
                .hillside(hillside4)
                .build());

        GenerateResolutionUtils.generateResolution(beneficiariesList, points, address, cadastralId, fmi, area, notification, path);
    }

}
