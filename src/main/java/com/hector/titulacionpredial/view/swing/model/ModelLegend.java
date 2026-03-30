package com.hector.titulacionpredial.view.swing.model;

import java.awt.*;

/**
 * Data model for a chart legend element.
 *
 * <p>
 * Stores the series name, its main color, and its
 * light color for the gradient fill.
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
     * Create a legend template with the specified data.
     *
     * @param name       series name
     * @param color      main color
     * @param colorLight light color for gradient
     */
    public ModelLegend(String name, Color color, Color colorLight) {
        this.name = name;
        this.color = color;
        this.colorLight = colorLight;
    }

    /**
     * Create an empty legend template.
     */
    public ModelLegend() {

    }

    /**     * get name.     * @return the get name     */
    public String getName() {
        return name;
    }

    /**     * set name.     * @param name the name     */
    public void setName(String name) {
        this.name = name;
    }

    /**     * get color.     * @return the get color     */
    public Color getColor() {
        return color;
    }

    /**     * set color.     * @param color the color     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**     * get color light.     * @return the get color light     */
    public Color getColorLight() {
        return colorLight;
    }

    /**     * set color light.     * @param colorLight the color light     */
    public void setColorLight(Color colorLight) {
        this.colorLight = colorLight;
    }

}
