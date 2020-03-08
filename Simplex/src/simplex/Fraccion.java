package simplex;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int n) {
        numerador = n;
        denominador = 1;
    }

    public Fraccion(int n, int d) {
        numerador = n;
        denominador = d;
    }

    public Fraccion getInv() {
        Fraccion y;
        if (numerador < 0) {
            y = new Fraccion((-1) * denominador, (-1) * numerador);
        } else {
            y = new Fraccion(denominador, numerador);
        }
        return y;
    }

    public Fraccion sumar(Fraccion X) {
        Fraccion S = new Fraccion(numerador * X.denominador + X.numerador * denominador, denominador * X.denominador);
        S.simplificar();
        return S;
    }

    public Fraccion multiplicar(Fraccion X) {
        Fraccion M = new Fraccion(numerador * X.numerador, denominador * X.denominador);
        M.simplificar();
        return M;
    }

    public Fraccion multiplicar(int x) {
        Fraccion M = new Fraccion(numerador * x, denominador);
        M.simplificar();
        return M;
    }

    public void simplificar() {
        int mcd = mcd(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }
    }

    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    public double getValor() {
        return (double) numerador / (double) denominador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }
}
