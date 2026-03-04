package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerDashboard;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.Dashboard;

/**
 * Builder para la construcción de instancias de {@link ControllerDashboard}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerDashboardBuilder {

    private Dashboard dashboard;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de inicio (dashboard).
     *
     * @param dashboard vista del dashboard
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerDashboardBuilder withViewDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerDashboardBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerDashboardBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerDashboardBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerDashboard}.
     *
     * @return nueva instancia configurada de {@link ControllerDashboard}
     */
    public ControllerDashboard build() {
        return new ControllerDashboard(this);
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

}
