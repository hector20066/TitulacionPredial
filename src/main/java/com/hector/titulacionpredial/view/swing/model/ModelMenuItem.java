package com.hector.titulacionpredial.view.swing.model;

/**
 * Modelo de datos para los elementos del menú lateral.
 *
 * <p>
 * Contiene el icono SVG, el nombre del menú principal
 * y la lista de nombres de los sub-menús.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class ModelMenuItem {

    private String icon;
    private String menuName;
    private String[] subMenu;

    public ModelMenuItem() {

    }

    public ModelMenuItem(String icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }
}
