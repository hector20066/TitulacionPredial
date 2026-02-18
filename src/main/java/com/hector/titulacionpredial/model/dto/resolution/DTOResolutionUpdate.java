package com.hector.titulacionpredial.model.dto.resolution;

import com.hector.titulacionpredial.model.dto.DTOResolution;

import java.time.LocalDate;

/**
 *
 * @author hectoracevedo
 */
public class DTOResolutionUpdate extends DTOResolution {

    public DTOResolutionUpdate() {
        super();
    }

    public DTOResolutionUpdate(LocalDate executory, String act, String publicWriting) {
        super(executory, act, publicWriting);
    }

}
