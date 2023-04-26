package br.edu.ifms.lista5.modelo;

import java.util.ArrayList;

public class Curso {
    
    private int id;

    private String nome;
    
    private int codigo;

    private int duracaoH;

    private ArrayList<Estudante> estudantes;

    public int getId() {return id;}

    public void setId(int id) {this.id=id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public int getCodigo() {return codigo;}

    public void setCodigo(int codigo) {this.codigo=codigo;}

    public int getDuracaoH() {return duracaoH;}
    
    public void setDuracaoH(int duracaoH) {this.duracaoH=duracaoH;}

    public ArrayList<Estudante> getEstudantes() {return estudantes;}

    public void setEstudantes(ArrayList<Estudante> estudantes) {this.estudantes=estudantes;}

    public Curso(){
        super();
        id=0;
        nome="";
        codigo=0;
        duracaoH=0;
        estudantes=new ArrayList<Estudante>();
    }

    public Curso(int id, String nome, int codigo, int duracaoH /*ArrayList<Estudante> estudantes*/){
        super();
        this.id=id;
        this.nome=nome;
        this.codigo=codigo;
        this.duracaoH=duracaoH;
        /*this.estudantes=estudantes;*/
    }

    public Curso(Curso curso){
        super();
        this.id=curso.getId();
        this.nome=curso.getNome();
        this.codigo=curso.getCodigo();
        this.duracaoH=curso.getDuracaoH();
        this.estudantes=curso.getEstudantes();
    }

    public String toString(){
        return "Curso:\n Nome: "+nome+", código: "+codigo+", duração(h): "+duracaoH;
    }

    public boolean hasId(int id){
        if(this.id==id){
            return true;
        }
        return false;
    }

    public boolean equals(Curso curso){
        if (this.id==curso.getId() &&
            this.nome.equals(curso.getNome()) &&
            this.codigo==curso.getCodigo() &&
            this.duracaoH==curso.getDuracaoH()
            //&& this.getEstudantes().equals(curso.getEstudantes())
            )
            {
            return true;
        }
        return false;
    }
}
