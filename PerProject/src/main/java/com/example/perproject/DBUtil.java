package com.example.perproject;

import java.net.ConnectException;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public Connection connection;

    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/login";
        String userName = "root";
        String password = "";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

}

