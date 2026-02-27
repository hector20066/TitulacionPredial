package com.hector.titulacionpredial.model.dto;

/**
 * Data Transfer Object (DTO) base que contiene información
 * de un punto para operaciones de entrada o salida con respecto
 * a las coordenadas de {@code Property}.
 *
 * <p>
 * Se utiliza para transportar datos entre la capa de presentación y
 * la capa de persistencia, evitando exponer directamente la entidad
 * {@code Point}.
 * </p>
 *
 * <p>
 * Contiene la información relacionada con la ubicación del predio,
 * manejando las coordenadas y el código de {@code Property} al cual
 * pertenece el punto.
 * </p>
 *
 * <p>
 * Este DTO no contiene lógica de negocio ni reglas de validación.
 * Su única responsabilidad es encapsular datos.
 * </p>
 *
 * <p>
 * Soporta construcción fluida mediante el patron {@link Builder}.
 * </p>
 *
 * @author hectoracevedo
 * @since 1.0
 */
public class DTOPoint {

    /**
     * Numero del punto asociada
     */
    protected int numberPoint;

    /**
     * Coordenada norte
     */
    protected Double northCoordinate;

    /**
     * Coordenada Este
     */
    protected Double eastCoordinate;

    /**
     * Distancia con respecto al siguiente punto
     */
    protected Double distance;

    /**
     * Datos del lindero vecino al punto
     */
    protected String hillside;

    /**
     * Código de {@code Property}
     */
    protected int propertyCode;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOPoint() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
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
     * Builder para la construcción fluida de instancias de {@link DTOPoint}
     *
     * <p>
     * Permite configurar los atributos antes de invocar
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

        /**
         * Construye una nueva instancia de {@link DTOPoint}.
         *
         * @return nuevo DTO configurado
         */
        public DTOPoint build() {
            return new DTOPoint(this);
        }

    }

}
