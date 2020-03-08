package ejemplo;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Cliente
 * @author Daniel Alvarez (a3dany)
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Socket canalComunicacion = null;
            OutputStream bufferSalida;
            DataOutputStream datos;
            canalComunicacion = new Socket("localhost", 10831);
            bufferSalida = canalComunicacion.getOutputStream();
            datos = new DataOutputStream(bufferSalida);
            String mensaje = "Hola Mundo!\n";
            for (int i = 0; i < 10; i++) {
                datos.writeUTF(mensaje);
            }
            datos.writeUTF("");
            datos.close();
            bufferSalida.close();
            canalComunicacion.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
