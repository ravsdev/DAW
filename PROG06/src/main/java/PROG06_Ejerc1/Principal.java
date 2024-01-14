/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG06_Ejerc1;

import java.time.LocalDate;
import java.util.Scanner;
import PROG06_Ejerc1_util.Validar;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Muestra por pantalla un menú en el que el usuario puede gestionar un
 * concesionario.
 *
 * @author Raúl Vañes Sanz
 */
public class Principal {

    //Atributo utilizado para leer los datos del usuario
    private static final Scanner entrada = new Scanner(System.in);

    //Creamos una instancia de concesionario
    private static final Concesionario segundaMano = new Concesionario();

    //Enumerado con las opciones del menú
    private enum OPCIONES {
        NUEVO("Nuevo Vehículo."),
        LISTAR("Listar Vehículos."),
        BUSCAR("Buscar Vehículo."),
        MODIFICAR("Modificar kms Vehículo."),
        ELIMINAR("Eliminar Vehículo."),
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

    //Constantes para mostrar información al usuario
    private static final String MENULINE = "#############################";
    private static final String VALIDOPTIONS = "Valores permitidos 1-6.";
    private static final String VALORNUMERICO = "Sólo se permiten números";

    //Constante para comprobar el formato de la fecha introducida por el usuario
    private static final DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("d/MM/yyyy");

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String args[]) {
        menu();
    }

    /**
     * Muestra el menú en pantalla y lanza las acciones necesarias según la
     * elección del usuario.
     */
    public static void menu() {
        //Almacena la opción elegida por el usuario mediante el teclado
        int opcionUsr = 0;

        /*
            Mientras la opción sea diferente de 6 el programa no finalizará.
         */
        do {
            //Mostramos las opciones del menú
            mostrarOpciones();

            /*
                En la tarea anterior utilicé try ... catch, en su lugar esta vez he decido utilizar un if...else
                comprobando primeramente si lo que se va a leer (hasNextInt) es un entero.
             */
            if (entrada.hasNextInt()) {
                opcionUsr = entrada.nextInt();
                entrada.nextLine();
                accion(opcionUsr);
            } else {
                System.out.println(VALIDOPTIONS);
                entrada.next();
            }

        } while (opcionUsr != 6);
    }

    /**
     * Recorre el enumerado de las opciones del menú y las muestra por pantalla.
     */
    public static void mostrarOpciones() {
        System.out.println(MENULINE);
        for (OPCIONES opcion : OPCIONES.values()) {
            System.out.println(opcion.getOrdinal() + "." + opcion.getDescripcion());
        }
        System.out.println(MENULINE);
    }

    /**
     * Ejecuta diferentes acciones en función de la opción elegida por el
     * usuario.
     *
     * @param opcion Opción del usuario leida por teclado.
     */
    public static void accion(int opcion) {
        switch (opcion) {
            case 1:
                pedirDatos();
                break;
            case 2:
                segundaMano.listaVehiculos();
                break;
            case 3:
                System.out.println("Introduce la matrícula: ");
                String datos = segundaMano.buscaVehiculo(entrada.nextLine());
                if (datos != null) {
                    System.out.println(datos);
                } else {
                    System.out.println("No existe vehículo con la matrícula introducida.");
                }
                break;
            case 4:
                System.out.println("Introduce la matrícula: ");
                String matricula = entrada.nextLine();
                System.out.println("Introduce los nuevos kilómetros: ");
                int kmsNuevos = pedirInt();
                if (segundaMano.actualizaKms(matricula, kmsNuevos)) {
                    System.out.println("Kilómetros actualizados correctamente.");
                } else {
                    System.out.println("Error al actualizar los kilómetros.");
                }
                break;
            case 5:
                System.out.println("Introduce la matrícula: ");
                if (segundaMano.eliminarVehiculo(entrada.nextLine())) {
                    System.out.println("Vehículo eliminado correctamente.");
                } else {
                    System.out.println("Vehículo no encontrado.");
                }
                break;
            case 6:
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println(VALIDOPTIONS);
        }
    }

    /**
     * Solicita al usuario que introduzca un número entero Si no introduce un
     * entero lo vuelve a pedir.
     *
     * @return El número introducido por el usuario
     */
    private static int pedirInt() {
        int num = -1;
        do {
            if (entrada.hasNextInt()) {
                num = entrada.nextInt();
                entrada.nextLine();
            } else {
                System.out.println(VALORNUMERICO);
                entrada.next();
            }
        } while (num == -1);

        return num;
    }

    /**
     * Pide los datos al usuario para insertar un vehículo nuevo en el
     * concesionario.
     */
    public static void pedirDatos() {
        /*
            Almacenamos temporalmente los datos introducidos por el usuario
            para posteriormente crear una nueva instancia de la clase Vehiculo con ellos.  
         */
        String marca, matricula, descripcion, propietarioNombre, propietarioDni, fecha;
        int kms = 0, precio;
        LocalDate fechaMatricula;

        /*
            Variables utilizadas para validar diferentes datos y así mostrar un mensaje informativo al usuario
            en función del valor.
         */
        boolean dniValidado = false, fechaValidada = false, matriculaValidada = false;

        //Inicializamos la variable fechaMatricula 
        fechaMatricula = LocalDate.now();
        System.out.println("Introduce la marca: ");
        marca = entrada.nextLine();

        do {
            System.out.println("Introduce la matrícula: (Ejemplo: 1234ABC)");
            matricula = entrada.nextLine();

            //Primero comprobamos el formato de la matrícula
            if (Validar.comprobarMatricula(matricula)) {
                matriculaValidada = true;
            } else {
                System.out.println("Formato de matrícula 4 números y 3 letras mayúsculas. Ejemplo: 1234ABC");
            }
        } while (!matriculaValidada);

        do {
            System.out.println("Introduce los kilómetros: ");
            kms = pedirInt();
            if (!Validar.comprobarKms(kms)) {
                System.out.println("Los kilómetros deben ser mayor que 0");
            }
        } while (!Validar.comprobarKms(kms));

        /*
            En la tarea anterior pedía el día, el mes y el año por separado,
            en esta he optado por pedir la fecha en una única línea
            y compruebo el formato antes de convertirlo a LocalDate.
         */
        do {
            System.out.println("Fecha de matriculación, formato (dd/mm/aaaa):");
            fecha = entrada.nextLine();

            try {
                fechaMatricula = LocalDate.parse(fecha, FORMATOFECHA);
                if (Validar.comprobarFecha(fechaMatricula)) {
                    fechaValidada = true;
                } else {
                    System.out.println("La fecha de matriculación debe ser anterior a la actual.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error al introducir la fecha");
            }
        } while (!fechaValidada);

        System.out.println("Introduce una descripción: ");
        descripcion = entrada.nextLine();

        System.out.println("Introduce el precio: ");
        precio = pedirInt();

        do {
            System.out.println("Introduce el nombre y los dos apellidos del propietario: ");
            propietarioNombre = entrada.nextLine();
        } while (!Validar.comprobarNombre(propietarioNombre));

        do {
            System.out.println("Introduce el DNI del propietario: ");
            propietarioDni = entrada.nextLine();
            try {
                Validar.comprobarNIF(propietarioDni);
                dniValidado = true;
            } catch (Exception e) {
                System.out.println("Nif erróneo");
            }
        } while (!dniValidado);

        //Una vez que los datos introducidos por el usuario son validados, insertamos el nuevo vehículo en nuestro concesionario.
        int resultado = segundaMano.insertarVehiculo(marca, matricula, kms, fechaMatricula, descripcion, precio, propietarioNombre, propietarioDni);
        resultadoMsj(resultado);
    }

    /**
     * Imprime por pantalla un mensaje con el resultado de insertar un vehículo
     * nuevo en el concesionario.
     *
     * @param resultado Imprime un mensaje en función del resultado recibido
     */
    private static void resultadoMsj(int resultado) {
        String mensaje = "";

        switch (resultado) {
            case 0:
                mensaje = "Vehículo insertado con éxito";
                break;
            case -1:
                mensaje = "Concesionario lleno";
                break;
            case -2:
                mensaje = "Ya existe un vehículo con la matrícula introducida.";
                break;
        }
        System.out.println(mensaje);

    }
}
