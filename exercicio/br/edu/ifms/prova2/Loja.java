package exercicio.br.edu.ifms.prova2;

import java.util.ArrayList;

public class Loja {

    private int id;

    private String nome;
    
    private String categoria;

    private Shopping shopping;

    private ArrayList<Funcionario> funcionarios;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Shopping getShopping() { return shopping; }

    public void setShopping(Shopping shopping) { this.shopping = shopping; }

    public ArrayList<Funcionario> getFuncionarios() { return funcionarios; }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) { this.funcionarios = funcionarios; }

    public String toString() { return ">Loja:\n-Nome: "+nome+"\n-Categoria: "+categoria+"-Shopping: "+shopping.getNome();}
}
