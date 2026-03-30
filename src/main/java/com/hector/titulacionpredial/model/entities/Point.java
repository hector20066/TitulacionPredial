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

    /**     * get code.     * @return the get code     */
    public int getCode() {
        return code;
    }

    /**     * set code.     * @param code the code     */
    public void setCode(int code) {
        this.code = code;
    }

    /**     * get number point.     * @return the get number point     */
    public int getNumberPoint() {
        return numberPoint;
    }

    /**     * set number point.     * @param numberPoint the number point     */
    public void setNumberPoint(int numberPoint) {
        this.numberPoint = numberPoint;
    }

    /**     * get north coordinate.     * @return the get north coordinate     */
    public Double getNorthCoordinate() {
        return northCoordinate;
    }

    /**     * set north coordinate.     * @param northCoordinate the north coordinate     */
    public void setNorthCoordinate(Double northCoordinate) {
        this.northCoordinate = northCoordinate;
    }

    /**     * get east coordinate.     * @return the get east coordinate     */
    public Double getEastCoordinate() {
        return eastCoordinate;
    }

    /**     * set east coordinate.     * @param eastCoordinate the east coordinate     */
    public void setEastCoordinate(Double eastCoordinate) {
        this.eastCoordinate = eastCoordinate;
    }

    /**     * get distance.     * @return the get distance     */
    public Double getDistance() {
        return distance;
    }

    /**     * set distance.     * @param distance the distance     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**     * get hillside.     * @return the get hillside     */
    public String getHillside() {
        return hillside;
    }

    /**     * set hillside.     * @param hillside the hillside     */
    public void setHillside(String hillside) {
        this.hillside = hillside;
    }

    /**
     * Textual representation of the entity.
     *
     * @return formatted description of the main attributes
     */
    @Override
    /**     * to string.     * @return the to string     */
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

    /**     * code.     * @param code the code     * @return the code     */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

    /**     * number point.     * @param numberPoint the number point     * @return the number point     */
        public Builder numberPoint(int numberPoint) {
            this.numberPoint = numberPoint;
            return this;
        }

    /**     * north coordinate.     * @param northCoordinate the north coordinate     * @return the north coordinate     */
        public Builder northCoordinate(Double northCoordinate) {
            this.northCoordinate = northCoordinate;
            return this;
        }

    /**     * east coordinate.     * @param eastCoordinate the east coordinate     * @return the east coordinate     */
        public Builder eastCoordinate(Double eastCoordinate) {
            this.eastCoordinate = eastCoordinate;
            return this;
        }

    /**     * distance.     * @param distance the distance     * @return the distance     */
        public Builder distance(Double distance) {
            this.distance = distance;
            return this;
        }

    /**     * hillside.     * @param hillside the hillside     * @return the hillside     */
        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

    /**     * build.     * @return the build     */
        public Point build() {
            return new Point(this);
        }

    }

}
