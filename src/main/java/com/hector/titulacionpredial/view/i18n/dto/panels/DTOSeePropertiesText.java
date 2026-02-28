package com.hector.titulacionpredial.view.i18n.dto.panels;


/**
 *
 * @author hectoracevedo
 */
public class DTOSeePropertiesText {

    private final String code;
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

    public DTOSeePropertiesText(Builder builder) {
        this.code = builder.code;
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

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNumResolution() {
        return numResolution;
    }

    public String getNotify() {
        return notify;
    }

    public String getExecutory() {
        return executory;
    }

    public String getFmi() {
        return fmi;
    }

    public String getAct() {
        return act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public String getNotary() {
        return notary;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public String getAddress() {
        return address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getSearch() {
        return search;
    }

    public String getProperties() {
        return properties;
    }

    public String getGenerateBtn() {
        return generateBtn;
    }

    public String getDeleteBtn() {
        return deleteBtn;
    }

    public String getExportExcelBtn() {
        return exportExcelBtn;
    }

    public static class Builder {

        private String code;
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

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        public Builder notify(String notify) {
            this.notify = notify;
            return this;
        }

        public Builder executory(String executory) {
            this.executory = executory;
            return this;
        }

        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        public Builder act(String act) {
            this.act = act;
            return this;
        }

        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        public Builder cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder properties(String properties) {
            this.properties = properties;
            return this;
        }

        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
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

        public DTOSeePropertiesText build() {
            return new DTOSeePropertiesText(this);
        }

    }

}
