package aula1;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco{

    private static String url, usuario, senha;
    private static Connection con;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/postgres";//modifique aqui
        usuario = "postgres";//modifique aqui
        senha = "1234";//modifique aqui
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }   
}



