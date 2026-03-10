package com.hector.titulacionpredial.view.swing.chart;

import com.hector.titulacionpredial.view.swing.model.CardModel;

import java.awt.*;

/**
 * Visual card with gradient background for the dashboard.
 *
 * <p>
 * Displays an icon, title, and numerical values with a
 * customizable gradient background. Used to present key statistics on the dashboard.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see CardModel
 */
public class Card extends javax.swing.JPanel {

    private Color color1;
    private Color color2;

    /**
     * Create a card with a default black to white gradient.
     */
    public Card() {
        initComponents();
        
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setColor1(Color color1){
        this.color1 = color1;
    }

    public void setColor2(Color color2){
        this.color2 = color2;
    }

    public Color getColor1(){
        return color1;
    }

    public Color getColor2(){
        return color2;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlb_title = new javax.swing.JLabel();
        jlb_value = new javax.swing.JLabel();
        jlb_description = new javax.swing.JLabel();
        jlb_icon = new javax.swing.JLabel();

        jlb_title.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlb_title.setForeground(new java.awt.Color(255, 255, 255));
        jlb_title.setText("Title");

        jlb_value.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jlb_value.setForeground(new java.awt.Color(255, 255, 255));
        jlb_value.setText("Values");

        jlb_description.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlb_description.setForeground(new java.awt.Color(255, 255, 255));
        jlb_description.setText("Description");

        jlb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stock.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_icon)
                    .addComponent(jlb_title)
                    .addComponent(jlb_value)
                    .addComponent(jlb_description))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jlb_icon)
                .addGap(18, 18, 18)
                .addComponent(jlb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_value)
                .addGap(18, 18, 18)
                .addComponent(jlb_description)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Enter the card details.
     *
     * @param data data model
     */
    public void setData(CardModel data){
        jlb_icon.setIcon(data.getIcon());
        jlb_title.setText(data.getTitle());
        jlb_value.setText(data.getValues());
        jlb_description.setText(data.getDescription());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlb_description;
    private javax.swing.JLabel jlb_icon;
    private javax.swing.JLabel jlb_title;
    private javax.swing.JLabel jlb_value;
    // End of variables declaration//GEN-END:variables
}
