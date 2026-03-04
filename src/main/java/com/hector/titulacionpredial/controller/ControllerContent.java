package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOMenuText;

/**
 * Controlador principal del contenido de la aplicación.
 *
 * <p>
 * Gestiona la navegación entre los distintos paneles de la
 * interfaz gráfica a través del menú lateral. Coordina la
 * transición entre vistas y notifica al {@link Subject}
 * cuando se requiere actualizar los datos.
 * </p>
 *
 * <p>
 * Implementa {@link LanguageObserver} como observador concreto
 * del patrón Observer, permitiendo que la vista se actualice
 * automáticamente cuando el {@link LanguageSubject} notifica
 * un cambio de idioma.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContentBuilder
 * @see NavigatorUtils
 * @see LanguageObserver
 * @since 1.0
 */
public class ControllerContent implements LanguageObserver {

    /**
     * Vista principal del contenido.
     */
    private final Content content;

    /**
     * Panel del dashboard.
     */
    private final Dashboard dashboard;

    /**
     * Panel de registro de beneficiarios.
     */
    private final RegisterBeneficiary registerBeneficiary;

    /**
     * Panel de registro de predios.
     */
    private final RegisterProperty registerProperty;

    /**
     * Panel de visualización de beneficiarios.
     */
    private final ViewBeneficiaries viewBeneficiaries;

    /**
     * Panel de visualización de predios.
     */
    private final SeeProperties seeProperties;

    /**
     * Panel de visualización de resoluciones.
     */
    private final SeeResolutions seeResolutions;

    /**
     * Panel de visualización de ajustes.
     */
    private final Settings settings;

    /**
     * Panel de información «Acerca de».
     */
    private final About about;

    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

    /**
     * Acceso al gestor de los idiomas.
     */
    private final LanguageManager lang;

    /**
     * Crea el controlador a partir de un builder que contiene
     * todas las vistas y dependencias necesarias.
     *
     * @param builder constructor con las vistas configuradas
     */
    public ControllerContent(ControllerContentBuilder builder) {
        this.content = builder.getContent();
        this.dashboard = builder.getDashboard();
        this.registerBeneficiary = builder.getRegisterBeneficiary();
        this.registerProperty = builder.getRegisterProperty();
        this.viewBeneficiaries = builder.getViewBeneficiaries();
        this.seeProperties = builder.getSeeProperties();
        this.seeResolutions = builder.getSeeResolutions();
        this.settings = builder.getSettings();
        this.about = builder.getAbout();
        this.subject = builder.getSubject();
        this.lang = builder.getLang();

        builder.getLanguageSubject().register(this);

        connectEvents();
    }

    /**
     * Conecta los eventos del menú lateral con la lógica
     * de navegación del controlador.
     */
    private void connectEvents() {
        content.setControllerMenu(this::selectedMenu);
    }

    /**
     * Gestiona la selección del menú lateral y navega al panel correspondiente.
     *
     * <p>
     * Según el índice del menú y submenú seleccionado, muestra
     * el panel adecuado y notifica a los observadores cuando
     * es necesario actualizar los datos.
     * </p>
     *
     * @param index        índice del menú principal
     * @param indexSubMenu índice del submenú seleccionado
     */
    private void selectedMenu(int index, int indexSubMenu) {
        switch (index) {
            case 0 -> {
                NavigatorUtils.showForms(dashboard);
                subject.notifyObservers();
            }
            case 1 -> {
                switch (indexSubMenu) {
                    case 1 -> {
                        NavigatorUtils.showForms(registerBeneficiary);
                        registerBeneficiary.clearFields();
                        subject.notifyObservers();
                        registerBeneficiary.setModify(false);
                    }
                    case 2 -> NavigatorUtils.showForms(registerProperty);
                }
            }
            case 2 -> {
                switch (indexSubMenu) {
                    case 1 -> NavigatorUtils.showForms(viewBeneficiaries);
                    case 2 -> NavigatorUtils.showForms(seeProperties);
                    case 3 -> NavigatorUtils.showForms(seeResolutions);
                }
            }
            case 3 -> NavigatorUtils.showForms(settings);
            case 4 -> NavigatorUtils.showForms(about);
        }
    }

    @Override
    public void updateLanguage() {
        DTOMenuText dto = new DTOMenuText.Builder()
                .mainTitle(lang.app("menu.main"))
                .dashboard(lang.app("menu.main.dashboard"))
                .info(lang.app("menu.info"))
                .registerInfo(lang.app("menu.info.register"))
                .registerBeneficiaries(lang.app("menu.info.register.beneficiary"))
                .registerProperties(lang.app("menu.info.register.property"))
                .see(lang.app("menu.info.see"))
                .seeBeneficiaries(lang.app("menu.info.see.beneficiaries"))
                .seeProperties(lang.app("menu.info.see.properties"))
                .seeResolutions(lang.app("menu.info.see.resolution"))
                .configuration(lang.app("menu.configuration.title"))
                .settings(lang.app("menu.configuration.settings"))
                .aboutApp(lang.app("menu.about"))
                .about(lang.app("menu.about.desc"))
                .build();
        
        content.getMenu().setText(dto);
    }

}
