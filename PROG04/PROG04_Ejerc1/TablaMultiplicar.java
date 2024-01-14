/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerc1;

import java.util.Scanner;

/**
 * Clase que muestra la tabla de multiplicar de un número menor que 30 dado por
 * el usuario.
 *
 * @author: Raúl Vañes
 *
 */
public class TablaMultiplicar {

    /**
     * Método principal
     *
     * @param args los parámetros que recibe por consola
     */
    public static void main(String[] args) {

        int numero;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un número menor que 30: ");

        numero = entrada.nextInt();

        if (numero < 30) {
            multiplica(numero);
        } else {
            System.out.println("El número debe ser menor de 30");
        }

    }

    /**
     * Muestra por pantalla la tabla de multiplicar usando 3 bucles diferentes
     *
     * @param num Número para generar la tabla de multiplicar
     *
     */
    static void multiplica(int num) {
        System.out.printf("\nTabla de multiplicar del %d con bucle FOR: \n", num);
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d * %d = %d\n", num, i, num * i);
        }

        System.out.printf("\nTabla de multiplicar del %d con bucle WHILE: \n", num);
        int i = 0;
        while (i <= 10) {
            System.out.printf("%d * %d = %d\n", num, i, num * i);
            i++;
        }

        System.out.printf("\nTabla de multiplicar del %d con bucle DO-WHILE: \n", num);
        i = 0; //Reutilizamos la variable i para el siguiente bucle, para ello la volvemos a poner a 0
        do {
            System.out.printf("%d * %d = %d\n", num, i, num * i);
            i++;
        } while (i <= 10);

    }
}
