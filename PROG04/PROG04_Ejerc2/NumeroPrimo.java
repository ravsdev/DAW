/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerc2;

import java.util.Scanner;

/**
 * Lee 5 números de teclado y nos indica si es primo o no, para los negativos
 * muestra mensaje de número negativo
 *
 * @author: Raúl Vañes
 */
public class NumeroPrimo {

    /**
     * Método principal
     *
     * @param args los parámetros que recibe por consola
     */
    public static void main(String[] args) {
        int numero, i = 0;
        Scanner entrada = new Scanner(System.in);

        while (i < 5) {
            System.out.println("Por favor, introduce un número: ");
            numero = entrada.nextInt();

            if (numero > 0) {
                System.out.printf("El número %d %s primo\n", numero, esPrimo(numero) ? "es" : "no es");
            } else {
                System.out.println("El número es negativo");
            }
            System.out.println();
            i++;
        }
    }

    /**
     * Comprueba si un número positivo dado es primo o no
     *
     * @param numero Número a comprobar
     * @return <code>true</code> si no es divisible por otro número que no sea
     * él mismo o 1 <code>false</code> si es divisible por otro número
     *
     */
    static boolean esPrimo(int numero) {

        boolean primo = true; //Por defecto consideramos al número como primo

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                primo = false;
                break; //Si encontramos un número que lo divida salimos del bucle puesto que no es necesario seguir buscando.
            }
        }
        return primo;
    }
}
