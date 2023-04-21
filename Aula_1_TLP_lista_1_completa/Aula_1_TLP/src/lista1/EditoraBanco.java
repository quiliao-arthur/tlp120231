package lista1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditoraBanco {
    public void adicionar(Editora editora){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into editora values(?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, editora.getNome());
            statement.setInt(2, editora.getCodigo());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Editora> buscarTodos(){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from editora";
        ArrayList<Editora> lista = new ArrayList<Editora>();	        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               Editora editora = new Editora();
               editora.setCodigo(rs.getInt("codigo"));
               editora.setId(rs.getInt("id"));
               editora.setNome(rs.getString("nome"));
               lista.add(editora);
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
    
    public Editora buscarPorNome(String nome){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from editora where nome = ?";
        Editora editora = null;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery(); 
            if(rs.next()){
               editora = new Editora();
               editora.setCodigo(rs.getInt("codigo"));
               editora.setId(rs.getInt("id"));
               editora.setNome(rs.getString("nome"));
               
            }
            rs.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return editora;
    } 
}
