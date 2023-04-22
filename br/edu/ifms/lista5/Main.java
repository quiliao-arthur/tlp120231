package br.edu.ifms.lista5;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifms.lista5.banco.CursoBanco;
import br.edu.ifms.lista5.banco.EstudanteBanco;
import br.edu.ifms.lista5.modelo.Curso;
import br.edu.ifms.lista5.modelo.Estudante;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        do{
            switch(opcao=menu()){
                case -1:{
                    System.out.println("Favor escrever um número");
                    break;
                }
                case 0:{

                    break;
                }
                case 1:{
                    cadastroCurso();
                    break;
                }
                case 2:{
                    cadastroEstudante();
                    break;
                }
                case 3:{
                    atualizaEstudanteCurso();
                    break;
                }
                case 4:{
                    exibirMatriculados();
                    aberturaCurso();
                    break;
                }
                case 5:{
                    exibirTudo();
                    break;
                }
            }
        }while(opcao!=0);
    }

    private static int menu(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println( "Sistema de matrícula Universitária\n"+
                                "1- Cadastro de curso\n"+
                                "2- Matrícula de estudante\n"+
                                "3- Atualizar curso de estudante\n"+
                                "4- Exibir matriculados de curso e verificar viabilidade de abertura\n"+
                                "5- Exibir todos os dados");
            return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }

    private static void cadastroCurso(){
        try (Scanner sc = new Scanner(System.in)){
            Curso curso = new Curso();
            CursoBanco cursoBanco = new CursoBanco();
            System.out.println("Favor inserir o nome do curso:");
            curso.setNome(sc.nextLine());
            System.out.println("Favor inserir o código do curso:");
            curso.setCodigo(Integer.parseInt(sc.nextLine()));
            System.out.println("Favor inserir a duração em horas do curso:");
            curso.setDuracaoH(Integer.parseInt(sc.nextLine()));
            cursoBanco.adicionar(curso);
        }
    }

    private static void cadastroEstudante(){
        try (Scanner sc = new Scanner(System.in)){

            Estudante estudante = new Estudante();
            Curso curso = new Curso();
            CursoBanco cursoBanco = new CursoBanco();
            EstudanteBanco estudanteBanco = new EstudanteBanco();
            ArrayList<Curso> listaCursos;
            ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();
            
            System.out.println("Favor inserir o nome do aluno:");
            estudante.setNome(sc.nextLine());
            System.out.println("Favor inserir o CPF do aluno:");
            estudante.setCpf(sc.nextLine());
            if(!(validaCpf(estudante.getCpf()))){
                System.out.println("Cpf inválido!");
                return;
            }

            System.out.println("Favor inserir o nome ou o código do curso do estudante:");
            String busca = sc.nextLine();
            curso.setNome(busca);
            curso.setCodigo(Integer.parseInt(busca));
            listaCursos = cursoBanco.buscarTudo();
            
            for(int i=0; i<listaCursos.size(); i++){
                if( listaCursos.get(i).getNome().equals(curso.getNome()) ||
                    listaCursos.get(i).getCodigo()==curso.getCodigo())
                    {
                        listaCursosBuscados.add(listaCursos.get(i));
                    }
            }

            if(listaCursosBuscados.size()==1){
                System.out.println("Curso selecionado:\n"+curso.toString());
            }else{
                int indiceCurso = 0;
                for(int i=0; i<listaCursosBuscados.size(); i++){
                    System.out.println(i+"- "+curso.toString());
                }
                System.out.println("Favor inserir o número do curso desejado:");
                try {
                    indiceCurso = Integer.parseInt(sc.nextLine());
                }catch(NumberFormatException e){
                    e.printStackTrace();
                    return;
                }
                if(listaCursosBuscados.size()-1>indiceCurso){
                    curso=listaCursosBuscados.get(indiceCurso);
                    estudante.setCurso(curso);
                    estudanteBanco.adicionar(estudante);
                }else{
                    System.out.println("Número inválido");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void atualizaEstudanteCurso(){
        try (Scanner sc = new Scanner(System.in)){
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean validaCpf(String cpf){
        if(cpf.length()==11){
            int cpfDigito;
            int digitoVerificador = Integer.parseInt(cpf.substring(9, 10));
            int somaDigitos = 0;
            for(int i=0; i<9; i++){
                cpfDigito = Character.getNumericValue(cpf.charAt(i));
                somaDigitos += cpfDigito*10-i;
            }
            if(11-(somaDigitos%11)==digitoVerificador){
                return true;
            }
        }
        return false;
    }
}
