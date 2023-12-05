/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Hotel;
import Dominio.Habitacion;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Persistencia.Interfaces.IHabitacionDAO;
import Excepciones.PersistenciaException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de la interfaz IHabitacionDAO que proporciona métodos para
 * realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades
 * de tipo Habitacion en la base de datos.
 */
public class HabitacionDAO implements IHabitacionDAO {

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    /**
     * Constructor de la clase que inicializa la conexión a la base de datos y
     * obtiene la colección "habitacion".
     */
    public HabitacionDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("habitacion");
    }

    /**
     * {@inheritDoc} Inserta una nueva habitación en la base de datos.
     *
     * @param insertarHabitacion La habitación a insertar.
     * @return La habitación insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    @Override
    public Habitacion insertar(Habitacion insertarHabitacion) throws PersistenciaException {

        Document habitacionDocument = new Document();
        try {
            habitacionDocument.append("tipoHabitacion", insertarHabitacion.getTipoHabitacion())
                    .append("numeroHabitacion", insertarHabitacion.getNumeroHabitacion())
                    .append("tarifa", insertarHabitacion.getTarifa())
                    .append("_idHotel", insertarHabitacion.getHotel().getId())
                    .append("Asignado", insertarHabitacion.isIsAsignado());

            coleccion.insertOne(habitacionDocument);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar habitación:" + e.getMessage());
        }

        return insertarHabitacion;
    }

    /**
     * {@inheritDoc} Actualiza una habitación existente en la base de datos.
     *
     * @param actualizarHabitacion La habitación con los datos actualizados.
     * @return La habitación actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public Habitacion actualizar(Habitacion actualizarHabitacion) throws PersistenciaException {
        Bson filtro = Filters.eq("_id", actualizarHabitacion.getId());

        try {
            Document habitacionDocument = new Document()
                    .append("tipoHabitacion", actualizarHabitacion.getTipoHabitacion())
                    .append("numeroHabitacion", actualizarHabitacion.getNumeroHabitacion())
                    .append("tarifa", actualizarHabitacion.getTarifa())
                    .append("_idHotel", actualizarHabitacion.getHotel().getId())
                    .append("Asignado", actualizarHabitacion.isIsAsignado());

            Document actualizacion = new Document("$set", habitacionDocument);
            UpdateResult updateOne = coleccion.updateOne(filtro, actualizacion);

        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar habitacion:" + e.getMessage());
        }

        return actualizarHabitacion;
    }

    /**
     * {@inheritDoc} Elimina una habitación de la base de datos.
     *
     * @param eliminarHabitacion La habitación a eliminar.
     * @return La habitación eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public Habitacion eliminar(Habitacion eliminarHabitacion) throws PersistenciaException {
        Document filtro = new Document("_id", eliminarHabitacion.getId());

        try {
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar habitacion:" + e.getMessage());
        }

        return eliminarHabitacion;
    }

    /**
     * {@inheritDoc} Busca una habitación por su identificador único (ID) en la
     * base de datos.
     *
     * @param id El ID de la habitación a buscar.
     * @return La habitación encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Habitacion buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);

        try {
            Document habitacion = coleccion.find(filtro).first();

            ObjectId hotelId = habitacion.getObjectId("_idHotel");

            // Buscamos el hotel correspondiente en su respectiva colección
            HotelDAO hDAO = new HotelDAO();
            Hotel hotel = hDAO.buscar(hotelId);

            return new Habitacion(
                    habitacion.getObjectId("_id"),
                    habitacion.getString("tipoHabitacion"),
                    habitacion.getInteger("numeroHabitacion"),
                    habitacion.getDouble("tarifa"),
                    hotel,
                    habitacion.getBoolean("Asignado")
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }

    /**
     * {@inheritDoc} Busca una habitación por su número en la base de datos.
     *
     * @param numeroHabitacion El número de la habitación a buscar.
     * @return La habitación encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Habitacion buscar(int numeroHabitacion) throws PersistenciaException {

        Document filtro = new Document("numeroHabitacion", numeroHabitacion);

        try {
            Document habitacion = coleccion.find(filtro).first();

            ObjectId hotelId = habitacion.getObjectId("_idHotel");

            // Buscamos el hotel correspondiente en su respectiva colección
            HotelDAO hDAO = new HotelDAO();
            Hotel hotel = hDAO.buscar(hotelId);

            return new Habitacion(
                    habitacion.getObjectId("_id"),
                    habitacion.getString("tipoHabitacion"),
                    habitacion.getInteger("numeroHabitacion"),
                    habitacion.getDouble("tarifa"),
                    hotel,
                    habitacion.getBoolean("Asignado")
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;

    }

    /**
     * {@inheritDoc} Obtiene todas las habitaciones almacenadas en la base de
     * datos.
     *
     * @return Lista de todas las habitaciones.
     * @throws PersistenciaException Si ocurre un error al obtener las
     * habitaciones.
     */
    public List<Habitacion> obtenerTodasLasHabitaciones() throws PersistenciaException {
        List<Habitacion> habitaciones = new ArrayList<>();

        try {
            FindIterable<Document> iterable = coleccion.find();
            for (Document document : iterable) {
                HotelDAO hDAO = new HotelDAO();

                ObjectId hotelId = null;
                Hotel hotel = null;

                if (document.containsKey("_idHotel") && document.get("_idHotel") != null) {
                    hotelId = document.getObjectId("_idHotel");
                    hotel = hDAO.buscar(hotelId);
                }

                Habitacion habitacion = new Habitacion(
                        document.getString("tipoHabitacion"),
                        document.getInteger("numeroHabitacion"),
                        document.getDouble("tarifa"),
                        hotel,
                        document.getBoolean("Asignado")
                );

                habitaciones.add(habitacion);
            }

        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al obtener todas las habitaciones: " + e.getMessage());
        }
        return habitaciones;
    }

    /**
     * {@inheritDoc} Obtiene todas las habitaciones de un hotel específico
     * almacenadas en la base de datos.
     *
     * @param hotelSeleccionado El hotel para el cual se obtienen las
     * habitaciones.
     * @return Lista de habitaciones del hotel seleccionado.
     * @throws PersistenciaException Si ocurre un error al obtener las
     * habitaciones del hotel.
     */
    @Override
    public List<Habitacion> obtenerTodasLasHabitacionesPorHotel(Hotel hotelSeleccionado) throws PersistenciaException {
        List<Habitacion> habitaciones = new ArrayList<>();

        try {
            Bson filtro = Filters.eq("_idHotel", hotelSeleccionado.getId());
            FindIterable<Document> iterable = coleccion.find(filtro);
            for (Document document : iterable) {

                Habitacion habitacion = new Habitacion(
                        document.getObjectId(("_id")),
                        document.getString("tipoHabitacion"),
                        document.getInteger("numeroHabitacion"),
                        document.getDouble("tarifa"),
                        hotelSeleccionado,
                        document.getBoolean("Asignado")
                );

                habitaciones.add(habitacion);
            }

        } catch (Exception e) {
            System.out.println("error desconocido");
        }
        return habitaciones;
    }
}
