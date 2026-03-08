package com.hector.titulacionpredial.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Domain entity that represents a property within the Land Titling
 * system.
 *
 * <p>
 * A property constitutes the main unit of the titling process and
 * acts as the Aggregate Root within the model.
 * </p>
 *
 * <p>
 * This entity:
 * </p>
 * <ul>
 *     <li>It has its own identity through the attribute {@code code}.</li>
 *     <li>It contains a collection of associated {@link Beneficiary}.</li>
 *     <li>Define a set of {@link Point} that represent the geographic boundaries.</li>
 *     <li>It is mutable through setter methods.</li>
 *     <li>It supports building using the {@link Builder} pattern.</li>
 * </ul>
 *
 * <p>
 * It is part of the persistent model and maintains consistency across
 * its related entities.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Property {

    private long code;
    private String cadastralId;
    private Double area;
    private List<Beneficiary> beneficiaries;
    private Point[] points;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection-based mechanisms.
     *
     * <p>
     * Initialize the beneficiary collection and the point array
     * to avoid null references.
     * </p>
     */
    public Property() {
        this.beneficiaries = new ArrayList<>();
        this.points = new Point[4];
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder step-by-step constructor instance
     */
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

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    public String toString() {
        return "Code= " + code +
                "\nCadastral Id= " + cadastralId +
                "\nArea= " + area +
                "\nBeneficiaries= " + beneficiaries +
                "\nPoints= " + Arrays.toString(points);
    }

    /**
     * Builder for controlled construction of {@link Property} instances.
     *
     * <p>
     * It allows you to smoothly configure the property attributes before
     * its final creation using {@link #build()}.
     * </p>
     *
     * <p>
     * It does not perform automatic validations such rules must be
     * guaranteed in the service layer or added explicitly.
     * </p>
     */
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
