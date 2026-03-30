package com.hector.titulacionpredial.model.dto.user;

import com.hector.titulacionpredial.model.dto.DTOUser;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUserDetails extends DTOUser {

    private String name;
    private String user;

    /**     * dto user details.     * @return the dto user details     */
    public DTOUserDetails() {
        super();
    }

    /**     * dto user details.     * @param name the name     * @param user the user     * @param id the id     * @return the dto user details     */
    public DTOUserDetails(String name, String user, int id) {
        super(id);
        this.name = name;
        this.user = user;
    }

    /**     * get name.     * @return the get name     */
    public String getName() {
        return name;
    }

    /**     * set name.     * @param name the name     */
    public void setName(String name) {
        this.name = name;
    }

    /**     * get user.     * @return the get user     */
    public String getUser() {
        return user;
    }

    /**     * set user.     * @param user the user     */
    public void setUser(String user) {
        this.user = user;
    }

}
