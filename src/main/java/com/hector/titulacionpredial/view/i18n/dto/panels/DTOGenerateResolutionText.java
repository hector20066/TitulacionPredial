package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 *
 * @author hectoracevedo
 */
public class DTOGenerateResolutionText {

    private final String resumeTitle;
    private final String beneficiaryData;
    private final String names;
    private final String id;
    private final String address;
    private final String cadastralRef;
    private final String municipality;
    private final String propertyInfo;
    private final String point;
    private final String northCord;
    private final String eastCord;
    private final String distance;
    private final String hillside;
    private final String propertyCode;
    private final String area;
    private final String enterInfo;
    private final String numResolution;
    private final String notification;
    private final String executory;
    private final String fmi;
    private final String act;
    private final String publicWriting;
    private final String notary;
    private final String generateLabel;
    private final String generateBtn;

    public DTOGenerateResolutionText(Builder builder) {
        this.resumeTitle = builder.resumeTitle;
        this.beneficiaryData = builder.beneficiaryData;
        this.names = builder.names;
        this.id = builder.id;
        this.address = builder.address;
        this.cadastralRef = builder.cadastralRef;
        this.municipality = builder.municipality;
        this.propertyInfo = builder.propertyInfo;
        this.point = builder.point;
        this.northCord = builder.northCord;
        this.eastCord = builder.eastCord;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.propertyCode = builder.propertyCode;
        this.area = builder.area;
        this.enterInfo = builder.enterInfo;
        this.numResolution = builder.numResolution;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.generateLabel = builder.generateLabel;
        this.generateBtn = builder.generateBtn;
    }

    public String getResumeTitle() {
        return resumeTitle;
    }

    public String getBeneficiaryData() {
        return beneficiaryData;
    }

    public String getNames() {
        return names;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCadastralRef() {
        return cadastralRef;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public String getPoint() {
        return point;
    }

    public String getNorthCord() {
        return northCord;
    }

    public String getEastCord() {
        return eastCord;
    }

    public String getDistance() {
        return distance;
    }

    public String getHillside() {
        return hillside;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public String getArea() {
        return area;
    }

    public String getEnterInfo() {
        return enterInfo;
    }

    public String getNumResolution() {
        return numResolution;
    }

    public String getNotification() {
        return notification;
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

    public String getGenerateLabel() {
        return generateLabel;
    }

    public String getGenerateBtn() {
        return generateBtn;
    }

    public static class Builder {

        private String resumeTitle;
        private String beneficiaryData;
        private String names;
        private String id;
        private String address;
        private String cadastralRef;
        private String municipality;
        private String propertyInfo;
        private String point;
        private String northCord;
        private String eastCord;
        private String distance;
        private String hillside;
        private String propertyCode;
        private String area;
        private String enterInfo;
        private String numResolution;
        private String notification;
        private String executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;
        private String generateLabel;
        private String generateBtn;

        public Builder resumeTitle(String resumeTitle) {
            this.resumeTitle = resumeTitle;
            return this;
        }

        public Builder beneficiaryData(String beneficiaryData) {
            this.beneficiaryData = beneficiaryData;
            return this;
        }

        public Builder names(String names) {
            this.names = names;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
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

        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

        public Builder point(String point) {
            this.point = point;
            return this;
        }

        public Builder northCord(String northCord) {
            this.northCord = northCord;
            return this;
        }

        public Builder eastCord(String eastCord) {
            this.eastCord = eastCord;
            return this;
        }

        public Builder distance(String distance) {
            this.distance = distance;
            return this;
        }

        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

        public Builder propertyCode(String propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder enterInfo(String enterInfo) {
            this.enterInfo = enterInfo;
            return this;
        }

        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        public Builder notification(String notification) {
            this.notification = notification;
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

        public Builder generateLabel(String generateLabel) {
            this.generateLabel = generateLabel;
            return this;
        }

        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
            return this;
        }

        public DTOGenerateResolutionText build() {
            return new DTOGenerateResolutionText(this);
        }

    }

}
