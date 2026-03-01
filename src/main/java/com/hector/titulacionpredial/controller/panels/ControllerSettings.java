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
 *
 * @author Ing. Hector Acevedo
 */
public class ControllerSettings implements LanguageObserver {

    private final Settings settings;
    private final LanguageSubject languageSubject;
    private final LanguageManager lang;

    public ControllerSettings(ControllerSettingsBuilder builder) {
        this.settings = builder.getSettings();
        this.lang = builder.getLang();
        this.languageSubject = builder.getLanguageSubject();

        builder.getLanguageSubject().register(this);
        connectEvents();
    }

    public void connectEvents() {
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

    public void showPanel() {

    }

    public void changeLanguage() {
        if (settings.getBtg_languages().getSelection() != null) {
            String languageCode = settings.getBtg_languages().getSelection().getActionCommand();
            changeLanguage(languageCode.toUpperCase());
        }
    }

    public void changeLanguage(String languageCode) {
        lang.setLanguage(AppLanguage.valueOf(languageCode));
        languageSubject.notifyObserver();
    }

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

    public void selectSpanishLanguage() {
        if (settings.getRbn_spanish().isSelected()) {
            lang.setLanguage(AppLanguage.ES);
            languageSubject.notifyObserver();
        }
    }

    public void selectEnglishLanguage() {
        if (settings.getRbn_english().isSelected()) {
            lang.setLanguage(AppLanguage.EN);
            languageSubject.notifyObserver();
        }
    }

}
