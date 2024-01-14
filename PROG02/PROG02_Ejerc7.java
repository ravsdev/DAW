/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

import java.util.Scanner;

/**
 * Programa para resolver una ecuación de primer grado con una incógnita (x)
 * @author Raúl Vañes
 * 
 */
public class PROG02_Ejerc7 {
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        
        double c1,c2,x;
        
        //Obtenemos los valores dados por el usuario
        System.out.print("Introduce el valor para c1: ");
        c1=entrada.nextDouble();
        System.out.print("Introduce el valor para c2: ");
        c2=entrada.nextDouble();
        
        //Resolvemos la ecuación con la fórmula x=-C2/C1
        x=-c2/c1;
        
        //Mostramos por pantalla el resultado de x con 4 decimales
        System.out.printf("Ecuación: %.0fx+%.0f=0%nSolución: x=%.4f%n",c1,c2,x);
    }
}
