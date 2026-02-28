package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 *
 * @author hectoracevedo
 */
public class DTOSpouseDataText {

    private final String title;
    private final String spouseName;
    private final String spouseLastName;
    private final String spouseId;
    private final String spouseExpeditionLocation;
    private final String spouseAddress;
    private final String spousePhone;
    private final String btnSave;
    private final String btnCancel;

    public DTOSpouseDataText(Builder builder) {
        this.title = builder.title;
        this.spouseName = builder.spouseName;
        this.spouseLastName = builder.spouseLastName;
        this.spouseId = builder.spouseId;
        this.spouseExpeditionLocation = builder.spouseExpeditionLocation;
        this.spouseAddress = builder.spouseAddress;
        this.spousePhone = builder.spousePhone;
        this.btnSave = builder.btnSave;
        this.btnCancel = builder.btnCancel;
    }

    public String getTitle() {
        return title;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
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

    public String getBtnSave() {
        return btnSave;
    }

    public String getBtnCancel() {
        return btnCancel;
    }

    public static class Builder {

        private String title;
        private String spouseName;
        private String spouseLastName;
        private String spouseId;
        private String spouseExpeditionLocation;
        private String spouseAddress;
        private String spousePhone;
        private String btnSave;
        private String btnCancel;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder spouseName(String spouseName) {
            this.spouseName = spouseName;
            return this;
        }

        public Builder spouseLastName(String spouseLastName) {
            this.spouseLastName = spouseLastName;
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

        public Builder btnSave(String btnSave) {
            this.btnSave = btnSave;
            return this;
        }

        public Builder btnCancel(String btnCancel) {
            this.btnCancel = btnCancel;
            return this;
        }

        public DTOSpouseDataText build() {
            return new DTOSpouseDataText(this);
        }

    }

}
