package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.facade.impl.BeneficiaryImplFacade;
import com.hector.titulacionpredial.facade.interfaces.BeneficiaryFacade;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiarySimpleDetails;
import com.hector.titulacionpredial.utils.MessageUtils;
import com.hector.titulacionpredial.view.content.dialogs.SelectBeneficiary;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Beneficiary search dialog controller.
 *
 * <p>
 * It allows you to search for beneficiaries by ID number, code, or
 * name asynchronously using {@link SwingWorker}. It is used in the
 * {@link SelectBeneficiary} dialog to select an existing beneficiary.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SelectBeneficiary
 * @see BeneficiaryFacade
 * @since 1.0
 */
public class ControllerSelectDialog {

    private final SelectBeneficiary selectBeneficiary;

    private final BeneficiaryFacade daoBeneficiary;
    private final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Create the controller associated with the specified dialog.
     *
     * @param selectBeneficiary selection dialogue
     */
    public ControllerSelectDialog(SelectBeneficiary selectBeneficiary) {
        this.selectBeneficiary = selectBeneficiary;
        this.daoBeneficiary = new BeneficiaryImplFacade();
    }

    /**
     * Search for a beneficiary asynchronously based on the provided parameter.
     *
     * <p>
     * The search is executed in a secondary thread using {@link SwingWorker}.
     * If the parameter is numeric, it searches by ID number or code; otherwise,
     * it searches by name.
     * </p>
     *
     * @param param search criteria (ID number, code or beneficiary name)
     */
    public void searchBeneficiary(String param) {
        if (isInvalidParam(param)) {
            MessageUtils.errorMessage(lang.message("message.beneficiary.enter.params"), null);
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
                        MessageUtils.errorMessage(lang.message("message.beneficiary.not.find") + " \""
                                + param + "\"", null);
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

    /**
     * Check if the search parameter is invalid.
     *
     * @param param text entered by the user
     * @return {@code true} if the parameter is null, empty, or is the placeholder
     */
    private boolean isInvalidParam(String param) {
        return param == null || param.isBlank()
                || param.equalsIgnoreCase("Buscar")
                || param.equalsIgnoreCase("Search");
    }

    /**
     * Resolve the beneficiary search according to the parameter type.
     *
     * <p>
     * If the parameter is numeric, search by ID number or code,
     * otherwise, search by name.
     * </p>
     *
     * @param param search criteria
     * @return DTO with the beneficiary's data found, or {@code null}
     * @throws Exception if an error occurs in the query
     */
    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws Exception {
        if (isNumeric(param)) {
            return searchByNumericValue(param);
        }

        return daoBeneficiary.findByName(param);
    }

    /**
     * Search for a beneficiary by numerical value (ID or code).
     *
     * <p>
     * If the numerical value is greater than or equal to 100,000,
     * it is interpreted as an ID number; otherwise, as an internal code.
     * </p>
     *
     * @param value numeric string with the search value
     * @return DTO with the beneficiary's data found, or {@code null}
     * @throws Exception if an error occurs in the query
     */
    private DTOBeneficiarySimpleDetails searchByNumericValue(String value) throws Exception {
        long numericValue = Long.parseLong(value);

        if (isDocumentNumber(numericValue)) {
            return daoBeneficiary.findById(numericValue);
        }

        return daoBeneficiary.findByCode((int) numericValue);
    }

    /**
     * Determine if the value corresponds to a document number.
     *
     * @param value numerical value to be evaluated
     * @return {@code true} if it is greater than or equal to 100,000
     */
    private boolean isDocumentNumber(long value) {
        return value >= 100000;
    }

    /**
     * Check if a string contains only digits.
     *
     * @param value string to validate
     * @return {@code true} if all characters are digits
     */
    private boolean isNumeric(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    /**
     * Upload the complete list of registered beneficiaries
     */
    public void loadUsers() {
        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> selectBeneficiary.loadBeneficiaries(listBeneficiaries));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage(lang.app("controller.search.dialog.error")
                        + " " + e.getMessage(), null));
            }
        }).start();
    }

}
