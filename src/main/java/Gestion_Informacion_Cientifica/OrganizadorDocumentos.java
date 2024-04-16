package Gestion_Informacion_Cientifica;

import java.util.Arrays;

public class OrganizadorDocumentos {

    public String[] ordenarLineas(String texto) {
        String[] lineas = texto.split("\\n");
        Arrays.sort(lineas);
        return lineas;
    }
}
