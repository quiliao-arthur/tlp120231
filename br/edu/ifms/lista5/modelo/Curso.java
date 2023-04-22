package br.edu.ifms.lista5.modelo;

public class Curso {
    
    private int id;

    private String nome;
    
    private int codigo;

    private int duracaoH;

    public int getId() {return id;}

    public void setId(int id) {this.id=id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome=nome;}

    public int getCodigo() {return codigo;}

    public void setCodigo(int codigo) {this.codigo=codigo;}

    public int getDuracaoH() {return duracaoH;}
    
    public void setDuracaoH(int duracaoH) {this.duracaoH=duracaoH;}

    public Curso(){super();}

    public Curso(int id, String nome, int codigo, int duracaoH){
        super();
        this.id=id;
        this.nome=nome;
        this.codigo=codigo;
        this.duracaoH=duracaoH;
    }

    public Curso(Curso curso){
        super();
        this.id=curso.getId();
        this.nome=curso.getNome();
        this.codigo=curso.getCodigo();
        this.duracaoH=curso.getDuracaoH();
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
            this.duracaoH==curso.getDuracaoH())
            {
            return true;
        }
        return false;
    }
}
