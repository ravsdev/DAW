/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

/**
 * Práctica con enumerados
 * @author Raúl Vañes
 */
public class PROG02_Ejerc6 {
    //La declaración de un Enum deberemos hacerla siempre fuera de los métodos, en este caso dentro de la misma clase.
    enum Razas{MASTIN,TERRIER,BULLDOG,PEKINES,CANICHE,GALGO};
    
    public static void main(String[] args){
        //Creamos las variables var1 y var y les asignamos un valor.
        Razas var1=Razas.CANICHE;
        Razas var2=Razas.TERRIER;
        
        /*
        * Hacemos la comparación de las dos variables mediante el operador ==
        * Así como también mediante el método equals que nos devuelve un valor boolean.
        */
        System.out.println("Comparación var1==var2: "+(var1==var2));
        System.out.println("Comparación usando el método equals, var1.equals(var2): "+(var1.equals(var2)));
        
        //Para obtener la posición que ocupa un determinado valor usamos el método ordinal 
        System.out.println("Posición de la variable var1: "+var1.ordinal());
        System.out.println("Posición de la variable var2: "+var2.ordinal());
        
        /* 
        * Para obtener la cantidad de valores que contiene usamos el método values para obtener los valores
        * y después length para obtener la cantidad.
        */
        System.out.println("Cantidad de valores del enumarado Razas: "+Razas.values().length);
    }
}
