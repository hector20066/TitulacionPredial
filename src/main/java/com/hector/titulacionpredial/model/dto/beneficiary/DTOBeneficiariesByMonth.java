package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiariesByMonth {

    private final int year;
    private final int month;
    private final int total;

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
