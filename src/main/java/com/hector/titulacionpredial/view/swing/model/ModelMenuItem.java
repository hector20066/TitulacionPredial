package com.hector.titulacionpredial.view.swing.model;

/**
 *
 * @author hectoracevedo
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
