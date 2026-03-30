package com.hector.titulacionpredial.view.swing.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hector.titulacionpredial.view.swing.shadow.ShadowBorder;

/**
 * Panel with interior and exterior shadow effect.
 *
 * <p>
 * Use {@link ShadowBorder} to render shadows around
 * the panel content. Configurable for corner radius
 * and shadow size.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ShadowBorder
 * @since 1.0
 */
public class PanelShadow extends JPanel {

    private ShadowBorder.ShadowType shadowType = ShadowBorder.ShadowType.OUT_SHADOW;
    private int radius = 20;
    private int shadowSize = 8;
    private BufferedImage imageShadow;

    /**
     * Create a panel with a default outer shadow.
     */
    public PanelShadow() {
        setBackground(new Color(242, 246, 253));
        setBorder(new EmptyBorder(16, 16, 16, 16));
        setOpaque(false);
    }

    /**     * get shadow type.     * @return the get shadow type     */
    public ShadowBorder.ShadowType getShadowType() {
        return shadowType;
    }

    /**     * set shadow type.     * @param shadowType the shadow type     */
    public void setShadowType(ShadowBorder.ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    /**     * get radius.     * @return the get radius     */
    public int getRadius() {
        return radius;
    }

    /**     * set radius.     * @param radius the radius     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**     * get shadow size.     * @return the get shadow size     */
    public int getShadowSize() {
        return shadowSize;
    }

    /**
     * Set the size of the shadow border.
     *
     * @param shadowSize shadow size
     */
    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * paint component.     * @param g the g     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imageShadow != null) {
            g.drawImage(imageShadow, 0, 0, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createShadowImage();
    }

    /**
     * Create the shadow image according to the configured type.
     */
    private void createShadowImage() {
        if (shadowType == ShadowBorder.ShadowType.OUT_SHADOW) {
            imageShadow = ShadowBorder.getInstance().createShadowOut(this, shadowSize, radius);
        } else {
            imageShadow = ShadowBorder.getInstance().createShadowIn(this, shadowSize, radius);
        }
    }

}
