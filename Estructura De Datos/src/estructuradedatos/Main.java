package estructuradedatos;

import java.util.Stack;

/**
 *
 * @author Daniel
 */
public class Main {

    public static void main(String[] a3d) {
        Stack<Integer> pila = new Stack();
        pila.push(new Integer(7));
        pila.push(new Integer(4));
        pila.push(new Integer(3));
        pila.push(new Integer(1));
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
        System.out.println("pila = " + pila);

    }
}
