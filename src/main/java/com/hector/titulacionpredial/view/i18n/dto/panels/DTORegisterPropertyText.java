package com.hector.titulacionpredial.view.i18n.dto.panels;

/**
 * DTO that encapsulates the internationalized texts for the property
 * registration panel.
 *
 * <p>
 * It is built using the internal Builder pattern {@link Builder}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTORegisterPropertyText {

    private final String title;
    private final String point;
    private final String northCord;
    private final String eastCord;
    private final String distance;
    private final String hillside;
    private final String registerBtn;
    private final String propertyInfo;
    private final String cadastralId;
    private final String area;
    private final String pointsInfo;
    private final String beneficiaryCode;
    private final String searchBeneficiary;
    private final String importExcelData;
    private final String address;

    /**
     * Build an instance from the {@link Builder}.
     *
     * @param builder builder with the configured texts
     */
    public DTORegisterPropertyText(Builder builder) {
        this.title = builder.title;
        this.point = builder.point;
        this.northCord = builder.northCord;
        this.eastCord = builder.eastCord;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.registerBtn = builder.registerBtn;
        this.propertyInfo = builder.propertyInfo;
        this.cadastralId = builder.cadastralId;
        this.area = builder.area;
        this.pointsInfo = builder.pointsInfo;
        this.beneficiaryCode = builder.beneficiaryCode;
        this.searchBeneficiary = builder.searchBeneficiary;
        this.importExcelData = builder.importExcelData;
        this.address = builder.address;
    }

    public String getTitle() {
        return title;
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

    public String getRegisterBtn() {
        return registerBtn;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public String getArea() {
        return area;
    }

    public String getPointsInfo() {
        return pointsInfo;
    }

    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public String getSearchBeneficiary() {
        return searchBeneficiary;
    }

    public String getImportExcelData() {
        return importExcelData;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Builder for building instances of {@link DTORegisterPropertyText}.
     */
    public static class Builder {

        private String title;
        private String point;
        private String northCord;
        private String eastCord;
        private String distance;
        private String hillside;
        private String registerBtn;
        private String propertyInfo;
        private String cadastralId;
        private String area;
        private String pointsInfo;
        private String beneficiaryCode;
        private String searchBeneficiary;
        private String importExcelData;
        private String address;

        public Builder title(String title) {
            this.title = title;
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

        public Builder registerBtn(String registerBtn) {
            this.registerBtn = registerBtn;
            return this;
        }

        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

        public Builder cadastralId(String cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder pointsInfo(String pointsInfo) {
            this.pointsInfo = pointsInfo;
            return this;
        }

        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        public Builder searchBeneficiary(String searchBeneficiary) {
            this.searchBeneficiary = searchBeneficiary;
            return this;
        }

        public Builder importExcelData(String importExcelData) {
            this.importExcelData = importExcelData;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public DTORegisterPropertyText build() {
            return new DTORegisterPropertyText(this);
        }

    }

}
