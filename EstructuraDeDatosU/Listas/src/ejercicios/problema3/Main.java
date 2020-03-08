package ejercicios.problema3;

/**
 * Solucion Laboratorio 2, Problema 3 (Lic. Jhonny Felipez) [Lab-131][1-11]
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] args) {
        BiCola C = new BiCola();
        C.adicionarDerecha("Ruben");
        C.adicionarDerecha("Katherine");
        C.adicionarDerecha("Julian");
        C.adicionarIzquierda("Raquel");
        C.adicionarIzquierda("Pedro");
        C.desplazar();
        C.eliminarDerecha();
        C.desplazar();
        C.eliminarIzquierda();
        C.desplazar();
    }
}
