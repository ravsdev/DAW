/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import interfaces.Imprimible;
import java.io.Serializable;

/**
 * Clase abstracta que utilizaremos como base para crear todos los tipos de
 * cuentas bancarias.
 * Implementa las clases Imprimible y Serializable.
 *
 * @author Raúl Vañes Sanz
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {

    private Persona titular;
    private String numCuenta;
    /*
        Lo ideal para el saldo hubiera sido utilizar BigDecimal,
        pero para no complicar la tarea he utilizado un double.
     */
    private double saldo;

    /**
     * Constructor de CuentaBancaria.
     *
     * @param titular Titular del tipo Persona
     * @param numCuenta Cadena de carácteres con el número de la cuenta
     * @param saldo Número real con el saldo inicial
     */
    public CuentaBancaria(Persona titular, String numCuenta, double saldo) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    /**
     * Devuelve una copia del Objeto titular.
     * @return the titular
     */
    public Persona getTitular() {
        return new Persona(this.titular);
    }

    /**
     * Establece el atributo titular.
     * @param titular the titular to set
     */
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    /**
     * Devuelve el número de la cuenta.
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el número de cuenta.
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Devuelve el saldo.
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo.
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve la información de la cuenta en una cadena de texto.
     * @return Información de la cuenta.
     */    
    @Override
    public String devolverInfoString() {
        return String.format("%s"
                + "\n"
                + "IBAN: %s"
                + "\n"
                + "Saldo: %.2f €", getTitular().devolverInfoString(), getNumCuenta(), getSaldo());
    }
}
