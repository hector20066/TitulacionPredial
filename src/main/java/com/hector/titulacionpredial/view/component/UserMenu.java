package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.swing.menu.Menu;
import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UserMenu extends Menu {

    /**     * user menu.     * @return the user menu     */
    public UserMenu() {
        super();
        rebuildMenu();
    }

    /**
     * Initialize and add menu components to the panel.
     */
    @Override
    public void addComponents() {
        addTitle("PRINCIPAL");
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", "Dashboard"));
        addTitle("INFORMACIÓN");
        addMenuItem(new ModelMenuItem("image/bookmark-plus.svg", "Registrar Informacion", "Beneficiarios", "Predios"));
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", "Ver Registros", "Beneficiarios", "Predios", "Resolucion"));
        addTitle("CONFIGURACION");
        addMenuItem(new ModelMenuItem("image/settings-2.svg", "Ajustes"));
        addTitle("SOBRE LA APP");
        addMenuItem(new ModelMenuItem("image/info.svg", "Acerca De"));
    }

    public void setText(/* DTO */) {
        // String title = dto.getTitle();
        rebuildMenu();
    }

}
