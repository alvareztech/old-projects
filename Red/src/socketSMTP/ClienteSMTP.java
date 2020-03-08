package socketSMTP;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @author grover
 */
public class ClienteSMTP {

    private Socket cliente;
    private Scanner input, teclado;
    private PrintStream output;
    private String remitente;
    private String destinatario;
    private String asunto;
    private String contenido;
    private int nroCaracteres;

    /**
     * @param direccion
     *            IP del servidor SMTP
     * @param puerto
     *            Puerto de escucha del servidor SMTP. Por lo general es el
     *            puerto 25
     */
    public ClienteSMTP(String direccion, int puerto) {
        try {
            this.cliente = new Socket(direccion, puerto);
            input = new Scanner(this.cliente.getInputStream());
            output = new PrintStream(this.cliente.getOutputStream());

            teclado = new Scanner(System.in);

            nroCaracteres = 78;
            contenido = "";

            System.out.println(input.nextLine());

        } catch (Exception e) {
        }
    }

    /**
     * Lee el correo electrónico de quién va a enviar el mensaje.
     */
    public void leerRemitente() {
        do {
            System.out.print("De: ");
            remitente = teclado.nextLine();
        } while (!esCorreoValido(remitente));
    }

    /**
     * Lee el correo electrónico de quién va a recibir el mensaje.
     */
    public void leerDestinatario() {
        do {
            System.out.print("Para: ");
            destinatario = teclado.nextLine();
        } while (!esCorreoValido(destinatario));
    }

    /**
     * Lee el asunto del mensaje, en caso de que no coloque nada, el asunto por
     * defecto es "Sin Asunto"
     */
    public void leerAsunto() {
        System.out.print("Asunto: ");
        asunto = teclado.nextLine();
        if (asunto.equals("")) {
            asunto = "Sin Asunto";
        }
    }

    /**
     * Lee el Cuerpo del mensaje y lo formatea en "nroCaracteres" por linea
     */
    public void leerContenido() {
        String linea = "";
        int finLinea;
        System.out.println("Mensaje (termina con ENTER.ENTER):");
        while (!contenido.endsWith("\n.\n")) {
            linea = teclado.nextLine();
            while (linea.length() > nroCaracteres) {
                finLinea = linea.substring(0, nroCaracteres - 1).lastIndexOf(
                        " ");
                contenido += linea.substring(0, finLinea) + "\n";
                linea = linea.substring(finLinea);
            }
            contenido += linea + "\n";
        }
    }

    /**
     * Forma y envia un correo electrónico con los atributos "remitente",
     * "destinatario", "asunto" y "contenido".
     */
    public void enviarCorreo() {

        output.println("MAIL FROM:" + remitente);
        System.out.println(input.nextLine());

        output.println("RCPT TO:" + destinatario);
        System.out.println(input.nextLine());

        output.println("DATA");
        System.out.println(input.nextLine());

        output.println("From:" + remitente);
        output.println("To:" + destinatario);
        output.println("Subject:" + asunto);
        output.println("MIME-Version: 1.0");
        output.println("Content-type: text/plain");
        output.println("Content-Transfer-Encoding: 7bit");

        output.print(contenido);
        System.out.println(input.nextLine());
    }

    /**
     * Verifica si el correo electrónico se encuentra registrado en el servidor.
     *
     * @param correo
     *            Email a verificar
     */
    public boolean esCorreoValido(String correo) {
        output.println("VRFY " + correo);
        if (input.nextLine().startsWith("252")) {
            return true;
        }
        System.out.println("Correo no valido " + correo);
        return false;
    }

    /**
     * Cierra los flujos de entrada y salida además de terminar la conexión con
     * el servidor
     */
    public void cerrarSesion() {
        try {
            output.println("QUIT");
            System.out.println(input.nextLine());

            input.close();
            output.close();
            cliente.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

        ClienteSMTP cls = new ClienteSMTP("127.0.0.1", 25);

        cls.leerRemitente();
        cls.leerDestinatario();
        cls.leerAsunto();
        cls.leerContenido();
        cls.enviarCorreo();
        cls.cerrarSesion();
    }
}
