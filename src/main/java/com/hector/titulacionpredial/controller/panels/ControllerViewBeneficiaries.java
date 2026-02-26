package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.exception.dao.DAOException;
import com.hector.titulacionpredial.exception.dao.notfound.BeneficiaryNotFoundException;
import com.hector.titulacionpredial.exception.validation.InvalidInputException;
import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.observer.Observer;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.*;
import com.hector.titulacionpredial.view.content.dialogs.UserProfile;
import com.hector.titulacionpredial.view.content.panels.RegisterBeneficiary;
import com.hector.titulacionpredial.view.content.panels.ViewBeneficiaries;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author hectoracevedo
 */
public class ControllerViewBeneficiaries implements Observer {

    private final ViewBeneficiaries viewBeneficiaries;
    private final RegisterBeneficiary registerBeneficiary;
    private final Subject subject;

    private final BeneficiaryFacade daoBeneficiary;

    public ControllerViewBeneficiaries(ViewBeneficiaries viewBeneficiaries, RegisterBeneficiary registerBeneficiary, Subject subject) {
        this.viewBeneficiaries = viewBeneficiaries;
        this.registerBeneficiary = registerBeneficiary;
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
        viewBeneficiaries.setControllerSearchCancel(e -> cancelSearch());
        viewBeneficiaries.setControllerExportToExcel(e -> exportToExcel());
        documentListeners();
        listenerSearch();
    }

    @Override
    public void update() {
        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> loadData(listBeneficiaries));
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    private void showDetails() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new InvalidInputException("Debe seleccionar un beneficiario para ver su información");
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            prepareUI();
            doInBackground(code);
        } catch (InvalidInputException e) {
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

                SwingUtilities.invokeLater(() -> {
                    java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(viewBeneficiaries);
                    UserProfile dialog = new UserProfile(parentFrame, true);
                    dialog.loadBeneficiary(dto);

                    dialog.setLocationRelativeTo(viewBeneficiaries);
                    dialog.setVisible(true);

                    resetUI();
                });
            } catch (DAOException e) {
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
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (selectedRow == -1) {
                throw new InvalidInputException("Debe seleccionar un beneficiario para ver su información");
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);
            doInBackgroundModify(code);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    private void doInBackgroundModify(int code) {
        new Thread(() -> {
            try {
                DTOBeneficiaryDetails dto = daoBeneficiary.findAllData(code);

                if (dto == null) {
                    throw new BeneficiaryNotFoundException(String.valueOf(code));
                }

                SwingUtilities.invokeLater(() -> {
                    NavigatorUtils.showForms(registerBeneficiary);
                    registerBeneficiary.loadDataModify(dto);
                    registerBeneficiary.setModify(true);
                    registerBeneficiary.setNowStatus(dto.getMaritalStatus());
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    private void deleteBeneficiary() {
        try {
            int selectedRow = viewBeneficiaries.getJtbl_beneficiaries().getSelectedRow();

            if (viewBeneficiaries.getJtbl_beneficiaries().getSelectedRowCount() != 1) {
                throw new InvalidInputException("Debe seleccionar el beneficiario que desea eliminar");
            }

            int code = (int) viewBeneficiaries.getJtbl_beneficiaries().getValueAt(selectedRow, 0);

            runDelete(code);
        } catch (InvalidInputException e) {
            MessageUtils.warningMessage(e.getMessage(), viewBeneficiaries);
        }
    }

    private void runDelete(int code) {
        new Thread(() -> {
            try {
                daoBeneficiary.delete(code);
                SwingUtilities.invokeLater(() -> {
                    MessageUtils.informationMessage("Se ha eliminado el registro del beneficiario", viewBeneficiaries);
                    subject.notifyObservers();
                });
            } catch (DAOException e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries));
            }
        }).start();
    }

    private void search() {
        String param = getSearchParam();

        if (!isValid(param)) {
            MessageUtils.warningMessage("Debe ingresar un criterio de búsqueda", viewBeneficiaries);
            return;
        }

        viewBeneficiaries.getBtn_search().setVisible(false);
        viewBeneficiaries.getBtn_searchCancel().setVisible(true);

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
            protected DTOBeneficiarySimpleDetails doInBackground() throws DAOException {
                return resolveSearch(param);
            }

            @Override
            protected void done() {
                try {
                    handleResult(get(), param);
                } catch (DAOException | InterruptedException | ExecutionException e) {
                    MessageUtils.errorMessage("Error al buscar beneficiario", viewBeneficiaries);
                } finally {
                    lockUI(true);
                }
            }
        }.execute();
    }

    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws DAOException {
        if (isNumeric(param)) {
            long value = Long.parseLong(param);

            return (value > 100000) ? daoBeneficiary.findById(value) : daoBeneficiary.findByCode((int) value);
        }

        return daoBeneficiary.findByName(param);
    }

    private void handleResult(DTOBeneficiarySimpleDetails result, String param) throws DAOException {
        if (result == null) {
            throw new BeneficiaryNotFoundException(param);
        }

        viewBeneficiaries.getTableModel().setRowCount(0);
        viewBeneficiaries.loadData(result);
    }

    private boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

    private void lockUI(boolean isBlocked) {
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

    private void cancelSearch() {
        viewBeneficiaries.getTxt_search().setText("Buscar");
        viewBeneficiaries.getBtn_searchCancel().setVisible(false);
        viewBeneficiaries.getBtn_search().setVisible(true);
        subject.notifyObservers();
    }

    private void loadData(List<DTOBeneficiarySimpleDetails> listBeneficiaries) {
        viewBeneficiaries.getTableModel().setRowCount(0);
        listBeneficiaries.forEach(viewBeneficiaries::loadData);
    }

    private void exportToExcel() {
        try {
            String path = DialogUtils.selectRoute(viewBeneficiaries);

            if (path == null) return;

            DialogUtils.executeWithDialog(viewBeneficiaries, "Exportando reporte, por favor espere...",
                    "Reporte exportado exitosamente", () -> {
                        List<DTOBeneficiaryCreate> allBeneficiaries = daoBeneficiary.findAllForExport();
                        GenerateExcelBeneficiary.export(allBeneficiaries, path);
                        return null;
                    });
        } catch (Exception e) {
            MessageUtils.errorMessage(e.getMessage(), viewBeneficiaries);
        }
    }

}
