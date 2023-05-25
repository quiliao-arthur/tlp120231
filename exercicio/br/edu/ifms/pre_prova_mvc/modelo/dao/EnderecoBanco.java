package exercicio.br.edu.ifms.pre_prova_mvc.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exercicio.br.edu.ifms.pre_prova_mvc.modelo.entidade.Endereco;

public class EnderecoBanco {
    
    public Endereco adicionarRetornandoId(Endereco endereco) {

        String sql = "INSERT INTO Endereco VALUES (?, ?, ?) RETURNING id";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, endereco.getRua());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getBairro());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                endereco.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    public void adicionar(Endereco endereco) {

        String sql = "INSERT INTO Endereco VALUES (?, ?, ?)";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, endereco.getRua());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getBairro());
        }
    }
}
