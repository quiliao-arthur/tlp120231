package exercicio.br.edu.ifms.prova1mvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServidorDAO {
    
    public Servidor adicionarRetornandoId(Servidor servidor) {

        String sql = "INSERT INTO Servidor VALUES (?, ?) RETURNING id";

        try {
            Connection connection = ConectaBanco.getConnection();

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

    public void adicionar(Servidor servidor) {

        String sql = "INSERT INTO Servidor VALUES (?, ?)";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, servidor.getNome());
            statement.setInt(2, servidor.getSiape());
            
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Servidor> buscarTudo() {
        
        ArrayList<Servidor> servidores = new ArrayList<Servidor>();
        Servidor servidorAdicionando = new Servidor();
        String sql = "SELECT * FROM Servidor";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                servidorAdicionando.setId(resultSet.getInt("id"));
                servidorAdicionando.setNome(resultSet.getString("nome"));
                servidorAdicionando.setSiape(resultSet.getInt("siape"));

                servidores.add(servidorAdicionando);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return servidores;
    }

    public Servidor buscarPorId(int id) {

        Servidor servidorBuscando = new Servidor();
        String sql = "SELECT * FROM Servidor WHERE id = ?";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                servidorBuscando.setId(resultSet.getInt("id"));
                servidorBuscando.setNome(resultSet.getString("nome"));
                servidorBuscando.setSiape(resultSet.getInt("siape"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return servidorBuscando;
    }
}
