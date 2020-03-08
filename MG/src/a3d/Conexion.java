package a3d;

import java.sql.*;

public class Conexion {

    Connection conexion = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mgames", "root", "kopernicuz");
            if (conexion != null) {
                System.out.println("Conección a base de datos listo");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        conexion = null;
    }
}
