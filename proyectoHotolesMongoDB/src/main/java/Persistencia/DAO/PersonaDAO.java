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
 * Implementación de la interfaz IPersonaDAO que proporciona métodos para
 * realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades
 * de tipo Persona en la base de datos.
 */
public class PersonaDAO implements IPersonaDAO {

    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    /**
     * Constructor de la clase que inicializa la conexión a la base de datos y
     * obtiene la colección "persona".
     */
    public PersonaDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("persona");
    }

    /**
     * {@inheritDoc} Inserta una nueva persona en la base de datos.
     *
     * @param insertarPersona La persona a insertar.
     * @return La persona insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
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
     * {@inheritDoc} Elimina una persona de la base de datos.
     *
     * @param eliminarPersona La persona a eliminar.
     * @return La persona eliminada.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
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
     * {@inheritDoc} Busca una persona por su identificador único (ID) en la
     * base de datos.
     *
     * @param id El ID de la persona a buscar.
     * @return La persona encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
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
