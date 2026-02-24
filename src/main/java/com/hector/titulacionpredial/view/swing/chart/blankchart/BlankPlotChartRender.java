package com.hector.titulacionpredial.view.swing.chart.blankchart;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public interface BlankPlotChartRender {
    
    String getLabelText(int index);
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra);
    boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index);
    void renderGraphics(Graphics2D g2, List<Path2D.Double> gra);
    int getMaxLegend();
    
}
