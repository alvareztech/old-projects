/*Instituto Tecnológico de Sonora
 *
 *Clase perceptron
 *
 *Objetivo: Implementar un perceptron.
 *
 *Autores:
 *César Olea Aguilar 54537
 *David Merino Bazua 52014
 */

public class perceptron {

    float factorAprendizaje;
    float output;
    float[] pesos;
    float error;

    /*Constructor de un perceptron. Recibe un vector de pesos inicial
    y el factor de aprendizaje deseado. Inicializa el error inicial a 1 y
    la salida inicial a 0*/
    public perceptron(float[] pesos, float factorAprendizaje) {
        this.pesos = pesos;
        this.factorAprendizaje = factorAprendizaje;
        this.error = 1f;
        this.output = 0f;
    }

    /*float ouput
     *Entradas: Vector de entradas
     *Salida: Numero flotante despues de la funcion del perceptron
     */
    public float output(float[] entradas) {
        output = 0f;
        for (int i = 0; i < entradas.length; i++) {
            output += pesos[i] * entradas[i];
        }
        output = funcionPerceptron(output);
        return output;
    }

    /*float funcionPerceptron
     *Entradas: Numero flotante
     *Salida: Numero flotante al que se le aplica la funcion del perceptron
     */
    private float funcionPerceptron(float o) {
        if (o <= 0) {
            return 0;
        } else if (o > 0) {
            return 1;
        }
        return o;
    }

    /*float error
     *Entradas: Numero flotante que representa la salida deseada
     *Salida: Numero flotante que representa el factor de error causado
     *por la salida deseada y la salida actual
     */
    public float error(float salidaDeseada) {
        error = salidaDeseada - output;
        return error;
    }

    /*void calculaPesos
     *Entradas: vector con las entradas actuales
     *Salida: Ninguna
     *Proposito: recalcular los pesos de acuerdo a las entradas actuales, el factor
     *de aprendizaje, los pesos actuales y el factor de error actual.
     */
    public void calculaPesos(float[] entradas) {
        if (error != 0) {
            for (int i = 0; i < entradas.length; i++) {
                this.pesos[i] = (factorAprendizaje * error) * entradas[i] + pesos[i];
            }
        }
    }

    /*float[] execute
     *Entradas: Matriz de entradas
     *Salida: vector de resultados
     *Proposito: Una vez entrenado el perceptron, ejecutar la funcion output del mismo
     *con cada vector que integra a la matriz de entradas para obtener los resultados
     *deseados.
     */
    public float[] execute(float[][] entradas) {
        float[] result = new float[entradas.length];
        for (int i = 0; i < entradas.length; i++) {
            result[i] = output(entradas[i]);
        }
        return result;
    }
}
