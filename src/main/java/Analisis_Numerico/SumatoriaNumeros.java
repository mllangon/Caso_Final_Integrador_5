package Analisis_Numerico;

public class SumatoriaNumeros {

    public int sumatoria(int n) {
        if (n == 1) return 1;
        return n + sumatoria(n - 1);
    }
}

