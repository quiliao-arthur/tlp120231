package aula1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PessoaBanco{
    //exemplo
    /*
    public void adicionar(objeto){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into TABELA values(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, INFO));
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    */

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