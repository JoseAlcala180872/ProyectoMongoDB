/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectohotolesmongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Jorge Luis
 */
public class Conexion {
    public MongoClient crearConexion(){
        MongoClient mongo = null;
        String servidor = "localhost";
        Integer puerto = 27017;
        try{
            mongo = new MongoClient(servidor, puerto);
            List<String> NombreBaseDatos = mongo.getDatabaseNames();
            JOptionPane.showMessageDialog(null,"Se conectó correctamente a MongoDB, Las BD son: "+NombreBaseDatos.toString());
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null,"Error de conexión con MongoDB, error: "+e.toString());
        }
        return mongo;
    }
}
