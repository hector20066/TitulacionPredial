package com.hector.titulacionpredial.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.hector.titulacionpredial.utils.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Pool of connections to the MySQL database based
 * on {@link HikariDataSource}.
 *
 * <p>
 * Manage the creation and lifecycle of JDBC connections
 * using HikariCP. The configuration is automatically
 * loaded from {@link AppConfig} when the class is
 * initialized.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see AppConfig
 * @see HikariDataSource
 * @since 1.0
 */
public class DataBasePool {

    /**
     * HikariCP data source statically configured.
     */
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(AppConfig.get("db.url"));
        config.setUsername(AppConfig.get("db.username"));
        config.setPassword(AppConfig.get("db.password"));
        config.setDriverClassName(AppConfig.get("db.driver"));

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setKeepaliveTime(300000);
        config.setValidationTimeout(5000);

        dataSource = new HikariDataSource(config);
    }

    /**
     * Obtains a connection from the connection pool.
     *
     * @return JDBC connection ready to use
     * @throws SQLException if a connection cannot be obtained
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Close the connection pool and release all resources.
     *
     * <p>
     * It must be invoked at the end of the application to
     * ensure that all connections are closed properly.
     * </p>
     */
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

}
