package com.yourdaddynka.springStudentsDB.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBConnect {
    private static final String propertyFilePatch = "src/main/resources/application.properties";
    private static DBConnect instance;

    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    private DBConnect() {
        setProperties();
    }


    private static void setProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(propertyFilePatch));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public DataSource createDatasource() {
        setProperties();
        try {
            HikariConfig hikariConfig = new HikariConfig("/application.properties");
            return new HikariDataSource(hikariConfig);
        } catch (HikariPool.PoolInitializationException | IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

