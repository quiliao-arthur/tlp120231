package br.edu.ifms.lista6;

import java.util.Scanner;

import br.edu.ifms.lista6.banco.ServidorBanco;
import br.edu.ifms.lista6.modelo.Servidor;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1337;

        switch (opcao=menu(sc)) {
            case -1337: {
                System.out.println("Erro.");
                break;
            }
            case 0: {break;}
            case 1: {
                cadastroServidor(sc);
                break;
            }
            case 2: {
                cadastroSetorEEquipamento(sc);
                break;
            }
            case 3: {
                cadastroBicicletaCFabricanteEDono(sc);
            }
        }
    }

    public static int menu(Scanner sc){
        System.out.println("Sistema de Patrimônio\n"+
                           "1- Cadastro de Servidor\n"+
                           "2- Cadastro de Equipamento com Setor\n"+
                           "3- Cadastro de bicicleta com fabricante e dono\n"+
                           "0- Sair");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1337;
    }

    public static void cadastroServidor(Scanner sc) {
        Servidor servidor = new Servidor();
        ServidorBanco servidorBanco = new ServidorBanco();

        System.out.println("Favor inserir o nome do servidor cadastrando:");
        servidor.setNome(sc.nextLine());
        System.out.println("Favor inserir o siape do servidor cadastrando:");
        try { 
            servidor.setSiape( Integer.parseInt(sc.nextLine()) ); 
        } catch (NumberFormatException e) { 
            e.printStackTrace(); 
            return; 
        }
        servidor=servidorBanco.adicionar(servidor);
    }

    public static void cadastroSetorEEquipamento(Scanner sc) {
        
    }

    public static void cadastroBicicletaCFabricanteEDono(Scanner sc) {

    }
}