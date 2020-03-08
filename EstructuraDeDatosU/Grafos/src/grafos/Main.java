package grafos;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase Principal
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        Grafo G = new Grafo(11);
        G.adicionarVectice(0, 1);
        G.adicionarVectice(0, 2);
        G.adicionarVectice(0, 3);
        G.adicionarVectice(1, 4);
        G.adicionarVectice(1, 5);
        G.adicionarVectice(3, 6);
        G.adicionarVectice(3, 7);
        G.adicionarVectice(5, 8);
        G.adicionarVectice(5, 9);
        G.adicionarVectice(5, 10);
        //G.busquedaEnAmplitud(0, 10);
        G.busquedaEnProfundidad(0, 7);


//        Grafo G = new Grafo(7);
//        G.adicionarVectice(0, 1);
//        G.adicionarVectice(0, 4);
//        G.adicionarVectice(1, 4);
//        G.adicionarVectice(1, 5);
//        G.adicionarVectice(2, 3);
//        G.adicionarVectice(4, 2);
//        G.adicionarVectice(4, 5);
//        G.adicionarVectice(5, 3);
//        G.adicionarVectice(5, 6);
//        G.mostrarCamino(4, 0);

//        Queue cola = new LinkedList<String>();
//
//        cola.add("A");
//        cola.add("B");
//        cola.add("C");
//        cola.add("D");
//        cola.add("E");
//        // queue.offer("X");
//
//        int n = cola.size();
//        for (int i = 0; i < n; i++) {
//            String e = (String) cola.poll();
//            System.out.print(" " + e);
//            cola.add(e);
//
//        }
//        for (int i = 0; i < n; i++) {
//            String e = (String) cola.poll();
//            System.out.print(" " + e);
//            cola.add(e);
//
//        }
//        for (int i = 0; i < n; i++) {
//            String e = (String) cola.poll();
//            System.out.print(" " + e);
//            cola.add(e);
//
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(">" + cola.poll());
//        }

        //Removing the first item from the queue.
        //If the queue is empty a java.util.NoSuchElementException will be thrown.
        //System.out.println("remove: " + queue.remove());

        //Checking what item is first in line without removing it
        //If the queue is empty a java.util.NoSuchElementException will be thrown.
        //System.out.println("element: " + queue.element());

        //Removing the first item from the queue.
        //If the queue is empty the method just returns false.
        //System.out.println("poll: " + queue.poll());

        //Checking what item is first in line without removing it
        //If the queue is empty a null value will be returned.
        //System.out.println("peek: " + queue.peek());
    }
}
