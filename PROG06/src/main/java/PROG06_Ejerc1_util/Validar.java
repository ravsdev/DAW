/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG06_Ejerc1_util;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Clase con métodos estáticos para validar los datos de los vehículos.
 *
 * @author Raúl Vañes Sanz
 */
public class Validar {

    /**
     * Comprueba si la fecha es anterior a la actual
     *
     * @param fecha fecha a comprobar
     * @return <code>true</code> si la fecha es anterior <code>false</code> si
     * no lo es
     */
    public static boolean comprobarFecha(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }

    /**
     * Comprueba si los kilómetros son mayor que 0
     *
     * @param numero número de kilómetros
     * @return <code>true</code> si el número es mayor que 0 <code>false</code>
     * si no lo es
     */
    public static boolean comprobarKms(int numero) {
        return numero > 0;
    }

    /**
     * Comprueba si los kilómetros del parámetro kmsNuevo son mayores a los del
     * paramétro kmsActual. Utilizamos la sobrcarga de métodos puesto que
     * podemos comprobar los kilómetros si ya hay kilómetros existentes.
     *
     * @param kmsActual kilómetros actuales del vehículo
     * @param kmsNuevo actualización de los kilómetros
     * @return <code>true</code> si los kilómetros nuevos son mayores que los
     * actuales <code>false</code> si no lo son
     */
    public static boolean comprobarKms(int kmsActual, int kmsNuevo) {
        return kmsNuevo > kmsActual;
    }

    /**
     * Verifica el NIF introducido
     *
     * @param nif cadena de texto con el DNI y la letra
     * @throws Exception
     */
    public static void comprobarNIF(String nif) throws Exception {
        /*
            Utilizamos una expresión regular para comprobar el formato.
            Para la expresión regular me he basado en la información:
            https://es.wikipedia.org/wiki/N%C3%BAmero_de_identificaci%C3%B3n_fiscal
            Puesto que sólo comprobamos el formato y no la letra usamos una expresión regular simple
            para comprobar tanto DNI como NIE
            No diferenciamos entre mayúsculas y minúsculas (?i)
            Puede empezar (^) por la letra X, Y o Z [XYZ]?
            Seguido de 7 u 8 números [0-9]{7,8}
            Termina ($) por una letra [A-Z].
         */
        String regexp = "(?i)^[XYZ]?[0-9]{7,8}[A-Z]$";
        if (!Pattern.matches(regexp, nif)) {
            throw new Exception("NIF inválido " + nif);
        }
    }

    /**
     * Comprueba si una matrícula cumple con el formato NNNNLLL, donde NNNN es
     * un número entre 0000 y 9999 y LLL son letras mayúsculas.
     *
     * @param matricula matricula a comprobar
     * @return <code>true</code> si la matrícula cumple el formato
     * <code>false</code> si no cumple con el formato
     */
    public static boolean comprobarMatricula(String matricula) {
        /*
            Explicación de la expresión regular:
            Empieza(^) por cuatro números del 0 al 9 [0-9]{4}
            Y termina ($) por 3 letras mayúsculas [A-Z]{3}
         */
        String regexp = "^[0-9]{4}[A-Z]{3}$";
        return Pattern.matches(regexp, matricula);
    }

    /**
     * Comprueba si el nombre completo consta de nombre y 2 apellidos y la
     * longitud no es superior a 40 carácteres.
     *
     * @param nombre nombre a comprobar
     * @return <code>true</code> si el nombre completo cumple las condiciones.
     * <code>false</code> si no cumple las condiciones.
     */
    public static boolean comprobarNombre(String nombre) {
        /*
        Divido el String a partir de los espacios, si obtengo un array de longitud 3
        significa que el usuario ha introducido un nombre y dos apellidos.
        También compruebo que la longitud total del String no sea superior a 40 carácteres.
         */
        return nombre.split(" ").length == 3 && nombre.length() <= 40;
    }

}
