package com.hector.titulacionpredial.view.swing.panel;

import com.hector.titulacionpredial.view.swing.shadow.ShadowBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author hectoracevedo
 */
public class PanelShadow extends JPanel {

    private ShadowBorder.ShadowType shadowType = ShadowBorder.ShadowType.OUT_SHADOW;
    private int radius = 20;
    private int shadowSize = 8;
    private BufferedImage imageShadow;

    public PanelShadow() {
        setBackground(new Color(242, 246, 253));
        setBorder(new EmptyBorder(16, 16, 16, 16));
        setOpaque(false);
    }

    public void setShadowType(ShadowBorder.ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    public ShadowBorder.ShadowType getShadowType() {
        return shadowType;
    }

    public int getRadius() {
        return radius;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imageShadow != null) {
            g.drawImage(imageShadow, 0, 0, null);
        }
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createShadowImage();
    }

    private void createShadowImage() {
        if (shadowType == ShadowBorder.ShadowType.OUT_SHADOW) {
            imageShadow = ShadowBorder.getInstance().createShadowOut(this, shadowSize, radius);
        } else {
            imageShadow = ShadowBorder.getInstance().createShadowIn(this, shadowSize, radius);
        }
    }

}
