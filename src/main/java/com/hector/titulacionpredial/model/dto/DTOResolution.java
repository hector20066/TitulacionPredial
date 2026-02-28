package com.hector.titulacionpredial.model.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) que representa la información
 * de una resolución para operaciones de entrada o salida
 * del sistema.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentación y
 * la capa de persistencia, evitando exponer directamente la entidad
 * {@code Resolution}.
 * </p>
 *
 * <p>
 * Contiene la información necesaria para una resolución, como el número
 * de la resolución y la información que esta contendrá.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DTOResolution {

    /**
     * Número único de la resolución.
     */
    protected long resolutionNumber;

    /**
     * Fecha de la ejecutoria.
     */
    protected LocalDate executory;

    /**
     * Descripción del proceso.
     */
    protected String act;

    /**
     * Escritura pública.
     */
    protected String publicWriting;

    /**
     * Fecha en la que se genera la resolución.
     */
    protected LocalDate notification;

    /**
     * Folio de Matrícula Inmobiliaria.
     */
    protected String fmi;

    /**
     * Notaría donde se ejecuta la resolución.
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
         * Establece el número de la resolución.
         *
         * @param resolutionNumber número de la resolución
         * @return builder actual
         */
        public T resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return self();
        }

        /**
         * Establece la ejecutoria.
         *
         * @param executory fecha de la ejecutoria
         * @return builder actual
         */
        public T executory(LocalDate executory) {
            this.executory = executory;
            return self();
        }

        /**
         * Establece el acto.
         *
         * @param act acto de la ejecutoria
         * @return builder actual
         */
        public T act(String act) {
            this.act = act;
            return self();
        }

        /**
         * Establece la escritura pública.
         *
         * @param publicWriting escritura pública
         * @return builder actual
         */
        public T publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return self();
        }

        /**
         * Establece la fecha de notificación.
         *
         * @param notification fecha de notificación
         * @return builder actual
         */
        public T notification(LocalDate notification) {
            this.notification = notification;
            return self();
        }

        /**
         * Establece el Folio de Matrícula Inmobiliaria.
         *
         * @param fmi Folio de Matrícula Inmobiliaria
         * @return builder actual
         */
        public T fmi(String fmi) {
            this.fmi = fmi;
            return self();
        }

        /**
         * Establece la notaría.
         *
         * @param notary notaría
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
