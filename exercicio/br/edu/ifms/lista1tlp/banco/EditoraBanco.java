package exercicio.br.edu.ifms.lista1tlp.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exercicio.br.edu.ifms.lista1tlp.modelo.Editora;

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

    public Editora buscarPorObjeto(Editora editora){

        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).equals(editora)){
                return listaEditoras.get(i);
            }
        }
        return null;
    }

    public Editora buscarPorNome(String nome){

        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).getNome().equals(nome)){
                return listaEditoras.get(i);
            }
        }
        return null;
    }

    public void alterarPorObjeto(Editora editoraAlterando, Editora editoraGravando){
        
        ArrayList<Editora> listaEditoras = this.buscarTudo();

        for(int i=0; i<listaEditoras.size(); i++){
            if(listaEditoras.get(i).equals(editoraAlterando)){

                String sql = "UPDATE Editora SET codigo=?, nome=? WHERE codigo=? AND nome=?";

                try{
                    Connection connection = ConectaBanco.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, editoraGravando.getCodigo());
                    statement.setString(2, editoraGravando.getNome());
                    statement.setInt(3, editoraAlterando.getCodigo());
                    statement.setString(4, editoraAlterando.getNome());
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

    public void deletarPorObjeto(Editora editoraDeletando){
        String sql = "DELETE FROM Editora INNER JOIN Livro ON Editora.codigo = livro.codigoEditora WHERE Editora.codigo=? AND Editora.nome=?";
        
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, editoraDeletando.getCodigo());
            statement.setString(2, editoraDeletando.getNome());
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletarPorId(int codigo){
        String sql = "DELETE FROM Editora INNER JOIN Livro ON Editora.codigo=codigoEditora WHERE Editora.codigo=?";
         
        try{
            Connection connection = ConectaBanco.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, codigo);
            statement.execute();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}