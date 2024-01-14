/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Cuenta Bancaria de tipo Ahorro, hereda todos los atributos de CuentaBancaria
 * y añade un atributo propio que es tipoInteres.
 *
 * @author Raúl Vañes Sanz
 */
public class CuentaAhorro extends CuentaBancaria {

    private float tipoInteres;

    /**
     * Constructor de la clase Cuenta Ahorro
     *
     * @param titular
     * @param numCuenta
     * @param saldo
     * @param tipoInteres
     */
    public CuentaAhorro(Persona titular, String numCuenta, double saldo, float tipoInteres) {
        //Llamamos al constructor padre (clase CuentaBancaria)
        super(titular, numCuenta, saldo);
        this.tipoInteres = tipoInteres;
    }

    /**
     * Devuelve la información de la cuenta en una cadena de texto.
     * Sobreescribe la función de la clase padre.
     * @return Información de la cuenta.
     */    
    @Override
    public String devolverInfoString() {
        //Llamamos al método padre y añadimos los atributos propios de esta clase.
        return String.format("%s"
                + "\n"
                + "Tipo de interés: %.2f", super.devolverInfoString(), getTipoInteres());
    }

    /**
     * Devuelve el tipo de interés de la cuenta
     * @return the tipoInteres
     */
    public float getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Establece el tipo de interés de la cuenta
     * @param tipoInteres the tipoInteres to set
     */
    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

}
