package com.hector.titulacionpredial.view.swing.chart.blankchart;

/**
 * Calculator of «nice» scales for graph axes.
 *
 * <p>
 * Given a range of minimum and maximum values,
 * calculate rounded tick intervals and appropriate
 * axis limits for a readable display.
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
     * Create a scale with the given range.
     *
     * @param min minimum value
     * @param max maximum value
     */
    public NiceScale(final double min, final double max) {
        this.min = min;
        this.max = max;
        calculate();
    }

    /**
     * Recalculate the range, spacing, and axis limits.
     */
    private void calculate() {
        range = niceNum(max - min, false);
        tickSpacing = niceNum(range / (maxTicks - 1), true);
        niceMin = Math.floor(min / tickSpacing) * tickSpacing;
        niceMax = Math.ceil(max / tickSpacing) * tickSpacing;
    }

    /**
     * Find the nearest "nice" number.
     *
     * @param range range to round
     * @param round {@code true} to round, {@code false} for ceiling
     * @return rounded number
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
     * Set the minimum and maximum range and recalculate.
     *
     * @param min minimum value
     * @param max maximum value
     */
    public void setMinMax(final double min, final double max) {
        this.min = min;
        this.max = max;
        calculate();
    }

    /**     * get tick spacing.     * @return the get tick spacing     */
    public double getTickSpacing() {
        return tickSpacing;
    }

    /**     * get nice min.     * @return the get nice min     */
    public double getNiceMin() {
        return niceMin;
    }

    /**     * get nice max.     * @return the get nice max     */
    public double getNiceMax() {
        return niceMax;
    }

    /**     * get max ticks.     * @return the get max ticks     */
    public double getMaxTicks() {
        return maxTicks;
    }

    /**
     * Set the maximum number of marks and recalculate.
     *
     * @param maxTicks maximum number of marks
     */
    public void setMaxTicks(final int maxTicks) {
        this.maxTicks = maxTicks;
        calculate();
    }

    /**     * get min.     * @return the get min     */
    public double getMin() {
        return min;
    }

    /**
     * Set the minimum value and recalculate.
     *
     * @param min minimum value
     */
    public void setMin(double min) {
        this.min = min;
        calculate();
    }

    /**     * get max.     * @return the get max     */
    public double getMax() {
        return max;
    }

    /**
     * Set the maximum value and recalculate.
     *
     * @param max maximum value
     */
    public void setMax(double max) {
        this.max = max;
        calculate();
    }

}
