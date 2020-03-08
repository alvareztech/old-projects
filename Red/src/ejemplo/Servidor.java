package ejemplo;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Servidor
 * @author Daniel Alvarez (a3dany)
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(10831);
            Socket cliente = servidor.accept();
            InputStream bufferEntrada;
            DataInputStream datos;

            bufferEntrada = cliente.getInputStream();
            datos = new DataInputStream(bufferEntrada);
            String cadena = new String(datos.readUTF());
            while (cadena.length() > 0) {
                System.out.print(cadena);
                cadena = datos.readUTF();
            }
            datos.close();
            bufferEntrada.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
