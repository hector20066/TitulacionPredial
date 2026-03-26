package com.hector.titulacionpredial.utils;

import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ing. Hector Acevedo
 */
public class ImportExcel {

    public ImportExcel() {

    }

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
            JOptionPane.showMessageDialog(null,
                    "Error al leer el archivo Excel:\n" + e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return data;
    }

}
