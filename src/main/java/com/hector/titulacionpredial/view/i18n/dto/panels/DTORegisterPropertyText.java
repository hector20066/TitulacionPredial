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

    /**     * get title.     * @return the get title     */
    public String getTitle() {
        return title;
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

    /**     * get register btn.     * @return the get register btn     */
    public String getRegisterBtn() {
        return registerBtn;
    }

    /**     * get property info.     * @return the get property info     */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /**     * get cadastral id.     * @return the get cadastral id     */
    public String getCadastralId() {
        return cadastralId;
    }

    /**     * get area.     * @return the get area     */
    public String getArea() {
        return area;
    }

    /**     * get points info.     * @return the get points info     */
    public String getPointsInfo() {
        return pointsInfo;
    }

    /**     * get beneficiary code.     * @return the get beneficiary code     */
    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    /**     * get search beneficiary.     * @return the get search beneficiary     */
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

    /**     * title.     * @param title the title     * @return the title     */
        public Builder title(String title) {
            this.title = title;
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

    /**     * register btn.     * @param registerBtn the register btn     * @return the register btn     */
        public Builder registerBtn(String registerBtn) {
            this.registerBtn = registerBtn;
            return this;
        }

    /**     * property info.     * @param propertyInfo the property info     * @return the property info     */
        public Builder propertyInfo(String propertyInfo) {
            this.propertyInfo = propertyInfo;
            return this;
        }

    /**     * cadastral id.     * @param cadastralId the cadastral id     * @return the cadastral id     */
        public Builder cadastralId(String cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

    /**     * area.     * @param area the area     * @return the area     */
        public Builder area(String area) {
            this.area = area;
            return this;
        }


    /**     * points info.     * @param pointsInfo the points info     * @return the points info     */
        public Builder pointsInfo(String pointsInfo) {
            this.pointsInfo = pointsInfo;
            return this;
        }

    /**     * beneficiary code.     * @param beneficiaryCode the beneficiary code     * @return the beneficiary code     */
        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

    /**     * search beneficiary.     * @param searchBeneficiary the search beneficiary     * @return the search beneficiary     */
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

    /**     * build.     * @return the build     */
        public DTORegisterPropertyText build() {
            return new DTORegisterPropertyText(this);
        }

    }

}
