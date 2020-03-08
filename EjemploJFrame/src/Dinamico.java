
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Dinamico extends JFrame {

    static int Ancho = 1200;
    static int Alto = 700;
    static int miTipo = 0;
    static int TMov = 0;
    static CursoMovil[] cMovil = new CursoMovil[100];

    public Dinamico() {
        super("Simuldorcito");
        JMenu menuArchivo = new JMenu("Accion");
        menuArchivo.setMnemonic('A');
        JMenuItem elementoAcerca = new JMenuItem("Ver");
        elementoAcerca.setMnemonic('c');
        menuArchivo.add(elementoAcerca);
        elementoAcerca.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        Pista pan = new Pista(100, 100);
                        pan.prepara();
                    }
                });
        JMenuItem elementoNuevo = new JMenuItem("Nuevo");
        elementoNuevo.setMnemonic('N');
        menuArchivo.add(elementoNuevo);
        elementoNuevo.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        limpiar();
                        repaint();
                    }
                });
        JMenuItem elementoSalir = new JMenuItem("Salir");
        elementoSalir.setMnemonic('S');
        menuArchivo.add(elementoSalir);
        elementoSalir.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        System.exit(0);
                    }
                });
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuArchivo);
        JMenu menuEscenario = new JMenu("Escenario");
        menuEscenario.setMnemonic('E');
        JMenuItem elementoLibre = new JMenuItem("Libre");
        elementoLibre.setMnemonic('L');
        menuEscenario.add(elementoLibre);
        elementoLibre.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        for (int i = 0; i < TMov; i++) {
                            remove(cMovil[i]);
                        }
                        if (TMov == 0) {
                            TMov++;
                        }
                        cMovil[0] = new CursoMovil(255, 255, 255, "Carretera");   // 1 = vagoneta 
                        add(cMovil[0]);
                        cMovil[0].setBounds(0,
                                0, Ancho, Alto);
                    }
                });
        JMenuItem elementoRotonda = new JMenuItem("Rotonda");
        elementoRotonda.setMnemonic('R');
        menuEscenario.add(elementoRotonda);
        elementoRotonda.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        //System.exit( 0 ); 
                    }
                });
        JMenuItem elementoInter = new JMenuItem("Interseccion");
        elementoInter.setMnemonic('I');
        menuEscenario.add(elementoInter);
        elementoInter.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });
        barra.add(menuEscenario);
        JMenu menuTipoVehi = new JMenu("Vehiculo");
        menuEscenario.setMnemonic('V');
        JMenuItem elementoTaxi = new JMenuItem("Radio Taxi ");
        elementoTaxi.setMnemonic('T');
        menuTipoVehi.add(elementoTaxi);
        elementoTaxi.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        invocaTipoVehi("Radio Taxi");
                    }
                });
        JMenuItem elementoMiniBus = new JMenuItem("Mini Bus");
        elementoMiniBus.setMnemonic('M');
        menuTipoVehi.add(elementoMiniBus);
        elementoMiniBus.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        invocaTipoVehi("Mini Bus");
                    }
                });
        JMenuItem elementoVagoneta = new JMenuItem("Vagoneta");
        elementoVagoneta.setMnemonic('V');
        menuTipoVehi.add(elementoVagoneta);
        elementoVagoneta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        invocaTipoVehi("Vagoneta");
                    }
                });
        barra.add(menuTipoVehi);
        getContentPane().setBackground(new Color(0, 100, 0));
        setSize(Ancho, Alto);
        setVisible(true);
    }

    void invocaTipoVehi(String tipo) {
        for (int i = 0; i < TMov; i++) {
            remove(cMovil[i]);
        }
        int rojo = (int) (Math.random() * 206);
        int verde = (int) (Math.random() * 206);
        int azul = (int) (Math.random() * 256);
        cMovil[TMov] = new CursoMovil(rojo, verde, azul, tipo);   // 1 = vagoneta 
        add(cMovil[TMov]);
        cMovil[TMov].setBounds(0, 0, Ancho, Alto);
        TMov++;
    }

    void limpiar() {
        int i = 0;
        while (i < Dinamico.TMov) {
            Dinamico.cMovil[i].vxCV[0] = 0;
            Dinamico.cMovil[i].vyCV[0] = 0;
            remove(Dinamico.cMovil[i]);//=null; 
            i++;
        }
        Dinamico.TMov = 0;
    }

    public static void main(String args[]) {
        Dinamico aplicacion = new Dinamico();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Genera un JFrame que muestra la simulacion 
class Pista extends JComponent {

    int itab = 0;
    int k = 100;
    int px;
    int py;
    Thread creador;
    private RutaAmpliada rutina;
    static Movilidad[] tipoMovil = new Movilidad[100];
    double ang = 0;

    public Pista(int px1, int py1) {
        if (Dinamico.TMov > 0) {
            px = px1;
            py = py1;
            JFrame ventana = new JFrame("Escenario");
            setBounds(0, 0, Dinamico.Ancho, Dinamico.Alto);
            setLayout(null);
            ventana.setBounds(0, 0,
                    Dinamico.Ancho, Dinamico.Alto);
            ventana.setLayout(null);
            ventana.getContentPane().add(this);
            ventana.show();
            for (int i = 0; i < Dinamico.TMov - 1; i++) {
                tipoMovil[i] = new Movilidad(Dinamico.cMovil[i + 1]);
                add(tipoMovil[i]);
                tipoMovil[i].setBounds(0, 0,
                        Dinamico.Ancho, Dinamico.Alto);
            }
            rutina = new RutaAmpliada();
            add(rutina);
            rutina.setBounds(0, 0,
                    Dinamico.Ancho, Dinamico.Alto);
        }
    }

    void prepara() {
        if (Dinamico.TMov > 0) {
            for (int i = 0; i < Dinamico.TMov - 1; i++) {
                creador = new Thread(tipoMovil[i]);
            }
            creador.start();
        }
    }
}

// permite dibujar el curso o ruta que toma un vehiculo 
class CursoMovil extends JComponent implements MouseMotionListener {

    public int rojo;
    public int verde;
    public int azul;
    public int[] vxCV = new int[2000];
    public int[] vyCV = new int[2000];
    public String tipoMovil;
    private int ipu = 0;
    public boolean isColi = false;
    public int[] vxColi = new int[500];
    public int[] vyColi = new int[500];

    public CursoMovil(int r, int v, int a, String tipo) {
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        rojo = r;
        verde = v;
        azul = a;
        tipoMovil = tipo;
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        // repintamos todas las rutas 
        int i = 0;
        while (i < Dinamico.TMov) {
            int p = 0;
            while (p < Dinamico.cMovil[i].ipu) {
                g.setColor(new Color(Dinamico.cMovil[i].rojo, Dinamico.cMovil[i].verde, Dinamico.cMovil[i].azul));
                g.drawString(Dinamico.cMovil[i].tipoMovil, Dinamico.cMovil[i].vxCV[0],
                        Dinamico.cMovil[i].vyCV[0]);
                g.fillOval(Dinamico.cMovil[i].vxCV[p],
                        Dinamico.cMovil[i].vyCV[p], 4, 4);
                p++;
            }
            i++;
        }
    }

    public void mouseDragged(MouseEvent m) {
        vxCV[ipu] = m.getX();
        vyCV[ipu] = m.getY();
        ipu++;
        this.repaint();
    }

    public void mouseMoved(MouseEvent m) {
        //System.out.println(m.getX()+"\t"+m.getY() ); 
    }
}

// Genera la ruta ampliada 
class RutaAmpliada extends JComponent {

    static int ipu = 0;

    RutaAmpliada() {
        //ipu=0; 
        setBounds(0, 0, Dinamico.Ancho, Dinamico.Alto);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g1) {
        Graphics2D gDib = (Graphics2D) g1;
        GeneralPath dib = new GeneralPath();
        dib.moveTo(Dinamico.cMovil[0].vxCV[0], Dinamico.cMovil[0].vyCV[0]);
        /* 
        int k=0; 
        while(Dinamico.cMovil[0].vxCV[k+1]>0){ 
        if((Dinamico.cMovil[0].vyCV[k]<Dinamico.cMovil[0].vyCV[k+1]) && 
        (Dinamico.cMovil[0].vxCV[k]>Dinamico.cMovil[0].vxCV[k+1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]-75,Dinamico.cMovil[0].vyCV[k]-75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]<Dinamico.cMovil[0].vyCV[k+1]) && 
        (Dinamico.cMovil[0].vxCV[k]<Dinamico.cMovil[0].vxCV[k+1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]-75,Dinamico.cMovil[0].vyCV[k] 
        +75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]>=Dinamico.cMovil[0].vyCV[k+1]) && 
        (Dinamico.cMovil[0].vxCV[k]<Dinamico.cMovil[0].vxCV[k+1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]+75,Dinamico.cMovil[0].vyCV[k] 
        +75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]<Dinamico.cMovil[0].vyCV[k+1]) && 
        (Dinamico.cMovil[0].vxCV[k]>Dinamico.cMovil[0].vxCV[k+1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]-75,Dinamico.cMovil[0].vyCV[k]-75 ); 
        } 
        else{ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]-75,Dinamico.cMovil[0].vyCV[k] 
        +75 ); 
        } 
        } 
        } 
        } 
        k++; 
        } 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k-1],Dinamico.cMovil[0].vyCV[k-1]); 
        while(k>1){ 
        if((Dinamico.cMovil[0].vyCV[k]>Dinamico.cMovil[0].vyCV[k-1]) && 
        (Dinamico.cMovil[0].vxCV[k]>Dinamico.cMovil[0].vxCV[k-1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k] 
        +75,Dinamico.cMovil[0].vyCV[k]-75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]<=Dinamico.cMovil[0].vyCV[k-1]) && 
        (Dinamico.cMovil[0].vxCV[k]>Dinamico.cMovil[0].vxCV[k-1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]-75,Dinamico.cMovil[0].vyCV[k]-75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]>=Dinamico.cMovil[0].vyCV[k-1]) && 
        (Dinamico.cMovil[0].vxCV[k]<Dinamico.cMovil[0].vxCV[k-1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]+75,Dinamico.cMovil[0].vyCV[k] 
        +75 ); 
        } 
        else{ 
        if((Dinamico.cMovil[0].vyCV[k]>=Dinamico.cMovil[0].vyCV[k-1]) && 
        (Dinamico.cMovil[0].vxCV[k]>Dinamico.cMovil[0].vxCV[k-1]) ){ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k]+75,Dinamico.cMovil[0].vyCV[k] 
        +75 ); 
        } 
        else{ 
        dib.lineTo( Dinamico.cMovil[0].vxCV[k] 
        +75,Dinamico.cMovil[0].vyCV[k]-75 ); 
        } 
        } 
        } 
        } 
        k--; 
        } 
         */ int k = 0;
        while (Dinamico.cMovil[0].vxCV[k + 1] > 0) {
            g1.fillOval(Dinamico.cMovil[0].vxCV[k] - 75,
                    Dinamico.cMovil[0].vyCV[k] - 75, 180, 180);
            k++;
        }
        /* 
        dib.lineTo( Dinamico.cMovil[0].vxCV[0],Dinamico.cMovil[0].vyCV[0] ); 
        g1.setColor(new Color(50,50,50)); 
        gDib.fill(dib); 
        g1.setColor(new Color(255,200,0)); 
         */
        k = 0;
        while (Dinamico.cMovil[0].vxCV[k] > 0) {
            g1.fillOval(Dinamico.cMovil[0].vxCV[k], Dinamico.cMovil[0].vyCV[k], 4,
                    4);
            k += 2;
        }
    }
}

// clase que genera la movilidad y la mueve 
class Movilidad extends JComponent implements Runnable {

    float angulo, xr, yr;
    int px;
    int py;
    int dir;
    int[] vx = new int[2000];
    int[] vy = new int[2000];
    int[] vxColi = new int[500];
    int[] vyColi = new int[500];
    int rojo, verde, azul;
    boolean isColi = false;
    int ix = 0;
    double inc;
    int width, height;
    String tipoMov;

    public Movilidad(CursoMovil cumov) {
        px = cumov.vxCV[0];
        py = cumov.vyCV[0];
        rojo = cumov.rojo;
        verde = cumov.verde;
        azul = cumov.azul;
        width = 50; //ancho1; 
        height = 100; //alto1; 
        setBounds(0, 0, Dinamico.Ancho, Dinamico.Alto);
        setLayout(null);
        vx = cumov.vxCV;
        vy = cumov.vyCV;
        this.vxColi = cumov.vxColi;
        this.vyColi = cumov.vyColi;
        this.isColi = cumov.isColi;
        tipoMov = cumov.tipoMovil;
        //System.out.println(cumov.tipoMovil); 
        angulo = 0;
    }

    @Override
    public void paint(Graphics g) {
        if (vx[ix] > 0) {
            Graphics2D render = (Graphics2D) g;
            GeneralPath model = new GeneralPath();
            px = vx[ix];
            py = vy[ix];
            model.moveTo(px + 10, py);
            model.curveTo(px + 10, py, px, py, px, py + 10);
            model.lineTo(px + 0, py + height - 10);
            model.curveTo(px + 0, py + height - 10, px, py
                    + height, px + 10, py + height);
            model.lineTo(px + width - 10, py + height);
            model.curveTo(px + width - 10, py + height, px + width,
                    py + height, px + width, py + height - 10);
            model.lineTo(px + width, py + 10);
            model.curveTo(px + width, py + 10, px + width, py, px
                    + width - 10, py);
            model.lineTo(px + 10, py + 0);
            model.closePath();
            render.setColor(new Color((rojo + 50) % 256,
                    (verde + 50) % 256, (azul + 50) % 256));
            //DA EL ANGULO AL OBJETO 
            dir = 1;
            if (ix - 1 >= 0 && (px - vx[ix - 1]) != 0) {
                angulo = (float) Math.atan(((py - vy[ix - 1])
                        / (px - vx[ix - 1]))) * dir;
            } else {
                angulo = (float) Math.atan(((py - 0)
                        / (px - 0)) * dir);
            }
            angulo += (float) (Math.PI / 2);
            if (ix - 1 >= 0) {
                if (px - vx[ix - 1] < 0) {
                    angulo += (float) (Math.PI);
                } else {
                    dir = -1;
                }
            }
            //System.out.println( angulo ); 
            render.rotate(angulo, px + height / 2, py + width / 2);
            render.translate(xr, yr);
            render.fill(model);
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(px + 2, py + 2, width - 4, height - 4,
                    20, 20);
            g.setColor(new Color(rojo, verde, azul));
            if (tipoMov.equals("Mini Bus")) {
                // techo 
                g.fillRect(px + 5, py + 10, width - 15,
                        height - 15);
                g.setColor(new Color((rojo + 256 - 50) % 256,
                        (verde + 256 - 50) % 256, (azul + 256 - 50) % 256));
                g.drawRoundRect(px + 5, py + 10, width - 15,
                        height - 15, 10, 10);
            } else {
                if (tipoMov.equals("Radio Taxi")) {
                    // maletera 
                    g.fillRect(px + 7, py + 4,
                            width - 14, height * 1 / 4 - 6);
                    // capo 
                    g.fillRect(px + 7, py
                            + height * 3 / 4 + 2, width - 14, height * 1 / 4 - 6);
                    // techo 
                    g.fillRect(px + 10, py
                            + height * 1 / 4, width - 13, height * 1 / 2);
                    g.setColor(new Color((rojo
                            + 256 - 50) % 256, (verde + 256 - 50) % 256, (azul + 256 - 50) % 256));
                    g.drawRoundRect(px + 10, py
                            + height * 1 / 4, width - 13, height * 1 / 2, 10, 10);
                    // capo 
                    g.drawRoundRect(px + 7, py
                            + height * 3 / 4 + 2, width - 14, height * 1 / 4 - 6, 10, 10);
                    // maletera 
                    g.drawRoundRect(px + 7, py + 4,
                            width - 14, height * 1 / 4 - 6, 10, 10);
                } else {
                    // capo 
                    g.fillRect(px + 7, py + 5,
                            width - 14, height * 1 / 4 - 6);
                    // techo  vagoneta 
                    g.fillRect(px + 10, py
                            + height * 1 / 4 + 2, width - 10, height - 35);
                    g.setColor(new Color((rojo
                            + 256 - 50) % 256, (verde + 256 - 50) % 256, (azul + 256 - 50) % 256));
                    g.drawRoundRect(px + 10, py
                            + height * 1 / 4 + 2, width - 10, height - 35, 10, 10);
                    g.drawRoundRect(px + 7, py + 5,
                            width - 14, height * 1 / 4 - 6, 10, 10);
                    // maletera 
                    //g.setColor(new                     Color(rojo, verde, azul)); 
                    //g.fillRect(px+7, py+4, width - 14 , height * 1 / 4 - 6   ); 
                }
            }
            if (!isColi) {
                // luces delanteras 
                g.setColor(new Color(255, 255, 0));
                if (tipoMov.equals("Mini Bus")) {
                    g.fillOval(px + 7, py + 1, 10, 10);
                    g.fillOval(px + width - 14, py + 1,
                            10, 10);
                } else {
                    g.fillOval(px + 3, py + 3, 7, 7);
                    g.fillOval(px + width - 10, py + 3,
                            7, 7);
                }
                // luces posteriores 
                g.setColor(new Color(255, 0, 0));
                g.fillOval(px, py + height - 5, 5, 5);
                g.fillOval(px + width - 5, py + height - 5,
                        5, 5);
            }
        }
        ix = (ix + 2) % 1000;
    }
    boolean sw = true;

    public void run() {
        try {
            do {
                colision();
                Thread.sleep(50);
                //Thread.sleep(100); 
                paintImmediately(0,
                        0, Dinamico.Ancho, Dinamico.Alto);
            } //while(true); 
            while (sw);
        } catch (InterruptedException e) {
        }
    }
    int c = 0;

    public void colision() {
        for (int i = 1; i < Dinamico.TMov - 1; i++) {
            for (int j = i + 1; j < Dinamico.TMov; j++) {
                if (i != j) {
                    int w = width / 2;
                    int h = height / 2;
                    if ((Dinamico.cMovil[i].vyCV[ix] + h >= Dinamico.cMovil[j].vyCV[ix]
                            && Dinamico.cMovil[i].vyCV[ix] + h <= Dinamico.cMovil[j].vyCV[ix] + h)
                            && (Dinamico.cMovil[i].vxCV[ix] + w >= Dinamico.cMovil[j].vxCV[ix]
                            && Dinamico.cMovil[i].vxCV[ix] + w <= Dinamico.cMovil[j].vxCV[ix] + w)) {
                        System.out.println("\t" + ix + "\t" + i + "\t" + j
                                + "\t" + Dinamico.cMovil[i].vxCV[ix] + "\t" + Dinamico.cMovil[i].vyCV[ix]
                                + "\t" + Dinamico.cMovil[j].vxCV[ix] + "\t" + Dinamico.cMovil[j].vyCV[ix]);
                        sw = false;
                    }
                }
            }
        }
    }
}
