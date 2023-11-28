/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Hotel;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Persistencia.Interfaces.IHotelDAO;
import Excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author TADEO
 */
public class HotelDAO implements IHotelDAO{
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public HotelDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("hotel");
    }

    
    /**
     * 
     * @param hotel 
     * @throws Excepciones.PersistenciaException 
     */
    @Override
    public void insertar(Hotel insertarHotel) throws PersistenciaException{
        
        Document hotelDocument = new Document();
        try{
            hotelDocument.append("nombre", insertarHotel.getNombre())
                .append("direccion", insertarHotel.getDireccion())
                .append("telefono", insertarHotel.getTelefono())
                .append("añoConstruccion", insertarHotel.getAñoConstruccion())
                .append("_id", insertarHotel.getCategoria().getId());

            coleccion.insertOne(hotelDocument);
        }catch(Exception e){
            
        }
        
        
    }

    /**
     * 
     * @param actualizarHotel
     */
    @Override
    public void actualizar(Hotel actualizarHotel) {
        Document filtro = new Document("_id", new ObjectId(actualizarHotel.getId()));
        
        try{ 
            Document hotelDocument = new Document()
                .append("nombre", actualizarHotel.getNombre())
                .append("direccion", actualizarHotel.getDireccion())
                .append("telefono", actualizarHotel.getTelefono())
                .append("añoConstruccion", actualizarHotel.getAñoConstruccion())
                .append("_id", actualizarHotel.getCategoria().getId());

            coleccion.replaceOne(filtro, hotelDocument);
        }catch (Exception e){
            
        }
    }

    /**
     * 
     * @param eliminarHotel
     */
    @Override
    public void eliminar(Hotel eliminarHotel) throws PersistenciaException{
        Document filtro = new Document("_id", new ObjectId(eliminarHotel.getId()));
        
        try{
            coleccion.deleteOne(filtro);
        }catch(Exception e){
            
        }
    }
}
