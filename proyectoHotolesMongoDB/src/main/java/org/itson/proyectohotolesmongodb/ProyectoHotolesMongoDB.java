/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.proyectohotolesmongodb;

import org.bson.types.ObjectId;
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

        Categoria categoria1 = new Categoria(5, 0.16);
        Categoria categoria2 = new Categoria(3, 0.16);
        Categoria categoria3 = new Categoria(1, 0.16);

        categoriaDAO.insertar(categoria1);
        categoriaDAO.insertar(categoria2);
        categoriaDAO.insertar(categoria3);

        Hotel hotel1 = new Hotel("Posada Deluexe", "Campestre 3151", "6441983990", "2003", categoria1);
        Hotel hotel2 = new Hotel("El viejo Jimmy", "El campanario", "6441983920", "1995", categoria2);
        Hotel hotel3 = new Hotel("La nana", "Pueblo Yaqui", "6441983900", "2021", categoria3);
        hotelDAO.insertar(hotel1);
        hotelDAO.insertar(hotel2);
        hotelDAO.insertar(hotel3);

    }
}
