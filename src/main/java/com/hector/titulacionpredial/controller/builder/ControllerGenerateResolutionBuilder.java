package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerGenerateResolution;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder para la construcción de instancias de {@link ControllerGenerateResolution}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerGenerateResolutionBuilder {

    private GenerateResolution generateResolution;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de generación de resoluciones.
     *
     * @param generateResolution vista de generación de resoluciones
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerGenerateResolutionBuilder withViewGenerateResolution(GenerateResolution generateResolution) {
        this.generateResolution = generateResolution;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerGenerateResolutionBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerGenerateResolutionBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerGenerateResolutionBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerGenerateResolution}.
     *
     * @return nueva instancia configurada de {@link ControllerGenerateResolution}
     */
    public ControllerGenerateResolution build() {
        return new ControllerGenerateResolution(this);
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
