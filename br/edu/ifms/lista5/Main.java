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
            switch(opcao=menu()) {
                case -1: {
                    System.out.println("Favor escrever um número");
                    break;
                }
                case 0: {

                    break;
                }
                case 1: {
                    cadastroCurso();
                    break;
                }
                case 2: {
                    cadastroEstudante();
                    break;
                }
                case 3: {
                    atualizaEstudanteCurso();
                    break;
                }
                case 4: {
                    exibirMatriculados();
                    aberturaCurso();
                    break;
                }
                case 5: {
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
        }catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void cadastroCurso(){
        try (Scanner sc = new Scanner(System.in)) {
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
        try (Scanner sc = new Scanner(System.in)) {

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
            if (!(validaCpf(estudante.getCpf()))) {
                System.out.println("Cpf inválido!");
                return;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void atualizaEstudanteCurso() {
        try (Scanner sc = new Scanner(System.in)){
                       
            EstudanteBanco estudanteBanco = new EstudanteBanco();
            CursoBanco cursoBanco = new CursoBanco();
            Estudante estudante = new Estudante();
            ArrayList<Estudante> listaEstudantes = estudanteBanco.buscarTudo();
            ArrayList<Curso> listaCursos = cursoBanco.buscarTudo();
            ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();
            Curso cursoMatriculando = new Curso();

            System.out.println("Favor inserir o cpf do estudante cuja matrícula deve ser refeita:");
            estudante.setCpf(sc.nextLine());
            for(int i=0; i<listaEstudantes.size(); i++) {
                if(estudante.getCpf().equals(listaEstudantes.get(i).getCpf())) {
                    estudante = listaEstudantes.get(i);
                    break;
                }
            }
            if(estudante.getNome().equals(null)) {
                System.out.println("Estudante não encontrado.");
                return;
            }
            System.out.println("Favor inserir o nome do curso em que o estudante deseja se cadastrar:");
            cursoMatriculando.setNome(sc.nextLine());
            for(int i=0; i<listaCursos.size(); i++) {
                if(cursoMatriculando.getNome().equals(listaCursos.get(i).getNome())){
                    listaCursosBuscados.add(listaCursos.get(i));
                }
            }
            if(listaCursosBuscados.size()==0){
                System.out.println("Curso não encontrado");
            }else{
                if(listaCursosBuscados.size()==1){
                    estudante.setCurso(cursoMatriculando);
                    estudanteBanco.alterarPorId(estudante.getId(), estudante);
                    return;
                }else{
                    
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean validaCpf(String cpf) {
        if (cpf.length()==11) {
            int cpfDigito;
            int digitoVerificador = Integer.parseInt(cpf.substring(9, 10));
            int somaDigitos = 0;
            for (int i=0; i<9; i++) {
                cpfDigito = Character.getNumericValue(cpf.charAt(i));
                somaDigitos += cpfDigito*10-i;
            }
            if (11-(somaDigitos%11)==digitoVerificador) {
                return true;
            }
        }
        return false;
    }
 
    private static Estudante validaEstudante(Estudante estudante) {
        
        EstudanteBanco estudanteBanco = new EstudanteBanco();
        ArrayList<Estudante> listaEstudantes = estudanteBanco.buscarTudo();
        ArrayList<Estudante> listaEstudantesBuscados = new ArrayList<Estudante>();

        for (int i=0; i<listaEstudantes.size(); i++) {
            if (estudante.hasId(listaEstudantes.get(i).getId()) ||
                estudante.getNome().equals(listaEstudantes.get(i).getNome()) ||
                estudante.getCpf()==listaEstudantes.get(i).getCpf()) 
            {
                listaEstudantesBuscados.add(listaEstudantes.get(i));
            }
        }

        if (listaEstudantesBuscados.size()>1) {
            System.out.println("Estudantes equivalentes:");
            for (int i=0; i<listaEstudantesBuscados.size(); i++) {
                System.out.println(i+"- "+listaEstudantesBuscados.get(i).toString());
            }
            System.out.println("Favor inserir o número do estudante desejado.");

            try (Scanner sc = new Scanner(System.in)) {
                int indiceEstudante = Integer.parseInt(sc.nextLine());
                return listaEstudantesBuscados.get(indiceEstudante);
            } catch (Exception e) {
                System.out.println("Erro!");
                e.printStackTrace();
            }
        } else {
            if (listaEstudantesBuscados.size() == 0) {
                System.out.println("Nenhum estudante equivalente.");
                return null;
            } else {
                return listaEstudantesBuscados.get(0);
            }
        }

        return null;
    }

    private static Curso validaCurso(Curso curso) {

        CursoBanco cursoBanco = new CursoBanco();
        ArrayList<Curso> listaCursos = cursoBanco.buscarTudo();
        ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();

        for (int i=0; i<listaCursos.size(); i++){
            if (curso.hasId(listaCursos.get(i).getId()) ||
                curso.getNome().equals(listaCursos.get(i).getNome()) ||
                curso.getCodigo()==listaCursos.get(i).getCodigo()) 
            {
                listaCursosBuscados.add(listaCursos.get(i));
            }
        }

        if (listaCursosBuscados.size()>1) {
            System.out.println("Cursos equivalentes:");
            for (int i=0; i<listaCursosBuscados.size(); i++) {
                System.out.println(i+"- "+listaCursosBuscados.get(i).toString());
            }

            System.out.println("Favor inserir o número do curso desejado.");
            try (Scanner sc = new Scanner(System.in)) {
                int indiceCurso = Integer.parseInt(sc.nextLine());
                return listaCursosBuscados.get(indiceCurso);
            } catch (Exception e) {
                System.out.println("Erro!");
                e.printStackTrace();
            }

        } else {
            if (listaCursosBuscados.size()==0) {
                System.out.println("Nenhum curso encontrado.");
                return null;
            } else {
                return listaCursosBuscados.get(0);
            }
        }
        return null;
    }
}
