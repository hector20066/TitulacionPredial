package com.hector.titulacionpredial.view.swing.menu;

import com.hector.titulacionpredial.i18n.LanguageManager;
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
 * Panel del menú lateral de navegación de la aplicación.
 *
 * <p>
 * Organiza los elementos de menú ({@link MenuItem}) en una
 * lista vertical con scroll personalizado. Gestiona la
 * selección de opciones y notifica al controlador mediante
 * {@link EventMenuSelected}.
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

    private final LanguageManager lang = LanguageManager.getInstance();

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
     * Crea el menú lateral con los componentes predeterminados.
     */
    public Menu() {
        init();
    }

    /**
     * Inicializa el layout, scroll y panel del menú.
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

    private void setText(DTOMenuText dto) {
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
    }

    /**
     * Agrega las opciones de menú predeterminadas.
     */
    public void addComponents() {
        addTitle(main);
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", dashboard));
        addTitle(info);
        addMenuItem(new ModelMenuItem("image/bookmark-plus.svg", register, registerBeneficiary, registerProperty));
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", see, seeBeneficiaries, seeProperties, seeResolutions));
        addTitle(settingsTitle);
        addMenuItem(new ModelMenuItem("image/settings-2.svg", settings));
        addTitle(lang.app(aboutTitle));
        addMenuItem(new ModelMenuItem("image/info.svg", about));
    }

    /**
     * Crea un scroll personalizado sin bordes.
     *
     * @return panel de scroll
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
     * Crea el panel contenedor de ítems de menú.
     *
     * @return panel del menú
     */
    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    /**
     * Crea un ítem de menú con sus eventos de selección.
     *
     * @param item modelo del menú
     * @return panel del ítem
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
     * Notifica a los listeners la selección de un menú.
     *
     * @param index        índice del menú
     * @param indexSubMenu índice del sub-menú
     */
    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    /**
     * Agrega un ítem de menú al panel.
     *
     * @param menu modelo del menú
     */
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    /**
     * Reconstruye el menú eliminando y volviendo a agregar los componentes.
     */
    protected void rebuildMenu() {
        panelMenu.removeAll();
        index = -1;
        addComponents();
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    /**
     * Agrega un título de sección al menú.
     *
     * @param title texto del título
     */
    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    /**
     * Agrega un espacio vertical al menú.
     *
     * @param size tamaño del espacio en píxeles
     */
    public void addSpace(int size) {
        panelMenu.add(new Label(), "h " + size + "!");
    }

    /**
     * Selecciona un ítem y sub-ítem del menú por índice.
     *
     * @param index        índice del menú
     * @param indexSubMenu índice del sub-menú
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
     * Limpia la selección de todos los ítems del menú.
     */
    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                item.clearSelected();
            }
        }
    }

    /**
     * Agrega un listener de selección de menú.
     *
     * @param event listener a agregar
     */
    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

}
