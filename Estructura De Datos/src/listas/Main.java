package listas;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Daniel
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(2);
        lista.add(3);
        lista.add(5);
        lista.add(9);
        lista.add(1);
        ListIterator<Integer> iterador = lista.listIterator();
        while (iterador.hasNext()) {
            Integer e = iterador.next();
            System.out.println(" " + e);
        }
        iterador =  lista.listIterator();
        while (iterador.hasNext()) {
            Integer e = iterador.next();
            System.out.println(" " + e);
        }
    }
}
