package br.edu.ifms.lista5;

public class Estudante {
    
    private int id;

    private String nome;

    //Cpf é String por problemas com zero
    private String cpf;

    private Curso curso;

    private int getId() {return id;}

    private void setId(int id) {this.id=id;}

    private String getNome() {return nome;}

    private void setNome(String nome) {this.nome=nome;}

    private String getCpf() {return cpf;}

    private void setCpf(String cpf) {this.cpf=cpf;}

    private Curso getCurso() {return curso;}

    private void setCurso(Curso curso) {this.curso=curso;}

    public Estudante() {super();}

    public Estudante(int id, String nome, String cpf, Curso curso) {
        super();
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
        this.curso=curso;
    }

    public Estudante(Estudante estudante){
        super();
        this.id=estudante.getId();
        this.nome=estudante.getNome();
        this.cpf=estudante.getCpf();
        this.curso=estudante.getCurso();
    }
}