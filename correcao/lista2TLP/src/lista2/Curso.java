package lista2;

import java.util.ArrayList;

public class Curso {
    private String nome; 
    private int duracao, codigo, id;
    private ArrayList<Estudante> lista;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Estudante> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Estudante> lista) {
        this.lista = lista;
    }
}
