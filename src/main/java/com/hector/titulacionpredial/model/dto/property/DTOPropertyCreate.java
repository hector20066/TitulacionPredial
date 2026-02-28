package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) que contiene la información
 * para registrar predios en el sistema.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentación
 * a la capa de persistencia para guardar la información, evitando
 * exponer directamente la entidad {@code Property}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOProperty} obteniendo la información necesaria
 * que se necesita para registrar un predio.
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
public class DTOPropertyCreate extends DTOProperty {

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOPropertyCreate() {
        super();
    }

    /**
     * Constructor utilizado para inicializar las variables.
     *
     * @param cadastralId cédula catastral del predio
     * @param area        área del predio
     */
    public DTOPropertyCreate(String cadastralId, Double area) {
        super(cadastralId, area);
    }

}
