package com.hector.titulacionpredial.model.entities;

/**
 * Entity that represents a geographic coordinate associated
 * with a {@link Property}.
 *
 * <p>
 * Define a point that is part of the boundaries of the property,
 * including its coordinates and additional data.
 * </p>
 *
 * <p>
 * This class:
 * </p>
 * <ul>
 *     <li>It has its own identity through the attribute {@code code}.</li>
 *     <li>It contains north and east coordinates.</li>
 *     <li>It may include additional information such as distance and boundaries.</li>
 *     <li>It is mutable through setter methods.</li>
 *     <li>It supports building using the {@link Builder} pattern.</li>
 * </ul>
 *
 * <p>
 * Its lifecycle depends on the {@link Property} it belongs to.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Point {

    private int code;
    private int numberPoint;
    private Double northCoordinate;
    private Double eastCoordinate;
    private Double distance;
    private String hillside;

    /**
     * Empty constructor required for persistence frameworks or
     * reflection-based mechanisms.
     */
    public Point() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder step-by-step constructor instance
     */
    public Point(Builder builder) {
        this.code = builder.code;
        this.numberPoint = builder.numberPoint;
        this.northCoordinate = builder.northCoordinate;
        this.eastCoordinate = builder.eastCoordinate;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    public String toString() {
        return "Code=" + code +
                "\nNumber Point= " + numberPoint +
                "\nNorth Coordinate= " + northCoordinate +
                "\nEast Coordinate= " + eastCoordinate +
                "\nDistance= " + distance +
                "\nHillside= " + hillside;
    }

    /**
     * Builder for the controlled construction of {@link Point} instances.
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

        private int code;
        private int numberPoint;
        private Double northCoordinate;
        private Double eastCoordinate;
        private Double distance;
        private String hillside;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

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

        public Point build() {
            return new Point(this);
        }

    }

}
