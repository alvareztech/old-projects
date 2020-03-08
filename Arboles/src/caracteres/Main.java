package caracteres;

/**
 *
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        Arbol A = new Arbol();
        A.leer();
        System.out.println("\n");
        A.recorridoPorNiveles();
        System.out.println("");
        A.recorridoPreOrden();
        System.out.println("");
        A.recorridoInOrden();
        System.out.println("");
        A.recorridoPostOrden();
        System.out.println("");
        A.mostrarAbuelos();
        A.mostrarNietos();
//        A.adicionar(7);
//        A.adicionar(4);
//        A.adicionar(5);
//        A.adicionar(6);
//        A.adicionar(11);
//        A.adicionar(3);
//        A.adicionar(1);
//        A.adicionar(16);
//        A.recorridoPreOrden(A.raiz());
//        System.out.println("");
//        A.recorridoInOrden(A.raiz());
//        System.out.println("");
//        A.recorridoPostOrden(A.raiz());
//        System.out.println("");
//        A.recorridoPorNiveles();
//        System.out.println("");
//        A.recorridoPreOrden();
//        System.out.println("");
//        A.recorridoInOrden();
//        System.out.println("");
//        A.recorridoPostOrden();
//        System.out.println("");
//        A.mostrarHojas();
//        A.buscar(7);
    }
}
