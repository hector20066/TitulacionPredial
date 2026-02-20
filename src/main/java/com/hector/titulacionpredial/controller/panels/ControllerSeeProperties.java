package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.PropertyImplFacade;
import com.hector.titulacionpredial.facade.interfaces.PropertyFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
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
            int selectedRow = seeProperties.getJtbl_properties().getSelectedRow();

            if (selectedRow < 0) {
                throw new Exception("Por favor seleccione una fila para generar la resolución");
            }

            int propertyCode = (int) seeProperties.getJtbl_properties().getValueAt(selectedRow, 0);
            String beneficiaryName = seeProperties.getJtbl_properties().getValueAt(selectedRow, 1).toString();
            long beneficiaryId = (long) seeProperties.getJtbl_properties().getValueAt(selectedRow, 2);
            String address = seeProperties.getJtbl_properties().getValueAt(selectedRow, 11).toString();
            Municipalities municipalities = Municipalities.valueOf(seeProperties.getJtbl_properties().getValueAt(selectedRow, 12).toString());
            long cadastralReference = (long) seeProperties.getJtbl_properties().getValueAt(selectedRow, 10);

            double eastCoordinate1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 13);
            double northCoordinate1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 14);
            double distance1 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 15);
            String hillside1 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 16).toString();

            double eastCoordinate2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 17);
            double northCoordinate2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 18);
            double distance2 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 19);
            String hillside2 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 20).toString();

            double eastCoordinate3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 21);
            double northCoordinate3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 22);
            double distance3 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 23);
            String hillside3 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 24).toString();

            double eastCoordinate4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 25);
            double northCoordinate4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 26);
            double distance4 = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 27);
            String hillside4 = seeProperties.getJtbl_properties().getValueAt(selectedRow, 28).toString();

            String[] point1 = {String.valueOf(northCoordinate1), String.valueOf(eastCoordinate1), String.valueOf(distance1), hillside1};
            String[] point2 = {String.valueOf(northCoordinate2), String.valueOf(eastCoordinate2), String.valueOf(distance2), hillside2};
            String[] point3 = {String.valueOf(northCoordinate3), String.valueOf(eastCoordinate3), String.valueOf(distance3), hillside3};
            String[] point4 = {String.valueOf(northCoordinate4), String.valueOf(eastCoordinate4), String.valueOf(distance4), hillside4};

            double area = (double) seeProperties.getJtbl_properties().getValueAt(selectedRow, 29);
            
            DTOBeneficiarySimpleDetails dtoBeneficiary = createDTOBeneficiaries(beneficiaryName, beneficiaryId, address, municipalities, cadastralReference);

            generateResolution.loadData(area, point1, point2, point3, point4, propertyCode, dtoBeneficiary);
            NavigatorUtils.showForms(generateResolution);
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    private DTOBeneficiarySimpleDetails createDTOBeneficiaries(String nameBeneficiary, long id, String address, Municipalities municipalities, long cadastralReference) {
        return new DTOBeneficiarySimpleDetails.Builder()
                .fullName(nameBeneficiary)
                .id(id)
                .address(address)
                .municipality(municipalities)
                .cadastralReference(cadastralReference)
                .build();
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
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
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
            String searchText = seeProperties.getTxt_search().getText().trim();

            if (searchText.isBlank() || searchText.equals("Buscar")) {
                throw new Exception("Por favor ingrese la cedula catastral para realizar la búsqueda");
            }

            doInBackground(searchText);
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), seeProperties);
        }
    }

    private void doInBackground(String searchText) {
        new Thread(() -> {
            try {
                DTOPropertyDetails dtoPropertyDetails = daoProperty.findByCode(searchText);

                if (dtoPropertyDetails == null) {
                    throw new Exception("No se ha encontrado el Predio con la cedula catastral: " + searchText);
                }

                SwingUtilities.invokeLater(() -> seeProperties.loadData(dtoPropertyDetails));
            } catch (Exception e) {
                MessageUtils.errorMessage(e.getMessage(), seeProperties);
            }
        }).start();
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
        seeProperties.getModel().setRowCount(0);
        listProperties.forEach(seeProperties::loadData);
    }

}
