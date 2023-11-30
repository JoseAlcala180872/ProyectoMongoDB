/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.proyectohotolesmongodb;

import Persistencia.Conexion.Conexion;
import Persistencia.DAO.*;
import Excepciones.PersistenciaException;
import Dominio.*;
import Persistencia.Interfaces.*;
import org.bson.types.ObjectId;


/**
 *
 * @author José Carlos Alcalá Ruíz 180872
 */
public class ProyectoHotolesMongoDB {

    public static void main(String[] args) throws PersistenciaException {
        IHotelDAO hotelDAO = new HotelDAO();
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        IHabitacionDAO habitacionDAO = new HabitacionDAO();
        
        
        
    }
}
