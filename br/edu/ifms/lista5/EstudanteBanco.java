package br.edu.ifms.lista5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

        String sql = "SELECT * FROM Estudante INNER JOIN Estudante ON Estudante.codigo=codigoEstudante";
        ArrayList<Estudante> listaEstudantes = new ArrayList<Estudante>();

        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                listaEstudantes.add(new Estudante(rs.getInt("id"), rs.getString("Estudante.nome"), rs.getInt("anoPublicacao"), rs.getInt("Estudante.codigo"), rs.getString("Estudante.nome")));
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

    public ArrayList<Estudante> buscarPorEditora(int codigoEditora){
        ArrayList<Estudante> listaTodosEstudantes = this.buscarTudo();
        ArrayList<Estudante> listaEstudantesEditora = new ArrayList<Estudante>();

        for(int i=0; i<listaTodosEstudantes.size(); i++){
            if(listaTodosEstudantes.get(i).getEditora().getCodigo()==codigoEditora){
                listaEstudantesEditora.add(listaTodosEstudantes.get(i));
            }
        }
        return listaEstudantesEditora;
    }

    public ArrayList<Estudante> buscarPorEditora(Editora editora){
        ArrayList<Estudante> listaTodosEstudantes = this.buscarTudo();
        ArrayList<Estudante> listaEstudantesEditora = new ArrayList<Estudante>();

        for(int i=0; i<listaTodosEstudantes.size(); i++){
            if(listaTodosEstudantes.get(i).getEditora().getCodigo()==editora.getCodigo()){
                listaEstudantesEditora.add(listaTodosEstudantes.get(i));
            }
        }
        return listaEstudantesEditora;
    }

    public void alterarPorObjeto(Estudante EstudanteAlterando, Estudante EstudanteGravando){
        
        ArrayList<Estudante> listaEstudantes = this.buscarTudo();

        for(int i=0; i<listaEstudantes.size(); i++){
            if(listaEstudantes.get(i).equals(EstudanteAlterando)){

                String sql = "UPDATE Estudante SET id=?, nome=?, anoPublicacao=?, codigoEditora=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, EstudanteGravando.getId());
                    statement.setString(2, EstudanteGravando.getNome());
                    statement.setInt(3, EstudanteGravando.getAnoPublicacao());
                    statement.setInt(4, EstudanteGravando.getEditora().getCodigo());
                    statement.setInt(5, EstudanteAlterando.getId());
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarPorId(int id, Estudante EstudanteGravando){
        ArrayList<Estudante> listaEstudantes = this.buscarTudo();

        for(int i=0; i<listaEstudantes.size(); i++){
            if(listaEstudantes.get(i).hasId(id)){
                String sql = "UPDATE Estudante SET id=?, nome=?, anoPublicacao=?, codigoEditora=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, EstudanteGravando.getId());
                    statement.setString(2, EstudanteGravando.getNome());
                    statement.setInt(3, EstudanteGravando.getAnoPublicacao());
                    statement.setInt(4, EstudanteGravando.getEditora().getCodigo());
                    statement.setInt(5, id);
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