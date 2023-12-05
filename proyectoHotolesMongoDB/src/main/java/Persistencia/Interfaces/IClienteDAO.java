/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Cliente;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades de tipo Cliente en la base de datos.
 */
public interface IClienteDAO {

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param insertarCliente El cliente a insertar.
     * @return El cliente insertado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public Cliente insertar(Cliente insertarCliente) throws PersistenciaException;

    /**
     * Actualiza un cliente existente en la base de datos.
     *
     * @param actualizarCliente El cliente con los datos actualizados.
     * @return El cliente actualizado.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public Cliente actualizar(Cliente actualizarCliente) throws PersistenciaException;

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param eliminarCliente El cliente a eliminar.
     * @return El cliente eliminado.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public Cliente eliminar(Cliente eliminarCliente) throws PersistenciaException;

    /**
     * Busca un cliente por su ID en la base de datos.
     *
     * @param id El ID del cliente a buscar.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Cliente buscar(ObjectId id) throws PersistenciaException;

    /**
     * Busca un cliente por su nombre en la base de datos.
     *
     * @param nombre El nombre del cliente a buscar.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Cliente buscar(String nombre) throws PersistenciaException;
}
