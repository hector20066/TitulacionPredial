package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSeeResolutions;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.observer.Subject;
import com.hector.titulacionpredial.view.content.panels.*;

/**
 * Builder para la construcción de instancias de {@link ControllerSeeResolutions}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSeeResolutionsBuilder {

    private ModifyResolution modifyResolution;
    private SeeResolutions seeResolutions;
    private Subject subject;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de modificación de resoluciones.
     *
     * @param modifyResolution vista de modificación de resoluciones
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeeResolutionsBuilder withViewModifyResolution(ModifyResolution modifyResolution) {
        this.modifyResolution = modifyResolution;
        return this;
    }

    /**
     * Asigna la vista del panel de consulta de resoluciones.
     *
     * @param seeResolutions vista de consulta de resoluciones
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeeResolutionsBuilder withViewSeeResolutions(SeeResolutions seeResolutions) {
        this.seeResolutions = seeResolutions;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para notificaciones de datos.
     *
     * @param subject sujeto concreto del patrón Observer
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeeResolutionsBuilder withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeeResolutionsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSeeResolutionsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerSeeResolutions}.
     *
     * @return nueva instancia configurada de {@link ControllerSeeResolutions}
     */
    public ControllerSeeResolutions build() {
        return new ControllerSeeResolutions(this);
    }

    /**
     * Obtiene la vista de modificación de resoluciones.
     *
     * @return vista de modificación de resoluciones
     */
    public ModifyResolution getModifyResolution() {
        return modifyResolution;
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
