/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;
import Dominio.Reservacion;
import Dominio.Hotel;
import Dominio.Cliente;
import Dominio.Habitacion;
import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Persistencia.Interfaces.IReservacionDAO;
import Excepciones.PersistenciaException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author 
 */
public class ReservacionDAO implements IReservacionDAO{
    
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public ReservacionDAO() {
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("reservacion");
    }

    /**
     * 
     * @param insertarReservacion
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Reservacion insertar(Reservacion insertarReservacion) throws PersistenciaException {
        
         Document reservacionDocument = new Document();
        try {
            reservacionDocument.append("tarifa", insertarReservacion.getTarifa())
                    .append("_idCliente", insertarReservacion.getCliente().getId())
                    .append("_idHotel", insertarReservacion.getCategoriaHotel().getId())
                    .append("_idHabitacion", insertarReservacion.getClaseHabitacion().getId())
                    .append("periodoEstancia", insertarReservacion.getPeriodoEstancia());

            coleccion.insertOne(reservacionDocument);
            
            ObjectId objectId = reservacionDocument.getObjectId("_id");
            insertarReservacion.setId(objectId);
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar hotel:" + e.getMessage());
        }

        return insertarReservacion;
    }
    
}
