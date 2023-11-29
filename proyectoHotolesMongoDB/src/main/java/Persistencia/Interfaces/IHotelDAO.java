/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Hotel;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;
/**
 *
 * @author marcos_zr
 */
public interface IHotelDAO {
    
    public Hotel insertar(Hotel insertarHotel) throws PersistenciaException;
    public Hotel actualizar(Hotel actualizarHotel) throws PersistenciaException;
    public Hotel eliminar(Hotel eliminarHotel) throws PersistenciaException;
    public Hotel buscar(ObjectId id) throws PersistenciaException;
}
