package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de modificar resolución.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOModifyResolutionText {

    private final String title;
    private final String code;
    private final String numResolution;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String modifyBtn;
    private final String executory;
    private final String notification;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOModifyResolutionText(Builder builder) {
        this.title = builder.title;
        this.code = builder.code;
        this.numResolution = builder.numResolution;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.modifyBtn = builder.modifyBtn;
        this.executory = builder.executory;
        this.notification = builder.notification;
    }

    /** Obtiene el texto del título. @return texto del título */
    public String getTitle() {
        return title;
    }

    /** Obtiene el texto del código. @return texto del código */
    public String getCode() {
        return code;
    }

    /** Obtiene el texto del número de resolución. @return texto del número de resolución */
    public String getNumResolution() {
        return numResolution;
    }

    /** Obtiene el texto del FMI. @return texto del FMI */
    public String getFmi() {
        return fmi;
    }

    /** Obtiene el texto del acta. @return texto del acta */
    public String getAct() {
        return act;
    }

    /** Obtiene el texto de la escritura pública. @return texto de la escritura pública */
    public String getPublicWriting() {
        return publicWriting;
    }

    /** Obtiene el texto de la notaría. @return texto de la notaría */
    public String getNotary() {
        return notary;
    }

    /** Obtiene el texto del botón de modificar. @return texto del botón de modificar */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /** Obtiene el texto de la ejecutoria. @return texto de la ejecutoria */
    public String getExecutory() {
        return executory;
    }

    /** Obtiene el texto de la notificación. @return texto de la notificación */
    public String getNotification() {
        return notification;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOModifyResolutionText}.
     */
    public static class Builder {

        private String title;
        private String code;
        private String numResolution;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String modifyBtn;
        private String executory;
        private String notification;

        /**
         * Asigna el texto del título.
         *
         * @param title texto del título
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Asigna el texto del código.
         *
         * @param code texto del código
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Asigna el texto del número de resolución.
         *
         * @param numResolution texto del número de resolución
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        /**
         * Asigna el texto del FMI.
         *
         * @param fmi texto del FMI
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        /**
         * Asigna el texto del acta.
         *
         * @param act texto del acta
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

        /**
         * Asigna el texto de la escritura pública.
         *
         * @param publicWriting texto de la escritura pública
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        /**
         * Asigna el texto de la notaría.
         *
         * @param notary texto de la notaría
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        /**
         * Asigna el texto del botón de modificar.
         *
         * @param modifyBtn texto del botón de modificar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

        /**
         * Asigna el texto de la ejecutoria.
         *
         * @param executory texto de la ejecutoria
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

        /**
         * Asigna el texto de la notificación.
         *
         * @param notification texto de la notificación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOModifyResolutionText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOModifyResolutionText build() {
            return new DTOModifyResolutionText(this);
        }
    }
}
