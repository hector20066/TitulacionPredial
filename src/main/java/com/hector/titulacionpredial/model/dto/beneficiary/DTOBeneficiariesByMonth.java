package com.hector.titulacionpredial.model.dto.beneficiary;

public class DTOBeneficiariesByMonth {

    private int year;
    private int month;
    private int total;

    public DTOBeneficiariesByMonth(int year, int month, int total) {
        this.year = year;
        this.month = month;
        this.total = total;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getTotal() {
        return total;
    }

}
