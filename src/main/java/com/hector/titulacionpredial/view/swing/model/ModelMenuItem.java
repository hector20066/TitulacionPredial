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

    /**     * get icon.     * @return the get icon     */
    public String getIcon() {
        return icon;
    }

    /**     * set icon.     * @param icon the icon     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**     * get menu name.     * @return the get menu name     */
    public String getMenuName() {
        return menuName;
    }

    /**     * set menu name.     * @param menuName the menu name     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**     * get sub menu.     * @return the get sub menu     */
    public String[] getSubMenu() {
        return subMenu;
    }

    /**     * set sub menu.     * @param subMenu the sub menu     */
    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

}
