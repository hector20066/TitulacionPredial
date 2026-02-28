package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) que representa la información
 * de un Predio para operaciones de entrada o salida del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentación y
 * la capa de persistencia, evitando exponer directamente la entidad
 * {@code Property}
 * </p>
 *
 * <p>
 * Contiene la información base de un predio, como la cédula catastral
 * y el área del predio.
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
public class DTOProperty {

    /**
     * Referencia catastral.
     */
    protected String cadastralId;

    /**
     * Área del predio.
     */
    protected Double area;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOProperty() {

    }

    /**
     * Constructor utilizado para inicializar las variables.
     *
     * @param cadastralId cédula catastral del predio
     * @param area        área del predio
     */
    public DTOProperty(String cadastralId, Double area) {
        this.cadastralId = cadastralId;
        this.area = area;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
