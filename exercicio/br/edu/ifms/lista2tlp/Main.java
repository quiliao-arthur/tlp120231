package exercicio.br.edu.ifms.lista2tlp;

import java.util.ArrayList;
import java.util.Scanner;

import exercicio.br.edu.ifms.lista2tlp.banco.CursoBanco;
import exercicio.br.edu.ifms.lista2tlp.banco.EstudanteBanco;
import exercicio.br.edu.ifms.lista2tlp.modelo.Curso;
import exercicio.br.edu.ifms.lista2tlp.modelo.Estudante;
import exercicio.br.edu.ifms.lista2tlp.organizadados.OrganizaCurso;
import exercicio.br.edu.ifms.lista2tlp.organizadados.OrganizaEstudante;

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
                    exibirMatriculadosAvaliaAbertura();
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
        
        System.out.println( "Sistema de matrícula Universitária\n"+
                            "1- Cadastro de curso\n"+
                            "2- Matrícula de estudante\n"+
                            "3- Atualizar curso de estudante\n"+
                            "4- Exibir matriculados de curso e verificar viabilidade de abertura\n"+
                            "5- Exibir todos os dados");
        
        try (Scanner sc = new Scanner(System.in)) {
            return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void cadastroCurso() {

        try (Scanner sc = new Scanner(System.in)) {

            Curso curso = new Curso();
            CursoBanco cursoBanco = new CursoBanco();
            OrganizaCurso organizaCurso = new OrganizaCurso();

            System.out.println("Favor inserir o nome do curso:");
            curso.setNome(sc.nextLine());
            System.out.println("Favor inserir o código do curso:");
            curso.setCodigo(Integer.parseInt(sc.nextLine()));
            System.out.println("Favor inserir a duração em horas do curso:");
            curso.setDuracaoH(Integer.parseInt(sc.nextLine()));

            if (!organizaCurso.duplicataCurso(curso)) {
                cursoBanco.adicionar(curso);
            } else {
                System.out.println("Curso já existente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cadastroEstudante(){

        Estudante estudante = new Estudante();
        OrganizaEstudante organizaEstudante = new OrganizaEstudante();
        OrganizaCurso organizaCurso = new OrganizaCurso();

        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.println("Favor inserir o nome do aluno:");
            estudante.setNome(sc.nextLine());
            System.out.println("Favor inserir o CPF do aluno:");
            estudante.setCpf(sc.nextLine());
            if (!(organizaEstudante.validaCpf(estudante.getCpf()))) {
                System.out.println("Cpf inválido!");
                return;
            }
            
            if (!organizaEstudante.duplicataEstudante(estudante)) {

                String cursoPesquisa;
                ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();
                int indiceCursoBuscado;

                do{
                    System.out.println("Insira ou o nome ou o código do curso do estudante:");
                    cursoPesquisa = sc.nextLine();
                    organizaCurso.buscaCurso(cursoPesquisa);

                    if (listaCursosBuscados.size()==1) {
                        estudante.setCurso(listaCursosBuscados.get(0));
                        return;
                    } else {
                        if (listaCursosBuscados.size()>1) {
                            System.out.println("Cursos equivalentes:");
                            for (int i=0; i<listaCursosBuscados.size(); i++) {
                                System.out.println("Número: "+i+"- "+listaCursosBuscados.get(i).toString());
                            }
                            System.out.println("Favor inserir o associado ao curso desejado");
                            indiceCursoBuscado = Integer.parseInt(sc.nextLine());
                            if (indiceCursoBuscado<listaCursosBuscados.size() &&
                                indiceCursoBuscado>-1) 
                                {
                                estudante.setCurso(listaCursosBuscados.get(indiceCursoBuscado));
                            }
                        }
                        return;
                    }
                } while (estudante.getCurso().getNome().equals(""));
            } else {
                System.out.println("Estudante já cadastrado.");
                return;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void atualizaEstudanteCurso() {
        
        Estudante estudante = new Estudante();
        EstudanteBanco estudanteBanco = new EstudanteBanco();
        ArrayList<Estudante> listaEstudantesBuscados = new ArrayList<Estudante>();
        ArrayList<Curso> listaCursosBuscados = new ArrayList<Curso>();
        Curso cursoMatriculando = new Curso();
        OrganizaEstudante organizaEstudante = new OrganizaEstudante();
        OrganizaCurso organizaCurso = new OrganizaCurso();

        try (Scanner sc = new Scanner(System.in)) {
                       
            System.out.println("Favor inserir o cpf do estudante cuja matrícula deve ser refeita:");
            estudante.setCpf(sc.nextLine());
            listaEstudantesBuscados = organizaEstudante.buscaEstudante(estudante.getCpf());

            if (listaEstudantesBuscados.size()==0) {
                System.out.println("Estudante não encontrado.");
                return;
            }
            if (listaEstudantesBuscados.size()>1) {
                System.out.println("Integridade da base de dados comprometida.");
                return;
            }
            estudante = listaEstudantesBuscados.get(0);
            System.out.println("Favor inserir o nome do curso em que o estudante deseja se cadastrar:");
            cursoMatriculando.setNome(sc.nextLine());
            listaCursosBuscados = organizaCurso.buscaCurso(cursoMatriculando.getNome());

            if(listaCursosBuscados.size()==0) {
                System.out.println("Curso não encontrado");
                return;
            }
            if(listaCursosBuscados.size()==1) {
                estudante.setCurso(listaCursosBuscados.get(0));
                estudanteBanco.alterarPorId(estudante.getId(), estudante);
                return;
            }
            if(listaCursosBuscados.size()>1) {
                int indiceCursoBuscado;
                System.out.println("Cursos equivalentes");
                for (int i=0; i<listaCursosBuscados.size(); i++) {
                    System.out.println("Número: "+i+"- "+listaCursosBuscados.get(i).toString());
                }
                System.out.println("Favor inserir o número associado ao curso desejado.");
                indiceCursoBuscado=Integer.parseInt(sc.nextLine());
                if (indiceCursoBuscado>-1&&indiceCursoBuscado<listaCursosBuscados.size()){
                    estudante.setCurso(listaCursosBuscados.get(indiceCursoBuscado));
                    estudanteBanco.alterarPorId(estudante.getId(), estudante);
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirMatriculadosAvaliaAbertura() {
        EstudanteBanco estudanteBanco = new EstudanteBanco();
        Curso curso = new Curso();
        OrganizaCurso organizaCurso = new OrganizaCurso();
        ArrayList<Curso> listaCursosBuscados = new ArrayList<>();
        ArrayList<Estudante> listaEstudantesCurso = new ArrayList<>();

        System.out.println("Favor inserir o nome do curso");
        try (Scanner sc = new Scanner(System.in)) {
            curso.setNome(sc.nextLine());
            listaCursosBuscados = organizaCurso.buscaCurso(curso.getNome());

            if (listaCursosBuscados.size()==1) {
                listaEstudantesCurso = estudanteBanco.buscarPorCurso(listaCursosBuscados.get(0));
                for (int i=0; i<listaEstudantesCurso.size(); i++) {
                    System.out.println(listaEstudantesCurso.get(i).toString());
                }
            } else {
                if (listaCursosBuscados.size() == 0) {
                    System.out.println("Curso não encontrado");
                    return;
                } else {
                    System.out.println("Cursos equivalentes:");
                    for (int i=0; i<listaCursosBuscados.size(); i++) {
                        System.out.println("Número: "+i+"- "+listaCursosBuscados.get(i).toString());
                    }
                    System.out.println("Favor inserir o número associado ao curso desejado");
                    int indiceCursoBuscado = Integer.parseInt(sc.nextLine());

                    if (indiceCursoBuscado>-1&&indiceCursoBuscado<listaCursosBuscados.size()) {
                        listaEstudantesCurso=estudanteBanco.buscarPorCurso(listaCursosBuscados.get(indiceCursoBuscado));
                    } else {
                        System.out.println("Curso não encontrado.");
                        return;
                    }
                }
            }
            System.out.println("Qual é a cota para abertura do curso?");
            int numVagas = Integer.parseInt(sc.nextLine());
            for (int i=0; i<listaEstudantesCurso.size(); i++) {
                System.out.println(listaEstudantesCurso.get(i).toString());
            }
            if(numVagas>listaEstudantesCurso.size()) {
                System.out.println("O curso ainda não abre");
            } else {
                System.out.println("O curso abre!");    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirTudo() {
        EstudanteBanco estudanteBanco = new EstudanteBanco();
        CursoBanco cursoBanco = new CursoBanco();
        ArrayList<Estudante> listaEstudantes = estudanteBanco.buscarTudo();
        ArrayList<Curso> listaCursos = cursoBanco.buscarTudo();
        for(int i=0; i<listaCursos.size(); i++) {
            System.out.println(listaCursos.get(i));
            listaEstudantes = estudanteBanco.buscarPorCurso(listaCursos.get(i));
            System.out.println("Matriculados no curso:");
            for(int j=0; j<listaEstudantes.size(); j++) {
                System.out.println(listaEstudantes.get(j).toStringSemCurso());
            }
        }
    }
}
