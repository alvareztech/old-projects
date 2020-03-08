package ejercicios.problema2;

/**
 * Solucion Laboratorio 2, Problema 2 (Lic. Jhonny Felipez) [Lab-131][1-11]
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3da) {
        ListaCircular L = new ListaCircular();
        L.insertar("Ruben");
        L.insertar("Katherine");
        L.insertar("Juan");
        L.insertar("Karen");
        L.insertar("Pedro");
        L.desplegar();

        int posicion = L.buscar("Karen");
        System.out.println("Juan esta en la posicion: " + posicion);

        L.avanzar();
        L.desplegar();

        String dato = L.eliminar();
        System.out.println("Se elimino el nodo: " + dato);
        L.desplegar();
    }
}
