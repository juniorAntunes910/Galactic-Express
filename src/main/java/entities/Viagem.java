package entities;

import java.sql.Timestamp; // Import necessário para lidar com a data/hora do SQL

public class Viagem {
    private int id;
    private int passageiroId;
    private int naveId;
    private String destino;
    private Timestamp dataSaida; // Mapeado para TIMESTAMP do SQL
    private double precoFinal;
    private String status;       // Mapeado para VARCHAR (Ex: "RESERVADA", "CONCLUIDA")

    /**
     * Construtor de INSERÇÃO.
     * Usado quando o usuário está criando uma nova viagem (reserva).
     * Não recebe ID, dataSaida e status, pois são definidos pelo banco de dados (DEFAULT NOW() e 'RESERVADA').
     */
    public Viagem(int passageiroId, int naveId, String destino, double precoFinal) {
        this.passageiroId = passageiroId;
        this.naveId = naveId;
        this.destino = destino;
        this.precoFinal = precoFinal;
        // Os demais atributos serão populados APENAS na leitura do banco.
    }

    /**
     * Construtor de LEITURA.
     * Usado pelo DAO ao ler uma linha do ResultSet para reconstruir o objeto.
     * Recebe todos os atributos, incluindo o ID e a data/status gerados.
     */
    public Viagem(int id, int passageiroId, int naveId, String destino, Timestamp dataSaida, double precoFinal, String status) {
        this(passageiroId, naveId, destino, precoFinal); // Chama o construtor de inserção
        this.id = id;
        this.dataSaida = dataSaida;
        this.status = status;
    }

    // ===================================
    // GETTERS E SETTERS
    // ===================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassageiroId() {
        return passageiroId;
    }

    public void setPassageiroId(int passageiroId) {
        this.passageiroId = passageiroId;
    }

    public int getNaveId() {
        return naveId;
    }

    public void setNaveId(int naveId) {
        this.naveId = naveId;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Getter e Setter para Timestamp
    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    // Getter e Setter para String (Status)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", passageiroId=" + passageiroId +
                ", naveId=" + naveId +
                ", destino='" + destino + '\'' +
                ", dataSaida=" + dataSaida +
                ", precoFinal=" + String.format("R$ %.2f", precoFinal) +
                ", status='" + status + '\'' +
                '}';
    }
}