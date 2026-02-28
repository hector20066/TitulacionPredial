package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * UI personalizada para barras de desplazamiento con estilo moderno.
 *
 * <p>
 * Muestra un indicador (thumb) delgado y translúcido sin
 * botones de flecha ni pista visible, logrando una
 * estética minimalista y plana.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModernScrollBarUI extends BasicScrollBarUI {

    /**
     * Grosor del indicador de desplazamiento.
     */
    private final int THUMB_SIZE = 5;

    /**
     * Color del indicador.
     */
    private final Color THUMB_COLOR = new Color(170, 170, 170);

    /**
     * Nivel de opacidad del indicador.
     */
    private final float ALPHA = 0.3f;

    /**
     * Crea la UI de la barra de desplazamiento moderna.
     */
    public ModernScrollBarUI() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getMaximumThumbSize() {
        return new Dimension(0, (int) (scrollbar.getHeight() * 0.4f));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Dimension getMinimumThumbSize() {
        return new Dimension(0, 75);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (scrollbar.getVisibleAmount() != scrollbar.getMaximum()) {
            int orientation = scrollbar.getOrientation();
            int x = thumbBounds.x + (orientation == JScrollBar.VERTICAL ? 0 : 8);
            int y = thumbBounds.y + (orientation == JScrollBar.VERTICAL ? 8 : 0);
            int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width - 16;
            width = Math.max(width, THUMB_SIZE);
            int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height - 16 : THUMB_SIZE;
            height = Math.max(height, THUMB_SIZE);

            Graphics2D graphics2D = (Graphics2D) g.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(THUMB_COLOR);
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ALPHA));
            graphics2D.fillRoundRect(x, y, width, height, 5, 5);
            graphics2D.dispose();
        }
    }

    /**
     * Botón invisible que reemplaza las flechas de desplazamiento.
     */
    private static class InvisibleScrollBarButton extends JButton {

        /**
         * Crea el botón invisible.
         */
        private InvisibleScrollBarButton() {
            init();
        }

        /**
         * Configura la apariencia invisible del botón.
         */
        private void init() {
            setOpaque(false);
            setFocusable(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setBorder(BorderFactory.createEmptyBorder());
        }

    }

}
