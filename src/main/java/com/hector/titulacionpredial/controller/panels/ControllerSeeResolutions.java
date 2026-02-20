package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.ResolutionImplFacade;
import com.hector.titulacionpredial.facade.interfaces.ResolutionFacade;
import com.hector.titulacionpredial.model.dto.resolution.DTOResolutionDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ControllerSeeResolutions implements Observer {

    private final SeeResolutions seeResolutions;
    private final Subject subject;

    private final ResolutionFacade daoResolution;

    public ControllerSeeResolutions(SeeResolutions seeResolutions, Subject subject) {
        this.seeResolutions = seeResolutions;
        this.subject = subject;

        this.subject.register(this);

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

        } catch (Exception e) {

        }
    }

    private void searchResolution() {
        try {
            String numResolutionText = seeResolutions.getTxt_search().getText().trim();

            if (numResolutionText.isBlank() || numResolutionText.equals("Buscar")) {
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
