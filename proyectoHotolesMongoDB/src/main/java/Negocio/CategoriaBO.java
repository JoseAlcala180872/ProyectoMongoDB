/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Categoria;
import Persistencia.Interfaces.ICategoriaDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.CategoriaDAO;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'Categoria'.
 */
public class CategoriaBO {

    ICategoriaDAO categoriaDAO = new CategoriaDAO();

    /**
     * Constructor de la clase 'CategoriaBO'. Inicializa la instancia del DAO
     * para la categoría.
     */
    public CategoriaBO() {
    }

    /**
     * Inserta una nueva categoría en la base de datos.
     *
     * @param categoriaInsertar Categoría a insertar.
     * @return Categoría insertada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Categoria insertar(Categoria CategoriaInsertar) throws BOException {

        try {
            return categoriaDAO.insertar(CategoriaInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Actualiza la información de una categoría en la base de datos.
     *
     * @param categoriaActualizar Categoría con la información actualizada.
     * @return Categoría actualizada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Categoria actualizar(Categoria categoriaActualizar) throws BOException {

        try {
            return categoriaDAO.actualizar(categoriaActualizar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Elimina una categoría de la base de datos.
     *
     * @param categoriaEliminar Categoría a eliminar.
     * @return Categoría eliminada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Categoria eliminar(Categoria categoriaEliminar) throws BOException {

        try {
            return categoriaDAO.eliminar(categoriaEliminar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Busca una categoría por su identificador en la base de datos.
     *
     * @param idCategoria Identificador de la categoría.
     * @return Categoría encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Categoria buscar(ObjectId idCategoria) throws BOException {

        try {
            return categoriaDAO.buscar(idCategoria);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }

    /**
     * Busca una categoría por la cantidad de estrellas en la base de datos.
     *
     * @param estrellas Cantidad de estrellas de la categoría.
     * @return Categoría encontrada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Categoria buscar(int estrellas) throws BOException {

        try {
            return categoriaDAO.buscar(estrellas);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
