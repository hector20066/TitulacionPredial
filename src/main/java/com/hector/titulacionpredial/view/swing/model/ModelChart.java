package com.hector.titulacionpredial.view.swing.model;

/**
 * Data model for a line chart series.
 *
 * <p>
 * It contains the X-axis label and the corresponding
 * values for each data series.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModelChart {

    private String label;
    private double[] values;

    /**
     * Create a series model with label and values.
     *
     * @param label  X-axis label
     * @param values values of the series
     */
    public ModelChart(String label, double[] values) {
        this.label = label;
        this.values = values;
    }

    /**
     * Create an empty series model.
     */
    public ModelChart() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public double getMaxValues() {
        double max = 0;

        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }

        return max;
    }

}

