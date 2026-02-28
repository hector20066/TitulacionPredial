package com.hector.titulacionpredial.view.swing.model;

import java.awt.*;

/**
 * Modelo de datos para un elemento de la leyenda del gráfico.
 *
 * <p>
 * Almacena el nombre de la serie, su color principal
 * y su color claro para el relleno de gradiente.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class ModelLegend {

    private String name;
    private Color color;
    private Color colorLight;

    public ModelLegend(String name, Color color, Color colorLight) {
        this.name = name;
        this.color = color;
        this.colorLight = colorLight;
    }

    public ModelLegend() {

    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorLight() {
        return colorLight;
    }

    public void setColorLight(Color colorLight) {
        this.colorLight = colorLight;
    }

}
