/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Hotel;
import Dominio.Categoria;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Persistencia.Interfaces.IHotelDAO;
import Excepciones.PersistenciaException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de la interfaz IHotelDAO que proporciona métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades de tipo
 * Hotel en la base de datos.
 */
public class HotelDAO implements IHotelDAO {

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    /**
     * Constructor de la clase que inicializa la conexión a la base de datos y
     * obtiene la colección "hotel".
     */
    public HotelDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("hotel");
    }

    /**
     * {@inheritDoc} Inserta un nuevo hotel en la base de datos.
     *
     * @param insertarHotel El hotel a insertar.
     * @return El hotel insertado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    @Override
    public Hotel insertar(Hotel insertarHotel) throws PersistenciaException {

        Document hotelDocument = new Document();
        try {
            hotelDocument.append("nombre", insertarHotel.getNombre())
                    .append("direccion", insertarHotel.getDireccion())
                    .append("telefono", insertarHotel.getTelefono())
                    .append("añoConstruccion", insertarHotel.getAñoConstruccion())
                    .append("_idCategoria", insertarHotel.getCategoria().getId());

            coleccion.insertOne(hotelDocument);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar hotel:" + e.getMessage());
        }

        return insertarHotel;
    }

    /**
     * {@inheritDoc} Actualiza un hotel existente en la base de datos.
     *
     * @param actualizarHotel El hotel con los datos actualizados.
     * @return El hotel actualizado.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public Hotel actualizar(Hotel actualizarHotel) throws PersistenciaException {
        Bson filtro = Filters.eq("_id", actualizarHotel.getId());

        try {
            Document hotelDocument = new Document()
                    .append("nombre", actualizarHotel.getNombre())
                    .append("direccion", actualizarHotel.getDireccion())
                    .append("telefono", actualizarHotel.getTelefono())
                    .append("añoConstruccion", actualizarHotel.getAñoConstruccion())
                    .append("_idCategoria", actualizarHotel.getCategoria().getId());

            Document actualizacion = new Document("$set", hotelDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);

        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar hotel:" + e.getMessage());
        }

        return actualizarHotel;
    }

    /**
     * {@inheritDoc} Elimina un hotel de la base de datos.
     *
     * @param eliminarHotel El hotel a eliminar.
     * @return El hotel eliminado.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public Hotel eliminar(Hotel eliminarHotel) throws PersistenciaException {
        Document filtro = new Document("_id", eliminarHotel.getId());

        try {
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar hotel:" + e.getMessage());
        }

        return eliminarHotel;
    }

    /**
     * {@inheritDoc} Busca un hotel por su identificador único (ID) en la base
     * de datos.
     *
     * @param id El ID del hotel a buscar.
     * @return El hotel encontrado o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Hotel buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);

        try {
            Document hotel = coleccion.find(filtro).first();

            ObjectId categoriaId = hotel.getObjectId("_idCategoria");

            // Buscamos la categoría correspondiente en su respectiva colección
            CategoriaDAO cDAO = new CategoriaDAO();
            Categoria categoria = cDAO.buscar(categoriaId);

            return new Hotel(
                    hotel.getObjectId("_id"),
                    hotel.getString("nombre"),
                    hotel.getString("direccion"),
                    hotel.getString("telefono"),
                    hotel.getString("añoConstruccion"),
                    categoria
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }

    /**
     * {@inheritDoc} Busca un hotel por su nombre en la base de datos.
     *
     * @param nombre El nombre del hotel a buscar.
     * @return El hotel encontrado o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public List<Hotel> obtenerTodosLosHoteles() throws PersistenciaException {
        List<Hotel> hoteles = new ArrayList<>();

        try {
            FindIterable<Document> iterable = coleccion.find();
            for (Document document : iterable) {
                CategoriaDAO cDAO = new CategoriaDAO();

                ObjectId categoriaId = null;
                Categoria categoria = null;

                // Verificar si "_idCategoria" está presente y no es nulo
                if (document.containsKey("_idCategoria") && document.get("_idCategoria") != null) {
                    categoriaId = document.getObjectId("_idCategoria");
                    // Verificar si la categoría es nula después de obtener el ID
                    categoria = cDAO.buscar(categoriaId);
                }

                Hotel hotel = new Hotel(
                        document.getObjectId("_id"),
                        document.getString("nombre"),
                        document.getString("direccion"),
                        document.getString("telefono"),
                        document.getString("añoConstruccion"),
                        categoria
                );

                hoteles.add(hotel);
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener todos los hoteles:" + e.getMessage());
        }

        return hoteles;
    }

    /**
     * Obtiene todos los hoteles almacenados en la base de datos.
     *
     * @return Lista de todos los hoteles.
     * @throws PersistenciaException Si ocurre un error al obtener los hoteles.
     */
    @Override
    public Hotel buscar(String nombre) throws PersistenciaException {
        Document filtro = new Document("nombre", nombre);

        try {
            Document hotel = coleccion.find(filtro).first();

            ObjectId categoriaId = hotel.getObjectId("_idCategoria");

            // Buscamos la categoría correspondiente en su respectiva colección
            CategoriaDAO cDAO = new CategoriaDAO();
            Categoria categoria = cDAO.buscar(categoriaId);

            return new Hotel(
                    hotel.getObjectId("_id"),
                    hotel.getString("nombre"),
                    hotel.getString("direccion"),
                    hotel.getString("telefono"),
                    hotel.getString("añoConstruccion"),
                    categoria
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }

}
