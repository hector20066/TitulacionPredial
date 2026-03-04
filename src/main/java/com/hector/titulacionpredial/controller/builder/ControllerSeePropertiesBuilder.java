package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSeeProperties;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.GenerateResolution;
import com.hector.titulacionpredial.view.content.panels.SeeProperties;

/**
 * Builder para la construcción de instancias de {@link ControllerSeeProperties}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSeePropertiesBuilder {

    private GenerateResolution generateResolution;
    private SeeProperties seeProperties;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de generación de resoluciones.
     *
     * @param generateResolution vista de generación de resoluciones
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeePropertiesBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    /**
     * Asigna la vista del panel de consulta de predios.
     *
     * @param seeProperties vista de consulta de predios
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeePropertiesBuilder withViewSeeProperties(SeeProperties seeProperties) {
        this.seeProperties = seeProperties;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeePropertiesBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeePropertiesBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeePropertiesBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerSeeProperties}.
     *
     * @return nueva instancia configurada de {@link ControllerSeeProperties}
     */
    public ControllerSeeProperties build() {
        return new ControllerSeeProperties(this);
    }

    /**
     * Obtiene la vista de generación de resoluciones.
     *
     * @return vista de generación de resoluciones
     */
    public GenerateResolution getGenerateResolution() {
        return generateResolution;
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
