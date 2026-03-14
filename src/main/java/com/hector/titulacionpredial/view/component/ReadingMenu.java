package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.swing.menu.Menu;
import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ReadingMenu extends Menu {

    public ReadingMenu() {
        super();
        rebuildMenu();
    }

    @Override
    public void addComponents() {
        addTitle("PRINCIPAL");
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", "Dashboard"));
        addTitle("INFORMACIÓN");
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
