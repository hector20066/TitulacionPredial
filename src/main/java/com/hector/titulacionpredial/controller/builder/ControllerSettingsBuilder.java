package com.hector.titulacionpredial.controller.builder;

import com.hector.titulacionpredial.controller.panels.ControllerSettings;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.view.content.panels.Settings;

/**
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerSettingsBuilder {

    private Settings settings;
    private LanguageSubject languageSubject;
    private LanguageManager lang;

    public ControllerSettingsBuilder withViewSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    public ControllerSettingsBuilder withLanguageSubject(LanguageSubject languageSubject) {
        this.languageSubject = languageSubject;
        return this;
    }

    public ControllerSettingsBuilder withLanguageManager(LanguageManager lang) {
        this.lang = lang;
        return this;
    }

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
