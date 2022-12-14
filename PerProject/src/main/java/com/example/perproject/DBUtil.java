package com.example.perproject;

import java.net.ConnectException;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public Connection connection;

    public static DBUtil instance;

    public static DBUtil getInstance() {
        if (instance == null) {
            instance = new DBUtil();

        }
        return instance;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/yydh";
        String userName = "root";
        String password = "";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}

