package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.DTOProperty;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) que representa el detalle completo
 * de un predio dentro del sistema.
 *
 * <p>
 * Esta clase se utiliza para transportar información desde la
 * capa de persistencia o servicio hacia la capa de presentación,
 * encapsulando datos del predio junto con información asociada
 * como beneficiarios, puntos geográficos y datos de resolución.
 * </p>
 *
 * <p>
 * Extiende {@link DTOProperty} agregando atributos adicionales
 * necesarios para mostrar información detallada del predio,
 * evitando exponer directamente la entidad de dominio.
 * </p>
 *
 * <p><strong>Incluye:</strong></p>
 * <ul>
 *     <li>Identificador interno del predio.</li>
 *     <li>Lista de beneficiarios asociados.</li>
 *     <li>Lista de puntos que definen la geometría del predio.</li>
 *     <li>Información relacionada con la resolución administrativa.</li>
 * </ul>
 *
 * <p>
 *     Es una clase mutable y soporta construcción mediante el patrón Builder.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class DTOPropertyDetails extends DTOProperty {

    private int propertyCode;
    private List<DTOBeneficiaryPropertyDetails> beneficiaries;
    private List<DTOPoint> points;
    private long numResolution;
    private LocalDate notification;
    private LocalDate executory;
    private String fmi;
    private String act;
    private String publicWriting;
    private String notary;

    /**
     * Constructor vacío requerido para frameworks
     * de serialización o mapeo.
     */
    public DTOPropertyDetails() {
        super();
        this.beneficiaries = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public DTOPropertyDetails(Builder builder) {
        super(builder.cadastralId, builder.area);
        this.propertyCode = builder.propertyCode;
        this.beneficiaries = builder.beneficiaries;
        this.points = builder.points;
        this.numResolution = builder.numResolution;
        this.notification = builder.notification;
        this.executory = builder.executory;
        this.fmi = builder.fmi;
        this.act = builder.act;
        this.publicWriting = builder.publicWriting;
        this.notary = builder.notary;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public List<DTOBeneficiaryPropertyDetails> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<DTOBeneficiaryPropertyDetails> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public List<DTOPoint> getPoints() {
        return points;
    }

    public void setPoints(List<DTOPoint> points) {
        this.points = points;
    }

    public long getNumResolution() {
        return numResolution;
    }

    public void setNumResolution(long numResolution) {
        this.numResolution = numResolution;
    }

    public LocalDate getNotification() {
        return notification;
    }

    public void setNotification(LocalDate notification) {
        this.notification = notification;
    }

    public LocalDate getExecutory() {
        return executory;
    }

    public void setExecutory(LocalDate executory) {
        this.executory = executory;
    }

    public String getFmi() {
        return fmi;
    }

    public void setFmi(String fmi) {
        this.fmi = fmi;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPublicWriting() {
        return publicWriting;
    }

    public void setPublicWriting(String publicWriting) {
        this.publicWriting = publicWriting;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    /**
     * Implementación del patrón Builder para la construcción
     * controlada e incremental de instancias de {@code DTOPropertyDetails}.
     *
     * <p>
     * Permite crear objetos complejos de manera legible y
     * evitando constructores con múltiples parámetros.
     * </p>
     *
     * <pre>
     * DTOPropertyDetails dto = new DTOPropertyDetails.Builder()
     *      .propertyCode(1)
     *      .cadastralId("123-456")
     *      .area(1500.0)
     *      .numResolution(2023001L)
     *      .build();
     * </pre>
     */
    public static class Builder {

        private int propertyCode;
        private String cadastralId;
        private Double area;
        private List<DTOBeneficiaryPropertyDetails> beneficiaries = new ArrayList<>();
        private List<DTOPoint> points = new ArrayList<>();
        private long numResolution;
        private LocalDate notification;
        private LocalDate executory;
        private String fmi;
        private String act;
        private String publicWriting;
        private String notary;

        /**
         * Establece el código del predio.
         *
         * @param propertyCode código del predio
         * @return builder actual
         */
        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        /**
         * Establece el identificador catastral.
         *
         * @param cadastralId identificador catastral
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
         * Establece la lista de beneficiarios del predio.
         *
         * @param beneficiaries lista de beneficiarios
         * @return builder actual
         */
        public Builder beneficiaries(List<DTOBeneficiaryPropertyDetails> beneficiaries) {
            this.beneficiaries = beneficiaries;
            return this;
        }

        /**
         * Establece la lista de puntos geográficos.
         *
         * @param points lista de coordenadas
         * @return builder actual
         */
        public Builder points(List<DTOPoint> points) {
            this.points = points;
            return this;
        }

        /**
         * Establece el número de resolución.
         *
         * @param numResolution número de resolución
         * @return builder actual
         */
        public Builder numResolution(long numResolution) {
            this.numResolution = numResolution;
            return this;
        }

        /**
         * Establece la fecha de notificación.
         *
         * @param notification fecha de notificación
         * @return builder actual
         */
        public Builder notification(LocalDate notification) {
            this.notification = notification;
            return this;
        }

        /**
         * Establece la fecha de ejecutoria.
         *
         * @param executory fecha de ejecutoria
         * @return builder actual
         */
        public Builder executory(LocalDate executory) {
            this.executory = executory;
            return this;
        }

        /**
         * Establece el Folio de Matrícula Inmobiliaria.
         *
         * @param fmi número FMI
         * @return builder actual
         */
        public Builder fmi(String fmi) {
            this.fmi = fmi;
            return this;
        }

        /**
         * Establece el número de acta.
         *
         * @param act número de acta
         * @return builder actual
         */
        public Builder act(String act) {
            this.act = act;
            return this;
        }

        /**
         * Establece el número de escritura pública.
         *
         * @param publicWriting número de escritura pública
         * @return builder actual
         */
        public Builder publicWriting(String publicWriting) {
            this.publicWriting = publicWriting;
            return this;
        }

        /**
         * Establece la notaría.
         *
         * @param notary nombre de la notaría
         * @return builder actual
         */
        public Builder notary(String notary) {
            this.notary = notary;
            return this;
        }

        /**
         * Construye una nueva instancia de {@link DTOPropertyDetails}.
         *
         * @return nuevo DTO configurado
         */
        public DTOPropertyDetails build() {
            return new DTOPropertyDetails(this);
        }

    }

}
