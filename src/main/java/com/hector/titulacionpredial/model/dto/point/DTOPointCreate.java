package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.entities.Property;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointCreate {

    private int numberPoint;
    private Double northCoordinate;
    private Double eastCoordinate;
    private Double distance;
    private String hillside;
    private Property property;

    public DTOPointCreate() {

    }

    public DTOPointCreate(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside, Property property) {
        this.numberPoint = numberPoint;
        this.northCoordinate = northCoordinate;
        this.eastCoordinate = eastCoordinate;
        this.distance = distance;
        this.hillside = hillside;
        this.property = property;
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

    public void setProperty(Property property) {
        this.property = property;
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

    public Property getProperty() {
        return property;
    }
    
}
