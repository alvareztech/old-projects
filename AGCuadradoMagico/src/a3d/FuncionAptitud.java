package a3d;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 * Clase FuncionAptitud
 * @author Daniel Alvarez (a3dany)
 */
public class FuncionAptitud extends FitnessFunction {

    private double fitness;

    public FuncionAptitud() {
        this.fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome ic) {
        evaluarHorizontal1(ic);
        evaluarHorizontal2(ic);
        evaluarHorizontal3(ic);
        evaluarVertical1(ic);
        evaluarVertical2(ic);
        evaluarVertical3(ic);
        evaluarDiagonalPrincipal(ic);
        evaluarDiagonalSecundaria(ic);
        verificarRepetidos(ic);
        return fitness;
    }

    private void evaluarHorizontal1(IChromosome ic) {
        int c1 = (int) ic.getGene(0).getAllele();
        int c2 = (int) ic.getGene(1).getAllele();
        int c3 = (int) ic.getGene(2).getAllele();
        if (c1 + c2 + c3 == 15) {
            fitness += 15;
        }
    }

    private void evaluarHorizontal2(IChromosome ic) {
        int c4 = (int) ic.getGene(3).getAllele();
        int c5 = (int) ic.getGene(4).getAllele();
        int c6 = (int) ic.getGene(5).getAllele();
        if (c4 + c5 + c6 == 15) {
            fitness += 15;
        }
    }

    private void evaluarHorizontal3(IChromosome ic) {
        int c7 = (int) ic.getGene(6).getAllele();
        int c8 = (int) ic.getGene(7).getAllele();
        int c9 = (int) ic.getGene(8).getAllele();
        if (c7 + c8 + c9 == 15) {
            fitness += 15;
        }
    }

    private void evaluarVertical1(IChromosome ic) {
        int c1 = (int) ic.getGene(0).getAllele();
        int c4 = (int) ic.getGene(3).getAllele();
        int c7 = (int) ic.getGene(6).getAllele();
        if (c1 + c4 + c7 == 15) {
            fitness += 15;
        }
    }

    private void evaluarVertical2(IChromosome ic) {
        int c2 = (int) ic.getGene(1).getAllele();
        int c5 = (int) ic.getGene(4).getAllele();
        int c8 = (int) ic.getGene(7).getAllele();
        if (c2 + c5 + c8 == 15) {
            fitness += 15;
        }
    }

    private void evaluarVertical3(IChromosome ic) {
        int c3 = (int) ic.getGene(2).getAllele();
        int c6 = (int) ic.getGene(5).getAllele();
        int c9 = (int) ic.getGene(8).getAllele();
        if (c3 + c6 + c9 == 15) {
            fitness += 15;
        }
    }

    private void evaluarDiagonalPrincipal(IChromosome ic) {
        int c1 = (int) ic.getGene(0).getAllele();
        int c5 = (int) ic.getGene(4).getAllele();
        int c9 = (int) ic.getGene(8).getAllele();
        if (c1 + c5 + c9 == 15) {
            fitness += 15;
        }
    }

    private void evaluarDiagonalSecundaria(IChromosome ic) {
        int c3 = (int) ic.getGene(2).getAllele();
        int c5 = (int) ic.getGene(4).getAllele();
        int c7 = (int) ic.getGene(6).getAllele();
        if (c3 + c5 + c7 == 15) {
            fitness += 15;
        }
    }

    private void verificarRepetidos(IChromosome ic) {
        Integer c1 = (Integer) ic.getGene(0).getAllele();
        Integer c2 = (Integer) ic.getGene(1).getAllele();
        Integer c3 = (Integer) ic.getGene(2).getAllele();
        Integer c4 = (Integer) ic.getGene(3).getAllele();
        Integer c5 = (Integer) ic.getGene(4).getAllele();
        Integer c6 = (Integer) ic.getGene(5).getAllele();
        Integer c7 = (Integer) ic.getGene(6).getAllele();
        Integer c8 = (Integer) ic.getGene(7).getAllele();
        Integer c9 = (Integer) ic.getGene(8).getAllele();
        if ((c1 != c2) && (c1 != c3) && (c1 != c4) && (c1 != c5) && (c1 != c6) && (c1 != c7) && (c1 != c8) && (c1 != c9)) {
            fitness += 5;
        }
        if ((c2 != c1) && (c2 != c3) && (c2 != c4) && (c2 != c5) && (c2 != c6) && (c2 != c7) && (c2 != c8) && (c2 != c9)) {
            fitness += 5;
        }
        if ((c3 != c2) && (c3 != c1) && (c3 != c4) && (c3 != c5) && (c3 != c6) && (c3 != c7) && (c3 != c8) && (c3 != c9)) {
            fitness += 5;
        }
        if ((c4 != c2) && (c4 != c3) && (c4 != c1) && (c4 != c5) && (c4 != c6) && (c4 != c7) && (c4 != c8) && (c4 != c9)) {
            fitness += 5;
        }
        if ((c5 != c2) && (c5 != c3) && (c5 != c4) && (c5 != c1) && (c5 != c6) && (c5 != c7) && (c5 != c8) && (c5 != c9)) {
            fitness += 5;
        }
        if ((c6 != c2) && (c6 != c3) && (c6 != c4) && (c6 != c5) && (c6 != c1) && (c6 != c7) && (c6 != c8) && (c6 != c9)) {
            fitness += 5;
        }
        if ((c7 != c2) && (c7 != c3) && (c7 != c4) && (c7 != c5) && (c7 != c6) && (c7 != c1) && (c7 != c8) && (c7 != c9)) {
            fitness += 5;
        }
        if ((c8 != c2) && (c8 != c3) && (c8 != c4) && (c8 != c5) && (c8 != c6) && (c8 != c7) && (c8 != c1) && (c8 != c9)) {
            fitness += 5;
        }
        if ((c9 != c2) && (c9 != c3) && (c9 != c4) && (c9 != c5) && (c9 != c6) && (c9 != c7) && (c9 != c8) && (c9 != c1)) {
            fitness += 5;
        }
    }
}
