/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
    
    public abstract String getLabelText(int index);
    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra);
    public abstract boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index);
    public abstract void renderGraphics(Graphics2D g2, List<Path2D.Double> gra);
    public abstract int getMaxLegend();
    
}
