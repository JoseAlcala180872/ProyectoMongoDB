/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Persistencia.Conexion.Conexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author TADEO
 */
public class HotelDAO {
    MongoDatabase baseDatos;
    MongoCollection<Document> coleccion;

    public HotelDAO(){
        this.baseDatos = Conexion.getConexion();
        this.coleccion = baseDatos.getCollection("hotel");
    }

    public void insertar(){
        Document hotel = new Document();

        hotel.append("nombre", "")
                .append("direccion", "mamamam")
                .append("telefono", "asdf")
                .append("añoConstruccion", 1234);

        coleccion.insertOne(hotel);
    }
}
