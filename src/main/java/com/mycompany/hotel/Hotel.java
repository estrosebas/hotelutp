/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotel;

/**
 *
 * @author Sebas
 */
//import java.util.Scanner;

import libreria.Cliente;
//import libreria.cuartos;
import libreria.GestorHabitaciones;
import libreria.Habitacion;
import libreria.Hospedaje;

import javax.swing.JOptionPane;

public class Hotel {
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
                            "3. Modulo hospedaje\n" +
                            "0. Salir\n" +
                            "Seleccione una opción: "));

            switch (MenuGeneralOption) {
                case 1:
                    mostrarMenuHabitaciones();
                    break;
                case 2:
                    mostrarMenuClientes();
                    break;
                case 3:
                    mostrarMenuHospedaje();
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
                            + "0. Salir\n"
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
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static Habitacion buscarHabitacion() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a buscar:"));
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);

        if (habitacion != null) {
            JOptionPane.showMessageDialog(null, "Habitación encontrada: " + habitacion.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
        }
        return habitacion;
    }

    private static void insertarHabitacion() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación:"));
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de habitación (simple | doble | triple):");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la habitación:"));
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la habitación (libre | ocupado):");

        Habitacion habitacion = new Habitacion(numero, tipo, precio, estado);
        gestorHabitaciones.insertarHabitacion(habitacion);
        JOptionPane.showMessageDialog(null, "La habitación ha sido insertada exitosamente.");
    }

    private static void modificarHabitacion() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a modificar:"));
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);

        if (habitacion != null) {
            JOptionPane.showMessageDialog(null, "Habitación encontrada: " + habitacion.toString());
            String tipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo de habitación (simple | doble | triple):");
            double precio = Double
                    .parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio de la habitación:"));
            String estado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la habitación (libre | ocupado):");

            gestorHabitaciones.modificarHabitacion(numero, tipo, precio, estado);
        } else {
            JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
        }
    }

    private static void eliminarHabitacion() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a eliminar:"));
        gestorHabitaciones.eliminarHabitacion(numero);
    }

    private static void cambiarEstadoHabitacion(int numero) {
        Habitacion habitacion = gestorHabitaciones.buscarHabitacion(numero);

        if (habitacion != null) {
            String estadoActual = habitacion.getEstado();
            String nuevoEstado = "";

            if (estadoActual.equals("libre")) {
                nuevoEstado = "ocupado";
            } else if (estadoActual.equals("ocupado")) {
                nuevoEstado = "libre";
            }

            gestorHabitaciones.modificarEstadoHabitacion(numero, nuevoEstado);
            JOptionPane.showMessageDialog(null, "Estado de la habitación cambiado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
        }
    }

    ////////////// FIN HABITACIONES
    ///////////// INICIO CLIENTES
    private static void mostrarMenuClientes() {
        int opcionClientes = 0;
        do {
            opcionClientes = Integer.parseInt(JOptionPane.showInputDialog(null, "=== Menú de Gestión de Clientes ===\n"
                    + "1. Mostrar clientes\n"
                    + "2. Buscar cliente\n"
                    + "3. Registrar cliente\n"
                    + "4. Modificar cliente\n"
                    + "5. Eliminar cliente\n"
                    + "0. Salir"));

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
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcionClientes != 0);
    }

    private static void registrarCliente() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI del cliente:");
        String nombres = JOptionPane.showInputDialog(null, "Ingrese los nombres del cliente:");
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese los apellidos del cliente:");
        String direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección del cliente:");
        String sexo = JOptionPane.showInputDialog(null, "Ingrese el sexo del cliente:");
        String fechaNacimiento = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento del cliente:");
        String nacionalidad = JOptionPane.showInputDialog(null, "Ingrese la nacionalidad del cliente:");
        String correo = JOptionPane.showInputDialog(null, "Ingrese el correo del cliente:", "Registro de Cliente");
        String celular = JOptionPane.showInputDialog(null, "Ingrese el celular del cliente:", "Registro de Cliente");

        // Crear un objeto Cliente con los datos ingresados
        Cliente cliente = new Cliente(dni, nombres, apellidos, direccion, sexo, fechaNacimiento, nacionalidad, correo,
                celular);

        // Llamar al método correspondiente del GestorHabitaciones para registrar al
        // cliente
        gestorHabitaciones.registrarCliente(cliente);

        JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
    }

    /////// SE REALIZO UN CAMBIO ESPECIFICIO PARA
    private static Cliente buscarCliente() {
        // SE USA STRING AL BUSCAR DNI EN CASO DE QUE EL DOCUMENT ODEL CLIENTE USE
        // CARACTERES DISTINTOS A NUNMEROS
        String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI del cliente a buscar:");

        // Llamar al método correspondiente del GestorHabitaciones para buscar al
        // cliente
        Cliente cliente = gestorHabitaciones.buscarCliente(dni);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: \n" + cliente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El cliente con el DNI ingresado no existe.");
        }

        return cliente; // Devolver el cliente encontrado
    }

    private static void eliminarCliente() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI del cliente a eliminar:");

        // Verificar si el cliente existe
        // Llamar al método correspondiente del GestorHabitaciones para buscar al
        // cliente
        Cliente cliente = gestorHabitaciones.buscarCliente(dni);
        if (cliente != null) {
            // Llamar al método correspondiente del GestorHabitaciones para eliminar al
            // cliente
            gestorHabitaciones.eliminarCliente(dni);

            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente con el DNI ingresado no existe.");
        }
    }

    private static void modificarCliente() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el dni del cliente a modificar:");
        Cliente clienteExistente = gestorHabitaciones.buscarCliente(dni);

        if (clienteExistente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + clienteExistente.toString());
            JOptionPane.showMessageDialog(null, "Ingrese los nuevos datos del cliente:");

            String nuevosNombres = JOptionPane.showInputDialog(null, "Nuevos nombres:");
            String nuevosApellidos = JOptionPane.showInputDialog(null, "Nuevos apellidos:");
            String nuevaDireccion = JOptionPane.showInputDialog(null, "Nueva dirección:");
            String nuevoSexo = JOptionPane.showInputDialog(null, "Nuevo sexo:");
            String nuevaFechaNacimiento = JOptionPane.showInputDialog(null, "Nueva fecha de nacimiento:");
            String nuevaNacionalidad = JOptionPane.showInputDialog(null, "Nueva nacionalidad:");
            String nuevoCorreo = JOptionPane.showInputDialog(null, "Nuevo correo:");
            String nuevoCelular = JOptionPane.showInputDialog(null, "Nuevo celular:");

            gestorHabitaciones.modificarCliente(dni, nuevosNombres, nuevosApellidos, nuevaDireccion, nuevoSexo,
                    nuevaFechaNacimiento, nuevaNacionalidad, nuevoCorreo, nuevoCelular);

            JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente con el DNI ingresado no existe.");
        }
    }

    ///////////////////////////////// FIN CLIENTES//////////
    // INICIO HOSPEDAJE//
    private static void mostrarMenuHospedaje() {
        int opcionHospedaje = 0;
        do {
            opcionHospedaje = Integer.parseInt(JOptionPane.showInputDialog(
                    "===    Módulo Hospedaje    ===\n" +
                            "1. Registrar hospedaje\n" +
                            "2. Consultar Huespedes\n" +
                            "2. Registrar salida de hospedaje\n" +
                            "0. Salir\n" +
                            "Seleccione una opción: "));

            switch (opcionHospedaje) {
                case 1:
                    registrarHospedaje();
                    break;
                case 2:
                    gestorHabitaciones.consultarHospedaje();    
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcionHospedaje != 0);
    }

    private static void registrarHospedaje() {
        Cliente cliente = buscarCliente();
        Habitacion habitacion = buscarHabitacion();

        if (habitacion != null) {
            int numHospedaje = habitacion.getNumero();
            String fechadeIngreso = JOptionPane.showInputDialog(null, "Ingrese la fecha de ingreso del hospedaje:");
            int numDiasHospedaje = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Ingrese los días de hospedaje:"));
            String lugardeorigen = JOptionPane.showInputDialog(null, "Ingrese la nacionalidad del cliente:");
            String observaciones = JOptionPane.showInputDialog(null, "Ingrese las observaciones:");
            String dnicliente = cliente.getDni();
            System.out.println(dnicliente);
            Hospedaje hospedaje = new Hospedaje(numHospedaje, fechadeIngreso, numDiasHospedaje, lugardeorigen,
                    observaciones);
            gestorHabitaciones.registrarHospedaje(hospedaje);
            cambiarEstadoHabitacion(numHospedaje);
            JOptionPane.showMessageDialog(null, "Hospedaje registrado exitosamente.");

            // Mostrar los datos del hospedaje registrado
            JOptionPane.showMessageDialog(null, "Datos del hospedaje:\n"
                    + "Habitación: " + numHospedaje + "\n"
                    + "Fecha de ingreso: " + fechadeIngreso + "\n"
                    + "Días de hospedaje: " + numDiasHospedaje + "\n"
                    + "Lugar de origen: " + lugardeorigen + "\n"
                    + "Observaciones: " + observaciones);
            // Mostrar datos del cliente
            JOptionPane.showMessageDialog(null, "Datos del cliente:\n" + cliente.toString() + "\n");
            // Mostrar datos de la habitacion
            JOptionPane.showMessageDialog(null, "Datos de la habitación:\n" + habitacion.toString() + "\n");

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el hospedaje. La habitación no existe.");
        }
    }

}