/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerc4;

import java.util.Scanner;

/**
 * Juego en el que el usuario debe adivinar un número aleatorio. El juego
 * mostrará un menú con 3 opciones
 *
 * @author Raúl Vañes
 */
public class AdivinaNum {

    /**
     * Lee la entrada de teclado
     */
    public static final Scanner entrada = new Scanner(System.in);

    /**
     * Número de intentos permitidos
     */
    public static int numInt;

    /**
     * Número máximo aleatorio
     */
    public static int numMax;

    /**
     * Método principal
     *
     * @param args los parámetros que recibe por consola
     */
    public static void main(String[] args) {
        //Configuración por defecto del juego
        numInt = 5;
        numMax = 10;

        System.out.println("#####################");
        System.out.println("# Adivina el número #");
        System.out.println("#####################");
        menu();
    }

    /**
     * Muestra el menú del juego y ejecuta la opción seleccionada
     *
     */
    static void menu() {

        String[] menu = {"1.Configurar", "2.Jugar", "3.Salir"};

        System.out.printf("Intentos: %d Número máximo: %d\n", numInt, numMax);
        System.out.printf("\nElige una opción:\n %s\n %s\n %s\n", menu[0], menu[1], menu[2]);
        int opcion;

        //Controlamos para que sólo acepte 1, 2 o 3
        do {
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    opciones();
                    break;
                case 2:
                    System.out.println("¡Buena suerte!");
                    jugar();
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion < 1 || opcion > 3);
    }

    /**
     * Configura las variables de número de intentos y el número máximo
     * aleatorio generado
     */
    static void opciones() {
        System.out.println("Configuración:");
        System.out.println("--------------");
        System.out.println("Número de intentos permitidos: ");
        do {
            numInt = entrada.nextInt();
            if (numInt < 1) {
                System.out.println("Introduce un número mayor que 0.");
            }
        } while (numInt < 1);
        System.out.println("Número máximo generado: ");
        do {

            numMax = entrada.nextInt();
            if (numMax < 1) {
                System.out.println("Introduce un número mayor que 0.");
            }
        } while (numMax < 1);
        menu();
    }

    /**
     * Motor del juego: Lee los números introducidos por el usuario y los
     * compara con el número aleatorio.
     */
    static void jugar() {
        int numOculto = numAleatorio(numMax);
        int jugador = 0;
        int intento = 0;

        do {
            System.out.printf("\nTe queda(n) %d intento(s)", numInt - intento);
            System.out.println("\nIntroduce un número: ");
            jugador = entrada.nextInt();
            if (jugador > numOculto) {
                System.out.println("El número oculto es menor");
            } else if (jugador < numOculto) {
                System.out.println("El número oculto es mayor");
            }
            intento++;
        } while (intento < numInt && jugador != numOculto);

        if (jugador == numOculto) {
            System.out.printf("¡Has ganado!. Has necesitado %d intentos\n", intento);
        } else {
            System.out.println("¡Perdiste!. Intentos consumidos");
        }

        menu();
    }

    /**
     * Genera un número aleatorio dado un valor máximo
     *
     * @param max El valor máximo con el que generar el número aleatorio
     */
    static int numAleatorio(int max) {
        return (int) Math.floor(Math.random() * max + 1);
    }
}
