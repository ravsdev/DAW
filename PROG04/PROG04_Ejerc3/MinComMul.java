/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerc3;

import java.util.Scanner;

/**
 * Se pide al usuario 2 números y se calcula el Mínimo Común Múltiplo
 *
 * @author Raúl Vañes
 *
 */
public class MinComMul {

    /**
     * Método principal
     *
     * @param args los parámetros que recibe por consola
     */
    public static void main(String[] args) {
        int num1, num2;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe el primer número: ");
        num1 = entrada.nextInt();
        System.out.println("Escribe el segundo número: ");
        num2 = entrada.nextInt();
        System.out.printf("El mínimo común múltiplo de %d y %d es %d", num1, num2, mcm(num1, num2));
    }

    /**
     * Devuelve el mínimo común múltiplo de 2 números Para ello utilizamos la
     * fórmula MCM(a, b) = (a * b) / MCD(a, b)
     *
     * @param num1 Primer número recibido
     * @param num2 Segundo número recibido
     */
    static int mcm(int num1, int num2) {
        return num1 * num2 / mcd(num1, num2);
    }

    /**
     * Devuelve el máximo común divisor utilizando el algoritmo de Euclides.
     *
     * @param num1 Primer número recibido
     * @param num2 Segundo número recibido
     */
    static int mcd(int num1, int num2) {
        /*
            - Se divide el número mayor entre el menor.
            - Si la división es exacta, el divisor es el m.c.d.
            - Si la división no es exacta, dividimos el divisor entre el resto obtenido
              y continuamos de esta forma hasta obtener una división exacta.
              El m.c.d. es el último divisor.
         */

        //Obtenemos el mayor y el menor de los 2 números
        int dividendo = Math.max(num1, num2);
        int divisor = Math.min(num1, num2);
        int resto = 0;
        int resultado = 0;

        do {
            resultado = divisor;
            resto = dividendo % divisor;
            dividendo = divisor;
            divisor = resto;
        } while (resto != 0);

        /*
            Podríamos ahorrárnos una variable con el siguiente código:
            while(divisor!=0)
            {
              resultado=divisor;
              divisor=dividendo%divisor;
              dividendo=resultado;

            }
         */
        return resultado;
    }
}
