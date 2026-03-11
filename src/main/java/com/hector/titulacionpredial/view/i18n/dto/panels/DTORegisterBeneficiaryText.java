package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the beneficiary
 * registration panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 */
public class DTORegisterBeneficiaryText {

    private final String modifyTitle;
    private final String modifyBtn;
    private final String addTitle;
    private final String addBtn;
    private final String beneficiaryInfo;
    private final String fullName;
    private final String phone;
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
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTORegisterBeneficiaryText(Builder builder) {
        this.modifyTitle = builder.modifyTitle;
        this.modifyBtn = builder.modifyBtn;
        this.addTitle = builder.addTitle;
        this.addBtn = builder.addBtn;
        this.beneficiaryInfo = builder.beneficiaryInfo;
        this.fullName = builder.fullName;
        this.phone = builder.phone;
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

    public String getModifyTitle() {
        return modifyTitle;
    }

    public String getModifyBtn() {
        return modifyBtn;
    }

    public String getAddTitle() {
        return addTitle;
    }

    public String getAddBtn() {
        return addBtn;
    }

    public String getBeneficiaryInfo() {
        return beneficiaryInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getResidenceData() {
        return residenceData;
    }

    public String getDepartment() {
        return department;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public String getCrossing() {
        return crossing;
    }

    public String getAffectation() {
        return affectation;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public String getPublication() {
        return publication;
    }

    public String getAffected() {
        return affected;
    }

    public String getCode() {
        return code;
    }

    /**
     * Builder for building instances of {@link DTORegisterBeneficiaryText}.
     */
    public static class Builder {

        private String modifyTitle;
        private String modifyBtn;
        private String addTitle;
        private String addBtn;
        private String beneficiaryInfo;
        private String fullName;
        private String phone;
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

        public Builder modifyTitle(String modifyTitle) {
            this.modifyTitle = modifyTitle;
            return this;
        }

        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

        public Builder addTitle(String addTitle) {
            this.addTitle = addTitle;
            return this;
        }

        public Builder addBtn(String addBtn) {
            this.addBtn = addBtn;
            return this;
        }

        public Builder beneficiaryInfo(String beneficiaryInfo) {
            this.beneficiaryInfo = beneficiaryInfo;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder residenceData(String residenceData) {
            this.residenceData = residenceData;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        public Builder affected(String affected) {
            this.affected = affected;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public DTORegisterBeneficiaryText build() {
            return new DTORegisterBeneficiaryText(this);
        }

    }

}
