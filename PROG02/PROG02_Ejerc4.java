/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

import java.util.Scanner;

/**
 * Dada una edad mostrar si es mayor de edad.
 * @author Raúl Vañes
 */
public class PROG02_Ejerc4 {
    public static void main(String[] args){
        
        /*
         * Pedimos al usuario que introduzca la edad
         * Aunque he utilizado un tipo short para la edad
         * probablemente con un tipo byte hubiera sido suficiente,
         * pero si en un futuro alguien vive más de 127, el programa funcionaría.
        */
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        short edad=entrada.nextShort();

        /*
         * Usamos el operador condicional ?: Si el valor introducido por el usuario
         * es mayor o igual que 18 devolverá la cadena Sí, de lo contrario devolverá NO.
        */
        System.out.printf("Mayor de edad: %s\n", edad>=18?"SÍ":"NO");
    }
}
