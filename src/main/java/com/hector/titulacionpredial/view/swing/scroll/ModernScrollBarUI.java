package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Custom UI for scroll bars with modern style.
 *
 * <p>
 * It features a thin, translucent indicator (thumb) with
 * no arrow buttons or visible track, achieving a minimalist
 * and flat aesthetic.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 5;

    private final Color THUMB_COLOR = new Color(170, 170, 170);

    private final float ALPHA = 0.3f;

    /**
     * Create the modern scrollbar UI.
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
     * Invisible button that replaces the scroll arrows.
     */
    private static class InvisibleScrollBarButton extends JButton {

        /**
         * Create the invisible button.
         */
        private InvisibleScrollBarButton() {
            init();
        }

        /**
         * Configure the invisible appearance of the button.
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
