package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointCreate extends DTOPoint {

    private int propertyCode;

    public DTOPointCreate() {

    }

    public DTOPointCreate(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public static class Builder extends DTOPoint.Builder {

        private int propertyCode;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        public DTOPointCreate build() {
            return new DTOPointCreate(this);
        }

    }

}
