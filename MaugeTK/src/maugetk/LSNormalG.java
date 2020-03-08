package maugetk;

public class LSNormalG extends ListaSimpleG {

    LSNormalG() {
        super();
    }

    int nronodos() {
        int c = 0;
        NodoG r = p;
        while (r != null) {
            c = c + 1;
            r = r.sig;
        }
        return c;

    }

    boolean esvacia() {
        if (p == null) {
            return true;
        }
        return false;
    }

    void adiprimero(String a, arbolnormal oe, arbolnormalD e) {
        NodoG w = new NodoG();
        w.nombre = a;
        w.C = oe;
        w.A = e;
        w.sig = p;
        p = w;
    }

    void adiultimo(String a, arbolnormal oe, arbolnormalD e) {
        NodoG w = new NodoG();
        NodoG r;
        w.nombre = a;
        w.C = oe;
        w.A = e;
        if (esvacia()) {
            p = w;
        } else {
            r = p;
            while (r.sig != null) {
                r = r.sig;
            }
            r.sig = w;
        }
    }

    void leer1(int n) {
        String nombre;
        for (int i = 1; i <= n; i++) {
            System.out.println("SECCION: ");
            nombre = Leer.dato();
            arbolnormal a = new arbolnormal();
            arbolnormalD b = new arbolnormalD();
            a.crear();
            b.crear();
            adiprimero(nombre, a, b);
        }
    }

    void leer2(int n) {
        String nombre;
        for (int i = 1; i <= n; i++) {

            System.out.println("SECCION: ");
            nombre = Leer.dato();
            arbolnormal a = new arbolnormal();
            arbolnormalD b = new arbolnormalD();
            //System.out.println ("nro de tutores");
            //int m=Leer.datoInt();
            a.crear();
            b.crear();
            adiultimo(nombre, a, b);

        }


    }

    void mostrar() {
        NodoG r;
        r = p;
        while (r != null) {
            //System.out.println (" " + r.periodo+"/"+r.a�o);
            System.out.println("SECCION: " + r.nombre);
            //System.out.println ();
            System.out.println("LIBROS");
            r.C.mostrar();
            System.out.println("DOCUMENTOS");
            r.A.mostrar();
            System.out.println();
            r = r.sig;
        }
    }

    NodoG eliprimero() {
        NodoG x;
        x = p;
        p = p.sig;
        x.sig = null;
        return x;
    }

    NodoG eliultimo() {
        NodoG x, r;
        x = r = p;
        if (r.sig == null) {
            p = null;
        } else {
            while (r.sig != null) {
                x = r;
                r = r.sig;
            }
        }
        x.sig = null;
        x = r;
        return (x);
    }

    void llevafinal() {
        NodoG x, r;
        r = p.sig;
        x = p;
        p = r;
        while (r.sig != null) {
            r = r.sig;
        }
        r.sig = x;
        x.sig = null;
    }

    void Recorre(String x, String y, String z) {
        NodoG q = p;

        while (q != null) {
            if (q.nombre.equals(x)) {
                if (q.C.verifica(y, z)) {
                    System.out.println("Si esta el libro");
                    System.out.println("Nro de descargas= " + q.C.busca(y, z));
                } else {
                    System.out.println("No esta el libro");
                }

            }
            q = q.sig;
        }

    }

    void MuestraDoc(String x) {
        NodoG q = p;
        int c = 0;
        while (q != null) {
            if (q.nombre.equals(x)) {
                c = c + q.A.cuentaD();

            }
            q = q.sig;
        }
        System.out.println("\n" + "Total de descargas en pdf de la seccion " + x + "= " + c);

    }

    void Adiciona(Libro e, String x) {
        NodoG q = p;

        while (q != null) {
            if (q.nombre.equals(x)) {
                q.C.Agrega(e);
            }
            q = q.sig;
        }

    }

    void Adiciona(Documento e, String x) {
        NodoG q = p;

        while (q != null) {
            if (q.nombre.equals(x)) {
               // q.A.Agrega(e);
            }
            q = q.sig;
        }

    }

    void buscaSeccionL(String x) {
        NodoG q = p;
        while (q != null) {
            if (q.nombre.equals(x)) {
                q.C.mostrar();
            }

            q = q.sig;

        }
    }

    void EliminaLD() {
        NodoG q = p;
        while (q != null) {
            q.C.EliminaL();
            q.A.EliminaD();
            q = q.sig;

        }
    }

    void MostrarIguales() {
        NodoG q = p;
        while (q != null) {
            System.out.println("\n" + q.nombre);
            q.C.buscaLD(q.A);
            q = q.sig;

        }
    }

    void verifica(String x, String y) {

        NodoG q = p;
        int c = 0;
        while (q != null) {
            c = c + q.A.buscaDoc(x, y);
            q = q.sig;

        }
        System.out.println("El documento con titulo " + x + " se descargo el dia " + y + ":  " + c + " veces");
    }

    void verificaLibro(String x) {

        NodoG q = p;

        while (q != null) {
            q.C.buscaLibrodesc(x);
            q = q.sig;

        }

    }
}
