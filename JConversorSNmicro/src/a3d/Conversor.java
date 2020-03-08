/**
 * @author Daniel Alvarez (a3dany)
 */
package a3d;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Conversor extends MIDlet implements CommandListener {

    private Command exitCommand;
    private Command convertir;
    private Display display;
    private Form screen;
    private TextField numero1, numero2, base1, base2;

    public Conversor() {
        display = Display.getDisplay(this);
        exitCommand = new Command("Salir", Command.EXIT, 2);
        convertir = new Command("Convertir", Command.OK, 0);
        screen = new Form("JConversorSN | Daniel Alvarez");
        numero1 = new TextField("Numero a Convertir", "", 30, TextField.ANY);
        numero2 = new TextField("Numero Convertido", "", 30, TextField.ANY);
        base1 = new TextField("Base Origen", "", 30, TextField.NUMERIC);
        base2 = new TextField("Base Destino", "", 30, TextField.NUMERIC);
        String autor = "SoloInformaticaYAlgoMas.blogspot.com | Daniel Alvarez";
        screen.append(numero1);
        screen.append(base1);
        screen.append(base2);
        screen.append(numero2);
        screen.append(autor);
        screen.addCommand(convertir);
        screen.addCommand(exitCommand);
        screen.setCommandListener(this);
    }

    public void startApp() throws MIDletStateChangeException {
        display.setCurrent(screen);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean incondicional) {
    }

    public void commandAction(Command c, Displayable s) {
        if (c == convertir) {
            int numeroBase10 = Integer.parseInt(numero1.getString(), Integer.parseInt(base1.getString())); // convierte a base 10 cualquier numero en otra base
            String numeroBaseB = Integer.toString(numeroBase10, Integer.parseInt(base2.getString())); 		// convierte numeroBase10 a otra base
            numero2.setString(numeroBaseB.toUpperCase());
            numero1.setString(numero1.getString().toUpperCase());
        }
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
