package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DB_URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
    private static final String DB_USER = "postgres.gnwaahsxndobgdswpiwd";
    private static final String DB_PASS = "jHa7F08JdPZBOX32";


    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}