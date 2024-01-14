/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerc5;

import java.util.Scanner;

/**
 * Calcula la división de dos números solicitados por teclado Se pedirán los
 * números hasta que el usuario introduzca -1 en ambos
 *
 * @author Raúl Vañes
 */
public class CalcDiv {

    /**
     * Método principal
     *
     * @param args los parámetros que recibe por consola
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dividendo, divisor, numDiv = 0;
        System.out.println("Para salir introduce -1 como dividendo y como divisor.");
        do {
            System.out.println("Introduce el dividendo: ");
            dividendo = entrada.nextInt();
            System.out.println("Introduce el divisor: ");
            divisor = entrada.nextInt();
            try {
                System.out.printf("%d / %d = %d\n", dividendo, divisor, dividendo / divisor);
                numDiv++;
            } catch (ArithmeticException e) {
                System.out.println("¡El divisor no puede ser igual a 0!");
            }
            System.out.println("");
        } while (dividendo != -1 && divisor != -1);

        System.out.printf("Divisiones realizadas: %d\n", numDiv - 1); //Puesto que la última división es -1/-1 la descontamos.
    }
}
