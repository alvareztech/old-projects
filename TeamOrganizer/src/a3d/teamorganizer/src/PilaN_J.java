package a3d.teamorganizer.src;

class PilaN_J {

    private int MAX = 100;
    private int tope;
    private Nodo_J pila[] = new Nodo_J[MAX];

    public PilaN_J() {
        tope = 0;
    }

    public boolean esVacia() {
        if (tope == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionar(Nodo_J e) {
        if (tope == MAX) {
            System.out.println("� Pila Llena !");
        } else {
            tope++;
            pila[tope] = e;
        }
    }

    public Nodo_J eliminar() {
        Nodo_J e = null;
        if (tope == 0) {
            System.out.println("� Pila Vacia !");
        } else {
            e = pila[tope];
            tope--;
        }
        return e;
    }

    public int nroElems() {
        return tope;
    }

    public void vaciar(PilaN_J A) {
        while (!A.esVacia()) {
            adicionar(A.eliminar());
        }
    }
}
