package Gestion_Informacion_Cientifica;

import java.util.Arrays;

public class BusquedaTexto {

    // Búsqueda lineal
    public boolean buscarLineal(String[] texto, String palabra) {
        for (String linea : texto) {
            if (linea.contains(palabra)) {
                return true;
            }
        }
        return false;
    }

    // Búsqueda binaria, asumiendo que el texto está ordenado
    public boolean buscarBinaria(String[] texto, String palabra) {
        int izquierda = 0, derecha = texto.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (texto[medio].compareTo(palabra) == 0) {
                return true;
            } else if (texto[medio].compareTo(palabra) < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return false;
    }
}
