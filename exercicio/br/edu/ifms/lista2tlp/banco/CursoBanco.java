package exercicio.br.edu.ifms.lista2tlp.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exercicio.br.edu.ifms.lista2tlp.modelo.Curso;

public class CursoBanco{

    public void adicionar(Curso curso){
        try{
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Curso(nome, codigo, duracaoH) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, curso.getNome());
            statement.setInt(2, curso.getCodigo());
            statement.setInt(3, curso.getDuracaoH());

            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Curso> buscarTudo(){

        String sql = "SELECT * FROM Curso";
        ArrayList<Curso> listaCursos = new ArrayList<Curso>();

        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                listaCursos.add(new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("codigo"), rs.getInt("duracaoH")));
            }
            rs.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCursos;
    }

    public Curso buscarPorId(int id){

        ArrayList<Curso> listaCursos = this.buscarTudo();

        for(int i=0; i<listaCursos.size(); i++){
            if(listaCursos.get(i).hasId(id)){
                return listaCursos.get(i);
            }
        }
        return null;
    }

    public Curso buscarPorObjeto(Curso curso){

        ArrayList<Curso> listaCursos = this.buscarTudo();

        for(int i=0; i<listaCursos.size(); i++){
            if(listaCursos.get(i).equals(curso)){
                return listaCursos.get(i);
            }
        }
        return null;
    }

    public Curso buscarPorNome(String nome){

        ArrayList<Curso> listaCursos = this.buscarTudo();

        for(int i=0; i<listaCursos.size(); i++){
            if(listaCursos.get(i).getNome().equals(nome)){
                return listaCursos.get(i);
            }
        }
        return null;
    }

    public void alterarPorObjeto(Curso cursoAlterando, Curso cursoGravando){
        
        ArrayList<Curso> listaCursos = this.buscarTudo();

        for(int i=0; i<listaCursos.size(); i++){
            if(listaCursos.get(i).equals(cursoAlterando)){

                String sql = "UPDATE Curso SET nome=?, codigo=?, duracaoH=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, cursoGravando.getNome());
                    statement.setInt(2, cursoGravando.getCodigo());
                    statement.setInt(3, cursoGravando.getDuracaoH());
                    statement.setInt(3, cursoAlterando.getId());
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarPorId(int id, Curso cursoGravando){
        ArrayList<Curso> listaCursos = this.buscarTudo();

        for(int i=0; i<listaCursos.size(); i++){
            if(listaCursos.get(i).hasId(id)){
                String sql = "UPDATE Curso SET nome=?, codigo=?, duracaoH=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, cursoGravando.getNome());
                    statement.setInt(2, cursoGravando.getCodigo());
                    statement.setInt(3, cursoGravando.getDuracaoH());
                    statement.setInt(3, id);
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void deletarPorObjeto(Curso CursoDeletando){
        String sql = "DELETE FROM Curso INNER JOIN Estudante ON Curso.id = idCurso WHERE Curso.id=?";
        
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, CursoDeletando.getId());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletarPorId(int id){
        String sql = "DELETE FROM Curso INNER JOIN Estudante ON Curso.id = idCurso WHERE Curso.id=?";
        
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}