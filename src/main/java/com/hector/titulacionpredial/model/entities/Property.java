package com.hector.titulacionpredial.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Entidad de dominio que representa un Predio dentro del sistema
 * de Titulación Predial.
 *
 * <p>
 * Un predio constituye la unidad principal del proceso de titulación
 * y actúa como agregado raíz (Aggregate Root) dentro del modelo.
 * </p>
 *
 * <p>
 * Esta entidad:
 * </p>
 * <ul>
 *     <li>Posee identidad propia mediante el atributo {@code code}.</li>
 *     <li>Contiene una colección de {@link Beneficiary} asociados.</li>
 *     <li>Define un conjunto de {@link Point} que representan los límites geográficos.</li>
 *     <li>Es mutable mediante métodos setter.</li>
 *     <li>Soporta construcción mediante el patrón {@link Builder}.</li>
 * </ul>
 *
 * <p>
 * Forma parte del modelo persistente y mantiene consistencia
 * sobre sus entidades relacionadas.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class Property {

    private long code;
    private String cadastralId;
    private Double area;
    private List<Beneficiary> beneficiaries;
    private Point[] points;

    /**
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos basados en reflexión.
     *
     * <p>
     * Inicializa la colección de beneficiarios y el arreglo de puntos
     * para evitar referencias nulas.
     * </p>
     */
    public Property() {
        this.beneficiaries = new ArrayList<>();
        this.points = new Point[4];
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia del constructor paso a paso
     */
    public Property(Builder builder) {
        this.code = builder.code;
        this.cadastralId = builder.cadastralId;
        this.area = builder.area;
        this.beneficiaries = builder.beneficiaries;
        this.points = builder.points;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    /**
     * Representación textual de la entidad.
     *
     * @return descripción formateada de los atributos principales
     */
    @Override
    public String toString() {
        return "Code= " + code +
                "\nCadastral Id= " + cadastralId +
                "\nArea= " + area +
                "\nBeneficiaries= " + beneficiaries +
                "\nPoints= " + Arrays.toString(points);
    }

    /**
     * Builder para la construcción controlada de instancias de {@link Property}.
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

        private long code;
        private String cadastralId;
        private Double area;
        private List<Beneficiary> beneficiaries;
        private Point[] points;

        /**
         * Establece el código del predio.
         *
         * @param code código único
         * @return builder actual
         */
        public Builder code(long code) {
            this.code = code;
            return this;
        }

        /**
         * Establece la cédula catastral.
         *
         * @param cadastralId cédula catastral
         * @return builder actual
         */
        public Builder cadastralId(String cadastralId) {
            this.cadastralId = cadastralId;
            return this;
        }

        /**
         * Establece el área del predio.
         *
         * @param area área en metros cuadrados
         * @return builder actual
         */
        public Builder area(Double area) {
            this.area = area;
            return this;
        }

        /**
         * Establece la lista de beneficiarios.
         *
         * @param beneficiaries lista de beneficiarios asociados
         * @return builder actual
         */
        public Builder beneficiaries(List<Beneficiary> beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        /**
         * Establece los puntos geográficos del predio.
         *
         * @param points arreglo de puntos
         * @return builder actual
         */
        public Builder points(Point[] points) {
            this.points = points;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link Property}.
         *
         * @return nuevo predio construido
         */
        public Property build() {
            return new Property(this);
        }

    }

}
