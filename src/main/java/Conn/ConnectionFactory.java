package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String DB_URL = "";
    private static final String DB_USER = "";
    private static final String DB_PASS = "";


    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}