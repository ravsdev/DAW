/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

import java.util.Scanner;

/**
 * Dado un año decir si es bisiesto.
 * @author Raúl Vañes
 */
public class PROG02_Ejerc9 {
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        
        int year;
        boolean esBisiesto;
        
        //Pedimos al usuario que introduzca un año
        System.out.print("Introduce un año: ");
        year=entrada.nextInt();
        
        /*
         * La primera opción que se triene que cumplir es que sea divisible por 4, es decir, que el resto sea 0: year%4==0
         * La segunda opción es que no sea divisible entre 100 salvo que lo sea por 400.
         * Por lo tanto nos sirve que no sea divisible por 100 o que lo sea por 400.
         * (year%100!=0 || year%400==0)
        */
        esBisiesto=year%4==0 && (year%100!=0 || year%400==0);
        
        /*
         * Mostramos una sentencia indicando si es año es bisiesto o no
         * Dado que hemos almacenado esBisiesto en un boolean, usamos el operador condicional ?
         * y devolvemos una cadena vacía si es cierto y un no precedido de un espacio si es falso.
        */
        System.out.printf("El año %d%s es bisiesto%n",year,esBisiesto?"":" no");
    }
}
