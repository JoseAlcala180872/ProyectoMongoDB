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

    /**
     * Interfaz que define los métodos para realizar operaciones CRUD (Crear,
     * Leer, Actualizar, Eliminar) sobre entidades de tipo Hotel en la base de
     * datos.
     */
    public Hotel insertar(Hotel insertarHotel) throws PersistenciaException;

    /**
     * Actualiza un hotel existente en la base de datos.
     *
     * @param actualizarHotel El hotel con los datos actualizados.
     * @return El hotel actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualización.
     */
    public Hotel actualizar(Hotel actualizarHotel) throws PersistenciaException;

    /**
     * Elimina un hotel de la base de datos.
     *
     * @param eliminarHotel El hotel a eliminar.
     * @return El hotel eliminado.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public Hotel eliminar(Hotel eliminarHotel) throws PersistenciaException;

    /**
     * Obtiene todos los hoteles almacenados en la base de datos.
     *
     * @return Lista de hoteles.
     * @throws PersistenciaException Si ocurre un error durante la obtención.
     */
    public List<Hotel> obtenerTodosLosHoteles() throws PersistenciaException;

    /**
     * Busca un hotel por su ID en la base de datos.
     *
     * @param id El ID del hotel a buscar.
     * @return El hotel encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Hotel buscar(ObjectId id) throws PersistenciaException;

    /**
     * Busca un hotel por su nombre en la base de datos.
     *
     * @param nombre El nombre del hotel a buscar.
     * @return El hotel encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Hotel buscar(String nombre) throws PersistenciaException;
}
