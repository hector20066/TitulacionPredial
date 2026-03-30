package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the
 * resolution generation panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
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

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
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

    /**     * get resume title.     * @return the get resume title     */
    public String getResumeTitle() {
        return resumeTitle;
    }

    /**     * get beneficiary data.     * @return the get beneficiary data     */
    public String getBeneficiaryData() {
        return beneficiaryData;
    }

    /**     * get names.     * @return the get names     */
    public String getNames() {
        return names;
    }

    /**     * get id.     * @return the get id     */
    public String getId() {
        return id;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * get municipality.     * @return the get municipality     */
    public String getMunicipality() {
        return municipality;
    }

    /**     * get property info.     * @return the get property info     */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /**     * get point.     * @return the get point     */
    public String getPoint() {
        return point;
    }

    /**     * get north cord.     * @return the get north cord     */
    public String getNorthCord() {
        return northCord;
    }

    /**     * get east cord.     * @return the get east cord     */
    public String getEastCord() {
        return eastCord;
    }

    /**     * get distance.     * @return the get distance     */
    public String getDistance() {
        return distance;
    }

    /**     * get hillside.     * @return the get hillside     */
    public String getHillside() {
        return hillside;
    }

    /**     * get property code.     * @return the get property code     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**     * get area.     * @return the get area     */
    public String getArea() {
        return area;
    }

    /**     * get enter info.     * @return the get enter info     */
    public String getEnterInfo() {
        return enterInfo;
    }

    /**     * get num resolution.     * @return the get num resolution     */
    public String getNumResolution() {
        return numResolution;
    }

    /**     * get notification.     * @return the get notification     */
    public String getNotification() {
        return notification;
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

    /**     * get generate label.     * @return the get generate label     */
    public String getGenerateLabel() {
        return generateLabel;
    }

    /**     * get generate btn.     * @return the get generate btn     */
    public String getGenerateBtn() {
        return generateBtn;
    }

    /**
     * Builder for building instances of {@link DTOGenerateResolutionText}.
     */
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

    /**     * resume title.     * @param resumeTitle the resume title     * @return the resume title     */
        public Builder resumeTitle(String resumeTitle) {
            this.resumeTitle = resumeTitle;
            return this;
        }

    /**     * beneficiary data.     * @param beneficiaryData the beneficiary data     * @return the beneficiary data     */
        public Builder beneficiaryData(String beneficiaryData) {
            this.beneficiaryData = beneficiaryData;
            return this;
        }

    /**     * names.     * @param names the names     * @return the names     */
        public Builder names(String names) {
            this.names = names;
            return this;
        }

    /**     * id.     * @param id the id     * @return the id     */
        public Builder id(String id) {
            this.id = id;
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

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(String municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * property info.     * @param propertyInfo the property info     * @return the property info     */
        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

    /**     * point.     * @param point the point     * @return the point     */
        public Builder point(String point) {
            this.point = point;
            return this;
        }

    /**     * north cord.     * @param northCord the north cord     * @return the north cord     */
        public Builder northCord(String northCord) {
            this.northCord = northCord;
            return this;
        }

    /**     * east cord.     * @param eastCord the east cord     * @return the east cord     */
        public Builder eastCord(String eastCord) {
            this.eastCord = eastCord;
            return this;
        }

    /**     * distance.     * @param distance the distance     * @return the distance     */
        public Builder distance(String distance) {
            this.distance = distance;
            return this;
        }

    /**     * hillside.     * @param hillside the hillside     * @return the hillside     */
        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

    /**     * property code.     * @param propertyCode the property code     * @return the property code     */
        public Builder propertyCode(String propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

    /**     * area.     * @param area the area     * @return the area     */
        public Builder area(String area) {
            this.area = area;
            return this;
        }

    /**     * enter info.     * @param enterInfo the enter info     * @return the enter info     */
        public Builder enterInfo(String enterInfo) {
            this.enterInfo = enterInfo;
            return this;
        }

    /**     * num resolution.     * @param numResolution the num resolution     * @return the num resolution     */
        public Builder numResolution(String numResolution) {
            this.numResolution = numResolution;
            return this;
        }

    /**     * notification.     * @param notification the notification     * @return the notification     */
        public Builder notification(String notification) {
            this.notification = notification;
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

    /**     * generate label.     * @param generateLabel the generate label     * @return the generate label     */
        public Builder generateLabel(String generateLabel) {
            this.generateLabel = generateLabel;
            return this;
        }

    /**     * generate btn.     * @param generateBtn the generate btn     * @return the generate btn     */
        public Builder generateBtn(String generateBtn) {
            this.generateBtn = generateBtn;
            return this;
        }

    /**     * build.     * @return the build     */
        public DTOGenerateResolutionText build() {
            return new DTOGenerateResolutionText(this);
        }

    }

}
