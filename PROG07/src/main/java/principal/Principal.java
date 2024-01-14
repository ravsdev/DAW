/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/*
    Importamos las clases necesarias de los paquetes banco y utiles
    Podríamos haber importado todo el paquete de banco: import banco.*
    Pero la clase CuentaCorriente.java no se utiliza por lo tanto sólo se importan las que realmente se utilizan.
 */
import banco.Persona;
import banco.Banco;
import banco.CuentaAhorro;
import banco.CuentaBancaria;
import banco.CuentaCorrientePersonal;
import banco.CuentaCorrienteEmpresa;
import java.util.Scanner;
import utiles.Validar;

/**
 * Clase principal que muestra un menú en pantalla y nos permite interactatuar
 * con Cuentas Bancarias.
 *
 * @author Raúl Vañes Sanz
 */
public class Principal {

    // Atributo utilizado para leer los datos del usuario
    private static final Scanner entrada = new Scanner(System.in);

    //Creamos una instancia de la clase Banco donde almacenaremos toda la información
    private static final Banco banco = new Banco();

    // Enumerado con las opciones del menú
    private enum OPCIONES {
        NUEVA("Abrir cuenta nueva."), LISTAR("Listado de cuentas disponibles."), BUSCAR("Obtener datos de una cuenta."),
        INGRESAR("Ingresar dinero."), RETIRAR("Retirar efectivo."), SALDO("Consultar el saldo de una cuenta."),
        SALIR("Salir.");

        private final String descripcion;

        OPCIONES(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getOrdinal() {
            return ordinal() + 1;
        }
    }

    // Constantes para mostrar información al usuario
    private static final String NOMBREBANCO = "BANCO por Raúl Vañes Sanz";
    private static final String MENULINE = "#############################";
    private static final String VALIDOPTIONS = "Valores permitidos 1-7.";
    private static final String VALORNUMERICO = "Sólo se permiten valores numéricos.";
    private static final String[] TIPOSCUENTAS = {"1.Cuenta de ahorro", "2.Cuenta corriente personal",
        "3.Cuenta corriente empresa"};

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Muestra el menú en pantalla y lanza las acciones necesarias según la
     * elección del usuario.
     */
    public static void menu() {
        // Almacena la opción elegida por el usuario mediante el teclado
        int opcionUsr = 0;

        /*
         * Mientras la opción sea diferente de 7 el programa no finalizará.
         */
        do {
            // Mostramos las opciones del menú
            mostrarOpciones();

            if (entrada.hasNextInt()) {
                opcionUsr = entrada.nextInt();
                entrada.nextLine();
                accion(opcionUsr);
            } else {
                System.out.println(VALIDOPTIONS);
                entrada.next();
            }

        } while (opcionUsr != 7);
    }

    /**
     * Recorre el enumerado de las opciones del menú y las muestra por pantalla.
     * Añadimos algunas líneas de carácteres para una mejor visibilidad de las
     * opciones.
     */
    public static void mostrarOpciones() {
        System.out.println(MENULINE);
        System.out.println(NOMBREBANCO);
        System.out.println(MENULINE);
        for (OPCIONES opcion : OPCIONES.values()) {
            System.out.println(opcion.getOrdinal() + "." + opcion.getDescripcion());
        }
        System.out.println(MENULINE);
    }

    /**
     * En función de la opción elegida por el usuario lanzamos una acción
     * determinada.
     *
     * @param opcion entrada por el usuario mediante el teclado
     */
    public static void accion(int opcion) {
        switch (opcion) {
            case 1:
                //Llamamos al método solicitarDatos
                solicitarDatos();
                break;
            case 2:
                //Llamamos al método listarCuentas
                listarCuentas();
                break;
            case 3:
                //Llamamos al método datosCuenta
                datosCuenta();
                break;
            case 4:
                //Llamamos al método ingresoCuenta
                ingresoCuenta();
                break;
            case 5:
                //Llamamos al método retiradaCuenta
                retiradaCuenta();
                break;
            case 6:
                //Llamamos al método consultarSaldo
                consultarSaldo();
                break;
            case 7:
                //Sale del programa
                System.out.println("Programa finalizado.");
                break;
            default:
                System.out.println(VALIDOPTIONS);
        }
    }

    /**
     * Hacemos una llamada al método listadoCuentas de la clase Banco, obtenemos
     * el listado de cuentas en un array de Strings y lo mostramos por pantalla.
     */
    private static void listarCuentas() {
        String[] cuentasActuales = banco.listadoCuentas();
        for (String cuenta : cuentasActuales) {
            System.out.printf("\n" + "---" + "\n" + "%s" + "\n" + "---" + "\n", cuenta);
        }
    }

    /**
     * Obtiene los datos completos de una cuenta bancaria dado su número, para
     * ello llama al método informacionCuenta de la clase Banco.
     */
    private static void datosCuenta() {
        String datos = banco.informacionCuenta(obtenerCadena("IBAN: "));

        if (datos == null) {
            System.out.println("= Cuenta no encontrada. =");
        } else {
            System.out.println(datos);
        }

    }

    /**
     * Pide un número de cuenta y utiliza el método obtenerSaldo de la clase
     * Banco para obtener el resultado.
     */
    private static void consultarSaldo() {
        String iban = obtenerCadena("Introduce el IBAN: ");
        double saldoAct = banco.obtenerSaldo(iban);

        //Si obtenemos -1 eso es que no ha encontrado la cuenta
        if (saldoAct == -1) {
            System.out.println("= Cuenta no encontrada. =");
        } else {
            System.out.printf("Saldo total: %.2f €\n", saldoAct);
        }

    }

    /**
     * Pedimos una cantidad y un número de cuenta. Utilizamos el método
     * ingresoCuenta de la clase Banco. Si la cuenta existe, ingresamos la
     * cantidad en dicha cuenta.
     */
    private static void ingresoCuenta() {
        double cantidad;
        String iban;
        iban = obtenerCadena("Introduce el IBAN: ");
        cantidad = obtenerDouble("Saldo a ingresar: ");

        if (banco.ingresoCuenta(iban, cantidad)) {
            System.out.println("Operación realizada con éxito");
            System.out.printf("Saldo total: %.2f €\n", banco.obtenerSaldo(iban));
        } else if(cantidad==0){
            System.out.println("La cantidad debe ser mayor que 0.");
        }else{
            //Si ingresoCuenta devuelve FALSE, significa que no ha encontrado la cuenta.
            System.out.println("= Cuenta no encontrada. =");
        }
    }

    /**
     * Pedimos una cantidad y un número de cuenta. Utilizamos el método
     * retiradaCuenta de la clase Banco. Si la cuenta existe y el saldo es
     * suficiente retiramos la cantidad en dicha cuenta.
     */
    private static void retiradaCuenta() {
        double cantidad;
        String iban;
        iban = obtenerCadena("Introduce el IBAN: ");
        cantidad = obtenerDouble("Saldo a retirar: ");

        //Primero comprobamos que la cuenta exista
        if (banco.comprobarCuenta(iban)) {
            if (banco.retiradaCuenta(iban, cantidad)) {
                System.out.println("Operación realizada con éxito");
                System.out.printf("Saldo total: %.2f €\n", banco.obtenerSaldo(iban));
            }else if(cantidad==0){
            System.out.println("La cantidad debe ser mayor que 0.");
        } else {
                //Si el método retiradaCuenta nos devuelve FALSE, significa que el saldo no es suficiente.
                System.out.println("No hay saldo suficiente.");
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    /**
     * Método privado utilizado para solicitar los Datos a la hora de crear una
     * cuenta nueva.
     */
    private static void solicitarDatos() {
        Persona titular;
        String iban, entidades;
        int tipoCuenta;
        double saldo, maxDescubierto;
        float tipoInteres, comision;

        //La variable cuenta almacenará cualquier tipo de clase que hereda de la clase CuentaBancaria
        CuentaBancaria cuenta;

        titular = obtenerDatosTitular();

        iban = obtenerNumCuenta();

        saldo = obtenerDouble("Saldo inicial: ");

        tipoCuenta = elegirTipoCuenta();

        //Dependiendo del tipo de cuenta elegida por el usuario crearemos una instancia de los diferentes tipos de cuentas.
        switch (tipoCuenta) {
            case 1:
                tipoInteres = obtenerInteres();
                cuenta = new CuentaAhorro(titular, iban, saldo, tipoInteres);
                break;
            case 2:
                entidades = obtenerCadena("Entidades autorizadas (separadas por comas): ");
                comision = obtenerComision();
                cuenta = new CuentaCorrientePersonal(titular, iban, saldo, comision, entidades);
                break;
            case 3:
                entidades = obtenerCadena("Entidades autorizadas (separadas por comas): ");
                maxDescubierto = obtenerDouble("Máximo descubierto: ");
                tipoInteres = obtenerInteres();
                comision = obtenerComision();
                cuenta = new CuentaCorrienteEmpresa(titular, iban, saldo, maxDescubierto, tipoInteres, comision, entidades);
                break;
            default:
                cuenta = null;
                System.out.println("Tipo de cuenta desconocida.");
        }

        //Si la cuenta es creada con éxito mostramos mensaje por pantalla.
        if (banco.abrirCuenta(cuenta)) {
            System.out.println("Cuenta creada con éxito.");
        } else {
            //En caso contrario significa que el array está lleno e informamos al usuario de ello.
            System.out.println("Error al crear la cuenta, no hay espacio disponible.");
        }
    }

    /**
     * Método auxiliar para pedir un dato de cadena de texto.
     *
     * @param mensaje Texto a mostrar en pantalla
     * @return Dato capturado del usuario
     */
    private static String obtenerCadena(String mensaje) {
        System.out.println(mensaje);

        return entrada.nextLine();
    }

    /**
     * Método autilixar para pedir un dato número. Si se introduce texto o un
     * número negativo volverá a pedir al usuario que introduzca un número.
     *
     * @param mensaje Texto a mostrar en pantalla
     * @return Número double
     */
    private static double obtenerDouble(String mensaje) {
        double num = -1;
        System.out.println(mensaje);

        do {
            try {
                String datoLeido = entrada.next();
                num = Double.parseDouble(Validar.validaDecimal(datoLeido));
                if (num < 0) {
                    System.out.println("La cantidad debe ser mayor o igual a 0.");
                }
            } catch (NumberFormatException ex) {
                System.out.println(VALORNUMERICO);
                //entrada.next();
            }
        } while (num < 0);

        return num;
    }

    /**
     * Método autilixar para pedir un dato número. Si se introduce texto o un
     * número negativo volverá a pedir al usuario que introduzca un número.
     *
     * @param mensaje Texto a mostrar en pantalla
     * @return Número float
     */
    private static float obtenerFloat(String mensaje) {
        float num = -1;
        System.out.println(mensaje);

        do {
            try {
                String datoLeido = entrada.next();
                num = Float.parseFloat(Validar.validaDecimal(datoLeido));
                if (num < 0) {
                    System.out.println("La cantidad debe ser mayor o igual a 0.");
                }
            } catch (NumberFormatException ex) {
                System.out.println(VALORNUMERICO);
                //entrada.next();
            }
        } while (num < 0);

        return num;
    }

    /**
     * Pide el tipo de interés y comprueba que no sea superior al 100%.
     * @return 
     */
    private static float obtenerInteres(){
        float interes=0;
        do{
            interes=obtenerFloat("Tipo de interés: ");
            if(interes>100) System.out.println("El interés no puede ser mayor a 100.");
        }while(interes>100);
        
        return interes;
    }
    
     /**
     * Pide la comisión y comprueba que no sea superior al 100%.
     * @return 
     */
    private static float obtenerComision(){
        float interes=0;
        do{
            interes=obtenerFloat("Comisión: ");
            if(interes>100) System.out.println("La comisión no puede ser mayor a 100.");
        }while(interes>100);
        
        return interes;
    }   
    /**
     * Solicita el DNI y lo comprueba. Hasta que no cumple el formato correcto
     * lo sigue solicitando.
     *
     * @return
     */
    private static String obtenerDNI() {
        String nif;
        boolean dniValidado = false;
        do {
            System.out.println("Introduce el DNI del propietario: ");
            nif = entrada.nextLine();
            try {
                Validar.comprobarNIF(nif);
                dniValidado = true;
            } catch (Exception e) {
                System.out.println("Nif erróneo");
                //entrada.next();
            }
        } while (!dniValidado);

        return nif;
    }

    /**
     * Pide nombre, apellidos y NIF y devuelve un objeto de tipo Persona con
     * esos datos.
     *
     * @return Titular de la cuenta
     */
    private static Persona obtenerDatosTitular() {
        String nombre, apellidos, nif;
        nombre = obtenerCadena("Nombre del titular: ");
        apellidos = obtenerCadena("Apellido(s) del titular: ");
        nif = obtenerDNI();

        return new Persona(nombre, apellidos, nif);
    }

    /**
     * Pide al usuario que introduzca el número de cuenta, comprueba si existe y
     * de ser así vuelve a solicitar que se introduzca un nuevo número de
     * cuenta.
     *
     * @return
     */
    private static String obtenerNumCuenta() {
        String iban;
        boolean ibanValidado = false;
        do {
            System.out.println("Número de cuenta (IBAN), ES seguido de 20 dígitos:");
            iban = entrada.nextLine();
            if (Validar.comprobarIBAN(iban)) {
                if (banco.comprobarCuenta(iban)) {

                    System.out.println("La cuenta ya existe");
                } else {
                    ibanValidado = true;
                }
            } else {
                System.out.println("Formato incorrecto.");
            }
        } while (!ibanValidado);

        return iban;
    }

    /**
     * Muestra un pequeño menú con opciones para elegir el tipo de cuenta. Si el
     * usuario introduce algo que no sea un número del 1 al 3, se le solicita de
     * nuevo la opción.
     *
     * @return
     */
    private static int elegirTipoCuenta() {
        int opcion = -1;

        do {
            for (String menuCuentas : TIPOSCUENTAS) {
                System.out.println(menuCuentas);
            }

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine();
            } else {
                System.out.println("Opciones válidas 1-3");
                entrada.next();
            }
        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

}
