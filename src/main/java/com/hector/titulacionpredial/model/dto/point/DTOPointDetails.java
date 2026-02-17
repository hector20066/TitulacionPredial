package com.hector.titulacionpredial.model.dto.point;

public class DTOPointDetails {

    private int numberPoint;
    private Double northCoordinate;
    private Double eastCoordinate;
    private Double distance;
    private String hillside;

    public DTOPointDetails() {

    }

    public DTOPointDetails(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside) {
        this.numberPoint = numberPoint;
        this.northCoordinate = northCoordinate;
        this.eastCoordinate = eastCoordinate;
        this.distance = distance;
        this.hillside = hillside;
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
    
}
