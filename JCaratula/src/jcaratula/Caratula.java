package jcaratula;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public class Caratula {

    private String titulo;
    private String subTitulo;
    private String tipo;
    private String encabezado1;
    private String encabezado2;
    private String encabezado3;
    private String estudiante;
    private String docente;
    private String materia;
    private String siglaMateria;
    private String lugar;
    private String fecha;

    public Caratula(String t, String st) {
        titulo = t;
        subTitulo = st;
        lugar = "La Paz - Bolivia";
    }

    public void generarPdf() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        FileOutputStream archivo = new FileOutputStream("caratula.pdf");
        Document documento = new Document(PageSize.LETTER, 70, 70, 50, 50);
        PdfWriter.getInstance(documento, archivo);
        documento.open();

        Image logo = Image.getInstance("src\\jcaratula\\Escudo UMSA.png");
        logo.setAlignment(Element.ALIGN_CENTER);
        logo.scalePercent(20);

        Paragraph encabezado1Pdf = new Paragraph("Universidad Mayor de San Andrés", new Font(FontFamily.HELVETICA, 12, Font.BOLD));
        encabezado1Pdf.setAlignment(Element.ALIGN_CENTER);

        Paragraph encabezado2Pdf = new Paragraph("Facultad de Ciencias Puras y Naturales", new Font(FontFamily.HELVETICA, 10, Font.NORMAL));
        encabezado2Pdf.setAlignment(Element.ALIGN_CENTER);
        
        Paragraph encabezado3Pdf = new Paragraph("Carrera de Informática", new Font(FontFamily.HELVETICA, 10, Font.NORMAL));
        encabezado3Pdf.setAlignment(Element.ALIGN_CENTER);

        Paragraph espaciado = new Paragraph("\n\n\n\n\n", new Font(FontFamily.HELVETICA, 10, Font.NORMAL));

        Paragraph tituloPdf = new Paragraph(titulo, new Font(FontFamily.HELVETICA, 16, Font.BOLD));
        tituloPdf.setAlignment(Element.ALIGN_CENTER);

        Paragraph subTituloPdf = new Paragraph(subTitulo, new Font(FontFamily.HELVETICA, 16, Font.NORMAL));
        subTituloPdf.setAlignment(Element.ALIGN_CENTER);

        Paragraph nombrePdf = new Paragraph("Estudiante:", new Font(FontFamily.HELVETICA, 16, Font.NORMAL));
        subTituloPdf.setAlignment(Element.ALIGN_CENTER);

        Paragraph fechaPdf = new Paragraph(new Date().toString(), new Font(FontFamily.HELVETICA, 16, Font.NORMAL));
        fechaPdf.setAlignment(Element.ALIGN_RIGHT);

        Paragraph lugarPdf = new Paragraph(lugar, new Font(FontFamily.HELVETICA, 16, Font.NORMAL));
        lugarPdf.setAlignment(Element.ALIGN_RIGHT);

        documento.add(logo);
        documento.add(encabezado1Pdf);
        documento.add(encabezado2Pdf);
        documento.add(encabezado3Pdf);
        documento.add(espaciado);
        documento.add(tituloPdf);
        documento.add(subTituloPdf);
        documento.add(espaciado);
        documento.add(fechaPdf);
        documento.add(lugarPdf);
        documento.close();
    }
}
