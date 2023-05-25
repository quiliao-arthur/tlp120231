package exercicio.br.edu.ifms.pre_prova_mvc.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco{

    private static String url, usuario, senha;
    private static Connection con;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        senha = "bORIS2019";
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }   
}
