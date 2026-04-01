package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the view beneficiaries panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 */
public class DTOViewBeneficiariesText {

    private final String code;
    private final String codeIdentification;
    private final String id;
    private final String name;
    private final String phone;
    private final String cadastralRef;
    private final String municipality;
    private final String address;
    private final String title;
    private final String search;
    private final String fullInfoBtn;
    private final String modifyBtn;
    private final String deleteBtn;
    private final String exportExcelBtn;

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOViewBeneficiariesText(Builder builder) {
        this.code = builder.code;
        this.codeIdentification = builder.codeIdentification;
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.cadastralRef = builder.cadastralRef;
        this.municipality = builder.municipality;
        this.address = builder.address;
        this.title = builder.title;
        this.search = builder.search;
        this.fullInfoBtn = builder.fullInfoBtn;
        this.modifyBtn = builder.modifyBtn;
        this.deleteBtn = builder.deleteBtn;
        this.exportExcelBtn = builder.exportExcelBtn;
    }

    public String getCode() {
        return code;
    }

    public String getCodeIdentification() {
        return codeIdentification;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getSearch() {
        return search;
    }

    public String getFullInfoBtn() {
        return fullInfoBtn;
    }

    public String getModifyBtn() {
        return modifyBtn;
    }

    public String getDeleteBtn() {
        return deleteBtn;
    }

    public String getExportExcelBtn() {
        return exportExcelBtn;
    }

    /**
     * Builder for building instances of {@link DTOViewBeneficiariesText}.
     */
    public static class Builder {

        private String code;
        private String codeIdentification;
        private String id;
        private String name;
        private String phone;
        private String cadastralRef;
        private String municipality;
        private String address;
        private String title;
        private String search;
        private String fullInfoBtn;
        private String modifyBtn;
        private String deleteBtn;
        private String exportExcelBtn;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder codeIdentification(String codeIdentification) {
            this.codeIdentification = codeIdentification;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder fullInfoBtn(String fullInfoBtn) {
            this.fullInfoBtn = fullInfoBtn;
            return this;
        }

        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

        public Builder deleteBtn(String deleteBtn) {
            this.deleteBtn = deleteBtn;
            return this;
        }

        public Builder exportExcelBtn(String exportExcelBtn) {
            this.exportExcelBtn = exportExcelBtn;
            return this;
        }

        public DTOViewBeneficiariesText build() {
            return new DTOViewBeneficiariesText(this);
        }

    }

}
