package com.hector.titulacionpredial.controller.panels;

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
public class ControllerViewBeneficiaries {

    private final ViewBeneficiaries viewBeneficiaries;

    public ControllerViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;

        connectEvents();
    }

    private void connectEvents() {
        viewBeneficiaries.setControllerViewDetails(e -> showDetails());
        viewBeneficiaries.setControllerModify(e -> modifyBeneficiary());
        viewBeneficiaries.setControllerDelete(e -> deleteBeneficiary());
        documentListeners();
        listenerSearch();
    }

    private void showDetails() {
        try {

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
        viewBeneficiaries.setControllerTxt_searchFocus(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        viewBeneficiaries.setControllerTxt_searchMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

}
