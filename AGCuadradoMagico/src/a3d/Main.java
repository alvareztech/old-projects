package a3d;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 * Clase Main
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] args) throws InvalidConfigurationException {
        Configuration configuracion = new DefaultConfiguration();
        FitnessFunction miFuncion = new FuncionAptitud();
        configuracion.setFitnessFunction(miFuncion);

        Gene[] genes = new Gene[9];
        genes[0] = new IntegerGene(configuracion, 1, 9);
        genes[1] = new IntegerGene(configuracion, 1, 9);
        genes[2] = new IntegerGene(configuracion, 1, 9);
        genes[3] = new IntegerGene(configuracion, 1, 9);
        genes[4] = new IntegerGene(configuracion, 1, 9);
        genes[5] = new IntegerGene(configuracion, 1, 9);
        genes[6] = new IntegerGene(configuracion, 1, 9);
        genes[7] = new IntegerGene(configuracion, 1, 9);
        genes[8] = new IntegerGene(configuracion, 1, 9);

        Chromosome cromosoma = new Chromosome(configuracion, genes);
        configuracion.setSampleChromosome(cromosoma);
        configuracion.setPopulationSize(30);
        Genotype poblacion = Genotype.randomInitialGenotype(configuracion);

        for (int i = 0; i < 600; i++) {
            poblacion.evolve();
//            System.out.println(" Generacion " + i);
//            IChromosome mejorIndividuo = poblacion.getFittestChromosome();
//            mostrarCuadrado(mejorIndividuo);
//            System.out.println(" Valor: " + mejorIndividuo.getFitnessValue());
        }
        System.out.println("--------------------------------------------");
        IChromosome mejorIndividuoFinal = poblacion.getFittestChromosome();
        mostrarCuadrado(mejorIndividuoFinal);
        System.out.println(" Valor: " + mejorIndividuoFinal.getFitnessValue());
        
    }

    private static void mostrarCuadrado(IChromosome ic) {
        Integer c1 = (Integer) ic.getGene(0).getAllele();
        Integer c2 = (Integer) ic.getGene(1).getAllele();
        Integer c3 = (Integer) ic.getGene(2).getAllele();
        Integer c4 = (Integer) ic.getGene(3).getAllele();
        Integer c5 = (Integer) ic.getGene(4).getAllele();
        Integer c6 = (Integer) ic.getGene(5).getAllele();
        Integer c7 = (Integer) ic.getGene(6).getAllele();
        Integer c8 = (Integer) ic.getGene(7).getAllele();
        Integer c9 = (Integer) ic.getGene(8).getAllele();
        System.out.println(" " + c1 + " " + c2 + " " + c3);
        System.out.println(" " + c4 + " " + c5 + " " + c6);
        System.out.println(" " + c7 + " " + c8 + " " + c9);
    }
}
