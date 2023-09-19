package com.parcial.framework.db;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class ConnectionDb {

    private static ConnectionDb instance;
    private static Connection connection = null;

    private static DatabaseConfig config = new DatabaseConfig();

    public ConnectionDb() {
        try {

            //String url = "jdbc:mysql://localhost:3306/hb-05-many-to-many";
            //String username = "springstudent";
            //String password = "springstudent";
            connection = config.dataSource().getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionDb getInstance() {
        if (instance == null) {
            synchronized (ConnectionDb.class) {
                if (instance == null) {
                    instance = new ConnectionDb();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {

        return connection;
    }
}
