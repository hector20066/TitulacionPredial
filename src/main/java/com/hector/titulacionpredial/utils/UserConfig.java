package com.hector.titulacionpredial.utils;

import com.hector.titulacionpredial.i18n.LanguageManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Gestor de configuración persistente del usuario.
 *
 * <p>
 * Esta clase proporciona un mecanismo simple para almacenar y recuperar
 * configuraciones personalizadas mediante un archivo
 * <code>application.properties</code> ubicado en el directorio del usuario.
 * </p>
 *
 * <h2>Ubicación del archivo</h2>
 *
 * <pre>
 * ${user.home}/.titulacionpredial/application.properties
 * </pre>
 *
 * <h2>Características</h2>
 *
 * <ul>
 *     <li>Crea automáticamente el directorio de configuración si no existe.</li>
 *     <li>Crea el archivo de propiedades con valores por defecto.</li>
 *     <li>Permite lectura y escritura de propiedades.</li>
 * </ul>
 *
 * <h2>Inicialización</h2>
 *
 * <p>
 * La configuración se inicializa automáticamente en el bloque estático
 * al cargarse la clase.
 * </p>
 *
 * <h2>Persistencia</h2>
 *
 * <p>
 * Cada vez que se invoca {@link #set(String, String)}, el archivo
 * es sobrescrito con los nuevos valores.
 * </p>
 *
 * <h2>Consideraciones</h2>
 *
 * <ul>
 *     <li>No es thread-safe.</li>
 *     <li>La escritura es completa (no incremental).</li>
 *     <li>Lanza RuntimeException en caso de error crítico.</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UserConfig {

    /**
     * Objeto Properties que mantiene las configuraciones en memoria.
     */
    private static final Properties properties = new Properties();

    private static final LanguageManager lang = LanguageManager.getInstance();

    private static final Path CONFIG_DIR = Paths.get(System.getProperty("user.home"), ".titulacionpredial");
    private static final Path CONFIG_FILE = CONFIG_DIR.resolve("application.properties");

    static {
        try {
            init();
        } catch (IOException e) {
            throw new RuntimeException(lang.message("user.config.init.error"));
        }
    }

    /**
     * Inicializa la estructura de configuración.
     *
     * <p>
     * Si el archivo no existe:
     * </p>
     * <ul>
     *     <li>Crea el directorio.</li>
     *     <li>Crea el archivo con valores por defecto.</li>
     * </ul>
     *
     * <p>
     * Si el archivo existe, carga sus propiedades en memoria.
     * </p>
     *
     * @throws IOException si ocurre un error de lectura o escritura
     */
    private static void init() throws IOException {
        if (Files.notExists(CONFIG_DIR)) {
            Files.createDirectories(CONFIG_DIR);
        }

        if (Files.notExists(CONFIG_FILE)) {
            properties.setProperty("app.language", "es");

            try (OutputStream outputStream = Files.newOutputStream(CONFIG_FILE)) {
                properties.store(outputStream, lang.message("user.config"));
            }

            return;
        }

        try (InputStream inputStream = Files.newInputStream(CONFIG_FILE)) {
            properties.load(inputStream);
        }
    }

    /**
     * Obtiene el valor asociado a una clave.
     *
     * @param key clave de configuración
     * @return valor asociado o null si no existe
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Establece o actualiza el valor de una clave.
     *
     * <p>
     * Persiste inmediatamente los cambios en el archivo físico.
     * </p>
     *
     * @param key clave de configuración
     * @param value valor a almacenar
     * @throws RuntimeException si ocurre un error al guardar
     */
    public static void set(String key, String value) {
        properties.setProperty(key, value);

        try (OutputStream outputStream = Files.newOutputStream(CONFIG_FILE)) {
            properties.store(outputStream, lang.message("user.config.update"));
        } catch (IOException e) {
            throw new RuntimeException(lang.message("user.config.save.error"));
        }
    }

}
