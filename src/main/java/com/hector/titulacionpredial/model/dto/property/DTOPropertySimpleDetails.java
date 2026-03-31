package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

public class DTOPropertySimpleDetails extends DTOProperty {

    public DTOPropertySimpleDetails() {

    }

    public DTOPropertySimpleDetails(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOProperty.Builder<Builder> {

        public DTOPropertySimpleDetails build() {
            return new DTOPropertySimpleDetails(this);
        }

    }
}
