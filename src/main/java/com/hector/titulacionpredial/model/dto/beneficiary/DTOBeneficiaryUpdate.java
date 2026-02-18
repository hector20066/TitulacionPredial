package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryUpdate extends DTOBeneficiary {

    public DTOBeneficiaryUpdate() {

    }

    public DTOBeneficiaryUpdate(Builder builder) {
        super(builder);
    }

    public static class Builder extends DTOBeneficiary.Builder {

        public DTOBeneficiaryUpdate build() {
            return new DTOBeneficiaryUpdate(this);
        }

    }

}
