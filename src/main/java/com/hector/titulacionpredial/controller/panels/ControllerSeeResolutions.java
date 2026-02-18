package com.hector.titulacionpredial.controller.panels;

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

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private void listenerSearch() {
        seeResolutions.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        seeResolutions.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

}
