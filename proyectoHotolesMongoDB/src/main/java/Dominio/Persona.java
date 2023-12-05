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
public class Persona extends Cliente{
    
    private Cliente cliente;
    
    public Persona(){
        
    }

    public Persona(ObjectId _id, Cliente cliente){
        super(_id);
        this.cliente = cliente;
    }
    
    public Persona(String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
    }

    public Persona(String nombre, String direccion, String telefono, Cliente cliente) {
        super(nombre, direccion, telefono);
        this.cliente = cliente;
    }
    
    /**
     * 
     * @param _id
     * @param cliente
     * @param nombre
     * @param direccion
     * @param telefono 
     */
    public Persona(ObjectId _id, String nombre, String direccion, String telefono, Cliente cliente) {
        super(_id, nombre, direccion, telefono);
        this.cliente = cliente;
    }
    
    public Persona(Cliente cliente){
        
        this.cliente = cliente;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
