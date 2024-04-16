package Analisis_Numerico;

public class MaximoValor {

    public int encontrarMaximo(int[] datos) {
        return encontrarMaximoRecursivo(datos, 0, datos.length - 1);
    }

    private int encontrarMaximoRecursivo(int[] datos, int inicio, int fin) {
        if (inicio == fin) {
            return datos[inicio];
        }
        int medio = (inicio + fin) / 2;
        int maxIzquierda = encontrarMaximoRecursivo(datos, inicio, medio);
        int maxDerecha = encontrarMaximoRecursivo(datos, medio + 1, fin);
        return Math.max(maxIzquierda, maxDerecha);
    }
}
