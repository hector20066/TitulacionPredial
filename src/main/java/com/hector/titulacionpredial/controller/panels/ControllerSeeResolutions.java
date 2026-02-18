package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.view.content.panels.SeeResolutions;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author hectoracevedo
 */
public class ControllerSeeResolutions {

    private final SeeResolutions seeResolutions;

    public ControllerSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;

        connectEvents();
    }

    private void connectEvents() {
        seeResolutions.setControllerModify(e -> modify());
        seeResolutions.setControllerSearch(e -> searchResolution());
        documentListeners();
        listenerSearch();
    }

    private void modify() {
        try {

        } catch (Exception e) {

        }
    }

    private void searchResolution() {
        try {

        } catch (Exception e) {

        }
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

}
