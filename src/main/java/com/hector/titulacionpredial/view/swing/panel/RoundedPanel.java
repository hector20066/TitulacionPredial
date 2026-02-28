package com.hector.titulacionpredial.view.swing.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Panel con esquinas redondeadas y borde opcional.
 *
 * <p>
 * Dibuja un fondo con {@code RoundRectangle2D} y permite
 * configurar el radio de las esquinas y el color del borde.
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
     * Crea un panel redondeado con radio predeterminado de 15px.
     */
    public RoundedPanel() {
        this(15);
    }

    /**
     * Crea un panel redondeado con el radio especificado.
     *
     * @param radius radio de las esquinas
     */
    public RoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);
    }

    /**
     * Indica si el borde se dibuja.
     *
     * @return {@code true} si se dibuja el borde
     */
    public boolean isDrawBorder() {
        return drawBorder;
    }

    /**
     * Establece si se dibuja el borde.
     *
     * @param drawBorder {@code true} para dibujar el borde
     */
    public void setDrawBorder(boolean drawBorder) {
        this.drawBorder = drawBorder;
        repaint();
    }

    /**
     * Establece el color del borde.
     *
     * @param borderColor color del borde
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
