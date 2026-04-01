package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 * Data Transfer Object (DTO) for modifying basic property information.
 *
 * <p>
 * Used to transport basic property modification data from the
 * presentation layer to the persistence layer, avoiding direct
 * exposure of the {@code Property} entity.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class DTOPropertyModifyBasic extends DTOProperty {

    /**
     * Empty constructor required for serialization or mapping frameworks.
     */
    public DTOPropertyModifyBasic() {

    }

    /**
     * Constructor used by the Builder pattern.
     *
     * @param builder configured instance of the builder
     */
    public DTOPropertyModifyBasic(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOProperty.Builder<Builder> {

        public DTOPropertyModifyBasic build() {
            return new DTOPropertyModifyBasic(this);
        }

    }

}
