package com.hector.titulacionpredial.utils;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.Pattern;

/**
 *
 * @author hectoracevedo
 */
public class FilterUtils {

    public static void filterTable(JTextField textField, JTable table, String text) {
        if (!textField.getText().equals(text)) {
            String texto = textField.getText();
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);

            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto)));
        }
    }

}
