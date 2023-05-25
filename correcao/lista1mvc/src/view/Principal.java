package correcao.lista1mvc.src.view;

import correcao.lista1mvc.model.dao.EditoraDAO;
import model.dao.LivroDAO;
import model.entity.Livro;
import model.entity.Editora;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in); 
        EditoraView ev = new EditoraView();
        LivroView lv = new LivroView();
        int opcao;
        
        do{
            System.out.println("Selecione a opcao desejada: \n1 = cadastrar editora \n2 = cadastrar livro \n3 = busca editora especifica \n4 = sair: ");
            opcao = sc.nextInt();
            
            if(opcao == 1){                
                ev.adicionar();                
            }
            else if(opcao == 2){               
                lv.adicionar();
            }
            else if(opcao == 3){
                lv.buscarLivros();
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
