package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOAdminMenuText extends DTOMenuText {

    private final String registerInfo;
    private final String registerBeneficiaries;
    private final String registerProperties;
    private final String manageUsers;
    private final String users;
    private final String registerUser;
    private final String seeUsers;

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOAdminMenuText(Builder builder) {
        super(builder);
        this.registerInfo = builder.registerInfo;
        this.registerBeneficiaries = builder.registerBeneficiaries;
        this.registerProperties = builder.registerProperties;
        this.manageUsers = builder.manageUsers;
        this.users = builder.users;
        this.registerUser = builder.registerUser;
        this.seeUsers = builder.seeUsers;

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

    public String getManageUsers() {
        return manageUsers;
    }

    public String getUsers() {
        return users;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public String getSeeUsers() {
        return seeUsers;
    }

    public static class Builder extends DTOMenuText.Builder<Builder> {

        private  String registerInfo;
        private String registerBeneficiaries;
        private String registerProperties;
        private String manageUsers;
        private String users;
        private String registerUser;
        private String seeUsers;

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

        public Builder manageUsers(String manageUsers) {
            this.manageUsers = manageUsers;
            return this;
        }

        public Builder users(String users) {
            this.users = users;
            return this;
        }

        public Builder registerUser(String registerUser) {
            this.registerUser = registerUser;
            return this;
        }

        public Builder seeUsers(String seeUsers) {
            this.seeUsers = seeUsers;
            return this;
        }

        public DTOAdminMenuText build() {
            return new DTOAdminMenuText(this);
        }

    }
}
