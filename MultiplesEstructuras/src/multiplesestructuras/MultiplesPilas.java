package multiplesestructuras;

/**
 * Clase MultiplesPilas
 * @author Daniel Alvarez (a3dany)
 */
public class MultiplesPilas {

    private Pila[] pilas;
    private int nroPilas;

    public MultiplesPilas() {
        this.nroPilas = 0;
    }

    public MultiplesPilas(int nroPilas) {
        this.nroPilas = nroPilas;
        pilas = new Pila[nroPilas + 1];
        for (int i = 1; i <= nroPilas; i++) {
            pilas[i] = new Pila();
        }
    }

    public void leer() {
        for (int i = 1; i <= nroPilas; i++) {
            pilas[i].leer();
        }
    }

    public void mostrar() {
        for (int i = 1; i <= nroPilas; i++) {
            pilas[i].mostrar();
        }
    }

    public void intercalar(MultiplesPilas B) {
        recorrer(2);
    }

    public void recorrer(int p) {
        for (int i = p; i < nroPilas; i++) {


        }
    }
}
