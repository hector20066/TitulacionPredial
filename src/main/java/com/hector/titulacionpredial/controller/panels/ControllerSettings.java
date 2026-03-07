package com.hector.titulacionpredial.controller.panels;

import com.hector.titulacionpredial.controller.builder.ControllerSettingsBuilder;
import com.hector.titulacionpredial.i18n.AppLanguage;
import com.hector.titulacionpredial.i18n.LanguageManager;
import com.hector.titulacionpredial.i18n.LanguageObserver;
import com.hector.titulacionpredial.i18n.LanguageSubject;
import com.hector.titulacionpredial.view.content.panels.Settings;
import com.hector.titulacionpredial.view.i18n.dto.panels.DTOSettingsText;

import javax.swing.*;
import java.util.Enumeration;

/**
 * Application settings panel controller.
 *
 * <p>
 * Manages the logic for changing the user's language and preferences,
 * connecting the actions of the {@link Settings} view with the
 * internationalization system.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSettings implements LanguageObserver {

    private final Settings settings;
    private final LanguageSubject languageSubject;
    private final LanguageManager lang;

    /**
     * Create the configuration controller, initialize dependencies,
     * and register as a language observer.
     *
     * @param builder constructor with configured views and dependencies
     */
    public ControllerSettings(ControllerSettingsBuilder builder) {
        this.settings = builder.getSettings();
        this.lang = builder.getLang();
        this.languageSubject = builder.getLanguageSubject();

        builder.getLanguageSubject().register(this);
        
        connectEvents();
    }

    /**
     * Connect the language radio button events with the
     * {@link #changeLanguage()} method.
     */
    private void connectEvents() {
        Enumeration<AbstractButton> buttons = settings.getBtg_languages().getElements();

        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            button.addActionListener(e -> changeLanguage());
        }
    }

    @Override
    public void updateLanguage() {
        DTOSettingsText dto = new DTOSettingsText(lang.app("settings.language.title"),
                                                    lang.app("settings.language"));

        settings.updateLanguage(dto);
    }

    /**
     * Change the application language according to the radio
     * button selected in the language group.
     */
    public void changeLanguage() {
        if (settings.getBtg_languages().getSelection() != null) {
            String languageCode = settings.getBtg_languages().getSelection().getActionCommand();
            changeLanguage(languageCode.toUpperCase());
        }
    }

    /**
     * Change the application language to the specified code
     * and notify all registered observers.
     *
     * @param languageCode language code in uppercase
     *                     (for example {@code "ES"} or {@code "EN"})
     */
    public void changeLanguage(String languageCode) {
        lang.setLanguage(AppLanguage.valueOf(languageCode));
        languageSubject.notifyObserver();
    }

    /**
     * Visually select the radio button that corresponds
     * to the provided language code.
     *
     * @param languageCode language code to select
     */
    public void selectLanguageRadio(String languageCode) {
        Enumeration<AbstractButton> buttons = settings.getBtg_languages().getElements();

        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();

            if (button.getActionCommand().equalsIgnoreCase(languageCode)) {
                button.setSelected(true);
                break;
            }
        }
    }

    /**
     * Set the language to Spanish if the corresponding
     * radio button is selected and notify observers.
     */
    public void selectSpanishLanguage() {
        if (settings.getRbn_spanish().isSelected()) {
            lang.setLanguage(AppLanguage.ES);
            languageSubject.notifyObserver();
        }
    }

    /**
     * Sets the language to English if the corresponding
     * radio button is selected and notifies observers.
     */
    public void selectEnglishLanguage() {
        if (settings.getRbn_english().isSelected()) {
            lang.setLanguage(AppLanguage.EN);
            languageSubject.notifyObserver();
        }
    }

}
