package cursojpa.prestamo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//Manejo de fechas
public class DateUtils {
	public static String fechaToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		return sdf.format(date);
	}
	
	public static Date StringToFecha(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date d = null;
		try {
			d = sdf.parse(s);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return d;
	}
}

//ALTER TABLE factura DROP COLUMN fac_fecha;
//ALTER TABLE factura ADD COLUMN fac_fecha timestamp with time zone;