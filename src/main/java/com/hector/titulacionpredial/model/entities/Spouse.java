package com.hector.titulacionpredial.model.entities;

/**
 * Entidad de dominio que representa un Cónyuge dentro del sistema.
 *
 * <p>
 * Extiende {@link Person} agregando información específica
 * que debe tener el cónyuge.
 * Esta entidad forma parte del modelo de dominio y es
 * persistida en la base de datos.
 * </p>
 * <p>
 * La construcción de instancias se soporta mediante el patrón
 * {@link Builder}, permitiendo herencia fluida desde {@link Person.Builder}
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class Spouse extends Person {

    /**
     * Constructor vacío requerido para frameworks de persistencia
     * o mecanismos basados en reflexión.
     */
    public Spouse() {

    }

    /**
     * Constructor utilizado por el patrón Builder.
     *
     * @param builder instancia configurada del builder
     */
    public Spouse(Builder builder) {
        super(builder);
    }

    /**
     * Devuelve una representación textual del cónyuge,
     * incluyendo los atributos heredados.
     *
     * @return descripción formateada del cónyuge
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Builder concreto para la construcción fluida de instancias
     * de {@link Spouse}
     *
     * <p>
     * Extiende {@link Person.Builder} para permitir la configuración
     * de atributos heredados y específicos en una misma cadena fluida.
     * </p>
     */
    public static class Builder extends Person.Builder<Builder> {

        /**
         * Construye una instancia de {@link Spouse}
         *
         * @return Spouse completamente configurado
         */
        @Override
        public Spouse build() {
            return new Spouse(this);
        }

    }

}
