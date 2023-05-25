package lista1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroBanco {
public void adicionar(Livro livro){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into livro values(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, livro.getNome());
            statement.setInt(2, livro.getAnoPublicacao());
            statement.setInt(3, livro.getEditora().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   
    public ArrayList<Livro> buscar(Editora editora){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from livro where ideditora = ?";
        ArrayList<Livro> lista = new ArrayList<Livro>();	        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, editora.getId());
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               Livro livro = new Livro();
               livro.setNome(rs.getString("nome"));
               lista.add(livro);
            }
            rs.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return lista;
    }
}
