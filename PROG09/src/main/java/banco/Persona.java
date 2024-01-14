/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

//Importamos la interfaz imprimible del paquete interfaces
import interfaces.Imprimible;
import java.io.Serializable;

/**
 * Clase Persona que almacena la información (Nombre, apellidos y NIF) de una persona.
 * Implementa el método devolverInfoString de la interfaz Imprimible.
 * También implementa la clase Serializable para poder hacer un guardado en ficheros.
 * @author Raúl Vañes Sanz
 */
public class Persona implements Imprimible, Serializable{
    private String nombre, apellidos, nif;
    
    /**
     * Constructor principal
     * @param nombre
     * @param apellidos
     * @param nif 
     */
    public Persona(String nombre, String apellidos, String nif){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.nif=nif;
    }

    /**
     * Constructor copia de la clase Persona.
     * @param persona 
     */
    public Persona(Persona persona){
        this.nombre=persona.getNombre();
        this.apellidos=persona.getApellidos();
        this.nif=persona.getNif();
    }
    /**
     * Devuelve la información de un Objeto de la clase Persona como cadena de texto.
     * @return Información de una persona
     */    
    @Override
    public String devolverInfoString() {
        return String.format("Nombre: %s"
                + "\n"
                + "Apellidos: %s"
                + "\n"
                + "NIF: %s",getNombre(),getApellidos(),getNif());
    }

    /**
     * Devuelve el nombre.
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     * @param nombre nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos
     * @return los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos.
     * @param apellidos apellido(s) a establecer
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el NIF.
     * @return el nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF.
     * @param nif NIF a establecer
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
    
}
