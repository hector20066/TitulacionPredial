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
 * Controlador del panel de configuración de la aplicación.
 *
 * <p>Gestiona la lógica de cambio de idioma y preferencias del usuario,
 * conectando las acciones de la vista {@link Settings} con el sistema
 * de internacionalización.</p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class ControllerSettings implements LanguageObserver {

    private final Settings settings;
    private final LanguageSubject languageSubject;
    private final LanguageManager lang;

    /**
     * Crea el controlador de configuración, inicializa las dependencias
     * y se registra como observador de idioma.
     *
     * @param builder constructor con las vistas y dependencias configuradas
     */
    public ControllerSettings(ControllerSettingsBuilder builder) {
        this.settings = builder.getSettings();
        this.lang = builder.getLang();
        this.languageSubject = builder.getLanguageSubject();

        builder.getLanguageSubject().register(this);
        connectEvents();
    }

    /**
     * Conecta los eventos de los radio buttons de idioma
     * con el método {@link #changeLanguage()}.
     */
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

    /**
     * Muestra el panel de configuración en la vista principal.
     */
    public void showPanel() {

    }

    /**
     * Cambia el idioma de la aplicación según el radio button
     * seleccionado en el grupo de idiomas.
     */
    public void changeLanguage() {
        if (settings.getBtg_languages().getSelection() != null) {
            String languageCode = settings.getBtg_languages().getSelection().getActionCommand();
            changeLanguage(languageCode.toUpperCase());
        }
    }

    /**
     * Cambia el idioma de la aplicación al código indicado
     * y notifica a todos los observadores registrados.
     *
     * @param languageCode código del idioma en mayúsculas (por ejemplo {@code "ES"} o {@code "EN"})
     */
    public void changeLanguage(String languageCode) {
        lang.setLanguage(AppLanguage.valueOf(languageCode));
        languageSubject.notifyObserver();
    }

    /**
     * Selecciona visualmente el radio button que corresponde
     * al código de idioma proporcionado.
     *
     * @param languageCode código del idioma a seleccionar
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
     * Establece el idioma español si el radio button correspondiente
     * está seleccionado y notifica a los observadores.
     */
    public void selectSpanishLanguage() {
        if (settings.getRbn_spanish().isSelected()) {
            lang.setLanguage(AppLanguage.ES);
            languageSubject.notifyObserver();
        }
    }

    /**
     * Establece el idioma inglés si el radio button correspondiente
     * está seleccionado y notifica a los observadores.
     */
    public void selectEnglishLanguage() {
        if (settings.getRbn_english().isSelected()) {
            lang.setLanguage(AppLanguage.EN);
            languageSubject.notifyObserver();
        }
    }

}
