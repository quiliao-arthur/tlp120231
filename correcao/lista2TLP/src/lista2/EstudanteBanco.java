package lista2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EstudanteBanco {
    CursoBanco cb = new CursoBanco(); 
    public void adicionar(Estudante estudante){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into estudante values(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, estudante.getNome());
            statement.setInt(2, estudante.getCpf());
            statement.setInt(3, estudante.getCurso().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Estudante> buscar(){
        ArrayList<Estudante> lista = new ArrayList<Estudante>();
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from estudante";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Estudante estudante = new Estudante();
                estudante.setCpf(rs.getInt("cpf"));
                estudante.setNome(rs.getString("nome"));
                
                int idcurso = rs.getInt("idcurso");
                Curso curso = cb.buscarPorId(idcurso);
                estudante.setCurso(curso);
                
                //opção 2 - equivalente às 3 linhas anteriores
                //estudante.setCurso(cb.buscarPorId(rs.getInt("idcurso")));
                
                lista.add(estudante);
            }
            
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Estudante> buscar(int id){
        ArrayList<Estudante> lista = new ArrayList<Estudante>();
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from estudante where idcurso = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Estudante estudante = new Estudante();
                
                estudante.setCpf(rs.getInt("cpf"));
                estudante.setNome(rs.getString("nome"));
                
                lista.add(estudante);
            }
            
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
