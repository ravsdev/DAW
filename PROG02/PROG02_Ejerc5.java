/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

import java.util.Scanner;

/**
 * Dado un número de segundos mostramos en pantalla cuántos minutos,horas y días contiene.
 * @author Raúl Vañes
 */
public class PROG02_Ejerc5 {
    public static void main(String[] args){
        
        final int MINUTO=60; //Segundos contenidos en un minuto
        final int HORA=60*MINUTO; //Segundos contenidos en una hora
        final int DIA=HORA*24; //Segundos contenidos en un día
        
        Scanner entrada= new Scanner(System.in);
        
        System.out.print("Introduce el número de segundos: ");
        
        double segs=entrada.nextDouble();
        
        /*
        * Puesto que es un programa muy sencillo no crearé variables para almacenar el resultado de las operaciones.
        * - Primeramente para obtener los días dividimos los segundos introducidos entre los segundo que hay en un día (60*60*24=86400).
        *   He optado por convertir los días a tipo long para que no haya problemas si introducimos una cifra de segundos muy alta.
        * - Para obtener las horas dividimos los segundos entre la constante HORA (60*60) y sólo nos quedamos con el resto de la división entre 24
        *   ya que 24horas = 1 día y los días ya los hemos calculado.
        * - Para los minutos hacemos lo mismo, dividimos entre 60 y de ahí sólo nos quedamos con el resto entre 60 para que nos dé los minutos.
        * - Finalmente para los segundos nos quedamos con el resto de la división de los segundos y 60 que sería 1 minuto.
        */
        
        System.out.printf("%d dia(s), %d hora(s), %d minuto(s), %d segundo(s)%n",(long)segs/DIA,(int)segs/HORA%24,(int)segs/MINUTO%60,(int)segs%MINUTO);
    }
}
