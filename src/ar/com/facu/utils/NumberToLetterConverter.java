package ar.com.facu.utils;

import java.util.regex.Pattern;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class NumberToLetterConverter {

    private final static String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final static String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final static String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};


    /**
     * Transformo un numero en su representacion en letras
     * @param numero string con formato #,##
     * @return
     */
    public final static String Convertir(String numero) {
        String literal = "";
        String parteDecimal;    
        // Si el numero no tiene parte decimal, se le agrega ,00
        if(numero.indexOf(",") == -1){
            numero = numero + ",00";
        }
        // Se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            // Se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");
            // Da formato al numero decimal
            parteDecimal = " con " + Num[1] + "/100 Centavos.";
            // Se convierte el numero a literal
            // Si el valor es cero
            if (Integer.parseInt(Num[0]) == 0) {
                literal = "cero ";
            // Si es millon
            } else if (Integer.parseInt(Num[0]) > 999999) {
                literal = getMillones(Num[0]);
            // si es miles
            } else if (Integer.parseInt(Num[0]) > 999) {
                literal = getMiles(Num[0]);
            // si es centena
            } else if (Integer.parseInt(Num[0]) > 99) {
                literal = getCentenas(Num[0]);
            // si es decena
            } else if (Integer.parseInt(Num[0]) > 9) {
                literal = getDecenas(Num[0]);
            // Sino unidades -> 9
            } else {
                literal = getUnidades(Num[0]);
            }

            //devuelve el resultado 
            return primerLetraMayuscula(literal + " Pesos " + parteDecimal);
        } else {
        	//error, no se puede convertir
            return literal = null;
        }
    }

    /**
     * Hago un uppercase de la primer letra del string
     */
    private static String primerLetraMayuscula(String string) {
    	return string.substring(0,  1).toUpperCase() + string.substring(1, string.length());
	}

	/* funciones para convertir los numeros a literales */
    private static String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private static String getDecenas(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private static String getCentenas(String num) {// 999 o 099
        if( Integer.parseInt(num)>99 ){//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                 return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            } 
        }else{//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num)+"");            
        }        
    }

    private static String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);           
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }

    }

    private static String getMillones(String numero) { //000 000 000        
        // se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        // se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if(millon.length()>1){
            n = getCentenas(millon) + "millones ";
        }else{
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);        
    }
}