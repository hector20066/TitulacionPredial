package com.hector.titulacionpredial.view.swing.menu;

/**
 * Interfaz funcional para manejar la selección de opciones
 * en el menú lateral de la aplicación.
 *
 * @author Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface EventMenuSelected {

    void menuSelected(int index, int indexSubmenu);

}
