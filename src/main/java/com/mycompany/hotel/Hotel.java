/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotel;

/**
 *
 * @author Sebas
 */
import java.util.Scanner;

import libreria.Cliente;
//import libreria.cuartos;
import libreria.GestorHabitaciones;
import libreria.Habitacion;

public class Hotel {
    private static Scanner scanner = new Scanner(System.in);
    private static GestorHabitaciones gestorHabitaciones = new GestorHabitaciones();

    public static void main(String[] args) {
        //mostrarMenuHabitaciones();
        MenuGeneral();
    }
    private static void MenuGeneral() {
    int MenuGeneralOption = 0;
    do {
        System.out.println("===    Hotel UTP    ===");
        System.out.println("1. Modulo Habitaciones");
        System.out.println("2. Modulo Clientes");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        MenuGeneralOption = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (MenuGeneralOption) {
            case 1:
                mostrarMenuHabitaciones();
                break;
            case 2:
                mostrarMenuClientes();
                break;
            case 0:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
        System.out.println();
    } while (MenuGeneralOption != 0);
}

    private static void mostrarMenuHabitaciones() {
        int opcion = 0;
        do {
            System.out.println("=== Menú de Mantenimiento de Habitaciones ===");
            System.out.println("1. Mostrar habitaciones");
            System.out.println("2. Buscar habitación");
            System.out.println("3. Insertar habitación");
            System.out.println("4. Modificar habitación");
            System.out.println("5. Eliminar habitación");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    gestorHabitaciones.mostrarHabitaciones();
                    break;
                case 2:
                    buscarHabitacion();
                    break;
                case 3:
                    insertarHabitacion();
                    break;
                case 4:
                    modificarHabitacion();
                    break;
                case 5:
                    eliminarHabitacion();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void buscarHabitacion() {
        System.out.print("Ingrese el número de habitación a buscar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);
        if (habitacion != null) {
            System.out.println("Habitación encontrada: " + habitacion.toString());
        } else {
            System.out.println("Habitación no encontrada.");
        }
    }

    private static void insertarHabitacion() {
        System.out.print("Ingrese el número de habitación: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el tipo de habitación (simple | doble | triple): ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese el precio de la habitación: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el estado de la habitación (libre | ocupado): ");
        String estado = scanner.nextLine();

        Habitacion habitacion = new Habitacion(numero, tipo, precio, estado);
        gestorHabitaciones.insertarHabitacion(habitacion);
        System.out.println("La habitación ha sido insertada exitosamente.");
    }

    private static void modificarHabitacion() {
        System.out.print("Ingrese el número de habitación a modificar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);
        if (habitacion != null) {
            System.out.println("Habitación encontrada: " + habitacion.toString());
            System.out.print("Ingrese el nuevo tipo de habitación (simple | doble | triple): ");
            String tipo = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio de la habitación: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese el nuevo estado de la habitación (libre | ocupado): ");
            String estado = scanner.nextLine();

            gestorHabitaciones.modificarHabitacion(numero, tipo, precio, estado);
        } else {
            System.out.println("Habitación no encontrada.");
        }
    }

    private static void eliminarHabitacion() {
        System.out.print("Ingrese el número de habitación a eliminar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        gestorHabitaciones.eliminarHabitacion(numero);
    }

    private static void mostrarMenuClientes() {
    int opcion = 0;
    do {
        System.out.println("=== Menú de Gestión de Clientes ===");
        System.out.println("1. Mostrar clientes");
        System.out.println("2. Buscar cliente");
        System.out.println("3. Registrar cliente");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                //gestorHabitaciones.mostrarClientes();
                break;
            case 2:
                //buscarCliente();
                break;
            case 3:
                registrarCliente();
                break;
            case 4:
                //modificarCliente();
                break;
            case 5:
                //eliminarCliente();
                break;
            case 0:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
        System.out.println();
    } while (opcion != 0);
}
    
    private static void registrarCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el DNI del cliente:");
    String dni = scanner.nextLine();
    System.out.println("Ingrese los nombres del cliente:");
    String nombres = scanner.nextLine();
    System.out.println("Ingrese los apellidos del cliente:");
    String apellidos = scanner.nextLine();
    System.out.println("Ingrese la dirección del cliente:");
    String direccion = scanner.nextLine();
    System.out.println("Ingrese el sexo del cliente:");
    String sexo = scanner.nextLine();
    System.out.println("Ingrese la fecha de nacimiento del cliente");
    String fechaNacimiento = scanner.nextLine();
    System.out.println("Ingrese la nacionalidad del cliente");
    String nacionalidad = scanner.nextLine();
    System.out.println("Ingrese el correo del cliente");
    String correo = scanner.nextLine();
    System.out.println("Ingrese el celular del cliente");
    String celular = scanner.nextLine();
    // Crear un objeto Cliente con los datos ingresados
    Cliente cliente = new Cliente(dni, nombres, apellidos, direccion, sexo, fechaNacimiento, nacionalidad, correo, celular);

    // Llamar al método correspondiente del GestorHabitaciones para registrar al cliente
    gestorHabitaciones.registrarCliente(cliente);

    System.out.println("Cliente registrado exitosamente.");
    scanner.close();
}
//comentario
}