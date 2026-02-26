package com.hector.titulacionpredial.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class Property {

    private long code;
    private String cadastralId;
    private Double area;
    private List<Beneficiary> beneficiaries;
    private Point[] points;

    public Property() {
        this.beneficiaries = new ArrayList<>();
        this.points = new Point[4];
    }

    public Property(Builder builder) {
        this.code = builder.code;
        this.cadastralId = builder.cadastralId;
        this.area = builder.area;
        this.beneficiaries = builder.beneficiaries;
        this.points = builder.points;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Code= " + code +
                "\nCadastral Id= " + cadastralId +
                "\nArea= " + area +
                "\nBeneficiaries= " + beneficiaries +
                "\nPoints= " + Arrays.toString(points);
    }

    public static class Builder {

        private long code;
        private String cadastralId;
        private Double area;
        private List<Beneficiary> beneficiaries;
        private Point[] points;

        public Builder code(long code) {
            this.code = code;
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

        public Builder beneficiaries(List<Beneficiary> beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        public Builder points(Point[] points) {
            this.points = points;
            return this;
        }

        public Property build() {
            return new Property(this);
        }

    }

}
