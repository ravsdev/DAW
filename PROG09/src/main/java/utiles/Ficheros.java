/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase utilizada para manejar ficheros. Se utilizará para hacer guardar los
 * datos que introduzca el usuario, así como también generar informes en
 * ficheros de texto. Todos los métodos son estáticos, así no es necesario
 * instanciar ningún objeto desde las clases donde se utilice.
 *
 * @author Raúl Vañes Sanz
 */

public class Ficheros {

    /**
     * Dado un nombre de fichero intenta abrirlo y lo lee.
     *
     * @param fichero Nombre del fichero a leer.
     * @return Objeto leido.
     */
    public static Object leer(String fichero) {
        try {
            //Intentamos abrir el fichero
            File outputFile = new File(fichero);

            //Abrimos el flujo
            ObjectInputStream lee = new ObjectInputStream(new FileInputStream(outputFile));
            Object objeto;

            //Leemos del fichero
            objeto = lee.readObject();

            //Cerramos el flujo
            lee.close();

            //Devolvemos el objeto
            return objeto;
        } catch (FileNotFoundException ex) {
            //Si no se ha encontrado el fichero devolvemos null
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Dado un nombre de fichero y un objeto escribe dicho objeto en el fichero.
     *
     * @param fichero Nombre del fichero a generar.
     * @param objeto
     * @return <code>True</code> Si puede crear el fichero <code>False</code> en
     * caso contrario.
     */
    public static boolean escribir(String fichero, Object objeto) {
        try {
            //Creamos (o sobrescribimos) el fichero
            ObjectOutputStream escribe = new ObjectOutputStream(new FileOutputStream(fichero));

            //Escribimos el objeto en el fichero
            escribe.writeObject(objeto);

            //Cerramos el flujo
            escribe.close();
        } catch (IOException ex) {
            //Si se produce algún error de acceso al fichero mostramos un mensaje de error.
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Dado un nombre de fichero y un array de Strings escribe dicho array en el
     * fichero.
     *
     * @param fichero Nombre del fichero a generar.
     * @param texto Array de Strings con el texto a guardar.
     * @return <code>True</code> Si puede crear el fichero <code>False</code> en
     * caso contrario.
     */
    public static boolean crearTxt(String fichero, String[] texto) {

        try {
            //Creamos (o sobrescribimos) el fichero
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fichero)));

            //Iteramos el array y vamos escribimos cada elemento en el fichero.
            for (String linea : texto) {
                pw.printf("----------"
                        + "\n"
                        + "%s"
                        + "\n", linea);
            }

            //Cerramos el flujo
            pw.close();

            //Si todo ha ido bien devolvemos TRUE
            return true;
        } catch (IOException e) {
            //Si se produce algún error de acceso al fichero mostramos un mensaje de error.
            System.out.println("Error al crear el archivo");
        }

        return false;

    }
}
