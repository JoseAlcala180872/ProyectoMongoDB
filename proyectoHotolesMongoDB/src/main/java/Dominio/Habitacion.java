/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import org.bson.types.ObjectId;

/**
 *
 * @author 
 */
public class Habitacion {
    private ObjectId _id;
    private String tipoHabitacion;
    private int numeroHabitacion;
    private double tarifa;
    private Hotel hotel;
    private boolean isAsignado;

    public Habitacion(){  
    }
    
    /**
     * 
     * @param _id
     * @param tipoHabitacion
     * @param numeroHabitacion
     * @param tarifa 
     * @param hotel 
     */
    public Habitacion(ObjectId _id, String tipoHabitacion, int numeroHabitacion, double tarifa, Hotel hotel, boolean isAsignado) {
        this._id = _id;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifa = tarifa;
        this.hotel = hotel;
        this.isAsignado = isAsignado;
    }
    
    /**
     * 
     * @param tipoHabitacion
     * @param numeroHabitacion
     * @param tarifa 
     */
    public Habitacion(String tipoHabitacion, int numeroHabitacion, double tarifa, Hotel hotel, boolean isAsignado) {
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifa = tarifa;
        this.hotel = hotel;
        this.isAsignado = isAsignado;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isIsAsignado() {
        return isAsignado;
    }

    public void setIsAsignado(boolean isAsignado) {
        this.isAsignado = isAsignado;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "_id=" + _id + ", tipoHabitacion=" + tipoHabitacion + ", numeroHabitacion=" + numeroHabitacion + ", tarifa=" + tarifa + ", hotel=" + hotel + ", isAsignado=" + isAsignado + '}';
    }
    
    
    
    
}
