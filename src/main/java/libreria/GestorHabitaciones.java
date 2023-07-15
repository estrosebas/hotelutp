/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import java.io.*;
import javax.swing.JOptionPane;

public class GestorHabitaciones {
    private static final String ARCHIVO_CSV = "habitaciones.csv";
    private static final String ARCHIVO_CSV_HOSPEDAJES = "hospedajes.csv";
    private static final String ARCHIVO_CSV_CLIENTES = "clientes.csv";
    private static final String ARCHIVO_CSV_HISTORIALHUESPEDES = "historial.csv";
    // private static final String ARCHIVO_CSV_CLIENTES = "ARCHIVO_CLIENTES_CSV";
    private Habitacion[] habitaciones;
    private Cliente[] clientes;
    private Hospedaje[] hospedajes;
    private HistorialHuspedes[] historialHuspedes;
    private int numHabitaciones;
    private int numClientes;
    private int numHospedajes;
    private int numHistorialHuspedes;

    public GestorHabitaciones() {
        habitaciones = new Habitacion[100]; // Tamaño inicial del arreglo
        clientes = new Cliente[100]; // Tamaño inicial del arreglo
        hospedajes = new Hospedaje[100]; // Tamaño inicial del arreglo
        historialHuspedes = new HistorialHuspedes[100]; // Tamaño inicial del arreglo
        numHabitaciones = 0;
        numClientes = 0;
        numHospedajes = 0;
        numHistorialHuspedes = 0;
        cargarDatosDesdeCSV();
        cargarDatosClientesDesdeCSV();
        cargarDatosHospedajeDesdeCSV();
    }

    // Método para cargar los datos desde el archivo CSV
    private void cargarDatosDesdeCSV() {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(ARCHIVO_CSV));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int numero = Integer.parseInt(data[0]);
                String tipo = data[1];
                double precio = Double.parseDouble(data[2]);
                String estado = data[3];
                Habitacion habitacion = new Habitacion(numero, tipo, precio, estado);
                habitaciones[numHabitaciones] = habitacion;
                numHabitaciones++;
            }
        } catch (FileNotFoundException e) {
            // El archivo no existe, se creará uno nuevo al guardar los datos
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método para guardar los datos en el archivo CSV
    private void guardarDatosEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CSV))) {
            for (int i = 0; i < numHabitaciones; i++) {
                Habitacion habitacion = habitaciones[i];
                bw.write(habitacion.getNumero() + "," +
                        habitacion.getTipo() + "," +
                        habitacion.getPrecio() + "," +
                        habitacion.getEstado());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar la información de todas las habitaciones
    public void mostrarHabitaciones() {
        String listadodehabitaciones = "";
        for (int i = 0; i < numHabitaciones; i++) {
            Habitacion habitacion = habitaciones[i];
            listadodehabitaciones += habitacion.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listadodehabitaciones);
    }

    // Método para buscar una habitación por número
    public Habitacion buscarHabitacion(int numero) {
        for (int i = 0; i < numHabitaciones; i++) {
            Habitacion habitacion = habitaciones[i];
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null; // Habitación no encontrada
    }

    // Método para insertar una nueva habitación
    public void insertarHabitacion(Habitacion habitacion) {
        habitaciones[numHabitaciones] = habitacion;
        numHabitaciones++;
        guardarDatosEnCSV();
    }

    // Método para modificar una habitación existente
    public void modificarHabitacion(int numero, String tipo, double precio, String estado) {
        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion != null) {
            habitacion.setTipo(tipo);
            habitacion.setPrecio(precio);
            habitacion.setEstado(estado);
            guardarDatosEnCSV();
            System.out.println("La habitación ha sido modificada exitosamente.");
        } else {
            System.out.println("La habitación no existe.");
        }
    }

    // Método para eliminar una habitación existente
    public void eliminarHabitacion(int numero) {
        for (int i = 0; i < numHabitaciones; i++) {
            Habitacion habitacion = habitaciones[i];
            if (habitacion.getNumero() == numero) {
                for (int j = i; j < numHabitaciones - 1; j++) {
                    habitaciones[j] = habitaciones[j + 1];
                }
                numHabitaciones--;
                guardarDatosEnCSV();
                break;
            }
        }
    }

    public void modificarEstadoHabitacion(int numero, String nuevoEstado) {
        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion != null) {
            habitacion.setEstado(nuevoEstado);
            guardarDatosEnCSV();
        }
    }

    //////////////////////////////////////////////// cliente////////////////////////////////////
    // Método para cargar datos del clientes desde el csv
    private void cargarDatosClientesDesdeCSV() {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(ARCHIVO_CSV_CLIENTES));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String dni = data[0];
                String nombres = data[1];
                String apellidos = data[2];
                String direccion = data[3];
                String sexo = data[4];
                // Parsear la fecha de nacimiento si está en un formato específico
                String fechaNacimiento = (data[5]);
                String nacionalidad = data[6];
                String correo = data[7];
                String celular = data[8];

                Cliente cliente = new Cliente(dni, nombres, apellidos, direccion, sexo, fechaNacimiento, nacionalidad,
                        correo, celular);
                clientes[numClientes] = cliente;
                numClientes++;
            }
        } catch (FileNotFoundException e) {
            // El archivo no existe, se creará uno nuevo al guardar los datos
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método para guardar datos del clientes desde el csv
    private void guardarDatosClientesEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CSV_CLIENTES))) {
            for (int i = 0; i < numClientes; i++) {
                Cliente cliente = clientes[i];
                bw.write(cliente.getDni() + "," +
                        cliente.getNombres() + "," +
                        cliente.getApellidos() + "," +
                        cliente.getDireccion() + "," +
                        cliente.getSexo() + "," +
                        cliente.getFechaNacimiento() + "," +
                        cliente.getNacionalidad() + "," +
                        cliente.getCorreo() + "," +
                        cliente.getCelular());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientes() {
        String Listaclientes = "";
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = clientes[i];
            Listaclientes += "DNI = " + cliente.getDni() + "\n";
        }
        JOptionPane.showMessageDialog(null, Listaclientes);
    }

    public Cliente buscarCliente(String dni) {
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = clientes[i];
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        clientes[numClientes] = cliente;
        numClientes++;
        guardarDatosClientesEnCSV();
    }

    public void eliminarCliente(String dni) {
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = clientes[i];
            if (cliente.getDni().equals(dni)) {
                for (int j = i; j < numClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                numClientes--;
                guardarDatosClientesEnCSV();
                System.out.println("El cliente ha sido eliminado exitosamente.");
                break;
            }
        }
    }

    public void modificarCliente(String dni, String nuevoNombres, String nuevoApellidos, String nuevoDireccion,
            String nuevoSexo, String nuevoFechanacimiento, String nuevoNacionalidad, String nuevvoCorreo,
            String nuevoCelular) {
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = clientes[i];
            if (cliente.getDni().equals(dni)) {
                cliente.setNombres(nuevoNombres);
                cliente.setApellidos(nuevoApellidos);
                cliente.setDireccion(nuevoDireccion);
                cliente.setSexo(nuevoSexo);
                cliente.setFechaNacimiento(nuevoFechanacimiento);
                cliente.setNacionalidad(nuevoNacionalidad);
                cliente.setCorreo(nuevvoCorreo);
                cliente.setCelular(nuevoCelular);
                guardarDatosClientesEnCSV();
                System.out.println("El cliente ha sido modificada exitosamente.");
                break;
            }
        }
    }

    ////// hospedaje

    private void cargarDatosHospedajeDesdeCSV() {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(ARCHIVO_CSV_HOSPEDAJES));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int numHospedaje = Integer.parseInt(data[0]);
                String fechadeIngreso = data[1];
                int numDiasHospedaje = Integer.parseInt(data[2]);
                String lugardeorigen = data[3];
                String observaciones = data[4];
                String dni = data[5];

                Hospedaje hospedaje = new Hospedaje(numHospedaje, fechadeIngreso, numDiasHospedaje, lugardeorigen,
                        observaciones, dni);
                hospedajes[numHospedajes] = hospedaje;
                numHospedajes++;
            }
        } catch (FileNotFoundException e) {
            // El archivo no existe, se creará uno nuevo al guardar los datos
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void guardarDatosHospedajeEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CSV_HOSPEDAJES))) {
            for (int i = 0; i < numHospedajes; i++) {
                Hospedaje hospedaje = hospedajes[i];
                bw.write(hospedaje.getNumHospedaje() + "," +
                        hospedaje.getFechadeIngreso() + "," +
                        hospedaje.getNumDiasHospedaje() + "," +
                        hospedaje.getLugardeorigen() + "," +
                        hospedaje.getObservaciones() + "," +
                        hospedaje.getDni());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // crear hospedaje
    public void registrarHospedaje(Hospedaje hospedaje) {
        hospedajes[numHospedajes] = hospedaje;
        numHospedajes++;
        guardarDatosHospedajeEnCSV();
    }

    // mostrar hospedaje
    public void consultarHospedaje() {
        String listadodehuespedes = "";
        for (int i = 0; i < numHospedajes; i++) {
            Hospedaje hospedaje = hospedajes[i];
            listadodehuespedes += hospedaje.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listadodehuespedes);
    }

    public void mostrarHabitacionesLibres() {
        String listadodehabitaciones = "";
        for (int i = 0; i < numHabitaciones; i++) {
            Habitacion habitacion = habitaciones[i];
            if (habitacion.getEstado().equals("libre")) {
                listadodehabitaciones += habitacion.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "Habitaciones libres\n" + listadodehabitaciones);
    }

    public Hospedaje buscarHospedajeDni(String dni) {
        for (int i = 0; i < numHospedajes; i++) {
            Hospedaje hospedaje = hospedajes[i];
            if (hospedaje.getDni().equals(dni)) {
                return hospedaje;
            }
        }
        return null;
    }

    public Hospedaje buscarHospedajeHabitacion(int numHospedaje) {
        for (int i = 0; i < numHospedajes; i++) {
            Hospedaje hospedaje = hospedajes[i];
            if (hospedaje.getNumHospedaje() == numHospedaje) {
                return hospedaje;
            }
        }
        return null;
    }

    public void eliminarHospedaje(Hospedaje hospedaje) {
        if (hospedaje != null) {
            for (int i = 0; i < numHospedajes; i++) {
                if (hospedajes[i] == hospedaje) {
                    for (int j = i; j < numHospedajes - 1; j++) {
                        hospedajes[j] = hospedajes[j + 1];
                    }
                    numHospedajes--;
                    guardarDatosHospedajeEnCSV(); // Corrección del método para guardar los datos de hospedaje
                    break;
                }
            }
        }
    }

    //////////////////////// salida huespedesdes
    private void guardarDatosHuespedhistorialEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CSV_HISTORIALHUESPEDES))) {
            for (int i = 0; i < numHistorialHuspedes; i++) {
                HistorialHuspedes historialHuespedes = historialHuspedes[i];
                bw.write(historialHuespedes.getDni() + "," +
                        historialHuespedes.getHabitacion() + "," +
                        historialHuespedes.getFecha() + "," +
                        historialHuespedes.getHora() + "," +
                        historialHuespedes.getComentario());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarHistorial(HistorialHuspedes historialHuespedes) {
        historialHuspedes[numHistorialHuspedes] = historialHuespedes;
        numHistorialHuspedes++;
        guardarDatosHuespedhistorialEnCSV();
    }

}
