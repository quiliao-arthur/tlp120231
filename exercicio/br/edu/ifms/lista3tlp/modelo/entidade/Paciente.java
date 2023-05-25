package exercicio.br.edu.ifms.lista3tlp.modelo.entidade;

import java.util.ArrayList;

public class Paciente {
    
    private int id;
    private String nome;
    private String cpf;
    private ArrayList<Consulta> consultas;

    public int getId() { return id; }

    public void setId(int id) { this.id=id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome=nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf=cpf; }

    public ArrayList<Consulta> getConsultas() { return consultas; }
    
    public void setConsultas(ArrayList<Consulta> consultas) { this.consultas=consultas; }
    
}
