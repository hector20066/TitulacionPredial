package com.hector.titulacionpredial.utils;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.Pattern;

/**
 * Clase utilitaria para el filtrado dinámico de tablas
 * Swing ({@link JTable}) en tiempo real.
 *
 * <p>
 * Aplica un filtro de expresión regular insensible a
 * mayúsculas sobre el modelo de la tabla según el texto
 * ingresado en un campo de texto.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class FilterUtils {

    /**
     * Filtra las filas de una tabla según el texto del campo.
     *
     * @param textField campo de texto con el criterio de búsqueda
     * @param table     tabla a filtrar
     * @param text      texto placeholder que se ignora
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
