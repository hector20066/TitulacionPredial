package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de ver resoluciones.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOSeeResolutionsText {

    private final String code;
    private final String number;
    private final String notification;
    private final String executory;
    private final String notary;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String title;
    private final String search;
    private final String modifyBtn;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOSeeResolutionsText(Builder builder) {
        this.code = builder.code;
        this.number = builder.number;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.notary = builder.notary;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.title = builder.title;
        this.search = builder.search;
        this.modifyBtn = builder.modifyBtn;
    }

    /** Obtiene el texto del código. @return texto del código */
    public String getCode() {
        return code;
    }

    /** Obtiene el texto del número. @return texto del número */
    public String getNumber() {
        return number;
    }

    /** Obtiene el texto de la notificación. @return texto de la notificación */
    public String getNotification() {
        return notification;
    }

    /** Obtiene el texto de la ejecutoria. @return texto de la ejecutoria */
    public String getExecutory() {
        return executory;
    }

    /** Obtiene el texto de la notaría. @return texto de la notaría */
    public String getNotary() {
        return notary;
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

    /** Obtiene el texto del título. @return texto del título */
    public String getTitle() {
        return title;
    }

    /** Obtiene el texto de la búsqueda. @return texto de la búsqueda */
    public String getSearch() {
        return search;
    }

    /** Obtiene el texto del botón de modificar. @return texto del botón de modificar */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOSeeResolutionsText}.
     */
    public static class Builder {

        private String code;
        private String number;
        private String notification;
        private String executory;
        private String notary;
        private String fmi;
        private String act;
        private String publicWriting;
        private String title;
        private String search;
        private String modifyBtn;

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
         * Asigna el texto del número.
         *
         * @param number texto del número
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder number(String number) {
            this.number = number;
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
         * Asigna el texto de la búsqueda.
         *
         * @param search texto de la búsqueda
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder search(String search) {
            this.search = search;
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
         * Construye una nueva instancia de {@link DTOSeeResolutionsText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOSeeResolutionsText build() {
            return new DTOSeeResolutionsText(this);
        }

    }

}
