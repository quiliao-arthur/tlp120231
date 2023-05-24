package br.edu.ifms.pre_prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = menu(sc);
        do {
            switch (opcao) {
                case -1 : {
                    System.out.println("Erro de leitura de entrada no menu");
                    break;
                }
                case 0 : {
                    System.out.println("Saindo...");
                    break;
                }
                case 1 : {
                    listaNomeRgTodos();
                    break;
                }
                case 2 : {
                    buscaRuaENumeroPeloBairro(sc);
                    break;
                }
                case 3 : {
                    buscaTudoPeloNome(sc);
                    break;
                }
            }
        } while ( opcao!=0 );
    }

    public static int menu(Scanner sc) {
        System.out.println( "Sistema de gerenciamento residencial\n"+
                            "1- Apresentar o nome e o rg de todas as pessoas cadastradas\n"+
                            "2- Apresentar o nome de rua e o número de todos os endereços de um determinado bairro:\n"+
                            "3- Apresentação de todos os dados relacionados a uma pessoa com base em seu nome:\n"+
                            "0- Fechar o prgrama");
        try { return Integer.parseInt(sc.nextLine()); }
        catch (Exception e) { e.printStackTrace(); }
        return -1;
    }

    public static void listaNomeRgTodos() {
        PessoaBanco pessoaBanco = new PessoaBanco();
        ArrayList<Pessoa> listaPessoas = pessoaBanco.buscarTudo();
        for (int i = 0; i < listaPessoas.size(); i++) {
            System.out.println( "Pessoa:\n"+
                                "-Nome: "+listaPessoas.get(i).getNome()+"\n"+
                                "-R.G.: "+listaPessoas.get(i).getRg());
        }
    }
}
