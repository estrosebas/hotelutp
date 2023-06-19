/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloMHabitaciones;

/**
 *
 * @author Sebas
 */
import java.util.Scanner;

public class cuartos {

    Scanner lector = new Scanner(System.in);
///atributos :D
    private int numero;
    private String tipo;
    private double precio;
    private String estado;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void pedirnumero() {
        System.out.println("ingrese el numero de habitacion");
        numero = lector.nextInt();
    }

    public void pedirprecio() {
        System.out.println("ingrese el precio de la habitacion");
        precio = lector.nextDouble();
    }

    public void pedirtipo() {
        System.out.println("ingrese el tipo de habitacion");
        lector.nextLine();
        tipo = lector.nextLine();
        
    }

    public void consultar() {
        System.out.println(tipo + " cuesta " + precio);
    }

}
