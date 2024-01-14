/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Clase abstracta que hereda de CuentaBancaria, se utiliza como base para las
 * clases CuentaCorrientePersonal y CuentaCorrienteEmpresa.
 *
 * @author Raúl Vañes Sanz
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    private String entidades;

    /**
     * Constructor.
     *
     * @param titular Titular de la cuenta
     * @param numCuenta Número de cuenta
     * @param saldo Saldo inicial
     * @param entidades Entidades autorizadas
     */
    public CuentaCorriente(Persona titular, String numCuenta, double saldo, String entidades) {
        //Llamamos al constructor padre (clase CuentaBancaria)
        super(titular, numCuenta, saldo);
        this.entidades = entidades;
    }

    /**
     * Obtiene las entidades autorizadas
     * @return the entidades
     */
    public String getEntidades() {
        return entidades;
    }

    /**
     * Establece las entidades autorizadas
     * @param entidades the entidades to set
     */
    public void setEntidades(String entidades) {
        this.entidades = entidades;
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
                + "Entidades autorizadas: ", super.devolverInfoString(), getEntidades());
    }
}
