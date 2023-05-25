package exercicio.br.edu.ifms.prova1mvc.modelo;

public class EquipamentoDAO {
    
    public Equipamento adicionar(Equipamento equipamento) {
        
        String sql = "INSERT INTO Equipamento VALUES (?, ?, ?, ?, ?) RETURNING id";

        
    }
}
