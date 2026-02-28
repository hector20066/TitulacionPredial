package com.hector.titulacionpredial.view.swing.model;

/**
 * Modelo de datos para una serie del gráfico de líneas.
 *
 * <p>
 * Contiene la etiqueta del eje X y los valores
 * correspondientes a cada serie de datos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModelChart {

    private String label;
    private double[] values;

    /**
     * Crea un modelo de serie con etiqueta y valores.
     *
     * @param label  etiqueta del eje X
     * @param values valores de la serie
     */
    public ModelChart(String label, double[] values) {
        this.label = label;
        this.values = values;
    }

    /**
     * Crea un modelo de serie vacío.
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

    /**
     * Obtiene el valor máximo de la serie.
     *
     * @return valor máximo
     */
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

