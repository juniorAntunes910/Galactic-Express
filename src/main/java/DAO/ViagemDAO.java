package DAO;

import Conn.ConnectionFactory;
import entities.Viagem;

import java.sql.*;

public class ViagemDAO {
    private static Connection conn;
    static{
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void realizarReserva(Viagem viagem) throws SQLException {
        String sql = "INSERT INTO viagem (passageiro_id, nave_id, destino, data_saida, preco_final) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, viagem.getPassageiroId());
        stmt.setInt(2, viagem.getNaveId());
        stmt.setString(3, viagem.getDestino());
        stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        stmt.setDouble(5, viagem.getPrecoFinal());
        stmt.execute();
        System.out.println("A viagem foi adicionada ao histórico");
    }
}
