package com.hector.titulacionpredial.model.entities;

import java.time.LocalDate;

/**
 * Entidad de dominio que representa una Resolución administrativa
 * dentro del sistema de Titulación Predial.
 *
 * <p>
 * Una resolución formaliza un acto jurídico o trámite aplicado
 * a un {@link Property}, pudiendo involucrar uno o más
 * {@link Beneficiary}.
 * </p>
 *
 * <p>
 * Esta entidad permite mantener trazabilidad e historial
 * de los procesos realizados sobre un predio.
 * </p>
 *
 * <p>
 * Características principales:
 * </p>
 * <ul>
 *     <li>Posee identidad propia mediante el atributo {@code code}.</li>
 *     <li>Se asocia a un {@link Property} (relación muchos-a-uno).</li>
 *     <li>Puede asociarse a un {@link Beneficiary} específico.</li>
 *     <li>Contiene fechas clave como notificación y ejecutoria.</li>
 *     <li>Forma parte del modelo persistente del sistema.</li>
 *     <li>Soporta construcción mediante el patrón {@link Builder}.</li>
 * </ul>
 *
 * <p>
 * Su ciclo de vida es independiente del predio, pero
 * conceptualmente depende de la existencia del mismo.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Resolution {

    private int code;
    private long resolutionNumber;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;
    private Property property;
    private Beneficiary beneficiary;

    /**
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos de reflexión.
     */
    public Resolution() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia del constructor paso a paso
     */
    public Resolution(Builder builder) {
        this.code = builder.code;
        this.resolutionNumber = builder.resolutionNumber;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.property = builder.property;
        this.beneficiary = builder.beneficiary;
    }

    /**
     * Obtiene el código único de la resolución.
     *
     * @return código único
     */
    public int getCode() {
        return code;
    }

    /**
     * Establece el código único de la resolución.
     *
     * @param code código único
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtiene el número de la resolución.
     *
     * @return número de la resolución
     */
    public long getResolutionNumber() {
        return resolutionNumber;
    }

    /**
     * Establece el número de la resolución.
     *
     * @param resolutionNumber número de la resolución
     */
    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    /**
     * Obtiene la fecha de notificación de la resolución.
     *
     * @return fecha de notificación
     */
    public LocalDate getNotification() {
        return notification;
    }

    /**
     * Establece la fecha de notificación de la resolución.
     *
     * @param notification fecha de notificación
     */
    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    /**
     * Obtiene la fecha de ejecutoria de la resolución.
     *
     * @return fecha de ejecutoria
     */
    public LocalDate getExecutory() {
        return executory;
    }

    /**
     * Establece la fecha de ejecutoria de la resolución.
     *
     * @param executory fecha de ejecutoria
     */
    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    /**
     * Obtiene el folio de matrícula inmobiliaria.
     *
     * @return folio de matrícula inmobiliaria
     */
    public String getFmi() {
        return fmi;
    }

    /**
     * Establece el folio de matrícula inmobiliaria.
     *
     * @param fmi folio de matrícula inmobiliaria
     */
    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    /**
     * Obtiene la descripción del acta asociada.
     *
     * @return descripción del acta
     */
    public String getAct() {
        return act;
    }

    /**
     * Establece la descripción del acta asociada.
     *
     * @param act descripción del acta
     */
    public void setAct(String act) {
        this.act = act;
    }

    /**
     * Obtiene la escritura pública de la resolución.
     *
     * @return escritura pública
     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**
     * Establece la escritura pública de la resolución.
     *
     * @param publicWriting escritura pública
     */
    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    /**
     * Obtiene el nombre de la notaría asociada.
     *
     * @return nombre de la notaría
     */
    public String getNotary() {
        return notary;
    }

    /**
     * Establece el nombre de la notaría asociada.
     *
     * @param notary nombre de la notaría
     */
    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**
     * Obtiene el predio asociado a la resolución.
     *
     * @return predio vinculado
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Establece el predio asociado a la resolución.
     *
     * @param property predio vinculado
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Obtiene el beneficiario asociado a la resolución.
     *
     * @return beneficiario vinculado
     */
    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    /**
     * Establece el beneficiario asociado a la resolución.
     *
     * @param beneficiary beneficiario vinculado
     */
    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    /**
     * Representación textual de la entidad.
     *
     * @return descripción formateada de los atributos principales
     */
    @Override
    public String toString() {
        return "Code= " + code +
                "\nResolution Number= " + resolutionNumber +
                "\nNotification= " + notification +
                "\nExecutory= " + executory +
                "\nFMI= " + fmi +
                "\nAct= " + act +
                "\nPublicWriting= " + publicWriting +
                "\nNotary= " + notary +
                "\nProperty= " + property +
                "\nBeneficiary= " + beneficiary;
    }

    /**
     * Builder para la construcción controlada de instancias de {@link Resolution}.
     *
     * <p>
     * Permite configurar de forma fluida los atributos del predio antes
     * de su creación definitiva mediante {@link #build()}.
     * </p>
     *
     * <p>
     * No realiza validaciones automáticas; dichas reglas deben
     * garantizarse en la capa de servicio o agregarse explícitamente.
     * </p>
     */
    public static class Builder {

        private int code;
        private long resolutionNumber;
        private LocalDate notification;
        private LocalDate executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private Property property;
        private Beneficiary beneficiary;

        /**
         * Establece el código de la resolución.
         *
         * @param code código único
         * @return builder actual
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Establece el número de resolución.
         *
         * @param resolutionNumber número de la resolución
         * @return builder actual
         */
        public Builder resolutionNumber(long resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
            return this;
        }

        /**
         * Establece la fecha de notificación.
         *
         * @param notification fecha de notificación
         * @return builder actual
         */
        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

        /**
         * Establece la fecha de ejecutoria.
         *
         * @param executory fecha de ejecutoria
         * @return builder actual
         */
        public Builder executory(LocalDate executory) {
            this.executory = executory;
            return this;
        }

        /**
         * Establece el folio de matrícula inmobiliaria.
         *
         * @param fmi folio de matrícula inmobiliaria
         * @return builder actual
         */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        /**
         * Establece el acta.
         *
         * @param act descripción del acta
         * @return builder actual
         */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

        /**
         * Establece la escritura pública.
         *
         * @param publicWriting escritura pública
         * @return builder actual
         */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        /**
         * Establece la notaría.
         *
         * @param notary nombre de la notaría
         * @return builder actual
         */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        /**
         * Establece el predio asociado.
         *
         * @param property predio vinculado
         * @return builder actual
         */
        public Builder property(Property property) {
            this.property = property;
            return this;
        }

        /**
         * Establece el beneficiario asociado.
         *
         * @param beneficiary beneficiario vinculado
         * @return builder actual
         */
        public Builder beneficiary(Beneficiary beneficiary) {
            this.beneficiary = beneficiary;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link Resolution}.
         *
         * @return nueva resolución construida
         */
        public Resolution build() {
            return new Resolution(this);
        }

    }

}
