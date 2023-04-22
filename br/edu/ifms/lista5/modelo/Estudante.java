package br.edu.ifms.lista5.modelo;

public class Estudante {
    
    private int id;

    private String nome;

    //Cpf é String por problemas com zero
    private String cpf;

    private Curso curso;

    public int getId() {return id;}

    public void setId(int id) {this.id=id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf=cpf;}

    public Curso getCurso() {return curso;}

    public void setCurso(Curso curso) {this.curso=curso;}

    public Estudante() {super();}

    public Estudante(int id, String nome, String cpf, Curso curso) {
        super();
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
        this.curso=curso;
    }
    public Estudante(int id, String nome, String cpf, int idCurso, String nomeCurso, int codigo, int duracaoH) {
        super();
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
        this.curso=new Curso(idCurso, nomeCurso, codigo, duracaoH);
    }

    public Estudante(Estudante estudante){
        super();
        this.id=estudante.getId();
        this.nome=estudante.getNome();
        this.cpf=estudante.getCpf();
        this.curso=estudante.getCurso();
    }

    public String toString() {
        return "Estudante:\n Nome: "+nome+", Cpf: "+cpf+", "+curso.toString();
    }

    public boolean hasId(int id){
        if(this.id==id){
            return true;
        }
        return false;
    }

    public boolean equals(Estudante estudante) {
        if( this.id==estudante.getId() &&
            this.nome.equals(estudante.getNome()) &&
            this.cpf.equals(estudante.getCpf()) &&
            this.curso.equals(estudante.getCurso()))
            {
                return true;
            }
        return false;
    }
}