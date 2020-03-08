/*Instituto Tecnológico de Sonora
 *
 *Programa principal
 *
 *Objetivo: Manejar un perceptron para enseñarle el problema
 *de la función lógica AND.
 *
 *Autores:
 *César Olea Aguilar 54537
 *David Merino Bazua 52014
 */

import java.util.Random;

public class Main {

    public static void main(String args[]) {
        //Matriz de entradas para el perceptron
        float[][] entradas = {
            {1f, 0f, 0f},
            {1f, 0f, 1f},
            {1f, 1f, 0f},
            {1f, 1f, 1f}
        };
        //Vector de salidas para el perceptron
        float[] salidas = {0f, 1f, 1f, 1f};
        //Generacion de pesos iniciales pseudoaleatorios
        Random generator = new Random();
        float[] pesos = {generator.nextFloat(), generator.nextFloat(), generator.nextFloat()};
        System.out.println("Pesos Iniciales");
        for (int i = 0; i < pesos.length; i++) {
            System.out.println(pesos[i]);
        }
        System.out.println();
        //Creacion de un perceptron, pesos definidos en vector pesos
        //y factor de aprendizaje de 0.7
        perceptron p = new perceptron(pesos, 0.7f);
        int contador = 0;           //contador de no error
        int iteraciones = 0;        //contador de iteraciones
        boolean aprendio = true;    //bandera de aprendizaje
        while (contador < 5) {        //Mientras que no aprenda...
            if (iteraciones < 1000) { //Máximo 1000 iteraciones
                for (int i = 0; i <= entradas[0].length; i++) {
                    float output = p.output(entradas[i]);
                    float error = p.error(salidas[i]);
                    System.out.println("Error:\t" + error);
                    if (error != 0f) {      //Si hay error, recalcula los pesos
                        p.calculaPesos(entradas[i]);
                        contador = 0;   //y reinicia el contador de no error
                    } else {
                        contador++;     //si no hay error, incrementa
                    }
                }
            } else {
                //Aqui ya paso de 1000 iteraciones, no aprendio.
                aprendio = false;
                System.out.println("No aprendio.");
                break;  //y por lo tanto, se sale
            }
            iteraciones++;
        }

        /*Para comprobar que el perceptron aprendio, se le manda
        a ejecutar el problema con las entradas definidas 
        anteriormente. El perceptron regresa un vector de resultados
        que se imprimen para verificar que se aprendio correctamente el
        problema.*/
        if (aprendio) {
            float[] resultados = p.execute(entradas);
            imprimeResultados(resultados, p, entradas);
        }
    }

    public static void imprimeResultados(float[] res, perceptron p, float[][] e) {
        System.out.println();
        System.out.println("E0\tE1\tE2\t|\tS0");
        System.out.println("------------------------------------");
        for (int i = 0; i < e.length; i++) {

            for (int j = 0; j < e[0].length; j++) {
                System.out.print(e[i][j] + "\t");
            }
            System.out.print("|\t" + res[i] + "\n");
        }
        System.out.println();
        System.out.println("Pesos finales");
        for (int i = 0; i < p.pesos.length; i++) {
            System.out.println("Peso" + i + "\t" + p.pesos[i]);
        }
    }
}
