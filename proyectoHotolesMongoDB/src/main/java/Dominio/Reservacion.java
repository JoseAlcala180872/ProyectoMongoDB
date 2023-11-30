/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import org.bson.types.ObjectId;
import java.util.Date;
/**
 *
 * @author 
 */
public class Reservacion {
    
    private int _id;
    private Cliente cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private Hotel categoriaHotel;
    private  Date periodoEstancia; //Tipo de dato temporal, tiene que ser tipo Periodo. Será una clase que se creará
    private Habitacion claseHabitacion;

    public Reservacion(){
        
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
    public Reservacion(int _id, Cliente cliente, String nombre, String direccion, String telefono, Hotel categoriaHotel, Date periodoEstancia, Habitacion claseHabitacion) {
        this._id = _id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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
    public Reservacion(Cliente cliente, String nombre, String direccion, String telefono, Hotel categoriaHotel, Date periodoEstancia, Habitacion claseHabitacion) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoriaHotel = categoriaHotel;
        this.periodoEstancia = periodoEstancia;
        this.claseHabitacion = claseHabitacion;
    }

    
    
    
}
