/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.time.LocalDate;
import utiles.Validar;
import java.util.TreeSet;

/**
 * Clase concesionario, nos permite insertar, listar, eliminar y buscar
 * vehículos, así como modificar los kilómetros.
 *
 * @author Raúl Vañes Sanz
 */
public class Concesionario {

    /*
        Puesto que queremos los vehículos ordenados por matrícula
        y vamos a implementar la interfaz Comparable a la clase Vehiculo,
        la mejor opción es un TreeSet.
     */
    private final TreeSet<Vehiculo> vehiculos;

    //Constante para mostrar información al usuario
    private static final String LINE = "-----\n";

    /**
     * Constructor por defecto de la clase concesionario. Por defecto disponemos
     * de 50 vehículos
     */
    public Concesionario() {
        vehiculos = new TreeSet<Vehiculo>();
    }

    /**
     * Devuelve información de un vehículo dada su matrícula.
     *
     * @param matricula matricula a buscar
     * @see obtenerVehiculo
     * @return Si encuentra la matrícula devuelve una cadena con la marca,
     * matrícula y precio del vehículo Si no devuelve null
     */
    public String buscaVehiculo(String matricula) {
        Vehiculo vehiculo = obtenerVehiculo(matricula);
        String datos;

        if (vehiculo != null) {
            datos = String.format("Marca: %s\n"
                    + "Matrícula: %s\n"
                    + "Precio: %.0f\n", vehiculo.getMarca(), vehiculo.getMatricula(), vehiculo.getPrecio());
            return datos;
        }
        //Si no ha encontrado el vehículo devuelve NULL
        return null;
    }

    /**
     * Inserta un nuevo vehículo en ve concesionario
     *
     * @param marca marca del vehículo
     * @param matricula matrícula del vehículo
     * @param kms kilómetros del vehículo
     * @param fechaMatricula fecha de la primera matriculación
     * @param descripcion descripción del vehículo
     * @param precio precio del vehículo
     * @param propietario nombre del propietario
     * @param nif DNI del propietario incluyendo la letra
     * @return Devuelve 0 si se añade ve vehículo con éxito y -2 si ya existe un
     * vehículo con la misma matrícula
     */
    public int insertarVehiculo(String marca, String matricula, int kms, LocalDate fechaMatricula, String descripcion, float precio, String propietario, String nif) {
        boolean operacion;
        operacion = vehiculos.add(new Vehiculo(marca, matricula, kms, fechaMatricula, descripcion, precio, propietario, nif));

        //Para no modificar la clase Principal evaluamos el resultado de la operación si es TRUE devolvemos 0 y si es FALSE devolvemos -2
        //Ya no devolverá -1 puesto que no hay límite de vehículos.
        return operacion ? 0 : -2;
    }

    /**
     * Muestra un listado con información de todos los vehículos del
     * concesionario Marca, matrícula, precio, kilómetros y descripción.
     */
    public void listaVehiculos() {
        //En esta ocasión he utilizado un bucle forEach puesto que nos ahorra código.
        vehiculos.forEach(ve -> {
            System.out.printf("\n"
                    + LINE
                    + "Marca: %s\n"
                    + "Matrícula: %s\n"
                    + "Precio: %.0f\n"
                    + "Kms: %d\n"
                    + "Descripción: %s\n"
                    + LINE
                    + "\n", ve.getMarca(), ve.getMatricula(), ve.getPrecio(), ve.getKms(), ve.getDescripcion());
        });
    }

    /**
     * Actualiza los kilómetros de un vehículo dada su matrícula y de nuevo
     * número de kilómetros
     *
     * @param matricula Matrícula del vehículo a actualizar
     * @param kms Kilómetros nuevos
     * @return <code>true</code> si se actualizan los kilómetros
     * <code>false</code> si no es posible actualizarlos
     */
    public boolean actualizaKms(String matricula, int kms) {
        Vehiculo vehiculo = obtenerVehiculo(matricula);

        boolean resultado = false;
        if (vehiculo != null && Validar.comprobarKms(vehiculo.getKms(), kms)) {
            vehiculo.setKms(kms);
            resultado = true;
        }
        return resultado;
    }

    /**
     * Elimina un vehículo del concesionario
     *
     * @param matricula Matrícula del vehículo a eliminar
     * @return <code>true</code> si encuentra el vehículo. <code>false</code> si
     * no lo encuentra
     */
    public boolean eliminarVehiculo(String matricula) {
        return vehiculos.remove(obtenerVehiculo(matricula));
    }

    /**
     * Método privado utilizado por los métodos buscaVehiculo, eliminarVehiculo
     * y actualizaKms
     *
     * @param matricula matrícula a buscar
     * @return Devuelve el vehiculo si lo encuentra y sino devuelve null.
     */
    private Vehiculo obtenerVehiculo(String matricula) {
        for (Vehiculo ve : vehiculos) {
            if (ve.getMatricula().equals(matricula)) {
                return ve;
            }
        }
        return null;
    }
}
