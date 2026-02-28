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
 * Controlador del diálogo de búsqueda de beneficiarios.
 *
 * <p>
 * Permite buscar beneficiarios por cédula, código o nombre
 * de forma asíncrona usando {@link SwingWorker}. Se utiliza
 * en el diálogo {@link SelectBeneficiary} para seleccionar
 * un beneficiario existente.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see SelectBeneficiary
 * @see BeneficiaryFacade
 * @since 1.0
 */
public class ControllerSearchDialog {

    /**
     * Diálogo de selección de beneficiarios.
     */
    private final SelectBeneficiary selectBeneficiary;

    /**
     * Fachada de acceso a datos de beneficiarios.
     */
    private final BeneficiaryFacade daoBeneficiary;

    /**
     * Crea el controlador asociado al diálogo indicado.
     *
     * @param selectBeneficiary diálogo de selección
     */
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

    /**
     * Verifica si el parámetro de búsqueda es inválido.
     *
     * @param param texto ingresado por el usuario
     * @return {@code true} si el parámetro es nulo, vacío o es el placeholder
     */
    private boolean isInvalidParam(String param) {
        return param == null || param.isBlank() || param.equalsIgnoreCase("Buscar");
    }

    /**
     * Resuelve la búsqueda del beneficiario según el tipo de parámetro.
     *
     * <p>
     * Si el parámetro es numérico, busca por cédula o código;
     * de lo contrario, busca por nombre.
     * </p>
     *
     * @param param criterio de búsqueda
     * @return DTO con los datos del beneficiario encontrado, o {@code null}
     * @throws Exception si ocurre un error en la consulta
     */
    private DTOBeneficiarySimpleDetails resolveSearch(String param) throws Exception {
        if (isNumeric(param)) {
            return searchByNumericValue(param);
        }

        return daoBeneficiary.findByName(param);
    }

    /**
     * Busca un beneficiario por valor numérico (cédula o código).
     *
     * <p>
     * Si el valor numérico es mayor o igual a 100.000, se interpreta
     * como número de cédula; de lo contrario, como código interno.
     * </p>
     *
     * @param value cadena numérica con el valor de búsqueda
     * @return DTO con los datos del beneficiario encontrado, o {@code null}
     * @throws Exception si ocurre un error en la consulta
     */
    private DTOBeneficiarySimpleDetails searchByNumericValue(String value) throws Exception {
        long numericValue = Long.parseLong(value);

        if (isDocumentNumber(numericValue)) {
            return daoBeneficiary.findById(numericValue);
        }

        return daoBeneficiary.findByCode((int) numericValue);
    }

    /**
     * Determina si el valor corresponde a un número de documento.
     *
     * @param value valor numérico a evaluar
     * @return {@code true} si es mayor o igual a 100.000
     */
    private boolean isDocumentNumber(long value) {
        return value >= 100000;
    }

    /**
     * Verifica si una cadena contiene únicamente dígitos.
     *
     * @param value cadena a validar
     * @return {@code true} si todos los caracteres son dígitos
     */
    private boolean isNumeric(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    /**
     * Cargar la lista completa de los beneficiarios registrados
     */
    public void loadUsers() {
        new Thread(() -> {
            try {
                List<DTOBeneficiarySimpleDetails> listBeneficiaries = daoBeneficiary.findByAll();
                SwingUtilities.invokeLater(() -> selectBeneficiary.loadBeneficiaries(listBeneficiaries));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> MessageUtils.errorMessage("Error. " + e.getMessage(), null));
            }
        }).start();
    }

}
