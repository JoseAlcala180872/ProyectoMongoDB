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
public class Reservacion {

    private ObjectId _id;
    private Cliente cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private Double tarifa;
    private Hotel categoriaHotel;
    private int periodoEstancia; //Tipo de dato temporal, tiene que ser tipo Periodo. Será una clase que se creará
    private Habitacion claseHabitacion;

    public Reservacion() {

    }

    /**
     *
     * @param _id
     * @param cliente
     * @param nombre
     * @param direccion
     * @param telefono
     * @param categoriaHotel
     * @param periodoEstancia
     * @param claseHabitacion
     */
    public Reservacion(ObjectId _id, Cliente cliente, String nombre, String direccion, String telefono, Double tarifa, Hotel categoriaHotel, int periodoEstancia, Habitacion claseHabitacion) {
        this._id = _id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarifa = tarifa;
        this.categoriaHotel = categoriaHotel;
        this.periodoEstancia = periodoEstancia;
        this.claseHabitacion = claseHabitacion;
    }

    /**
     *
     * @param cliente
     * @param nombre
     * @param direccion
     * @param telefono
     * @param categoriaHotel
     * @param periodoEstancia
     * @param claseHabitacion
     */
    public Reservacion(Cliente cliente, String nombre, String direccion, String telefono, double tarifa, Hotel categoriaHotel, int periodoEstancia, Habitacion claseHabitacion) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarifa = tarifa;
        this.categoriaHotel = categoriaHotel;
        this.periodoEstancia = periodoEstancia;
        this.claseHabitacion = claseHabitacion;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Hotel getCategoriaHotel() {
        return categoriaHotel;
    }

    public void setCategoriaHotel(Hotel categoriaHotel) {
        this.categoriaHotel = categoriaHotel;
    }

    public int getPeriodoEstancia() {
        return periodoEstancia;
    }

    public void setPeriodoEstancia(int periodoEstancia) {
        this.periodoEstancia = periodoEstancia;
    }

    public Habitacion getClaseHabitacion() {
        return claseHabitacion;
    }

    public void setClaseHabitacion(Habitacion claseHabitacion) {
        this.claseHabitacion = claseHabitacion;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
    
    

}
