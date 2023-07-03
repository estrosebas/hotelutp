/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

/**
 *
 * @author Sebas
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestorHabitaciones {
    private static final String ARCHIVO_CSV = "hotelutp/habitaciones.csv";
    private static final String ARCHIVO_CSV_HOSPEDAJES = "hotelutp/hospedajes.csv";
    private static final String ARCHIVO_CSV_CLIENTES = "hotelutp/clientes.csv";
    // private static final String ARCHIVO_CSV_CLIENTES = "ARCHIVO_CLIENTES_CSV";
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Hospedaje> hospedajes;

    public GestorHabitaciones() {
        habitaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        hospedajes = new ArrayList<>();
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
                habitaciones.add(habitacion);
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
            for (Habitacion habitacion : habitaciones) {
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
        for (Habitacion habitacion : habitaciones) {
            listadodehabitaciones += habitacion.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listadodehabitaciones);
    }

    // Método para buscar una habitación por número
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null; // Habitación no encontrada
    }

    // Método para insertar una nueva habitación
    public void insertarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
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
        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion != null) {
            habitaciones.remove(habitacion);
            guardarDatosEnCSV();
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
                clientes.add(cliente);
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
            for (Cliente cliente : clientes) {
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
        for (Cliente cliente : clientes) {
            Listaclientes += "DNI = " + cliente.getDni() + "\n";
        }
        JOptionPane.showMessageDialog(null, Listaclientes);
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarDatosClientesEnCSV();
    }

    public void eliminarCliente(String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            guardarDatosClientesEnCSV();
            System.out.println("El cliente ha sido eliminado exitosamente.");
        } else {
            System.out.println("El cliente no existe.");
        }
    }

    public void modificarCliente(String dni, String nuevoNombres, String nuevoApellidos, String nuevoDireccion,
            String nuevoSexo, String nuevoFechanacimiento, String nuevoNacionalidad, String nuevvoCorreo,
            String nuevoCelular) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            // cliente.setTipo(tipo);
            // cliente.setPrecio(precio);
            // cliente.setEstado(estado);
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
        } else {
            System.out.println("El cliente no existe.");
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
                hospedajes.add(hospedaje);
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
            for (Hospedaje hospedaje : hospedajes) {
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
        hospedajes.add(hospedaje);
        guardarDatosHospedajeEnCSV();
    }

    // mostrar hospedaje
    public void consultarHospedaje() {
        String listadodehuespedes = "";
        for (Hospedaje hospedaje : hospedajes) {
            listadodehuespedes += hospedaje.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listadodehuespedes);
    }
}
