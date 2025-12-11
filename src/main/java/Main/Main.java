package Main;

import Conn.ConnectionFactory;
import DAO.NaveDAO;
import DAO.PassageiroDAO;
import DAO.ViagemDAO;
import entities.Nave;
import entities.Passageiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final NaveDAO NAVE_DAO = new NaveDAO();
    private static final PassageiroDAO PASSAGEIRO_DAO = new PassageiroDAO();
    private static final ViagemDAO VIAGEM_DAO = new ViagemDAO();
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try{
            System.out.println("Fazendo a conexão com o Supabase");
            conn = ConnectionFactory.getConnection(); //Tentando fazer a conexão por meio do Driver Manager e GetConnection
            System.out.println("Conexão Bem sucedida!");
        } catch (SQLException sE){ //Caso de Erro
            System.out.println("Conexão Falhou");
            System.out.println("Codigo Erro: " + sE.getErrorCode());
            System.out.println("Mensagem: " + sE.getMessage());
            sE.printStackTrace(); //Demonstra o erro para mim
        } finally {
            // Fechar o recurso para nao dar merda
            if(conn != null){
                try{
                    conn.close();
                    System.out.println("Conexçao Fechada!");
                } catch (SQLException sE){
                    System.out.println("Erro ao fechar a conexão!");
                    System.out.println("Erro: " + sE.getMessage());
                }
            }
        }
        mostrarMenu();
    }
    public static void mostrarMenu() throws SQLException {
        while (true){
            System.out.println("1. Adicionar Nave à Frota\n2. Ver Frota Disponível\n3. Cadastrar Passageiro" +
                    "\n4. Ver Passageiros Cadastrados\n5. Realizar Reserva\n6. Ver Histórico de Viagens\n7. Sair"
            );
            int opcao = SC.nextInt();
            SC.nextLine();
            switch (opcao){
                case 1:
                    adicionarNave();
                    break;
                case 2:
                    verFrota();
                    break;
                case 3:
                    cadastrarPassageiro();
                    break;
                case 4:
                    verPassageiro();
                    break;
                case 5:
                    realizarReserva();
                    break;
                case 6:
                    verHistorico();
                    break;
                case 7:
                    System.exit(0);
            }

        }
    }
    public static void adicionarNave() throws SQLException {
        System.out.println("-----Adicionar-Naves-----");
        System.out.println("Nome: ");
        String nomeNave = SC.nextLine();
        System.out.println("Capacidade: ");
        int capacidadeNave = SC.nextInt();
        System.out.println("Preço Base: ");
        double precoBaseNave = SC.nextDouble();
        Nave nave = new Nave(nomeNave, capacidadeNave, precoBaseNave, true);
        NAVE_DAO.adicionarNave(nave);

    }
    public static void verFrota() throws SQLException {
        System.out.println("-----Ver-Todas-Naves-Disponíveis-----");
        ArrayList<Nave> listaNaves = NAVE_DAO.verNavesDisponiveis();
        for(Nave nave: listaNaves){
            System.out.println(nave);
        }
    }
    public static void cadastrarPassageiro() throws SQLException {
        System.out.println("-----Cadastrar-Passageiros-----");
        System.out.println("Nome: ");
        String nome = SC.nextLine();
        System.out.println("RG Espacial: ");
        String rgEspacial = SC.next();
        System.out.println("Email: ");
        String email = SC.next();
        Passageiro passageiro = new Passageiro(nome, rgEspacial, email);
        PASSAGEIRO_DAO.adicionarPassageiro(passageiro);
    }
    public static void verPassageiro(){

    }
    public static void realizarReserva(){

    }
    public static void verHistorico(){

    }

}
