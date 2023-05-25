package exercicio.br.edu.ifms.prova2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ShoppingBanco {
    
    public Shopping adicionar(Shopping shopping) {
        
        String sql = "INSERT INTO Shopping VALUES (?) RETURNING id";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, shopping.getNome());

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                shopping.setId(resultSet.getInt("id"));
            }
            
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return shopping;
    }
    
    public ArrayList<Shopping> buscarPorNome(String nomeShopping) {

        ArrayList<Shopping> shoppingsBuscados = new ArrayList<Shopping>();
        
        Shopping shopping = new Shopping();

        String sql = "SELECT nome, id FROM Shopping WHERE nome = ?";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nomeShopping);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                shopping.setNome(resultSet.getString("nome"));
                shopping.setId(resultSet.getInt("id"));

                shoppingsBuscados.add(shopping);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingsBuscados;
    }

    public ArrayList<Shopping> buscarTudo() {

        ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
        Shopping shopping = new Shopping();

        String sql = "SELECT nome, id FROM Shopping";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                shopping.setNome(resultSet.getString("nome"));
                shopping.setId(resultSet.getInt("id"));

                shoppings.add(shopping);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppings;
    }
}
