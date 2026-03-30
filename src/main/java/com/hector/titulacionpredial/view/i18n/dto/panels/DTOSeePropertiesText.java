package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the view
 * properties panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 */
public class DTOSeePropertiesText {

    private final String code;
    private final String codeBeneficiaries;
    private final String name;
    private final String id;
    private final String numResolution;
    private final String notify;
    private final String executory;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String cadastralRef;
    private final String address;
    private final String municipality;
    private final String search;
    private final String properties;
    private final String generateBtn;
    private final String deleteBtn;
    private final String exportExcelBtn;

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTOSeePropertiesText(Builder builder) {
        this.code = builder.code;
        this.codeBeneficiaries = builder.codeBeneficiaries;
        this.name = builder.name;
        this.id = builder.id;
        this.numResolution = builder.numResolution;
        this.notify = builder.notify;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.cadastralRef = builder.cadastralRef;
        this.address = builder.address;
        this.municipality = builder.municipality;
        this.search = builder.search;
        this.properties = builder.properties;
        this.generateBtn = builder.generateBtn;
        this.deleteBtn = builder.deleteBtn;
        this.exportExcelBtn = builder.exportExcelBtn;
    }

    /**     * get code.     * @return the get code     */
    public String getCode() {
        return code;
    }

    /**     * get code beneficiaries.     * @return the get code beneficiaries     */
    public String getCodeBeneficiaries() {
        return codeBeneficiaries;
    }

    /**     * get name.     * @return the get name     */
    public String getName() {
        return name;
    }

    /**     * get id.     * @return the get id     */
    public String getId() {
        return id;
    }

    /**     * get num resolution.     * @return the get num resolution     */
    public String getNumResolution() {
        return numResolution;
    }

    /**     * get notify.     * @return the get notify     */
    public String getNotify() {
        return notify;
    }

    /**     * get executory.     * @return the get executory     */
    public String getExecutory() {
        return executory;
    }

    /**     * get fmi.     * @return the get fmi     */
    public String getFmi() {
        return fmi;
    }

    /**     * get act.     * @return the get act     */
    public String getAct() {
        return act;
    }

    /**     * get public writing.     * @return the get public writing     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * get municipality.     * @return the get municipality     */
    public String getMunicipality() {
        return municipality;
    }

    /**     * get search.     * @return the get search     */
    public String getSearch() {
        return search;
    }

    /**     * get properties.     * @return the get properties     */
    public String getProperties() {
        return properties;
    }

    /**     * get generate btn.     * @return the get generate btn     */
    public String getGenerateBtn() {
        return generateBtn;
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
     * Builder for building instances of {@link DTOSeePropertiesText}.
     */
    public static class Builder {

        private String code;
        private String codeBeneficiaries;
        private String name;
        private String id;
        private String numResolution;
        private String notify;
        private String executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String cadastralRef;
        private String address;
        private String municipality;
        private String search;
        private String properties;
        private String generateBtn;
        private String deleteBtn;
        private String exportExcelBtn;

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

    /**     * code beneficiaries.     * @param codeBeneficiaries the code beneficiaries     * @return the code beneficiaries     */
        public Builder codeBeneficiaries(String codeBeneficiaries) {
            this.codeBeneficiaries = codeBeneficiaries;
            return this;
        }

    /**     * name.     * @param name the name     * @return the name     */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

    /**     * num resolution.     * @param numResolution the num resolution     * @return the num resolution     */
        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

    /**     * notify.     * @param notify the notify     * @return the notify     */
        public Builder notify(String notify) {
            this.notify = notify;
            return this;
        }

    /**     * executory.     * @param executory the executory     * @return the executory     */
        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

    /**     * fmi.     * @param fmi the fmi     * @return the fmi     */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

    /**     * act.     * @param act the act     * @return the act     */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

    /**     * public writing.     * @param publicWriting the public writing     * @return the public writing     */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

    /**     * notary.     * @param notary the notary     * @return the notary     */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * search.     * @param search the search     * @return the search     */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

    /**     * properties.     * @param properties the properties     * @return the properties     */
        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

    /**     * generate btn.     * @param generateBtn the generate btn     * @return the generate btn     */
        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
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
        public DTOSeePropertiesText build() {
            return new DTOSeePropertiesText(this);
        }

    }

}
