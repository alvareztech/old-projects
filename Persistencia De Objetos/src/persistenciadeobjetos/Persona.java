package persistenciadeobjetos;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class Persona implements Serializable {

    private String nombre;
    private int ci;

    public Persona() {
        nombre = "";
        ci = 0;
    }

    public Persona(String nombre, int ci) {
        this.nombre = nombre;
        this.ci = ci;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
