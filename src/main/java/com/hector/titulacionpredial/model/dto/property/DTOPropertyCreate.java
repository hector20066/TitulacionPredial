package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyCreate extends DTOProperty {

    public DTOPropertyCreate() {
        super();
    }

    public DTOPropertyCreate(String cadastralId, Double area) {
        super(cadastralId, area);
    }


}
