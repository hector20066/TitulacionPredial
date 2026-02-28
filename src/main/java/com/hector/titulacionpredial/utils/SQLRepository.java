package com.hector.titulacionpredial.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repositorio centralizado para la carga y caché de archivos SQL
 * desde los recursos de la aplicación.
 *
 * <p>
 * Utiliza un {@link ConcurrentHashMap} como caché en memoria
 * para evitar lecturas repetidas del classpath. La primera
 * invocación carga el archivo y las subsiguientes retornan
 * el contenido almacenado.
 * </p>
 *
 * @author Hector Acevedo
 * @since 1.0
 */
public class SQLRepository {

    /**
     * Caché concurrente de consultas SQL indexadas por ruta.
     */
    private static final Map<String, String> CACHE = new ConcurrentHashMap<>();

    /**
     * Constructor privado para evitar instanciación (clase utilitaria).
     */
    private SQLRepository() {

    }

    /**
     * Obtiene el contenido SQL asociado a la ruta indicada.
     * Si no existe en caché, lo carga desde los recursos.
     *
     * @param path ruta relativa del archivo SQL en el classpath
     * @return contenido del archivo SQL
     * @throws RuntimeException si el archivo no se encuentra o hay error de lectura
     */
    public static String get(String path) {
        return CACHE.computeIfAbsent(path, SQLRepository::loadFile);
    }

    /**
     * Carga el contenido de un archivo SQL desde el classpath.
     *
     * @param path ruta relativa del archivo SQL
     * @return contenido del archivo como cadena UTF-8
     * @throws RuntimeException si el archivo no existe o no puede leerse
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
