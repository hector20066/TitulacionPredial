package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Data Transfer Object (DTO) que contiene la informacion obtenida
 * de un beneficiario.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de persistencia
 * a la capa de presentacion para mostrar la informacion, evitando
 * exponer directamente la entidad {@code Beneficiary}
 * </p>
 *
 * <p>
 * Extiende {@link DTOBeneficiary} agregando informacion especial
 * relacionada con el nombre completo y la cedula del beneficiario.
 * </p>
 *
 * <p>
 * Este DTO no contiene logica de negocio ni reglas de validacion.
 * Su unica responsabilidad es encapsular datos.
 * </p>
 *
 * @author hectoracevedo
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
     * Constructor usado para inicializar los parametros de la clase.
     *
     * @param fullName     nombre completo del beneficiario
     * @param code         codigo unico del beneficiario
     * @param municipality municipio de residencia del beneficiario
     * @param address      direccion del beneficiario
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
