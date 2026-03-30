package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.model.enums.Municipalities;
import com.hector.titulacionpredial.model.enums.Role;

/**
 * Session manager for storing and retrieving current user session information.
 *
 * <p>
 * This class maintains the active session data during the application lifetime,
 * including the current user role and selected municipality for data filtering.
 * </p>
 *
 * <h2>Characteristics</h2>
 *
 * <ul>
 *     <li>Uses the Singleton pattern to ensure a single instance throughout the application.</li>
 *     <li>Stores the current user role and municipality selection.</li>
 *     <li>Allows clearing the session when the user logs out.</li>
 *     <li>Provides thread-safe access to session data.</li>
 * </ul>
 *
 * <h3>Session Data</h3>
 *
 * <pre>
 * - Role: ADMIN, EMPLOYEE, NONE
 * - Municipality: MONTERIA, SAHAGUN, or null (for unrestricted access)
 * </pre>
 *
 * <h2>Lifecycle</h2>
 *
 * <pre>
 * 1. User logs in → setRole() and setMunicipality() are called
 * 2. Controllers read municipality → filters data accordingly
 * 3. User logs out → clearSession() clears all session data
 * </pre>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SessionManager {

    private static SessionManager instance;
    private Role currentRole;
    private Municipalities currentMunicipality;

    /**
     * Private constructor to guarantee the Singleton pattern.
     */
    private SessionManager() {
        this.currentRole = Role.NONE;
        this.currentMunicipality = null;
    }

    /**
     * Obtain the single instance of the SessionManager.
     *
     * <p>
     * If the instance does not exist, it is created and returned.
     * </p>
     *
     * @return the single instance of SessionManager
     */
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    /**
     * Set the current user role.
     *
     * @param role the user's role (ADMIN, EMPLOYEE, NONE)
     */
    public void setRole(Role role) {
        this.currentRole = role;
    }

    /**
     * Get the current user role.
     *
     * @return the current user's role
     */
    public Role getRole() {
        return currentRole;
    }

    /**
     * Set the current municipality for data filtering.
     *
     * @param municipality the selected municipality (MONTERIA, SAHAGUN, or null)
     */
    public void setMunicipality(Municipalities municipality) {
        this.currentMunicipality = municipality;
    }

    /**
     * Get the current municipality.
     *
     * <p>
     * Returns null if no municipality filter is active (unrestricted access).
     * </p>
     *
     * @return the current municipality, or null for unrestricted access
     */
    public Municipalities getMunicipality() {
        return currentMunicipality;
    }

    /**
     * Verify if a municipality filter is active.
     *
     * @return true if a specific municipality is selected, false otherwise
     */
    public boolean hasMunicipalityFilter() {
        return currentMunicipality != null;
    }

    /**
     * Clear all session data when the user logs out.
     *
     * <p>
     * Resets both role and municipality to default values.
     * </p>
     */
    public void clearSession() {
        this.currentRole = Role.NONE;
        this.currentMunicipality = null;
    }

}
