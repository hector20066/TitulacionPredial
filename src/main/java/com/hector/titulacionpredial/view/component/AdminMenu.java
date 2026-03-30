package com.hector.titulacionpredial.view.component;

import com.hector.titulacionpredial.view.i18n.dto.panels.DTOAdminMenuText;
import com.hector.titulacionpredial.view.swing.menu.Menu;
import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;

/**
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class AdminMenu extends Menu {

    private String main = "PRINCIPAL";
    private String dashboard = "Dashboard";
    private String info = "INFORMACIÓN";
    private String registerInfo = "Registrar Información";
    private String registerBeneficiaries = "Beneficiario";
    private String registerProperties = "Predios";
    private String seeRegisters = "Ver Registros";
    private String seeBeneficiaries = "Beneficiario";
    private String seeProperties = "Predios";
    private String seeResolutions = "Resoluciones";
    private String manageUsers = "GESTION DE USUARIOS";
    private String users = "Usuarios";
    private String registerUsers = "Registrar Usuarios";
    private String seeUsers = "Ver Usuarios";
    private String config = "CONFIGURACIÓN";
    private String settings = "Ajustes";
    private String aboutApp = "SOBRE LA APP";
    private String about = "Acerca De";

    /**     * admin menu.     * @return the admin menu     */
    public AdminMenu() {
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
        addMenuItem(new ModelMenuItem("image/bookmark-plus.svg", this.registerInfo, this.registerBeneficiaries, this.registerProperties));
        addMenuItem(new ModelMenuItem("image/book-open-text.svg", this.seeRegisters, this.seeBeneficiaries, this.seeProperties, this.seeResolutions));
        addTitle(this.manageUsers);
        addMenuItem(new ModelMenuItem("image/info.svg", this.users, this.registerUsers, this.seeUsers));
        addTitle(this.config);
        addMenuItem(new ModelMenuItem("image/settings-2.svg", this.settings));
        addTitle(this.aboutApp);
        addMenuItem(new ModelMenuItem("image/info.svg", this.about));
    }

    public void setText(DTOAdminMenuText texts) {
        this.main = texts.getMainTitle();
        this.dashboard = texts.getDashboard();
        this.info = texts.getInfo();
        this.registerInfo = texts.getRegisterInfo();
        this.registerBeneficiaries = texts.getRegisterBeneficiaries();
        this.registerProperties = texts.getRegisterProperties();
        this.seeRegisters = texts.getSee();
        this.seeBeneficiaries = texts.getSeeBeneficiaries();
        this.seeProperties = texts.getSeeProperties();
        this.seeResolutions = texts.getSeeResolutions();
        this.manageUsers = texts.getManageUsers();
        this.users = texts.getUsers();
        this.registerUsers = texts.getRegisterUser();
        this.seeUsers = texts.getSeeUsers();
        this.config = texts.getConfiguration();
        this.settings = texts.getSettings();
        this.aboutApp = texts.getAboutApp();
        this.about = texts.getAbout();

        rebuildMenu();
    }

}
