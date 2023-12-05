/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Dominio.Categoria;
import Persistencia.Interfaces.ICategoriaDAO;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

/**
 * Implementación de la interfaz ICategoriaDAO que proporciona métodos para
 * realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades
 * de tipo Categoria en la base de datos.
 */
public class CategoriaDAO implements ICategoriaDAO {

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public CategoriaDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("categoria");
    }

    /**
     * {@inheritDoc} Inserta una nueva categoría en la base de datos.
     *
     * @param insertarCategoria La categoría a insertar.
     * @return La categoría insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    @Override
    public Categoria insertar(Categoria insertarCategoria) throws PersistenciaException {
        Document categoriaDocument = new Document();

        try {
            categoriaDocument.append("estrellas", insertarCategoria.getEstrellas())
                    .append("iva", insertarCategoria.getIva());

            coleccion.insertOne(categoriaDocument);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar categoria:" + e.getMessage());
        }

        return insertarCategoria;

    }

    /**
     * {@inheritDoc} Actualiza una categoría existente en la base de datos.
     *
     * @param actualizarCategoria La categoría con los datos actualizados.
     * @return La categoría actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public Categoria actualizar(Categoria actualizarCategoria) throws PersistenciaException {
        Bson filtro = Filters.eq("_id", actualizarCategoria.getId());

        try {
            Document categoriaDocument = new Document()
                    .append("estrellas", actualizarCategoria.getEstrellas())
                    .append("iva", actualizarCategoria.getIva());

            Document actualizacion = new Document("$set", categoriaDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);

        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar categoria:" + e.getMessage());
        }

        return actualizarCategoria;

    }

    /**
     * {@inheritDoc} Elimina una categoría de la base de datos.
     *
     * @param eliminarCategoria La categoría a eliminar.
     * @return La categoría eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public Categoria eliminar(Categoria eliminarCategoria) throws PersistenciaException {

        try {
            Document filtro = new Document("_id", eliminarCategoria.getId());
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar categoria:" + e.getMessage());
        }

        return eliminarCategoria;
    }

    /**
     * {@inheritDoc} Busca una categoría por su identificador único (ID) en la
     * base de datos.
     *
     * @param id El ID de la categoría a buscar.
     * @return La categoría encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Categoria buscar(ObjectId id) throws PersistenciaException {

        Document filtro = new Document("_id", id);

        try {
            Document categoria = coleccion.find(filtro).first();

            return new Categoria(
                    categoria.getObjectId("_id"),
                    categoria.getInteger("estrellas"),
                    categoria.getDouble("iva")
            );
        } catch (Exception e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;

    }

    /**
     * {@inheritDoc} Busca una categoría por el número de estrellas en la base
     * de datos.
     *
     * @param estrellas El número de estrellas de la categoría a buscar.
     * @return La categoría encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Categoria buscar(int estrellas) throws PersistenciaException {

        Document filtro = new Document("estrellas", estrellas);

        try {
            Document categoria = coleccion.find(filtro).first();

            return new Categoria(
                    categoria.getObjectId("_id"),
                    categoria.getInteger("estrellas"),
                    categoria.getDouble("iva")
            );
        } catch (Exception e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;

    }

}
