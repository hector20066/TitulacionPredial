package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de generación de resoluciones.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOGenerateResolutionText {

    private final String resumeTitle;
    private final String beneficiaryData;
    private final String names;
    private final String id;
    private final String address;
    private final String cadastralRef;
    private final String municipality;
    private final String propertyInfo;
    private final String point;
    private final String northCord;
    private final String eastCord;
    private final String distance;
    private final String hillside;
    private final String propertyCode;
    private final String area;
    private final String enterInfo;
    private final String numResolution;
    private final String notification;
    private final String executory;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String generateLabel;
    private final String generateBtn;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOGenerateResolutionText(Builder builder) {
        this.resumeTitle = builder.resumeTitle;
        this.beneficiaryData = builder.beneficiaryData;
        this.names = builder.names;
        this.id = builder.id;
        this.address = builder.address;
        this.cadastralRef = builder.cadastralRef;
        this.municipality = builder.municipality;
        this.propertyInfo = builder.propertyInfo;
        this.point = builder.point;
        this.northCord = builder.northCord;
        this.eastCord = builder.eastCord;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.propertyCode = builder.propertyCode;
        this.area = builder.area;
        this.enterInfo = builder.enterInfo;
        this.numResolution = builder.numResolution;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.generateLabel = builder.generateLabel;
        this.generateBtn = builder.generateBtn;
    }

    /**
     * Obtiene el texto de título del resumen.
     *
     * @return texto de título del resumen
     */
    public String getResumeTitle() {
        return resumeTitle;
    }

    /**
     * Obtiene el texto de datos del beneficiario.
     *
     * @return texto de datos del beneficiario
     */
    public String getBeneficiaryData() {
        return beneficiaryData;
    }

    /**
     * Obtiene el texto de nombres.
     *
     * @return texto de nombres
     */
    public String getNames() {
        return names;
    }

    /**
     * Obtiene el texto de identificación.
     *
     * @return texto de identificación
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el texto de dirección.
     *
     * @return texto de dirección
     */
    public String getAddress() {
        return address;
    }

    /**
     * Obtiene el texto de referencia catastral.
     *
     * @return texto de referencia catastral
     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**
     * Obtiene el texto de municipio.
     *
     * @return texto de municipio
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Obtiene el texto de información del predio.
     *
     * @return texto de información del predio
     */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /**
     * Obtiene el texto de punto.
     *
     * @return texto de punto
     */
    public String getPoint() {
        return point;
    }

    /**
     * Obtiene el texto de coordenada norte.
     *
     * @return texto de coordenada norte
     */
    public String getNorthCord() {
        return northCord;
    }

    /**
     * Obtiene el texto de coordenada este.
     *
     * @return texto de coordenada este
     */
    public String getEastCord() {
        return eastCord;
    }

    /**
     * Obtiene el texto de distancia.
     *
     * @return texto de distancia
     */
    public String getDistance() {
        return distance;
    }

    /**
     * Obtiene el texto de ladera.
     *
     * @return texto de ladera
     */
    public String getHillside() {
        return hillside;
    }

    /**
     * Obtiene el texto de código del predio.
     *
     * @return texto de código del predio
     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**
     * Obtiene el texto de área.
     *
     * @return texto de área
     */
    public String getArea() {
        return area;
    }

    /**
     * Obtiene el texto de ingresar información.
     *
     * @return texto de ingresar información
     */
    public String getEnterInfo() {
        return enterInfo;
    }

    /**
     * Obtiene el texto de número de resolución.
     *
     * @return texto de número de resolución
     */
    public String getNumResolution() {
        return numResolution;
    }

    /**
     * Obtiene el texto de notificación.
     *
     * @return texto de notificación
     */
    public String getNotification() {
        return notification;
    }

    /**
     * Obtiene el texto de ejecutoria.
     *
     * @return texto de ejecutoria
     */
    public String getExecutory() {
        return executory;
    }

    /**
     * Obtiene el texto de FMI.
     *
     * @return texto de FMI
     */
    public String getFmi() {
        return fmi;
    }

    /**
     * Obtiene el texto de acta.
     *
     * @return texto de acta
     */
    public String getAct() {
        return act;
    }

    /**
     * Obtiene el texto de escritura pública.
     *
     * @return texto de escritura pública
     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**
     * Obtiene el texto de notaría.
     *
     * @return texto de notaría
     */
    public String getNotary() {
        return notary;
    }

    /**
     * Obtiene el texto de etiqueta de generar.
     *
     * @return texto de etiqueta de generar
     */
    public String getGenerateLabel() {
        return generateLabel;
    }

    /**
     * Obtiene el texto de botón de generar.
     *
     * @return texto de botón de generar
     */
    public String getGenerateBtn() {
        return generateBtn;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOGenerateResolutionText}.
     */
    public static class Builder {

        private String resumeTitle;
        private String beneficiaryData;
        private String names;
        private String id;
        private String address;
        private String cadastralRef;
        private String municipality;
        private String propertyInfo;
        private String point;
        private String northCord;
        private String eastCord;
        private String distance;
        private String hillside;
        private String propertyCode;
        private String area;
        private String enterInfo;
        private String numResolution;
        private String notification;
        private String executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String generateLabel;
        private String generateBtn;

        /**
         * Asigna el texto de título del resumen.
         *
         * @param resumeTitle texto de título del resumen
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder resumeTitle(String resumeTitle) {
            this.resumeTitle = resumeTitle;
            return this;
        }

        /**
         * Asigna el texto de datos del beneficiario.
         *
         * @param beneficiaryData texto de datos del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryData(String beneficiaryData) {
            this.beneficiaryData = beneficiaryData;
            return this;
        }

        /**
         * Asigna el texto de nombres.
         *
         * @param names texto de nombres
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder names(String names) {
            this.names = names;
            return this;
        }

        /**
         * Asigna el texto de identificación.
         *
         * @param id texto de identificación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Asigna el texto de dirección.
         *
         * @param address texto de dirección
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Asigna el texto de referencia catastral.
         *
         * @param cadastralRef texto de referencia catastral
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        /**
         * Asigna el texto de municipio.
         *
         * @param municipality texto de municipio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        /**
         * Asigna el texto de información del predio.
         *
         * @param propertyInfo texto de información del predio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

        /**
         * Asigna el texto de punto.
         *
         * @param point texto de punto
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder point(String point) {
            this.point = point;
            return this;
        }

        /**
         * Asigna el texto de coordenada norte.
         *
         * @param northCord texto de coordenada norte
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder northCord(String northCord) {
            this.northCord = northCord;
            return this;
        }

        /**
         * Asigna el texto de coordenada este.
         *
         * @param eastCord texto de coordenada este
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder eastCord(String eastCord) {
            this.eastCord = eastCord;
            return this;
        }

        /**
         * Asigna el texto de distancia.
         *
         * @param distance texto de distancia
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder distance(String distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Asigna el texto de ladera.
         *
         * @param hillside texto de ladera
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

        /**
         * Asigna el texto de código del predio.
         *
         * @param propertyCode texto de código del predio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder propertyCode(String propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        /**
         * Asigna el texto de área.
         *
         * @param area texto de área
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder area(String area) {
            this.area = area;
            return this;
        }

        /**
         * Asigna el texto de ingresar información.
         *
         * @param enterInfo texto de ingresar información
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder enterInfo(String enterInfo) {
            this.enterInfo = enterInfo;
            return this;
        }

        /**
         * Asigna el texto de número de resolución.
         *
         * @param numResolution texto de número de resolución
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        /**
         * Asigna el texto de notificación.
         *
         * @param notification texto de notificación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

        /**
         * Asigna el texto de ejecutoria.
         *
         * @param executory texto de ejecutoria
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

        /**
         * Asigna el texto de FMI.
         *
         * @param fmi texto de FMI
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        /**
         * Asigna el texto de acta.
         *
         * @param act texto de acta
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

        /**
         * Asigna el texto de escritura pública.
         *
         * @param publicWriting texto de escritura pública
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        /**
         * Asigna el texto de notaría.
         *
         * @param notary texto de notaría
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        /**
         * Asigna el texto de etiqueta de generar.
         *
         * @param generateLabel texto de etiqueta de generar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder generateLabel(String generateLabel) {
            this.generateLabel = generateLabel;
            return this;
        }

        /**
         * Asigna el texto de botón de generar.
         *
         * @param generateBtn texto de botón de generar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOGenerateResolutionText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOGenerateResolutionText build() {
            return new DTOGenerateResolutionText(this);
        }

    }

}
