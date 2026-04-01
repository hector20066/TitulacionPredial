package com.hector.titulacionpredial.view.swing.chart.blankchart;

/**
 * Data model that stores the size of a chart series.
 *
 * <p>
 * It contains the position (startX, startY) and dimensions
 * (width, height) of the area of each series for rendering.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SeriesSize {

    private double x;
    private double y;
    private double width;
    private double height;

    /**
     * Create a series area with position and dimensions.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width
     * @param height height
     */
    public SeriesSize(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Create an empty series area.
     */
    public SeriesSize() {

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
