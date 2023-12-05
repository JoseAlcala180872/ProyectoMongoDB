/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.AgenciaDeViajes;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades de tipo AgenciaDeViajes en la base de
 * datos.
 */
public interface IAgenciaDeViajesDAO {

    /**
     * Inserta una nueva agencia de viajes en la base de datos.
     *
     * @param insertarAgenciaDeViajes La agencia de viajes a insertar.
     * @return La agencia de viajes insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public AgenciaDeViajes insertar(AgenciaDeViajes insertarAgenciaDeViajes) throws PersistenciaException;

    /**
     * Actualiza una agencia de viajes existente en la base de datos.
     *
     * @param actualizarAgenciaDeViajes La agencia de viajes con los datos
     * actualizados.
     * @return La agencia de viajes actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public AgenciaDeViajes actualizar(AgenciaDeViajes actualizarAgenciaDeViajes) throws PersistenciaException;

    /**
     * Elimina una agencia de viajes de la base de datos.
     *
     * @param eliminarAgenciaDeViajes La agencia de viajes a eliminar.
     * @return La agencia de viajes eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public AgenciaDeViajes eliminar(AgenciaDeViajes eliminarAgenciaDeViajes) throws PersistenciaException;

    /**
     * Busca una agencia de viajes por su ID en la base de datos.
     *
     * @param id El ID de la agencia de viajes a buscar.
     * @return La agencia de viajes encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public AgenciaDeViajes buscar(ObjectId id) throws PersistenciaException;

    /**
     * Busca una agencia de viajes por el ID de su cliente asociado en la base
     * de datos.
     *
     * @param idCliente El ID del cliente asociado a la agencia de viajes.
     * @return La agencia de viajes encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public AgenciaDeViajes buscarPorCliente(ObjectId idCliente) throws PersistenciaException;
}
