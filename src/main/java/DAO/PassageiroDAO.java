package DAO;

import Conn.ConnectionFactory;
import entities.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String sql = "INSERT INTO passageiro (nome, rg_espacial, email) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, passageiro.getNome());
        stmt.setString(2, passageiro.getRgEspacial());
        stmt.setString(3, passageiro.getEmail());
        stmt.execute();

        System.out.println("Passageiro " + passageiro.getNome() + " Adicionado ao banco de dados!");
    }

    public ArrayList<Passageiro> verPassageiro() throws SQLException{
        String sql = "SELECT *FROM passageiro";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ArrayList<Passageiro> listaPassageiros = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String rgEspacial = rs.getString("rg_espacial");
            String email = rs.getString("email");
            Passageiro passageiro = new Passageiro(id, nome, rgEspacial, email);
            listaPassageiros.add(passageiro);
        }
        return listaPassageiros;
    }
}