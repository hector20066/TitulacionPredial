package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.view.content.Content;

import javax.swing.*;
import java.awt.*;

/**
 * Clase utilitaria para la navegación entre paneles
 * dentro del contenido principal de la aplicación.
 *
 * <p>
 * Permite reemplazar dinámicamente el contenido del panel
 * principal ({@link Content}) con el componente indicado.
 * </p>
 *
 * @author Hector Acevedo
 * @see Content
 * @since 1.0
 */
public class NavigatorUtils {

    /**
     * Muestra el componente proporcionado como formulario activo
     * en el panel de contenido principal.
     *
     * @param component componente Swing a mostrar
     */
    public static void showForms(JComponent component) {
        Content.getJpl_content().removeAll();
        Content.getJpl_content().setLayout(new BorderLayout());
        Content.getJpl_content().add(component, BorderLayout.CENTER);
        Content.getJpl_content().revalidate();
        Content.getJpl_content().repaint();
    }

}
