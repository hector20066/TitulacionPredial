package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.model.dto.DTOPoint;
import com.hector.titulacionpredial.model.dto.property.DTOPropertyDetails;
import com.hector.titulacionpredial.model.enums.Municipalities;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Utility class for exporting properties to an Excel file
 * (.xls) using Apache POI.
 *
 * <p>
 * Generates a complete report with information for each
 * property, including beneficiaries, resolutions, geographic
 * points and area.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see DTOPropertyDetails
 * @since 1.0
 */
public class GenerateExcelProperty {

    /**
     * Export the list of properties to an Excel file.
     *
     * @param properties List of data with the property information
     * @param path       directory path where to save the file
     * @throws IOException If an error occurs while writing the file
     */
    public static void export(List<DTOPropertyDetails> properties, String path) throws IOException {
        File archivoXLS = new File(path + File.separator + "Reporte.xls");
        Workbook book = new HSSFWorkbook();

        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font headerFont = book.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        headerStyle.setFont(headerFont);
        Sheet sheet = book.createSheet("Reporte Completo");
        sheet.setDisplayGridlines(true);

        String[] titles = {"Código Propiedad", "Nombre", "Cedula", "N. Resolución", "Notificación",
                "Ejecutoria", "FMI", "Acto", "Esc. Publica", "Notaria", "Ref. Catastral", "Dirección", "Municipio",
                "MCORE1", "MCORN1", "MDISN", "MCOLN", "MCORE2", "MCORN2", "MDISE", "MCOLE", "MCORE3", "MCORN3", "MDISS",
                "MCOLS", "MCORE4", "MCORN4", "MDISO", "MLINDO", "AMAT"};

        Row header = sheet.createRow(0);

        for (int c = 0; c < titles.length; c++) {
            Cell cell = header.createCell(c);
            cell.setCellValue(titles[c]);
            cell.setCellStyle(headerStyle);
        }

        int rowIndex = 1;

        for (DTOPropertyDetails dto : properties) {
            Row row = sheet.createRow(rowIndex++);

            String codeBeneficiaries = dto.getCodeBeneficiaries();
            String beneficiariesName = dto.getBeneficiariesName();
            String addressBeneficiary = dto.getAddress();
            Municipalities municipalities = dto.getMunicipality();
            String beneficiaryId = dto.getBeneficiariesIds();

            long resolutionNumber = dto.getNumResolution();
            LocalDate notification = dto.getNotification();
            LocalDate executory = dto.getExecutory();
            String fmi = dto.getFmi();
            String act = dto.getAct();
            String publicWriting = dto.getPublicWriting();
            String notary = dto.getNotary();
            String cadastralReference = dto.getCadastralId();
            double area = dto.getArea();

            double northCoordinate1 = 0, eastCoordinate1 = 0, distance1 = 0;
            String hillside1 = "";
            double northCoordinate2 = 0, eastCoordinate2 = 0, distance2 = 0;
            String hillside2 = "";
            double northCoordinate3 = 0, eastCoordinate3 = 0, distance3 = 0;
            String hillside3 = "";
            double northCoordinate4 = 0, eastCoordinate4 = 0, distance4 = 0;
            String hillside4 = "";

            for (DTOPoint point : dto.getPoints()) {
                switch (point.getNumberPoint()) {
                    case 1 -> {
                        northCoordinate1 = point.getNorthCoordinate();
                        eastCoordinate1 = point.getEastCoordinate();
                        distance1 = point.getDistance();
                        hillside1 = point.getHillside();
                    }
                    case 2 -> {
                        northCoordinate2 = point.getNorthCoordinate();
                        eastCoordinate2 = point.getEastCoordinate();
                        distance2 = point.getDistance();
                        hillside2 = point.getHillside();
                    }
                    case 3 -> {
                        northCoordinate3 = point.getNorthCoordinate();
                        eastCoordinate3 = point.getEastCoordinate();
                        distance3 = point.getDistance();
                        hillside3 = point.getHillside();
                    }
                    case 4 -> {
                        northCoordinate4 = point.getNorthCoordinate();
                        eastCoordinate4 = point.getEastCoordinate();
                        distance4 = point.getDistance();
                        hillside4 = point.getHillside();
                    }
                }
            }

            int col = 0;
            row.createCell(col++).setCellValue(codeBeneficiaries);
            row.createCell(col++).setCellValue(beneficiariesName);
            row.createCell(col++).setCellValue(beneficiaryId);
            row.createCell(col++).setCellValue(resolutionNumber);
            row.createCell(col++).setCellValue(notification != null ? notification.toString() : "");
            row.createCell(col++).setCellValue(executory != null ? executory.toString() : "");
            row.createCell(col++).setCellValue(fmi != null ? fmi : "");
            row.createCell(col++).setCellValue(act != null ? act : "");
            row.createCell(col++).setCellValue(publicWriting != null ? publicWriting : "");
            row.createCell(col++).setCellValue(notary != null ? notary : "");
            row.createCell(col++).setCellValue(cadastralReference != null ? cadastralReference : "");
            row.createCell(col++).setCellValue(addressBeneficiary != null ? addressBeneficiary : "");
            row.createCell(col++).setCellValue(municipalities != null ? municipalities.getValue() : "");
            row.createCell(col++).setCellValue(eastCoordinate1);
            row.createCell(col++).setCellValue(northCoordinate1);
            row.createCell(col++).setCellValue(distance1);
            row.createCell(col++).setCellValue(hillside1);
            row.createCell(col++).setCellValue(eastCoordinate2);
            row.createCell(col++).setCellValue(northCoordinate2);
            row.createCell(col++).setCellValue(distance2);
            row.createCell(col++).setCellValue(hillside2);
            row.createCell(col++).setCellValue(eastCoordinate3);
            row.createCell(col++).setCellValue(northCoordinate3);
            row.createCell(col++).setCellValue(distance3);
            row.createCell(col++).setCellValue(hillside3);
            row.createCell(col++).setCellValue(eastCoordinate4);
            row.createCell(col++).setCellValue(northCoordinate4);
            row.createCell(col++).setCellValue(distance4);
            row.createCell(col++).setCellValue(hillside4);
            row.createCell(col).setCellValue(area);
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
