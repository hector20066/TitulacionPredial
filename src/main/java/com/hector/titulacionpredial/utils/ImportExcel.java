package com.hector.titulacionpredial.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.protobuf.Message;
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
        try (FileInputStream fis = new FileInputStream(new File(route));
            Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            boolean firstRow = true;

            for (Row fila : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                List<String> dataRow = new ArrayList<>();

                for (Cell cell : fila) {
                    dataRow.add(formatter.formatCellValue(cell));
                }

                data.add(dataRow);
            }

        } catch (IOException e) {
            MessageUtils.errorMessage(lang.message("message.import.error") + "\n" + e.getMessage(),null);
        }

        return data;
    }

}
