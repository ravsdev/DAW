/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteFecha;


/**
 *
 * @author Raúl Vañes
 */
public class Principal {
    public static void main(String[] args){
        /*
         Creamos un nuevo objeto llamado objFecha1 a partir de la clase Fecha.
         Utilizamos el constructor con sólo el parámetro de mes
        */
        Fecha objFecha1=new Fecha(Fecha.enumMes.FEBRERO);
        
        //Utilizamos el método setDia para dar valor al día del objeto objFecha1
        objFecha1.setDia(20);
        
        //Y el método setAnio para dar valor a la propiedad 
        objFecha1.setAnio(2000);
        
        System.out.printf("Primera fecha, inicializada con el primer constructor:\n%s\n",objFecha1.toString());
        System.out.printf("%s.\n", objFecha1.isSummer()?"Es verano":"No es verano");
        
        /*
            Creamos otro objeto a partir de la clase Fecha llamado objFecha2.
            Utilizamos el constructor con todos los parámetros, día, mes y año.
        */
        Fecha objFecha2=new Fecha(15, Fecha.enumMes.JULIO,2015);
        System.out.println("\nSegunda fecha, inicializada con el segundo constructor:");
        System.out.printf("La fecha 2 contiene el año %s\n", objFecha2.getAnio());
        System.out.printf("La fecha es: %s de %s del %s\n", objFecha2.getDia(),objFecha2.getMes().name().toLowerCase(),objFecha2.getAnio());
        System.out.printf("%s.\n", objFecha2.isSummer()?"Es verano":"No es verano");
    }
}
