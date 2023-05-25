package exercicio.br.edu.ifms.lista3tlp.modelo.entidade;

import java.util.ArrayList;

public class Medico {
    
    private int id;
    private String nome;
    private int crm;
    ArrayList<Consulta> consultas;

    public int getId() { return id; }

    public void setId(int id) { this.id=id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome=nome; }

    public int getCrm() { return crm; }

    public void setCrm(int crm) { this.crm=crm; }

    public ArrayList<Consulta> getConsultas() { return consultas; }

    public void setConsultas(ArrayList<Consulta> consultas) { this.consultas=consultas; }
    
}
