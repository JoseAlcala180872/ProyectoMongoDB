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
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
/**
 *
 * @author 
 */
public class HabitacionDAO implements IHabitacionDAO{
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public HabitacionDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("habitacion");
    }

    
    /**
     * 
     * @param insertarHabitacion
     * @return 
     * @throws Excepciones.PersistenciaException 
     */
    @Override
    public Habitacion insertar(Habitacion insertarHabitacion) throws PersistenciaException{
        
        Document habitacionDocument = new Document();
        try{
            habitacionDocument.append("tipoHabitacion", insertarHabitacion.getTipoHabitacion())
                .append("numeroHabitacion", insertarHabitacion.getNumeroHabitacion())
                .append("tarifa", insertarHabitacion.getTarifa())
                .append("_idHotel", insertarHabitacion.getHotel().getId());

            coleccion.insertOne(habitacionDocument);
        }catch(Exception e){
            throw new PersistenciaException("Error al insertar habitación:" + e.getMessage());
        }
        
        return insertarHabitacion;
    }

    /**
     * 
     * @param actualizarHabitacion
     * @return 
     * @throws Excepciones.PersistenciaException 
     */
    @Override
    public Habitacion actualizar(Habitacion actualizarHabitacion) throws PersistenciaException{
        Bson filtro = Filters.eq("_id", actualizarHabitacion.getId());
        
        try{ 
            Document habitacionDocument = new Document()
                .append("tipoHabitacion", actualizarHabitacion.getTipoHabitacion())
                .append("numeroHabitacion", actualizarHabitacion.getNumeroHabitacion())
                .append("tarifa", actualizarHabitacion.getTarifa())
                .append("_idHotel", actualizarHabitacion.getHotel().getId());

            Document actualizacion = new Document("$set", habitacionDocument);
            UpdateResult updateOne = coleccion.updateOne(filtro, actualizacion);
            
        }catch (Exception e){
            throw new PersistenciaException("Error al actualizar habitacion:" + e.getMessage());
        }
        
        return actualizarHabitacion;
    }

    /**
     * 
     * @param eliminarHabitacion
     * @return 
     * @throws Excepciones.PersistenciaException
     */
    @Override
    public Habitacion eliminar(Habitacion eliminarHabitacion) throws PersistenciaException{
        Document filtro = new Document("_id", eliminarHabitacion.getId());
        
        try{
            coleccion.deleteOne(filtro);
        }catch(Exception e){
            throw new PersistenciaException("Error al eliminar habitacion:" + e.getMessage());
        }
        
        return eliminarHabitacion;
    }

    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Habitacion buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);
        
        try{
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
                    hotel
            );
        }catch (PersistenciaException e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 
     * @param numeroHabitacion
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Habitacion buscar(int numeroHabitacion) throws PersistenciaException{
        
        Document filtro = new Document("numeroHabitacion", numeroHabitacion);
        
        try{
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
                    hotel
            );
        }catch (PersistenciaException e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
        
    }
}
