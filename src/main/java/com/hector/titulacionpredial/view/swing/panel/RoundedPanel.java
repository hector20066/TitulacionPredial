package com.hector.titulacionpredial.view.swing.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Panel with rounded corners and optional border.
 *
 * <p>
 * Draw a background with {@code RoundRectangle2D} and allow
 * you to configure the corner radius and border color.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class RoundedPanel extends JPanel {

    private final int cornerRadius;
    private boolean drawBorder = true;
    private Color borderColor = Color.BLACK;

    /**
     * Create a rounded panel with a default radius of 15px.
     */
    public RoundedPanel() {
        this(15);
    }

    /**
     * Creates a rounded panel with the specified radius.
     *
     * @param radius corner radius
     */
    public RoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);
    }

    /**
     * Indicates whether the border is drawn.
     *
     * @return {@code true} if the border is drawn
     */
    public boolean isDrawBorder() {
        return drawBorder;
    }

    /**
     * Determines whether the border is drawn.
     *
     * @param drawBorder {@code true} to draw the border
     */
    public void setDrawBorder(boolean drawBorder) {
        this.drawBorder = drawBorder;
        repaint();
    }

    /**
     * Set the border color.
     *
     * @param borderColor border color
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    /**     * paint component.     * @param g the g     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, cornerRadius, cornerRadius));

        if (drawBorder) {
            g2.setColor(borderColor != null ? borderColor : getForeground());
            g2.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, cornerRadius, cornerRadius));
        }

        g2.dispose();
    }

}
