package com.hector.titulacionpredial.view.swing.scroll;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author hectoracevedo
 */
public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }

}
