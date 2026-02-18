package com.hector.titulacionpredial.model.dto;

/**
 *
 * @author hectoracevedo
 */
public class DTOProperty {

    private long cadastralId;
    private Double area;

    public DTOProperty() {

    }

    public DTOProperty(Builder builder) {
        this.cadastralId = builder.cadastralId;
        this.area = builder.area;
    }

    public void setCadastralId(long cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public long getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public static class Builder {

        private long cadastralId;
        private Double area;

        public Builder cadastralId(long cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

        public Builder area(Double area) {
            this.area = area;
            return this;
        }

        public DTOProperty build() {
            return new DTOProperty(this);
        }

    }

}
