package persistenciadeobjetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Daniel Alvarez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("C:\\aaa.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Persona P = new Persona("Raquel Arias", 6120049);

        oos.writeObject(P);
        oos.close();

        FileInputStream fis = new FileInputStream("C:\\aaa.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        

        Object O = ois.readObject();
        if (O instanceof Persona) {
            Persona aux = (Persona) O;
            System.out.println("aux = " + aux.getNombre() + aux.getCi());
        }

        O = ois.readObject();
        if (O instanceof Persona) {
            Persona aux = (Persona) O;
            System.out.println("aux = " + aux.getNombre() + aux.getCi());
        }
        
        ois.close();
    }
}
