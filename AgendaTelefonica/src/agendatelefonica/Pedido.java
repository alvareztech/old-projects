
import java.util.Date;

public class Pedido {
    private int codigoPedido;
    private int codigoCliente;
    private int codigoProducto;
    private int codigoEmpleado;
    private Date fecha;
    
    public Pedido(int a, int b, int c, int d, Date e)
    {
        codigoPedido = a;
        codigoCliente = b;
        codigoProducto = c;
        codigoEmpleado = d;
        fecha = e;
    }
}

/// REAL --->> double
///  VARCHAR >>> String
