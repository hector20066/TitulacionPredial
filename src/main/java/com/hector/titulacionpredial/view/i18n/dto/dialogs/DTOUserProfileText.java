package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 * DTO que encapsula los textos internacionalizados para el diálogo de perfil de usuario.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOUserProfileText {

    private final String title;
    private final String code;
    private final String id;
    private final String phone;
    private final String address;
    private final String department;
    private final String municipality;
    private final String neighborhood;
    private final String residenceData;
    private final String expeditionLocation;
    private final String maritalStatus;
    private final String cadastralRef;
    private final String crossing;
    private final String affectation;
    private final String publication;
    private final String spouseData;
    private final String spouseName;
    private final String spouseId;
    private final String spouseExpeditionLocation;
    private final String spouseAddress;
    private final String spousePhone;
    private final String notApply;
    private final String btnExit;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOUserProfileText(Builder builder) {
        this.title = builder.title;
        this.code = builder.code;
        this.id = builder.id;
        this.phone = builder.phone;
        this.address = builder.address;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.residenceData = builder.residenceData;
        this.expeditionLocation = builder.expeditionLocation;
        this.maritalStatus = builder.maritalStatus;
        this.cadastralRef = builder.cadastralRef;
        this.crossing = builder.crossing;
        this.affectation = builder.affectation;
        this.publication = builder.publication;
        this.spouseData = builder.spouseData;
        this.spouseName = builder.spouseName;
        this.spouseId = builder.spouseId;
        this.spouseExpeditionLocation = builder.spouseExpeditionLocation;
        this.spouseAddress = builder.spouseAddress;
        this.spousePhone = builder.spousePhone;
        this.notApply = builder.notApply;
        this.btnExit = builder.btnExit;
    }

    /**
     * Obtiene el texto de título.
     *
     * @return texto de título
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el texto de código.
     *
     * @return texto de código
     */
    public String getCode() {
        return code;
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
     * Obtiene el texto de teléfono.
     *
     * @return texto de teléfono
     */
    public String getPhone() {
        return phone;
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
     * Obtiene el texto de departamento.
     *
     * @return texto de departamento
     */
    public String getDepartment() {
        return department;
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
     * Obtiene el texto de barrio.
     *
     * @return texto de barrio
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Obtiene el texto de datos de residencia.
     *
     * @return texto de datos de residencia
     */
    public String getResidenceData() {
        return residenceData;
    }

    /**
     * Obtiene el texto de lugar de expedición.
     *
     * @return texto de lugar de expedición
     */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /**
     * Obtiene el texto de estado civil.
     *
     * @return texto de estado civil
     */
    public String getMaritalStatus() {
        return maritalStatus;
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
     * Obtiene el texto de cruce.
     *
     * @return texto de cruce
     */
    public String getCrossing() {
        return crossing;
    }

    /**
     * Obtiene el texto de afectación.
     *
     * @return texto de afectación
     */
    public String getAffectation() {
        return affectation;
    }

    /**
     * Obtiene el texto de publicación.
     *
     * @return texto de publicación
     */
    public String getPublication() {
        return publication;
    }

    /**
     * Obtiene el texto de datos del cónyuge.
     *
     * @return texto de datos del cónyuge
     */
    public String getSpouseData() {
        return spouseData;
    }

    /**
     * Obtiene el texto de nombre del cónyuge.
     *
     * @return texto de nombre del cónyuge
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * Obtiene el texto de identificación del cónyuge.
     *
     * @return texto de identificación del cónyuge
     */
    public String getSpouseId() {
        return spouseId;
    }

    /**
     * Obtiene el texto de lugar de expedición del cónyuge.
     *
     * @return texto de lugar de expedición del cónyuge
     */
    public String getSpouseExpeditionLocation() {
        return spouseExpeditionLocation;
    }

    /**
     * Obtiene el texto de dirección del cónyuge.
     *
     * @return texto de dirección del cónyuge
     */
    public String getSpouseAddress() {
        return spouseAddress;
    }

    /**
     * Obtiene el texto de teléfono del cónyuge.
     *
     * @return texto de teléfono del cónyuge
     */
    public String getSpousePhone() {
        return spousePhone;
    }

    /**
     * Obtiene el texto de no aplica.
     *
     * @return texto de no aplica
     */
    public String getNotApply() {
        return notApply;
    }

    /**
     * Obtiene el texto de botón salir.
     *
     * @return texto de botón salir
     */
    public String getBtnExit() {
        return btnExit;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOUserProfileText}.
     */
    public static class Builder {

        private String title;
        private String code;
        private String id;
        private String phone;
        private String address;
        private String department;
        private String municipality;
        private String neighborhood;
        private String residenceData;
        private String expeditionLocation;
        private String maritalStatus;
        private String cadastralRef;
        private String crossing;
        private String affectation;
        private String publication;
        private String spouseData;
        private String spouseName;
        private String spouseId;
        private String spouseExpeditionLocation;
        private String spouseAddress;
        private String spousePhone;
        private String notApply;
        private String btnExit;

        /**
         * Asigna el texto de título.
         *
         * @param title texto de título
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Asigna el texto de código.
         *
         * @param code texto de código
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder code(String code) {
            this.code = code;
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
         * Asigna el texto de teléfono.
         *
         * @param phone texto de teléfono
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder phone(String phone) {
            this.phone = phone;
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
         * Asigna el texto de departamento.
         *
         * @param department texto de departamento
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder department(String department) {
            this.department = department;
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
         * Asigna el texto de barrio.
         *
         * @param neighborhood texto de barrio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        /**
         * Asigna el texto de datos de residencia.
         *
         * @param residenceData texto de datos de residencia
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder residenceData(String residenceData) {
            this.residenceData = residenceData;
            return this;
        }

        /**
         * Asigna el texto de lugar de expedición.
         *
         * @param expeditionLocation texto de lugar de expedición
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        /**
         * Asigna el texto de estado civil.
         *
         * @param maritalStatus texto de estado civil
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
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
         * Asigna el texto de cruce.
         *
         * @param crossing texto de cruce
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        /**
         * Asigna el texto de afectación.
         *
         * @param affectation texto de afectación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        /**
         * Asigna el texto de publicación.
         *
         * @param publication texto de publicación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        /**
         * Asigna el texto de datos del cónyuge.
         *
         * @param spouseData texto de datos del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseData(String spouseData) {
            this.spouseData = spouseData;
            return this;
        }

        /**
         * Asigna el texto de nombre del cónyuge.
         *
         * @param spouseName texto de nombre del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseName(String spouseName) {
            this.spouseName = spouseName;
            return this;
        }

        /**
         * Asigna el texto de identificación del cónyuge.
         *
         * @param spouseId texto de identificación del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseId(String spouseId) {
            this.spouseId = spouseId;
            return this;
        }

        /**
         * Asigna el texto de lugar de expedición del cónyuge.
         *
         * @param spouseExpeditionLocation texto de lugar de expedición del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseExpeditionLocation(String spouseExpeditionLocation) {
            this.spouseExpeditionLocation = spouseExpeditionLocation;
            return this;
        }

        /**
         * Asigna el texto de dirección del cónyuge.
         *
         * @param spouseAddress texto de dirección del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spouseAddress(String spouseAddress) {
            this.spouseAddress = spouseAddress;
            return this;
        }

        /**
         * Asigna el texto de teléfono del cónyuge.
         *
         * @param spousePhone texto de teléfono del cónyuge
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder spousePhone(String spousePhone) {
            this.spousePhone = spousePhone;
            return this;
        }

        /**
         * Asigna el texto de no aplica.
         *
         * @param notApply texto de no aplica
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder notApply(String notApply) {
            this.notApply = notApply;
            return this;
        }

        /**
         * Asigna el texto de botón salir.
         *
         * @param btnExit texto de botón salir
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder btnExit(String btnExit) {
            this.btnExit = btnExit;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOUserProfileText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOUserProfileText build() {
            return new DTOUserProfileText(this);
        }

    }

}
