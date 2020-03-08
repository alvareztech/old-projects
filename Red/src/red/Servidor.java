package red;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor
 * @author Daniel Alvarez (a3dany)
 */
public class Servidor {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(9999);
        Socket conexion = servidor.accept();
        ObjectInputStream entrada = new ObjectInputStream(conexion.getInputStream());
        //ObjectOutputStream salida = new ObjectOutputStream(conexion.getOutputStream());
        System.out.println("> " + entrada.readObject());
        entrada.close();
       // salida.close();
        conexion.close();
        servidor.close();
    }
}
