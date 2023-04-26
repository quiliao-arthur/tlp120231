package br.edu.ifms.lista6.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.ifms.lista6.modelo.Setor;

public class SetorBanco {
    
    public Setor adicionar(Setor setor) {

        try {
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Setor VALUES (?, ?) RETURNING id";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, setor.getNome());
            statement.setString(2, setor.getDescricao());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) { 
                setor.setId(resultSet.getInt("id")); 
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setor;
    }
}
