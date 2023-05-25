package exercicio.br.edu.ifms.prova2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class LojaBanco {
    
    public Loja adicionar(Loja loja) {

        String sql = "INSERT INTO Loja VALUES(?, ?, ?) RETURNING id";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, loja.getNome());
            statement.setString(2, loja.getCategoria());
            statement.setInt(3, loja.getShopping().getId());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                loja.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loja;
    }

    public ArrayList<String> buscarCategorias() {

        ArrayList<String> categorias = new ArrayList<String>();

        String sql = "SELECT DISTINCT categoria FROM Lojas";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                categorias.add(resultSet.getString("categoria"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public ArrayList<Loja> buscarPorCategoria(String categoria) {
        
        ArrayList<Loja> lojasCategoria = new ArrayList<Loja>();
        Loja loja = new Loja();
        Shopping shoppingLoja = new Shopping();

        String sql = "SELECT nome, categoria, idShopping FROM Lojas WHERE categoria = ?";

        try {
            Connection connection = ConectaBanco.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, categoria);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                loja.setNome(resultSet.getString("nome"));
                loja.setCategoria(resultSet.getString("categoria"));
                shoppingLoja.setId(resultSet.getInt("id"));
                loja.setShopping(shoppingLoja);

                lojasCategoria.add(loja);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lojasCategoria;
    }
}
