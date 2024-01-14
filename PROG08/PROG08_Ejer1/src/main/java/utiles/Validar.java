/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.regex.Pattern;

/**
 * Clase utilizada para validar los datos que va introduciendo el usuario.
 *
 * @author Raúl Vañes Sanz
 */
public class Validar {

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
            Termina ($) por una letra.
         */
        String regexp = "(?i)^[XYZ]?[0-9]{7,8}[A-Z]$";
        if (!Pattern.matches(regexp, nif)) {
            throw new Exception("NIF inválido " + nif);
        }
    }

    /**
     * Comprueba el formato de una cuenta bancaria.
     *
     * @param iban
     * @return <code>true</code> si el formato es correcto <code>false</code> si
     * no es correcto
     */
    public static boolean comprobarIBAN(String iban) {
        String regexp = "^ES[0-9]{20}$";
        return Pattern.matches(regexp, iban);
    }

    /**
     * Recibe una cadena de texto y convierte todas las comas en puntos. Lo
     * utilizo para facilitar la entrada de datos, puesto que el usuario puede
     * poner tanto , como . para separar los decimales y el sistema no devolverá
     * error.
     *
     * @param entrada Cadena de entrada
     * @return Cadena de salida modificada las comas por puntos
     */
    public static String validaDecimal(String entrada) {
        return entrada.replace(",", ".");
    }

}
