package agendatelefonica;

import java.sql.*;

public class Conexion {

    Connection conn = null;

    public Conexion() {
        System.out.print("holasldkahsk jd");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "kopernicuz");
            if (conn != null) {
                System.out.println("Conección a base de datos listo");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
    }
}
