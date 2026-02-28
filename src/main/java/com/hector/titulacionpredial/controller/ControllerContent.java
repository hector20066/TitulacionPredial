package com.hector.titulacionpredial.controller;

import com.hector.titulacionpredial.controller.builder.ControllerContentBuilder;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.utils.NavigatorUtils;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

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
 * @author Hector Acevedo
 * @see ControllerContentBuilder
 * @see NavigatorUtils
 * @since 1.0
 */
public class ControllerContent {

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
     * Panel de información «Acerca de».
     */
    private final About about;
    /**
     * Sujeto del patrón Observer para notificar cambios.
     */
    private final Subject subject;

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
        this.about = builder.getAbout();
        this.subject = builder.getSubject();

        connectEvents();
    }

    private void connectEvents() {
        content.setControllerMenu(this::selectedMenu);
    }

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
            case 3 -> NavigatorUtils.showForms(about);
        }
    }

}
