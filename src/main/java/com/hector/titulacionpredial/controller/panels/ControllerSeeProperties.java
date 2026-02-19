package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;

import javax.swing.*;
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
public class ControllerSeeProperties implements Observer {

    private final SeeProperties seeProperties;
    private final GenerateResolution generateResolution;
    private final Subject subject;

    public ControllerSeeProperties(SeeProperties seeProperties, GenerateResolution generateResolution, Subject subject) {
        this.seeProperties = seeProperties;
        this.generateResolution = generateResolution;
        this.subject = subject;

        this.subject.register(this);

        connectEvents();
    }

    private void connectEvents() {
        seeProperties.setControllerGenerate(e -> generateResolution());
        seeProperties.setControllerDelete(e -> deleteProperty());
        seeProperties.setControllerSearch(e -> searchProperty());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {

    }

    private void generateResolution() {
        try {
            NavigatorUtils.showForms(generateResolution);
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
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(seeProperties.getTxt_search(), seeProperties.getJtbl_properties(), "Buscar");
            }
        });
    }

    private void listenerSearch() {
        seeProperties.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (seeProperties.getTxt_search().getText().isBlank()) {
                    seeProperties.getTxt_search().setText("Buscar");
                }
            }
        });

        seeProperties.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (seeProperties.getTxt_search().getText().equals("Buscar")) {
                    seeProperties.getTxt_search().setText("");
                }
            }
        });
    }

}
