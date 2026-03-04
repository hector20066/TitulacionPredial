package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 * DTO que encapsula los textos internacionalizados para el diálogo de selección de beneficiario.
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTOSelectBeneficiaryText {

    private final String title;
    private final String beneficiaryCode;
    private final String beneficiaryName;
    private final String beneficiaryId;
    private final String beneficiaryCadastralRef;
    private final String search;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTOSelectBeneficiaryText(Builder builder) {
        this.title = builder.title;
        this.beneficiaryCode = builder.beneficiaryCode;
        this.beneficiaryName = builder.beneficiaryName;
        this.beneficiaryId = builder.beneficiaryId;
        this.beneficiaryCadastralRef = builder.beneficiaryCadastralRef;
        this.search = builder.search;
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
     * Obtiene el texto de código del beneficiario.
     *
     * @return texto de código del beneficiario
     */
    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    /**
     * Obtiene el texto de nombre del beneficiario.
     *
     * @return texto de nombre del beneficiario
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Obtiene el texto de identificación del beneficiario.
     *
     * @return texto de identificación del beneficiario
     */
    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * Obtiene el texto de referencia catastral del beneficiario.
     *
     * @return texto de referencia catastral del beneficiario
     */
    public String getBeneficiaryCadastralRef() {
        return beneficiaryCadastralRef;
    }

    /**
     * Obtiene el texto de búsqueda.
     *
     * @return texto de búsqueda
     */
    public String getSearch() {
        return search;
    }

    /**
     * Builder para la construcción de instancias de {@link DTOSelectBeneficiaryText}.
     */
    public static class Builder {

        private String title;
        private String beneficiaryCode;
        private String beneficiaryName;
        private String beneficiaryId;
        private String beneficiaryCadastralRef;
        private String search;

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
         * Asigna el texto de código del beneficiario.
         *
         * @param beneficiaryCode texto de código del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        /**
         * Asigna el texto de nombre del beneficiario.
         *
         * @param beneficiaryName texto de nombre del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        /**
         * Asigna el texto de identificación del beneficiario.
         *
         * @param beneficiaryId texto de identificación del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryId(String beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
            return this;
        }

        /**
         * Asigna el texto de referencia catastral del beneficiario.
         *
         * @param beneficiaryCadastralRef texto de referencia catastral del beneficiario
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaryCadastralRef(String beneficiaryCadastralRef) {
            this.beneficiaryCadastralRef = beneficiaryCadastralRef;
            return this;
        }

        /**
         * Asigna el texto de búsqueda.
         *
         * @param search texto de búsqueda
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOSelectBeneficiaryText}.
         *
         * @return nueva instancia inmutable
         */
        public DTOSelectBeneficiaryText build() {
            return new DTOSelectBeneficiaryText(this);
        }

    }

}
