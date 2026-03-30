package com.hector.titulacionpredial.model.dto.property;

/**
 * @author Ing. Hector Acevedo
 */
public class DTOPropertyUpdate {

    private Double area;
    private String cadastralRef;

    /**     * dto property update.     * @return the dto property update     */
    public DTOPropertyUpdate() {

    }

    /**     * dto property update.     * @param area the area     * @param cadastralRef the cadastral ref     * @return the dto property update     */
    public DTOPropertyUpdate(Double area, String cadastralRef) {
        this.area = area;
        this.cadastralRef = cadastralRef;
    }

    /**     * get area.     * @return the get area     */
    public Double getArea() {
        return area;
    }

    /**     * set area.     * @param area the area     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**     * get cadastral ref.     * @return the get cadastral ref     */
    public String getCadastralRef() {
        return cadastralRef;
    }

    /**     * set cadastral ref.     * @param cadastralRef the cadastral ref     */
    public void setCadastralRef(String cadastralRef) {
        this.cadastralRef = cadastralRef;
    }

}
