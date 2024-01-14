/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Cuenta Corriente de tipo Personal, hereda de CuentaCorriente todos los
 * atributos y también hereda los de CuentaBancaria.
 * @author Raúl Vañes Sanz
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    private float comisionMan;
    
    /**
     * Constructor principal de CuentaCorrientePersonal.
     * @param titular
     * @param numCuenta
     * @param saldo
     * @param comisionMan
     * @param entidades 
     */
    public CuentaCorrientePersonal(Persona titular, String numCuenta, double saldo,float comisionMan, String entidades) {
        //Llamamos al constructor padre (clase CuentaCorriente)
        super(titular, numCuenta, saldo,entidades);
        this.comisionMan=comisionMan;
    }

    /**
     * Devuelve la comisión de mantenimiento de la cuenta.
     * @return the comisionMan
     */
    public float getComisionMan() {
        return comisionMan;
    }

    /**
     * Establece la comisión de mantenimiento de la cuenta.
     * @param comisionMan the comisionMan to set
     */
    public void setComisionMan(float comisionMan) {
        this.comisionMan = comisionMan;
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
                + "Comisión de mantenimiento: %.2f", super.devolverInfoString(), getComisionMan());
    }
    
    
}
