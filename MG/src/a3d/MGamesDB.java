package a3d;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class MGamesDB {

    private Conexion conexion;

    public MGamesDB() {
        conexion = new Conexion();
    }

    public void adicionarCliente(int b, String c, String d, String e) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO cliente(codigo_cliente, nombre, paterno, materno) VALUES (?, ?, ?, ?)");
            consulta.setInt(1, b);
            consulta.setString(2, c);
            consulta.setString(3, d);
            consulta.setString(4, e);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarEmpleado(int b, String c, String d, String e, String f, String g, int h, String i, Date j, String k, String l) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO empleado(codigo_empleado, nombre, paterno, materno, sexo, direccion, telefono, correo, fecha_nacimiento, cargo, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setString(2, c);
            consulta.setString(3, d);
            consulta.setString(4, e);
            consulta.setString(5, f);
            consulta.setString(6, g);
            consulta.setInt(7, h);
            consulta.setString(8, i);
            consulta.setDate(9, (java.sql.Date) j);
            consulta.setString(10, k);
            consulta.setString(11, l);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarServicio(String b, double c, String d, String e) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO servicio(tipo, costo_hora, estado, caracteristicas) VALUES (?, ?, ?, ?)");

            consulta.setString(1, b);
            consulta.setDouble(2, c);
            consulta.setString(3, d);
            consulta.setString(4, e);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarProducto(int b, int c, String d, double e) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO producto(tipo, costo_hora, estado, caracteristicas) VALUES (?, ?, ?, ?)");
            consulta.setInt(1, b);
            consulta.setInt(2, c);
            consulta.setString(3, d);
            consulta.setDouble(4, e);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarProveedor(String b, int c, String d) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO proveedor(nombre, telefono, direccion) VALUES (?, ?, ?)");

            consulta.setString(1, b);
            consulta.setInt(2, c);
            consulta.setString(3, d);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarPedidos(int b, int c, int d, Date e) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO pedido(codigo_cliente, codigo_producto, codigo_empleado, fecha) VALUES (?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setInt(2, c);
            consulta.setInt(3, d);
            consulta.setDate(4, (java.sql.Date) e);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarMaterial(String b, String c, double d, String e, String f) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO material(tipo, nombre, costo, unidad) VALUES (?, ?, ?, ?)");

            consulta.setString(1, b);
            consulta.setString(2, c);
            consulta.setDouble(3, d);
            consulta.setString(4, e);
            consulta.setString(5, f);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarSolicitudMaterial(int b, int c, String d, int e, Date f, String g) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO solicitud_material(codigo_empleado, unidad_solicitante, cantidad, fecha, estado, observacion) VALUES (?, ?, ?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setInt(2, c);
            consulta.setString(3, d);
            consulta.setInt(4, e);
            consulta.setDate(5, (java.sql.Date) f);
            consulta.setString(6, g);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarHorario(int b, Time c, Time d, int e) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO horario(codigo_contrato, hora_inicio, hora_fin, dia) VALUES (?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setTime(2, c);
            consulta.setTime(3, d);
            consulta.setInt(4, e);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarRegistrohorario(int b, Date c, Time d, Time e, String f) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO registro_horario(codigo_empleado, fecha, hora_ingreso, hora_salida, observacion) VALUES (?, ?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setDate(2, (java.sql.Date) c);
            consulta.setTime(3, d);
            consulta.setTime(4, e);
            consulta.setString(5, f);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarPrestamo(int b, int c, int d, Date e, Date f, Date g, String h) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO prestamo(codigo_servicio, codigo_cliente, codigo_empleado, fecha_co, hora_inicio, hora_fin, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setInt(2, c);
            consulta.setInt(3, d);
            consulta.setDate(4, (java.sql.Date) e);
            consulta.setDate(5, (java.sql.Date) f);
            consulta.setDate(6, (java.sql.Date) g);
            consulta.setString(7, h);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void adicionarContrato(int b, Date c, Date d, double e, String f, String g) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("INSERT INTO contrato(codigo_empleado, fecha_inicio, fecha_fin, sueldo, cargo, observacion) VALUES (?, ?, ?, ?, ?, ?)");

            consulta.setInt(1, b);
            consulta.setDate(2, (java.sql.Date) c);
            consulta.setDate(3, (java.sql.Date) d);
            consulta.setDouble(4, e);
            consulta.setString(5, f);
            consulta.setString(6, g);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Object[][] getDatosCliente() {
        int registros = 0;
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM cliente");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_cliente, nombre, paterno, materno FROM cliente ORDER BY codigo_cliente");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_cliente") + "";
                datos[i][1] = resultado.getString("nombre");
                datos[i][2] = resultado.getString("paterno");
                datos[i][3] = resultado.getString("materno");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosEmpleado() {
        int registros = 0;
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM empleado");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros-1][12];
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_empleado, nombre, paterno, materno, sexo, direccion, telefono, correo, fecha_nacimiento, cargo, contrasenia FROM empleado ORDER BY codigo_empleado");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                int cod = resultado.getInt("codigo_empleado");
                if(cod != 0)
                {
                datos[i][0] = cod + "";
                datos[i][1] = resultado.getString("nombre");
                datos[i][2] = resultado.getString("paterno");
                datos[i][3] = resultado.getString("materno");
                datos[i][4] = resultado.getString("sexo").equals("M") ? "masculino" : "femenino";
                datos[i][5] = resultado.getString("direccion");
                datos[i][6] = resultado.getInt("telefono") + "";
                datos[i][7] = resultado.getString("correo");
                datos[i][8] = resultado.getDate("fecha_nacimiento") + "";
                datos[i][9] = resultado.getString("cargo");
                datos[i][10] = resultado.getString("contrasenia");
                i++;}
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosServicio() {
        int registros = 0;
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM servicio");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT tipo, costo_hora, estado, caracteristicas FROM servicio ORDER BY codigo_servicio");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getString("tipo");
                datos[i][1] = resultado.getDouble("costo_hora") + "";
                datos[i][2] = resultado.getString("estado");
                datos[i][3] = resultado.getString("caracteristicas");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosPrestamo() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM prestamo");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][7];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_servicio, codigo_cliente, codigo_empleado, fecha_co, hora_inicio, hora_fin, observaciones FROM prestamo ORDER BY codigo_prestamo");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_servicio") + "";
                datos[i][1] = resultado.getInt("codigo_cliente") + "";
                datos[i][2] = resultado.getInt("codigo_empleado") + "";
                datos[i][3] = resultado.getDate("fecha_co");
                datos[i][4] = resultado.getTime("hora_inicio");
                datos[i][5] = resultado.getTime("hora fin");
                datos[i][6] = resultado.getString("observaciones");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosContrato() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM contrato");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][6];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_empleado, fecha_inicio, fecha_fin, sueldo, cargo, observacion FROM contrato ORDER BY codigo_contrato");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_empleado") + "";
                datos[i][1] = resultado.getDate("fecha_inicio");
                datos[i][2] = resultado.getDate("fecha_fin");
                datos[i][3] = resultado.getDouble("sueldo") + "";
                datos[i][4] = resultado.getString("cargo");
                datos[i][5] = resultado.getString("observacion");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosHorario() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM horario");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_contrato, hora_inicio, hora_fin, dia FROM horario ORDER BY codigo_horario");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_contrato") + "";
                datos[i][1] = resultado.getTime("hora_inicio");
                datos[i][2] = resultado.getTime("hora_fin");
                datos[i][3] = resultado.getInt("dia") + "";
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosRegistroHorario() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM registro_horario");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][5];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_empleado, fecha, hora_ingreso, hora_salida, observacion  FROM horario ORDER BY codigo_registro");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_empleado") + "";
                datos[i][1] = resultado.getDate("fecha");
                datos[i][2] = resultado.getTime("hora_ingreso");
                datos[i][2] = resultado.getTime("hora_salida");
                datos[i][3] = resultado.getString("observacion");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosProducto() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM producto");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_proveedor, existencias, descripcion, precio FROM producto ORDER BY codigo_producto");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_proveedor") + "";
                datos[i][1] = resultado.getInt("existencias") + "";
                datos[i][2] = resultado.getString("descripcion");
                datos[i][3] = resultado.getDouble("precio") + "";
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosProveedor() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM proveedor");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][3];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT nombre, telefono, direccion FROM proveedor ORDER BY codigo_proveedor");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getString("nombre");
                datos[i][1] = resultado.getInt("telefono") + "";
                datos[i][2] = resultado.getString("direccion");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosPedido() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM pedido");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_cliente, codigo_producto, codigo_empleado, fecha FROM pedido ORDER BY codigo_pedido");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_cliente") + "";
                datos[i][1] = resultado.getInt("codigo_producto") + "";
                datos[i][2] = resultado.getInt("codigo_empleado") + "";
                datos[i][3] = resultado.getDate("fecha");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosMaterial() {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM material");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT tipo, nombre, costo, unidad FROM material ORDER BY codigo_material");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getString("tipo");
                datos[i][1] = resultado.getString("nombre");
                datos[i][2] = resultado.getDouble("costo") + "";
                datos[i][3] = resultado.getString("unidad");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public Object[][] getDatosSolicitudMaterial() {
        int registros = 0;
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT count(1) as total FROM solicitud_material");
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            registros = resultado.getInt("total");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        Object[][] datos = new String[registros][6];
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT codigo_empleado, unidad_solicitante, cantidad, fecha, estado, observacion FROM solicitud_material ORDER BY codigo_solicitud");
            ResultSet resultado = consulta.executeQuery();
            int i = 0;
            while (resultado.next()) {
                datos[i][0] = resultado.getInt("codigo_empleado") + "";
                datos[i][1] = resultado.getString("unidad_solicitante");
                datos[i][2] = resultado.getInt("cantidad") + "";
                datos[i][3] = resultado.getDate("fecha");
                datos[i][4] = resultado.getString("estado");
                datos[i][5] = resultado.getString("observacion");
                i++;
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return datos;
    }

    public void eliminarCliente(int c) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("DELETE FROM cliente WHERE codigo_cliente = ?");
            consulta.setInt(1, c);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void eliminarEmpleado(int c) {
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("DELETE FROM empleado WHERE codigo_empleado = ?");
            consulta.setInt(1, c);
            consulta.execute();
            consulta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String getNombreEmpleado(int cod) {
        String nom = "";
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT nombre as N FROM empleado WHERE codigo_empleado = " + cod);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            nom = resultado.getString("N");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nom;
    }

    public String getCargoEmpleado(int cod) {
        String car = "";
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT cargo as CA FROM empleado WHERE codigo_empleado = " + cod);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            car = resultado.getString("CA");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return car;
    }

    public String getContraseniaEmpleado(int cod) {
        String con = "";
        try {
            PreparedStatement consulta = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT contrasenia as C FROM empleado WHERE codigo_empleado = " + cod);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            con = resultado.getString("C");
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
