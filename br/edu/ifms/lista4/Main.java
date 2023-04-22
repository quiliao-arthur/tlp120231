package br.edu.ifms.lista4;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifms.lista4.banco.*;
import br.edu.ifms.lista4.modelo.*;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;

        do{
            switch(opcao=menu()){
                case 0:{

                    break;
                }
                case 1:{
                    cadastroEditora();
                    break;
                }
                case 2:{
                    cadastroLivro();
                    break;
                }
                case 3:{
                    catalogoEditora();
                    break;
                }
                default :{
                    System.out.println("Insira um número de 0 a 3");
                    break;
                }
            }
        }while(opcao!=0);
    }
    
    private static int menu(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Sistema Bibliotecário!\n"+
                               "Favor inserir a opção desejada:\n"+
                               "1-Cadastro de Editora\n"+
                               "2-Cadastro de Livro\n"+
                               "3-Busca de Catálogo de Editora\n"+
                               "0-Sair");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void cadastroEditora(){

        try (Scanner sc = new Scanner(System.in)) {
            EditoraBanco editoraBanco = new EditoraBanco();

            Editora editoraGravando = new Editora();

            System.out.println("Favor informar o código da editora:");
            editoraGravando.setCodigo(Integer.parseInt(sc.nextLine()));
            System.out.println("Favor informar o nome da editora:");
            editoraGravando.setNome(sc.nextLine());
            editoraBanco.adicionar(editoraGravando);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void cadastroLivro(){
        try (Scanner sc = new Scanner(System.in)) {
            LivroBanco livroBanco = new LivroBanco();
            Livro livroGravando = new Livro();
            EditoraBanco editoraBanco = new EditoraBanco();
            Editora editoraLivro = new Editora();

            System.out.println("Favor informar o nome do livro");
            livroGravando.setNome(sc.nextLine());
            System.out.println("Inserir o ano de publicação");
            livroGravando.setAnoPublicacao(Integer.parseInt(sc.nextLine()));
            System.out.println("Favor inserir o código da editora");
            editoraLivro=editoraBanco.buscarPorId(Integer.parseInt(sc.nextLine()));
            livroGravando.setEditora(editoraLivro);
            
            livroBanco.adicionar(livroGravando);
        }
    }

    private static void catalogoEditora(){
        try (Scanner sc = new Scanner(System.in)){
            LivroBanco livroBanco = new LivroBanco();
            ArrayList<Livro> listaLivrosEditora = new ArrayList<Livro>();
            EditoraBanco editoraBanco = new EditoraBanco();
            Editora editora = new Editora();

            System.out.println("Insira o nome da Editora");
            editora = editoraBanco.buscarPorNome(sc.nextLine());
            listaLivrosEditora = livroBanco.buscarPorEditora(editora);
            for(Livro livro : listaLivrosEditora){
                System.out.println(livro);
            }
        }
    }
}
