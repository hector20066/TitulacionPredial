package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.view.content.dialogs.UserProfile;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

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
public class ControllerViewBeneficiaries implements Observer {

    private final ViewBeneficiaries viewBeneficiaries;
    private final Subject subject;

    public ControllerViewBeneficiaries(ViewBeneficiaries viewBeneficiaries, Subject subject) {
        this.viewBeneficiaries = viewBeneficiaries;
        this.subject = subject;

        this.subject.register(this);

        connectEvents();
    }

    private void connectEvents() {
        viewBeneficiaries.setControllerViewDetails(e -> showDetails());
        viewBeneficiaries.setControllerModify(e -> modifyBeneficiary());
        viewBeneficiaries.setControllerDelete(e -> deleteBeneficiary());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void showDetails() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();
            if (selectedRow == -1) {
                // return;
            }

            // Beneficiary beneficiary = getBeneficiaryFromTable(selectedRow);

            java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(viewBeneficiaries);
            UserProfile dialog = new UserProfile(parentFrame, true);

            // Cargar los datos en el diálogo (necesitas agregar este método a UserProfile)
            // dialog.loadBeneficiary(beneficiary);

            dialog.setLocationRelativeTo(viewBeneficiaries);
            dialog.setVisible(true);
        } catch (Exception e) {

        }
    }

    private void modifyBeneficiary() {
        try {

        } catch (Exception e) {

        }
    }

    private void deleteBeneficiary() {
        try {

        } catch (Exception e) {

        }
    }

    private void documentListeners() {
        viewBeneficiaries.setControllerTxt_searchDocument(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), "Buscar");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), "Buscar");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                FilterUtils.filterTable(viewBeneficiaries.getTxt_search(), viewBeneficiaries.getJtbl_beneficiaries(), "Buscar");
            }
        });
    }

    private void listenerSearch() {
        viewBeneficiaries.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (viewBeneficiaries.getTxt_search().getText().isBlank()) {
                    viewBeneficiaries.getTxt_search().setText("Buscar");
                }
            }
        });

        viewBeneficiaries.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (viewBeneficiaries.getTxt_search().getText().equals("Buscar")) {
                    viewBeneficiaries.getTxt_search().setText("");
                }
            }
        });
    }

}
