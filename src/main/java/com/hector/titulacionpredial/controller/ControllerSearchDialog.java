package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class ControllerSearchDialog {

    private final SelectBeneficiary selectBeneficiary;
    private final BeneficiaryFacade daoBeneficiary;

    public ControllerSearchDialog(SelectBeneficiary selectBeneficiary) {
        this.selectBeneficiary = selectBeneficiary;
        this.daoBeneficiary = new BeneficiaryImplFacade();
    }

    public void searchBeneficiary(String param) {
        new SwingWorker<DTOBeneficiarySimpleDetails, Void>() {
            @Override
            public DTOBeneficiarySimpleDetails doInBackground() throws Exception {
                return resolveSearch(param);
            }

            @Override
            public void done() {
                try {
                    DTOBeneficiarySimpleDetails dto = get();

                    if (dto == null) {
                        throw new Exception("No se han encontrado registros asociados al parámetro de búsqueda \"" + param + "\"");
                    }

                    selectBeneficiary.loadBeneficiary(dto);
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException("Error al realizar la búsqueda.");
                } catch (Exception e) {
                    MessageUtils.errorMessage("No se ha encontrado el beneficiario", null);
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

    private boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

}
