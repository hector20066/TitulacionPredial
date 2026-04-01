package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTOReadingMenuText;
import com.hector.titulacionpredial.view.swing.menu.Menu;
import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ReadingMenu extends Menu {

    private String main = "PRINCIPAL";
    private String dashboard = "Dashboard";
    private String info = "INFORMACIÓN";
    private String seeRegisters = "Ver Registros";
    private String seeBeneficiaries = "Beneficiario";
    private String seeProperties = "Predios";
    private String seeResolutions = "Resoluciones";
    private String config = "CONFIGURACIÓN";
    private String settings = "Ajustes";
    private String aboutApp = "SOBRE LA APP";
    private String about = "Acerca De";

    /**
     * Creates a reading menu and initializes its structure.
     */
    public ReadingMenu() {
        super();
        rebuildMenu();
    }

    /**
     * Initialize and add menu components to the panel.
     */
    @Override
    public void addComponents() {
        addTitle(this.main);
        addMenuItem(new ModelMenuItem("image/layout-dashboard.svg", this.dashboard));
        addTitle(this.info);
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", this.seeRegisters, this.seeBeneficiaries, this.seeProperties, this.seeResolutions));
        addTitle(this.config);
        addMenuItem(new ModelMenuItem("image/settings-2.svg", this.settings));
        addTitle(this.aboutApp);
        addMenuItem(new ModelMenuItem("image/info.svg", this.about));
    }

    /**
     * Update the menu texts with the provided translations.
     *
     * @param texts the DTO containing localized menu labels
     */
    public void setText(DTOReadingMenuText texts) {
        this.main = texts.getMainTitle();
        this.dashboard = texts.getDashboard();
        this.info = texts.getInfo();
        this.seeRegisters = texts.getSee();
        this.seeBeneficiaries = texts.getSeeBeneficiaries();
        this.seeProperties = texts.getSeeProperties();
        this.seeResolutions = texts.getSeeResolutions();
        this.config = texts.getConfiguration();
        this.settings = texts.getSettings();
        this.aboutApp = texts.getAboutApp();
        this.about = texts.getAbout();

        rebuildMenu();
    }

}
