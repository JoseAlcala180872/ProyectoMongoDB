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

    /**
     * Constructor vacío de la clase Reservacion. Se utiliza para crear
     * instancias de la clase sin proporcionar valores iniciales.
     */
    public Reservacion() {

    }

    /**
     * Constructor de la clase Reservacion que recibe parámetros para
     * inicializar sus atributos.
     *
     * @param _id Identificador único de la reservación.
     * @param cliente Cliente asociado a la reservación.
     * @param nombre Nombre asociado a la reservación.
     * @param direccion Dirección asociada a la reservación.
     * @param telefono Teléfono asociado a la reservación.
     * @param tarifa Tarifa asociada a la reservación.
     * @param categoriaHotel Hotel asociado a la reservación.
     * @param periodoEstancia Período de estancia asociado a la reservación.
     * @param claseHabitacion Habitación asociada a la reservación.
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
     * Constructor de la clase Reservacion que recibe parámetros para
     * inicializar sus atributos.
     *
     * @param cliente Cliente asociado a la reservación.
     * @param nombre Nombre asociado a la reservación.
     * @param direccion Dirección asociada a la reservación.
     * @param telefono Teléfono asociado a la reservación.
     * @param tarifa Tarifa asociada a la reservación.
     * @param categoriaHotel Hotel asociado a la reservación.
     * @param periodoEstancia Período de estancia asociado a la reservación.
     * @param claseHabitacion Habitación asociada a la reservación.
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

    /**
     * Obtiene el identificador único de la reservación.
     *
     * @return Identificador único de la reservación.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único de la reservación.
     *
     * @param _id Nuevo identificador único de la reservación.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el cliente asociado a la reservación.
     *
     * @return Cliente asociado a la reservación.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la reservación.
     *
     * @param cliente Nuevo cliente asociado a la reservación.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el nombre asociado a la reservación.
     *
     * @return Nombre asociado a la reservación.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre asociado a la reservación.
     *
     * @param nombre Nuevo nombre asociado a la reservación.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección asociada a la reservación.
     *
     * @return Dirección asociada a la reservación.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección asociada a la reservación.
     *
     * @param direccion Nueva dirección asociada a la reservación.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono asociado a la reservación.
     *
     * @return Teléfono asociado a la reservación.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono asociado a la reservación.
     *
     * @param telefono Nuevo teléfono asociado a la reservación.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la tarifa asociada a la reservación.
     *
     * @return Tarifa asociada a la reservación.
     */
    public Hotel getCategoriaHotel() {
        return categoriaHotel;
    }

    /**
     * Establece el hotel asociado a la reservación.
     *
     * @param categoriaHotel Nuevo hotel asociado a la reservación.
     */
    public void setCategoriaHotel(Hotel categoriaHotel) {
        this.categoriaHotel = categoriaHotel;
    }

    /**
     * Obtiene el período de estancia asociado a la reservación.
     *
     * @return Período de estancia asociado a la reservación.
     */
    public int getPeriodoEstancia() {
        return periodoEstancia;
    }

    /**
     * Establece el período de estancia asociado a la reservación.
     *
     * @param periodoEstancia Nuevo período de estancia asociado a la
     * reservación.
     */
    public void setPeriodoEstancia(int periodoEstancia) {
        this.periodoEstancia = periodoEstancia;
    }

    /**
     * Obtiene la habitación asociada a la reservación.
     *
     * @return Habitación asociada a la reservación.
     */
    public Habitacion getClaseHabitacion() {
        return claseHabitacion;
    }

    /**
     * Establece la habitación asociada a la reservación.
     *
     * @param claseHabitacion Nueva habitación asociada a la reservación.
     */
    public void setClaseHabitacion(Habitacion claseHabitacion) {
        this.claseHabitacion = claseHabitacion;
    }

    /**
     * Obtiene la tarifa asociada a la reservación.
     *
     * @return Tarifa asociada a la reservación.
     */
    public Double getTarifa() {
        return tarifa;
    }

    /**
     * Establece la tarifa asociada a la reservación.
     *
     * @param tarifa Nueva tarifa asociada a la reservación.
     */
    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

}
