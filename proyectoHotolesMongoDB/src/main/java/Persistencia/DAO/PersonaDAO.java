/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;
import Dominio.Cliente;
import Dominio.Persona;
import Excepciones.PersistenciaException;
import Persistencia.Conexion.Conexion;
import Persistencia.Interfaces.IPersonaDAO;
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
public class PersonaDAO implements IPersonaDAO{

    
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;
    
    public PersonaDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("persona");
    }
    
    /**
     * 
     * @param insertarPersona
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Persona insertar(Persona insertarPersona) throws PersistenciaException {
        
        Document personaDocument = new Document();
        try {
            personaDocument.append("_idCliente", insertarPersona.getCliente().getId());

            coleccion.insertOne(personaDocument);
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar persona:" + e.getMessage());
        }
        
        return insertarPersona;
    }     

    /**
     * 
     * @param eliminarPersona
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Persona eliminar(Persona eliminarPersona) throws PersistenciaException {
        Document filtro = new Document("_id", eliminarPersona.getId());

        try {
            coleccion.deleteOne(filtro);
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar Persona:" + e.getMessage());
        }

        return eliminarPersona;
    }

    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Persona buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);
        
        try {
            Document persona = coleccion.find(filtro).first();

            ObjectId clienteId = persona.getObjectId("_idCliente");

            // Buscamos la categoría correspondiente en su respectiva colección
            ClienteDAO cDAO = new ClienteDAO();
            Cliente cliente = cDAO.buscar(clienteId);
            
            return new Persona(
                    persona.getObjectId("_id"),
                    cliente
            );
        } catch (PersistenciaException e) {
            System.out.println("ocurrio un error en:" + e.getMessage());
        }

        return null;
    }
    
}
