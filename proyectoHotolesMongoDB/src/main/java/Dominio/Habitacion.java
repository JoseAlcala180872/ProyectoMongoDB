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

    /**
     * Constructor vacío de la clase Habitacion. Se utiliza para crear
     * instancias de la clase sin proporcionar valores iniciales.
     */
    public Habitacion() {
    }

    /**
     * Constructor de la clase Habitacion que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param _id Identificador único de la habitación.
     * @param tipoHabitacion Tipo de habitación.
     * @param numeroHabitacion Número de la habitación.
     * @param tarifa Tarifa de la habitación.
     * @param hotel Hotel al que pertenece la habitación.
     * @param isAsignado Indica si la habitación está asignada o no.
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
     * Constructor de la clase Habitacion que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param tipoHabitacion Tipo de habitación.
     * @param numeroHabitacion Número de la habitación.
     * @param tarifa Tarifa de la habitación.
     * @param hotel Hotel al que pertenece la habitación.
     * @param isAsignado Indica si la habitación está asignada o no.
     */
    public Habitacion(String tipoHabitacion, int numeroHabitacion, double tarifa, Hotel hotel, boolean isAsignado) {
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tarifa = tarifa;
        this.hotel = hotel;
        this.isAsignado = isAsignado;
    }

    /**
     * Obtiene el identificador único de la habitación.
     *
     * @return Identificador único de la habitación.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único de la habitación.
     *
     * @param _id Nuevo identificador único de la habitación.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el tipo de habitación.
     *
     * @return Tipo de habitación.
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de habitación.
     *
     * @param tipoHabitacion Nuevo tipo de habitación.
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Obtiene el número de la habitación.
     *
     * @return Número de la habitación.
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Establece el número de la habitación.
     *
     * @param numeroHabitacion Nuevo número de la habitación.
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Obtiene la tarifa de la habitación.
     *
     * @return Tarifa de la habitación.
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Establece la tarifa de la habitación.
     *
     * @param tarifa Nueva tarifa de la habitación.
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Obtiene el hotel al que pertenece la habitación.
     *
     * @return Hotel al que pertenece la habitación.
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Establece el hotel al que pertenece la habitación.
     *
     * @param hotel Nuevo hotel al que pertenece la habitación.
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Indica si la habitación está asignada o no.
     *
     * @return true si la habitación está asignada, false si no lo está.
     */
    public boolean isIsAsignado() {
        return isAsignado;
    }

    /**
     * Establece si la habitación está asignada o no.
     *
     * @param isAsignado true si la habitación está asignada, false si no lo
     * está.
     */
    public void setIsAsignado(boolean isAsignado) {
        this.isAsignado = isAsignado;
    }

    /**
     * Genera una representación en cadena de la habitación.
     *
     * @return Cadena que representa la habitación.
     */
    @Override
    public String toString() {
        return "Habitacion{" + "_id=" + _id + ", tipoHabitacion=" + tipoHabitacion + ", numeroHabitacion=" + numeroHabitacion + ", tarifa=" + tarifa + ", hotel=" + hotel + ", isAsignado=" + isAsignado + '}';
    }

}
