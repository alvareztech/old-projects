package multiplesestructuras;

/**
 * Clase MultiplesColas
 * @author Daniel Alvarez (a3dany)
 */
public class MultiplesColas {

    private ColaCircular[] colas;
    private int nroColas;

    public MultiplesColas() {
        this.nroColas = 0;
    }

    public MultiplesColas(int nroColas) {
        this.nroColas = nroColas;
        colas = new ColaCircular[nroColas + 1];
        for (int i = 1; i <= nroColas; i++) {
            colas[i] = new ColaCircular();
        }
    }

    public void leer() {
        for (int i = 1; i <= nroColas; i++) {
            colas[i].leer();
        }
    }

    public void mostrar() {
        for (int i = 1; i <= nroColas; i++) {
            colas[i].mostrar();
        }
    }

    public void intercalar(MultiplesPilas B) {
        recorrer(2);
    }

    public void recorrer(int p) {
        for (int i = p; i < nroColas; i++) {


        }
    }

}