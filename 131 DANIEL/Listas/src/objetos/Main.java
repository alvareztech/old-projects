package objetos;

/**
 * Listas De Personas
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        ListaDoble L = new ListaDoble();
        L.adicionarUltimo(new Persona("Anabel", 44));
        L.adicionarUltimo(new Persona("Lucas", 32));
        L.adicionarUltimo(new Persona("Katherine", 25));
        L.adicionarUltimo(new Persona("Lorenzo", 33));
        L.adicionarUltimo(new Persona("Pablo", 12));
        //L.adicionar(new Persona("Daniel", 22), 1);
        //Persona P = L.eliminar(7);
        L.mostrar();
        System.out.println("************");
        //P.mostrar();
        L.ordenar();
        L.mostrar();
        
    }
}
