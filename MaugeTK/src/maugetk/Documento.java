package maugetk;

//import java.io.*;
public class Documento {

    private String titulo;
    private String autor;
    private String tipo;
    private int cantdescpdf;
    private int cantdescword;
    private int cantconsultas;
    private String fechadesc;
    private String Codigodesc;

    public Documento() {
        titulo = "";
        autor = "";
        tipo = "";
        cantdescpdf = 0;
        cantdescword = 0;
        cantconsultas = 0;
        fechadesc = "";
        Codigodesc = "";
    }

    public void leer() {

        System.out.print(" titulo del documento ");
        titulo = Leer.dato();
        System.out.print(" autor del documento ");
        autor = Leer.dato();
        System.out.print(" tipo de descarga ");
        tipo = Leer.dato();
        System.out.print(" cantidad de descargas en pdf ");
        cantdescpdf = Leer.datoInt();
        System.out.print(" cantidad de descargas en word ");
        cantdescword = Leer.datoInt();
        System.out.print(" cantidad de consultas  ");
        cantconsultas = Leer.datoInt();
        System.out.print(" dia de descargas  ");
        fechadesc = Leer.dato();
        System.out.print(" Codigo de descarga  ");
        Codigodesc = Leer.dato();

    }

    public void mostrar() {

        System.out.print(" " + titulo + " ");
        System.out.print(" " + autor + " ");
        System.out.print(" " + tipo + " ");
        System.out.print(" " + cantdescpdf + " ");
        System.out.print(" " + cantdescword + " ");
        System.out.print(" " + cantconsultas + " ");
        System.out.print(" " + fechadesc + " ");
        System.out.print(" " + Codigodesc + " ");
    }

    public String gettit() {
        return titulo;
    }

    public String getAut() {
        return autor;
    }

    public String gettipo() {
        return tipo;
    }

    public int getcantdescpdf() {
        return cantdescpdf;
    }

    public int getcantdescword() {
        return cantdescword;
    }

    public int getcantconsult() {
        return cantconsultas;
    }

    public String getdia() {
        return fechadesc;
    }

    public String getcod() {
        return Codigodesc;
    }

    public void setCodigodesc(String Codigodesc) {
        this.Codigodesc = Codigodesc;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantconsultas(int cantconsultas) {
        this.cantconsultas = cantconsultas;
    }

    public void setCantdescpdf(int cantdescpdf) {
        this.cantdescpdf = cantdescpdf;
    }

    public void setCantdescword(int cantdescword) {
        this.cantdescword = cantdescword;
    }

    public void setFechadesc(String fechadesc) {
        this.fechadesc = fechadesc;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
