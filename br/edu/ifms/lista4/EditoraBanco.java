package br.edu.ifms.lista4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditoraBanco{

    public void adicionar(Editora editora){
        try{
            Connection connection = ConectaBanco.getConnection();
            String sql = "INSERT INTO Editora VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, editora.getCodigo());
            statement.setString(2, editora.getNome());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Editora> buscarTudo(){

        String sql = "SELECT * FROM Editora";
        ArrayList<Editora> listaEditoras = new ArrayList<Editora>();

        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                listaEditoras.add(new Editora(rs.getInt("codigo"), rs.getString("nome")));
            }
            rs.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEditoras;
    }

    public Editora buscarPorId(int codigo){

        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).hasId(codigo)){
                return listaEditoras.get(i);
            }
        }
        return null;
    }

    public void alterarPorObjeto(Editora editoraAlterando, Editora editoraGravando){
        
        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).equals(editoraAlterando)){

                String sql = "UPDATE Editora SET codigo=?, nome=? WHERE codigo=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, editoraGravando.getCodigo());
                    statement.setString(2, editoraGravando.getNome());
                    statement.setInt(3, editoraAlterando.getCodigo());
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void alterarPorId(int codigo, Editora editoraGravando){
        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).hasId(codigo)){
                String sql = "UPDATE Editora SET codigo=?, nome=? WHERE codigo=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, editoraGravando.getCodigo());
                    statement.setString(2, editoraGravando.getNome());
                    statement.setInt(3, codigo);
                    statement.execute();
                    statement.close();
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}