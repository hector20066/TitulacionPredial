package com.hector.titulacionpredial.model.enums;

/**
 * List to represent the different roles that users can have
 * within the system.
 *
 * <p>
 * Define the user's role and according to that role, certain
 * privileges will be assigned to each user of the system.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public enum Role {

    ADMIN("Administrador"),
    EMPLOYEE("Empleado"),
    NONE("Ninguno");

    /**
     * readable value of the role
     */
    private final String role;

    /**
     * Role builder.
     *
     * @param role textual representation of the role
     */
    Role(String role) {
        this.role = role;
    }

    /**     * get role.     * @return the get role     */
    public String getRole() {
        return role;
    }

}
