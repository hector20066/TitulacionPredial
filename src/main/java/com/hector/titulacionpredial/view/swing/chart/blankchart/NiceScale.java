package com.hector.titulacionpredial.view.swing.chart.blankchart;

/**
 * Calculadora de escalas «agradables» para ejes de gráficos.
 *
 * <p>
 * Dado un rango de valores mínimo y máximo, calcula
 * intervalos de marcas (ticks) redondeados y límites
 * de eje apropiados para una visualización legible.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class NiceScale {

    private double min;
    private double max;
    private int maxTicks = 10;
    private double tickSpacing;
    private double range;
    private double niceMin;
    private double niceMax;

    /**
     * Crea una escala con el rango dado.
     *
     * @param min valor mínimo
     * @param max valor máximo
     */
    public NiceScale(final double min, final double max) {
        this.min = min;
        this.max = max;
        calculate();
    }

    /**
     * Recalcula el rango, espaciado y límites del eje.
     */
    private void calculate() {
        range = niceNum(max - min, false);
        tickSpacing = niceNum(range / (maxTicks - 1), true);
        niceMin = Math.floor(min / tickSpacing) * tickSpacing;
        niceMax = Math.ceil(max / tickSpacing) * tickSpacing;
    }

    /**
     * Encuentra el número «agradable» más cercano.
     *
     * @param range rango a redondear
     * @param round {@code true} para redondear, {@code false} para techo
     * @return número redondeado
     */
    private double niceNum(final double range, final boolean round) {
        double exponent;
        double fraction;
        double niceFraction;

        exponent = Math.floor(Math.log10(range));
        fraction = range / Math.pow(10, exponent);

        if (round) {
            if (fraction < 1.5) {
                niceFraction = 1;
            } else {
                if (fraction < 3) {
                    niceFraction = 2;
                } else {
                    if (fraction < 7) {
                        niceFraction = 5;
                    } else {
                        niceFraction = 10;
                    }
                }
            }
        } else {
            if (fraction <= 1) {
                niceFraction = 1;
            } else {
                if (fraction <= 2) {
                    niceFraction = 2;
                } else {
                    if (fraction <= 5) {
                        niceFraction = 5;
                    } else {
                        niceFraction = 10;
                    }
                }
            }

        }
        return niceFraction * Math.pow(10, exponent);
    }

    /**
     * Establece el rango mínimo y máximo y recalcula.
     *
     * @param min valor mínimo
     * @param max valor máximo
     */
    public void setMinMax(final double min, final double max) {
        this.min = min;
        this.max = max;
        calculate();
    }

    public double getTickSpacing() {
        return tickSpacing;
    }

    public double getNiceMin() {
        return niceMin;
    }

    public double getNiceMax() {
        return niceMax;
    }

    public double getMaxTicks() {
        return maxTicks;
    }

    /**
     * Establece el número máximo de marcas y recalcula.
     *
     * @param maxTicks cantidad máxima de marcas
     */
    public void setMaxTicks(final int maxTicks) {
        this.maxTicks = maxTicks;
        calculate();
    }

    public double getMin() {
        return min;
    }

    /**
     * Establece el valor mínimo y recalcula.
     *
     * @param min valor mínimo
     */
    public void setMin(double min) {
        this.min = min;
        calculate();
    }

    public double getMax() {
        return max;
    }

    /**
     * Establece el valor máximo y recalcula.
     *
     * @param max valor máximo
     */
    public void setMax(double max) {
        this.max = max;
        calculate();
    }

}
