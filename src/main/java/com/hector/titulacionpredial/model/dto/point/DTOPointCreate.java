package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointCreate extends DTOPoint {

    private int propertyCode;

    public DTOPointCreate() {
        super();
    }

    public DTOPointCreate(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOPoint.Builder<Builder> {

        @Override
        public DTOPointCreate build() {
            return new DTOPointCreate(this);
        }

    }

}
