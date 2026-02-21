package com.hector.titulacionpredial.view.swing.menu;

import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;
import com.hector.titulacionpredial.view.swing.scroll.ScrollBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoracevedo
 */
public class Menu extends JPanel {

    private MigLayout menuLayout;
    private JPanel panelMenu;
    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.white);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        
        rebuildMenu();
    }

    public void addComponents() {
        addTitle("PRINCIPAL");
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", "Dashboard"));
        addTitle("INFORMACIÓN");
        addMenuItem(new ModelMenuItem("image/bookmark-plus.svg", "Registrar Información", "Beneficiarios", "Predios"));
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", "Ver registros", "Beneficiarios", "Reportes", "Resolución"));
        /*addTitle("CONFIGURACIÓN");
        addMenuItem(new ModelMenuItem("image/settings-2.svg", "Ajustes"));*/
        addTitle("SOBRE LA APP");
        addMenuItem(new ModelMenuItem("image/info.svg", "Acerca De"));
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());

        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

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

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    protected void rebuildMenu() {
        panelMenu.removeAll();
        index = -1;
        addComponents();
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new Label(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;

                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

}
