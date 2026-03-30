package com.hector.titulacionpredial.model.dto;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOUser {

    protected int id;

    /**     * dto user.     * @return the dto user     */
    public DTOUser() {

    }

    /**     * dto user.     * @param id the id     * @return the dto user     */
    public DTOUser(int id) {
        this.id = id;
    }

    /**     * get id.     * @return the get id     */
    public int getId() {
        return id;
    }

    /**     * set id.     * @param id the id     */
    public void setId(int id) {
        this.id = id;
    }

}
