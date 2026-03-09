package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.i18n.LanguageManager;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for loading and accessing application configuration
 * properties.
 *
 * <p>
 * Reads the {@code config/application.properties} file from the
 * classpath when initializing the class. Provides static access
 * to configuration properties such as the database URL, credentials,
 * and JDBC driver.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class AppConfig {

    /**
     * Configuration properties loaded from the file.
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
     * Gets the value of a configuration property.
     *
     * @param key property key
     * @return value associated with the key, or {@code null} if it does not exist
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

}
