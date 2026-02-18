package com.hector.titulacionpredial.database;

import com.hector.titulacionpredial.utils.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hectoracevedo
 */
public class DataBasePool {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(AppConfig.get("db.dev.url"));
        config.setUsername(AppConfig.get("db.dev.username"));
        config.setPassword(AppConfig.get("db.dev.password"));
        config.setDriverClassName(AppConfig.get("db.driver"));

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(1);
        config.setIdleTimeout(6000000);
        config.setMaxLifetime(18000000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

}
