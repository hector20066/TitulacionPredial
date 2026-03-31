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
    private final String registerBtn;
    private final String addBeneficiaryBtn;
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
        this.registerBtn = builder.registerBtn;
        this.addBeneficiaryBtn = builder.addBeneficiaryBtn;
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

    public String getRegisterBtn() {
        return registerBtn;
    }

    /**     * get beneficiary info.     * @return the get beneficiary info     */
    public String getBeneficiaryInfo() {
        return beneficiaryInfo;
    }

    /**     * get full name.     * @return the get full name     */
    public String getFullName() {
        return fullName;
    }

    /**     * get phone.     * @return the get phone     */
    public String getPhone() {
        return phone;
    }

    /**     * get id.     * @return the get id     */
    public String getId() {
        return id;
    }

    /**     * get marital status.     * @return the get marital status     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**     * get residence data.     * @return the get residence data     */
    public String getResidenceData() {
        return residenceData;
    }

    /**     * get department.     * @return the get department     */
    public String getDepartment() {
        return department;
    }

    /**     * get municipality.     * @return the get municipality     */
    public String getMunicipality() {
        return municipality;
    }

    /**     * get neighborhood.     * @return the get neighborhood     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * get crossing.     * @return the get crossing     */
    public String getCrossing() {
        return crossing;
    }

    /**     * get affectation.     * @return the get affectation     */
    public String getAffectation() {
        return affectation;
    }

    /**     * get expedition location.     * @return the get expedition location     */
    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    /**     * get publication.     * @return the get publication     */
    public String getPublication() {
        return publication;
    }

    /**     * get affected.     * @return the get affected     */
    public String getAffected() {
        return affected;
    }

    /**     * get code.     * @return the get code     */
    public String getCode() {
        return code;
    }

    public String getAddBeneficiaryBtn() {
        return addBeneficiaryBtn;
    }

    /**
     * Builder for building instances of {@link DTORegisterBeneficiaryText}.
     */
    public static class Builder {

        private String modifyTitle;
        private String modifyBtn;
        private String addTitle;
        private String registerBtn;
        private String addBeneficiaryBtn;
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

    /**     * modify title.     * @param modifyTitle the modify title     * @return the modify title     */
        public Builder modifyTitle(String modifyTitle) {
            this.modifyTitle = modifyTitle;
            return this;
        }

    /**     * modify btn.     * @param modifyBtn the modify btn     * @return the modify btn     */
        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

    /**     * add title.     * @param addTitle the add title     * @return the add title     */
        public Builder addTitle(String addTitle) {
            this.addTitle = addTitle;
            return this;
        }

        public Builder registerBtn(String registerBtn) {
            this.registerBtn = registerBtn;
            return this;
        }

        public Builder addBeneficiaryBtn(String addBeneficiaryBtn) {
            this.addBeneficiaryBtn = addBeneficiaryBtn;
            return this;
        }

    /**     * beneficiary info.     * @param beneficiaryInfo the beneficiary info     * @return the beneficiary info     */
        public Builder beneficiaryInfo(String beneficiaryInfo) {
            this.beneficiaryInfo = beneficiaryInfo;
            return this;
        }

    /**     * full name.     * @param fullName the full name     * @return the full name     */
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

    /**     * phone.     * @param phone the phone     * @return the phone     */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

    /**     * marital status.     * @param maritalStatus the marital status     * @return the marital status     */
        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

    /**     * residence data.     * @param residenceData the residence data     * @return the residence data     */
        public Builder residenceData(String residenceData) {
            this.residenceData = residenceData;
            return this;
        }

    /**     * department.     * @param department the department     * @return the department     */
        public Builder department(String department) {
            this.department = department;
            return this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * neighborhood.     * @param neighborhood the neighborhood     * @return the neighborhood     */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

    /**     * crossing.     * @param crossing the crossing     * @return the crossing     */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

    /**     * affectation.     * @param affectation the affectation     * @return the affectation     */
        public Builder affectation(String affectation) {
            this.affectation = affectation;
            return this;
        }

    /**     * expedition location.     * @param expeditionLocation the expedition location     * @return the expedition location     */
        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

    /**     * publication.     * @param publication the publication     * @return the publication     */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

    /**     * affected.     * @param affected the affected     * @return the affected     */
        public Builder affected(String affected) {
            this.affected = affected;
            return this;
        }

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTORegisterBeneficiaryText build() {
            return new DTORegisterBeneficiaryText(this);
        }

    }

}
