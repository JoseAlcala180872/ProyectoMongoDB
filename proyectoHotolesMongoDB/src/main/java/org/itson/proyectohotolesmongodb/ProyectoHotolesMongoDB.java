/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.proyectohotolesmongodb;

import Persistencia.Conexion.Conexion;
import Persistencia.DAO.HotelDAO;


/**
 *
 * @author José Carlos Alcalá Ruíz 180872
 */
public class ProyectoHotolesMongoDB {

    public static void main(String[] args) {
        HotelDAO hotel = new HotelDAO();
        hotel.insertar();
    }
}
