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
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
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
     * @param insertarHotel
     * @return 
     * @throws Excepciones.PersistenciaException 
     */
    @Override
    public Hotel insertar(Hotel insertarHotel) throws PersistenciaException{
        
        Document hotelDocument = new Document();
        try{
            hotelDocument.append("nombre", insertarHotel.getNombre())
                .append("direccion", insertarHotel.getDireccion())
                .append("telefono", insertarHotel.getTelefono())
                .append("añoConstruccion", insertarHotel.getAñoConstruccion())
                .append("_idCategoria", insertarHotel.getCategoria().getId());

            coleccion.insertOne(hotelDocument);
        }catch(Exception e){
            throw new PersistenciaException("Error al insertar hotel:" + e.getMessage());
        }
        
        return insertarHotel;
    }

    /**
     * 
     * @param actualizarHotel
     * @return 
     */
    @Override
    public Hotel actualizar(Hotel actualizarHotel) throws PersistenciaException{
        Bson filtro = Filters.eq("_id", actualizarHotel.getId());
        
        try{ 
            Document hotelDocument = new Document()
                .append("nombre", actualizarHotel.getNombre())
                .append("direccion", actualizarHotel.getDireccion())
                .append("telefono", actualizarHotel.getTelefono())
                .append("añoConstruccion", actualizarHotel.getAñoConstruccion())
                .append("_idCategoria", actualizarHotel.getCategoria().getId());

            Document actualizacion = new Document("$set", hotelDocument);
            UpdateResult updateResult = coleccion.updateOne(filtro, actualizacion);
            
        }catch (Exception e){
            throw new PersistenciaException("Error al actualizar hotel:" + e.getMessage());
        }
        
        return actualizarHotel;
    }

    /**
     * 
     * @param eliminarHotel
     * @return 
     * @throws Excepciones.PersistenciaException
     */
    @Override
    public Hotel eliminar(Hotel eliminarHotel) throws PersistenciaException{
        Document filtro = new Document("_id", eliminarHotel.getId());
        
        try{
            coleccion.deleteOne(filtro);
        }catch(Exception e){
            throw new PersistenciaException("Error al eliminar hotel:" + e.getMessage());
        }
        
        return eliminarHotel;
    }

    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Hotel buscar(ObjectId id) throws PersistenciaException {
        Document filtro = new Document("_id", id);
        
        try{
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
        }catch (PersistenciaException e){
            System.out.println("ocurrio un error en:"  + e.getMessage());
        }
        
        return null;
    }
}
