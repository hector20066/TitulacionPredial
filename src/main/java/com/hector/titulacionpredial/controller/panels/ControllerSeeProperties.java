package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
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
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class ControllerSeeProperties implements Observer {

    private final SeeProperties seeProperties;
    private final GenerateResolution generateResolution;
    private final Subject subject;

    private final PropertyFacade daoProperty;

    public ControllerSeeProperties(SeeProperties seeProperties, GenerateResolution generateResolution, Subject subject) {
        this.seeProperties = seeProperties;
        this.generateResolution = generateResolution;
        this.subject = subject;

        this.subject.register(this);

        this.daoProperty = new PropertyImplFacade();

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
        new Thread(() -> {
            try {
                List<DTOPropertyDetails> properties = daoProperty.findByAll();
                SwingUtilities.invokeLater(() -> loadData(properties));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void generateResolution() {
        try {

            NavigatorUtils.showForms(generateResolution);
        } catch (Exception e) {

        }
    }

    private void deleteProperty() {
        try {
            if (seeProperties.getJtbl_properties().getSelectedRow() < 0) {
                throw new Exception("Por favor seleccione una fila para eliminar");
            }

            int code = (int) seeProperties.getJtbl_properties().getValueAt(seeProperties.getJtbl_properties().getSelectedRow(), 0);

            runDelete(() -> {
                try {
                    daoProperty.delete(code);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {

        }
    }

    private void runDelete(Runnable delete) {
        new Thread(() -> {
            delete.run();

            SwingUtilities.invokeLater(() -> {
                MessageUtils.informationMessage("Se ha eliminado el registro", seeProperties);
                subject.notifyObservers();
            });
        }).start();
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

    private void loadData(List<DTOPropertyDetails> listProperties) {
        seeProperties.loadData(listProperties);
    }

}
