package DAO;

import Conn.ConnectionFactory;
import entities.Nave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NaveDAO {
    private static final Connection conn;

    static {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarNave(Nave nave) throws SQLException {
        String sql = "INSERT INTO nave (...) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, );

    }
}
