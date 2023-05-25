package lista2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lista1.Editora;

public class CursoBanco {
    EstudanteBanco eb = new EstudanteBanco();
    public void adicionar(Curso curso){
        try{
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into curso values(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, curso.getNome());
            statement.setInt(2, curso.getCodigo());
            statement.setInt(3, curso.getDuracao());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Curso> buscarTodos(){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from curso";
        ArrayList<Curso> lista = new ArrayList<Curso>();	        
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               Curso curso = new Curso(); 
               curso.setNome(rs.getString("nome"));
               curso.setCodigo(rs.getInt("codigo"));
               curso.setDuracao(rs.getInt("duracao"));
               lista.add(curso);
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
    
    public Curso buscarPorNome(String nome){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from curso where nome = ?";
        Curso curso = null;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               curso = new Curso(); 
               curso.setId(rs.getInt("id"));
            }
            rs.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return curso;
    } 
    public Curso buscarPorId(int idcurso){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from curso where id = ?";
        Curso curso = null;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, idcurso);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               curso = new Curso(); 
               curso.setId(rs.getInt("id"));
               curso.setCodigo(rs.getInt("codigo"));
               curso.setNome(rs.getString("nome"));
               curso.setDuracao(rs.getInt("duracao"));
            }
            rs.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return curso;
    } 
    public ArrayList<Curso> buscarEstudantesDoCurso(){
        
        Connection conexao = ConectaBanco.getConnection();
        String sql = "select * from curso";
        
        ArrayList<Curso> listaCurso = new ArrayList<Curso>();
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(); 
            while(rs.next()){
               Curso curso = new Curso(); 
               curso.setId(rs.getInt("id"));
               curso.setCodigo(rs.getInt("codigo"));
               curso.setNome(rs.getString("nome"));
               curso.setDuracao(rs.getInt("duracao"));
               
               int id = rs.getInt("id");
               ArrayList<Estudante> lista = eb.buscar(id);
               curso.setLista(lista);
               
               //opcao 2: equivalente às 3 linhas anteriores
               //curso.setLista(eb.buscar(rs.getInt("id")));
               
               listaCurso.add(curso);
            }
            rs.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return listaCurso;
    } 
}
