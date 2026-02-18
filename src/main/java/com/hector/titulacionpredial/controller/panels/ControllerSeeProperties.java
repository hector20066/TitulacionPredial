package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.view.content.panels.SeeProperties;

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
public class ControllerSeeProperties {

    private final SeeProperties seeProperties;

    public ControllerSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;

        connectEvents();
    }

    private void connectEvents() {
        seeProperties.setControllerGenerate(e -> generateResolution());
        seeProperties.setControllerDelete(e -> deleteProperty());
        seeProperties.setControllerSearch(e -> searchProperty());
        documentListeners();
        listenerSearch();
    }

    private void generateResolution() {
        try {

        } catch (Exception e) {

        }
    }

    private void deleteProperty() {
        try {

        } catch (Exception e) {

        }
    }

    private void searchProperty() {
        try {

        } catch (Exception e) {

        }
    }

    private void documentListeners() {
        seeProperties.setControllerTxt_searchDocument(new DocumentListener() {
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
        seeProperties.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        seeProperties.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

}
