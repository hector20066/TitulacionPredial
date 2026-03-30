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

    /**     * get code.     * @return the get code     */
    public String getCode() {
        return code;
    }

    /**     * get code identification.     * @return the get code identification     */
    public String getCodeIdentification() {
        return codeIdentification;
    }

    /**     * get id.     * @return the get id     */
    public String getId() {
        return id;
    }

    /**     * get name.     * @return the get name     */
    public String getName() {
        return name;
    }

    /**     * get phone.     * @return the get phone     */
    public String getPhone() {
        return phone;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * get municipality.     * @return the get municipality     */
    public String getMunicipality() {
        return municipality;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
    }

    /**     * get search.     * @return the get search     */
    public String getSearch() {
        return search;
    }

    /**     * get full info btn.     * @return the get full info btn     */
    public String getFullInfoBtn() {
        return fullInfoBtn;
    }

    /**     * get modify btn.     * @return the get modify btn     */
    public String getModifyBtn() {
        return modifyBtn;
    }

    /**     * get delete btn.     * @return the get delete btn     */
    public String getDeleteBtn() {
        return deleteBtn;
    }

    /**     * get export excel btn.     * @return the get export excel btn     */
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

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

    /**     * code identification.     * @param codeIdentification the code identification     * @return the code identification     */
        public Builder codeIdentification(String codeIdentification) {
            this.codeIdentification = codeIdentification;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

    /**     * name.     * @param name the name     * @return the name     */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

    /**     * phone.     * @param phone the phone     * @return the phone     */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

    /**     * search.     * @param search the search     * @return the search     */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

    /**     * full info btn.     * @param fullInfoBtn the full info btn     * @return the full info btn     */
        public Builder fullInfoBtn(String fullInfoBtn) {
            this.fullInfoBtn = fullInfoBtn;
            return this;
        }

    /**     * modify btn.     * @param modifyBtn the modify btn     * @return the modify btn     */
        public Builder modifyBtn(String modifyBtn) {
            this.modifyBtn = modifyBtn;
            return this;
        }

    /**     * delete btn.     * @param deleteBtn the delete btn     * @return the delete btn     */
        public Builder deleteBtn(String deleteBtn) {
            this.deleteBtn = deleteBtn;
            return this;
        }

    /**     * export excel btn.     * @param exportExcelBtn the export excel btn     * @return the export excel btn     */
        public Builder exportExcelBtn(String exportExcelBtn) {
            this.exportExcelBtn = exportExcelBtn;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOViewBeneficiariesText build() {
            return new DTOViewBeneficiariesText(this);
        }

    }

}
