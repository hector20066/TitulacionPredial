package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) que contiene la informacion
 * para registrar predios en el sistema.
 *
 * <p>
 * Se utiliza para transportar datos de la capa de presentacion
 * a la capa de persistencia para guardar la informacion, evitando
 * exponer directamente la entidad {@code Property}.
 * </p>
 *
 * <p>
 * Extiende {@link DTOProperty} obteniendo la informacion necesaria
 * que se necesita para registrar un predio.
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
     * @param cadastralId cedula catastral del predio
     * @param area        area del predio
     */
    public DTOPropertyCreate(String cadastralId, Double area) {
        super(cadastralId, area);
    }

}
