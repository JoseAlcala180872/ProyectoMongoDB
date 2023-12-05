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
 *
 * @author 
 */
public class AgenciaDeViajesDAO implements IAgenciaDeViajesDAO{

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;
    
    public AgenciaDeViajesDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("agenciaDeViajes");
    }
    /**
     * 
     * @param insertarAgenciaDeViajes
     * @return
     * @throws PersistenciaException 
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
     * 
     * @param actualizarAgenciaDeViajes
     * @return
     * @throws PersistenciaException 
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
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
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
