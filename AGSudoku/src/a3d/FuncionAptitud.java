package a3d;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 * Clase FuncionAptitud
 * @author Daniel Alvarez (a3dany)
 */
public class FuncionAptitud extends FitnessFunction {

    private Sudoku sudoku;

    public FuncionAptitud(int[][] sudoku) {
        this.sudoku = new Sudoku(sudoku);
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        double fitness = 0;
        Sudoku S = Solucion.crearSudokuDesdeCromosoma(cromosoma);
        //fitness += S.numeroRepeticionesCuadrados();
        fitness += S.numeroRepeticionesFilas();
        fitness += S.numeroRepeticionesColumnas();
        return fitness;
    }
}
