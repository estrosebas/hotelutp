/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

/**
 *
 * @author Sebas
 */
public class HistorialHuspedes {
    private String dni;
    private int habitacion;
    private String fecha;
    private String hora;
    private String comentario;
    
    // Constructor
    public HistorialHuspedes(String dni, int habitacion, String fecha, String hora, String comentario) {
        this.dni = dni;
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
    }
    
    // Getter y Setter para dni
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    // Getter y Setter para habitacion
    public int getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
    
    // Getter y Setter para fecha
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    // Getter y Setter para hora
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    // Getter y Setter para comentario
    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

