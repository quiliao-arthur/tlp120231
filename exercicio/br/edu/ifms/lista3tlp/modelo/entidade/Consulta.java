package exercicio.br.edu.ifms.lista3tlp.modelo.entidade;

import java.util.Date;

public class Consulta {
    
    private int id;
    private Date data;
    private Medico medico;
    private Paciente paciente;

    public int getId() { return id; }

    public void setId(int id) { this.id=id; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data=data; }

    public Medico getMedico() { return medico; }

    public void setMedico(Medico medico) { this.medico=medico; }

    public Paciente getPaciente() { return paciente; }

    public void setPaciente(Paciente paciente) { this.paciente=paciente; }
    
}
