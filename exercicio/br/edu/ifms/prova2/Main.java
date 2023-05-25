package exercicio.br.edu.ifms.prova2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcao = 0;
        
        do {
            switch(opcao=menu(sc)) {
                case 0: {
                    break;
                }
                case 1: {
                    cadastroShopping(sc);
                    break;
                }
                case 2: {
                    cadastroLoja(sc);
                    break;
                }
                case 3: {
                    buscaLojaDeCategoria(sc);
                    break;
                }
            }
        } while (opcao != 0);
    }

    public static int menu(Scanner sc) {

        int opcao = -1337;

        System.out.println( "-------------Sistema de RH de Shopping-------------\n\n"+
                            "1 -) Cadastro de Shopping\n"+
                            "2 -) Cadastro de Loja\n"+
                            "3 -) Busca de lojas de uma categoria");
        try {
            opcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
        return opcao;
    }

    public static void cadastroShopping(Scanner sc) {

        ShoppingBanco shoppingBanco = new ShoppingBanco();
        Shopping shoppingCadastrando = new Shopping();

        System.out.println("Favor informar o nome do shopping, por favor.");

        shoppingCadastrando.setNome(sc.nextLine());

        shoppingCadastrando = shoppingBanco.adicionar(shoppingCadastrando);
    }

    public static void cadastroLoja(Scanner sc) {

        ShoppingBanco shoppingBanco = new ShoppingBanco();
        ArrayList<Shopping> shoppings = shoppingBanco.buscarTudo();
        String nomeShopping = "";

        LojaBanco lojaBanco = new LojaBanco();
        Loja lojaCadastrando = new Loja();

        System.out.println("Favor informar o nome da loja.");
        lojaCadastrando.setNome(sc.nextLine());

        System.out.println("Favor informar a categoria da loja.");
        lojaCadastrando.setCategoria(sc.nextLine());

        for(Shopping shopping : shoppings) {
            System.out.println(shopping.toString());
        }
        System.out.println("Favor informar o nome do shopping no qual está a loja.");
        nomeShopping = sc.nextLine();

        ArrayList<Shopping> shoppingsBuscados = shoppingBanco.buscarPorNome(nomeShopping);

        if(shoppingsBuscados.size()==0) {
            System.out.println("Não existem shoppings com tal nome.");
        } else {
            if(shoppingsBuscados.size()>1) {
                System.out.println("Mais de um shopping com o nome informado. Primeiro selecionado.");
            }
            lojaCadastrando.setShopping(shoppingsBuscados.get(0));

            lojaBanco.adicionar(lojaCadastrando);
        }
    }

    public static void buscaLojaDeCategoria(Scanner sc) {
        LojaBanco lojaBanco = new LojaBanco();
        ArrayList<String> categorias = lojaBanco.buscarCategorias();

        for (String categoria : categorias) {
            System.out.println(categoria);
        }
        System.out.println("Favor informar a categoria desejada.");

        String categoriaEscolhida = sc.nextLine();

        ArrayList<Loja> lojasCategoria = lojaBanco.buscarPorCategoria(categoriaEscolhida);

        for (Loja loja : lojasCategoria) {
            System.out.println(loja.toString());
        }
    }
}
