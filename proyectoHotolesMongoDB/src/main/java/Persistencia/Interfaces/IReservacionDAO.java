/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Reservacion;
import Excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define los métodos para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades de tipo Reservacion en la base de
 * datos.
 */
public interface IReservacionDAO {

    /**
     * Inserta una nueva reservación en la base de datos.
     *
     * @param insertarReservacion La reservación a insertar.
     * @return La reservación insertada.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    public Reservacion insertar(Reservacion insertarReservacion) throws PersistenciaException;
}
