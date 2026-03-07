package com.hector.titulacionpredial.i18n;

import com.hector.titulacionpredial.utils.UserConfig;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Gestor centralizado de internacionalización (i18n) de la aplicación.
 *
 * <p>
 * Esta clase implementa el patrón Singleton para garantizar una única
 * instancia encargada de administrar el idioma activo del sistema.
 * Se encarga de:
 * </p>
 *
 * <ul>
 *     <li>Cargar los {@link ResourceBundle} correspondientes al idioma seleccionado.</li>
 *     <li>Persistir la preferencia de idioma del usuario mediante {@link UserConfig}.</li>
 *     <li>Proveer acceso a los textos de interfaz (app) y mensajes del sistema (message).</li>
 * </ul>
 *
 * <p>
 * El idioma inicial se obtiene desde la configuración persistida bajo la clave
 * <code>app.language</code>. Si no existe o es inválido, se utiliza español (ES)
 * como idioma por defecto.
 * </p>
 *
 * <p>
 * Esta clase actúa como punto único de acceso para la obtención de textos
 * internacionalizados, evitando que las vistas o controladores gestionen
 * directamente {@link ResourceBundle}, lo cual favorece el desacoplamiento.
 * </p>
 *
 * <p><b>Uso recomendado:</b></p>
 *
 * <pre>
 * LanguageManager lm = LanguageManager.getInstance();
 * String title = lm.app("window.title");
 * String error = lm.message("error.connection");
 * </pre>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class LanguageManager {

    /**
     * Instancia única del gestor de idioma.
     *
     * <p>
     * Se inicializa de manera perezosa la primera vez que se invoca
     * {@link #getInstance()}.
     * </p>
     */
    private static LanguageManager instance;

    /**
     * Bundle que contiene los textos de la interfaz gráfica.
     */
    private ResourceBundle appBundle;

    /**
     * Bundle que contiene los mensajes del sistema.
     */
    private ResourceBundle messageBundle;

    /**
     * Idioma actualmente activo en la aplicación.
     */
    private AppLanguage currentLanguage;

    /**
     * Constructor privado para evitar instanciación externa.
     *
     * <p>
     * Realiza la carga inicial del idioma desde la configuración
     * persistida y prepara los ResourceBundle correspondientes.
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
     * Obtiene la instancia unica de {@link LanguageManager}
     *
     * <p>
     * Si la instancia no existe, la crea. Este metodo no es Thread-safe
     * por diseño, ya que se ejecuta en el hilo principal de la aplicacion
     * Swing.
     * </p>
     *
     * @return instancia unica del sujeto concreto
     */
    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }

        return instance;
    }

    /**
     * Cambia el idioma activo de la aplicación.
     *
     * <p>
     * Este método:
     * </p>
     *
     * <ul>
     *     <li>Actualiza el idioma actual.</li>
     *     <li>Recarga los ResourceBundle correspondientes.</li>
     *     <li>Persiste la nueva configuración en {@link UserConfig}.</li>
     * </ul>
     *
     * @param language nuevo idioma a establecer
     */
    public void setLanguage(AppLanguage language) {
        this.currentLanguage = language;
        Locale locale = Locale.of(language.getCode());

        this.appBundle = ResourceBundle.getBundle("i18n.app.app", locale);
        this.messageBundle = ResourceBundle.getBundle("i18n.message.message", locale);
        UserConfig.set("app.language", language.getCode());
    }

    /**
     * Obtiene un texto localizado del bundle de interfaz.
     *
     * @param key clave del recurso
     * @return texto localizado asociado a la clave
     * @throws java.util.MissingResourceException si la clave no existe
     */
    public String app(String key) {
        return appBundle.getString(key);
    }

    /**
     * Obtiene un mensaje localizado del bundle de mensajes del sistema.
     *
     * @param key clave del recurso
     * @return mensaje localizado asociado a la clave
     * @throws java.util.MissingResourceException si la clave no existe
     */
    public String message(String key) {
        return messageBundle.getString(key);
    }

    /**
     * Retorna el idioma actualmente activo.
     *
     * @return idioma actual
     */
    public AppLanguage getCurrentLanguage() {
        return currentLanguage;
    }

}
