package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSettings;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.view.content.panels.Settings;

/**
 * Builder para la construcción de instancias de {@link ControllerSettings}.
 *
 * <p>Centraliza la inyección de dependencias necesarias para la configuración
 * del controlador mediante un patrón de diseño Builder.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSettingsBuilder {

    private Settings settings;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Asigna la vista del panel de configuración.
     *
     * @param settings vista de configuración
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSettingsBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Asigna el sujeto del patrón Observer para el sistema de idiomas.
     *
     * @param languageSubject sujeto de cambio de idioma
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSettingsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Asigna el gestor de idiomas de la aplicación.
     *
     * @param lang gestor de idiomas
     * @return esta instancia del builder para encadenamiento fluido
     */
    public ControllerSettingsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Construye e inicializa una nueva instancia de {@link ControllerSettings}.
     *
     * @return nueva instancia configurada de {@link ControllerSettings}
     */
    public ControllerSettings build() {
        return new ControllerSettings(this);
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
