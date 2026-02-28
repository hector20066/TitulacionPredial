package com.hector.titulacionpredial.view.i18n.dto.panels;


/**
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
    private final String nameCompany;
    private final String withProperty;
    private final String withoutProperty;
    private final String withResolution;
    private final String withoutResolution;
    private final String total;
    private final String totalRegisters;
    private final String percentWorks;
    private final String registersMonth;

    public DTODashboardText(Builder builder) {
        this.beneficiaries = builder.beneficiaries;
        this.beneficiariesDesc = builder.beneficiariesDesc;
        this.properties = builder.properties;
        this.propertiesDesc = builder.propertiesDesc;
        this.resolutions = builder.resolutions;
        this.resolutionsDesc = builder.resolutionsDesc;
        this.nameCompany = builder.nameCompany;
        this.withProperty = builder.withProperty;
        this.withoutProperty = builder.withoutProperty;
        this.withResolution = builder.withResolution;
        this.withoutResolution = builder.withoutResolution;
        this.total = builder.total;
        this.totalRegisters = builder.totalRegisters;
        this.percentWorks = builder.percentWorks;
        this.registersMonth = builder.registersMonth;
    }

    public String getBeneficiaries() {
        return beneficiaries;
    }

    public String getBeneficiariesDesc() {
        return beneficiariesDesc;
    }

    public String getProperties() {
        return properties;
    }

    public String getPropertiesDesc() {
        return propertiesDesc;
    }

    public String getResolutions() {
        return resolutions;
    }

    public String getResolutionsDesc() {
        return resolutionsDesc;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getWithProperty() {
        return withProperty;
    }

    public String getWithoutProperty() {
        return withoutProperty;
    }

    public String getWithResolution() {
        return withResolution;
    }

    public String getWithoutResolution() {
        return withoutResolution;
    }

    public String getTotal() {
        return total;
    }

    public String getTotalRegisters() {
        return totalRegisters;
    }

    public String getPercentWorks() {
        return percentWorks;
    }

    public String getRegistersMonth() {
        return registersMonth;
    }

    public static class Builder {

        private String beneficiaries;
        private String beneficiariesDesc;
        private String properties;
        private String propertiesDesc;
        private String resolutions;
        private String resolutionsDesc;
        private String nameCompany;
        private String withProperty;
        private String withoutProperty;
        private String withResolution;
        private String withoutResolution;
        private String total;
        private String totalRegisters;
        private String percentWorks;
        private String registersMonth;

        public Builder beneficiaries(String beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        public Builder beneficiariesDesc(String beneficiariesDesc) {
            this.beneficiariesDesc = beneficiariesDesc;
            return this;
        }

        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

        public Builder propertiesDesc(String propertiesDesc) {
            this.propertiesDesc = propertiesDesc;
            return this;
        }

        public Builder resolutions(String resolutions) {
            this.resolutions = resolutions;
            return this;
        }

        public Builder resolutionsDesc(String resolutionsDesc) {
            this.resolutionsDesc = resolutionsDesc;
            return this;
        }

        public Builder nameCompany(String nameCompany) {
            this.nameCompany = nameCompany;
            return this;
        }

        public Builder withProperty(String withProperty) {
            this.withProperty = withProperty;
            return this;
        }

        public Builder withoutProperty(String withoutProperty) {
            this.withoutProperty = withoutProperty;
            return this;
        }

        public Builder withResolution(String withResolution) {
            this.withResolution = withResolution;
            return this;
        }

        public Builder withoutResolution(String withoutResolution) {
            this.withoutResolution = withoutResolution;
            return this;
        }

        public Builder total(String total) {
            this.total = total;
            return this;
        }

        public Builder totalRegisters(String totalRegisters) {
            this.totalRegisters = totalRegisters;
            return this;
        }

        public Builder percentWorks(String percentWorks) {
            this.percentWorks = percentWorks;
            return this;
        }

        public Builder registersMonth(String registersMonth) {
            this.registersMonth = registersMonth;
            return this;
        }

        public DTODashboardText build() {
            return new DTODashboardText(this);
        }

    }

}
