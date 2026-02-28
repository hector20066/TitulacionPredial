package com.hector.titulacionpredial.model.entities;

/**
 * Entidad base que representa una persona dentro del dominio
 * del sistema de Titulación Predial.
 *
 * <p>
 * Define los atributos comunes que deben poseer las entidades
 * que representen actores del sistema (por ejemplo, beneficiarios,
 * </p>
 *
 * <p>
 * Esta clase:
 * </p>
 * <ul>
 *     <li>Posee identidad propia mediante el atributo {@code id}.</li>
 *     <li>Es mutable a través de métodos setter.</li>
 *     <li>Soporta construcción mediante el patrón {@link Builder}.</li>
 * </ul>
 *
 * <p>
 * Puede extenderse para especializar distintos tipos de personas
 * dentro del modelo de dominio.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Person {

    protected long id;
    protected String fullName;
    protected String address;
    protected String expeditionLocation;
    protected long phone;

    /**
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos de reflexión.
     */
    public Person() {
    }

    /**
     * Constructor protegido utilizado por el patrón Builder.
     *
     * @param builder instancia del constructor paso a paso
     */
    protected Person(Builder<?> builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.expeditionLocation = builder.expeditionLocation;
        this.phone = builder.phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * Representación textual de la entidad.
     *
     * @return descripción formateada de los atributos principales
     */
    @Override
    public String toString() {
        return "Id= " + id +
                "\nName= " + fullName +
                "\nAddress= " + address +
                "\nExpedition Location= " + expeditionLocation +
                "\nPhone=" + phone;
    }

    /**
     * Implementación genérica del patrón Builder para permitir
     * la construcción fluida y segura de instancias de {@link Person}
     * y sus subclases.
     *
     * <p>
     * Utiliza el patrón "self type generics" para soportar herencia
     * sin perder el tipo concreto en las subclases.
     * </p>
     *
     * @param <T> tipo concreto del builder extendido
     */
    public static class Builder<T extends Builder<T>> {

        private long id;
        private String fullName;
        private String address;
        private String expeditionLocation;
        private long phone;

        /**
         * Devuelve la instancia concreta del builder.
         *
         * @return instancia tipada del builder
         */
        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        /**
         * Establece el identificador.
         *
         * @param id identificador único
         * @return builder actual
         */
        public T id(long id) {
            this.id = id;
            return self();
        }

        /**
         * Establece el nombre completo.
         *
         * @param fullName nombre completo
         * @return builder actual
         */
        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        /**
         * Establece la dirección.
         *
         * @param address dirección de residencia
         * @return builder actual
         */
        public T address(String address) {
            this.address = address;
            return self();
        }

        /**
         * Establece el lugar de expedición.
         *
         * @param expeditionLocation ciudad o lugar de expedición
         * @return builder actual
         */
        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        /**
         * Establece el número telefónico.
         *
         * @param phone número de contacto
         * @return builder actual
         */
        public T phone(long phone) {
            this.phone = phone;
            return self();
        }

        /**
         * Construye una nueva instancia de {@link Person}.
         *
         * @return nueva persona construida
         */
        public Person build() {
            return new Person(this);
        }

    }

}
