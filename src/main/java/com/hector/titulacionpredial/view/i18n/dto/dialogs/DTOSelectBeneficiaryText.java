package com.hector.titulacionpredial.view.i18n.dto.dialogs;

/**
 *
 * @author hectoracevedo
 */
public class DTOSelectBeneficiaryText {

    private final String beneficiaryCode;
    private final String beneficiaryName;
    private final String beneficiaryId;
    private final String beneficiaryCadastralRef;
    private final String search;

    public DTOSelectBeneficiaryText(Builder builder) {
        this.beneficiaryCode = builder.beneficiaryCode;
        this.beneficiaryName = builder.beneficiaryName;
        this.beneficiaryId = builder.beneficiaryId;
        this.beneficiaryCadastralRef = builder.beneficiaryCadastralRef;
        this.search = builder.search;
    }

    public String getBeneficiaryCode() {
        return beneficiaryCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getBeneficiaryCadastralRef() {
        return beneficiaryCadastralRef;
    }

    public String getSearch() {
        return search;
    }

    public static class Builder {

        private String beneficiaryCode;
        private String beneficiaryName;
        private String beneficiaryId;
        private String beneficiaryCadastralRef;
        private String search;

        public Builder beneficiaryCode(String beneficiaryCode) {
            this.beneficiaryCode = beneficiaryCode;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder beneficiaryId(String beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
            return this;
        }

        public Builder beneficiaryCadastralRef(String beneficiaryCadastralRef) {
            this.beneficiaryCadastralRef = beneficiaryCadastralRef;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public DTOSelectBeneficiaryText build() {
            return new DTOSelectBeneficiaryText(this);
        }

    }

}
