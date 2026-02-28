package com.hector.titulacionpredial.model.entities;

/**
 * Entidad que representa una coordenada geográfica asociada
 * a un {@link Property}.
 *
 * <p>
 * Define un punto que forma parte de los límites del predio,
 * incluyendo sus coordenadas y datos complementarios.
 * </p>
 *
 * <p>
 * Esta clase:
 * </p>
 * <ul>
 *     <li>Posee identidad propia mediante el atributo {@code code}.</li>
 *     <li>Contiene coordenadas norte y este.</li>
 *     <li>Puede incluir información adicional como distancia y linderos.</li>
 *     <li>Es mutable mediante métodos setter.</li>
 *     <li>Soporta construcción mediante el patrón {@link Builder}.</li>
 * </ul>
 *
 * <p>
 * Su ciclo de vida depende del {@link Property} al que pertenece.
 * </p>
 *
 * @author Hector Acevedo
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
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos basados en reflexión.
     */
    public Point() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia del constructor paso a paso
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
     * Representación textual de la entidad.
     *
     * @return descripción formateada de los atributos principales
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
     * Builder para la construcción controlada de instancias de {@link Point}.
     *
     * <p>
     * Permite configurar de forma fluida los atributos del predio antes
     * de su creación definitiva mediante {@link #build()}.
     * </p>
     *
     * <p>
     * No realiza validaciones automáticas; dichas reglas deben
     * garantizarse en la capa de servicio o agregarse explícitamente.
     * </p>
     */
    public static class Builder {

        private int code;
        private int numberPoint;
        private Double northCoordinate;
        private Double eastCoordinate;
        private Double distance;
        private String hillside;

        /**
         * Establece el código del punto.
         *
         * @param code código único
         * @return builder actual
         */
        public Builder code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Establece el número de punto.
         *
         * @param numberPoint número secuencial del punto
         * @return builder actual
         */
        public Builder numberPoint(int numberPoint) {
            this.numberPoint = numberPoint;
            return this;
        }

        /**
         * Establece la coordenada norte.
         *
         * @param northCoordinate coordenada norte
         * @return builder actual
         */
        public Builder northCoordinate(Double northCoordinate) {
            this.northCoordinate = northCoordinate;
            return this;
        }

        /**
         * Establece la coordenada este.
         *
         * @param eastCoordinate coordenada este
         * @return builder actual
         */
        public Builder eastCoordinate(Double eastCoordinate) {
            this.eastCoordinate = eastCoordinate;
            return this;
        }

        /**
         * Establece la distancia al siguiente punto.
         *
         * @param distance distancia en metros
         * @return builder actual
         */
        public Builder distance(Double distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Establece el lindero.
         *
         * @param hillside descripción del lindero
         * @return builder actual
         */
        public Builder hillside(String hillside) {
            this.hillside = hillside;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link Point}.
         *
         * @return nuevo punto construido
         */
        public Point build() {
            return new Point(this);
        }

    }

}
