package pruebas;

import java.awt.*;
import java.awt.event.*;

public class minimax_1 extends java.applet.Applet implements ActionListener {

    Panel p, principal;
    Button bNuevo;
    Button casilla[][];
    Image cero, equis;
    boolean ban = false;
    int tablero[][] = new int[3][3];
    int diagonales = 0, lineas = 0, columnas = 0, minmax = -100, min = 100;
    Thread runner = null;
    byte quienGana = 0; // 0 empate, 1 el humano gana, 2 la computadora gana
    TextArea muestra;
    Label pos;

    public void init() {
        setBackground(Color.black);
        setLayout(new BorderLayout());
        principal = new Panel();
        principal.setLayout(new BorderLayout());
        p = new Panel();
        p.setBackground(Color.black);
        p.setLayout(new GridLayout(3, 3, 10, 10));

        // TEXTAREA QUE MUESTRA COMO SE HACE EL PROCESO
        muestra = new TextArea("", 10, 10, 0);
        muestra.reshape(300, 150, 300, 150);
        muestra.setBackground(Color.white);

        // ETIQUETA QUE MUESTRA POSICION OPTIMA
        pos = new Label("                                                          ");
        pos.reshape(310, 100, 200, 20);
        pos.setForeground(Color.white);

        // CREA EL BOTON DE NUEVO JUEGO
        bNuevo = new Button("Nuevo juego");
        bNuevo.setBackground(new java.awt.Color(58, 100, 241));
        bNuevo.setForeground(Color.white);
        bNuevo.addActionListener(this);

        // CREA LAS AREAS DE LA CASILLA Y LAS PONE EN EL PANEL
        casilla = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casilla[i][j] = new Button();
                casilla[i][j].setBackground(new java.awt.Color(132, 207, 255));
                casilla[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                casilla[i][j].addActionListener(this);
                p.add(casilla[i][j]);
            }
        }
        principal.add("North", bNuevo);
        principal.add("Center", p);
        principal.reshape(0, 0, 300, 300);
        add(principal);
        add(muestra);
        add(pos);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(300, 0, 300, 300);
        g.setColor(Color.yellow);
        g.drawString("ARREGLO PRINCIPAL:", 310, 20);
        g.setColor(Color.white);

        // IMPRIME EL ARREGLO DEL TABLERO EN PANTALLA
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.drawString("" + tablero[i][j], 310 + (j * 30), 40 + (i * 16));
            }
        }

        g.setColor(Color.yellow);
        g.drawString("JUGADAS A EVALUAR:", 305, 143);
        if (quienGana > 0) {
            g.setColor(Color.red);
            if (quienGana == 1) {
                pos.setText("�TU GANAS!");
            } else if (quienGana == 2) {
                pos.setText("�YO GANO!");
            }
        }
    }

    // EVENTOS
    public void actionPerformed(ActionEvent e) {

        // BOTON NUEVO JUEGO
        if (e.getSource() == bNuevo) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    casilla[i][j].setLabel("");	// BORRA LAS ETIQUETAS DE LOS BOTONES
                    tablero[i][j] = 0;		// BORRA LA MATRIZ DEL TABLERO
                }
            }
            quienGana = 0;
            muestra.setText("");
            pos.setText("");
            ban = true;					// Y HABILITA LA BANDERA DE JUEGO
            repaint();
        }

        // VERIFICA SI SE PRESIONO ALGUNA DE LAS CASILLAS
        for (int i = 0; (i < 3) && (ban == true); i++) {
            for (int j = 0; j < 3; j++) {
                if ((e.getSource() == casilla[i][j]) && (casilla[i][j].getLabel().equals(""))) {
                    casilla[i][j].setLabel(":-)");
                    tablero[i][j] = -1;
                    muestra.setText("");
                    minMax();
                    checaGanador();
                    if (quienGana > 0) {
                        ban = false;
                    }
                    actualiza();
                }
            }
        }
    }

    // ACTUALIZA LAS POSICIONES EN BASE AL ARREGLO
    public void actualiza() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 1) {
                    casilla[i][j].setLabel("O");
                } else if (tablero[i][j] == -1) {
                    casilla[i][j].setLabel(":-)");
                } else {
                    casilla[i][j].setLabel("");
                }
            }
        }

        repaint();
    }

    // CHECA LAS POSICIONES EN LAS DIAGONALES
    public int checaDiagonales(boolean isMax) {
        int min = 1;
        int max = -1;
        // ALTERNA MAXIMOS Y MINIMOS
        if (isMax) {
            min = -1;
            max = 1;
        }
        diagonales = 0;
        if ((tablero[0][0] != min) && (tablero[1][1] != min) && (tablero[2][2] != min)) {
            if ((tablero[0][0] == max) && (tablero[1][1] == max) && (tablero[2][2] == max)) {
                return -100;
            }
            diagonales++;
        }
        if ((tablero[0][2] != min) && (tablero[1][1] != min) && (tablero[2][0] != min)) {
            if ((tablero[0][2] == max) && (tablero[1][1] == max) && (tablero[2][0] == max)) {
                return -100;
            }
            diagonales++;
        }
        if (isMax) {
            return diagonales;
        } else {
            diagonales *= -1;
            return (0 - diagonales);
        }
    }

    // CHECA LAS POSICIONES EN LAS LINEAS
    public int checaLineas(boolean isMax) {
        int min = 1;
        int max = -1;
        // ALTERNA LOS MAXIMOS Y MINIMOS
        if (isMax) {
            min = -1;
            max = 1;
        }
        lineas = 0;
        if ((tablero[0][0] != min) && (tablero[0][1] != min) && (tablero[0][2] != min)) {
            if ((tablero[0][0] == max) && (tablero[0][1] == max) && (tablero[0][2] == max)) {
                return -100;
            }
            lineas++;
        }

        if ((tablero[1][0] != min) && (tablero[1][1] != min) && (tablero[1][2] != min)) {
            if ((tablero[1][0] == max) && (tablero[1][1] == max) && (tablero[1][2] == max)) {
                return -100;
            }
            lineas++;
        }
        if ((tablero[2][0] != min) && (tablero[2][1] != min) && (tablero[2][2] != min)) {
            if ((tablero[2][0] == max) && (tablero[2][1] == max) && (tablero[2][2] == max)) {
                return -100;
            }
            lineas++;
        }
        if (isMax) {
            return lineas;
        } else {
            lineas *= -1;
            return (0 - lineas);
        }
    }

    // CHECA LAS POSICIONES DE LAS COLUMNAS
    public int checaColumnas(boolean isMax) {
        int min = 1;
        int max = -1;
        // ALTERNA LOS MAXIMOS Y MINIMOS
        if (isMax) {
            min = -1;
            max = 1;
        }
        columnas = 0;
        if ((tablero[0][0] != min) && (tablero[1][0] != min) && (tablero[2][0] != min)) {
            if ((tablero[0][0] == max) && (tablero[1][0] == max) && (tablero[2][0] == max)) {
                return -100;
            }
            columnas++;
        }
        if ((tablero[0][1] != min) && (tablero[1][1] != min) && (tablero[2][1] != min)) {
            if ((tablero[0][1] == max) && (tablero[1][1] == max) && (tablero[2][1] == max)) {
                return -100;
            }
            columnas++;
        }
        if ((tablero[0][2] != min) && (tablero[1][2] != min) && (tablero[2][2] != min)) {
            if ((tablero[0][2] == max) && (tablero[1][2] == max) && (tablero[2][2] == max)) {
                return -100;
            }
            columnas++;
        }
        if (isMax) {
            return columnas;
        } else {
            columnas *= -1;
            return (0 - columnas);
        }
    }

    // VERIFICA SI EXISTE ALGUN GANADOR
    public void checaGanador() {
        // CHECA SI GANO EL CONTRINCANTE HUMANO EN LAS DIAGONALES
        if ((tablero[0][0] == -1 && tablero[1][1] == -1 && tablero[2][2] == -1) || (tablero[0][2] == -1 && tablero[1][1] == -1 && tablero[2][0] == -1)) {
            quienGana = 1;
        }
        // CHECA SI GANO EL CONTRINCANTE HUMANO EN LAS LINEAS
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == -1 && tablero[i][1] == -1 && tablero[i][2] == -1) {
                quienGana = 1;
            }
        }
        // CHECA SI GANO EL CONTRINCANTE HUMANO EN LAS COLUMNAS
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == -1 && tablero[1][i] == -1 && tablero[2][i] == -1) {
                quienGana = 1;
            }
        }
    }

    // VERIFICA SI TODO EL TABLERO ESTA LLENO
    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // ALGORITMO PRINCIPAL MINIMAX
    public boolean minMax() {
        int temp_max = 0;
        int temp_min = 0;
        int temp_minmax = 0;
        int save_col = -1;
        int save_row = -1;
        minmax = -100;
        min = 100;
        for (int i = 0, contador = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    if (tablero[1][1] == 0) {
                        tablero[1][1] = 1;
                        return estaLleno();
                    }
                    tablero[i][j] = 1;
                    //
                    //
                    //
                    //
                    contador++;

                    muestra.append("EVALUACION " + contador + ":\n");
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            muestra.append("  " + tablero[k][l]);
                        }
                        muestra.append("\n");
                    }

                    /////////////////

                    temp_max = checaDiagonales(true) + checaColumnas(true) + checaLineas(true);
                    if (temp_max < -50) {
                        //////// GANA LA COMPUTADORA
                        quienGana = 2;
                        return true;
                    } else {
                        for (int i2 = 0; i2 < 3; i2++) {
                            for (int j2 = 0; j2 < 3; j2++) {
                                if (tablero[i2][j2] == 0) {
                                    tablero[i2][j2] = -1;
                                    temp_min = checaDiagonales(false) + checaColumnas(false) + checaLineas(false);
                                    if (temp_min < -50) {
                                        save_row = i2;
                                        save_col = j2;
                                    }
                                    if (temp_min < min) {
                                        min = temp_min;
                                    }
                                    tablero[i2][j2] = 0;
                                }
                            }
                        }
                    }
                    temp_minmax = temp_max - min;
                    ////
                    muestra.append("Caminos posibles de  O  = " + temp_max + "\n");
                    muestra.append("Caminos posibles de :-) = " + temp_min + "\n\n");
                    muestra.append("-------------------------\n\n");
                    ///
                    System.out.println("");
                    if (temp_minmax > minmax) {
                        if (temp_minmax < 50) {
                            save_row = i;
                            save_col = j;
                        }
                        minmax = temp_minmax;
                    }
                    tablero[i][j] = 0;
                }
            }
        }
        tablero[save_row][save_col] = 1;
        pos.setText("Posici�n optima (ren,col): (" + (save_row + 1) + ", " + (save_col + 1) + ")");
        repaint();
        return estaLleno();
    }
}
