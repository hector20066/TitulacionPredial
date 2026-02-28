package com.hector.titulacionpredial.view.swing.model;

import javax.swing.*;

/**
 * Modelo de datos para las tarjetas del dashboard.
 *
 * <p>
 * Almacena el título, los valores numéricos, el icono
 * y los colores de gradiente utilizados por {@link com.hector.titulacionpredial.view.swing.chart.Card}.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class CardModel {

    private Icon icon;
    private String title;
    private String values;
    private String description;

    public CardModel(Icon icon, String titulo, String valores, String descripcion) {
        this.icon = icon;
        this.title = titulo;
        this.values = valores;
        this.description = descripcion;
    }

    public CardModel() {

    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
