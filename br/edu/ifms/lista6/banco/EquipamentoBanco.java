package br.edu.ifms.lista6.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.ifms.lista6.modelo.Equipamento;

public class EquipamentoBanco {
    
    public Equipamento adicionar(Equipamento equipamento) {
        try {
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Equipamento VALUES (?, ?, ?, ?, ?) RETURNING id";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, equipamento.getModelo());
            statement.setString(2, equipamento.getDescricao());
            statement.setDouble(3, equipamento.getValor());
            statement.setInt(4, equipamento.getSetor().getId());
            statement.setInt(5, equipamento.getServidor().getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                equipamento.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamento;
    }
}
