package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de ver beneficiarios.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOViewBeneficiariesText {

    private final String code;
    private final String id;
    private final String name;
    private final String phone;
    private final String cadastralRef;
    private final String municipality;
    private final String address;
    private final String title;
    private final String search;
    private final String fullInfoBtn;
    private final String modifyBtn;
    private final String deleteBtn;
    private final String exportExcelBtn;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOViewBeneficiariesText(Builder builder) {
        this.code = builder.code;
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.cadastralRef = builder.cadastralRef;
        this.municipality = builder.municipality;
        this.address = builder.address;
        this.title = builder.title;
        this.search = builder.search;
        this.fullInfoBtn = builder.fullInfoBtn;
        this.modifyBtn = builder.modifyBtn;
        this.deleteBtn = builder.deleteBtn;
        this.exportExcelBtn = builder.exportExcelBtn;
    }

    /** Obtiene el texto del código. @return texto del código */
    public String getCode() {
        return code;
    }

    /** Obtiene el texto de la identificación. @return texto de la identificación */
    public String getId() {
        return id;
    }

    /** Obtiene el texto del nombre. @return texto del nombre */
    public String getName() {
        return name;
    }

    /** Obtiene el texto del teléfono. @return texto del teléfono */
    public String getPhone() {
        return phone;
    }

    /** Obtiene el texto de la referencia catastral. @return texto de la referencia catastral */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /** Obtiene el texto del municipio. @return texto del municipio */
    public String getMunicipality() {
        return municipality;
    }

    /** Obtiene el texto de la dirección. @return texto de la dirección */
    public String getAddress() {
        return address;
    }

    /** Obtiene el texto del título. @return texto del título */
    public String getTitle() {
        return title;
    }

    /** Obtiene el texto de la búsqueda. @return texto de la búsqueda */
    public String getSearch() {
        return search;
    }

    /** Obtiene el texto del botón de información completa. @return texto del botón de información completa */
    public String getFullInfoBtn() {
        return fullInfoBtn;
    }

    /** Obtiene el texto del botón de modificar. @return texto del botón de modificar */
    public String getModifyBtn() {
        return modifyBtn;
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
     * Builder para la construcción de instancias de {@link DTOViewBeneficiariesText}.
     */
    public static class Builder {

        private String code;
        private String id;
        private String name;
        private String phone;
        private String cadastralRef;
        private String municipality;
        private String address;
        private String title;
        private String search;
        private String fullInfoBtn;
        private String modifyBtn;
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
         * Asigna el texto del botón de información completa.
         *
         * @param fullInfoBtn texto del botón de información completa
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder fullInfoBtn(String fullInfoBtn) {
            this.fullInfoBtn = fullInfoBtn;
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
         * Asigna el texto del botón de eliminar.
         *
         * @param deleteBtn texto del botón de eliminar
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder deleteBtn(String deleteBtn) {
            this.deleteBtn = deleteBtn;
            return  this;
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
         * Construye una nueva instancia de {@link DTOViewBeneficiariesText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOViewBeneficiariesText build() {
            return new DTOViewBeneficiariesText(this);
        }

    }

}
