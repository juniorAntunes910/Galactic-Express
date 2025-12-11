package DAO;

import Conn.ConnectionFactory;
import entities.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassageiroDAO {
    private static final Connection conn;
    static {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void adicionarPassageiro (Passageiro passageiro) throws SQLException {
            String sql = "INSERT INTO passageiro (nome, rgEspacial, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, passageiro.getNome());
            stmt.setString(2, passageiro.getRgEspacial());
            stmt.setString(3, passageiro.getEmail());
            stmt.execute();

            System.out.println("Passageiro " + passageiro.getNome() + " Adicionado ao banco de dados!");
        }
    }
