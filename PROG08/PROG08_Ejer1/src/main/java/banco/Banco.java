/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;

/**
 * Clase que almacena cuentas bancarias de diferentes tipos en un array. Esta
 * clase nos permite: -Añadir (abrir) cuentas -Listarlas -Obtener información
 * detallada de cada cuenta -Obtener el saldo -Ingresar y retirar dinero de las
 * cuentas
 *
 * @author Raúl Vañes Sanz
 */
public class Banco {

    /*
        Utilizamos como estructura dinámica un ArrayList.
        Puesto que no necesitamos mantener ningún orden especial
        y las funciones principales serán las de buscar y modificar objetos pero no tanto la de eliminarlos.
     */
    private final ArrayList<CuentaBancaria> cuentas;

    /**
     * Constructor por defecto.
     */
    public Banco() {
        cuentas = new ArrayList<CuentaBancaria>();
    }

    /**
     * Recibe un objeto de tipo cuenta bancaria y lo añade si hay espacio en el
     * array.
     *
     * @param cuenta Objeto de tipo Cuenta bancaria
     * @return <code>true</code> si se añade con éxito una nueva cuenta bancaria
     * <code>false</code> en caso contrario
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        /*
            Con el ArrayList, simplemente utilizamos el método add y nos devuelve TRUE y se ha realizado con éxito 
            o FALSE en caso contrario.
         */
        return cuentas.add(cuenta);
    }

    /**
     * Devuelve un array de cadenas de texto con todas las cuentas bancarias
     * creadas.
     *
     * @return Array de cadenas de texto
     */
    public String[] listadoCuentas() {
        int numCuentas = cuentas.size();
        String[] listado = new String[numCuentas];

        int i;
        for (i = 0; i < numCuentas; i++) {
            //listado[i] = cuentas.get(i).devolverInfoString();
            listado[i] = String.format("%s"
                    + "\n"
                    + "IBAN: %s"
                    + "\n"
                    + "Saldo: %.2f", cuentas.get(i).getTitular().devolverInfoString(), cuentas.get(i).getNumCuenta(), cuentas.get(i).getSaldo());
        }
        return listado;
    }

    /**
     * Devuelve la información de una cuenta en función del iban recibido.
     *
     * @param iban Número de cuenta
     * @return Cadena de texto con la información de la cuenta.
     */
    public String informacionCuenta(String iban) {
        CuentaBancaria cuenta = obtenerCuenta(iban);

        return cuenta != null ? cuenta.devolverInfoString() : null;
    }

    /**
     * Recibe un IBAN y una cantidad por parámetros e ingresa la cantidad en la
     * cuenta.
     *
     * @param iban Número de cuenta
     * @param cantidad Cantidad en euros a ingresar
     * @return <code>true</code> si se ha podido hacer el ingreso
     * <code>false</code> en caso contrario
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
        boolean operacion = false;
        CuentaBancaria cuenta = obtenerCuenta(iban);

        // Si ha encontrado el IBAN
        if (cuenta != null) {
            double saldo = cuenta.getSaldo();
            cuenta.setSaldo(saldo + cantidad);
            operacion = true;
        }

        return operacion;
    }

    /**
     * Recibe un IBAN y una cantidad por parámetros y retira la cantidad en la
     * cuenta.
     *
     * @param iban Número de cuenta
     * @param cantidad Cantidad en euros a retirar
     * @return  <code>true</code> si se ha podido hacer la retirada
     * <code>false</code> en caso contrario
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        boolean operacion = false;
        CuentaBancaria cuenta = obtenerCuenta(iban);

        // Si ha encontrado el IBAN
        if (cuenta != null) {
            double saldo = cuenta.getSaldo();
            double nuevoSaldo = saldo - cantidad;

            // Comprobamos que el saldo a retirar no sea mayor que el disponible
            if (nuevoSaldo >= 0) {
                cuenta.setSaldo(nuevoSaldo);
                operacion = true;
            }
        }

        return operacion;
    }

    /**
     * Recibe un número de cuenta y devuelve el saldo disponible En caso de no
     * encontrar la cuenta devuelve -1.
     *
     * @param iban Número de cuenta
     * @return Saldo disponible
     */
    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = obtenerCuenta(iban);

        // Si ha encontrado el IBAN
        if (cuenta != null) {
            return cuenta.getSaldo();
        }

        return -1;
    }

    /**
     * Recibe un número de cuenta, comprueba si existe la cuenta y si el saldo
     * es igual a 0, en caso de cumplirse las condiciones elimina la cuenta.
     *
     * @param iban Número de cuenta a eliminar.
     * @return <code>TRUE</code> Si la cuenta se ha eliminado con éxito.
     * <code>FALSE</code> Si no se ha podido eliminar.
     */
    public boolean eliminarCuenta(String iban) {
        CuentaBancaria cuenta = obtenerCuenta(iban);

        if (cuenta != null) {
            if (cuenta.getSaldo() == 0) {
                return cuentas.remove(cuenta);
            }
        }

        return false;
    }

    /**
     * Recibe un número de cuenta y comprueba si existe en la 'base de datos'
     *
     * @param iban Número de cuenta
     * @return <code>true</code> si la cuenta existe en el banco
     * <code>false</code> si no existe
     */
    public boolean comprobarCuenta(String iban) {
        return obtenerCuenta(iban) != null;
    }

    /**
     * Método privado para obtener la cuenta bancaria. Si la cuenta no existe
     * devuelve null.
     *
     * @param iban Número de cuenta
     * @return La cuenta bancaria si la encuentra, null en caso de no
     * encontrarla.
     */
    private CuentaBancaria obtenerCuenta(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumCuenta().equalsIgnoreCase(iban)) {
                return cuenta;
            }
        }

        return null;
    }
}
