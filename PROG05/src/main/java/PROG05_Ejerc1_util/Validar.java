/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1_util;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Clase con métodos estáticos para validar los datos del programa Vehículo
 * @author Raúl Vañes Sanz
 */
public class Validar {
    private static final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";
    
    /**
     * Comprueba si la fecha es anterior a la actual
     * @param fecha fecha a comprobar
     * @return <code>true</code> si la fecha es anterior
     *         <code>false</code> si no lo es
     */
    public static boolean comprobarFecha(LocalDate fecha){
        return fecha.isBefore(LocalDate.now());
    }

    /**
     * Comprueba si los kilómetros son mayor que 0
     * @param numero número de kilómetros
     * @return <code>true</code> si el número es mayor que 0
     *         <code>false</code> si no lo es
     */
    public static boolean comprobarKms(int numero){
        return numero > 0;
    }

    /**
     * Comprueba si los kilómetros del parámetro kmsNuevo son mayores
     * a los del paramétro kmsActual.
     * Utilizamos la sobrcarga de métodos puesto que podemos comprobar los kilómetros
     * si ya hay kilómetros existentes.
     * @param kmsActual kilómetros actuales del vehículo
     * @param kmsNuevo actualización de los kilómetros
     * @return <code>true</code> si los kilómetros nuevos son mayores que los actuales
     *         <code>false</code> si no lo son
     */
    public static boolean comprobarKms(int kmsActual,int kmsNuevo){
        return kmsNuevo > kmsActual;
    }

    /**
     * Verifica el NIF introducido
     * @param nif cadena de texto con el DNI y la letra
     * @throws Exception 
     */
    public static void comprobarNIF(String nif) throws Exception{
        int numero=extraerNumeroNIF(nif);
        char letra=Character.toLowerCase(extraerLetraNIF(nif));
        char letraCalculada=Character.toLowerCase(calcularLetraNIF(numero));
        
        /*
         * Utilizamos una expresión regular para comprobar el formato y además comprobamos
         * que la letra es válida para el número de DNI
        */
        String regexp = "(?i)[0-9]{7,8}["+LETRAS_DNI+"]";
        if(!Pattern.matches(regexp, nif) || letra!=letraCalculada) throw new Exception("NIF inválido "+nif); 
    }

    /**
     * Extrae la letra del NIF de una cadena de texto.
     * Método privado puesto que sólo es utilizado como método auxiliar
     * dentro de esta clase.
     * @param nif cadena de texto con el número de DNI y la letra
     * @return letra del NIF
     */
    private static char extraerLetraNIF (String nif) {
        char letra=   nif.charAt(nif.length()-1);
        return letra;
    }

    /**
     * Extrae el número del DNI.
     * Método privado puesto que sólo es utilizado como método auxiliar
     * dentro de esta clase.
     * @param nif cadena de texto con el número de DNI y la letra
     * @return número del DNI
     */
    private static int extraerNumeroNIF (String nif) {
        int numero= Integer.parseInt(nif.substring(0, nif.length()-1));
        return numero;
    }

    /**
     * Calcula la letra del NIF a partir de un número de DNI.
     * Método privado puesto que sólo es utilizado como método auxiliar
     * dentro de esta clase.
     * @param dni número de DNI
     * @return letra calculada del DNI
     */
    private static char calcularLetraNIF (int dni) {
        char letra;

        // Cálculo de la letra NIF
        letra= LETRAS_DNI.charAt(dni % 23);       

        return letra;
    }
}
