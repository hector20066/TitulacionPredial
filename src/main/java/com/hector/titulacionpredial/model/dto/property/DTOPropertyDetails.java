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

    /**     * get property code.     * @return the get property code     */
    public int getPropertyCode() {
        return propertyCode;
    }

    /**     * set property code.     * @param propertyCode the property code     */
    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    /**     * get code beneficiaries.     * @return the get code beneficiaries     */
    public String getCodeBeneficiaries() {
        return codeBeneficiaries;
    }

    /**     * set code beneficiaries.     * @param codeBeneficiaries the code beneficiaries     */
    public void setCodeBeneficiaries(String codeBeneficiaries) {
        this.codeBeneficiaries = codeBeneficiaries;
    }

    /**     * get beneficiaries ids.     * @return the get beneficiaries ids     */
    public String getBeneficiariesIds() {
        return beneficiariesIds;
    }

    /**     * set beneficiaries ids.     * @param beneficiariesIds the beneficiaries ids     */
    public void setBeneficiariesIds(String beneficiariesIds) {
        this.beneficiariesIds = beneficiariesIds;
    }

    /**     * get beneficiaries name.     * @return the get beneficiaries name     */
    public String getBeneficiariesName() {
        return beneficiariesName;
    }

    /**     * set beneficiaries name.     * @param beneficiariesName the beneficiaries name     */
    public void setBeneficiariesName(String beneficiariesName) {
        this.beneficiariesName = beneficiariesName;
    }

    public List<DTOPoint> getPoints() {
        return points;
    }

    /**     * set points.     * @param points the points     */
    public void setPoints(List<DTOPoint> points) {
        this.points = points;
    }

    /**     * get num resolution.     * @return the get num resolution     */
    public long getNumResolution() {
        return numResolution;
    }

    /**     * set num resolution.     * @param numResolution the num resolution     */
    public void setNumResolution(long numResolution) {
        this.numResolution = numResolution;
    }

    /**     * get notification.     * @return the get notification     */
    public LocalDate getNotification() {
        return notification;
    }

    /**     * set notification.     * @param notification the notification     */
    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    /**     * get executory.     * @return the get executory     */
    public LocalDate getExecutory() {
        return executory;
    }

    /**     * set executory.     * @param executory the executory     */
    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    /**     * get fmi.     * @return the get fmi     */
    public String getFmi() {
        return fmi;
    }

    /**     * set fmi.     * @param fmi the fmi     */
    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    /**     * get act.     * @return the get act     */
    public String getAct() {
        return act;
    }

    /**     * set act.     * @param act the act     */
    public void setAct(String act) {
        this.act = act;
    }

    /**     * get public writing.     * @return the get public writing     */
    public String getPublicWriting() {
        return publicWriting;
    }

    /**     * set public writing.     * @param publicWriting the public writing     */
    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    /**     * get notary.     * @return the get notary     */
    public String getNotary() {
        return notary;
    }

    /**     * set notary.     * @param notary the notary     */
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

    /**     * property code.     * @param propertyCode the property code     * @return the property code     */
        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

    /**     * beneficiaries ids.     * @param beneficiariesIds the beneficiaries ids     * @return the beneficiaries ids     */
        public Builder beneficiariesIds(String beneficiariesIds) {
            this.beneficiariesIds = beneficiariesIds;
            return this;
        }

    /**     * code beneficiaries.     * @param codeBeneficiaries the code beneficiaries     * @return the code beneficiaries     */
        public Builder codeBeneficiaries(String codeBeneficiaries) {
            this.codeBeneficiaries = codeBeneficiaries;
            return this;
        }

    /**     * beneficiaries name.     * @param beneficiariesName the beneficiaries name     * @return the beneficiaries name     */
        public Builder beneficiariesName(String beneficiariesName) {
            this.beneficiariesName = beneficiariesName;
            return this;
        }

    /**     * points.     * @param points the points     * @return the points     */
        public Builder points(List<DTOPoint> points) {
            this.points = points;
            return this;
        }

    /**     * num resolution.     * @param numResolution the num resolution     * @return the num resolution     */
        public Builder numResolution(long numResolution) {
            this.numResolution = numResolution;
            return this;
        }

    /**     * notification.     * @param notification the notification     * @return the notification     */
        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

    /**     * executory.     * @param executory the executory     * @return the executory     */
        public Builder executory(LocalDate executory) {
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

    /**     * build.     * @return the build     */
        public DTOPropertyDetails build() {
            return new DTOPropertyDetails(this);
        }

    }

}
