package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.entities.Property;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointCreate extends DTOPoint {

    private int propertyCode;

    public DTOPointCreate() {

    }

    public DTOPointCreate(Builder builder, int propertyCode) {
        super(builder);
        this.propertyCode = propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

}
