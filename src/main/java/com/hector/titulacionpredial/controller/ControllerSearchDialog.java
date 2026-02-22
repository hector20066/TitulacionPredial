package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author hectoracevedo
 */
public class ControllerSearchDialog {

    private final SelectBeneficiary selectBeneficiary;
    private final BeneficiaryFacade daoBeneficiary;

    public ControllerSearchDialog(SelectBeneficiary selectBeneficiary) {
        this.selectBeneficiary = selectBeneficiary;
        this.daoBeneficiary = new BeneficiaryImplFacade();
    }

    public void searchBeneficiary(String param) {
        if (isInvalidParam(param)) {
            MessageUtils.errorMessage("Debe ingresar el número de cédula, código o nombre", null);
            return;
        }

        new SwingWorker<DTOBeneficiarySimpleDetails, Void>() {
            @Override
            protected DTOBeneficiarySimpleDetails doInBackground() throws Exception {
                return resolveSearch(param.trim());
            }

            @Override
            protected void done() {
                try {
                    DTOBeneficiarySimpleDetails dto = get();

                    if (dto == null) {
                        MessageUtils.errorMessage("No se encontraron registros para: \"" + param + "\"", null);
                        return;
                    }

                    selectBeneficiary.loadBeneficiary(dto);
                } catch (ExecutionException e) {
                    MessageUtils.errorMessage(e.getCause().getMessage(), null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }.execute();
    }

    private boolean isInvalidParam(String param) {
        return param == null || param.isBlank() || param.equalsIgnoreCase("Buscar");
    }

    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws Exception {
        if (isNumeric(param)) {
            return searchByNumericValue(param);
        }

        return daoBeneficiary.findByName(param);
    }

    private DTOBeneficiarySimpleDetails searchByNumericValue(String value) throws Exception {
        long numericValue = Long.parseLong(value);

        if (isDocumentNumber(numericValue)) {
            return daoBeneficiary.findById(numericValue);
        }

        return daoBeneficiary.findByCode((int) numericValue);
    }

    private boolean isDocumentNumber(long value) {
        return value >= 1_000_000;
    }

    private boolean isNumeric(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    public void loadUsers() {
        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> selectBeneficiary.loadBeneficiaries(listBeneficiaries));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
