package correcao.lista1mvc.src.model.entity;

import java.util.ArrayList;

public class Editora {
    private String nome;
    private int codigo, id;
    private ArrayList<Livro> lista;

    public ArrayList<Livro> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Livro> lista) {
        this.lista = lista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
