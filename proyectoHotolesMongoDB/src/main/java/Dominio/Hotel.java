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
public class Hotel {

    private ObjectId _id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String añoConstruccion;
    private Categoria categoria;

    /**
     * Constructor vacío de la clase Hotel. Se utiliza para crear instancias de
     * la clase sin proporcionar valores iniciales.
     */
    public Hotel() {

    }

    /**
     * Constructor de la clase Hotel que recibe parámetros para inicializar sus
     * atributos.
     *
     * @param _id Identificador único del hotel.
     * @param nombre Nombre del hotel.
     * @param direccion Dirección del hotel.
     * @param telefono Número de teléfono del hotel.
     * @param añoConstruccion Año de construcción del hotel.
     * @param categoria Categoría del hotel.
     */
    public Hotel(ObjectId _id, String nombre, String direccion, String telefono, String añoConstruccion, Categoria categoria) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añoConstruccion = añoConstruccion;
        this.categoria = categoria;
    }

    /**
     * Constructor de la clase Hotel que recibe parámetros para inicializar sus
     * atributos.
     *
     * @param nombre Nombre del hotel.
     * @param direccion Dirección del hotel.
     * @param telefono Número de teléfono del hotel.
     * @param añoConstruccion Año de construcción del hotel.
     * @param categoria Categoría del hotel.
     */
    public Hotel(String nombre, String direccion, String telefono, String añoConstruccion, Categoria categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añoConstruccion = añoConstruccion;
        this.categoria = categoria;
    }

    /**
     * Obtiene el identificador único del hotel.
     *
     * @return Identificador único del hotel.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único del hotel.
     *
     * @param _id Nuevo identificador único del hotel.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el nombre del hotel.
     *
     * @return Nombre del hotel.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del hotel.
     *
     * @param nombre Nuevo nombre del hotel.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del hotel.
     *
     * @return Dirección del hotel.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del hotel.
     *
     * @param direccion Nueva dirección del hotel.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del hotel.
     *
     * @return Número de teléfono del hotel.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del hotel.
     *
     * @param telefono Nuevo número de teléfono del hotel.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el año de construcción del hotel.
     *
     * @return Año de construcción del hotel.
     */
    public String getAñoConstruccion() {
        return añoConstruccion;
    }

    /**
     * Establece el año de construcción del hotel.
     *
     * @param añoConstruccion Nuevo año de construcción del hotel.
     */
    public void setAñoConstruccion(String añoConstruccion) {
        this.añoConstruccion = añoConstruccion;
    }

    /**
     * Obtiene la categoría del hotel.
     *
     * @return Categoría del hotel.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del hotel.
     *
     * @param categoria Nueva categoría del hotel.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
