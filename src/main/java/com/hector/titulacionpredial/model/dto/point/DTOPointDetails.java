package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointDetails extends DTOPoint {

    private int propertyCode;

    public DTOPointDetails() {
        super();
    }

    public DTOPointDetails(Builder builder) {
        super(builder);
        this.propertyCode = builder.propertyCode;
    }

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getPropertyCode() {
        return propertyCode;
    }

    public static class Builder extends DTOPoint.Builder<Builder> {

        private int propertyCode;

        public Builder propertyCode(int propertyCode) {
            this.propertyCode = propertyCode;
            return this;
        }

        @Override
        public DTOPointDetails build() {
            return new DTOPointDetails(this);
        }

    }

}
