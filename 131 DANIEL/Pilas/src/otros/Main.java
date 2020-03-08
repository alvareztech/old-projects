package otros;

import java.util.Stack;

/**
 *
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        Stack<Integer> P = new Stack<Integer>();
        P.push(5);
        P.push(3);
        P.push(5);
        P.push(6);
        System.out.println(">>>" + P.peek());
        while (!P.isEmpty()) {
            System.out.println(" " + P.pop());
        }
    }
}
