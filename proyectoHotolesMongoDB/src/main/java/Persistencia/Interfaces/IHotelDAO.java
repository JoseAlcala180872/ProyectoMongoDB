/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Hotel;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public interface IHotelDAO {
    
    public Hotel insertar(Hotel insertarHotel) throws PersistenciaException;
    public Hotel actualizar(Hotel actualizarHotel) throws PersistenciaException;
    public Hotel eliminar(Hotel eliminarHotel) throws PersistenciaException;
    public List<Hotel> obtenerTodosLosHoteles() throws PersistenciaException;
    public Hotel buscar(ObjectId id) throws PersistenciaException;
    public Hotel buscar(String nombre) throws PersistenciaException;
}
