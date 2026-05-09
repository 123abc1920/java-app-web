package com.abc1920.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Consts {
    public static final String URL = "jdbc:postgresql://localhost:5434/";
    public static final String DB = "organizer";
    public static final String USER = "postgres";
    public static final String PASSWORD = "password";

    public static Connection getStartConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB, USER, PASSWORD);
    }
}
