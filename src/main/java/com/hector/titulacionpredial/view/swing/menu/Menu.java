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
public class Menu extends JPanel {

    private final List<EventMenuSelected> events = new ArrayList<>();
    private MigLayout menuLayout;
    private JPanel panelMenu;
    private int index = -1;

    private String main = "PRINCIPAL";
    private String dashboard = "Dashboard";
    private String info = "INFORMACIÓN";
    private String register = "Registrar Informacion";
    private String registerBeneficiary = "Beneficiarios";
    private String registerProperty = "Predios";
    private String see = "Ver Registros";
    private String seeBeneficiaries = "Beneficiarios";
    private String seeResolutions = "Resolucion";
    private String seeProperties = "Predios";
    private String settingsTitle = "CONFIGURACION";
    private String settings = "Ajustes";
    private String aboutTitle = "SOBRE LA APP";
    private String about = "Acerca De";

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

        rebuildMenu();
    }

    public void setText(DTOMenuText dto) {
        main = dto.getMainTitle();
        dashboard = dto.getDashboard();
        info = dto.getInfo();
        register = dto.getRegisterInfo();
        registerBeneficiary = dto.getRegisterBeneficiaries();
        registerProperty = dto.getRegisterProperties();
        see = dto.getSee();
        seeBeneficiaries = dto.getSeeBeneficiaries();
        seeResolutions = dto.getSeeResolutions();
        seeProperties = dto.getSeeProperties();
        settingsTitle = dto.getConfiguration();
        settings = dto.getSettings();
        aboutTitle = dto.getAboutApp();
        about = dto.getAbout();

        rebuildMenu();
    }

    /**
     * Add the default menu options.
     */
    public void addComponents() {
        addTitle(main);
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", dashboard));
        addTitle(info);
        addMenuItem(new ModelMenuItem("image/bookmark-plus.svg", register, registerBeneficiary, registerProperty));
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", see, seeBeneficiaries, seeProperties, seeResolutions));
        addTitle("GESTION DE USUARIOS");
        addMenuItem(new ModelMenuItem("image/info.svg", "Usuarios", "Registrar Usuarios", "Ver Usuarios"));
        addTitle(settingsTitle);
        addMenuItem(new ModelMenuItem("image/settings-2.svg", settings));
        addTitle(aboutTitle);
        addMenuItem(new ModelMenuItem("image/info.svg", about));
    }

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
