package componentes;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Clase EjemploJList
 * @author Daniel Alvarez (a3dany)
 */
public class EjemploJList extends JFrame {

    public EjemploJList() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        String[] datos = new String[]{"holaxxxxxxxxxxxxxxxxxxxxxx", "como", "estan"};
        JList lista = new JList(datos);
        lista.setBounds(10, 10, 50, 50);
        JScrollPane X = new JScrollPane(lista);
        X.setBounds(10, 10, 50, 50);
        getContentPane().add(X);
    }

    public static void main(String[] args) {
        EjemploJList V = new EjemploJList();
        V.setVisible(true);
    }
}
