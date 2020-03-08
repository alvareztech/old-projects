package red;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Clase Cliente
 * @author Daniel Alvarez (a3dany)
 */
public class Cliente {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Socket conexion = new Socket("localhost", 9999);
        //ObjectInputStream entrada = new ObjectInputStream(conexion.getInputStream());
        ObjectOutputStream salida = new ObjectOutputStream(conexion.getOutputStream());
        salida.writeObject("hOLAS SERVER");
        //entrada.close();
        salida.close();
        conexion.close();
    }
}
