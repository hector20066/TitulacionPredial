package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.view.content.Content;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class for navigating between panels within the
 * main content of the application.
 *
 * <p>
 * It allows you to dynamically replace the content of the
 * main panel ({@link Content}) with the specified component.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see Content
 * @since 1.0
 */
public class NavigatorUtils {

    /**
     * Displays the provided component as the active form
     * in the main content panel.
     *
     * @param component Swing component to be displayed
     */
    public static void showForms(JComponent component) {
        Content.getJpl_content().removeAll();
        Content.getJpl_content().setLayout(new BorderLayout());
        Content.getJpl_content().add(component, BorderLayout.CENTER);
        Content.getJpl_content().revalidate();
        Content.getJpl_content().repaint();
    }

}
