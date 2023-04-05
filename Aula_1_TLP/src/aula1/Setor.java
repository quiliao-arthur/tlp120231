package aula1;
import java.util.ArrayList;

public class Setor{
    private String nome, sigla, descricao; 
    private int id;
    
    private ArrayList<Pessoa> lista;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Pessoa> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Pessoa> lista) {
        this.lista = lista;
    }

}
