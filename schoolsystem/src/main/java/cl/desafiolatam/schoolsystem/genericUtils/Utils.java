package cl.desafiolatam.schoolsystem.genericUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {
	public static String getJsonString(InputStream io) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(io));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        
        return json;
	}
	
	/*
	 * La fecha debe ser dd-mm-yy
	 */
	public static String getFechaDB(String fecha) throws Exception {
		int dia = 0;
		int mes = 0;
		int anio = 0;
		GregorianCalendar gCalendar = new GregorianCalendar();
		String arrFecha[] = fecha.split("-");
		if(arrFecha.length == 3) {
			dia = Integer.parseInt(arrFecha[0]);
			mes = Integer.parseInt(arrFecha[1]);
			anio = Integer.parseInt(arrFecha[2]);
		}else {
			throw new Exception("Fecha DB inválida");
		}
		gCalendar.set(anio, mes - 1, dia);
		return gCalendar.get(Calendar.YEAR) + "-" + gCalendar.get(Calendar.MONTH) + "-" + gCalendar.get(Calendar.DAY_OF_MONTH);
	}
}
