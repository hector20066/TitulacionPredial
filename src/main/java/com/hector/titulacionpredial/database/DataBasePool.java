package com.hector.titulacionpredial.database;

import com.hector.titulacionpredial.utils.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * Pool de conexiones a la base de datos PostgreSQL
 * basado en {@link HikariDataSource}.
 *
 * <p>
 * Administra la creación y el ciclo de vida de las conexiones
 * JDBC mediante HikariCP. La configuración se carga
 * automáticamente desde {@link AppConfig} al inicializar la clase.
 * </p>
 *
 * <p>
 * Parámetros del pool:
 * </p>
 * <ul>
 *   <li>{@code maximumPoolSize} – 20 conexiones máximas</li>
 *   <li>{@code minimumIdle} – 1 conexión mínima inactiva</li>
 *   <li>{@code idleTimeout} – 100 minutos</li>
 *   <li>{@code maxLifetime} – 300 minutos</li>
 * </ul>
 *
 * @author Ing. Hector Acevedo
 * @see AppConfig
 * @see HikariDataSource
 * @since 1.0
 */
public class DataBasePool {

    /**
     * Fuente de datos HikariCP configurada estáticamente.
     */
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(AppConfig.get("db.url.ssl"));
        config.setUsername(AppConfig.get("db.username"));
        config.setPassword(AppConfig.get("db.password"));
        config.setDriverClassName(AppConfig.get("db.driver"));

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        config.setConnectionTimeout(30000);
        config.setIdleTimeout(300000);
        config.setMaxLifetime(600000);
        config.setKeepaliveTime(300000);

        dataSource = new HikariDataSource(config);
    }

    /**
     * Obtiene una conexión del pool de conexiones.
     *
     * @return conexión JDBC lista para usar
     * @throws SQLException si no se puede obtener una conexión
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Cierra el pool de conexiones y libera todos los recursos.
     *
     * <p>
     * Debe invocarse al finalizar la aplicación para garantizar
     * que todas las conexiones se cierran correctamente.
     * </p>
     */
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

}
