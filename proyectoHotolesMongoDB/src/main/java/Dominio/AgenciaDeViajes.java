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
public class AgenciaDeViajes extends Cliente{
    
    private String personaReservacion;
    private Cliente cliente;

    public AgenciaDeViajes(){
        
    }
    
    /**
     * 
     * @param _id
     * @param personaReservacion
     * @param cliente 
     */
    public AgenciaDeViajes(ObjectId _id, String personaReservacion, Cliente cliente){
        super(_id);
        this.personaReservacion = personaReservacion;
        this.cliente = cliente;
    }
    
    /**
     * 
     * @param personaReservacion
     * @param cliente 
     */
    public AgenciaDeViajes(String personaReservacion, Cliente cliente){
        
        this.personaReservacion = personaReservacion;
        this.cliente = cliente;
    }
    
    /**
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param personaReservacion
     * @param cliente 
     */
    public AgenciaDeViajes(String nombre, String direccion, String telefono, String personaReservacion, Cliente cliente) {
        super(nombre, direccion, telefono);
        this.personaReservacion = personaReservacion;
        this.cliente = cliente;
    }

    /**
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param cliente
     * @param personaReservacion 
     */
    public AgenciaDeViajes(String nombre, String direccion, String telefono,Cliente cliente, String personaReservacion) {
        super(nombre, direccion, telefono);
        this.cliente = cliente;
        this.personaReservacion = personaReservacion;
    }
     
    public String getPersonaReservacion() {
        return personaReservacion;
    }

    public void setPersonaReservacion(String personaReservacion) {
        this.personaReservacion = personaReservacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
