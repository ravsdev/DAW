/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

/**
 * Declaración e inicialización de variables.
 * @author Raúl Vañes
 */
public class PROG02_Ejerc1 {
    public static void main(String[] args){
        /* 
         * Declaramos una variable short que es suficiente para almacenar el valor fijo.
         * Hacemos la variable constante con la palabra reservada final
        */
        final short MAXIMO=5000;

        /*
         * Utilizamos el tipo boolean porque nos permite 2 valores, verdadero o falso.
        */
        boolean carnetConducir=true;
        
        /*
         * Mes del año tendrá un valor de 12 como máximo por lo que el tipo byte es más que suficiente para almacenar dicho valor.
         * Para guardar el nombre como cadena utilizamos String que es un tipo referenciado
        */
        byte mesNum=11;
        String mesCadena="Noviembre";
        
        
        /*
        * Utilizamos una variable de tipo String para almacenar una cadena de texto, en este caso nombre y apellidos.
        */
        String nombreCompleto="Pepito Grillo";
        
        /*
        * Puesto que la variable sólo puede ser 'V' o 'M' el tipo char es más que suficiente para almacenar uno de los dos carácteres.
        */
        char sexo='V';
        
        /*
         * He usado la función currentTimeMillis que devuelve un valor del tipo long, con el tiempo actual en milisegundos,
         * Mide la diferencia entre el tiempo actual y la fecha 01/01/1970
        */
        long currentTime=System.currentTimeMillis();
        
        /*
         * Puesto que el saldo de una cuenta bancaria puede incluir decimales utilizaremos un tipo float.
        */
        
        float saldoBanco=1235000.87F;
        
        /*
        * La distancia en kms desde la Tierra a Júpiter es de 588 millones de kms.
        * El tipo int es más que suficiente para almacenar dicha cantidad.
        */
        int distTierraJupiter=588000000;
        
        /*
        * Para mostrar los resultados puesto que no podemos utilizar println, he utilizado print,
        * usando la secuencia de escape \n para hacer un salto de línea.
        * También he usado printf para mostrar la línea de mes del año
        */
        
        System.out.print("1. Valor máximo no modificable: "+MAXIMO+"\n");
        System.out.print("2. El empleadio tiene carnet de conducir: "+carnetConducir+"\n");
        System.out.printf("3. Mes del año en formato númerico: %d y como cadena: %s",mesNum,mesCadena+"\n");
        System.out.print("4. Valor variable nombreCompleto: "+nombreCompleto+"\n");
        System.out.print("5. Valor variable sexo: "+sexo+"\n");
        System.out.print("6. Milisegundos transcurridos desde el 01/01/1970 hasta nuestros días: "+currentTime+"ms \n");
        System.out.print("7. Saldo de cuenta bancaria: "+saldoBanco+" €\n");
        System.out.print("8. Distancia de la Tierra a Júpiter: "+distTierraJupiter+" kms\n");
    }
}
