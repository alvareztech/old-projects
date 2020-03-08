package a3d;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

/**
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    private static final int[] SUDOKU = {
        0, 0, 6, 4, 2, 8, 0, 0, 0,
        4, 5, 0, 1, 7, 6, 0, 3, 2,
        0, 8, 7, 3, 9, 5, 0, 4, 1,
        0, 9, 3, 5, 8, 0, 7, 0, 0,
        0, 4, 0, 2, 0, 7, 0, 9, 3,
        7, 2, 0, 9, 0, 0, 5, 6, 0,
        5, 6, 8, 0, 3, 4, 2, 0, 9,
        0, 1, 0, 8, 0, 0, 3, 7, 6,
        0, 7, 0, 6, 1, 0, 4, 8, 0
    };
    private static final int[] SUDOKU2 = {
        0, 0, 0, 0, 4, 0, 5, 0, 0,
        0, 0, 5, 0, 0, 0, 0, 8, 0,
        0, 0, 0, 0, 6, 9, 0, 3, 0,
        3, 0, 0, 0, 0, 6, 7, 5, 0,
        0, 0, 0, 0, 3, 0, 4, 0, 2,
        5, 4, 0, 0, 2, 0, 8, 6, 3,
        0, 3, 0, 0, 0, 0, 6, 0, 0,
        9, 0, 8, 0, 0, 0, 0, 4, 7,
        6, 0, 0, 7, 9, 3, 0, 0, 8
    };

    public static void main(String[] args) throws InvalidConfigurationException {
        Ventana V = new Ventana();
        V.setVisible(true);
        //crearAlgotitmoGenetico();
    }



    
}
