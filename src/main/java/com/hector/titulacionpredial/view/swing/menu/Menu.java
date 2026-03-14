package com.hector.titulacionpredial.view.swing.menu;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTOMenuText;
import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;
import com.hector.titulacionpredial.view.swing.scroll.ScrollBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Application navigation side menu panel.
 *
 * <p>
 * Organizes menu items ({@link MenuItem}) into a vertical
 * list with custom scrolling. Manages option selection and
 * notifies the controller using {@link EventMenuSelected}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see MenuItem
 * @see EventMenuSelected
 * @since 1.0
 */
public abstract class Menu extends JPanel {

    private final List<EventMenuSelected> events = new ArrayList<>();
    private MigLayout menuLayout;
    private JPanel panelMenu;
    private int index = -1;

    /**
     * Create the side menu with the default components.
     */
    public Menu() {
        init();
    }

    /**
     * Initializes the layout, scroll, and menu panel.
     */
    private void init() {
        setBackground(Color.white);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
    }

    /**
     * Add the default menu options.
     */
    public abstract void addComponents();

    /**
     * Create a custom borderless scroll.
     *
     * @return scroll panel
     */
    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());

        return scroll;
    }

    /**
     * Create the menu item container panel.
     *
     * @return menu panel
     */
    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    /**
     * Create a menu item with its selection events.
     *
     * @param item menu template
     * @return item panel
     */
    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);

        menuItem.addEvent((index, indexSubMenu) -> {
            if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                clearSelected();
                setSelectedIndex(index, indexSubMenu);
            }
        });

        return menuItem;
    }

    /**
     * Notifies listeners of a menu selection.
     *
     * @param index        menu index
     * @param indexSubMenu sub-menu index
     */
    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    /**
     * Add a menu item to the panel.
     *
     * @param menu menu template
     */
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    /**
     * Rebuild the menu by removing and re-adding the components.
     */
    protected void rebuildMenu() {
        panelMenu.removeAll();
        index = -1;
        addComponents();
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    /**
     * Add a section title to the menu.
     *
     * @param title title text
     */
    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    /**
     * Add a vertical space to the menu.
     *
     * @param size space size in pixels
     */
    public void addSpace(int size) {
        panelMenu.add(new Label(), "h " + size + "!");
    }

    /**
     * Select an item and sub-item from the menu by index.
     *
     * @param index        menu index
     * @param indexSubMenu sub-menu index
     */
    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    /**
     * Clear the selection of all menu items.
     */
    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                item.clearSelected();
            }
        }
    }

    /**
     * Add a menu selection listener.
     *
     * @param event listener to add
     */
    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

}
