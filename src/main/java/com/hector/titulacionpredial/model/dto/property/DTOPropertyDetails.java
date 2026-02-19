package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.DTOProperty;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryPropertyDetails;
import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyDetails extends DTOProperty {

    private List<DTOBeneficiaryPropertyDetails> beneficiaries;
    private List<DTOPointDetails> points;

    public DTOPropertyDetails() {
        super();
        this.beneficiaries = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public DTOPropertyDetails(String cadastralId, Double area, List<DTOBeneficiaryPropertyDetails> beneficiaries, List<DTOPointDetails> points) {
        super(cadastralId, area);
        this.beneficiaries = beneficiaries;
        this.points = points;
    }

    public void setBeneficiaries(List<DTOBeneficiaryPropertyDetails> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setPoints(List<DTOPointDetails> points) {
        this.points = points;
    }

    public List<DTOBeneficiaryPropertyDetails> getBeneficiaries() {
        return beneficiaries;
    }

    public List<DTOPointDetails> getPoints() {
        return points;
    }

}
