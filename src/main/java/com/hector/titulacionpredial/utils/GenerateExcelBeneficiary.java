package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryCreate;
import com.hector.titulacionpredial.model.dto.beneficiary.DTOBeneficiaryDetails;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Utility class for exporting beneficiaries to an Excel file
 * (.xls) using Apache POI.
 *
 * <p>
 * Generate a report with the personal data of each beneficiary
 * registered in the system.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DTOBeneficiaryCreate
 * @since 1.0
 */
public class GenerateExcelBeneficiary {

    /**
     * Export the list of beneficiaries to an Excel file.
     *
     * @param beneficiaries list of data with the beneficiaries' information
     * @param path          directory path where to save the file
     * @throws IOException If an error occurs while writing the file
     */
    public static void export(List<DTOBeneficiaryDetails> beneficiaries, String path) throws IOException {
        File archivoXLS = new File(path + File.separator + "ReporteBeneficiarios.xls");
        Workbook book = new HSSFWorkbook();

        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font headerFont = book.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        headerStyle.setFont(headerFont);
        Sheet sheet = book.createSheet("Reporte Beneficiarios");
        sheet.setDisplayGridlines(true);

        String[] titles = {"Codigo", "Cédula", "Nombre", "Departamento", "Municipio", "Dirección",
                "Ref. Catastral", "Estado Civil", "Afectación", "Teléfono", "Cruce",
                "Publicación", "Barrio", "Lugar Expedición"};

        Row header = sheet.createRow(0);

        for (int c = 0; c < titles.length; c++) {
            Cell cell = header.createCell(c);
            cell.setCellValue(titles[c]);
            cell.setCellStyle(headerStyle);
        }

        int rowIndex = 1;

        for (DTOBeneficiaryDetails dto : beneficiaries) {
            Row row = sheet.createRow(rowIndex++);

            int col = 0;
            row.createCell(col++).setCellValue(dto.getCodeBeneficiaries());
            row.createCell(col++).setCellValue(dto.getId());
            row.createCell(col++).setCellValue(dto.getFullName() != null ? dto.getFullName() : "");
            row.createCell(col++).setCellValue(dto.getDepartment() != null ? dto.getDepartment().getValue() : "");
            row.createCell(col++).setCellValue(dto.getMunicipality() != null ? dto.getMunicipality().getValue() : "");
            row.createCell(col++).setCellValue(dto.getAddress() != null ? dto.getAddress() : "");
            row.createCell(col++).setCellValue(dto.getCadastralRef() != null ? dto.getCadastralRef() : "");
            row.createCell(col++).setCellValue(dto.getMaritalStatus() != null ? dto.getMaritalStatus().getValue() : "");
            row.createCell(col++).setCellValue(dto.getAffectation() != null ? dto.getAffectation() : "");
            row.createCell(col++).setCellValue(dto.getPhone());
            row.createCell(col++).setCellValue(dto.getCrossing() != null ? dto.getCrossing() : "");
            row.createCell(col++).setCellValue(dto.getPublication() != null ? dto.getPublication() : "");
            row.createCell(col++).setCellValue(dto.getNeighborhood() != null ? dto.getNeighborhood() : "");
            row.createCell(col).setCellValue(dto.getExpeditionLocation() != null ? dto.getExpeditionLocation() : "");
        }

        for (int c = 0; c < titles.length; c++) {
            sheet.autoSizeColumn(c);
        }

        try (FileOutputStream file = new FileOutputStream(archivoXLS)) {
            book.write(file);
        }

        book.close();
    }
}
