package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de registrar predio.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTORegisterPropertyText {

    private final String title;
    private final String point;
    private final String northCord;
    private final String eastCord;
    private final String distance;
    private final String hillside;
    private final String registerBtn;
    private final String propertyInfo;
    private final String cadastralId;
    private final String area;
    private final String pointsInfo;
    private final String beneficiaryCode;
    private final String searchBeneficiary;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTORegisterPropertyText(Builder builder) {
        this.title = builder.title;
        this.point = builder.point;
        this.northCord = builder.northCord;
        this.eastCord = builder.eastCord;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.registerBtn = builder.registerBtn;
        this.propertyInfo = builder.propertyInfo;
        this.cadastralId = builder.cadastralId;
        this.area = builder.area;
        this.pointsInfo = builder.pointsInfo;
        this.beneficiaryCode = builder.beneficiaryCode;
        this.searchBeneficiary = builder.searchBeneficiary;
    }

    /** Obtiene el texto del título. @return texto del título */
    public String getTitle() {
        return title;
    }

    /** Obtiene el texto del punto. @return texto del punto */
    public String getPoint() {
        return point;
    }

    /** Obtiene el texto de la coordenada norte. @return texto de la coordenada norte */
    public String getNorthCord() {
        return northCord;
    }

    /** Obtiene el texto de la coordenada este. @return texto de la coordenada este */
    public String getEastCord() {
        return eastCord;
    }

    /** Obtiene el texto de la distancia. @return texto de la distancia */
    public String getDistance() {
        return distance;
    }

    /** Obtiene el texto del colindante. @return texto del colindante */
    public String getHillside() {
        return hillside;
    }

    /** Obtiene el texto del botón de registrar. @return texto del botón de registrar */
    public String getRegisterBtn() {
        return registerBtn;
    }

    /** Obtiene el texto de la información del predio. @return texto de la información del predio */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /** Obtiene el texto del identificador catastral. @return texto del identificador catastral */
    public String getCadastralId() {
        return cadastralId;
    }

    /** Obtiene el texto del área. @return texto del área */
    public String getArea() {
        return area;
    }

    /** Obtiene el texto de la información de puntos. @return texto de la información de puntos */
    public String getPointsInfo() {
        return pointsInfo;
    }

    /** Obtiene el texto del código del beneficiario. @return texto del código del beneficiario */
    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    /** Obtiene el texto de buscar beneficiario. @return texto de buscar beneficiario */
    public String getSearchBeneficiary() {
        return searchBeneficiary;
    }

    /**
     * Builder para la construcción de instancias de {@link DTORegisterPropertyText}.
     */
    public static class Builder {

        private String title;
        private String point;
        private String northCord;
        private String eastCord;
        private String distance;
        private String hillside;
        private String registerBtn;
        private String propertyInfo;
        private String cadastralId;
        private String area;
        private String pointsInfo;
        private String beneficiaryCode;
        private String searchBeneficiary;

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
         * Asigna el texto del punto.
         *
         * @param point texto del punto
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder point(String point) {
            this.point = point;
            return this;
        }

        /**
         * Asigna el texto de la coordenada norte.
         *
         * @param northCord texto de la coordenada norte
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder northCord(String northCord) {
            this.northCord = northCord;
            return this;
        }

        /**
         * Asigna el texto de la coordenada este.
         *
         * @param eastCord texto de la coordenada este
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder eastCord(String eastCord) {
            this.eastCord = eastCord;
            return this;
        }

        /**
         * Asigna el texto de la distancia.
         *
         * @param distance texto de la distancia
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder distance(String distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Asigna el texto del colindante.
         *
         * @param hillside texto del colindante
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

        /**
         * Asigna el texto del botón de registrar.
         *
         * @param registerBtn texto del botón de registrar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder registerBtn(String registerBtn) {
            this.registerBtn = registerBtn;
            return this;
        }

        /**
         * Asigna el texto de la información del predio.
         *
         * @param propertyInfo texto de la información del predio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

        /**
         * Asigna el texto del identificador catastral.
         *
         * @param cadastralId texto del identificador catastral
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder cadastralId(String cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

        /**
         * Asigna el texto del área.
         *
         * @param area texto del área
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder area(String area) {
            this.area = area;
            return this;
        }

        /**
         * Asigna el texto de la información de puntos.
         *
         * @param point texto de la información de puntos
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder pointsInfo(String point) {
            this.pointsInfo = pointsInfo;
            return this;
        }

        /**
         * Asigna el texto del código del beneficiario.
         *
         * @param beneficiaryCode texto del código del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        /**
         * Asigna el texto de buscar beneficiario.
         *
         * @param searchBeneficiary texto de buscar beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder searchBeneficiary(String searchBeneficiary) {
            this.searchBeneficiary = searchBeneficiary;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTORegisterPropertyText}.
         *
         * @return nueva instancia inmutable
         */
        public DTORegisterPropertyText build() {
            return new DTORegisterPropertyText(this);
        }

    }

}
