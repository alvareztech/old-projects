package a3d;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

/**
 * Clase Solucion
 * @author Daniel Alvarez (a3dany)
 */
public class Solucion extends Thread {

    private JTextField[] cajas;
    private JTextArea areaDeTexto;
    private int[] sudoku;

    public Solucion(JTextField[] cajas, JTextArea areaDeTexto, int[] sudoku) {
        this.cajas = cajas;
        this.areaDeTexto = areaDeTexto;
        this.sudoku = sudoku;
    }

    @Override
    public void run() {
        try {
            Configuration configuracion = new Configuracion();
            FitnessFunction funcionFitness = new FuncionAptitud(crearMatriz(sudoku, 9));
            configuracion.setFitnessFunction(funcionFitness);
            int nroCasillas = 81;
            Gene[] genes = new Gene[nroCasillas];
            for (int i = 0; i < nroCasillas; i++) {
                if (sudoku[i] == 0) {
                    genes[i] = new IntegerGene(configuracion, 1, 9);
                } else {
                    genes[i] = new IntegerGene(configuracion, sudoku[i], sudoku[i]);
                }
            }
            Chromosome ejemploCromosoma = new Chromosome(configuracion, genes);
            configuracion.setSampleChromosome(ejemploCromosoma);
            configuracion.setPopulationSize(10);
            Genotype poblacion = Genotype.randomInitialGenotype(configuracion);
            boolean resuelto = false;
            Sudoku mejorSolucion = null;
            int generacion = 0;
            while (!resuelto) {
                poblacion.evolve();
                IChromosome mejorSolucionHastaAhora = poblacion.getFittestChromosome();
                mejorSolucion = crearSudokuDesdeCromosoma(mejorSolucionHastaAhora);
                generacion++;
                areaDeTexto.append("Generacion " + generacion + "\n");
                areaDeTexto.append("filas(" + mejorSolucion.numeroRepeticionesFilas() + ") columnas(" + mejorSolucion.numeroRepeticionesColumnas() + ") cuadrados(" + mejorSolucion.numeroRepeticionesCuadrados() + ")\n");
                areaDeTexto.append("Fitness: " + mejorSolucionHastaAhora.getFitnessValue() + "\n\n");
                areaDeTexto.setCaretPosition(areaDeTexto.getDocument().getLength());
                if (mejorSolucion.numeroRepeticionesCuadrados() == 81 && mejorSolucion.numeroRepeticionesFilas() == 81 && mejorSolucion.numeroRepeticionesColumnas() == 81) {
                    resuelto = true;
                }
            }
            if (mejorSolucion != null) {
                mejorSolucion.mostrar(cajas);
            }
        } catch (Exception e) {
        }
    }

    public static Sudoku crearSudokuDesdeCromosoma(IChromosome cromosoma) {
        int nroCasillas = 81;
        int[] genes = new int[nroCasillas];
        for (int i = 0; i < nroCasillas; i++) {
            genes[i] = (Integer) cromosoma.getGene(i).getAllele();
        }
        return new Sudoku(crearMatriz(genes, 9));
    }

    public static int[][] crearMatriz(int[] vector, int n) {
        int[][] matriz = new int[n][n];
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < n * n; i++) {
            matriz[fila][columna] = vector[i];
            columna++;
            if (columna == n) {
                columna = 0;
                fila++;
            }
        }
        return matriz;
    }
}
