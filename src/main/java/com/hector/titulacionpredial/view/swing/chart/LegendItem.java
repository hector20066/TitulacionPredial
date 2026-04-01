package com.hector.titulacionpredial.view.swing.chart;

import com.hector.titulacionpredial.view.swing.model.ModelLegend;

import javax.swing.*;

/**
 * Individual element of a chart legend.
 *
 * <p>
 * Displays a color indicator along with the corresponding
 * series label. It is used as a component within the legend
 * of the {@link LineChart}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see ModelLegend
 */
public class LegendItem extends javax.swing.JPanel {

    /**
     * Create a legend element with the color and name of the series.
     *
     * @param data legend model
     */
    public LegendItem(ModelLegend data) {
        initComponents();
        
        labelColor1.setBackground(data.getColor());
        lbName.setText(data.getName());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**     * init components.     */
    private void initComponents() {

        labelColor1 = new com.hector.titulacionpredial.view.swing.chart.LabelColor();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelColor1.setText("labelColor1");

        lbName.setForeground(new java.awt.Color(180, 180, 180));
        lbName.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(lbName)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbName)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public LabelColor getLbColor() {
        return labelColor1;
    }

    public JLabel getLbName() {
        return lbName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hector.titulacionpredial.view.swing.chart.LabelColor labelColor1;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
