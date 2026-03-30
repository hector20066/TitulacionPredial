package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 */
public class DTOUserMenuText extends DTOMenuText {

    private final String registerInfo;
    private final String registerBeneficiaries;
    private final String registerProperties;


    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOUserMenuText(Builder builder) {
        super(builder);
        this.registerInfo = builder.registerInfo;
        this.registerBeneficiaries = builder.registerBeneficiaries;
        this.registerProperties = builder.registerProperties;
    }

    public String getRegisterInfo() {
        return registerInfo;
    }

    public String getRegisterBeneficiaries() {
        return registerBeneficiaries;
    }

    public String getRegisterProperties() {
        return registerProperties;
    }

    public static class Builder extends DTOMenuText.Builder<Builder> {

        private String registerInfo;
        private String registerBeneficiaries;
        private String registerProperties;

        public Builder registerInfo(String registerInfo) {
            this.registerInfo = registerInfo;
            return this;
        }

        public Builder registerBeneficiaries(String registerBeneficiaries) {
            this.registerBeneficiaries = registerBeneficiaries;
            return this;
        }

        public Builder registerProperties(String registerProperties) {
            this.registerProperties = registerProperties;
            return this;
        }

        public DTOUserMenuText build() {
            return new DTOUserMenuText(this);
        }

    }

}
