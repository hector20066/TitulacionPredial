package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.FilterUtils;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.UserProfile;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author hectoracevedo
 */
public class ControllerViewBeneficiaries implements Observer {

    private final ViewBeneficiaries viewBeneficiaries;
    private final Subject subject;

    private final BeneficiaryFacade daoBeneficiary;

    public ControllerViewBeneficiaries(ViewBeneficiaries viewBeneficiaries, Subject subject) {
        this.viewBeneficiaries = viewBeneficiaries;
        this.subject = subject;

        this.subject.register(this);

        this.daoBeneficiary = new BeneficiaryImplFacade();

        connectEvents();
    }

    private void connectEvents() {
        viewBeneficiaries.setControllerViewDetails(e -> showDetails());
        viewBeneficiaries.setControllerModify(e -> modifyBeneficiary());
        viewBeneficiaries.setControllerDelete(e -> deleteBeneficiary());
        viewBeneficiaries.setControllerSearch(e -> search());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listBeneficiaries));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void showDetails() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new Exception("Debe seleccionar un beneficiario para ver su información");
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            prepareUI();
            doInBackground(code);
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    private void prepareUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(false);
        viewBeneficiaries.getBtn_seeProfile().setText("Buscando Información...");
    }

    private void doInBackground(int code) {
        new Thread(() -> {
            try {
                DTOBeneficiaryDetails dto = daoBeneficiary.findAllData(code);

                if (dto == null) {
                    throw new Exception("No se han encontrado registros para este usuario, lamentamos los inconvenientes.");
                }

                SwingUtilities.invokeLater(() -> {
                    java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(viewBeneficiaries);
                    UserProfile dialog = new UserProfile(parentFrame, true);
                    dialog.loadBeneficiary(dto);

                    dialog.setLocationRelativeTo(viewBeneficiaries);
                    dialog.setVisible(true);

                    resetUI();
                });
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    private void resetUI() {
        viewBeneficiaries.getBtn_seeProfile().setEnabled(true);
        viewBeneficiaries.getBtn_seeProfile().setText("Ver Información Completa");
    }

    private void modifyBeneficiary() {
        try {

        } catch (Exception e) {

        }
    }

    private void deleteBeneficiary() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (viewBeneficiaries.getJtbl_beneficiaries().getSelectedRowCount() != 1) {
                throw new Exception("Debe seleccionar el beneficiario que desea eliminar");
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            runDelete(() -> {
                try {
                    daoBeneficiary.delete(code);
                } catch (Exception e) {
                    throw new RuntimeException("Ha ocurrido un error al eliminar el registro");
                }
            });
        } catch (Exception e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    private void runDelete(Runnable task) {
        new Thread(() -> {
            task.run();

            SwingUtilities.invokeLater(() -> {
                MessageUtils.informationMessage("Se ha eliminado el registro del beneficiario", viewBeneficiaries);
                subject.notifyObservers();
            });
        }).start();
    }

    private void search() {
        String param = getSearchParam();

        if (!isValid(param)) {
            MessageUtils.warningMessage("Debe ingresar un criterio de búsqueda", viewBeneficiaries);
            return;
        }

        lockUI(false);
        executeSearchAsync(param);
    }

    private String getSearchParam() {
        return viewBeneficiaries.getTxt_search().getText().trim();
    }

    private boolean isValid(String param) {
        return !(param.isBlank() || param.equalsIgnoreCase("Buscar"));
    }

    private void executeSearchAsync(String param) {
        new SwingWorker<DTOBeneficiarySimpleDetails, Void>() {
            @Override
            protected DTOBeneficiarySimpleDetails doInBackground() throws Exception {
                return resolveSearch(param);
            }

            @Override
            protected void done() {
                try {
                    handleResult(get());
                } catch (Exception e) {
                    MessageUtils.errorMessage("Error al buscar beneficiario", viewBeneficiaries);
                } finally {
                    lockUI(true);
                }
            }
        }.execute();
    }

    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws Exception {
        if (isNumeric(param)) {
            long value = Long.parseLong(param);

            return (value > 1_000_000) ? daoBeneficiary.findById(value) : daoBeneficiary.findByCode((int) value);
        }

        return daoBeneficiary.findByName(param);
    }

    private void handleResult(DTOBeneficiarySimpleDetails result) {
        if (result == null) {
            MessageUtils.errorMessage("No se encontró el beneficiario", viewBeneficiaries);
            return;
        }

        viewBeneficiaries.loadData(result);
    }

    private boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

    private void lockUI(boolean isBlocked) {
        viewBeneficiaries.getBtn_search().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_delete().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_modify().setEnabled(isBlocked);
        viewBeneficiaries.getBtn_seeProfile().setEnabled(isBlocked);
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

    private void loadData(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        viewBeneficiaries.getTableModel().setRowCount(0);
        listBeneficiaries.forEach(viewBeneficiaries::loadData);
    }

}
