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
 * Persistent user configuration manager.
 *
 * <p>
 * This class provides a simple mechanism for storing and retrieving
 * custom configurations using an <code>application.properties</code>
 * file located in the user's directory.
 * </p>
 *
 * <h2>File location</h2>
 *
 * <pre>
 * ${user.home}/.titulacionpredial/application.properties
 * </pre>
 *
 * <h2>Characteristics</h2>
 *
 * <ul>
 *     <li>Automatically creates the configuration directory if it does not exist.</li>
 *     <li>Create the properties file with default values.</li>
 *     <li>It allows reading and writing of properties.</li>
 * </ul>
 *
 * <h3>Initialization</h3>
 *
 * <p>
 * The configuration is automatically initialized in the static block when
 * the class is loaded.
 * </p>
 *
 * <h4>Persistence</h4>
 *
 * <p>
 * Each time {@link #set(String, String)} is invoked, the file is overwritten
 * with the new values.
 * </p>
 *
 * <h4>Considerations</h4>
 *
 * <ul>
 *     <li>It is not thread-safe.</li>
 *     <li>The writing is complete (not incremental).</li>
 *     <li>Throws RuntimeException in case of critical error.</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class UserConfig {

    /**
     * Properties object that keeps the configurations in memory.
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
     * Initializes the configuration structure.
     *
     * <p>
     * If the file does not exist:
     * </p>
     *
     * <ul>
     *     <li>Create the directory.</li>
     *     <li>Create the file with default values.</li>
     * </ul>
     *
     * <p>
     * If the file exists, load its properties into memory.
     * </p>
     *
     * @throws IOException if a read or write error occurs
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
     * It retrieves the value associated with a key.
     *
     * @param key configuration key
     * @return associated value or null if it does not exist
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Sets or updates the value of a key.
     *
     * <p>
     * It immediately persists the changes in the physical file.
     * </p>
     *
     * @param key   configuration key
     * @param value value to store
     * @throws RuntimeException if an error occurs while saving
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
