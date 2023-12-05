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
public class Persona extends Cliente {

    private Cliente cliente;

    /**
     * Constructor vacío de la clase Persona. Se utiliza para crear instancias
     * de la clase sin proporcionar valores iniciales.
     */
    public Persona() {

    }

    /**
     * Constructor de la clase Persona que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param _id Identificador único de la persona.
     * @param cliente Cliente asociado a la persona.
     */
    public Persona(ObjectId _id, Cliente cliente) {
        super(_id);
        this.cliente = cliente;
    }

    /**
     * Constructor de la clase Persona que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param nombre Nombre de la persona.
     * @param direccion Dirección de la persona.
     * @param telefono Teléfono de la persona.
     */
    public Persona(String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
    }

    /**
     * Constructor de la clase Persona que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param nombre Nombre de la persona.
     * @param direccion Dirección de la persona.
     * @param telefono Teléfono de la persona.
     * @param cliente Cliente asociado a la persona.
     */
    public Persona(String nombre, String direccion, String telefono, Cliente cliente) {
        super(nombre, direccion, telefono);
        this.cliente = cliente;
    }

    /**
     * Constructor de la clase Persona que recibe parámetros para inicializar
     * sus atributos.
     *
     * @param _id Identificador único de la persona.
     * @param nombre Nombre de la persona.
     * @param direccion Dirección de la persona.
     * @param telefono Teléfono de la persona.
     * @param cliente Cliente asociado a la persona.
     */
    public Persona(ObjectId _id, String nombre, String direccion, String telefono, Cliente cliente) {
        super(_id, nombre, direccion, telefono);
        this.cliente = cliente;
    }

    /**
     * Constructor de la clase Persona que recibe un cliente como parámetro.
     *
     * @param cliente Cliente asociado a la persona.
     */
    public Persona(Cliente cliente) {

        this.cliente = cliente;
    }

    /**
     * Obtiene el cliente asociado a la persona.
     *
     * @return Cliente asociado a la persona.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la persona.
     *
     * @param cliente Nuevo cliente asociado a la persona.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
