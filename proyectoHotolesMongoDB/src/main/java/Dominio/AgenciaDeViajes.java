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
public class AgenciaDeViajes extends Cliente {

    private String personaReservacion;
    private Cliente cliente;

    /**
     * Constructor vacío de la clase AgenciaDeViajes. Se utiliza para crear
     * instancias de la clase sin proporcionar valores iniciales.
     */
    public AgenciaDeViajes() {

    }

    /**
     * Constructor de la clase AgenciaDeViajes que recibe parámetros para
     * inicializar sus atributos.
     *
     * @param _id Identificador único de la agencia.
     * @param personaReservacion Nombre de la persona encargada de las
     * reservaciones.
     * @param cliente Cliente asociado a la agencia.
     */
    public AgenciaDeViajes(ObjectId _id, String personaReservacion, Cliente cliente) {
        super(_id);
        this.personaReservacion = personaReservacion;
        this.cliente = cliente;
    }

    /**
     * Constructor de la clase AgenciaDeViajes que recibe parámetros para
     * inicializar sus atributos.
     *
     * @param personaReservacion Nombre de la persona encargada de las
     * reservaciones.
     * @param cliente Cliente asociado a la agencia.
     */
    public AgenciaDeViajes(String personaReservacion, Cliente cliente) {
        this.personaReservacion = personaReservacion;
        this.cliente = cliente;
    }

    /**
     * Constructor de la clase AgenciaDeViajes que recibe parámetros para
     * inicializar sus atributos.
     *
     * @param nombre Nombre de la agencia.
     * @param direccion Dirección de la agencia.
     * @param telefono Teléfono de la agencia.
     * @param cliente Cliente asociado a la agencia.
     * @param personaReservacion Nombre de la persona encargada de las
     * reservaciones.
     */
    public AgenciaDeViajes(String nombre, String direccion, String telefono, Cliente cliente, String personaReservacion) {
        super(nombre, direccion, telefono);
        this.cliente = cliente;
        this.personaReservacion = personaReservacion;
    }

    /**
     * Obtiene el nombre de la persona encargada de las reservaciones.
     *
     * @return Nombre de la persona encargada de las reservaciones.
     */
    public String getPersonaReservacion() {
        return personaReservacion;
    }

    /**
     * Establece el nombre de la persona encargada de las reservaciones.
     *
     * @param personaReservacion Nuevo nombre de la persona encargada de las
     * reservaciones.
     */
    public void setPersonaReservacion(String personaReservacion) {
        this.personaReservacion = personaReservacion;
    }

    /**
     * Obtiene el cliente asociado a la agencia.
     *
     * @return Cliente asociado a la agencia.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la agencia.
     *
     * @param cliente Nuevo cliente asociado a la agencia.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
