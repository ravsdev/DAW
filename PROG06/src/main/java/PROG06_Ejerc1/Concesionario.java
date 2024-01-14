/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG06_Ejerc1;

import java.time.LocalDate;
import PROG06_Ejerc1_util.Validar;

/**
 * Clase concesionario, nos permite insertar, listar, eliminar y buscar
 * vehículos, así como modificar los kilómetros.
 *
 * @author Raúl Vañes Sanz
 */
public class Concesionario {

    //Array de la clase Vehiculo donde almacenaremos los vehículos del concesionario.
    private final Vehiculo[] vehiculos;

    //Número total de vehículos actualmente presentes en el concesionario
    private int numVehiculos;

    //Constante para mostrar información al usuario
    private static final String LINE = "-----\n";

    /**
     * Constructor por defecto de la clase concesionario. Por defecto disponemos
     * de 50 vehículos
     */
    Concesionario() {
        vehiculos = new Vehiculo[50];
        numVehiculos = 0;
    }

    /**
     * Constructor con el que podemos indicar el número de vehículos del
     * concesionario. Aunque no se utilice en esta práctica, podríamos
     * instanciar un objeto de la clase Concesionario con un número
     * personalizado de vehículos.
     *
     * @param numVehiculos Número máximo de vehículos que podemos tener en el
     * concesionario.
     */
    Concesionario(int numVehiculos) {
        vehiculos = new Vehiculo[numVehiculos];
        numVehiculos = 0;
    }

    /**
     * Busca la matrícula de un vehículo.
     *
     * @param matricula matricula a buscar
     * @see buscaMatricula
     * @return Si encuentra la matrícula devuelve una cadena con la marca,
     * matrícula y precio del vehículo Si no devuelve null
     */
    public String buscaVehiculo(String matricula) {
        /*
            Puesto que hay 3 métodos que buscan por matrícula he optado por crear un método privado
            y así no repetir código.
         */
        int pos = buscaMatricula(matricula);
        String datos;

        //Si la posición devuelta es distanta de -1 es que ha encontrado el vehículo
        if (pos != -1) {
            datos = String.format("Marca: %s\n"
                    + "Matrícula: %s\n"
                    + "Precio: %.0f\n", vehiculos[pos].getMarca(), vehiculos[pos].getMatricula(), vehiculos[pos].getPrecio());
            return datos;
        }
        //Si no ha encontrado el vehículo devuelve NULL
        return null;
    }

    /**
     * Inserta un nuevo vehículo en el concesionario
     *
     * @param marca marca del vehículo
     * @param matricula matrícula del vehículo
     * @param kms kilómetros del vehículo
     * @param fechaMatricula fecha de la primera matriculación
     * @param descripcion descripción del vehículo
     * @param precio precio del vehículo
     * @param propietario nombre del propietario
     * @param nif DNI del propietario incluyendo la letra
     * @return Devuelve 0 si se añade el vehículo con éxito, -1 si está lleno y
     * -2 si ya existe un vehículo con la misma matrícula
     */
    public int insertarVehiculo(String marca, String matricula, int kms, LocalDate fechaMatricula, String descripcion, float precio, String propietario, String nif) {
        int resultado = 0;

        //Si el array está lleno devuelve -1
        if (numVehiculos == vehiculos.length) {
            resultado = -1;
        } else {
            //Si no encuentra la matrícula crea un nuevo vehículo
            if (buscaMatricula(matricula) == -1) {
                vehiculos[numVehiculos] = new Vehiculo(marca, matricula, kms, fechaMatricula, descripcion, precio, propietario, nif);
                numVehiculos++;
            } //En caso contrario devuelve -2
            else {
                resultado = -2;
            }
        }

        return resultado;
    }

    /**
     * Muestra un listado con información de todos los vehículos del
     * concesionario Marca, matrícula, precio, kilómetros y descripción.
     */
    public void listaVehiculos() {
        int i;
        for (i = 0; i < numVehiculos; i++) {
            if (vehiculos[i] != null) {
                System.out.printf("\n"
                        + LINE
                        + "Coche: %d\n"
                        + "Marca: %s\n"
                        + "Matrícula: %s\n"
                        + "Precio: %.0f\n"
                        + "Kms: %d\n"
                        + "Descripción: %s\n"
                        + LINE
                        + "\n",
                        i + 1, vehiculos[i].getMarca(), vehiculos[i].getMatricula(), vehiculos[i].getPrecio(), vehiculos[i].getKms(), vehiculos[i].getDescripcion());
            }
        }
    }

    /**
     * Actualiza los kilómetros de un vehículo dada su matrícula y el nuevo
     * número de kilómetros
     *
     * @param matricula Matrícula del vehículo a actualizar
     * @param kms Kilómetros nuevos
     * @return <code>true</code> si se actualizan los kilómetros
     * <code>false</code> si no es posible actualizarlos
     */
    public boolean actualizaKms(String matricula, int kms) {
        int pos = buscaMatricula(matricula);
        boolean resultado = false;
        if (pos != -1 && Validar.comprobarKms(vehiculos[pos].getKms(), kms)) {
            vehiculos[pos].setKms(kms);
            resultado = true;
        }
        return resultado;
    }

    /**
     * Elimina un vehículo del concesionario
     *
     * @see reordenar
     * @param matricula Matrícula del vehículo a eliminar
     * @return true si encuentra el vehículo false si no lo encuentra
     */
    public boolean eliminarVehiculo(String matricula) {
        int pos = buscaMatricula(matricula);
        boolean resultado = false;
        //Si encontramos la matrícula
        if (pos != -1) {
            //Ponemos a NULL el vehículo
            vehiculos[pos] = null;
            reordenar(pos);
            numVehiculos--;
            resultado = true;
        }

        return resultado;
    }

    /**
     * Método privado utilizado por los métodos buscaVehiculo, eliminarVehiculo
     * y actualizaKms
     *
     * @param matricula matrícula a buscar
     * @return Devuelve la posición del vehículo, si no la encuentra devuelve -1
     */
    private int buscaMatricula(String matricula) {
        int i;

        for (i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Mueve un elemento NULL a la posición final del array y el resto de
     * elementos una posición a la izquierda desde la posición del elemento NULL
     *
     * @param pos posición desde la que empezar a mover
     */
    private void reordenar(int pos) {
        int i;
        int longitud = numVehiculos - 1;

        for (i = pos; i < longitud; i++) {
            vehiculos[i] = vehiculos[i + 1];
        }
        /*
    	 * El bucle anterior nos dejaría con el último y el penúltimo elementos duplicados.
    	 * Puesto que hemos borrado un elemento debe haber una posición a NULL.
    	 * Con vehiculos[longitud]=null nos aseguramos de que la última posición queda libre.
         */
        vehiculos[longitud] = null;
    }
}
