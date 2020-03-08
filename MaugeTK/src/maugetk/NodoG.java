package maugetk;


public class NodoG {
	
	arbolnormal C =new arbolnormal();
	arbolnormalD A =new arbolnormalD();
	String nombre;
	NodoG sig;
	
	NodoG()
	{
		sig=null;
	}

    public arbolnormalD getA() {
        return A;
    }

    public void setA(arbolnormalD A) {
        this.A = A;
    }

    public arbolnormal getC() {
        return C;
    }

    public void setC(arbolnormal C) {
        this.C = C;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoG getSig() {
        return sig;
    }

    public void setSig(NodoG sig) {
        this.sig = sig;
    }
	
        

}
