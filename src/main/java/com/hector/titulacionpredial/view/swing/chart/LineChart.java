package com.hector.titulacionpredial.view.swing.chart;

import com.hector.titulacionpredial.view.swing.chart.blankchart.BlankPlotChart;
import com.hector.titulacionpredial.view.swing.chart.blankchart.BlankPlotChartRender;
import com.hector.titulacionpredial.view.swing.chart.blankchart.SeriesSize;
import com.hector.titulacionpredial.view.swing.model.ModelChart;
import com.hector.titulacionpredial.view.swing.model.ModelLegend;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Line graphic component with support for multiple series.
 *
 * <p>
 * Draw data series as smoothed lines with a gradient fill,
 * a bottom legend, and an interactive tooltip that appears
 * on hover. Use {@link BlankPlotChart} as the basis for the
 * coordinate axes.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see BlankPlotChart
 * @see ModelChart
 */
public class LineChart extends javax.swing.JPanel {

    DecimalFormat df = new DecimalFormat("#,##0.##");
    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 18;
    private final int seriesSpace = 0;
    private final Animator animator;
    private float animate;
    private String showLabel;
    /**     * point.     * @return the point     */
    private Point labelLocation = new Point();

    /**
     * Create the line graph and initialize the animation and renderer.
     */
    public LineChart() {
        initComponents();
        
        setOpaque(false);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
    /**     * timing event.     * @param fraction the fraction     */
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
        };
        
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        blankPlotChart.getNiceScale().setMaxTicks(5);
        
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChartRender() {
            @Override
    /**     * get max legend.     * @return the get max legend     */
            public int getMaxLegend() {
                return legends.size();
            }

            @Override
    /**     * get label text.     * @param index the index     * @return the get label text     */
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
    /**     * render series.     * @param chart the chart     * @param g2 the g2     * @param size the size     * @param index the index     */
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {

            }

            @Override
    /**     * render series.     * @param chart the chart     * @param g2 the g2     * @param size the size     * @param index the index     * @param gra the gra     */
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                int ss = seriesSize / 2;

                for(int i = 0; i < legends.size(); i++) {
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight() * animate);

                    if(index == 0){
                        gra.get(i).moveTo(size.getX() + x + ss, size.getY() + size.getHeight() - seriesValues);
                    }else{
                        gra.get(i).lineTo(size.getX() + x + ss, size.getY() + size.getHeight() - seriesValues);
                    }
                    
                    x += seriesSpace + seriesSize;
                }

                if(showLabel != null) {
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
                    Dimension s = getLabelWidth(showLabel, g2);
                    int space = 3;
                    int spaceTop = 0;
                    g2.setColor(new Color(156, 151, 151));
                    g2.fillRoundRect(labelLocation.x - s.width / 2 - 3, labelLocation.y - s.height - space * 2 - spaceTop, s.width + space * 2, s.height + space * 2, 10, 10);
                    g2.setColor(new Color(0, 0, 0));
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
                    g2.drawString(showLabel, labelLocation.x - s.width / 2, labelLocation.y - spaceTop - space * 2);
                }
                
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            }

            @Override
    /**     * render graphics.     * @param g2 the g2     * @param gra the gra     */
            public void renderGraphics(Graphics2D g2, List<Path2D.Double> gra) {
                g2.setStroke(new BasicStroke(3f));

                for (int i = 0; i < gra.size(); i++) {
                    g2.setPaint(new GradientPaint(0, 0, legends.get(i).getColor(), getWidth(), 0, legends.get(i).getColorLight()));
                    g2.draw(gra.get(i));
                }
            }
            
            @Override
    /**     * mouse moving.     * @param chart the chart     * @param evt the evt     * @param g2 the g2     * @param size the size     * @param index the index     * @return the mouse moving     */
            public boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;

                for (int i = 0; i < legends.size(); i++) {
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
                    int s = seriesSize / 2;
                    int sy = seriesSize / 3;
                    int[] px = {(int) (size.getX() + x), (int) (size.getX() + x + s), (int) (size.getX() + x + seriesSize), (int) (size.getX() + x + seriesSize), (int) (size.getX() + x + s), (int) (size.getX() + x)};
                    int[] py = {(int) (size.getY() + size.getHeight() - seriesValues), (int) (size.getY() + size.getHeight() - seriesValues - sy), (int) (size.getY() + size.getHeight() - seriesValues), (int) (size.getY() + size.getHeight()), (int) (size.getY() + size.getHeight() + sy), (int) (size.getY() + size.getHeight())};

                    if (new Polygon(px, py, px.length).contains(evt.getPoint())) {
                        double data = model.get(index).getValues()[i];
                        showLabel = df.format(data);
                        labelLocation.setLocation((int) (size.getX() + x + s), (int) (size.getY() + size.getHeight() - seriesValues - sy));
                        chart.repaint();
                        return true;
                    }

                    x += seriesSpace + seriesSize;
                }

                return false;
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**     * init components.     */
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new com.hector.titulacionpredial.view.swing.chart.blankchart.BlankPlotChart();

        setBackground(new java.awt.Color(242, 242, 242));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        blankPlotChart.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**     * get blank plot chart.     * @return the get blank plot chart     */
    public BlankPlotChart getBlankPlotChart() {
        return blankPlotChart;
    }

    /**     * get panel legend.     * @return the get panel legend     */
    public JPanel getPanelLegend() {
        return panelLegend;
    }

    /**
     * Add a series legend to the chart.
     *
     * @param name   series name
     * @param color  main color
     * @param color1 light gradient color
     */
    public void addLegend(String name, Color color, Color color1){
        ModelLegend data = new ModelLegend(name, color, color1);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    /**
     * Add data from a category to the chart.
     *
     * @param data model with label and values
     */
    public void addData(ModelChart data){
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();

        if(max > blankPlotChart.getMaxValues()){
            blankPlotChart.setMaxValues(max);
        }
    }

    /**
     * Clean up all series, legends, and restart the animation.
     */
    public void clear(){
        animate = 0;
        showLabel = null;
        blankPlotChart.setLabelCount(0);
        legends.clear();
        model.clear();
        panelLegend.removeAll();
        panelLegend.repaint();
        panelLegend.revalidate();
        repaint();
    }

    /**
     * Start the animation of tracing the lines.
     */
    public void start(){
        showLabel = null;

        if(!animator.isRunning()){
            animator.start();
        }
    }

    /**
     * Calculate the dimensions of the tooltip text.
     *
     * @param text text to be measured
     * @param g2   graphic context
     * @return text dimension
     */
    private Dimension getLabelWidth(String text, Graphics2D g2){
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(text, g2);
        return new Dimension((int) r2.getWidth(), (int) r2.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.chart.blankchart.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
