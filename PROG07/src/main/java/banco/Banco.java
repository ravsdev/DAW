/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Clase que almacena cuentas bancarias de diferentes tipos en un array. Esta
 * clase nos permite: -Añadir (abrir) cuentas -Listarlas -Obtener información
 * detallada de cada cuenta -Obtener el saldo -Ingresar y retirar dinero de las
 * cuentas
 *
 * @author Raúl Vañes Sanz
 */
public class Banco {

    //Array donde se almacenan las cuentas
    private CuentaBancaria[] cuentas;

    //Número de cuentas creadas
    private int numCuentas;

    /**
     * Constructor por defecto. Por defecto hay un máximo de 100 cuentas.
     */
    public Banco() {
        cuentas = new CuentaBancaria[100];
        numCuentas = 0;
    }

    /**
     * Constructor con el que podemos personalizar el número máximo de cuentas.
     *
     * @param cantidadCuentas
     */
    public Banco(int cantidadCuentas) {
        cuentas = new CuentaBancaria[cantidadCuentas];
        numCuentas = 0;
    }

    /**
     * Recibe un objeto de tipo cuenta bancaria y lo añade si hay espacio en el array.
     * @param cuenta Objeto de tipo Cuenta bancaria
     * @return <code>true</code> si se añade con éxito una nueva cuenta bancaria
     * <code>false</code> en caso contrario
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        boolean operacion = false;
        
        //Si hay espacio libre, se añade
        if (numCuentas < cuentas.length) {
            cuentas[numCuentas] = cuenta;
            numCuentas++;
            operacion = true;
        }

        return operacion;
    }

    /**
     * Devuelve un array de cadenas de texto con todas las cuentas bancarias creadas.
     * @return Array de cadenas de texto
     */
    public String[] listadoCuentas() {
        String[] listado = new String[numCuentas];

        int i;
        for (i = 0; i < numCuentas; i++) {
            //listado[i] = cuentas[i].devolverInfoString();
            listado[i] = String.format("%s"
                    + "\n"
                    + "IBAN: %s"
                    + "\n"
                    + "Saldo: %.2f", cuentas[i].getTitular().devolverInfoString(), cuentas[i].getNumCuenta(), cuentas[i].getSaldo());
        }
        return listado;
    }

    /**
     * Devuelve la información de una cuenta en función del iban recibido.
     * @param iban Número de cuenta
     * @return Cadena de texto con la información de la cuenta.
     */
    public String informacionCuenta(String iban) {
        String datos = null;
        int pos = obtenerCuenta(iban);
        
        //Si ha encontrado el IBAN
        if (pos != -1) {
            datos = cuentas[pos].devolverInfoString();
        }

        return datos;
    }

    /**
     * Recibe un IBAN y una cantidad por parámetros e ingresa la cantidad en la cuenta.
     * @param iban Número de cuenta
     * @param cantidad Cantidad en euros a ingresar
     * @return <code>true</code> si se ha podido hacer el ingreso
     * <code>false</code> en caso contrario
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
        boolean operacion = false;
        int pos = obtenerCuenta(iban);
        
        //Si ha encontrado el IBAN
        if (pos != -1) {
            double saldo = cuentas[pos].getSaldo();
            cuentas[pos].setSaldo(saldo + cantidad);
            operacion = true;
        }

        return operacion;
    }

    /**
     * Recibe un IBAN y una cantidad por parámetros y retira la cantidad en la cuenta.
     * @param iban Número de cuenta
     * @param cantidad Cantidad en euros a retirar
     * @return  <code>true</code> si se ha podido hacer la retirada
     * <code>false</code> en caso contrario
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        boolean operacion = false;
        int pos = obtenerCuenta(iban);
        
        //Si ha encontrado el IBAN
        if (pos != -1) {
            double saldo = cuentas[pos].getSaldo();
            double nuevoSaldo = saldo - cantidad;
            
            //Comprobamos que el saldo a retirar no sea mayor que el disponible
            if (nuevoSaldo >= 0) {
                cuentas[pos].setSaldo(nuevoSaldo);
                operacion = true;
            }
        }

        return operacion;
    }

    /**
     * Recibe un número de cuenta y devuelve el saldo disponible
     * @param iban Número de cuenta
     * @return Saldo disponible
     */
    public double obtenerSaldo(String iban) {
        int pos = obtenerCuenta(iban);
        
        //Si ha encontrado el IBAN
        if (pos != -1) {
            return cuentas[pos].getSaldo();
        }

        return -1;
    }

    /**
     * Recibe un número de cuenta y comprueba si existe en la 'base de datos'
     * @param iban Número de cuenta
     * @return <code>true</code> si la cuenta existe en el banco
     * <code>false</code> si no existe
     */
    public boolean comprobarCuenta(String iban) {
        boolean encontrada = false;
        if (obtenerCuenta(iban) != -1) {
            encontrada = true;
        }
        return encontrada;

    }

    /**
     * Método privado para obtener la posición de la cuenta dentro del array.
     * Si la cuenta no existe devuelve -1.
     * @param iban Número de cuenta
     * @return Posición de la cuenta en el array cuentas
     */
    private int obtenerCuenta(String iban) {
        int i;

        for (i = 0; i < numCuentas; i++) {
            if (cuentas[i].getNumCuenta().equals(iban)) {
                return i;
            }
        }

        return -1;
    }

}
