/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Reservacion;
import Persistencia.Interfaces.IReservacionDAO;
import Excepciones.BOException;
import Excepciones.PersistenciaException;
import Persistencia.DAO.ReservacionDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la lógica de negocios para la entidad 'Reservacion'.
 */
public class ReservacionBO {

    IReservacionDAO reservacionDAO;

    /**
     * Constructor de la clase 'ReservacionBO'. Inicializa la instancia del DAO
     * para las reservaciones.
     */
    public ReservacionBO() {
        this.reservacionDAO = new ReservacionDAO();
    }

    /**
     * Inserta una nueva reservación en la base de datos.
     *
     * @param reservacionInsertar Reservación a insertar.
     * @return Reservación insertada.
     * @throws BOException Si ocurre un error durante la operación.
     */
    public Reservacion insertar(Reservacion reservacionInsertar) throws BOException {

        try {
            return this.reservacionDAO.insertar(reservacionInsertar);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage(), e);
        }

    }
}
