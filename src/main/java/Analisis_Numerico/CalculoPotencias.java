package Analisis_Numerico;

public class CalculoPotencias {

    public int calcularPotencia(int base, int exponente) {
        if (exponente == 0) return 1;
        return base * calcularPotencia(base, exponente - 1);
    }
}
