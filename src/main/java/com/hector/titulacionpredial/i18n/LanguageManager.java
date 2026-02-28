package com.hector.titulacionpredial.i18n;

import com.hector.titulacionpredial.utils.UserConfig;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author hectoracevedo
 */
public class LanguageManager {

    private static LanguageManager instance;

    private ResourceBundle appBundle;
    private ResourceBundle messageBundle;
    private AppLanguage currentLanguage;

    private LanguageManager() {
        String savedLanguage = UserConfig.get("app.language");
        AppLanguage language = AppLanguage.ES;

        if (savedLanguage != null) {
            try {
                language = AppLanguage.valueOf(savedLanguage.toUpperCase());
            } catch (IllegalArgumentException ignored) {
            }
        }

        this.currentLanguage = language;
        Locale locale = Locale.of(language.getCode());
        this.appBundle = ResourceBundle.getBundle("i18n.app.app", locale);
        this.messageBundle = ResourceBundle.getBundle("i18n.message.message", locale);
    }

    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }

        return instance;
    }

    public void setLanguage(AppLanguage language) {
        this.currentLanguage = language;
        Locale locale = Locale.of(language.getCode());

        this.appBundle = ResourceBundle.getBundle("i18n.app.app", locale);
        this.messageBundle = ResourceBundle.getBundle("i18n.message.message", locale);
        UserConfig.set("app.language", language.getCode());
    }

    public String app(String key) {
        return appBundle.getString(key);
    }

    public String message(String key) {
        return messageBundle.getString(key);
    }

    public AppLanguage getCurrentLanguage() {
        return currentLanguage;
    }

}
