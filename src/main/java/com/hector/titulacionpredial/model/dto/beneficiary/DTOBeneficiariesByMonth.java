package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * It represents the total number of beneficiaries grouped
 * by year and month.
 *
 * <p>
 * It is used for statistical reports or aggregated queries
 * that return the number of beneficiaries registered in a
 * specific period.
 * </p>
 *
 * @param year  year corresponding to the record
 * @param month month corresponding to the record (1-12)
 * @param total total number of beneficiaries in the period
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public record DTOBeneficiariesByMonth(int year, int month, int total) {

}
