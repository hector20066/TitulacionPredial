package com.hector.titulacionpredial.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

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
    private String cadastralRef;
    private Double area;
    private Department department;
    private Municipalities municipality;
    private String neighborhood;
    private String address;
    private String crossing;
    private String publication;
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
        this.cadastralRef = builder.cadastralRef;
        this.area = builder.area;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.address = builder.address;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
        this.beneficiaries = builder.beneficiaries;
        this.points = builder.points;
    }

    /**     * get code.     * @return the get code     */
    public long getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(long code) {
        this.code = code;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

    /**     * get area.     * @return the get area     */
    public Double getArea() {
        return area;
    }

    /**     * set area.     * @param area the area     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**     * get department.     * @return the get department     */
    public Department getDepartment() {
        return department;
    }

    /**     * set department.     * @param department the department     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**     * get municipality.     * @return the get municipality     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**     * set municipality.     * @param municipality the municipality     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**     * get neighborhood.     * @return the get neighborhood     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**     * set neighborhood.     * @param neighborhood the neighborhood     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * set address.     * @param address the address     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**     * get crossing.     * @return the get crossing     */
    public String getCrossing() {
        return crossing;
    }

    /**     * set crossing.     * @param crossing the crossing     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**     * get publication.     * @return the get publication     */
    public String getPublication() {
        return publication;
    }

    /**     * set publication.     * @param publication the publication     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    /**     * set beneficiaries.     * @param beneficiaries the beneficiaries     */
    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    /**     * get points.     * @return the get points     */
    public Point[] getPoints() {
        return points;
    }

    /**     * set points.     * @param points the points     */
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
                "\nCadastral Reference= " + cadastralRef +
                "\nArea= " + area +
                "\nDepartment= " + department +
                "\nMunicipality= " + municipality +
                "\nNeighborhood= " + neighborhood +
                "\nAddress= " + address +
                "\nCrossing= " + crossing +
                "\nPublication= " + publication +
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
        private String cadastralRef;
        private Double area;
        private Department department;
        private Municipalities municipality;
        private String neighborhood;
        private String address;
        private String crossing;
        private String publication;
        private List<Beneficiary> beneficiaries;
        private Point[] points;

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(long code) {
            this.code = code;
            return this;
        }

    /**     * cadastral id.     * @param cadastralId the cadastral id     * @return the cadastral id     */
        public Builder cadastralId(String cadastralId) {
            this.cadastralRef = cadastralId;
            return this;
        }

    /**     * area.     * @param area the area     * @return the area     */
        public Builder area(Double area) {
            this.area = area;
            return this;
        }

    /**     * department.     * @param department the department     * @return the department     */
        public Builder department(Department department) {
            this.department = department;
            return this;
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public Builder municipality(Municipalities municipality) {
            this.municipality = municipality;
            return this;
        }

    /**     * neighborhood.     * @param neighborhood the neighborhood     * @return the neighborhood     */
        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

    /**     * address.     * @param address the address     * @return the address     */
        public Builder address(String address) {
            this.address = address;
            return this;
        }

    /**     * crossing.     * @param crossing the crossing     * @return the crossing     */
        public Builder crossing(String crossing) {
            this.crossing = crossing;
            return this;
        }

    /**     * publication.     * @param publication the publication     * @return the publication     */
        public Builder publication(String publication) {
            this.publication = publication;
            return this;
        }

    /**     * beneficiaries.     * @param beneficiaries the beneficiaries     * @return the beneficiaries     */
        public Builder beneficiaries(List<Beneficiary> beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

    /**     * points.     * @param points the points     * @return the points     */
        public Builder points(Point[] points) {
            this.points = points;
            return this;
        }

    /**     * build.     * @return the build     */
        public Property build() {
            return new Property(this);
        }

    }

}
