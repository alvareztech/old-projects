package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Conexion MySQL
 * @author Daniel Alvarez (a3dany)
 */
public class ConexionMySQL {

    private Connection conexion;

    public ConexionMySQL(String db, String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db, usuario, contrasenia);
    }

    public static void main(String[] args) {
        try {
            ConexionMySQL X = new ConexionMySQL("seresvivos", "root", "");
            //X.crearTabla();
//            X.insertar("perro");
//            X.insertar("gato");
//            X.insertar("pato");
//            X.listar();
//            X.actualizar(2);
            X.borrar(3);
            X.listar();
            X.cerrar();
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    public void crearTabla() throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeUpdate("CREATE TABLE animales (id int AUTO_INCREMENT, nombre varchar(30) NOT NULL, PRIMARY KEY (id))");
        consulta.close();
    }

    public void listar() throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM animales");
        while (resultado.next()) {
            System.out.println(resultado.getObject("id") + " " + resultado.getObject("nombre"));
        }
        resultado.close();
        consulta.close();
    }

    public void insertar(String nombre) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeUpdate("INSERT INTO animales (nombre) VALUES ('" + nombre + "')");
        consulta.close();
    }

    public void actualizar(int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        System.out.print("Nuevo Nombre: ");
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        consulta.executeUpdate("UPDATE animales SET nombre='" + nombre + "' WHERE id=" + id);
        consulta.close();
    }

    public void borrar(int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeUpdate("DELETE FROM animales WHERE id=" + id);
        consulta.close();
    }
}
