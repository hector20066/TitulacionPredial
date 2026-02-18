package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionUpdate extends DTOResolution {

    public DTOResolutionUpdate() {
        super();
    }

    public DTOResolutionUpdate(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        @Override
        public DTOResolutionUpdate build() {
            return new DTOResolutionUpdate(this);
        }

    }

}
