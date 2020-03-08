package agendatelefonica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contacto {

    Conexion con;

    public Contacto() {
        con = new Conexion();
    }
    /*Añade un nuevo registro*/

    public void adicionaContacto(String n, String p, String m, int s, Date f, String d, int t, int td, String c, String com) {
        try {
            PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("INSERT INTO contactos (nombres, apellido_paterno, apellido_materno, sexo, fecha_nacimiento, domicilio, telefono, telefono_domicilio, correo_electronico, comentarios) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, n);
            pstm.setString(2, p);
            pstm.setString(3, m);
            pstm.setInt(4, s);
            pstm.setDate(5, (java.sql.Date) f);
            pstm.setString(6, d);
            pstm.setInt(7, t);
            pstm.setInt(8, td);
            pstm.setString(9, c);
            pstm.setString(10, com);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /*obtenemos todos los datos de la tabla*/

    public Object[][] getDatos() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM contactos ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][10];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT nombres, apellido_paterno, apellido_materno, sexo, fecha_nacimiento, domicilio, telefono, telefono_domicilio, correo_electronico, comentarios FROM contactos ORDER BY codigo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String xNombres = res.getString("nombres");
                String xPaterno = res.getString("apellido_paterno");
                String xMaterno = res.getString("apellido_materno");
                int xSexo = res.getInt("sexo");
                Date xFechaNacimiento = res.getDate("fecha_nacimiento");
                String xDomicilio = res.getString("domicilio");
                int xTelefono = res.getInt("telefono");
                int xTelefonoDomicilio = res.getInt("telefono_domicilio");
                String xCorreoElectronico = res.getString("correo_electronico");
                String xComentarios = res.getString("comentarios");
                datos[i][0] = xNombres;
                datos[i][1] = xPaterno;
                datos[i][2] = xMaterno;
                datos[i][3] = xSexo == 0 ? "masculino" : "femenino";
                datos[i][4] = xFechaNacimiento.toString();
                datos[i][5] = xDomicilio;
                datos[i][6] = xTelefono + "";
                datos[i][7] = xTelefonoDomicilio + "";
                datos[i][8] = xCorreoElectronico;
                datos[i][9] = xComentarios;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }
}
