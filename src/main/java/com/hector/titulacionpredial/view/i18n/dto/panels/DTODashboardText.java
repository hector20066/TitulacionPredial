package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the dashboard.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
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
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
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

    /**     * get beneficiaries.     * @return the get beneficiaries     */
    public String getBeneficiaries() {
        return beneficiaries;
    }

    /**     * get beneficiaries desc.     * @return the get beneficiaries desc     */
    public String getBeneficiariesDesc() {
        return beneficiariesDesc;
    }

    /**     * get properties.     * @return the get properties     */
    public String getProperties() {
        return properties;
    }

    /**     * get properties desc.     * @return the get properties desc     */
    public String getPropertiesDesc() {
        return propertiesDesc;
    }

    /**     * get resolutions.     * @return the get resolutions     */
    public String getResolutions() {
        return resolutions;
    }

    /**     * get resolutions desc.     * @return the get resolutions desc     */
    public String getResolutionsDesc() {
        return resolutionsDesc;
    }

    /**     * get with property.     * @return the get with property     */
    public String getWithProperty() {
        return withProperty;
    }

    /**     * get without property.     * @return the get without property     */
    public String getWithoutProperty() {
        return withoutProperty;
    }

    /**     * get with resolution.     * @return the get with resolution     */
    public String getWithResolution() {
        return withResolution;
    }

    /**     * get without resolution.     * @return the get without resolution     */
    public String getWithoutResolution() {
        return withoutResolution;
    }

    /**     * get total.     * @return the get total     */
    public String getTotal() {
        return total;
    }

    /**     * get total registers.     * @return the get total registers     */
    public String getTotalRegisters() {
        return totalRegisters;
    }

    /**     * get percent works.     * @return the get percent works     */
    public String getPercentWorks() {
        return percentWorks;
    }

    /**     * get registers month.     * @return the get registers month     */
    public String getRegistersMonth() {
        return registersMonth;
    }

    /**
     * Builder for building instances of {@link DTODashboardText}.
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

    /**     * beneficiaries.     * @param beneficiaries the beneficiaries     * @return the beneficiaries     */
        public Builder beneficiaries(String beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

    /**     * beneficiaries desc.     * @param beneficiariesDesc the beneficiaries desc     * @return the beneficiaries desc     */
        public Builder beneficiariesDesc(String beneficiariesDesc) {
            this.beneficiariesDesc = beneficiariesDesc;
            return this;
        }

    /**     * properties.     * @param properties the properties     * @return the properties     */
        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

    /**     * properties desc.     * @param propertiesDesc the properties desc     * @return the properties desc     */
        public Builder propertiesDesc(String propertiesDesc) {
            this.propertiesDesc = propertiesDesc;
            return this;
        }

    /**     * resolutions.     * @param resolutions the resolutions     * @return the resolutions     */
        public Builder resolutions(String resolutions) {
            this.resolutions = resolutions;
            return this;
        }

    /**     * resolutions desc.     * @param resolutionsDesc the resolutions desc     * @return the resolutions desc     */
        public Builder resolutionsDesc(String resolutionsDesc) {
            this.resolutionsDesc = resolutionsDesc;
            return this;
        }

    /**     * with property.     * @param withProperty the with property     * @return the with property     */
        public Builder withProperty(String withProperty) {
            this.withProperty = withProperty;
            return this;
        }

    /**     * without property.     * @param withoutProperty the without property     * @return the without property     */
        public Builder withoutProperty(String withoutProperty) {
            this.withoutProperty = withoutProperty;
            return this;
        }

    /**     * with resolution.     * @param withResolution the with resolution     * @return the with resolution     */
        public Builder withResolution(String withResolution) {
            this.withResolution = withResolution;
            return this;
        }

    /**     * without resolution.     * @param withoutResolution the without resolution     * @return the without resolution     */
        public Builder withoutResolution(String withoutResolution) {
            this.withoutResolution = withoutResolution;
            return this;
        }

    /**     * total.     * @param total the total     * @return the total     */
        public Builder total(String total) {
            this.total = total;
            return this;
        }

    /**     * total registers.     * @param totalRegisters the total registers     * @return the total registers     */
        public Builder totalRegisters(String totalRegisters) {
            this.totalRegisters = totalRegisters;
            return this;
        }

    /**     * percent works.     * @param percentWorks the percent works     * @return the percent works     */
        public Builder percentWorks(String percentWorks) {
            this.percentWorks = percentWorks;
            return this;
        }

    /**     * registers month.     * @param registersMonth the registers month     * @return the registers month     */
        public Builder registersMonth(String registersMonth) {
            this.registersMonth = registersMonth;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTODashboardText build() {
            return new DTODashboardText(this);
        }

    }

}
