package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.PersistenceException;
import com.hector.titulacionpredial.exception.validation.EmptyFieldException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.exception.validation.InvalidNumberInputException;
import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NumericalValidationUtils;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 *
 * @author hectoracevedo
 */
public class ControllerGenerateResolution {

    private final GenerateResolution generateResolution;
    private final Subject subject;

    private final ResolutionFacade daoResolution;

    public ControllerGenerateResolution(GenerateResolution generateResolution, Subject subject) {
        this.generateResolution = generateResolution;
        this.subject = subject;

        this.daoResolution = new ResolutionImplFacade();

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

            if (resolutionNumber.isBlank() || notary.isBlank() || propertyCode.isBlank()) {
                throw new EmptyFieldException("N. Resolución y Nota");
            }

            if (!NumericalValidationUtils.isNumeric(resolutionNumber)) {
                throw new InvalidNumberInputException("N. Resolución");
            }

            LocalDate executoryLocalDate = executory.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate notificationLocalDate = notification.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            doInBackground(Long.parseLong(resolutionNumber), executoryLocalDate, act, publicWriting, notificationLocalDate,
                    fmi, notary, Integer.parseInt(propertyCode), beneficiaryName);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), generateResolution);
        }
    }

    private JDialog createLoadDialog() {
        Window parentWindow = SwingUtilities.getWindowAncestor(generateResolution);

        JDialog dialog = new JDialog(parentWindow, "Procesando", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(350, 120);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Generando documento, por favor espere...");
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setPreferredSize(new Dimension(0, 8));
        progress.setBorderPainted(false);
        progress.setForeground(new Color(70, 130, 180));
        progress.setBackground(new Color(230, 230, 230));

        panel.add(label, BorderLayout.CENTER);
        panel.add(progress, BorderLayout.SOUTH);

        dialog.setContentPane(panel);
        dialog.setLocationRelativeTo(generateResolution);

        return dialog;
    }

    private void executeWithDialog(Callable<Void> task) {
        JDialog dialog = createLoadDialog();

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                task.call();
                return null;
            }

            @Override
            protected void done() {
                dialog.dispose();

                try {
                    get();
                    MessageUtils.informationMessage("Se ha completado la operación", generateResolution);
                    subject.notifyObservers();
                } catch (Exception e) {
                    String msg = (e.getCause() != null) ? e.getCause().getMessage() : e.getMessage();
                    MessageUtils.errorMessage("Ha ocurrido un error.\nError: " + msg, generateResolution);
                }
            }
        };

        worker.execute();
        dialog.setVisible(true);
    }

    private void doInBackground(long numResolution, LocalDate executory, String act, String publicWriting,
                                LocalDate notification, String fmi, String notary, int propertyCode, String beneficiaryName) {
        executeWithDialog(() -> {
            if (daoResolution.findByCode((int) numResolution) != null) {
                throw new PersistenceException("Ya existe un registro con este numero de resolución en la base de datos");
            }

            daoResolution.add(numResolution, notification, executory, fmi, act, publicWriting, notary, propertyCode, beneficiaryName);
            generateDocument();
            return null;
        });
    }

    private void generateDocument() {

    }

}
