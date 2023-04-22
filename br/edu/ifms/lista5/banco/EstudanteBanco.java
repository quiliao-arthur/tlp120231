package br.edu.ifms.lista5.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.ifms.lista5.modelo.Curso;
import br.edu.ifms.lista5.modelo.Estudante;

public class EstudanteBanco{

    public void adicionar(Estudante estudante){
        try{
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Estudante (nome, cpf, idCurso) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, estudante.getNome());
            statement.setString(3, estudante.getCpf());
            statement.setInt(4, estudante.getCurso().getId());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Estudante> buscarTudo(){

        String sql = "SELECT * FROM Estudante INNER JOIN Curso ON idcuros=curso.id";
        ArrayList<Estudante> listaEstudantes = new ArrayList<Estudante>();

        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                listaEstudantes.add(new Estudante(rs.getInt("id"), rs.getString("Estudante.nome"), rs.getString("cpf"), rs.getInt("idCurso"), rs.getString("Curso.nome"), rs.getInt("Curso.codigo"), rs.getInt("duracaoH")));
            }
            rs.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEstudantes;
    }

    public Estudante buscarPorId(int id){

        ArrayList<Estudante> listaEstudantes = this.buscarTudo();

        for(int i=0; i<listaEstudantes.size(); i++){
            if(listaEstudantes.get(i).hasId(id)){
                return listaEstudantes.get(i);
            }
        }
        return null;
    }

    public ArrayList<Estudante> buscarPorCurso(int idCurso){
        ArrayList<Estudante> listaTodosEstudantes = this.buscarTudo();
        ArrayList<Estudante> listaEstudantesCurso = new ArrayList<Estudante>();

        for(int i=0; i<listaTodosEstudantes.size(); i++){
            if(listaTodosEstudantes.get(i).getCurso().hasId(idCurso)){
                listaEstudantesCurso.add(listaTodosEstudantes.get(i));
            }
        }
        return listaEstudantesCurso;
    }

    public ArrayList<Estudante> buscarPorCurso(Curso curso){
        ArrayList<Estudante> listaTodosEstudantes = this.buscarTudo();
        ArrayList<Estudante> listaEstudantesCurso = new ArrayList<Estudante>();

        for(int i=0; i<listaTodosEstudantes.size(); i++){
            if(listaTodosEstudantes.get(i).getCurso().equals(curso)){
                listaEstudantesCurso.add(listaTodosEstudantes.get(i));
            }
        }
        return listaEstudantesCurso;
    }

    public void alterarPorObjeto(Estudante estudanteAlterando, Estudante estudanteGravando){
        
        ArrayList<Estudante> listaEstudantes = this.buscarTudo();

        for(int i=0; i<listaEstudantes.size(); i++){
            if(listaEstudantes.get(i).equals(estudanteAlterando)){

                String sql = "UPDATE Estudante SET nome=?, cpf=?, idCurso=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, estudanteGravando.getNome());
                    statement.setString(2, estudanteGravando.getCpf());
                    statement.setInt(3, estudanteGravando.getCurso().getId());
                    statement.setInt(4, estudanteAlterando.getId());
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarPorId(int id, Estudante estudanteGravando){
        ArrayList<Estudante> listaEstudantes = this.buscarTudo();

        for(int i=0; i<listaEstudantes.size(); i++){
            if(listaEstudantes.get(i).hasId(id)){
                String sql = "UPDATE Estudante SET nome=?, cpf=?, idCurso=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, estudanteGravando.getNome());
                    statement.setString(2, estudanteGravando.getCpf());
                    statement.setInt(3, estudanteGravando.getCurso().getId());
                    statement.setInt(4, id);
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void deletarPorObjeto(Estudante EstudanteDeletando){
        String sql = "DELETE FROM Estudante WHERE Estudante.id=?";
        
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, EstudanteDeletando.getId());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletarPorId(int id){
        String sql = "DELETE FROM Estudante WHERE Estudante.id=?";
        
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