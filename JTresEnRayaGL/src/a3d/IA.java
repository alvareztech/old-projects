package a3d;

/**
 * Clase IA
 * @author Daniel Alvarez (a3dany)
 */
public class IA {

    private int ganador;
    private int lineas;
    private int columnas;
    private int diagonales;
    private int[][] tablero;
    private Punto X;
    private int min;
    private int minmax;

    public IA() {
        ganador = 0;
        lineas = 0;
        columnas = 0;
        diagonales = 0;
        tablero = new int[3][3];
        min = 100;
        minmax = -100;
    }

    public boolean minimax() {
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
                    contador++;

                    temp_max = checaDiagonales(true) + checaColumnas(true) + checaLineas(true);
                    if (temp_max < -50) {
                        //////// GANA LA COMPUTADORA
                        ganador = 2;
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
                    ///
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
        //        pos.setText("Posici?n optima (ren,col): (" + (save_row + 1) + ", " + (save_col + 1) + ")");
        return estaLleno();
    }

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

    public char[] getMovimientoIA() {
        char[] t = new char[9];
        int c = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 1) {
                    t[c] = 'o';
                } else {
                    if (tablero[i][j] == -1) {
                        t[c] = 'x';
                    } else {
                        t[c] = ' ';
                    }
                }
                c++;
            }

        }
        return t;
    }

    public void setMovimientoHumano(int pos) {
        switch (pos) {
            case 1:
                tablero[0][0] = -1;
                break;
            case 2:
                tablero[0][1] = -1;
                break;
            case 3:
                tablero[0][2] = -1;
                break;
            case 4:
                tablero[1][0] = -1;
                break;
            case 5:
                tablero[1][1] = -1;
                break;
            case 6:
                tablero[1][2] = -1;
                break;
            case 7:
                tablero[2][0] = -1;
                break;
            case 8:
                tablero[2][1] = -1;
                break;
            case 9:
                tablero[2][2] = -1;
                break;
        }
    }
}
