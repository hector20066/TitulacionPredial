package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import java.awt.*;

/**
 * Custom scroll bar that automatically applies {@link ModernScrollBarUI}.
 *
 * @author Ing. Hector Acevedo
 * @see ModernScrollBarUI
 * @since 1.0
 */
public class ScrollBar extends JScrollBar {

    /**
     * Create a scroll bar with a modern style.
     */
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }

}
