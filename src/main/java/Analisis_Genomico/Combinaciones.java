package Analisis_Genomico;

public class Combinaciones {

    // Método recursivo para calcular combinaciones
    public int calcularCombinaciones(int n) {
        if (n <= 1) {
            return 1;
        }
        return calcularCombinaciones(n - 1) + calcularCombinaciones(n - 2);
    }
}
