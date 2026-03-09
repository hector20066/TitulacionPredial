package com.hector.titulacionpredial.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Centralized repository for loading and caching SQL files
 * from application resources.
 *
 * <p>
 * It uses a {@link ConcurrentHashMap} as an in-memory cache
 * to avoid repeated reads of the classpath. The first
 * invocation loads the file, and subsequent invocations return
 * the stored content.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SQLRepository {

    /**
     * Concurrent cache of SQL queries indexed by path.
     */
    private static final Map<String, String> CACHE = new ConcurrentHashMap<>();

    /**
     * Private constructor to avoid instantiation (utility class).
     */
    private SQLRepository() {

    }

    /**
     * It retrieves the SQL content associated with the
     * specified path. If it is not cached, it loads it
     * from the resources.
     *
     * @param path relative path of the SQL file in the classpath
     * @return SQL file content
     * @throws RuntimeException if the file is not found or there is a read error
     */
    public static String get(String path) {
        return CACHE.computeIfAbsent(path, SQLRepository::loadFile);
    }

    /**
     * Load the contents of an SQL file from the classpath.
     *
     * @param path relative path of the SQL file
     * @return file content as a UTF-8 string
     * @throws RuntimeException if the file does not exist or cannot be read
     */
    private static String loadFile(String path) {
        try (InputStream is = SQLRepository.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new RuntimeException("SQL file not found: " + path);
            }

            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error reading SQL file: " + path, e);
        }
    }

}
