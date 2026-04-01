package com.hector.titulacionpredial.model.dto.property;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) that represents the complete details
 * of a property within the system.
 *
 * <p>
 * This class is used to transport information from the persistence
 * or service layer to the presentation layer, encapsulating property
 * data along with associated information such as beneficiaries,
 * geographic points, and resolution data.
 * </p>
 *
 * <p>
 * Extends {@link DTOProperty} by adding additional attributes needed
 * to display detailed property information, avoiding directly exposing
 * the domain entity.
 * </p>
 *
 * <p><strong>Includes:</strong></p>
 * <ul>
 *     <li>Internal property identifier.</li>
 *     <li>Concatenated beneficiary IDs and names.</li>
 *     <li>List of points that define the geometry of the property.</li>
 *     <li>Information related to the administrative resolution.</li>
 * </ul>
 *
 * <p>
 * It is a mutable class and supports construction using the Builder
 * pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOPropertyDetails extends DTOProperty {

    private double area;
    private int propertyCode;
    private String codeBeneficiaries;
    private String beneficiariesIds;
    private String beneficiariesName;
    private List<DTOPoint> points;
    private long numResolution;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;

    /**
     * Empty constructor required for serialization or mapping
     * frameworks.
     */
    public DTOPropertyDetails() {
        super();
        this.points = new ArrayList<>();
    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOPropertyDetails(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
        this.codeBeneficiaries = builder.codeBeneficiaries;
        this.beneficiariesIds = builder.beneficiariesIds;
        this.beneficiariesName = builder.beneficiariesName;
        this.points = builder.points;
        this.numResolution = builder.numResolution;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
        this.area = builder.area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getCodeBeneficiaries() {
        return codeBeneficiaries;
    }

    public void setCodeBeneficiaries(String codeBeneficiaries) {
        this.codeBeneficiaries = codeBeneficiaries;
    }

    public String getBeneficiariesIds() {
        return beneficiariesIds;
    }

    public void setBeneficiariesIds(String beneficiariesIds) {
        this.beneficiariesIds = beneficiariesIds;
    }

    public String getBeneficiariesName() {
        return beneficiariesName;
    }

    public void setBeneficiariesName(String beneficiariesName) {
        this.beneficiariesName = beneficiariesName;
    }

    public List<DTOPoint> getPoints() {
        return points;
    }

    public void setPoints(List<DTOPoint> points) {
        this.points = points;
    }

    public long getNumResolution() {
        return numResolution;
    }

    public void setNumResolution(long numResolution) {
        this.numResolution = numResolution;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**
     * Implementation of the Builder pattern for controlled and
     * incremental construction of {@code DTOPropertyDetails}
     * instances.
     *
     * <p>
     * It allows you to create complex objects in a readable way
     * and avoids constructors with multiple parameters.
     * </p>
     *
     * <pre>
     * DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
     *      .propertyCode(1)
     *      .cadastralId("123-456")
     *      .area(1500.0)
     *      .numResolution(2023001L)
     *      .build();
     * </pre>
     */
    public static class Builder extends DTOProperty.Builder<Builder> {

        private double area;
        private int propertyCode;
        private String codeBeneficiaries;
        private String beneficiariesIds;
        private String beneficiariesName;
        private List<DTOPoint> points = new ArrayList<>();
        private long numResolution;
        private LocalDate notification;
        private LocalDate executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;

        public Builder area(double area) {
            this.area = area;
            return this;
        }

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public Builder beneficiariesIds(String beneficiariesIds) {
            this.beneficiariesIds = beneficiariesIds;
            return this;
        }

        public Builder codeBeneficiaries(String codeBeneficiaries) {
            this.codeBeneficiaries = codeBeneficiaries;
            return this;
        }

        public Builder beneficiariesName(String beneficiariesName) {
            this.beneficiariesName = beneficiariesName;
            return this;
        }

        public Builder points(List<DTOPoint> points) {
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
