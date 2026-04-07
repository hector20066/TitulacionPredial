package com.hector.titulacionpredial.i18n;

import com.hector.titulacionpredial.utils.UserConfig;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Centralized internationalization manager (i18n) of the application.
 *
 * <p>
 * This class implements the Singleton pattern to ensure a single instance
 * is responsible for managing the system's active language. It handles:
 * </p>
 *
 * <ul>
 *     <li>Load the {@link ResourceBundle} corresponding to the selected language.</li>
 *     <li>Persist the user's language preference using {@link UserConfig}.</li>
 *     <li>Provide access to interface texts (app) and system messages (message).</li>
 * </ul>
 *
 * <p>
 * The initial language is obtained from the configuration persisted under the key
 * <code>app.language</code>. If it does not exist or is invalid, Spanish (ES) is used
 * as the default language.
 * </p>
 *
 * <p>
 * This class acts as a single point of access for obtaining internationalized texts,
 * preventing views or controllers from directly managing {@link ResourceBundle}, which
 * promotes decoupling.
 * </p>
 *
 * <p><b>Recommended use:</b></p>
 *
 * <pre>
 * LanguageManager lang = LanguageManager.getInstance();
 * String title = lang.app("window.title");
 * String error = lang.message("error.connection");
 * </pre>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class LanguageManager {

    private static LanguageManager instance;
    private ResourceBundle appBundle;
    private ResourceBundle messageBundle;
    private AppLanguage currentLanguage;

    /**
     * Private builder to avoid external instantiation.
     *
     * <p>
     * Perform the initial language load from the persisted configuration and
     * prepare the corresponding ResourceBundles.
     * </p>
     */
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

    /**
     * Gets the unique instance of {@link LanguageManager}
     *
     * <p>
     * If the instance does not exist, it creates it. This method is not
     * thread-safe by design, as it runs on the main thread of the Swing
     * application.
     * </p>
     *
     * @return single instance of the specific subject
     */
    public static synchronized LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }

        return instance;
    }

    /**
     * Change the active language of the application.
     *
     * <p>
     * This method:
     * </p>
     *
     * <ul>
     *     <li>Update the current language.</li>
     *     <li>Reload the corresponding ResourceBundle.</li>
     *     <li>The new configuration persists in {@link UserConfig}.</li>
     * </ul>
     *
     * @param language new language to set
     */
    public void setLanguage(AppLanguage language) {
        this.currentLanguage = language;
        Locale locale = Locale.of(language.getCode());

        this.appBundle = ResourceBundle.getBundle("i18n.app.app", locale);
        this.messageBundle = ResourceBundle.getBundle("i18n.message.message", locale);
        UserConfig.set("app.language", language.getCode());
    }

    /**
     * Gets localized text from the interface bundle.
     *
     * @param key resource key
     * @return text located associated with the key
     * @throws java.util.MissingResourceException if the key does not exist
     */
    public String app(String key) {
        return appBundle.getString(key);
    }

    /**
     * Retrieves a localized message from the system message bundle.
     *
     * @param key resource key
     * @return message located associated with the key
     * @throws java.util.MissingResourceException if the key does not exist
     */
    public String message(String key) {
        return messageBundle.getString(key);
    }

    /**
     * Returns to the currently active language.
     *
     * @return current language
     */
    public AppLanguage getCurrentLanguage() {
        return currentLanguage;
    }

}
