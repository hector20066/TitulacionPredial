package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) base que contiene información
 * común relacionada con datos personales.
 *
 * <p>
 * Esta clase es utilizada para transportar información entre
 * capas del sistema (por ejemplo, entre la capa de presentación
 * y la capa de aplicación) sin exponer directamente las entidades
 * del dominio.
 * </p>
 *
 * <p>
 * No contiene lógica de negocio y su única responsabilidad
 * es encapsular datos.
 * </p>
 *
 * <p>
 * Es mutable y está diseñada para ser utilizada como objeto
 * simple de transporte.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DTOBasePerson {

    /**
     * Dirección asociada a la persona.
     */
    protected String address;

    /**
     * Número telefónico de contacto.
     */
    protected long phone;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo automático.
     */
    public DTOBasePerson() {

    }

    /**
     * Constructor completo.
     *
     * @param address dirección de la persona
     * @param phone   número telefónico
     */
    public DTOBasePerson(String address, long phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

}
