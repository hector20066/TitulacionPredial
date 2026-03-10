package com.hector.titulacionpredial.view.swing.chart;

import javax.swing.*;
import java.awt.*;

/**
 * Label ({@link JLabel}) with custom rendering of
 * rounded background color.
 *
 * <p>
 * Used as a color indicator in chart legends.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class LabelColor extends JLabel {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height) - 4;
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        g2.setColor(getBackground());
        g2.fillOval(x, y, size, size);
    }

}
