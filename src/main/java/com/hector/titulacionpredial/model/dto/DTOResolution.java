package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) que representa la informacion
 * de una resolucion para operaciones de entrada o salida
 * del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentacion y
 * la capa de persistencia, evitando exponer directamente la entidad
 * {@code Resolution}.
 * </p>
 *
 * <p>
 * Contiene la informacion necesaria para una resolución, como el numero
 * de la resolución y la informacion que esta contendrá.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * @author hectoracevedo
 * @since 1.0
 */
public class DTOResolution {

    /**
     * Numero unico de la resolucion
     */
    protected long resolutionNumber;

    /**
     * Fecha de la ejecutoria
     */
    protected LocalDate executory;

    /**
     * Descripcion del proceso
     */
    protected String act;

    /**
     * Escritura publica
     */
    protected String publicWriting;

    /**
     * Fecha en la que se genera la resolucion.
     */
    protected LocalDate notification;

    /**
     * Folio de Matricula Inmobiliaria
     */
    protected String fmi;

    /**
     * Notaria donde se ejecuta la resolucion
     */
    protected String notary;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo automático.
     */
    public DTOResolution() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOResolution(Builder<?> builder) {
        this.resolutionNumber = builder.resolutionNumber;
        this.executory = builder.executory;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notification = builder.notification;
        this.fmi = builder.fmi;
        this.notary = builder.notary;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**
     * Builder genérico para la construcción fluida de instancias
     * de {@link DTOResolution}.
     *
     * <p>
     * Permite configurar los atributos antes de invocar
     * {@link #build()}.
     * </p>
     *
     * @param <T> tipo concreto del builder
     */
    public static class Builder<T extends Builder<T>> {

        private long resolutionNumber;
        private LocalDate executory;
        private String act;
        private String publicWriting;
        private LocalDate notification;
        private String fmi;
        private String notary;

        /**
         * Devuelve la instancia concreta del builder.
         *
         * @return instancia tipada del builder
         */
        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        /**
         * Establecer el número de la resolución.
         *
         * @param resolutionNumber numero de la resolución
         * @return builder actual
         */
        public T resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return self();
        }

        /**
         * Establecer la ejecutoria
         *
         * @param executory fecha de la ejecutoria
         * @return builder actual
         */
        public T executory(LocalDate executory) {
            this.executory = executory;
            return self();
        }

        /**
         * Establecer el acto
         *
         * @param act acto de la ejecutoria
         * @return builder actual
         */
        public T act(String act) {
            this.act = act;
            return self();
        }

        /**
         * Establecer la escritura pública
         *
         * @param publicWriting escritura publica
         * @return builder actual
         */
        public T publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return self();
        }

        /**
         * Establecer fecha de notificacion
         *
         * @param notification fecha de notificacion
         * @return builder actual
         */
        public T notification(LocalDate notification) {
            this.notification = notification;
            return self();
        }

        /**
         * Establecer Folio de Matrícula Inmobiliaria
         *
         * @param fmi Folio de Matrícula Inmobiliaria
         * @return builder actual
         */
        public T fmi(String fmi) {
            this.fmi = fmi;
            return self();
        }

        /**
         * Establecer notaria
         *
         * @param notary notaria
         * @return builder actual
         */
        public T notary(String notary) {
            this.notary = notary;
            return self();
        }

        /**
         * Construye una nueva instancia de {@link DTOResolution}.
         *
         * @return nuevo DTO configurado
         */
        public DTOResolution build() {
            return new DTOResolution(this);
        }

    }

}
