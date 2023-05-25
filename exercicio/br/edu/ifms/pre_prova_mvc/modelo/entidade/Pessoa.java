package exercicio.br.edu.ifms.pre_prova_mvc.modelo.entidade;

public class Pessoa {
    
    private int id;

    private String nome;

    private String rg;

    private Endereco moradia;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getRg() { return rg; }

    public void setRg(String rg) { this.rg = rg; }

    public Endereco getMoradia() { return moradia; }

    public void setEndereco(Endereco moradia) { this.moradia = moradia; }
}
