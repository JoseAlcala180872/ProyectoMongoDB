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
public class Cliente {

    private ObjectId _id;
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * Constructor vacío de la clase Cliente. Se utiliza para crear instancias
     * de la clase sin proporcionar valores iniciales.
     */
    public Cliente() {

    }

    /**
     * Constructor de la clase Cliente que recibe el identificador único como
     * parámetro.
     *
     * @param _id Identificador único del cliente.
     */
    public Cliente(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Constructor de la clase Cliente que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param _id Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Número de teléfono del cliente.
     */
    public Cliente(ObjectId _id, String nombre, String direccion, String telefono) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Constructor de la clase Cliente que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Número de teléfono del cliente.
     */
    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return Identificador único del cliente.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único del cliente.
     *
     * @param _id Nuevo identificador único del cliente.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     *
     * @param direccion Nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return Número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono Nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
