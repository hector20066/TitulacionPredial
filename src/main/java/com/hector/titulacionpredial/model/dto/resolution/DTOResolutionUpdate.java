package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;


/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionUpdate extends DTOResolution {

    private int code;

    public DTOResolutionUpdate() {
        super();
    }

    public DTOResolutionUpdate(Builder builder) {
        super(builder);
        this.code = builder.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static class Builder extends DTOResolution.Builder<Builder> {

        private int code;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        @Override
        public DTOResolutionUpdate build() {
            return new DTOResolutionUpdate(this);
        }

    }

}
