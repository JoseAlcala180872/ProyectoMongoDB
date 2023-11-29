/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public class AgenciaDeViajes extends Cliente{
    
    private String personaReservacion;

    public AgenciaDeViajes(String personaReservacion, String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
        this.personaReservacion = personaReservacion;
    }

    public String getPersonaReservacion() {
        return personaReservacion;
    }

    public void setPersonaReservacion(String personaReservacion) {
        this.personaReservacion = personaReservacion;
    }
    
    
}
