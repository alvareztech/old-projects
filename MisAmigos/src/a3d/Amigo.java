package a3d;

/**
 * Clase Amigo
 * @author Daniel Alvarez (a3dany)
 */
public class Amigo {

    private String nombre;
    private String sexo;
    private boolean gustoFutbol;
    private boolean gustoBasketball;
    private boolean gustoVoleibol;

    public Amigo() {
        this.nombre = "";
        this.sexo = "";
        this.gustoFutbol = false;
        this.gustoBasketball = false;
        this.gustoVoleibol = false;
    }

    public Amigo(String nombre, String sexo, boolean gustoFutbol, boolean gustoBasketball, boolean gustoVoleibol) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.gustoFutbol = gustoFutbol;
        this.gustoBasketball = gustoBasketball;
        this.gustoVoleibol = gustoVoleibol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean getGustoFutbol() {
        return gustoFutbol;
    }

    public void setGustoFutbol(boolean gustoFutbol) {
        this.gustoFutbol = gustoFutbol;
    }

    public boolean getGustoBasketball() {
        return gustoBasketball;
    }

    public void setGustoBasketball(boolean gustoBasketball) {
        this.gustoBasketball = gustoBasketball;
    }

    public boolean getGustoVoleibol() {
        return gustoVoleibol;
    }

    public void setGustoVoleibol(boolean gustoVoleibol) {
        this.gustoVoleibol = gustoVoleibol;
    }

    public String getInformacion() {
        return " [" + nombre.toUpperCase() + "] " + (sexo.equals("Masculino") ? "a él " : "a ella") + " le gusta: " + (gustoFutbol ? "futbol" : "") + " " + (gustoBasketball ? "basketball" : "") + " " + (gustoVoleibol ? "voleibol" : "");
    }
}