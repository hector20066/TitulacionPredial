package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.view.content.Content;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author hectoracevedo
 */
public class NavigatorUtils {

    public static void showForms(JComponent component) {
        Content.getJpl_content().removeAll();
        Content.getJpl_content().setLayout(new BorderLayout());
        Content.getJpl_content().add(component, BorderLayout.CENTER);
        Content.getJpl_content().revalidate();
        Content.getJpl_content().repaint();
    }

}
