package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

public class DTOPropertyModifyBasic extends DTOProperty {

    public DTOPropertyModifyBasic() {

    }

    public DTOPropertyModifyBasic(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOProperty.Builder<Builder> {

        public DTOPropertyModifyBasic build() {
            return new DTOPropertyModifyBasic(this);
        }

    }

}
