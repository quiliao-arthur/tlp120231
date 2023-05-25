package exercicio.br.edu.ifms.prova1mvc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco {

    private static String url;
    private static String user;
    private static String password;

    private static Connection connection;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/prova1";
        user = "postgres";
        password = "bORIS2019";

        try {
            connection =  DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
