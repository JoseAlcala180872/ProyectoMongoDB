/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Categoria;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades de tipo Categoria en la base de datos.
 */
public interface ICategoriaDAO {

    /**
     * Inserta una nueva categoría en la base de datos.
     *
     * @param insertarCategoria La categoría a insertar.
     * @return La categoría insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public Categoria insertar(Categoria insertarCategoria) throws PersistenciaException;

    /**
     * Actualiza una categoría existente en la base de datos.
     *
     * @param actualizarCategoria La categoría con los datos actualizados.
     * @return La categoría actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public Categoria actualizar(Categoria actualizarCategoria) throws PersistenciaException;

    /**
     * Elimina una categoría de la base de datos.
     *
     * @param eliminarCategoria La categoría a eliminar.
     * @return La categoría eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public Categoria eliminar(Categoria eliminarCategoria) throws PersistenciaException;

    /**
     * Busca una categoría por su ID en la base de datos.
     *
     * @param idCategoria El ID de la categoría a buscar.
     * @return La categoría encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Categoria buscar(ObjectId idCategoria) throws PersistenciaException;

    /**
     * Busca una categoría por el número de estrellas en la base de datos.
     *
     * @param estrellas El número de estrellas de la categoría a buscar.
     * @return La categoría encontrada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Categoria buscar(int estrellas) throws PersistenciaException;
}
