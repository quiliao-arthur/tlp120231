package br.edu.ifms.lista6.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.ifms.lista6.modelo.Servidor;

public class ServidorBanco {
    
    public Servidor adicionar(Servidor servidor) {
        
        try {
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Servidor VALUES (?, ?) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, servidor.getNome());
            statement.setInt(2, servidor.getSiape());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                servidor.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servidor;
    }

    public Servidor buscaPorId(int id) {
        
        Servidor servidor = new Servidor();

        try {
            Connection connection = ConectaBanco.getConnection();
            String sql = "SELECT * FROM Servidor WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                servidor.setId(resultSet.getInt("id"));
                servidor.setNome(resultSet.getString("nome"));
                servidor.setSiape(resultSet.getInt("siape"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servidor;
    }
}
