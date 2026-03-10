package com.hector.titulacionpredial.view.swing.menu;

/**
 * Functional interface for managing the selection of
 * options in the application's side menu.
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
@FunctionalInterface
public interface EventMenuSelected {

    /**
     * It is invoked when the user selects an option from the menu.
     *
     * @param index        index of the selected main menu
     * @param indexSubmenu index of the selected sub-menu
     */
    void menuSelected(int index, int indexSubmenu);

}
