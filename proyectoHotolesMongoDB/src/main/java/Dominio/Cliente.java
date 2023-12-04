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
    private int idSistema;
    private String nombre;
    private String direccion;
    private String telefono;
//    private String personaReservacion;

    public Cliente(){
        
    }
    
    /**
     * 
     * @param _id 
     */
    public Cliente(ObjectId _id){
        this._id = _id;
    }
    /**
     * 
     * @param _id
     * @param idSistema
     * @param nombre
     * @param direccion
     * @param telefono 
     */
    public Cliente(ObjectId _id,int idSistema, String nombre, String direccion, String telefono) {
        this._id = _id;
        this.idSistema = idSistema;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    /**
     * 
     * @param _id
     * @param nombre
     * @param direccion
     * @param telefono 
     */
    public Cliente(ObjectId _id,String nombre, String direccion, String telefono){
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    /**
     * 
     * @param nombre
     * @param direccion
     * @param telefono 
     */
    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
//    
//    public Cliente(String nombre, String direccion, String telefono) {
//        this.nombre = nombre;
//        this.direccion = direccion;
//        this.telefono = telefono;
//        
//    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
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

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

//    public String getPersonaReservacion() {
//        return personaReservacion;
//    }
//
//    public void setPersonaReservacion(String personaReservacion) {
//        this.personaReservacion = personaReservacion;
//    }
    
    
    
}
