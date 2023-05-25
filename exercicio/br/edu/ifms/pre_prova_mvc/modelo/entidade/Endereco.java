package exercicio.br.edu.ifms.pre_prova_mvc.modelo.entidade;

import java.util.List;

public class Endereco {
    
    private int id;

    private String rua;

    private int numero;

    private String bairro;

    private List<Pessoa> moradores;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public List<Pessoa> getMoradores() { return moradores; }

    public void setMoradores(List<Pessoa> moradores) { this.moradores = moradores; }
}
