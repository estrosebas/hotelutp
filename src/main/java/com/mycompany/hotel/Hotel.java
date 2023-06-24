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
import javax.swing.JOptionPane;

public class Hotel {
    private static Scanner scanner = new Scanner(System.in);
    private static GestorHabitaciones gestorHabitaciones = new GestorHabitaciones();

    public static void main(String[] args) {
        // mostrarMenuHabitaciones();

        // contrasena;
        String Contraseña = "Admin";
        String opcionPass = "";
        int opcionmenu = 0;
        do {
            opcionmenu = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== Menú de Mantenimiento de Habitaciones === \n" +
                            "1. Ingresar contraseña\n" +
                            "0. Salir\n" +
                            "Seleccione una opción:"));

            switch (opcionmenu) {
                case 1:
                    opcionPass = JOptionPane.showInputDialog("Ingrese la contraseña:");
                    if (opcionPass.equals(Contraseña)) {
                        // System.out.println("Acceso exitoso");
                        JOptionPane.showMessageDialog(null, "Acceso exitoso");
                        MenuGeneral();
                    } else {
                        // System.out.println("Contraseña incorrecta");
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcionmenu != 0);
    }

    private static void MenuGeneral() {
        int MenuGeneralOption = 0;
        do {
            MenuGeneralOption = Integer.parseInt(JOptionPane.showInputDialog(
                    "===    Hotel UTP    ===\n" +
                            "1. Modulo Habitaciones\n" +
                            "2. Modulo Clientes\n" +
                            "0. Salir\n" +
                            "Seleccione una opción:"));

            switch (MenuGeneralOption) {
                case 1:
                    mostrarMenuHabitaciones();
                    break;
                case 2:
                    mostrarMenuClientes();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (MenuGeneralOption != 0);
    }

    ////////////// INICIO HABITACIONES/////
    private static void mostrarMenuHabitaciones() {
        int opcion = 0;
        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "=== Menú de Mantenimiento de Habitaciones ===\n"
                            + "1. Mostrar habitaciones\n"
                            + "2. Buscar habitación\n"
                            + "3. Insertar habitación\n"
                            + "4. Modificar habitación\n"
                            + "5. Eliminar habitación\n"
                            + "0. Salir"
                            + "Seleccione una opción: "));

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
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void buscarHabitacion() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a buscar:"));
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);
        
        if (habitacion != null) {
            JOptionPane.showMessageDialog(null, "Habitación encontrada: " + habitacion.toString());
        } else {
            JOptionPane.showMessageDialog(null,"Habitación no encontrada.");
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

    ////////////// FIN HABITACIONES
    ///////////// INICIO CLIENTES
    private static void mostrarMenuClientes() {
        int opcionClientes = 0;
        do {
            System.out.println("=== Menú de Gestión de Clientes ===");
            System.out.println("1. Mostrar clientes");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Modificar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcionClientes = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionClientes) {
                case 1:
                    gestorHabitaciones.mostrarClientes();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    registrarCliente();
                    break;
                case 4:
                    modificarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcionClientes != 0);
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
        Cliente cliente = new Cliente(dni, nombres, apellidos, direccion, sexo, fechaNacimiento, nacionalidad, correo,
                celular);

        // Llamar al método correspondiente del GestorHabitaciones para registrar al
        // cliente
        gestorHabitaciones.registrarCliente(cliente);

        System.out.println("Cliente registrado exitosamente.");

    }

    private static void buscarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente a buscar:");
        String dni = scanner.nextLine();

        // Llamar al método correspondiente del GestorHabitaciones para buscar al
        // cliente
        Cliente cliente = gestorHabitaciones.buscarCliente(dni);

        if (cliente != null) {
            String message = "Cliente encontrado:\n";
            message += "DNI: " + cliente.getDni() + "\n";
            message += "Nombres: " + cliente.getNombres() + "\n";
            message += "Apellidos: " + cliente.getApellidos() + "\n";
            message += "Dirección: " + cliente.getDireccion() + "\n";
            message += "Sexo: " + cliente.getSexo() + "\n";
            message += "Fecha de nacimiento: " + cliente.getFechaNacimiento() + "\n";
            message += "Nacionalidad: " + cliente.getNacionalidad() + "\n";
            message += "Correo: " + cliente.getCorreo() + "\n";
            message += "Celular: " + cliente.getCelular();

            JOptionPane.showMessageDialog(null, message, "Cliente encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El cliente con el DNI ingresado no existe.", "Cliente no encontrado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente a eliminar:");
        String dni = scanner.nextLine();

        // Verificar si el cliente existe
        // Llamar al método correspondiente del GestorHabitaciones para buscar al
        // cliente
        Cliente cliente = gestorHabitaciones.buscarCliente(dni);
        if (cliente != null) {
            // Llamar al método correspondiente del GestorHabitaciones para eliminar al
            // cliente
            gestorHabitaciones.eliminarCliente(dni);

            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("El cliente con el DNI ingresado no existe.");
        }
    }

    private static void modificarCliente() {
        System.out.print("Ingrese el dni del cliente a modificar: ");
        String dni = scanner.nextLine();
        // scanner.nextLine(); // Consumir el salto de línea
        // cliente
        Cliente clienteExistente = gestorHabitaciones.buscarCliente(dni);
        if (clienteExistente != null) {
            System.out.println("Cliente encontrado: " + clienteExistente.toString());
            System.out.println("Ingrese los nuevos datos del cliente:");

            System.out.print("Nuevos nombres: ");
            String nuevosNombres = scanner.nextLine();

            System.out.print("Nuevos apellidos: ");
            String nuevosApellidos = scanner.nextLine();

            System.out.print("Nueva dirección: ");
            String nuevaDireccion = scanner.nextLine();

            System.out.print("Nuevo sexo: ");
            String nuevoSexo = scanner.nextLine();

            System.out.print("Nueva fecha de nacimiento: ");
            String nuevaFechaNacimiento = scanner.nextLine();

            System.out.print("Nueva nacionalidad: ");
            String nuevaNacionalidad = scanner.nextLine();

            System.out.print("Nuevo correo: ");
            String nuevoCorreo = scanner.nextLine();

            System.out.print("Nuevo celular: ");
            String nuevoCelular = scanner.nextLine();

            // Crear un nuevo objeto Cliente con los nuevos datos
            //

            // Llamar al método correspondiente del GestorHabitaciones para modificar al
            // cliente
            gestorHabitaciones.modificarCliente(dni, nuevosNombres, nuevosApellidos, nuevaDireccion, nuevoSexo,
                    nuevaFechaNacimiento, nuevaNacionalidad, nuevoCorreo, nuevoCelular);

            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("El cliente con el DNI ingresado no existe.");
        }
    }
}