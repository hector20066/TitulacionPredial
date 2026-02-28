package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import java.awt.*;

/**
 * Barra de desplazamiento personalizada que aplica
 * {@link ModernScrollBarUI} automáticamente.
 *
 * @author Ing. Hector Acevedo
 * @see ModernScrollBarUI
 * @since 1.0
 */
public class ScrollBar extends JScrollBar {

    /**
     * Crea una barra de desplazamiento con estilo moderno.
     */
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }

}
