package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 *
 * @author hectoracevedo
 */
public class DTOUserProfileText {

    private final String title;
    private final String code;
    private final String id;
    private final String phone;
    private final String address;
    private final String department;
    private final String municipality;
    private final String neighborhood;
    private final String residenceData;
    private final String expeditionLocation;
    private final String maritalStatus;
    private final String cadastralRef;
    private final String crossing;
    private final String affectation;
    private final String publication;
    private final String spouseData;
    private final String spouseName;
    private final String spouseId;
    private final String spouseExpeditionLocation;
    private final String spouseAddress;
    private final String spousePhone;
    private final String notApply;
    private final String btnExit;

    public DTOUserProfileText(Builder builder) {
        this.title = builder.title;
        this.code = builder.code;
        this.id = builder.id;
        this.phone = builder.phone;
        this.address = builder.address;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.residenceData = builder.residenceData;
        this.expeditionLocation = builder.expeditionLocation;
        this.maritalStatus = builder.maritalStatus;
        this.cadastralRef = builder.cadastralRef;
        this.crossing = builder.crossing;
        this.affectation = builder.affectation;
        this.publication = builder.publication;
        this.spouseData = builder.spouseData;
        this.spouseName = builder.spouseName;
        this.spouseId = builder.spouseId;
        this.spouseExpeditionLocation = builder.spouseExpeditionLocation;
        this.spouseAddress = builder.spouseAddress;
        this.spousePhone = builder.spousePhone;
        this.notApply = builder.notApply;
        this.btnExit = builder.btnExit;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
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

    public String getResidenceData() {
        return residenceData;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
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

    public String getPublication() {
        return publication;
    }

    public String getSpouseData() {
        return spouseData;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public String getSpouseId() {
        return spouseId;
    }

    public String getSpouseExpeditionLocation() {
        return spouseExpeditionLocation;
    }

    public String getSpouseAddress() {
        return spouseAddress;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public String getNotApply() {
        return notApply;
    }

    public String getBtnExit() {
        return btnExit;
    }

    public static class Builder {

        private String title;
        private String code;
        private String id;
        private String phone;
        private String address;
        private String department;
        private String municipality;
        private String neighborhood;
        private String residenceData;
        private String expeditionLocation;
        private String maritalStatus;
        private String cadastralRef;
        private String crossing;
        private String affectation;
        private String publication;
        private String spouseData;
        private String spouseName;
        private String spouseId;
        private String spouseExpeditionLocation;
        private String spouseAddress;
        private String spousePhone;
        private String notApply;
        private String btnExit;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
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

        public Builder residenceData(String residenceData) {
            this.residenceData = residenceData;
            return this;
        }

        public Builder expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
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

        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

        public Builder spouseData(String spouseData) {
            this.spouseData = spouseData;
            return this;
        }

        public Builder spouseName(String spouseName) {
            this.spouseName = spouseName;
            return this;
        }

        public Builder spouseId(String spouseId) {
            this.spouseId = spouseId;
            return this;
        }

        public Builder spouseExpeditionLocation(String spouseExpeditionLocation) {
            this.spouseExpeditionLocation = spouseExpeditionLocation;
            return this;
        }

        public Builder spouseAddress(String spouseAddress) {
            this.spouseAddress = spouseAddress;
            return this;
        }

        public Builder spousePhone(String spousePhone) {
            this.spousePhone = spousePhone;
            return this;
        }

        public Builder notApply(String notApply) {
            this.notApply = notApply;
            return this;
        }

        public Builder btnExit(String btnExit) {
            this.btnExit = btnExit;
            return this;
        }

        public DTOUserProfileText build() {
            return new DTOUserProfileText(this);
        }

    }

}
