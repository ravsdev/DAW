/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Cuenta Corriente de tipo Empresa, hereda de CuentaCorriente todos los
 * atributos y también hereda los de CuentaBancaria.
 *
 * @author Raúl Vañes Sanz
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double maxDescubierto;
    private float tipoInteres;
    private float comisionFija;

    /**
     * Constructor principal
     *
     * @param titular
     * @param numCuenta
     * @param saldo
     * @param maxDescubierto
     * @param tipoInteres
     * @param comisionFija
     * @param entidades
     */
    public CuentaCorrienteEmpresa(Persona titular, String numCuenta, double saldo, double maxDescubierto, float tipoInteres, float comisionFija, String entidades) {
        //Llamamos al constructor padre (clase CuentaCorriente)
        super(titular, numCuenta, saldo, entidades);
        this.maxDescubierto = maxDescubierto;
        this.tipoInteres = tipoInteres;
        this.comisionFija = comisionFija;
    }

    /**
     * @return the maxDescubierto
     */
    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    /**
     * @param maxDescubierto the maxDescubierto to set
     */
    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    /**
     * @return the tipoInteres
     */
    public float getTipoInteres() {
        return tipoInteres;
    }

    /**
     * @param tipoInteres the tipoInteres to set
     */
    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * @return the comisionFija
     */
    public float getComisionFija() {
        return comisionFija;
    }

    /**
     * @param comisionFija the comisionFija to set
     */
    public void setComisionFija(float comisionFija) {
        this.comisionFija = comisionFija;
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
                + "Máximo descubierto: %.2f"
                + "\n"
                + "Tipo de interés por descubierto: %.2f"
                + "\n"
                + "Comisión por descubierto: %.2f", super.devolverInfoString(), getMaxDescubierto(), getTipoInteres(), getComisionFija());
    }

}
