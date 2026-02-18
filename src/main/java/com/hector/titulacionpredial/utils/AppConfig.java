package com.hector.titulacionpredial.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author hectoracevedo
 */
public class AppConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream file = AppConfig.class.getClassLoader().getResourceAsStream("config/application.properties")) {
            if (file == null) {
                throw new RuntimeException("No se encontró el archivo de configuración");
            }

            properties.load(file);
        } catch (Exception e) {
            throw new RuntimeException("No se puede cargar la aplicación");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
