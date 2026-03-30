package com.hector.titulacionpredial.model.entities;

/**
 * Domain entity that represents a Spouse within the system.
 *
 * <p>
 * Extends {@link Person} by adding specific information that
 * the spouse must have. This entity is part of the domain model
 * and is persisted in the database.
 * </p>
 *
 * <p>
 * Instance building is supported by the {@link Builder} pattern,
 * allowing fluid inheritance from {@link Person.Builder}
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class Spouse extends Person {

    /**
     * Empty constructor required for persistence frameworks
     * or reflection-based mechanisms.
     */
    public Spouse() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public Spouse(Builder builder) {
        super(builder);
    }

    /**
     * Returns a textual representation of the spouse,
     * including inherited attributes.
     *
     * @return formatted description of spouse
     */
    @Override
    /**     * to string.     * @return the to string     */
    public String toString() {
        return super.toString();
    }

    /**
     * Concrete builder for the seamless construction of
     * {@link Spouse} instances
     *
     * <p>
     * Extends {@link Person.Builder} to allow the
     * configuration of both inherited and specific
     * attributes in the same fluent string.
     * </p>
     */
    public static class Builder extends Person.Builder<Builder> {

        @Override
    /**     * build.     * @return the build     */
        public Spouse build() {
            return new Spouse(this);
        }

    }

}
