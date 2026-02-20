package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyDetails extends DTOProperty {

    private int propertyCode;
    private List<DTOBeneficiaryPropertyDetails> beneficiaries;
    private List<DTOPointDetails> points;
    private long numResolution;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;

    public DTOPropertyDetails() {
        super();
        this.beneficiaries = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public DTOPropertyDetails(Builder builder) {
        super(builder.cadastralId, builder.area);
        this.propertyCode = builder.propertyCode;
        this.beneficiaries = builder.beneficiaries;
        this.points = builder.points;
        this.numResolution = builder.numResolution;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public void setBeneficiaries(List<DTOBeneficiaryPropertyDetails> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setPoints(List<DTOPointDetails> points) {
        this.points = points;
    }

    public void setNumResolution(long numResolution) {
        this.numResolution = numResolution;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public List<DTOBeneficiaryPropertyDetails> getBeneficiaries() {
        return beneficiaries;
    }

    public List<DTOPointDetails> getPoints() {
        return points;
    }

    public long getNumResolution() {
        return numResolution;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public LocalDate getExecutory() {
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

    public static class Builder {

        private int propertyCode;
        private String cadastralId;
        private Double area;
        private List<DTOBeneficiaryPropertyDetails> beneficiaries = new ArrayList<>();
        private List<DTOPointDetails> points = new ArrayList<>();
        private long numResolution;
        private LocalDate notification;
        private LocalDate executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder cadastralId(String cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

        public Builder area(Double area) {
            this.area = area;
            return this;
        }

        public Builder beneficiaries(List<DTOBeneficiaryPropertyDetails> beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        public Builder points(List<DTOPointDetails> points) {
            this.points = points;
            return this;
        }

        public Builder numResolution(long numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

        public Builder executory(LocalDate executory) {
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

        public DTOPropertyDetails build() {
            return new DTOPropertyDetails(this);
        }

    }

}
