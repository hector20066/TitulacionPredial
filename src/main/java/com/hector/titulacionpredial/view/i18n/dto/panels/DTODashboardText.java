package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO que encapsula los textos internacionalizados para el panel de control (dashboard).
 *
 * <p>Se construye mediante el patrón Builder interno {@link Builder}.</p>
 *
 * @author hectoracevedo
 */
public class DTODashboardText {

    private final String beneficiaries;
    private final String beneficiariesDesc;
    private final String properties;
    private final String propertiesDesc;
    private final String resolutions;
    private final String resolutionsDesc;
    private final String withProperty;
    private final String withoutProperty;
    private final String withResolution;
    private final String withoutResolution;
    private final String total;
    private final String totalRegisters;
    private final String percentWorks;
    private final String registersMonth;

    /**
     * Construye una instancia a partir del {@link Builder}.
     *
     * @param builder builder con los textos configurados
     */
    public DTODashboardText(Builder builder) {
        this.beneficiaries = builder.beneficiaries;
        this.beneficiariesDesc = builder.beneficiariesDesc;
        this.properties = builder.properties;
        this.propertiesDesc = builder.propertiesDesc;
        this.resolutions = builder.resolutions;
        this.resolutionsDesc = builder.resolutionsDesc;
        this.withProperty = builder.withProperty;
        this.withoutProperty = builder.withoutProperty;
        this.withResolution = builder.withResolution;
        this.withoutResolution = builder.withoutResolution;
        this.total = builder.total;
        this.totalRegisters = builder.totalRegisters;
        this.percentWorks = builder.percentWorks;
        this.registersMonth = builder.registersMonth;
    }

    /**
     * Obtiene el texto de beneficiarios.
     *
     * @return texto de beneficiarios
     */
    public String getBeneficiaries() {
        return beneficiaries;
    }

    /**
     * Obtiene el texto de descripción de beneficiarios.
     *
     * @return texto de descripción de beneficiarios
     */
    public String getBeneficiariesDesc() {
        return beneficiariesDesc;
    }

    /**
     * Obtiene el texto de predios.
     *
     * @return texto de predios
     */
    public String getProperties() {
        return properties;
    }

    /**
     * Obtiene el texto de descripción de predios.
     *
     * @return texto de descripción de predios
     */
    public String getPropertiesDesc() {
        return propertiesDesc;
    }

    /**
     * Obtiene el texto de resoluciones.
     *
     * @return texto de resoluciones
     */
    public String getResolutions() {
        return resolutions;
    }

    /**
     * Obtiene el texto de descripción de resoluciones.
     *
     * @return texto de descripción de resoluciones
     */
    public String getResolutionsDesc() {
        return resolutionsDesc;
    }

    /**
     * Obtiene el texto de con predio.
     *
     * @return texto de con predio
     */
    public String getWithProperty() {
        return withProperty;
    }

    /**
     * Obtiene el texto de sin predio.
     *
     * @return texto de sin predio
     */
    public String getWithoutProperty() {
        return withoutProperty;
    }

    /**
     * Obtiene el texto de con resolución.
     *
     * @return texto de con resolución
     */
    public String getWithResolution() {
        return withResolution;
    }

    /**
     * Obtiene el texto de sin resolución.
     *
     * @return texto de sin resolución
     */
    public String getWithoutResolution() {
        return withoutResolution;
    }

    /**
     * Obtiene el texto de total.
     *
     * @return texto de total
     */
    public String getTotal() {
        return total;
    }

    /**
     * Obtiene el texto de total de registros.
     *
     * @return texto de total de registros
     */
    public String getTotalRegisters() {
        return totalRegisters;
    }

    /**
     * Obtiene el texto de porcentaje de trabajos.
     *
     * @return texto de porcentaje de trabajos
     */
    public String getPercentWorks() {
        return percentWorks;
    }

    /**
     * Obtiene el texto de registros por mes.
     *
     * @return texto de registros por mes
     */
    public String getRegistersMonth() {
        return registersMonth;
    }

    /**
     * Builder para la construcción de instancias de {@link DTODashboardText}.
     */
    public static class Builder {

        private String beneficiaries;
        private String beneficiariesDesc;
        private String properties;
        private String propertiesDesc;
        private String resolutions;
        private String resolutionsDesc;
        private String withProperty;
        private String withoutProperty;
        private String withResolution;
        private String withoutResolution;
        private String total;
        private String totalRegisters;
        private String percentWorks;
        private String registersMonth;

        /**
         * Asigna el texto de beneficiarios.
         *
         * @param beneficiaries texto de beneficiarios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiaries(String beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        /**
         * Asigna el texto de descripción de beneficiarios.
         *
         * @param beneficiariesDesc texto de descripción de beneficiarios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder beneficiariesDesc(String beneficiariesDesc) {
            this.beneficiariesDesc = beneficiariesDesc;
            return this;
        }

        /**
         * Asigna el texto de predios.
         *
         * @param properties texto de predios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

        /**
         * Asigna el texto de descripción de predios.
         *
         * @param propertiesDesc texto de descripción de predios
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder propertiesDesc(String propertiesDesc) {
            this.propertiesDesc = propertiesDesc;
            return this;
        }

        /**
         * Asigna el texto de resoluciones.
         *
         * @param resolutions texto de resoluciones
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder resolutions(String resolutions) {
            this.resolutions = resolutions;
            return this;
        }

        /**
         * Asigna el texto de descripción de resoluciones.
         *
         * @param resolutionsDesc texto de descripción de resoluciones
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder resolutionsDesc(String resolutionsDesc) {
            this.resolutionsDesc = resolutionsDesc;
            return this;
        }

        /**
         * Asigna el texto de con predio.
         *
         * @param withProperty texto de con predio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder withProperty(String withProperty) {
            this.withProperty = withProperty;
            return this;
        }

        /**
         * Asigna el texto de sin predio.
         *
         * @param withoutProperty texto de sin predio
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder withoutProperty(String withoutProperty) {
            this.withoutProperty = withoutProperty;
            return this;
        }

        /**
         * Asigna el texto de con resolución.
         *
         * @param withResolution texto de con resolución
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder withResolution(String withResolution) {
            this.withResolution = withResolution;
            return this;
        }

        /**
         * Asigna el texto de sin resolución.
         *
         * @param withoutResolution texto de sin resolución
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder withoutResolution(String withoutResolution) {
            this.withoutResolution = withoutResolution;
            return this;
        }

        /**
         * Asigna el texto de total.
         *
         * @param total texto de total
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder total(String total) {
            this.total = total;
            return this;
        }

        /**
         * Asigna el texto de total de registros.
         *
         * @param totalRegisters texto de total de registros
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder totalRegisters(String totalRegisters) {
            this.totalRegisters = totalRegisters;
            return this;
        }

        /**
         * Asigna el texto de porcentaje de trabajos.
         *
         * @param percentWorks texto de porcentaje de trabajos
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder percentWorks(String percentWorks) {
            this.percentWorks = percentWorks;
            return this;
        }

        /**
         * Asigna el texto de registros por mes.
         *
         * @param registersMonth texto de registros por mes
         * @return esta instancia del builder para encadenamiento fluido
         */
        public Builder registersMonth(String registersMonth) {
            this.registersMonth = registersMonth;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTODashboardText}.
         *
         * @return nueva instancia inmutable
         */
        public DTODashboardText build() {
            return new DTODashboardText(this);
        }

    }

}
