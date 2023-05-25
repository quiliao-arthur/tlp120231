    package lista2;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        EstudanteBanco eb = new EstudanteBanco();
        CursoBanco cb = new CursoBanco();
        String nome;
        int opcao, i; 
        
        do{
            System.out.println("Selecione a opção desejada: \n1 = realizar cadastro de curso \n2 = realizar cadastro de estudante \n5 = buscar curso e todos os estudantes matriculados nele \n6 = buscar estudante e o curso dele = sair: ");
            opcao = sc.nextInt();
            
            if(opcao == 1){
                Curso curso = new Curso();
                
                System.out.println("Informe o nome do curso: ");
                curso.setNome(sc.next());
                System.out.println("Informe o código: ");
                curso.setCodigo(sc.nextInt());
                System.out.println("Informe a duração: ");
                curso.setDuracao(sc.nextInt());
                
                cb.adicionar(curso);
                
            }
            
            if(opcao == 2){
                //apresentando o nome de todos os cursos cadastrados com 2 opções de formato de impressão
                ArrayList<Curso> lista = cb.buscarTodos();
                
                //opcao 1:
                for(i = 0; i < lista.size(); i++){
                    System.out.println("Nome: "+
                            lista.get(i).getNome()+
                            " Código: "+
                            lista.get(i).getCodigo()+
                            " Duração: "+
                            lista.get(i).getDuracao());
                }
                
                //opção 2: 
                for(Curso curso : lista){
                    System.out.println("Nome: "+
                            curso.getNome()+
                            " Código: "+
                            curso.getCodigo()+
                            " Duração: "+
                            curso.getDuracao());
                }
                
                //pedindo o nome do curso
                System.out.println("Informe o nome do curso que deseja se matricular: ");
                nome = sc.next(); 
                
                //buscar id do curso
                Curso curso = cb.buscarPorNome(nome);
                
                //solicitando dados para cadastro de uma pessoa
                Estudante estudante = new Estudante();
                System.out.println("Informe o nome da pessoa: ");
                estudante.setNome(sc.next());
                System.out.println("Informe o CPF:");
                estudante.setCpf(sc.nextInt());
                
                //vincular estudante ao curso
                estudante.setCurso(curso);
                
                //adicionando estudante no banco
                eb.adicionar(estudante);
            }
            
        
            
            if(opcao == 5){
                for(Curso curso : cb.buscarEstudantesDoCurso()){
                    System.out.println("Nome do curso"+curso.getNome());
                    System.out.println("Duração"+curso.getDuracao());
                    System.out.println("Código"+curso.getCodigo());
                    for(Estudante estudante : curso.getLista()){
                        System.out.println("Nome do estudante: "+ estudante.getNome());
                        System.out.println("CPF"+estudante.getCpf());
                    }
                }
            }
                if(opcao == 6){
                
                for(Estudante estudante : eb.buscar()){
                    System.out.println("Nome do estudante: "+ estudante.getNome());
                    System.out.println("CPF"+estudante.getCpf());
                    System.out.println("Nome do curso"+estudante.getCurso().getNome());
                    System.out.println("Duração"+estudante.getCurso().getDuracao());
                    System.out.println("Código"+estudante.getCurso().getCodigo());
                }
            }
        }while(opcao != 3);
    }
   
}

/*
create table curso(
	nome varchar, 
	codigo int, 
	duracao int, 
	id serial primary key
); 

create table estudante(
	nome varchar, 
	cpf int, 
	idcurso int references curso(id), 
	id serial primary key
);
*/