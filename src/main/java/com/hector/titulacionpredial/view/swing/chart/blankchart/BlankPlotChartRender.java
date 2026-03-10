package com.hector.titulacionpredial.view.swing.chart.blankchart;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.List;

/**
 * Rendering interface for the base chart ({@link BlankPlotChart}).
 *
 * <p>
 * Define the contract to draw the data series over the plot
 * area of the chart.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BlankPlotChart
 * @since 1.0
 */
public interface BlankPlotChartRender {

    /**
     * Gets the label text for a given index.
     *
     * @param index series index
     * @return label text
     */
    String getLabelText(int index);

    /**
     * Renders a series of data about the plotting area.
     *
     * @param chart base chart
     * @param g2    2D graphic context
     * @param size  dimensions of the area of the series
     * @param index series index
     */
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);

    /**
     * Render a series of data by accumulating plots in the list.
     *
     * @param chart base chart
     * @param g2    2D graphic context
     * @param size  dimensions of the area of the series
     * @param index series index
     * @param gra   list of accumulated routes
     */
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra);

    /**
     * Manage mouse movement over the chart.
     *
     * @param chart base chart
     * @param evt   mouse event
     * @param g2    2D graphic context
     * @param size  dimensions of the area of the series
     * @param index series index
     * @return {@code true} if the mouse is over a series
     */
    boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index);

    /**
     * Render the accumulated graphical paths.
     *
     * @param g2  2D graphic context
     * @param gra list of paths to draw
     */
    void renderGraphics(Graphics2D g2, List<Path2D.Double> gra);

    /**
     * Get the maximum number of elements in the legend.
     *
     * @return maximum number of legends
     */
    int getMaxLegend();

}
