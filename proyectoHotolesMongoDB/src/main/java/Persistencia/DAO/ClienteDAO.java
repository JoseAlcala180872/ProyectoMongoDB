/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;
import Dominio.Cliente;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Persistencia.Interfaces.IClienteDAO;
import Excepciones.PersistenciaException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public class ClienteDAO implements IClienteDAO{

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;
    
    public ClienteDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("cliente");
    }
    
    /**
     * 
     * @param insertarCliente
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cliente insertar(Cliente insertarCliente) throws PersistenciaException {
        

        Document clienteDocument = new Document();
        try {
            clienteDocument.append("nombre", insertarCliente.getNombre())
                    .append("direccion", insertarCliente.getDireccion())
                    .append("telefono", insertarCliente.getTelefono());

            coleccion.insertOne(clienteDocument);
            
            // Obtener el ObjectId generado por MongoDB y asignarlo al Cliente
            ObjectId objectId = clienteDocument.getObjectId("_id");
            insertarCliente.setId(objectId);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar cliente:" + e.getMessage());
        }
        
        return insertarCliente;
    }

    /**
     * 
     * @param actualizarCliente
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cliente actualizar(Cliente actualizarCliente) throws PersistenciaException {
        Bson filtro = Filters.eq("_id", actualizarCliente.getId());

        try {
            Document clienteDocument = new Document()
                    .append("nombre", actualizarCliente.getNombre())
                    .append("direccion", actualizarCliente.getDireccion())
                    .append("telefono", actualizarCliente.getTelefono());

            Document actualizacion = new Document("$set", clienteDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);

        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar cliente:" + e.getMessage());
        }

        return actualizarCliente;
    }

    /**
     * 
     * @param eliminarCliente
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cliente eliminar(Cliente eliminarCliente) throws PersistenciaException {
        Document filtro = new Document("_id", eliminarCliente.getId());

        try {
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar cliente:" + e.getMessage());
        }

        return eliminarCliente;
    }


    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cliente buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);
        
        try{
            Document cliente = coleccion.find(filtro).first();
           
            return new Cliente(
                    cliente.getObjectId("_id"),
                    cliente.getString("nombre"),
                    cliente.getString("direccion"),
                    cliente.getString("telefono")
            );
        }catch (Exception e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @param nombre
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cliente buscar(String  nombre) throws PersistenciaException {
        Document filtro = new Document("nombre", nombre);
        
        try{
            Document cliente = coleccion.find(filtro).first();
            
            return new Cliente(
                    cliente.getObjectId("_id"),
                    cliente.getString("nombre"),
                    cliente.getString("direccion"),
                    cliente.getString("telefono")
            );
        }catch (Exception e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
    }
    
}
