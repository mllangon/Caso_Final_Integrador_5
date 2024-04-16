package Analisis_Numerico;

import java.util.ArrayList;
import java.util.List;

public class ListadoNumeros {

    public List<Integer> listarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            return new ArrayList<>();
        }
        List<Integer> lista = listarNumeros(inicio, fin - 1);
        lista.add(fin);
        return lista;
    }
}
