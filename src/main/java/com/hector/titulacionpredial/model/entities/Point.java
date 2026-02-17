package com.hector.titulacionpredial.model.entities;

/**
 *
 * @author hectoracevedo
 */
public class Point {

    private long code;
    private int numberPoint;
    private Double northCoordinate;
    private Double eastCoordinate;
    private Double distance;
    private String hillside;

    public Point() {

    }

    public Point(long code, int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside) {
        this.code = code;
        this.numberPoint = numberPoint;
        this.northCoordinate = northCoordinate;
        this.eastCoordinate = eastCoordinate;
        this.distance = distance;
        this.hillside = hillside;
    }

    public void setCode(long code) {
        this.code = code;
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

    public long getCode() {
        return code;
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

    @Override
    public String toString() {
        return  "Code=" + code +
                "\nNumber Point= " + numberPoint +
                "\nNorth Coordinate= " + northCoordinate +
                "\nEast Coordinate= " + eastCoordinate +
                "\nDistance= " + distance +
                "\nHillside= " + hillside;
    }

}
