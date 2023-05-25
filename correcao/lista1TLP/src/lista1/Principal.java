package lista1;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        EditoraBanco eb = new EditoraBanco();
        LivroBanco lb = new LivroBanco();

        String nome;
        int opcao, codigo, i; 
        
        do{
            System.out.println("Selecione a opcao desejada: \n1 = cadastrar editora \n2 = cadastrar livro \n3 = busca editora especifica \n4 = sair: ");
            opcao = sc.nextInt();
            
            if(opcao == 1){
                Editora editora = new Editora();
                System.out.println("Informe o nome: ");
                editora.setNome(sc.next());
                System.out.println("Informe o código: ");
                codigo = sc.nextInt();                
                editora.setCodigo(codigo);

                eb.adicionar(editora);
            }
            else if(opcao == 2){
                Livro livro = new Livro();
                System.out.println("Informe o nome: ");
                livro.setNome(sc.next());
                System.out.println("Informe o ano: ");
                livro.setAnoPublicacao(sc.nextInt());
                
                 
                System.out.println("Informe o nome da editora: ");
                nome = sc.next();
                Editora ed = eb.buscarPorNome(nome);
                
                livro.setEditora(ed);
                
                lb.adicionar(livro);
            }
            else if(opcao == 3){
                System.out.println("Informe o nome da editora: ");
                nome = sc.next();
                
                Editora editora = eb.buscarPorNome(nome);
                
                ArrayList<Livro> lista = lb.buscar(editora);
                
                for(i = 0; i < lista.size(); i++){
                    System.out.println("Nome do livro: "+
                            lista.get(i).getNome());
                }
            }
            
        }while(opcao != 4);
    }
}

/*
create table editora(
	nome varchar, 
	codigo int, 
	id serial primary key
);
create table livro(
	nome varchar, 
	ano int,
	ideditora int references editora(id),
	id serial primary key
); 

*/
