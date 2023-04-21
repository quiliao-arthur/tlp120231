package aula1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SetorBanco{
    //exemplo
    
    public void adicionar(Setor setor){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into setor values(?, ?, ?) returning id";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, setor.getNome());
            statement.setString(2, setor.getSigla());
            statement.setString(3, setor.getDescricao());
            ResultSet rs = statement.executeQuery();
            rs.next();
            setor.setId(rs.getInt("id"));
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    

    /*
    public ArrayList<TIPO> buscar(){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from TABELA";
        PreparedStatement statement = null; 
	        
        try{
            statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               //criar objeto e preencher informações com base nos dados do banco
               
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
    */
}