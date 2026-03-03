package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.i18n.LanguageManager;

import java.io.InputStream;
import java.util.Properties;

/**
 * Clase utilitaria para la carga y acceso a las propiedades
 * de configuración de la aplicación.
 *
 * <p>
 * Lee el archivo {@code config/application.properties} desde
 * el classpath al inicializar la clase. Proporciona acceso
 * estático a las propiedades de configuración como la URL
 * de la base de datos, credenciales y driver JDBC.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class AppConfig {

    /**
     * Propiedades de configuración cargadas desde el archivo.
     */
    private static final Properties properties = new Properties();

    private static final LanguageManager lang = LanguageManager.getInstance();

    static {
        try (InputStream file = AppConfig.class.getClassLoader().getResourceAsStream("config/application.properties")) {
            if (file == null) {
                throw new RuntimeException(lang.message("app.config.not.found.file"));
            }

            properties.load(file);
        } catch (Exception e) {
            throw new RuntimeException(lang.message("app.config.no.charge.app"));
        }
    }

    /**
     * Obtiene el valor de una propiedad de configuración.
     *
     * @param key clave de la propiedad
     * @return valor asociado a la clave, o {@code null} si no existe
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

}
