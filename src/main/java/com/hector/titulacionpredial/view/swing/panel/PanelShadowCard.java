package com.hector.titulacionpredial.view.swing.panel;

import com.hector.titulacionpredial.view.swing.shadow.chart.ShadowRendererChart;
import com.hector.titulacionpredial.view.swing.shadow.chart.ShadowType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Panel with card-like shadow effect.
 *
 * <p>
 * Use {@link ShadowRendererChart} to generate shadow images in
 * different positions ({@link ShadowType}). It supports 7 shadow
 * directions: center, corners, and edges.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ShadowRendererChart
 * @see ShadowType
 * @since 1.0
 */
public class PanelShadowCard extends JPanel {

    private ShadowType shadowType = ShadowType.CENTER;
    private int shadowSize = 10;
    private float shadowOpacity = 0.3f;
    /**     * color.     * @return the color     */
    private Color shadowColor = new Color(48, 44, 90);
    private BufferedImage shadowImage;

    /**
     * Create a panel with a centered card-style shadow.
     */
    public PanelShadowCard() {
        setOpaque(false);
    }

    /**     * get shadow type.     * @return the get shadow type     */
    public ShadowType getShadowType() {
        return shadowType;
    }

    /**     * set shadow type.     * @param shadowType the shadow type     */
    public void setShadowType(ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    /**     * get shadow size.     * @return the get shadow size     */
    public int getShadowSize() {
        return shadowSize;
    }

    /**     * set shadow size.     * @param shadowSize the shadow size     */
    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    /**     * get shadow opacity.     * @return the get shadow opacity     */
    public float getShadowOpacity() {
        return shadowOpacity;
    }

    /**     * set shadow opacity.     * @param shadowOpacity the shadow opacity     */
    public void setShadowOpacity(float shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    /**     * get shadow color.     * @return the get shadow color     */
    public Color getShadowColor() {
        return shadowColor;
    }

    /**     * set shadow color.     * @param shadowColor the shadow color     */
    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * paint component.     * @param grphcs the grphcs     */
    protected void paintComponent(Graphics grphcs) {
        grphcs.drawImage(shadowImage, 0, 0, null);
        super.paintComponent(grphcs);
    }

    /**
     * Create the shadow image according to the configured type and position.
     */
    private void createShadow() {
        int size = shadowSize * 2;
        int x = 0;
        int y = 0;
        int width = getWidth() - size;
        int height = getHeight() - size;

        if (shadowType == ShadowType.TOP) {
            x = shadowSize;
            y = size;
        } else if (shadowType == ShadowType.BOT) {
            x = shadowSize;
            y = 0;
        } else if (shadowType == ShadowType.TOP_LEFT) {
            x = size;
            y = size;
        } else if (shadowType == ShadowType.TOP_RIGHT) {
            x = 0;
            y = size;
        } else if (shadowType == ShadowType.BOT_LEFT) {
            x = size;
            y = 0;
        } else if (shadowType == ShadowType.BOT_RIGHT) {
            x = 0;
            y = 0;
        } else {
            x = shadowSize;
            y = shadowSize;
        }

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, width, height, 10, 10);
        ShadowRendererChart render = new ShadowRendererChart(shadowSize, shadowOpacity, shadowColor);
        shadowImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = shadowImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.fillRoundRect(x, y, width, height, 10, 10);
        g2.dispose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * set bounds.     * @param i the i     * @param i1 the i1     * @param i2 the i2     * @param i3 the i3     */
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createShadow();
    }

}
