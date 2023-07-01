/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

/**
 *
 * @author Sebas
 */
public class Hospedaje {
    private int numHospedaje;
    private String fechadeIngreso;
    private int numDiasHospedaje;
    private String lugardeorigen;
    private String observaciones;

    public Hospedaje(int numHospedaje, String fechadeIngreso, int numDiasHospedaje, String lugardeorigen,
            String observaciones) {
        this.numHospedaje = numHospedaje;
        this.fechadeIngreso = fechadeIngreso;
        this.numDiasHospedaje = numDiasHospedaje;
        this.lugardeorigen = lugardeorigen;
        this.observaciones = observaciones;
    }

    public int getNumHospedaje() {
        return numHospedaje;
    }

    public void setNumHospedaje(int numHospedaje) {
        this.numHospedaje = numHospedaje;
    }

    public String getFechadeIngreso() {
        return fechadeIngreso;
    }

    public void setFechadeIngreso(String fechadeIngreso) {
        this.fechadeIngreso = fechadeIngreso;
    }

    public int getNumDiasHospedaje() {
        return numDiasHospedaje;
    }

    public void setNumDiasHospedaje(int numDiasHospedaje) {
        this.numDiasHospedaje = numDiasHospedaje;
    }

    public String getLugardeorigen() {
        return lugardeorigen;
    }

    public void setLugardeorigen(String lugardeorigen) {
        this.lugardeorigen = lugardeorigen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // metodo para representar datos de cadena
    @Override
    public String toString() {
        return "Numero de hospedaje : " + numHospedaje +
                ", Fecha de ingreso : " + fechadeIngreso +
                ", Dias de hospedaje : " + numDiasHospedaje +
                ", Lugar de origen : " + lugardeorigen +
                ", Observaciones : " + observaciones;
    }
}