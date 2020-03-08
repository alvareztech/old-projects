package maugetk;

class nodoD {

    nodoD izq;
    Documento D;
    nodoD der;

    nodoD() {
        D = new Documento();
        izq = der = null;
    }
}
