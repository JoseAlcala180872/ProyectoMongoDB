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
    
    private String _id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String añoConstruccion;
    private Categoria categoria;
            
    /**
     * 
     */       
    public Hotel(){
       
    }

    /**
     *
     * @param _id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param añoConstruccion
     * @param categoria 
     */
    public Hotel(String _id, String nombre, String direccion, String telefono, String añoConstruccion, Categoria categoria) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añoConstruccion = añoConstruccion;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
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

    public String getAñoConstruccion() {
        return añoConstruccion;
    }

    public void setAñoConstruccion(String añoConstruccion) {
        this.añoConstruccion = añoConstruccion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
