package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import java.awt.*;

/**
 * Barra de desplazamiento personalizada que aplica
 * {@link ModernScrollBarUI} automáticamente.
 *
 * @author Hector Acevedo
 * @since 1.0
 * @see ModernScrollBarUI
 */
public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }

}
