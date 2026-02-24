package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOPoint {

    protected int numberPoint;
    protected Double northCoordinate;
    protected Double eastCoordinate;
    protected Double distance;
    protected String hillside;
    protected int propertyCode;

    public DTOPoint() {

    }

    public DTOPoint(Builder builder) {
        this.numberPoint = builder.numberPoint;
        this.northCoordinate = builder.northCoordinate;
        this.eastCoordinate = builder.eastCoordinate;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
        this.propertyCode = builder.propertyCode;
    }

    public void setNumberPoint(int numberPoint) {
        this.numberPoint = numberPoint;
    }

    public void setNorthCoordinate(Double northCoordinate) {
        this.northCoordinate = northCoordinate;
    }

    public void setEastCoordinate(Double eastCoordinate) {
        this.eastCoordinate = eastCoordinate;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setHillside(String hillside) {
        this.hillside = hillside;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getNumberPoint() {
        return numberPoint;
    }

    public Double getNorthCoordinate() {
        return northCoordinate;
    }

    public Double getEastCoordinate() {
        return eastCoordinate;
    }

    public Double getDistance() {
        return distance;
    }

    public String getHillside() {
        return hillside;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

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
            return  this;
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
