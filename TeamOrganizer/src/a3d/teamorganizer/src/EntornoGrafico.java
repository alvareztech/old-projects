package a3d.teamorganizer.src;

import java.awt.*;

public class EntornoGrafico extends Frame {

    private int c;
    private Equipo E;
    private ListaSimple_E ev;
    private Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;
    private TextField tfM, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tfA1, tfA2, tfA3, tfA4, tfA5, tfP1, tfP2, tfP3, tfP4, tfP5, tfP6, tfP7, tfP8, tfP9;
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, btA1, btA2, btA3, btP1, btP2, btP3, btX, btC;
    private Toolkit tool;
    private Image fondo, m1, equi1, equi2, equi3, equi4, equi5, equi6, equi7, equi8, jug, par;
    private Checkbox e1, e2, e3, e4, e5, e6, e7, e8;
    private TextArea ta1, taA, refresh, taE1, taE2;
    private Font f1, f2;
    private CheckboxGroup esc;
    private Choice pos, dia, mes, anio, tipo, tiem, tipoE;

    public EntornoGrafico() {
        super("TeamOrganizer 1.0 por DANIEL ALVAREZ");
        c = 0;
    }

    public void inicio() {
        //setBackground (Color.white);
        c = 1;
        refresh = new TextArea();
        refresh.setBounds(0, 0, 640, 500);

        setLayout(null);
        tool = getToolkit();
        fondo = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/fondo.jpg"));
        m1 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/m1.jpg"));
        equi1 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi1.jpg"));
        equi2 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi2.jpg"));
        equi3 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi3.jpg"));
        equi4 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi4.jpg"));
        equi5 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi5.jpg"));
        equi6 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi6.jpg"));
        equi7 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi7.jpg"));
        equi8 = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/equi8.jpg"));
        jug = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/jug.jpg"));
        par = tool.getImage(getClass().getResource("/a3d/teamorganizer/images/par.jpg"));
        f1 = new Font("Tahoma", Font.PLAIN, 25);
        /********** 1 **********/
        bt1 = new Button("CREAR NUEVO EQUIPO");
        btX = new Button("SALIR");
        btC = new Button("Cancelar Todo");
        bt1.setBounds(240, 220, 160, 30);
        btX.setBounds(10, 470, 60, 20);
        btC.setBounds(540, 470, 90, 20);
        add(bt1);
        add(btX);
        /********** 2 **********/
        tf1 = new TextField();
        tf2 = new TextField();
        esc = new CheckboxGroup();
        e1 = new Checkbox("1", esc, true);
        e2 = new Checkbox("2", esc, false);
        e3 = new Checkbox("3", esc, false);
        e4 = new Checkbox("4", esc, false);
        e5 = new Checkbox("5", esc, false);
        e6 = new Checkbox("6", esc, false);
        e7 = new Checkbox("7", esc, false);
        e8 = new Checkbox("8", esc, false);
        bt3 = new Button("CREAR");
        tf1.setBounds(240, 145, 160, 25);
        tf2.setBounds(240, 195, 160, 25);
        e1.setBounds(95, 320, 30, 20);
        e2.setBounds(155, 320, 30, 20);
        e3.setBounds(215, 320, 30, 20);
        e4.setBounds(275, 320, 30, 20);
        e5.setBounds(335, 320, 30, 20);
        e6.setBounds(395, 320, 30, 20);
        e7.setBounds(455, 320, 30, 20);
        e8.setBounds(515, 320, 30, 20);
        bt3.setBounds(250, 370, 140, 25);
        /********** 3 **********/
        bt4 = new Button("Plantilla de Jugadores");
        bt5 = new Button("Partidos Jugados");
        bt6 = new Button("Adicionar Jugadores");
        bt7 = new Button("Nuevo Partido");
        bt8 = new Button("Nro de Partidos Ganados");
        bt9 = new Button("Partidos Ganados");
        bt10 = new Button("Jugador Goleador");
        bt11 = new Button("Jugador Amonestado");
        bt12 = new Button("Jugador Joven");
        bt4.setBounds(150, 140, 160, 25);
        bt5.setBounds(330, 140, 160, 25);
        bt6.setBounds(170, 180, 140, 25);
        bt7.setBounds(330, 180, 140, 25);

        bt8.setBounds(250, 220, 140, 25);
        bt9.setBounds(250, 250, 140, 25);
        bt10.setBounds(250, 280, 140, 25);
        bt11.setBounds(250, 310, 140, 25);
        bt12.setBounds(250, 300, 140, 25);

        taE1 = new TextArea();
        taE1.setBounds(30, 220, 200, 200);
        taE2 = new TextArea();
        taE2.setBounds(410, 220, 200, 200);

        /********** adi J **********/
        tfA1 = new TextField();
        tfA2 = new TextField();
        tfA3 = new TextField();
        tfA4 = new TextField();
        tfA5 = new TextField();
        pos = new Choice();
        pos.addItem("Portero");
        pos.addItem("Defensa");
        pos.addItem("Mediocampista");
        pos.addItem("Delantero");
        taA = new TextArea();
        btA1 = new Button("Adicionar");
        btA2 = new Button("Terminar");
        tfA1.setBounds(95, 180, 140, 25);
        tfA2.setBounds(255, 180, 50, 25);
        pos.setBounds(95, 230, 115, 25);
        tfA3.setBounds(230, 230, 75, 25);
        tfA4.setBounds(95, 280, 95, 25);
        tfA5.setBounds(210, 280, 95, 25);
        taA.setBounds(340, 180, 210, 185);
        btA1.setBounds(130, 340, 140, 25);
        btA2.setBounds(240, 400, 160, 25);
        /********** adi PAR **********/
        dia = new Choice();
        dia.addItem("1");
        dia.addItem("2");
        dia.addItem("3");
        dia.addItem("4");
        dia.addItem("5");
        dia.addItem("6");
        dia.addItem("7");
        dia.addItem("8");
        dia.addItem("9");
        dia.addItem("10");
        dia.addItem("11");
        dia.addItem("12");
        dia.addItem("13");
        dia.addItem("14");
        dia.addItem("15");
        dia.addItem("16");
        dia.addItem("17");
        dia.addItem("18");
        dia.addItem("19");
        dia.addItem("20");
        dia.addItem("21");
        dia.addItem("22");
        dia.addItem("23");
        dia.addItem("24");
        dia.addItem("25");
        dia.addItem("26");
        dia.addItem("27");
        dia.addItem("28");
        dia.addItem("29");
        dia.addItem("30");
        dia.addItem("31");
        mes = new Choice();
        mes.addItem("1");
        mes.addItem("2");
        mes.addItem("3");
        mes.addItem("4");
        mes.addItem("5");
        mes.addItem("6");
        mes.addItem("7");
        mes.addItem("8");
        mes.addItem("9");
        mes.addItem("10");
        mes.addItem("11");
        mes.addItem("12");
        anio = new Choice();
        anio.addItem("2000");
        anio.addItem("2001");
        anio.addItem("2002");
        anio.addItem("2003");
        anio.addItem("2004");
        anio.addItem("2005");
        anio.addItem("2006");
        anio.addItem("2007");
        anio.addItem("2008");
        anio.addItem("2009");
        anio.addItem("2010");
        tipo = new Choice();
        tipo.addItem("Amistoso");
        tipo.addItem("Oficial Copa");
        tipo.addItem("Clasificatoria");
        tipo.addItem("SemiFinal");
        tipo.addItem("Final");
        tfP1 = new TextField();
        tfP2 = new TextField();
        tfP3 = new TextField();
        tfP4 = new TextField();
        dia.setBounds(125, 145, 40, 25);
        mes.setBounds(175, 145, 40, 25);
        anio.setBounds(225, 145, 55, 25);
        tipo.setBounds(125, 195, 155, 25);
        tfP1.setBounds(125, 245, 155, 25);
        tfP2.setBounds(125, 295, 155, 25);
        tfP3.setBounds(165, 350, 25, 25);
        tfP4.setBounds(225, 350, 25, 25);

        //----Eventos
        tiem = new Choice();
        tiem.addItem("1er Tiempo");
        tiem.addItem("2do Tiempo");
        tiem.addItem("Tiempo de Adicion");
        tiem.addItem("Tanda de Penaltis");
        tfP5 = new TextField();
        tfP6 = new TextField();
        tipoE = new Choice();
        tipoE.addItem("Gol");
        tipoE.addItem("Amonestacion");
        tipoE.addItem("Expulsion");
        tipoE.addItem("Lesion");
        tipoE.addItem("Cambio Egreso");
        tipoE.addItem("Cambio Ingreso");
        btP2 = new Button("Crear Evento");
        tiem.setBounds(370, 200, 160, 25);
        tfP5.setBounds(370, 250, 160, 25);
        tfP6.setBounds(370, 300, 30, 25);
        tipoE.setBounds(415, 300, 115, 25);
        btP2.setBounds(380, 350, 140, 25);
        //----
        btP1 = new Button("Finalizar Partido");
        btP1.setBounds(240, 420, 160, 25);
        /***********************/
        show();
    }

    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 20, this);
        if (c == 2) {
            g.drawImage(m1, 0, 20, this);
        }
        if (c == 3) {
            if (E.obtE() == 1) {
                g.drawImage(equi1, 0, 20, this);
            }
            if (E.obtE() == 2) {
                g.drawImage(equi2, 0, 20, this);
            }
            if (E.obtE() == 3) {
                g.drawImage(equi3, 0, 20, this);
            }
            if (E.obtE() == 4) {
                g.drawImage(equi4, 0, 20, this);
            }
            if (E.obtE() == 5) {
                g.drawImage(equi5, 0, 20, this);
            }
            if (E.obtE() == 6) {
                g.drawImage(equi6, 0, 20, this);
            }
            if (E.obtE() == 7) {
                g.drawImage(equi7, 0, 20, this);
            }
            if (E.obtE() == 8) {
                g.drawImage(equi8, 0, 20, this);
            }
            g.setColor(Color.white);
            g.setFont(f1);
            g.drawString(E.obtNombre(), 90, 70);
            g.drawString("DT: " + E.obtDT(), 90, 100);

        }
        if (c == 4) {
            g.drawImage(jug, 0, 20, this);
        }
        if (c == 5) {
            g.drawImage(par, 0, 20, this);
        }
        //g.drawString ("TeamOrganizer 1.0 - Daniel Alvarez - UMSA 2008", 200, 460);
    }

    public boolean action(Event e, Object o) {
        if (e.target instanceof Button) {
            if (e.arg.equals("CREAR NUEVO EQUIPO")) {
                c = 2;
                remove(bt1);
                add(btC);
                add(tf1);
                add(tf2);
                add(bt3);
                add(e1);
                add(e2);
                add(e3);
                add(e4);
                add(e5);
                add(e6);
                add(e7);
                add(e8);
                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("CREAR")) {
                c = 3;
                remove(tf1);
                remove(tf2);
                remove(bt3);
                remove(e1);
                remove(e2);
                remove(e3);
                remove(e4);
                remove(e5);
                remove(e6);
                remove(e7);
                remove(e8);
                E = new Equipo();
                E.llenar1(tf1.getText(), tf2.getText(), Integer.parseInt((esc.getCurrent()).getLabel()));
                add(bt4);
                add(bt5);
                add(bt6);
                add(bt7);
                //add (bt8);
                //add (bt9);
                // add (bt10);
                //add (bt11);
                add(bt12);

                add(taE1);
                add(taE2);
                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("Plantilla de Jugadores")) {

                PilaN_J aux = new PilaN_J();
                aux = E.Jugadores.r_inOrden();
                while (!aux.esVacia()) {
                    Nodo_J x = aux.eliminar();
                    taE1.insertText(" -> " + x.nombre + " , " + x.edad + " , " + x.posicion + " , " + x.media + " , " + x.estatura + " , " + x.peso + "\n", 0);
                }

            }
            if (e.arg.equals("Partidos Jugados")) {

                NodoM_P v = new NodoM_P();
                v = E.Partidos.PM;
                while (v != null) {
                    Nodo_E w = new Nodo_E();
                    w = v.eventos;
                    while (w != null) {
                        taE2.insertText(" * " + w.tiempo + "-" + w.minuto + "-" + w.autor + "-" + w.tipo + "\n", 0);
                        w = w.sig;
                    }
                    taE2.insertText("\nPartido\n Fecha: " + v.dia + "/" + v.mes + "/" + v.anio + "\n Tipo: " + v.tipo + "\n Lugar: " + v.lugar + "\n Rival: " + v.rival + "\n Marcador: E (" + v.golesE + ") vs (" + v.golesR + ") R\n Eventos:\n", 0);
                    v = v.sig;
                }

            }
            if (e.arg.equals("Adicionar Jugadores")) {
                c = 4;
                remove(bt4);
                remove(bt5);
                remove(bt6);
                remove(bt7);
                remove(bt8);
                remove(bt9);
                remove(bt10);
                remove(bt11);
                remove(bt12);

                //    remove (tfM);
                remove(taE1);
                remove(taE2);

                add(tfA1);
                add(tfA2);
                add(tfA3);
                add(tfA4);
                add(tfA5);
                add(taA);
                add(pos);
                add(btA1);
                add(btA2);

                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("Terminar")) {
                c = 3;
                remove(tfA1);
                remove(tfA2);
                remove(tfA3);
                remove(tfA4);
                remove(tfA5);
                remove(taA);
                remove(pos);
                remove(btA1);
                remove(btA2);

                add(bt4);
                add(bt5);
                add(bt6);
                add(bt7);
                // add (bt8);
                //  add (bt9);
                // add (bt10);
                // add (bt11);
                add(bt12);

                add(taE1);
                add(taE2);

                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("Nuevo Partido")) {
                c = 5;
                ev = new ListaSimple_E();
                remove(bt4);
                remove(bt5);
                remove(bt6);
                remove(bt7);
                remove(bt8);
                remove(bt9);
                remove(bt10);
                remove(bt11);
                remove(bt12);

                //   remove (tfM);
                remove(taE1);
                remove(taE2);

                add(dia);
                add(mes);
                add(anio);
                add(tipo);
                add(tfP1);
                add(tfP2);
                add(tfP3);
                add(tfP4);
                //even
                add(tiem);
                add(tfP5);
                add(tfP6);
                add(tipoE);
                add(btP2);
                add(btP1);

                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("Crear Evento")) {
                ev.adiUltimo(tiem.getSelectedItem(), Integer.parseInt(tfP6.getText()), tfP5.getText(), tipoE.getSelectedItem());
            }
            if (e.arg.equals("Finalizar Partido")) {
                E.Partidos.adiUltimo(Integer.parseInt(dia.getSelectedItem()), Integer.parseInt(mes.getSelectedItem()), Integer.parseInt(anio.getSelectedItem()), tipo.getSelectedItem(), tfP1.getText(), tfP2.getText(), Integer.parseInt(tfP3.getText()), Integer.parseInt(tfP4.getText()), ev);
                c = 3;
                remove(dia);
                remove(mes);
                remove(anio);
                remove(tipo);
                remove(tfP1);
                remove(tfP2);
                remove(tfP3);
                remove(tfP4);
                //even
                remove(tiem);
                remove(tfP5);
                remove(tfP6);
                remove(tipoE);
                remove(btP2);
                remove(btP1);

                add(bt4);
                add(bt5);
                add(bt6);
                add(bt7);
                // add (bt8);
                // add (bt9);
                // add (bt10);
                // add (bt11);
                add(bt12);

                add(taE1);
                add(taE2);

                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("Adicionar")) {
                E.Jugadores.cargar(tfA1.getText(), Integer.parseInt(tfA2.getText()), pos.getSelectedItem(), Integer.parseInt(tfA3.getText()), Integer.parseInt(tfA4.getText()), Integer.parseInt(tfA5.getText()));
                taA.setText("Adicionado !");
            }
            if (e.arg.equals("Cancelar Todo")) {
                c = 1;
                E = new Equipo();
                remove(taE1);
                remove(taE2);
                remove(tf1);
                remove(tf2);
                remove(bt3);
                remove(e1);
                remove(e2);
                remove(e3);
                remove(e4);
                remove(e5);
                remove(e6);
                remove(e7);
                remove(e8);
                remove(bt4);
                remove(bt5);
                remove(bt6);
                remove(bt7);
                remove(bt8);
                remove(bt9);
                remove(bt10);
                remove(bt11);
                remove(bt12);
                remove(dia);
                remove(mes);
                remove(anio);
                remove(tipo);
                remove(tfP1);
                remove(tfP2);
                remove(tfP3);
                remove(tfP4);
                remove(tiem);
                remove(tfP5);
                remove(tfP6);
                remove(tipoE);
                remove(btP2);
                remove(btP1);
                remove(tfA1);
                remove(tfA2);
                remove(tfA3);
                remove(tfA4);
                remove(tfA5);
                remove(taA);
                remove(pos);
                remove(btA1);
                remove(btA2);

                add(bt1);
                add(btX);

                add(refresh);
                remove(refresh);
            }
            if (e.arg.equals("SALIR")) {
                System.exit(0);
            }
            if (e.arg.equals("Jugador Joven")) {
                if (E.Jugadores.R != null) {
                    taE1.insertText("El Jugador mas Joven es:\n -> " + E.Jugadores.masJoven(), 0);
                }
            }
        }
        return true;
    }
}
