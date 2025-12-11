package Main;

import Conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
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
    public static void mostrarMenu(){
        while (true){
            System.out.println("1. Adicionar Nave à Frota\n2. Ver Frota Disponível\n3. Cadastrar Passageiro" +
                    "\n4. Ver Passageiros Cadastrados\n5. Realizar Reserva\n6. Ver Histórico de Viagens\n7. Sair"
            );
            int opcao = SC.nextInt();
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
    public static void adicionarNave(){

    }
    public static void verFrota(){

    }
    public static void cadastrarPassageiro(){

    }
    public static void verPassageiro(){

    }
    public static void realizarReserva(){

    }
    public static void verHistorico(){

    }

}
