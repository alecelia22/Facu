package ar.com.facu.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formateador {
	// Formateador de fechas
	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	// Formateador de decimales
	private static DecimalFormat formatDecimal = new DecimalFormat("#,##0.00");

	/**
	 * Tomo un bigdecimal y devuelvo un string con formato #.###,##
	 */
	public static String formatNumero(BigDecimal valor) {
		if (valor != null) {
			return formatDecimal.format(valor);
		} else {
			return null;
		}
	}

	/**
	 * Formateo una fecha
	 */
	public static String formatFecha(Date fecha) {
		if (fecha != null) {
			return formatDate.format(fecha);	
		} else {
			return null;
		}
	}

	/**
	 * Tomo un cuit o cuil y lo retorno con el formato 00-00000000-0
	 */
	public static String formatCuit(Long cuit) {
		// Convierto el dato en un string
		String cuitString = cuit.toString();
		// Formateo el cuit o cuil
		return cuitString.substring(0,2) + "-" + cuitString.substring(2,10) + "-" + cuitString.substring(10,11);
	}

	/**
	 * Transformo un string en un en un Date
	 */
	public static Date stringAFecha(String fecha) throws ParseException {
		if (fecha != null) {
			return formatDate.parse(fecha);
		} else { 
			return null;	
		}
	}

	/**
	 * Transformo un string en un en un BigDecimal
	 */
	public static BigDecimal stringABigDecimal(String numeroDecimal) throws ParseException {
		if (numeroDecimal != null) {
 			// Formateo el importe de string a numero
 			DecimalFormat formatter = new DecimalFormat("#,##0.00");
 			Number number = formatter.parse(numeroDecimal);

			return new BigDecimal(number.doubleValue());
		} else { 
			return null;	
		}
	}
}
