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
 * @author Hector Acevedo
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(long resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
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

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

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
