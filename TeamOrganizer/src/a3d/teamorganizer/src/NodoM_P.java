package a3d.teamorganizer.src;

class NodoM_P {

    int dia;
    int mes;
    int anio;
    String tipo;
    String lugar;
    String rival;
    int golesE;
    int golesR;
    Nodo_E eventos;
    NodoM_P sig;

    public NodoM_P() {
        sig = null;
        eventos = new Nodo_E();
    }
}
