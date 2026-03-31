package com.hector.titulacionpredial.model.dto;

import com.hector.titulacionpredial.model.enums.Department;
import com.hector.titulacionpredial.model.enums.Municipalities;

/**
 * Data Transfer Object (DTO) that represents the information of a
 * Property for entry or exit operations of the system.
 *
 * <p>
 * It is used to transport data between the presentation layer and
 * the persistence layer, avoiding direct exposure of the
 * {@code Property} entity.
 * </p>
 *
 * <p>
 * It contains the basic information of a property, such as the
 * cadastral certificate and the area of the property.
 * </p>
 *
 * <p>
 * This DTO contains no business logic or validation rules. Its
 * sole purpose is to encapsulate data.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOProperty {

    /**
     * Cadastral reference.
     */
    protected String cadastralRef;

    /**
     * Department.
     */
    protected Department department;

    /**
     * Municipality.
     */
    protected Municipalities municipality;

    /**
     * Neighborhood.
     */
    protected String neighborhood;

    /**
     * Address.
     */
    protected String address;

    /**
     * Information on administrative crossings.
     */
    protected String crossing;

    /**
     * Information related to official publications.
     */
    protected String publication;

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOProperty() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOProperty(Builder<?> builder) {
        this.cadastralRef = builder.cadastralRef;
        this.department = builder.department;
        this.municipality = builder.municipality;
        this.neighborhood = builder.neighborhood;
        this.address = builder.address;
        this.crossing = builder.crossing;
        this.publication = builder.publication;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

    /**     * get department.     * @return the get department     */
    public Department getDepartment() {
        return department;
    }

    /**     * set department.     * @param department the department     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**     * get municipality.     * @return the get municipality     */
    public Municipalities getMunicipality() {
        return municipality;
    }

    /**     * set municipality.     * @param municipality the municipality     */
    public void setMunicipality(Municipalities municipality) {
        this.municipality = municipality;
    }

    /**     * get neighborhood.     * @return the get neighborhood     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**     * set neighborhood.     * @param neighborhood the neighborhood     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**     * get address.     * @return the get address     */
    public String getAddress() {
        return address;
    }

    /**     * set address.     * @param address the address     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**     * get crossing.     * @return the get crossing     */
    public String getCrossing() {
        return crossing;
    }

    /**     * set crossing.     * @param crossing the crossing     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**     * get publication.     * @return the get publication     */
    public String getPublication() {
        return publication;
    }

    /**     * set publication.     * @param publication the publication     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    public static class Builder<T extends Builder<T>> {

        private String cadastralRef;
        private Department department;
        private Municipalities municipality;
        private String neighborhood;
        private String address;
        private String crossing;
        private String publication;

    /**     * self.     * @return the self     */
        protected T self() {
            return (T) this;
        }

    /**     * cadastral ref.     * @param cadastralRef the cadastral ref     * @return the cadastral ref     */
        public T cadastralRef(String cadastralRef) {
            this.cadastralRef = cadastralRef;
            return self();
        }

    /**     * department.     * @param department the department     * @return the department     */
        public T department(Department department) {
            this.department = department;
            return self();
        }

    /**     * municipality.     * @param municipality the municipality     * @return the municipality     */
        public T municipality(Municipalities municipality) {
            this.municipality = municipality;
            return self();
        }

    /**     * neighborhood.     * @param neighborhood the neighborhood     * @return the neighborhood     */
        public T neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return self();
        }

    /**     * address.     * @param address the address     * @return the address     */
        public T address(String address) {
            this.address = address;
            return self();
        }

    /**     * crossing.     * @param crossing the crossing     * @return the crossing     */
        public T crossing(String crossing) {
            this.crossing = crossing;
            return self();
        }

    /**     * publication.     * @param publication the publication     * @return the publication     */
        public T publication(String publication) {
            this.publication = publication;
            return self();
        }

    /**     * build.     * @return the build     */
        public DTOProperty build() {
            return new DTOProperty(this);
        }

    }

}
