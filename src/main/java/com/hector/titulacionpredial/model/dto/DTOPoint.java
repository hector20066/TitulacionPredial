package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) base that contains information of a point
 * for input or output operations with respect to the coordinates of
 * {@code Property}.
 *
 * <p>
 * It is used to transport data between the presentation layer and the
 * persistence layer, avoiding directly exposing the {@code Point} entity.
 * </p>
 *
 * <p>
 * It contains information related to the location of the property,
 * handling the coordinates and the {@code Property} code to which
 * the point belongs.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its sole
 * purpose is to encapsulate data.
 * </p>
 *
 * <p>
 * It supports fluid construction using the {@link Builder} pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOPoint {

    /**
     * Associated point number.
     */
    protected int numberPoint;

    /**
     * North coordinate.
     */
    protected Double northCoordinate;

    /**
     * East coordinate.
     */
    protected Double eastCoordinate;

    /**
     * Distance from the next point.
     */
    protected Double distance;

    /**
     * Data of the neighboring boundary to the point.
     */
    protected String hillside;

    /**
     * {@code Property} code.
     */
    protected int propertyCode;

    /**
     * Empty constructor required for serialization or
     * mapping frameworks.
     */
    public DTOPoint() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOPoint(Builder builder) {
        this.numberPoint = builder.numberPoint;
        this.northCoordinate = builder.northCoordinate;
        this.eastCoordinate = builder.eastCoordinate;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.propertyCode = builder.propertyCode;
    }

    public int getNumberPoint() {
        return numberPoint;
    }

    public void setNumberPoint(int numberPoint) {
        this.numberPoint = numberPoint;
    }

    public Double getNorthCoordinate() {
        return northCoordinate;
    }

    public void setNorthCoordinate(Double northCoordinate) {
        this.northCoordinate = northCoordinate;
    }

    public Double getEastCoordinate() {
        return eastCoordinate;
    }

    public void setEastCoordinate(Double eastCoordinate) {
        this.eastCoordinate = eastCoordinate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getHillside() {
        return hillside;
    }

    public void setHillside(String hillside) {
        this.hillside = hillside;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    /**
     * Builder for seamless construction of {@link DTOPoint} instances
     *
     * <p>
     * It allows you to configure the attributes before invoking
     * {@link #build()}.
     * </p>
     */
    public static class Builder {

        private int numberPoint;
        private Double northCoordinate;
        private Double eastCoordinate;
        private Double distance;
        private String hillside;
        private int propertyCode;

        public Builder numberPoint(int numberPoint) {
            this.numberPoint = numberPoint;
            return this;
        }

        public Builder northCoordinate(Double northCoordinate) {
            this.northCoordinate = northCoordinate;
            return this;
        }

        public Builder eastCoordinate(Double eastCoordinate) {
            this.eastCoordinate = eastCoordinate;
            return this;
        }

        public Builder distance(Double distance) {
            this.distance = distance;
            return this;
        }

        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public DTOPoint build() {
            return new DTOPoint(this);
        }

    }

}
