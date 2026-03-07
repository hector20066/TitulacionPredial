package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSettings;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.view.content.panels.Settings;

/**
 * Builder for building instances of {@link ControllerSettings}.
 *
 * <p>
 * Centralize the injection of dependencies necessary for controller
 * configuration using a Builder design pattern.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSettingsBuilder {

    private Settings settings;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    /**
     * Assign the configuration panel view.
     *
     * @param settings configuration view
     * @return instance of the builder for fluid chaining
     */
    public ControllerSettingsBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Assign the subject of the Observer pattern for the language system.
     *
     * @param languageSubject subject to language change
     * @return instance of the builder for fluid chaining
     */
    public ControllerSettingsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    /**
     * Assign the application's language manager.
     *
     * @param lang language manager
     * @return instance of the builder for fluid chaining
     */
    public ControllerSettingsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Build and initialize a new instance of {@link ControllerSettings}.
     *
     * @return new configured instance of {@link ControllerSettings}
     */
    public ControllerSettings build() {
        return new ControllerSettings(this);
    }

    public Settings getSettings() {
        return settings;
    }

    public LanguageSubject getLanguageSubject() {
        return languageSubject;
    }

    public LanguageManager getLang() {
        return lang;
    }

}
