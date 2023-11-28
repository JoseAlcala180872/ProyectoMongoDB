/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TADEO
 */
public class Conexion {

    private static MongoClient mongoClient;
    private static MongoDatabase baseDatos;
    private static Conexion conexion;

    public Conexion() {
        mongoClient = new MongoClient("localhost", 27017);
        baseDatos = mongoClient.getDatabase("hoteles");
    }

    public MongoClient crearConexion() {
        MongoClient mongo = null;
        String servidor = "localhost";
        Integer puerto = 27017;

        try {
            mongo = new MongoClient(servidor, puerto);
            List<String> nombrebd = mongo.getDatabaseNames();
            JOptionPane.showMessageDialog(null, "Se conecto, las bases son: " + nombrebd.toString());
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "no se conecto: " + e.toString());
        }
        return mongo;
    }

    public static MongoDatabase getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return baseDatos;
    }
}
