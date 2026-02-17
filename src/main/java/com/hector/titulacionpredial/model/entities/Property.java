package com.hector.titulacionpredial.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class Property {

    private long code;
    private long cadastralId;
    private Double area;
    private List<Beneficiary> beneficiaries;
    private Point[] points;

    public Property() {
        this.beneficiaries = new ArrayList<>();
        this.points = new Point[4];
    }

    public Property(long code, long cadastralId, Double area, List<Beneficiary> beneficiaries, Point[] points) {
        this.code = code;
        this.cadastralId = cadastralId;
        this.area = area;
        this.beneficiaries = beneficiaries;
        this.points = points;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setCadastralId(long cadastralId) {
        this.cadastralId = cadastralId;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public long getCode() {
        return code;
    }

    public long getCadastralId() {
        return cadastralId;
    }

    public Double getArea() {
        return area;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return  "Code= " + code +
                "\nCadastral Id= " + cadastralId +
                "\nArea= " + area +
                "\nBeneficiaries= " + beneficiaries +
                "\nPoints= " + Arrays.toString(points);
    }

}
