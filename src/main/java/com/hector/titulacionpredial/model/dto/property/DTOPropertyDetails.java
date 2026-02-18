package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyDetails {

    private List<String> beneficiaries;
    private List<DTOPointDetails> points;

    public DTOPropertyDetails() {
        this.beneficiaries = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public DTOPropertyDetails(long cadastralId, Double area, List<String> beneficiaries, List<DTOPointDetails> points) {
        super();
        this.beneficiaries = beneficiaries;
        this.points = points;
    }

    public void setBeneficiaries(List<String> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setPoints(List<DTOPointDetails> points) {
        this.points = points;
    }

    public List<String> getBeneficiaries() {
        return beneficiaries;
    }

    public List<DTOPointDetails> getPoints() {
        return points;
    }

}
