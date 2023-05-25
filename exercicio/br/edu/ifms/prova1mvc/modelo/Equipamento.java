package exercicio.br.edu.ifms.prova1mvc.modelo;

public class Equipamento {
    
    private int id;

    private String modelo;

    private String descricao;

    private double valor;

    private Servidor servidor;

    private Setor setor;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor=valor; }

    public Servidor getServidor() { return servidor; }

    public void setServidor(Servidor servidor) { this.servidor = servidor; }

    public Setor getSetor() { return setor; }

    public void setSetor(Setor setor) { this.setor = setor; }
}
