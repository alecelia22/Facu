package ar.com.facu.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class FechasUtil {

	// Milisegundos al día
	public final static Long MILISEGS_POR_DAY = new Long(24 * 60 * 60 * 1000);

	/**
	 * Devuelvo la cantidad de dias para el mes
	 */
	public final static Integer totalDeDias(Integer periodo) {
		Integer diasMes = null;
		Integer dia = new Integer(periodo.toString().substring(4, 6));

		switch (dia) {
			case 1: diasMes = 31; break;
			case 3: diasMes = 31; break;
			case 5: diasMes = 31; break;
			case 7: diasMes = 31; break;
			case 8: diasMes = 31; break;
			case 10: diasMes = 31; break;
			case 12: diasMes = 31; break;

			case 4: diasMes = 30; break;
			case 6: diasMes = 30; break;
			case 9: diasMes = 30; break;
			case 11: diasMes = 30; break;

			case 2: {
					int ano = new Integer(periodo.toString().substring(0, 4));
					if ((ano % 4) == 0) {
						diasMes = 29;
					} else {
						diasMes = 28;
					}
				}
				break;
		}

		return diasMes;
	}

	/**
	 * Devuelvo true, si la fecha esta entre desde y hasta.
	 */
	public final static boolean estaEntre(Date fecha, Date desde, Date hasta) {
		// La fecha es igual al primer o ultimo dia o esta en el medio
		if (fecha.equals(desde) || fecha.equals(hasta) || 
				(fecha.after(desde) && fecha.before(hasta))) {
			return true;
		}

		return false;
	}

	/**
	 * Calculo la cantidad de años entre 2 fechas
	 */
	public static BigDecimal anosEntre(Date fechaDesde, Date fechaHasta) {
		// Cantidad de dias entre las 2 fechas
		Long diasDif = (fechaHasta.getTime() - fechaDesde.getTime()) / FechasUtil.MILISEGS_POR_DAY;
		// Divido en 365 para saver la cantidad de años
		Long anos = diasDif / 365;

		// Lo transformo en un Bigdecimal
		return new BigDecimal(anos.intValue());
	}

	/**
	 * Tomo el periodo de una fecha.
	 */
	public static Integer fechaAPeriodo(Date fecha) {
		// Transformo el date en un Calendar
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha);
	    int ano = calendar.get(Calendar.YEAR);
	    int mes = calendar.get(Calendar.MONTH) + 1;

	    // Armo el periodo a retornar 
	    return (ano * 100) + mes;
	}
}
