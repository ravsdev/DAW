/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG06_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase vehículo, nos permite gestionar la información de un coche
 * (marca,matrícula,kms,precio y descripción), la fecha de matriculación y el
 * nombre del propietario
 *
 * @author Raúl Vañes Sanz
 */
public class Vehiculo {

    //Atributos que almacenarán los datos del vehículo
    private String marca,
            matricula,
            descripcion,
            propietario,
            nif;
    private int kms;
    private float precio;
    private LocalDate fechaMatricula;

    /**
     * Constructor
     *
     * @param marca marca del vehículo
     * @param matricula matrícula del vehículo
     * @param kms kilómetros del vehículo
     * @param fechaMatricula fecha de la primera matriculación
     * @param descripcion descripción del vehículo
     * @param precio precio del vehículo
     * @param propietario nombre del propietario
     * @param nif DNI del propietario incluyendo la letra
     */
    Vehiculo(String marca, String matricula, int kms, LocalDate fechaMatricula, String descripcion, float precio, String propietario, String nif) {
        this.marca = marca;
        this.matricula = matricula;
        this.kms = kms;
        this.fechaMatricula = fechaMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.propietario = propietario;
        this.nif = nif;
    }

    /**
     * Devuelve la marca del vehículo
     *
     * @return Cadena de texto con la marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo
     *
     * @param marca Cadena de texto con la marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve la matrícula
     *
     * @return Cadena de texto con la matrícula del vehículo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo
     *
     * @param matricula Cadena de texto con la matrícula del vehículo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devuelve la descrición del vehículo
     *
     * @return Cadena de texto con la descripción del vehículo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descrición del vehículo
     *
     * @param descripcion Cadena de texto con la descripción del vehículo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve los kilómetros del vehículo
     *
     * @return Número entero con los kilómetros del vehículo
     */
    public int getKms() {
        return kms;
    }

    /**
     * Establece los kilómetros del vehículo
     *
     * @param kms Número entero (int) con los kilómetros del vehículo
     */
    public void setKms(int kms) {
        this.kms = kms;
    }

    /**
     * Devuelve el DNI del propietario del vehículo
     *
     * @return Devuelve el número y la letra del DNI.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el número y letra del DNI
     *
     * @param nif Número y letra del DNI
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el precio del vehículo
     *
     * @return precio del vehículo
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del vehículo
     *
     * @param precio precio del vehículo
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el nombre del propietario
     *
     * @return cadena de texto con el nombre del propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * Establece el nombre del propietario
     *
     * @param propietario cadena de texto con el nombre del propietario
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * Devuelve la fecha de matriculación del vehículo
     *
     * @return fecha de matriculación del vehículo
     */
    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    /**
     * Establece la fecha de matriculación del vehícul
     *
     * @param fechaMatricula fecha de matriculación del vehículo
     */
    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    /**
     * Devuelve el número de años desde la primera matriculación del vehículo
     *
     * @return número de años desde la primera matriculación del vehículo
     */
    public int get_Anios() {
        return Period.between(fechaMatricula, LocalDate.now()).getYears();
    }

    /**
     * Devuelve toda la información del vehículo
     *
     * @return Los datos completos del vehículo
     */
    public String getDatos() {
        return String.format("Marca: %s\n"
                + "Matrícula: %s\n"
                + "Kilómetros: %d\n"
                + "Fecha Matriculación: %s\n"
                + "Descripción: %s\n"
                + "%.0f\n"
                + "Propietario: %s - %s", marca, matricula, kms, fechaMatricula, descripcion, precio, propietario, nif);
    }
}
