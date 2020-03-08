package a3d;

import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.InvalidConfigurationException;
import org.jgap.event.EventManager;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.ChromosomePool;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.GABreeder;
import org.jgap.impl.MutationOperator;
import org.jgap.impl.StockRandomGenerator;
import org.jgap.util.ICloneable;

/**
 * Clase Configuracion
 * @author Daniel Alvarez (a3dany)
 */
public class Configuracion extends Configuration implements ICloneable {

    public Configuracion() throws InvalidConfigurationException {
        super("", "");
        setBreeder(new GABreeder());
        setRandomGenerator(new StockRandomGenerator());
        setEventManager(new EventManager());
        BestChromosomesSelector bestChromsSelector = new BestChromosomesSelector(this, 0.95d);
        bestChromsSelector.setDoubletteChromosomesAllowed(true);
        addNaturalSelector(bestChromsSelector, false);
        setMinimumPopSizePercent(0);
        setSelectFromPrevGen(1.0d);
        setKeepPopulationSizeConstant(true);
        setFitnessEvaluator(new DefaultFitnessEvaluator());
        setChromosomePool(new ChromosomePool());
        addGeneticOperator(new CrossoverOperator(this, 100));
        addGeneticOperator(new MutationOperator(this, 35));
        resetProperty("", "");
    }
}
