/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import org.bson.types.ObjectId;

/**
 *
 * @author marcos_zr
 */
public class Habitacion {
    private ObjectId _id;
    private String tipoHabitacion;
    private int numeroHabitacion;
    private double tarifa;

    public Habitacion(){
        
    }
    
    /**
     * 
     * @param _id
     * @param tipoHabitacion
     * @param numeroHabitacion
     * @param tarifa 
     */
    public Habitacion(ObjectId _id, String tipoHabitacion, int numeroHabitacion, double tarifa) {
        this._id = _id;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifa = tarifa;
    }
    
    /**
     * 
     * @param tipoHabitacion
     * @param numeroHabitacion
     * @param tarifa 
     */
    public Habitacion(String tipoHabitacion, int numeroHabitacion, double tarifa) {
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifa = tarifa;
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
    
    
    
}
