package exercicio.br.edu.ifms.prova2;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco {

    private static String url;
    private static String usuario;
    private static String senha;

    private static Connection connection;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/prova1";
        usuario = "postgres";
        senha = "bORIS2019";

        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
