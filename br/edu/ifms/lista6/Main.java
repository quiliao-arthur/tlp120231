package br.edu.ifms.lista6;

import java.util.Scanner;

import br.edu.ifms.lista6.banco.SetorBanco;
import br.edu.ifms.lista6.modelo.Setor;
import br.edu.ifms.lista6.banco.EquipamentoBanco;
import br.edu.ifms.lista6.banco.ServidorBanco;
import br.edu.ifms.lista6.modelo.Equipamento;
import br.edu.ifms.lista6.modelo.Servidor;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1337;
        do{
            switch (opcao=menu(sc)) {
                case -1337: {
                    System.out.println("Erro.");
                    break;
                }
                case 0: {break;}
                case 1: {
                    if (cadastroServidor(sc)) {
                        System.out.println("Cadastro de servidor bem-sucedido!");
                    } else {
                        System.out.println("Cadastro de servidor falhou.");
                    }
                    break;
                }
                case 2: {
                    if (cadastroSetorEEquipamento(sc)) {
                        System.out.println("Cadastro de setor e equipamento bem-sucedido!");
                    } else {
                        System.out.println("Cadastro de setor e equipamento mal-sucedido.");
                    }
                    break;
                }
                case 3: {
                    if (cadastroBicicletaCFabricanteEDono(sc)) {
                        System.out.println("Cadastro de bicicleta, fabricante e dono bem-sucedido!");
                    } else {
                        System.out.println("Cadastro de bicicleta, fabricante e dono falhou.");
                    }
                }
            }
        } while (opcao!=0); 
    }

    public static int menu(Scanner sc){
        System.out.println("Sistema de Patrimônio\n"+
                           "1- Cadastro de servidor\n"+
                           "2- Cadastro de equipamento com setor\n"+
                           "3- Cadastro de bicicleta com fabricante e dono\n"+
                           "0- Sair");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1337;
    }

    public static boolean cadastroServidor(Scanner sc) {
        Servidor servidor = new Servidor();
        ServidorBanco servidorBanco = new ServidorBanco();

        System.out.println("Favor inserir o nome do servidor cadastrando:");
        servidor.setNome(sc.nextLine());
        System.out.println("Favor inserir o siape do servidor cadastrando:");
        try { 
            servidor.setSiape( Integer.parseInt(sc.nextLine()) ); 
            servidor=servidorBanco.adicionar(servidor);
            return true;
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cadastroSetorEEquipamento(Scanner sc) {
        Setor setor = new Setor();
        Equipamento equipamento = new Equipamento();
        Servidor servidor = new Servidor();
        try {
            System.out.println("Favor inserir o nome do setor:");
            setor.setNome(sc.nextLine());
            System.out.println("Favor inserir a descrição do setor:");
            setor.setDescricao(sc.nextLine());

            SetorBanco setorBanco = new SetorBanco();
            setor = setorBanco.adicionar(setor);

            equipamento.setSetor(setor);

            System.out.println("Favor inserir o modelo do equipamento:");
            equipamento.setModelo(sc.nextLine());
            System.out.println("Favor inserir a descrição do equipamento:");
            equipamento.setDescricao(sc.nextLine());
            System.out.println("Favor inserir o valor do equipamento:");
            equipamento.setValor(Double.parseDouble(sc.nextLine()));
            
            System.out.println("Favor inserir o id do servidor associado ao equipamento.");
            servidor.setId(Integer.parseInt(sc.nextLine()));
            
            ServidorBanco servidorBanco = new ServidorBanco();
            servidor = servidorBanco.buscarPorId(servidor.getId());

            equipamento.setServidor(servidor);
            EquipamentoBanco equipamentoBanco = new EquipamentoBanco();
            equipamento = equipamentoBanco.adicionar(equipamento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cadastroBicicletaCFabricanteEDono(Scanner sc) {
        Equipamento equipamento = new Equipamento();

        System.out.println("Favor inserir o modelo da bicicleta:");
        equipamento.setModelo(sc.nextLine());
        System.out.println("Favor inserir a descrição do equipamento:");
        equipamento.setDescricao(sc.nextLine());
        System.out.println("Favor inserir o valor do equipamento:");
        try {

        }
    }
}