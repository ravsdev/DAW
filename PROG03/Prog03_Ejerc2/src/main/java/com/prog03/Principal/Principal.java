/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog03.Principal;

//Importamos la clase Rectangulo del paquete com.prog03.figuras
import com.prog03.figuras.Rectangulo;

/**
 *
 * @author Raúl Vañes
 */

public class Principal {
    public static void main(String args[]){
        //Creamos un nuevo objeto con el constructor sin parámetros
        Rectangulo rect1=new Rectangulo();
        
        //Mostramos por pantalla su funcionamiento
        System.out.println("Rectángulo rect1");
        //Comprobamos cómo se inicializa sin parámetros
        System.out.println(rect1.toString());
        
        System.out.println("Modificamos los valores:");
        //Utilizamos los métodos del objeto para modificar sus atributos
        rect1.setBase(4F);
        rect1.setAltura(4F);
                
        //Utilizamos el método toString para obtener una cadena con el área y la altura
        System.out.println(rect1.toString());
        System.out.printf("La base es %.1f\n",rect1.getBase());
        System.out.printf("%s un rectángulo cuadrado.\n",rect1.isCuadrado()?"Es":"No es");
        
        //Creamos otro objeto, esta vez con parámetros
        Rectangulo rect2=new Rectangulo(14.2F,8.1F);
        
        //Mostramos información usando los diferentes métodos de la clase Rectangulo
        System.out.println("- - -");
        System.out.println("Rectángulo rect2");
        System.out.printf("Área: %.2f. Altura %.2f\n",rect2.getArea(),rect2.getAltura());
        System.out.printf("La base es %.2f\n",rect2.getBase());
        System.out.printf("%s un rectángulo cuadrado.",rect2.isCuadrado()?"Es":"No es");        
    }
}
