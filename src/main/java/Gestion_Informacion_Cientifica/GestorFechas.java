package Gestion_Informacion_Cientifica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestorFechas {

    private List<Date> fechas = new ArrayList<>();

    public void agregarFecha(String fecha) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(fecha);
        fechas.add(date);
        Collections.sort(fechas);
    }

    public List<String> obtenerFechas() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<String> fechasFormato = new ArrayList<>();
        for (Date fecha : fechas) {
            fechasFormato.add(sdf.format(fecha));
        }
        return fechasFormato;
    }
}
