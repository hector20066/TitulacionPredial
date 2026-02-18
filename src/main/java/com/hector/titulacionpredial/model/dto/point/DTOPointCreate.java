package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.entities.Property;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointCreate {

    private int propertyCode;

    public DTOPointCreate() {

    }

    public DTOPointCreate(int numberPoint, Double northCoordinate, Double eastCoordinate, Double distance, String hillside, int propertyCode) {
        super();
        this.propertyCode = propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

}
