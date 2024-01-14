/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1;

import java.util.Scanner;
import PROG05_Ejerc1_util.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;

/**
 * Clase principal para gestionar vehículos.
 * Muestra un menú con el que podemos añadir información de un vehículo
 * y verla si se ha introducido previamente.
 * @author Raúl Vañes Sanz
 */
public class Principal {
    //Atributo utilizado para leer los datos del usuario
    private static final Scanner entrada = new Scanner(System.in);
    
    //Almacenará una instancia de la clase Vehículo
    private static Vehiculo objetoVehiculo;

    //Enumerado con las opciones del menú
    private enum Menu {
        MENU_1("Nuevo Vehiculo."),
        MENU_2("Ver Matrícula."),
        MENU_3("Ver Número de Kilómetros."),
        MENU_4("Actualizar Kilómetros."),
        MENU_5("Ver años de antigüedad."),
        MENU_6("Mostrar propietario."),
        MENU_7("Mostrar descripción."),
        MENU_8("Mostrar Precio."),
        MENU_9("Salir.");

        private final String descripcion;

        Menu(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getOrdinal() {
            return ordinal() + 1;
        }
    }
    
    //Constante con texto decorativo para el menú
    private static final String MENULINE="#############################";
    /**
     * Método principal
     * @param args 
     */
    public static void main(String args[]) {
        menu();
    }

    /**
     * Muestra el menú en pantalla y lanza las acciones
     * necesarias según la elección del usuario.
     */
    public static void menu() {
        //Almacena la opción elegida por el usuario mediante el teclado
        int opcionUsr = 0;

        do {
            mostrarOpciones();
            try {
                opcionUsr = entrada.nextInt();
                entrada.nextLine();
                if (opcionUsr > 1 && opcionUsr < 9 && objetoVehiculo == null) {
                    System.out.println("> Primero debes introducir los datos del coche.");
                } else {
                    accion(opcionUsr);
                }
            } catch (InputMismatchException e) {
                entrada.nextLine();
                System.out.println("> Opciones válidas del 1 al 9.");
            }

        } while (opcionUsr != 9);
    }

    /**
     * Recorre el enumerado de las opciones del menú
     * y las muestra por pantalla.
     */
    public static void mostrarOpciones() {
        System.out.println(MENULINE);
        for (Menu opcion : Menu.values()) {
            System.out.println(opcion.getOrdinal() + "." + opcion.getDescripcion());
        }
        System.out.println(MENULINE);
    }

    /**
     * Evalua la opción seleccionada por el usuario
     * y muestra la información por pantalla o pide más
     * datos al usuario.
     * @param opcion 
     */
    public static void accion(int opcion) {
        switch (opcion) {
            case 1:
                pideDatos();
                break;
            case 2:
                System.out.printf("Matrícula: %s\n", objetoVehiculo.getMatricula());
                break;
            case 3:
                System.out.printf("Kilómetros: %d kms\n", objetoVehiculo.getKms());
                break;
            case 4:
                System.out.println("Introduce los kilómetros: ");
                int kms = entrada.nextInt();
                entrada.nextLine();
                if(Validar.comprobarKms(objetoVehiculo.getKms(), kms)) objetoVehiculo.setKms(kms);
                else System.out.println("> No puede tener menos kilómetros");
                break;
            case 5:
                System.out.printf("Antigüedad: %d año(s)\n", objetoVehiculo.get_Anios());
                break;
            case 6:
                System.out.printf("Propietario: %s %s\n", objetoVehiculo.getPropietario(),objetoVehiculo.getNif());
                break;
            case 7:
                System.out.printf("Descripcion: %s\nMatrícula:%s\nKilómetros:%d\n",
                        objetoVehiculo.getDescripcion(),objetoVehiculo.getMatricula(),objetoVehiculo.getKms());
                break;
            case 8:
                System.out.printf("Precio: %.0f €\n", objetoVehiculo.getPrecio());
                break;
            case 9:
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    /**
     * Pide datos al usuario
     */
    public static void pideDatos() {
        /*
            Almacenamos temporalmente los datos introducidos por el usuario
            para posteriormente crear una nueva instancia de la clase Vehiculo con ellos.  
        */
        String marca, matricula, descripcion, propietarioNombre, propietarioDni;
        int kms, precio;
        LocalDate fechaMatricula;
        
        //Variable utilizada durante la validación del DNI
        boolean dniValidado=false;
        
        //Inicializamos la variable fechaMatricula 
        fechaMatricula=LocalDate.now();
        
        try {
            System.out.println("Introduce la marca: ");
            marca = entrada.nextLine();

            System.out.println("Introduce la matrícula: ");
            matricula = entrada.nextLine();

            do{
                System.out.println("Introduce los kilómetros: ");
                kms = entrada.nextInt();
                entrada.nextLine();
                if(!Validar.comprobarKms(kms)) System.out.println("Los kilómetros deben ser mayor que 0");
            } while (!Validar.comprobarKms(kms));

            do {
                System.out.println("Fecha de matriculación:");
                System.out.println("Día: ");
                int dia = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Mes: ");
                int mes = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Año: ");
                int anyo = entrada.nextInt();
                entrada.nextLine();
                
                try{
                    fechaMatricula = LocalDate.of(anyo, mes, dia);
                    
                    if (!Validar.comprobarFecha(fechaMatricula)) {
                        System.out.println("La fecha de matriculación debe ser anterior a la actual.");
                    }
                }catch(DateTimeException e){
                    System.out.println("Error al introducir la fecha");
                }
                
            } while (!Validar.comprobarFecha(fechaMatricula));

            System.out.println("Introduce una descripción: ");
            descripcion = entrada.nextLine();

            System.out.println("Introduce el precio: ");
            precio = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Introduce el nombre del propietario: ");
            propietarioNombre = entrada.nextLine();

            do{
                System.out.println("Introduce el DNI del propietario: ");
                propietarioDni = entrada.nextLine();
                try{
                    Validar.comprobarNIF(propietarioDni);
                    dniValidado=true;
                }catch(Exception e){
                    System.out.println("Nif erróneo");
                }
            }while(!dniValidado);

            objetoVehiculo = new Vehiculo(marca, matricula, kms, fechaMatricula, descripcion, precio, propietarioNombre, propietarioDni);
        } catch (InputMismatchException e) {
            entrada.nextLine();
            System.out.println("Error al introducir los datos");
        }
    }
}
