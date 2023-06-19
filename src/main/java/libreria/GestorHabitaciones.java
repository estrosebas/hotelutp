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

public class GestorHabitaciones {
    private static final String ARCHIVO_CSV = "habitaciones.csv";
    private List<Habitacion> habitaciones;

    // Constructor
    public GestorHabitaciones() {
        habitaciones = new ArrayList<>();
        cargarDatosDesdeCSV();
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
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion.toString());
        }
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
            System.out.println("La habitación ha sido eliminada exitosamente.");
        } else {
            System.out.println("La habitación no existe.");
        }
    }
}