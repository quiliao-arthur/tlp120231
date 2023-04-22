package br.edu.ifms.lista4.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.ifms.lista4.modelo.Livro;
import br.edu.ifms.lista4.modelo.Editora;

public class LivroBanco{

    public void adicionar(Livro livro){
        try{
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Livro (nome, anoPublicacao, codigoEditora) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, livro.getNome());
            statement.setInt(3, livro.getAnoPublicacao());
            statement.setInt(4, livro.getEditora().getCodigo());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Livro> buscarTudo(){

        String sql = "SELECT * FROM Livro INNER JOIN Livro ON Livro.codigo=codigoLivro";
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();

        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                listaLivros.add(new Livro(rs.getInt("id"), rs.getString("Livro.nome"), rs.getInt("anoPublicacao"), rs.getInt("Livro.codigo"), rs.getString("Livro.nome")));
            }
            rs.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaLivros;
    }

    public Livro buscarPorId(int id){

        ArrayList<Livro> listaLivros = this.buscarTudo();

        for(int i=0; i<listaLivros.size(); i++){
            if(listaLivros.get(i).hasId(id)){
                return listaLivros.get(i);
            }
        }
        return null;
    }

    public ArrayList<Livro> buscarPorEditora(int codigoEditora){
        ArrayList<Livro> listaTodosLivros = this.buscarTudo();
        ArrayList<Livro> listaLivrosEditora = new ArrayList<Livro>();

        for(int i=0; i<listaTodosLivros.size(); i++){
            if(listaTodosLivros.get(i).getEditora().getCodigo()==codigoEditora){
                listaLivrosEditora.add(listaTodosLivros.get(i));
            }
        }
        return listaLivrosEditora;
    }

    public ArrayList<Livro> buscarPorEditora(Editora editora){
        ArrayList<Livro> listaTodosLivros = this.buscarTudo();
        ArrayList<Livro> listaLivrosEditora = new ArrayList<Livro>();

        for(int i=0; i<listaTodosLivros.size(); i++){
            if(listaTodosLivros.get(i).getEditora().getCodigo()==editora.getCodigo()){
                listaLivrosEditora.add(listaTodosLivros.get(i));
            }
        }
        return listaLivrosEditora;
    }

    public void alterarPorObjeto(Livro livroAlterando, Livro livroGravando){
        
        ArrayList<Livro> listaLivros = this.buscarTudo();

        for(int i=0; i<listaLivros.size(); i++){
            if(listaLivros.get(i).equals(livroAlterando)){

                String sql = "UPDATE Livro SET id=?, nome=?, anoPublicacao=?, codigoEditora=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, livroGravando.getId());
                    statement.setString(2, livroGravando.getNome());
                    statement.setInt(3, livroGravando.getAnoPublicacao());
                    statement.setInt(4, livroGravando.getEditora().getCodigo());
                    statement.setInt(5, livroAlterando.getId());
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarPorId(int id, Livro livroGravando){
        ArrayList<Livro> listaLivros = this.buscarTudo();

        for(int i=0; i<listaLivros.size(); i++){
            if(listaLivros.get(i).hasId(id)){
                String sql = "UPDATE Livro SET id=?, nome=?, anoPublicacao=?, codigoEditora=? WHERE id=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, livroGravando.getId());
                    statement.setString(2, livroGravando.getNome());
                    statement.setInt(3, livroGravando.getAnoPublicacao());
                    statement.setInt(4, livroGravando.getEditora().getCodigo());
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

    public void deletarPorObjeto(Livro LivroDeletando){
        String sql = "DELETE FROM Livro WHERE Livro.id=?";
        
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, LivroDeletando.getId());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletarPorId(int id){
        String sql = "DELETE FROM Livro WHERE Livro.id=?";
        
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