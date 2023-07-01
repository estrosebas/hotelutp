/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

/**
 *
 * @author Sebas
 */
public class Cliente {

    private String dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String sexo;
    private String fechaNacimiento;
    private String nacionalidad;
    private String correo;
    private String celular;

    // Constructor
    public Cliente(String dni, String nombres, String apellidos, String direccion, String sexo, String fechaNacimiento,
            String nacionalidad, String correo, String celular) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Método para representar los datos como una cadena
    @Override
    public String toString() {
        return "Documento: " +  dni +
                ", \n Nombres: " + nombres +
                ", \n Apellidos: " + apellidos +
                ", \n Dirección: " + direccion +
                ", \n Sexo: " + sexo +
                ", \n Fecha de nacimiento: " + fechaNacimiento +
                ", \n Nacionalidad: " + nacionalidad +
                ", \n Correo: " + correo +
                ", \n Celular: " + celular;
    }
}
