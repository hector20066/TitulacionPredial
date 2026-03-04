package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.ControllerContent;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.Content;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder para construir el {@link ControllerContent} con
 * todas sus vistas y dependencias.
 *
 * <p>
 * Permite configurar de forma fluida cada panel de la
 * aplicación antes de crear el controlador principal
 * del contenido mediante el método {@link #build()}.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ControllerContent
 * @since 1.0
 */
public class ControllerContentBuilder {

    private Content content;
    private Dashboard dashboard;
    private RegisterBeneficiary registerBeneficiary;
    private RegisterProperty registerProperty;
    private ViewBeneficiaries viewBeneficiaries;
    private SeeProperties seeProperties;
    private SeeResolutions seeResolutions;
    private Settings settings;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;
    private About about;

    /**
     * Asigna la vista principal del contenido de la aplicación.
     *
     * @param content vista principal del contenido
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewContent(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Asigna la vista del panel de inicio (dashboard).
     *
     * @param dashboard vista del dashboard
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Asigna la vista del panel de registro de beneficiarios.
     *
     * @param registerBeneficiary vista de registro de beneficiarios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewRegisterBeneficiary(RegisterBeneficiary registerBeneficiary) {
        this.registerBeneficiary = registerBeneficiary;
        return this;
    }

    /**
     * Asigna la vista del panel de registro de predios.
     *
     * @param registerProperty vista de registro de predios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewRegisterProperty(RegisterProperty registerProperty) {
        this.registerProperty = registerProperty;
        return this;
    }

    /**
     * Asigna la vista del panel de visualización de beneficiarios.
     *
     * @param viewBeneficiaries vista de visualización de beneficiarios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewBeneficiaries(ViewBeneficiaries viewBeneficiaries) {
        this.viewBeneficiaries = viewBeneficiaries;
        return this;
    }

    /**
     * Asigna la vista del panel de consulta de predios.
     *
     * @param seeProperties vista de consulta de predios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Asigna la vista del panel de consulta de resoluciones.
     *
     * @param seeResolutions vista de consulta de resoluciones
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**
     * Asigna la vista del panel de configuración.
     *
     * @param settings vista de configuración
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Asigna la vista del panel «Acerca de».
     *
     * @param about vista del panel Acerca de
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerContentBuilder withViewAbout(About about) {
        this.about = about;
        return this;
    }

    /**
     * Construye una nueva instancia de {@link ControllerContent}
     *
     * @return nuevo DTO configurado
     */
    public ControllerContent build() {
        return new ControllerContent(this);
    }

    /**
     * Obtiene la vista principal del contenido.
     *
     * @return vista principal del contenido
     */
    public Content getContent() {
        return content;
    }

    /**
     * Obtiene la vista del dashboard.
     *
     * @return vista del dashboard
     */
    public Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * Obtiene la vista de registro de beneficiarios.
     *
     * @return vista de registro de beneficiarios
     */
    public RegisterBeneficiary getRegisterBeneficiary() {
        return registerBeneficiary;
    }

    /**
     * Obtiene la vista de registro de predios.
     *
     * @return vista de registro de predios
     */
    public RegisterProperty getRegisterProperty() {
        return registerProperty;
    }

    /**
     * Obtiene la vista de visualización de beneficiarios.
     *
     * @return vista de visualización de beneficiarios
     */
    public ViewBeneficiaries getViewBeneficiaries() {
        return viewBeneficiaries;
    }

    /**
     * Obtiene la vista de consulta de predios.
     *
     * @return vista de consulta de predios
     */
    public SeeProperties getSeeProperties() {
        return seeProperties;
    }

    /**
     * Obtiene la vista de consulta de resoluciones.
     *
     * @return vista de consulta de resoluciones
     */
    public SeeResolutions getSeeResolutions() {
        return seeResolutions;
    }

    /**
     * Obtiene la vista de configuración.
     *
     * @return vista de configuración
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Obtiene el sujeto del patrón Observer.
     *
     * @return sujeto concreto del patrón Observer
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Obtiene el sujeto de cambio de idioma.
     *
     * @return sujeto del patrón Observer para idiomas
     */
    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    /**
     * Obtiene el gestor de idiomas.
     *
     * @return gestor de idiomas de la aplicación
     */
    public LanguageManager getLang() {
        return lang;
    }

    /**
     * Obtiene la vista del panel «Acerca de».
     *
     * @return vista del panel Acerca de
     */
    public About getAbout() {
        return about;
    }

}
