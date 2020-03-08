package a3d.teamorganizer.src;

class Equipo {

    String nombre;
    String DT;
    int escudo;
    Arbol_J Jugadores;
    ListaMultiple_P Partidos;

    public Equipo() {
        nombre = "";
        DT = "";
        Jugadores = new Arbol_J();
        Partidos = new ListaMultiple_P();
    }

    public void llenar1(String nom, String dt, int esc) {
        nombre = nom;
        DT = dt;
        escudo = esc;
    }

    public String obtNombre() {
        return nombre;
    }

    public String obtDT() {
        return DT;
    }

    public int obtE() {
        return escudo;
    }


    /*
    public void leer ()
    {
    System.out.print (" Nombre Equipo:    ");
    nombre = Leer.datoString ();
    System.out.print (" Director Tecnico: ");
    DT = Leer.datoString ();
    Jugadores.cargar ("Daniel", 15, "medio", 90, 123, 321);
    System.out.print (" Nro.de Partidos: ");
    Partidos.leer (Leer.datoInt ());
    }
     */
    public void mostrar() {
        System.out.println(" Nombre Equipo: " + nombre);
        System.out.println(" Director Tecnico: " + DT);
        System.out.println(" Escudo: " + escudo);
        Jugadores.mostrar();
        Partidos.mostrar();
    }
}
