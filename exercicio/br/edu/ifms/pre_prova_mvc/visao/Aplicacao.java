package exercicio.br.edu.ifms.pre_prova_mvc.visao;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        
        int opcao;
        PessoaVisao pessoaVisao = new PessoaVisao();
        EnderecoVisao enderecoVisao = new EnderecoVisao();

        do {
            switch (opcao = menu()) {
                case -1: {
                    System.out.println("Erro de leitura de entrada de menu");
                    break;
                }
                case 0: {
                    break;
                }
                case 1: {
                    pessoaVisao.verNomeRgTodos();
                    break;
                }
                case 2: {
                    enderecoVisao.verRuaN_PorBairro();
                    break;
                }
                case 3: {
                    pessoaVisao.verTudoPorNome();
                    break;
                }
                default: {
                    System.out.println("Não há opção associada ao número informado");
                }
            }
        } while (opcao != 0);
    }

    public static int menu() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println( " - - - - - - - - Sistema de controle postal - - - - - - - -\n"+
                                "1 -) Apresentação de nome e rg de todas as pessoas cadastradas\n"+
                                "2 -) Apresentação do número e logradouro de todos os endereços de um determinado bairro\n"+
                                "3 -) Apresentação de todos os dados relacionados a uma pessoa de determinado nome\n"+
                                "0 -) Sair");
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
