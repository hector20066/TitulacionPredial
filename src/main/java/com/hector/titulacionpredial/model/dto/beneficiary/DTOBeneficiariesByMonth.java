package com.hector.titulacionpredial.model.dto.beneficiary;

/**
 * Representa la cantidad total de beneficiarios agrupados por año y mes.
 *
 * <p>
 * Se utiliza para reportes estadísticos o consultas agregadas
 * que retornan el número de beneficiarios registrados en un
 * periodo específico.
 * </p>
 *
 * @param year  año correspondiente al registro
 * @param month mes correspondiente al registro (1-12)
 * @param total cantidad total de beneficiarios en el periodo
 * @author hectoracevedo
 * @since 1.0
 */
public record DTOBeneficiariesByMonth(int year, int month, int total) {

}
