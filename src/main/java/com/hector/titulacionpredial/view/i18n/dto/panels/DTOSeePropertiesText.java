package com.hector.titulacionpredial.view.i18n.dto.panels;


/**
 * DTO que encapsula los textos internacionalizados para el panel de ver predios.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOSeePropertiesText {

    private final String code;
    private final String name;
    private final String id;
    private final String numResolution;
    private final String notify;
    private final String executory;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String cadastralRef;
    private final String address;
    private final String municipality;
    private final String search;
    private final String properties;
    private final String generateBtn;
    private final String deleteBtn;
    private final String exportExcelBtn;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOSeePropertiesText(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.id = builder.id;
        this.numResolution = builder.numResolution;
        this.notify = builder.notify;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.cadastralRef = builder.cadastralRef;
        this.address = builder.address;
        this.municipality = builder.municipality;
        this.search = builder.search;
        this.properties = builder.properties;
        this.generateBtn = builder.generateBtn;
        this.deleteBtn = builder.deleteBtn;
        this.exportExcelBtn = builder.exportExcelBtn;
    }

    /** Obtiene el texto del código. @return texto del código */
    public String getCode() {
        return code;
    }

    /** Obtiene el texto del nombre. @return texto del nombre */
    public String getName() {
        return name;
    }

    /** Obtiene el texto de la identificación. @return texto de la identificación */
    public String getId() {
        return id;
    }

    /** Obtiene el texto del número de resolución. @return texto del número de resolución */
    public String getNumResolution() {
        return numResolution;
    }

    /** Obtiene el texto de la notificación. @return texto de la notificación */
    public String getNotify() {
        return notify;
    }

    /** Obtiene el texto de la ejecutoria. @return texto de la ejecutoria */
    public String getExecutory() {
        return executory;
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

    /** Obtiene el texto de la referencia catastral. @return texto de la referencia catastral */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /** Obtiene el texto de la dirección. @return texto de la dirección */
    public String getAddress() {
        return address;
    }

    /** Obtiene el texto del municipio. @return texto del municipio */
    public String getMunicipality() {
        return municipality;
    }

    /** Obtiene el texto de la búsqueda. @return texto de la búsqueda */
    public String getSearch() {
        return search;
    }

    /** Obtiene el texto de los predios. @return texto de los predios */
    public String getProperties() {
        return properties;
    }

    /** Obtiene el texto del botón de generar. @return texto del botón de generar */
    public String getGenerateBtn() {
        return generateBtn;
    }

    /** Obtiene el texto del botón de eliminar. @return texto del botón de eliminar */
    public String getDeleteBtn() {
        return deleteBtn;
    }

    /** Obtiene el texto del botón de exportar a Excel. @return texto del botón de exportar a Excel */
    public String getExportExcelBtn() {
        return exportExcelBtn;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOSeePropertiesText}.
     */
    public static class Builder {

        private String code;
        private String name;
        private String id;
        private String numResolution;
        private String notify;
        private String executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String cadastralRef;
        private String address;
        private String municipality;
        private String search;
        private String properties;
        private String generateBtn;
        private String deleteBtn;
        private String exportExcelBtn;

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
         * Asigna el texto del nombre.
         *
         * @param name texto del nombre
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Asigna el texto de la identificación.
         *
         * @param id texto de la identificación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder id(String id) {
            this.id = id;
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
         * Asigna el texto de la notificación.
         *
         * @param notify texto de la notificación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notify(String notify) {
            this.notify = notify;
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
         * Asigna el texto de la referencia catastral.
         *
         * @param cadastralRef texto de la referencia catastral
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        /**
         * Asigna el texto de la dirección.
         *
         * @param address texto de la dirección
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Asigna el texto del municipio.
         *
         * @param municipality texto del municipio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
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
         * Asigna el texto de los predios.
         *
         * @param properties texto de los predios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

        /**
         * Asigna el texto del botón de generar.
         *
         * @param generateBtn texto del botón de generar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
            return this;
        }

        /**
         * Asigna el texto del botón de eliminar.
         *
         * @param deleteBtn texto del botón de eliminar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder deleteBtn(String deleteBtn) {
            this.deleteBtn = deleteBtn;
            return this;
        }

        /**
         * Asigna el texto del botón de exportar a Excel.
         *
         * @param exportExcelBtn texto del botón de exportar a Excel
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder exportExcelBtn(String exportExcelBtn) {
            this.exportExcelBtn = exportExcelBtn;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOSeePropertiesText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOSeePropertiesText build() {
            return new DTOSeePropertiesText(this);
        }

    }

}
