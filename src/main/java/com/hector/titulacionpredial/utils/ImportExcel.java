package com.hector.titulacionpredial.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hector.titulacionpredial.i18n.LanguageManager;

/**
 * Utility class for importing data from Excel files into the system.
 *
 * <p>
 * Handles the reading and parsing of Excel files, extracting beneficiary,
 * property, and spouse information for bulk loading operations.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ImportExcel {

    private static final LanguageManager lang = LanguageManager.getInstance();

    /**
     * Private constructor to prevent instantiation (utility class).
     */
    public ImportExcel() {

    }

    /**
     * Reads and parses an Excel file, extracting data for beneficiaries,
     * properties, and spouses from bulk loading operations.
     *
     * @param route the file path to the Excel file to read
     * @return a list of lists containing parsed data rows from the Excel sheet
     */
    public List<List<String>> readExcel(String route) {
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(route);
             Workbook workbook = WorkbookFactory.create(fis)) {

            if (workbook.getNumberOfSheets() <= 5) {
                MessageUtils.errorMessage(lang.message("message.import.error") + "\n" +
                        "Excel file must have at least 6 sheets. Found: " + workbook.getNumberOfSheets(), null);
                return data;
            }

            Sheet sheet = workbook.getSheetAt(5);
            DataFormatter formatter = new DataFormatter();

            boolean firstRow = true;

            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                List<String> dataRow = new ArrayList<>();
                int lastColumn = 24;

                for (int i = 0; i < lastColumn; i++) {
                    Cell cell = row.getCell(i);

                    if (cell != null) {
                        dataRow.add(formatter.formatCellValue(cell));
                    } else {
                        dataRow.add("");
                    }
                }

                data.add(dataRow);
            }
        } catch (IOException e) {
            MessageUtils.errorMessage(lang.message("message.import.error") + "\n" + e.getMessage(), null);
        }

        return data;
    }

}
