package DAO;

import Conn.ConnectionFactory;
import entities.Nave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String sql = "INSERT INTO nave (nome, capacidade, preco_base, esta_disponivel ) VALUES (?, ?, ?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nave.getNome());
        stmt.setInt(2, nave.getCapacidade());
        stmt.setDouble(3, nave.getPrecoBase());
        stmt.setBoolean(4, true);
        stmt.executeUpdate();
        System.out.println("A nave " + nave.getNome() + " Foi adicionada ao banco de dados");



    }
    public ArrayList<Nave> verNavesDisponiveis() throws SQLException {
        String sql = "SELECT * FROM nave WHERE esta_disponivel = TRUE";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Nave> listaNaves = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int capacidade = rs.getInt("capacidade");
            double preco_base = rs.getDouble("preco_base");
            Nave nave = new Nave(id, nome, capacidade, preco_base, true);
            listaNaves.add(nave);
        }
        return listaNaves;
    }

    public void mudarStatusDisponivelFalso(int id) throws SQLException {
        String sql = "UPDATE nave SET esta_disponivel = Indisponivel WHERE id = " + id;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }

}
