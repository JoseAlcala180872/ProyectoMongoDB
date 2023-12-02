/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;
import Dominio.Habitacion;
import Dominio.Hotel;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public interface IHabitacionDAO {
    
    public Habitacion insertar(Habitacion insertarhabitacion) throws PersistenciaException;
    public Habitacion actualizar(Habitacion actualizarhabitacion) throws PersistenciaException;
    public Habitacion eliminar(Habitacion eliminarhabitacion) throws PersistenciaException;
    public Habitacion buscar(ObjectId idCategoria) throws PersistenciaException;
    public Habitacion buscar(int numeroHabitacion) throws PersistenciaException;
    public List<Habitacion> obtenerTodasLasHabitacionesPorHotel(Hotel hotelSeleccionado) throws PersistenciaException;
}
