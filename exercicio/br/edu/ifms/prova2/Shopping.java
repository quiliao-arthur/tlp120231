package exercicio.br.edu.ifms.prova2;

import java.util.ArrayList;

public class Shopping {
    private int id;

    private String nome;

    ArrayList<Loja> lojas;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public ArrayList<Loja> getLojas() { return lojas; }

    public void setLojas(ArrayList<Loja> lojas) { this.lojas = lojas; }

    public String toString() { return "Shooping>\n-Nome: " + nome; }
}
