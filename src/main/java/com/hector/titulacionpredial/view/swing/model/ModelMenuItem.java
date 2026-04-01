package com.hector.titulacionpredial.view.swing.model;

/**
 * Data model for side menu items.
 *
 * <p>
 * It contains the SVG icon, the main menu name, and the list
 * of sub-menu names.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ModelMenuItem {

    private String icon;
    private String menuName;
    private String[] subMenu;

    /**
     * Create an empty menu template.
     */
    public ModelMenuItem() {

    }

    /**
     * Create a menu template with the specified data.
     *
     * @param icon     SVG icon path
     * @param menuName menu name
     * @param subMenu  sub-menu names
     */
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
