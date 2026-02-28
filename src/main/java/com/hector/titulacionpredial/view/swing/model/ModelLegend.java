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
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModelLegend {

    private String name;
    private Color color;
    private Color colorLight;

    /**
     * Crea un modelo de leyenda con los datos especificados.
     *
     * @param name       nombre de la serie
     * @param color      color principal
     * @param colorLight color claro para gradiente
     */
    public ModelLegend(String name, Color color, Color colorLight) {
        this.name = name;
        this.color = color;
        this.colorLight = colorLight;
    }

    /**
     * Crea un modelo de leyenda vacío.
     */
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
