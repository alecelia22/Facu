package ar.com.facu.utils;

public class PeriodoFormateador {

	/**
	 * Transformo un periodo en su nombre de mes + el año.
	 */
	public static String obtenerDescripcionPeriodo(Integer idPeriodo) {
		// Tomo el mes del periodo
		Integer mes = new Integer(idPeriodo.toString().substring(4,6));
		// Tomo el año del periodo
		Integer ano = new Integer(idPeriodo.toString().substring(0, 4));

		// Transformo el numero de mes, en una letras
		String periodoLetra = mesEnLetras(mes);
		// le agrego el año
		return periodoLetra + " " + ano;
	}

	/**
	 * Transformo un periodo en numero en su equivalente en letras.
	 */
	private static String mesEnLetras(Integer mes) {
		String mesLetra = null;

		switch (mes) {
			case 1: mesLetra = "Enero"; break;
			case 2: mesLetra = "Febrero"; break;
			case 3: mesLetra = "Marzo"; break;
			case 4: mesLetra = "Abril"; break;
			case 5: mesLetra = "Mayo"; break;
			case 6: mesLetra = "Junio"; break;
			case 7: mesLetra = "Julio"; break;
			case 8: mesLetra = "Agosto"; break;
			case 9: mesLetra = "Septiembre"; break;
			case 10: mesLetra = "Octubre"; break;
			case 11: mesLetra = "Noviembre"; break;
			case 12: mesLetra = "Diciembre"; break;
		}

		return mesLetra;
	}

	/**
	 * Calculo el periodo anterior al pasado por parametro.
	 */
	public static Integer calcularPeriodoAnterior(Integer idPeriodoActual) {
		// Tomo el periodo actual -1
		Integer periodoAnterior = idPeriodoActual -1;

		// Si termina en 00, entonces paso a diciembre del año pasado
		if (periodoAnterior.toString().subSequence(4, 6).equals("00")) {
			periodoAnterior -= 88;
		}

		return periodoAnterior;
	}
}
