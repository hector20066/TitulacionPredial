package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.view.content.ContentAdmin;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class for navigating between panels within the
 * main content of the application.
 *
 * <p>
 * It allows you to dynamically replace the content of the
 * main panel ({@link ContentAdmin}) with the specified component.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ContentAdmin
 * @since 1.0
 */
public class NavigatorUtils {

    /**
     * Displays the provided component as the active form
     * in the main content panel.
     *
     * @param componentParent swing componentParent
     * @param component Swing component to be displayed
     */
    public static void showForms(JComponent componentParent, JComponent component) {
        componentParent.removeAll();
        componentParent.setLayout(new BorderLayout());
        componentParent.add(component, BorderLayout.CENTER);
        componentParent.revalidate();
        componentParent.repaint();
    }

}
