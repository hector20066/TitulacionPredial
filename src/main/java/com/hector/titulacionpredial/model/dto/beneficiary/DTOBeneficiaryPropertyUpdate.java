package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Data Transfer Object (DTO) que contiene la información para actualizar
 * los datos del beneficiario con respecto a un predio.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación a
 * la capa de persistencia para actualizar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Contiene el código de la propiedad la cual se ha asignado al
 * beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOBeneficiaryPropertyUpdate {

    private int beneficiaryCode;
    private int propertyCode;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiaryPropertyUpdate() {

    }

    /**
     * Constructor utilizado para inicializar las variables.
     *
     * @param beneficiaryCode código del beneficiario
     * @param propertyCode    código de la propiedad
     */
    public DTOBeneficiaryPropertyUpdate(int beneficiaryCode, int propertyCode) {
        this.beneficiaryCode = beneficiaryCode;
        this.propertyCode = propertyCode;
    }

    public int getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public void setBeneficiaryCode(int beneficiaryCode) {
        this.beneficiaryCode = beneficiaryCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

}
