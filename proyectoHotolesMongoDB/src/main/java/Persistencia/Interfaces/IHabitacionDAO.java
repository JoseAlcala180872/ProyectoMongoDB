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
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades de tipo Habitacion en la base de datos.
 */
public interface IHabitacionDAO {

    /**
     * Inserta una nueva habitación en la base de datos.
     *
     * @param insertarHabitacion La habitación a insertar.
     * @return La habitación insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public Habitacion insertar(Habitacion insertarhabitacion) throws PersistenciaException;

    /**
     * Actualiza una habitación existente en la base de datos.
     *
     * @param actualizarHabitacion La habitación con los datos actualizados.
     * @return La habitación actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public Habitacion actualizar(Habitacion actualizarhabitacion) throws PersistenciaException;

    /**
     * Elimina una habitación de la base de datos.
     *
     * @param eliminarHabitacion La habitación a eliminar.
     * @return La habitación eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public Habitacion eliminar(Habitacion eliminarhabitacion) throws PersistenciaException;

    /**
     * Busca una habitación por su ID en la base de datos.
     *
     * @param id El ID de la habitación a buscar.
     * @return La habitación encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Habitacion buscar(ObjectId idCategoria) throws PersistenciaException;

    /**
     * Busca una habitación por su número en la base de datos.
     *
     * @param numeroHabitacion El número de la habitación a buscar.
     * @return La habitación encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Habitacion buscar(int numeroHabitacion) throws PersistenciaException;

    /**
     * Obtiene todas las habitaciones asociadas a un hotel específico.
     *
     * @param hotelSeleccionado El hotel del cual se quieren obtener las
     * habitaciones.
     * @return Lista de habitaciones asociadas al hotel.
     * @throws PersistenciaException Si ocurre un error durante la obtención.
     */
    public List<Habitacion> obtenerTodasLasHabitacionesPorHotel(Hotel hotelSeleccionado) throws PersistenciaException;
}
