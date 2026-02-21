package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.panels.ModifyResolution;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ControllerSeeResolutions implements Observer {

    private final SeeResolutions seeResolutions;
    private final ModifyResolution modifyResolution;

    private final ResolutionFacade daoResolution;

    public ControllerSeeResolutions(SeeResolutions seeResolutions, ModifyResolution modifyResolution, Subject subject) {
        this.seeResolutions = seeResolutions;
        this.modifyResolution = modifyResolution;

        subject.register(this);

        this.daoResolution = new ResolutionImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        seeResolutions.setControllerModify(e -> modify());
        seeResolutions.setControllerSearch(e -> searchResolution());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOResolutionDetails> listResolutions = daoResolution.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listResolutions));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void modify() {
        try {
            int selectedRow = seeResolutions.getJtbl_resolutions().getSelectedRow();

            if (seeResolutions.getJtbl_resolutions().getSelectedRowCount() != 1) {
                throw new Exception("Solo puede modificar una resolución a la vez");
            }

            int code = (int) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 0);
            long numResolution = (long) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 1);
            LocalDate notification = (LocalDate) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 2);
            LocalDate executory = (LocalDate) seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 3);
            String notary = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 4).toString();
            String fmi = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 5).toString();
            String act = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 6).toString();
            String publicWriting = seeResolutions.getJtbl_resolutions().getValueAt(selectedRow, 7).toString();

            DTOResolutionDetails dto = createDTO(code, numResolution, notification, executory, notary, fmi, act, publicWriting);

            modifyResolution.loadData(dto);
            NavigatorUtils.showForms(modifyResolution);
        } catch (Exception e) {
            MessageUtils.warningMessage(e.getMessage(), seeResolutions);
        }
    }

    private DTOResolutionDetails createDTO(int code, long numResolution, LocalDate notification, LocalDate executory, String notary, String fmi, String act, String publicWriting) {
        return new DTOResolutionDetails.Builder()
                .code(code)
                .resolutionNumber(numResolution)
                .notification(notification)
                .executory(executory)
                .notary(notary)
                .fmi(fmi)
                .act(act)
                .publicWriting(publicWriting)
                .build();
    }

    private void searchResolution() {
        try {
            String numResolutionText = seeResolutions.getTxt_search().getText().trim();

            if (numResolutionText.isBlank() || numResolutionText.equalsIgnoreCase("Buscar")) {
                throw new Exception("Debe ingresar el numero de la resolución para realizar la búsqueda");
            }

            doInBackground(Integer.parseInt(numResolutionText));
        } catch (Exception e) {
            MessageUtils.warningMessage("Ha ocurrido un error.\nError: " + e.getMessage(), seeResolutions);
        }
    }

    private void doInBackground(int numResolution) {
        new Thread(() -> {
            try {
                DTOResolutionDetails dto = daoResolution.findByCode(numResolution);

                if (dto == null) {
                    throw new Exception("No se ha encontrado la resolución con el numero " + numResolution);
                }

                SwingUtilities.invokeLater(() -> seeResolutions.loadData(dto));
            } catch (Exception e) {
                MessageUtils.errorMessage(e.getMessage(), seeResolutions);
            }
        }).start();
    }

    private void documentListeners() {
        seeResolutions.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeResolutions.getTxt_search(), seeResolutions.getJtbl_resolutions(), "Buscar");
            }
        });
    }

    private void listenerSearch() {
        seeResolutions.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeResolutions.getTxt_search().getText().isBlank()) {
                    seeResolutions.getTxt_search().setText("Buscar");
                }
            }
        });

        seeResolutions.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeResolutions.getTxt_search().getText().equals("Buscar")) {
                    seeResolutions.getTxt_search().setText("");
                }
            }
        });
    }

    private void loadData(List<DTOResolutionDetails> listResolutions) {
        seeResolutions.getModel().setRowCount(0);
        listResolutions.forEach(seeResolutions::loadData);
    }

}
