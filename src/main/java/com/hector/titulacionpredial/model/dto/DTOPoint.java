package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOPoint {

    private int numberPoint;
    private Double northCoordinate;
    private Double eastCoordinate;
    private Double distance;
    private String hillside;

    public DTOPoint() {

    }

    public DTOPoint(Builder<?> builder) {
        this.numberPoint = builder.numberPoint;
        this.northCoordinate = builder.northCoordinate;
        this.eastCoordinate = builder.eastCoordinate;
        this.distance = builder.distance;
        this.hillside = builder.hillside;
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

    public static class Builder<T extends Builder<T>> {

        private int numberPoint;
        private Double northCoordinate;
        private Double eastCoordinate;
        private Double distance;
        private String hillside;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T numberPoint(int numberPoint) {
            this.numberPoint = numberPoint;
            return self();
        }

        public T northCoordinate(Double northCoordinate) {
            this.northCoordinate = northCoordinate;
            return self();
        }

        public T eastCoordinate(Double eastCoordinate) {
            this.eastCoordinate = eastCoordinate;
            return self();
        }

        public T distance(Double distance) {
            this.distance = distance;
            return self();
        }

        public T hillside(String hillside) {
            this.hillside = hillside;
            return self();
        }

        public DTOPoint build() {
            return new DTOPoint(this);
        }

    }

}
