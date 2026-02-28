package com.hector.titulacionpredial.view.swing.button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Botón personalizado para los controles de ventana
 * (minimizar, maximizar, cerrar).
 *
 * <p>
 * Extiende {@link JButton} con un estilo plano sin borde
 * ni fondo, utilizando un icono SVG centrado.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class WindowButton extends JButton {

    public WindowButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        g2.setColor(getBackground());
        g2.fillOval(x, y, size, size);
        super.paint(g);
    }

}
