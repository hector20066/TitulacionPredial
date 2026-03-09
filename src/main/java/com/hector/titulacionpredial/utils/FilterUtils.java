package com.hector.titulacionpredial.utils;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.Pattern;

/**
 * Utility class for real-time dynamic filtering of
 * Swing tables ({@link JTable}).
 *
 * <p>
 * Applies a case-insensitive regular expression
 * filter to the table pattern based on the text
 * entered in a text field.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class FilterUtils {

    /**
     * Filter the rows of a table based on the text in the field.
     *
     * @param textField text field with the search criteria
     * @param table     table to filter
     * @param text      placeholder text that is ignored
     */
    public static void filterTable(JTextField textField, JTable table, String text) {
        if (!textField.getText().equals(text)) {
            String texto = textField.getText();
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);

            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto)));
        }
    }

}
