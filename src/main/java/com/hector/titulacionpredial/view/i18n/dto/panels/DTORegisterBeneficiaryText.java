package com.hector.titulacionpredial.view.i18n.dto.panels;


/**
 * DTO que encapsula los textos internacionalizados para el panel de registrar beneficiario.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTORegisterBeneficiaryText {

    private final String modifyTitle;
    private final String modifyBtn;
    private final String addTitle;
    private final String addBtn;
    private final String beneficiaryInfo;
    private final String name;
    private final String phone;
    private final String lastName;
    private final String id;
    private final String maritalStatus;
    private final String residenceData;
    private final String department;
    private final String municipality;
    private final String neighborhood;
    private final String address;
    private final String cadastralRef;
    private final String crossing;
    private final String affectation;
    private final String expeditionLocation;
    private final String publication;
    private final String affected;
    private final String code;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTORegisterBeneficiaryText(Builder builder) {
        this.modifyTitle = builder.modifyTitle;
        this.modifyBtn = builder.modifyBtn;
        this.addTitle = builder.addTitle;
        this.addBtn = builder.addBtn;
        this.beneficiaryInfo = builder.beneficiaryInfo;
        this.name = builder.name;
        this.phone = builder.phone;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.maritalStatus = builder.maritalStatus;
        this.residenceData = builder.residenceData;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.address = builder.address;
        this.cadastralRef = builder.cadastralRef;
        this.crossing = builder.crossing;
        this.affectation = builder.affectation;
        this.expeditionLocation = builder.expeditionLocation;
        this.publication = builder.publication;
        this.affected = builder.affected;
        this.code = builder.code;
    }

    /** Obtiene el texto del título de modificar. @return texto del título de modificar */
    public String getModifyTitle() {
        return modifyTitle;
    }

    /** Obtiene el texto del botón de modificar. @return texto del botón de modificar */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /** Obtiene el texto del título de agregar. @return texto del título de agregar */
    public String getAddTitle() {
        return addTitle;
    }

    /** Obtiene el texto del botón de agregar. @return texto del botón de agregar */
    public String getAddBtn() {
        return addBtn;
    }

    /** Obtiene el texto de la información del beneficiario. @return texto de la información del beneficiario */
    public String getBeneficiaryInfo() {
        return beneficiaryInfo;
    }

    /** Obtiene el texto del nombre. @return texto del nombre */
    public String getName() {
        return name;
    }

    /** Obtiene el texto del teléfono. @return texto del teléfono */
    public String getPhone() {
        return phone;
    }

    /** Obtiene el texto del apellido. @return texto del apellido */
    public String getLastName() {
        return lastName;
    }

    /** Obtiene el texto de la identificación. @return texto de la identificación */
    public String getId() {
        return id;
    }

    /** Obtiene el texto del estado civil. @return texto del estado civil */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /** Obtiene el texto de los datos de residencia. @return texto de los datos de residencia */
    public String getResidenceData() {
        return residenceData;
    }

    /** Obtiene el texto del departamento. @return texto del departamento */
    public String getDepartment() {
        return department;
    }

    /** Obtiene el texto del municipio. @return texto del municipio */
    public String getMunicipality() {
        return municipality;
    }

    /** Obtiene el texto del barrio. @return texto del barrio */
    public String getNeighborhood() {
        return neighborhood;
    }

    /** Obtiene el texto de la dirección. @return texto de la dirección */
    public String getAddress() {
        return address;
    }

    /** Obtiene el texto de la referencia catastral. @return texto de la referencia catastral */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /** Obtiene el texto del cruce. @return texto del cruce */
    public String getCrossing() {
        return crossing;
    }

    /** Obtiene el texto de la afectación. @return texto de la afectación */
    public String getAffectation() {
        return affectation;
    }

    /** Obtiene el texto del lugar de expedición. @return texto del lugar de expedición */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /** Obtiene el texto de la publicación. @return texto de la publicación */
    public String getPublication() {
        return publication;
    }

    /** Obtiene el texto del afectado. @return texto del afectado */
    public String getAffected() {
        return affected;
    }

    /** Obtiene el texto del código. @return texto del código */
    public String getCode() {
        return code;
    }

    /**
     * Builder para la construcción de instancias de {@link DTORegisterBeneficiaryText}.
     */
    public static class Builder {

        private String modifyTitle;
        private String modifyBtn;
        private String addTitle;
        private String addBtn;
        private String beneficiaryInfo;
        private String name;
        private String phone;
        private String lastName;
        private String id;
        private String maritalStatus;
        private String residenceData;
        private String department;
        private String municipality;
        private String neighborhood;
        private String address;
        private String cadastralRef;
        private String crossing;
        private String affectation;
        private String expeditionLocation;
        private String publication;
        private String affected;
        private String code;

        /**
         * Asigna el texto del título de modificar.
         *
         * @param modifyTitle texto del título de modificar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder modifyTitle(String modifyTitle) {
            this.modifyTitle = modifyTitle;
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
         * Asigna el texto del título de agregar.
         *
         * @param addTitle texto del título de agregar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder addTitle(String addTitle) {
            this.addTitle = addTitle;
            return this;
        }

        /**
         * Asigna el texto del botón de agregar.
         *
         * @param addBtn texto del botón de agregar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder addBtn(String addBtn) {
            this.addBtn = addBtn;
            return this;
        }

        /**
         * Asigna el texto de la información del beneficiario.
         *
         * @param beneficiaryInfo texto de la información del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryInfo(String beneficiaryInfo) {
            this.beneficiaryInfo = beneficiaryInfo;
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
         * Asigna el texto del teléfono.
         *
         * @param phone texto del teléfono
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Asigna el texto del apellido.
         *
         * @param lastName texto del apellido
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
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
         * Asigna el texto del estado civil.
         *
         * @param maritalStatus texto del estado civil
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        /**
         * Asigna el texto de los datos de residencia.
         *
         * @param residenceData texto de los datos de residencia
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder residenceData(String residenceData) {
            this.residenceData = residenceData;
            return this;
        }

        /**
         * Asigna el texto del departamento.
         *
         * @param department texto del departamento
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder department(String department) {
            this.department = department;
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
         * Asigna el texto del barrio.
         *
         * @param neighborhood texto del barrio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
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
         * Asigna el texto del cruce.
         *
         * @param crossing texto del cruce
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        /**
         * Asigna el texto de la afectación.
         *
         * @param affectation texto de la afectación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        /**
         * Asigna el texto del lugar de expedición.
         *
         * @param expeditionLocation texto del lugar de expedición
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        /**
         * Asigna el texto de la publicación.
         *
         * @param publication texto de la publicación
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        /**
         * Asigna el texto del afectado.
         *
         * @param affected texto del afectado
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder affected(String affected) {
            this.affected = affected;
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
         * Construye una nueva instancia de {@link DTORegisterBeneficiaryText}.
         *
         * @return nueva instancia inmutable
         */
        public DTORegisterBeneficiaryText build() {
            return new DTORegisterBeneficiaryText(this);
        }

    }

}
