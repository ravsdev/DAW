/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

import java.util.Scanner;

/**
 * Cálculo del tanto por ciento de los alumnos matriculados.
 * @author DAW
 */
public class PROG02_Ejerc8 {
    public static void main(String[] args){
        int alumnosPROG, alumnosED, alumnosBBDD, totalAlumnos;
        
        //Obtenemos por parte del usuario los datos
        Scanner entrada=new Scanner(System.in);
        
        System.out.print("Alumnos matriculados en Programación: ");
        alumnosPROG=entrada.nextInt();
        System.out.print("Alumnos matriculados en Entornos de desarrollo: ");
        alumnosED=entrada.nextInt();
        System.out.print("Alumnos matriculados en Bases de datos: ");
        alumnosBBDD=entrada.nextInt();
        
        //Sumamos el total de alumnos matriculados en los 3 módulos
        totalAlumnos=alumnosPROG+alumnosED+alumnosBBDD;
        
        //Mostramos los resultados por pantalla, usamos una conversión explícita a float y mostramos 1 decimal con %.1f
        System.out.println("\nResultado:");
        System.out.printf("Porcentaje de matriculación en Programación: %.1f%% %n",(float)alumnosPROG/totalAlumnos*100);
        System.out.printf("Porcentaje de matriculación en Entornos de desarrollo: %.1f%% %n",(float)alumnosED/totalAlumnos*100);
        System.out.printf("Porcentaje de matriculación en Bases de datos: %.1f%% %n",(float)alumnosBBDD/totalAlumnos*100);
    }
}
