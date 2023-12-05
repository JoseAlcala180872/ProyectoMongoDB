/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Cliente;
import Dominio.AgenciaDeViajes;
import Excepciones.PersistenciaException;
import Persistencia.Conexion.Conexion;
import Persistencia.Interfaces.IAgenciaDeViajesDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de la interfaz IAgenciaDeViajesDAO que proporciona
 * métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre entidades de tipo AgenciaDeViajes en la base de datos.
 */
public class AgenciaDeViajesDAO implements IAgenciaDeViajesDAO {

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public AgenciaDeViajesDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("agenciaDeViajes");
    }

    /**
     * Inserta una nueva Agencia de Viajes en la base de datos.
     *
     * @param insertarAgenciaDeViajes La Agencia de Viajes a insertar.
     * @return La Agencia de Viajes insertada.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public AgenciaDeViajes insertar(AgenciaDeViajes insertarAgenciaDeViajes) throws PersistenciaException {

        Document agenciaDocument = new Document();
        try {
            agenciaDocument.append("personaReservacion", insertarAgenciaDeViajes.getPersonaReservacion())
                    .append("_idCliente", insertarAgenciaDeViajes.getCliente().getId());

            coleccion.insertOne(agenciaDocument);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar Agencia:" + e.getMessage());
        }

        return insertarAgenciaDeViajes;
    }

    /**
     * Actualiza una Agencia de Viajes existente en la base de datos.
     *
     * @param actualizarAgenciaDeViajes La Agencia de Viajes con los datos
     * actualizados.
     * @return La Agencia de Viajes actualizada.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public AgenciaDeViajes actualizar(AgenciaDeViajes actualizarAgenciaDeViajes) throws PersistenciaException {
        Bson filtro = Filters.eq("_id", actualizarAgenciaDeViajes.getId());

        try {
            Document hotelDocument = new Document()
                    .append("personaReservacion", actualizarAgenciaDeViajes.getPersonaReservacion());

            Document actualizacion = new Document("$set", hotelDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);

        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar hotel:" + e.getMessage());
        }

        return actualizarAgenciaDeViajes;
    }

    /**
     * Elimina una Agencia de Viajes de la base de datos.
     *
     * @param eliminarAgenciaDeViajes La Agencia de Viajes a eliminar.
     * @return La Agencia de Viajes eliminada.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public AgenciaDeViajes eliminar(AgenciaDeViajes eliminarAgenciaDeViajes) throws PersistenciaException {
        Document filtro = new Document("_id", eliminarAgenciaDeViajes.getId());

        try {
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar agencia:" + e.getMessage());
        }

        return eliminarAgenciaDeViajes;
    }

    /**
     * Busca una Agencia de Viajes por su identificador único.
     *
     * @param id El identificador único de la Agencia de Viajes.
     * @return La Agencia de Viajes encontrada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public AgenciaDeViajes buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);

        try {
            Document agencia = coleccion.find(filtro).first();

            ObjectId clienteId = agencia.getObjectId("_idCliente");

            // Buscamos la categoría correspondiente en su respectiva colección
            ClienteDAO cDAO = new ClienteDAO();
            Cliente cliente = cDAO.buscar(clienteId);

            return new AgenciaDeViajes(
                    agencia.getObjectId("_id"),
                    agencia.getString("personaReservacion"),
                    cliente
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }

    /**
     * Busca una Agencia de Viajes por el identificador de su cliente asociado.
     *
     * @param idCliente El identificador del cliente asociado a la Agencia de
     * Viajes.
     * @return La Agencia de Viajes encontrada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public AgenciaDeViajes buscarPorCliente(ObjectId idCliente) throws PersistenciaException {
        Document filtro = new Document("_idCliente", idCliente);

        try {
            Document agencia = coleccion.find(filtro).first();

            ObjectId clienteId = agencia.getObjectId("_idCliente");

            // Buscamos la categoría correspondiente en su respectiva colección
            ClienteDAO cDAO = new ClienteDAO();
            Cliente cliente = cDAO.buscar(clienteId);

            return new AgenciaDeViajes(
                    agencia.getObjectId("_id"),
                    agencia.getString("personaReservacion"),
                    cliente
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }

}
