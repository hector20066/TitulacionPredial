package com.hector.titulacionpredial.model.dto.property;

import com.hector.titulacionpredial.model.dto.point.DTOPointDetails;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class DTOPropertyDetails {

    private long cadastralId;
    private Double area;

    private List<String> beneficiaries;
    private List<DTOPointDetails> points;

    public DTOPropertyDetails() {
        this.beneficiaries = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public DTOPropertyDetails(long cadastralId, Double area, List<String> beneficiaries, List<DTOPointDetails> points) {
        this.cadastralId = cadastralId;
        this.area = area;
        this.beneficiaries = beneficiaries;
        this.points = points;
    }

    public void setCadastralId(long cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBeneficiaries(List<String> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setPoints(List<DTOPointDetails> points) {
        this.points = points;
    }

    public long getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public List<String> getBeneficiaries() {
        return beneficiaries;
    }

    public List<DTOPointDetails> getPoints() {
        return points;
    }
    
}
