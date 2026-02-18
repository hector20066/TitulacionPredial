package com.hector.titulacionpredial.model.dto.point;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 *
 * @author hectoracevedo
 */
public class DTOPointDetails extends DTOPoint {

    public DTOPointDetails() {
        super();
    }

    public DTOPointDetails(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOPoint.Builder<Builder> {

        @Override
        public DTOPointDetails build() {
            return new DTOPointDetails(this);
        }

    }

}
