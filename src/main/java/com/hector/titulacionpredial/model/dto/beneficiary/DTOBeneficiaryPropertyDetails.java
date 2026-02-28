package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Data Transfer Object (DTO) que contiene la información obtenida
 * de un beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentación para mostrar la información, evitando
 * exponer directamente la entidad {@code Beneficiary}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando información especial
 * relacionada con el nombre completo y la cédula del beneficiario.
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
public class DTOBeneficiaryPropertyDetails extends DTOBeneficiary {

    private String fullName;
    private long id;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOBeneficiaryPropertyDetails() {
        super();
    }

    /**
     * Constructor usado para inicializar los parámetros de la clase.
     *
     * @param fullName     nombre completo del beneficiario
     * @param code         código único del beneficiario
     * @param municipality municipio de residencia del beneficiario
     * @param address      dirección del beneficiario
     */
    public DTOBeneficiaryPropertyDetails(String fullName, long code, Municipalities municipality, String address) {
        super();
        this.fullName = fullName;
        this.id = code;
        setMunicipality(municipality);
        setAddress(address);
    }

    public void setCode(long code) {
        this.id = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

}
